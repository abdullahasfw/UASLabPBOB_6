package sistem;

import menu.*; 
import akun.*;  
import transaksi.*;
import database.DatabaseManager;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantSystem {
    private Map<Integer, Pesanan> pesananAktif = new HashMap<>();
    private int idPesananCounter = 0;

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

     public void tampilkanDaftarMeja() {

        System.out.println("========================================");
        System.out.println("          DAFTAR MEJA RESTORAN          ");
        System.out.println("========================================");

        List<Meja> semuaMeja = DatabaseManager.load("Meja.json", Meja.class);
        System.out.println("Daftar Meja:");

        for (Meja m : semuaMeja) {
        System.out.println("Meja #" + m.getNomor() + " - Status: " + m.getStatus());
        System.out.println("=========================================");
       }
}

    private int generateIdPesanan() {
    return idPesananCounter++;
    }

    public void mulaiPesanan(Customer customer, Meja meja) {

        if (pesananAktif.containsKey(customer.getId())) {
            System.out.println("Customer ini sudah memiliki pesanan aktif!");
            return;
        }

        if (meja.getStatus().equalsIgnoreCase("terisi")) {
             System.out.println("Meja #" + meja.getNomor() + " sudah terisi. Gagal memulai pesanan.");
             return;
        }

        Pesanan baru = new Pesanan(generateIdPesanan(), meja);
        pesananAktif.put(customer.getId(), baru);

        System.out.println("Pesanan baru dibuat untuk customer: " + customer.getNama());

        boolean statusUpdated = this.updateStatusMeja(meja.getNomor(), "Terisi");

        if (statusUpdated) {
            // Update status objek 'meja' di memori
            meja.setStatus("Terisi"); 
        } else {
            System.err.println("PERINGATAN: Gagal memperbarui status Meja #" + meja.getNomor() + " di database.");
        }
    }

    public void tambahItemKePesanan(Customer customer, MenuItem item, int jumlah, String catatan) {

        Pesanan p = pesananAktif.get(customer.getId());

        if (p == null) {
            System.out.println("Customer belum memiliki pesanan! Buat dulu.");
            return;
        }

        DetailPesanan dp = new DetailPesanan(item, jumlah, catatan);
        p.addDetail(dp);

        System.out.println("Item \"" + item.getNama() + "\" ditambahkan ke pesanan customer "
                + customer.getNama());
    }

} 