package sistem;

import menu.*; 
import akun.*;  
import transaksi.*;
import database.DatabaseManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RestaurantSystem {
    private Map<Integer, Pesanan> pesananAktif = new HashMap<>();
    private int idPesananCounter = 0;
    private Queue<Pesanan> antrianDapur = new LinkedList<>();
    private Queue<Pesanan> antrianSiapAntar = new LinkedList<>();
    private Queue<Pesanan> antrianTransaksi = new LinkedList<>();

    private Koki koki = new Koki(101, "budi","koki123", "koki");
    private Pelayan pelayan = new Pelayan(201, "siti","pelayan123", "pelayan");
    private Kasir kasir = new Kasir(301, "andi","kasir123", "kasir");
    

    // Method ini sesuai dengan diagram UML: +lihatMenu()
    public void lihatMenu() {
        System.out.println("========================================");
        System.out.println("          DAFTAR MENU RESTORAN          ");
        System.out.println("========================================");

        // --- BAGIAN 1: LOAD MAKANAN ---
        // Menggunakan method .load() milik DatabaseManager 
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

        List<Meja> semuaMeja = DatabaseManager.load("Meja.json", Meja.class);
    Meja mejaDariDB = null;
    for (Meja m : semuaMeja) {
        if (m.getNomor() == meja.getNomor()) {
            mejaDariDB = m;
            break;
        }
    }

    if (mejaDariDB == null) {
        System.out.println("Meja tidak ditemukan di database!");
        return;
    }

    if (mejaDariDB.getStatus().equalsIgnoreCase("Terisi")) {
        System.out.println("Meja #" + mejaDariDB.getNomor() + " sudah terisi. Gagal memulai pesanan.");
        return;
    }

        Pesanan baru = new Pesanan(generateIdPesanan(), meja, "dipesan", customer.getNama());
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


    public void tampilkanPesananCS(Customer customer) {

    Pesanan p = pesananAktif.get(customer.getId());

    if (p == null) {
        System.out.println("Customer belum memiliki pesanan!");
        return;
    }

    System.out.println("=== Daftar Pesanan Customer: " + customer.getNama() + " ===");

    List<DetailPesanan> itemList = p.getDaftarItem();

    if (itemList.isEmpty()) {
        System.out.println("Belum ada item yang dipesan.");
        return;
    }

    int i = 1;
    for (DetailPesanan dp : itemList) {
        System.out.println(i++ + ". " + dp.getItem().getNama()
            + " | Jumlah: " + dp.getJumlah()
            + " | Catatan: " + dp.getCatatan()
            + " | Subtotal: " + dp.getSubTotal()
        );
    }
    System.out.println("status pesanan:  " + p.getStatus());
    System.out.println("Total Harga: " + p.getTotalHarga());
}

public void tampilkanSemuaPesanan() {
    if (pesananAktif.isEmpty()) {
        System.out.println("Belum ada pesanan aktif.");
        return;
    }

    System.out.println("\n=== SEMUA PESANAN AKTIF ===");

    for (Map.Entry<Integer, Pesanan> entry : pesananAktif.entrySet()) {
        Pesanan p = entry.getValue();
        System.out.println("\nCustomer ID: " + entry.getKey());
        System.out.println("Meja: #" + p.getMeja().getNomor());
        System.out.println("Item:");

        int i = 1;
        for (DetailPesanan dp : p.getDaftarItem()) {
            System.out.println(" " + (i++) + ". " 
                + dp.getItem().getNama()
                + " x" + dp.getJumlah());
        }
        System.out.println("\n  Total Harga: " + p.getTotalHarga());
    }
}


    public void konfirmasiPesanan(Customer customer) {
    // 1. Ambil pesanan
    Pesanan p = pesananAktif.get(customer.getId());
    antrianDapur.add(p);

    if (p == null) {
        System.out.println("Tidak ada pesanan untuk dikonfirmasi.");
        return;
    }

    // // 2. Simpan ke Database (File JSON)
    // DatabaseManager.add("DataPesanan.json", Pesanan.class, p);

     System.out.println("Pesanan berhasil dikonfirmasi dan masuk ke dapur!");

     }

     public void prosesDapur() {
        if (antrianDapur.isEmpty()) {
            System.out.println("Tidak ada pesanan untuk dimasak.");
            return;
        }

         while (!antrianDapur.isEmpty()) {
        Pesanan p = antrianDapur.poll();   // ambil satu pesanan dari queue

        koki.mulaiMasak(p);
        System.out.println(
            "Pesanan #" + p.getIdPesanan() +
            " atas nama: " + p.getCustomerName() + " " +
            p.getStatus()
        );

        koki.selesaiMasak(p);
        System.out.println(
            "Pesanan #" + p.getIdPesanan() +
            " atas nama: " + p.getCustomerName() + " " +
             p.getStatus()
        );

        antrianSiapAntar.add(p);
        System.out.println(
            "Pesanan #" + p.getIdPesanan() +
            " masuk ke antrian pelayan untuk diantar.");
    }

        System.out.println("Semua pesanan dalam antrian dapur telah diproses.");
    }

    public void prosesAntarPesanan() {
    if (antrianSiapAntar.isEmpty()) {
        System.out.println("Tidak ada pesanan yang siap diantar.");
        return;
    }

    while (!antrianSiapAntar.isEmpty()) {
        Pesanan p = antrianSiapAntar.poll();

        pelayan.antarPesanan(p);  // pakai method pelayan
        antrianTransaksi.add(p);
    }

  }

    //  public void prosesTransaksi() {
    //     if (antrianTransaksi.isEmpty()) {
    //         System.out.println("Tidak ada pesanan untuk diproses transaksi.");
    //         return;
    //     }

    //     while (!antrianTransaksi.isEmpty()) {
    //         Pesanan p = antrianTransaksi.poll();

    //         kasir.prosesPembayaran(p);  // pakai method kasir

    //         // Hapus pesanan dari pesananAktif setelah transaksi selesai
    //         pesananAktif.values().removeIf(pesanan -> pesanan.getIdPesanan() == p.getIdPesanan());
    //     }



     public boolean updateStatusMeja(int nomorMeja, String statusBaru) {
        // 1. Load semua data meja dari file JSON
        List<transaksi.Meja> semuaMeja = DatabaseManager.load("Meja.json", transaksi.Meja.class);
        boolean mejaDitemukan = false;

        if (semuaMeja == null) {
            System.out.println("Gagal memuat daftar meja dari database.");
            return false;
        }

        // 2. Cari Meja berdasarkan nomor
        for (transaksi.Meja m : semuaMeja) {
            if (m.getNomor() == nomorMeja) {
                // 3. Ubah status meja
                m.setStatus(statusBaru); // Memerlukan method setStatus(String) di kelas Meja
                mejaDitemukan = true;
                break; 
            }
        }

        if (mejaDitemukan) {
            // 4. Simpan kembali (overwrite) seluruh daftar meja ke file JSON
            DatabaseManager.save("Meja.json", semuaMeja);
            System.out.println("Status Meja #" + nomorMeja + " berhasil diubah menjadi: " + statusBaru);
            return true;
        } else {
         System.out.println("Meja dengan nomor " + nomorMeja + " tidak ditemukan.");
            return false;
        }
    }
} 
