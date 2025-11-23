package sistem;

import menu.*;      // Import class Makanan & Minuman
import database.DatabaseManager;
import java.util.List;

public class RestaurantSystem {

    // Method ini sesuai dengan diagram UML: +lihatMenu()
    public void lihatMenu() {
        System.out.println("========================================");
        System.out.println("          DAFTAR MENU RESTORAN          ");
        System.out.println("========================================");

        // --- BAGIAN 1: LOAD MAKANAN ---
        // Menggunakan method .load() milik DatabaseManager Anda
        List<Makanan> daftarMakanan = DatabaseManager.load("MenuMakanan.json", Makanan.class);

        System.out.println("\n--- [ MAKANAN ] ---");
        if (daftarMakanan.isEmpty()) {
            System.out.println("(Menu makanan sedang kosong)");
        } else {
            for (Makanan m : daftarMakanan) {
                // Menggunakan getInfo() dari class Makanan
                System.out.println(m.getInfo());
            }
        }

        // --- BAGIAN 2: LOAD MINUMAN ---
        List<Minuman> daftarMinuman = DatabaseManager.load("MenuMinuman.json", Minuman.class);

        System.out.println("\n--- [ MINUMAN ] ---");
        if (daftarMinuman.isEmpty()) {
            System.out.println("(Menu minuman sedang kosong)");
        } else {
            for (Minuman m : daftarMinuman) {
                // Menggunakan getInfo() dari class Minuman
                System.out.println(m.getInfo());
            }
        }
        System.out.println("\n========================================");
    }
} 