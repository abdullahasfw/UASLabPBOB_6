import akun.*;
import menu.*;
import transaksi.*;
import pembayaran.*;
import sistem.RestaurantSystem;
import ui.*;

import database.DatabaseManager;

public class RestaurantDriver {
    public static void main(String[] args) {


        new Home();
        Pegawai tes = new Pegawai(1, "dobleh", "dobleh123", "kasir");
        DatabaseManager.add("Pegawai.json", akun.Pegawai.class, tes);


        System.out.println("ini adalah");

        Makanan mk1 = new Makanan("nasi goreng", 10000, "1 - 5", "berat, gurih");
        DatabaseManager.add("MenuMakanan.json", menu.Makanan.class, mk1);

        Makanan mk2 = new Makanan("mie goreng kuah", 10000, "1 - 5", "berat, gurih");
        DatabaseManager.add("MenuMakanan.json", menu.Makanan.class, mk2);

        Makanan mk3 = new Makanan("mie goreng kering", 10000, "1 - 5", "berat, gurih");
        DatabaseManager.add("MenuMakanan.json", menu.Makanan.class, mk3);

        Minuman mn1 = new Minuman("jus", 6000, "sedang", "dingin/sedang");
        DatabaseManager.add("MenuMinuman.json", menu.Minuman.class, mn1);

        Minuman mn2 = new Minuman("teh", 5000, "sedang", "panas/hangat");
        DatabaseManager.add("MenuMinuman.json", menu.Minuman.class, mn2);

        Minuman mn3 = new Minuman("kopi", 8000, "sedang", "panas/dingin");
        DatabaseManager.add("MenuMinuman.json", menu.Minuman.class, mn3);

        Customer coba = new Customer(1, "shara", "shara123");
        DatabaseManager.add("Customer.json", akun.Customer.class, coba);

        Meja meja1 = new Meja (1, "tersedia");
    DatabaseManager.add("Meja.json", transaksi.Meja.class, meja1);

    Meja meja2 = new Meja (2, "tersedia");
    DatabaseManager.add("Meja.json", transaksi.Meja.class, meja2);

    Meja meja3 = new Meja (3, "tersedia");
    DatabaseManager.add("Meja.json", transaksi.Meja.class, meja3);

    Meja meja4 = new Meja (4, "tersedia");
    DatabaseManager.add("Meja.json", transaksi.Meja.class, meja4);

    Meja meja5 = new Meja (5, "tersedia");
    DatabaseManager.add("Meja.json", transaksi.Meja.class, meja5);


        // new CardPayment(1, 1234567);
        // coba.bayarCard(21000);


        System.out.println("\n--- SIMULASI APLIKASI ---");


        // Inisialisasi Sistem
        RestaurantSystem sistem = new RestaurantSystem();

        // Customer melakukan aksi
        coba.tampilkanMenuAksi(sistem);
        sistem.tampilkanDaftarMeja();
        sistem.mulaiPesanan(coba, meja1);
        sistem.mulaiPesanan(coba, meja1);
        sistem.tambahItemKePesanan(coba, mk3, 2, "pedas 3");
        sistem.tampilkanDaftarMeja();
        sistem.konfirmasiPesanan(coba);


}
}