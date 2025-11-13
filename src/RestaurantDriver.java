import Akun.*;
import database.DatabaseManager;

public class RestaurantDriver {
    public static void main(String[] args) {
        Pegawai tes = new Pegawai(1, "dobleh", "dobleh123", "kasir");
        DatabaseManager.add("Pegawai.json", Akun.Pegawai.class, tes);

        System.out.println("ini adalah");
    }
}
