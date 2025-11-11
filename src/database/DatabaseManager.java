package database;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
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
            e.printStackTrace(null);
        }
    }

    public static <T> void load(String fileName, Class<T> clazz) {
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
}