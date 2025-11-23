package database;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class DatabaseManager {
    private static final String DB_FOLDER = "database";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    static {
        File folder = new File(DB_FOLDER);
        if(!folder.exists()) folder.mkdir();
    }

    public static <T> void save(String fileName, List<T> data) {
        try(FileWriter writer = new FileWriter(DB_FOLDER + "/" + fileName)) {
            gson.toJson(data, writer);
        } catch(IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static <T> List<T> load(String fileName, Class<T> clazz) {
        File file = new File(DB_FOLDER + "/" + fileName);
        if (!file.exists()) return new ArrayList<>();

        try (FileReader reader = new FileReader(file)) {
            Type type = TypeToken.getParameterized(List.class, clazz).getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
public static <T> void add(String fileName, Class<T> clazz, T newData) {
    List<T> data = load(fileName, clazz);

    try {
        // ========== CASE 1: CUSTOMER / PEGAWAI (cek ID saja) ==========
        if (clazz.getSimpleName().equals("Customer") ||
            clazz.getSimpleName().equals("Pegawai")) {

            Field idField = clazz.getDeclaredField("id");
            idField.setAccessible(true);
            int newId = idField.getInt(newData);

            for (T obj : data) {
                int existingId = idField.getInt(obj);

                if (existingId == newId) {
                    System.out.println("GAGAL: ID " + newId + " sudah ada!");
                    return;
                }
            }
        }

        // ========== CASE 2: MENU (Makanan / Minuman → cek semua field) ==========
        else if (clazz.getSuperclass().getSimpleName().equals("MenuItem")) {

            for (T obj : data) {

                boolean isDuplicate = true;

                // Cek field dari superclass (nama, harga)
                for (Field field : clazz.getSuperclass().getDeclaredFields()) {
                    field.setAccessible(true);

                    Object newVal = field.get(newData);
                    Object oldVal = field.get(obj);

                    if (!Objects.equals(newVal, oldVal)) {
                        isDuplicate = false;
                        break;
                    }
                }

                // Cek field subclass (tingkatPedas, kategori / ukuran, suhu)
                if (isDuplicate) {
                    for (Field field : clazz.getDeclaredFields()) {
                        field.setAccessible(true);

                        Object newVal = field.get(newData);
                        Object oldVal = field.get(obj);

                        if (!Objects.equals(newVal, oldVal)) {
                            isDuplicate = false;
                            break;
                        }
                    }
                }

                if (isDuplicate) {
                    System.out.println("GAGAL: Menu yang sama sudah ada!");
                    return;
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    data.add(newData);
    save(fileName, data);
    System.out.println("Berhasil menambah data ke " + fileName);
}



    public static <T> void remove(String fileName, Class<T> clazz, int id) {
        List<T> data = load(fileName, clazz);
        data.removeIf(obj -> {
            try {
                Field idField = obj.getClass().getDeclaredField("id");
                idField.setAccessible(true);
                return idField.getInt(obj) == id;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        });
        save(fileName, data);
    }

    public static <T> void update(String fileName, Class<T> clazz, int id, String fieldName, Object newValue) {
        List<T> data = load(fileName, clazz);
        for (T obj : data) {
            try {
                Field idField = obj.getClass().getDeclaredField("id");
                idField.setAccessible(true);
                if (idField.getInt(obj) == id) {
                    Field field = obj.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(obj, newValue);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        save(fileName, data);
    }
}