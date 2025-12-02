import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import akun.*;
import auth.Login;
import menu.*;
import transaksi.*;
import pembayaran.*;
import sistem.RestaurantSystem;


import database.DatabaseManager;

public class RestaurantDriver {
    public static void main(String[] args) {

        RestaurantSystem sistem = new RestaurantSystem();

        Makanan mk1 = new Makanan("nasi goreng", 10000, "1 - 5", "berat, gurih");
        DatabaseManager.add("MenuMakanan.json", menu.Makanan.class, mk1);

        Makanan mk2 = new Makanan("mie goreng kuah", 10000, "1 - 5", "berat, gurih");
        DatabaseManager.add("MenuMakanan.json", menu.Makanan.class, mk2);

        Makanan mk3 = new Makanan("mie goreng kering", 10000, "1 - 5", "berat, gurih");
        DatabaseManager.add("MenuMakanan.json", menu.Makanan.class, mk3);

        Minuman mn1 = new Minuman("jus", 6000, "sedang", "dingin/sedang");
        DatabaseManager.add("MenuMinuman.json", menu.Minuman.class, mn1);

        Minuman mn2 = new Minuman("teh", 5000, "sedang", "panas/hangat/dingin");
        DatabaseManager.add("MenuMinuman.json", menu.Minuman.class, mn2);

        Minuman mn3 = new Minuman("kopi", 8000, "sedang", "panas/dingin");
        DatabaseManager.add("MenuMinuman.json", menu.Minuman.class, mn3);

        Customer coba = new Customer(1, "shara", "shara123");
        DatabaseManager.add("Customer.json", akun.Customer.class, coba);

        Customer coba1 = new Customer(2, "syifa", "123");
        DatabaseManager.add("Customer.json", akun.Customer.class, coba1);

        Koki koki = new Koki(102, "fathur", "fathur123", "koki");
        DatabaseManager.add("Koki.json", akun.Koki.class, koki);

        Kasir kasir = new Kasir(302, "syifa", "syifa123", "kasir");
        DatabaseManager.add("Kasir.json", akun.Kasir.class, kasir);

        Pelayan pelayan = new Pelayan (202, "abdul", "abdul123", "pelayan");
        DatabaseManager.add("Pelayan.json", akun.Pelayan.class, pelayan);

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
        System.out.flush();

        System.out.println("\n--- SIMULASI APLIKASI ---");
        Scanner sc = new Scanner(System.in);
        Login login = new Login();

        boolean t = true;

             while (t) {
            // Login
            Object akun = login.login();
            while (akun == null) {
                akun = login.login();
                if (akun != null) break;
            }


// =====================================================
// =============== MENU CUSTOMER =======================
// =====================================================
if (akun instanceof Customer) {
    Customer c = (Customer) akun;
    boolean logout = false;

    while (!logout) {
        System.out.println("\n=== MENU CUSTOMER ===");
        System.out.println("1. Lihat Menu");
        System.out.println("2. Lihat Daftar Meja");
        System.out.println("3. Pesan");
        System.out.println("4. Lihat Pesanan Saya");
        System.out.println("5. Bayar");
        System.out.println("6. Logout");
        System.out.println("0. Tutup Aplikasi");
        System.out.print("Pilih: ");

        int pilih = sc.nextInt();
        sc.nextLine();

        if (pilih == 0) {
            t = false;
            break;
        };

        switch (pilih) {
            case 1:
                sistem.lihatMenu();
                break;

            case 2:
                sistem.tampilkanDaftarMeja();
                break;
                
case 3:

    
    // Ambil semua meja dari database
    List<Meja> semuaMeja = DatabaseManager.load("Meja.json", Meja.class);

System.out.println("Daftar Meja:");
for (Meja m : semuaMeja) {
    System.out.println(m.getNomor() + ". " + m.getStatus());
}

System.out.print("Pilih nomor meja: ");
int pilihmeja = sc.nextInt();

Meja mejaDipilih = null;
for (Meja m : semuaMeja) {
    if (m.getNomor() == pilihmeja) {
        mejaDipilih = m;
        break;
    }
}

if (mejaDipilih == null) {
    System.out.println("Meja tidak ditemukan!");
    return;
}


    // Mulai Pesanan
    sistem.mulaiPesanan(c, mejaDipilih);

    // =============================
    // LOOP PEMESANAN BERULANG
    // =============================
    while (true) {

        System.out.println("\n=== MENU MAKANAN & MINUMAN ===");

        List<MenuItem> daftarGabungan = new ArrayList<>();

        List<Makanan> listMkn = DatabaseManager.load("MenuMakanan.json", Makanan.class);
        List<Minuman> listMin = DatabaseManager.load("MenuMinuman.json", Minuman.class);

        daftarGabungan.addAll(listMkn);
        daftarGabungan.addAll(listMin);

        for (int i = 0; i < daftarGabungan.size(); i++) {
            MenuItem mi = daftarGabungan.get(i);
            System.out.println((i + 1) + ". " + mi.getNama() + " - Rp" + mi.getHarga());
        }

        // pilih menu
        System.out.print("\nPilih nomor menu (0 untuk selesai): ");
        int pilihMenu = sc.nextInt();
        sc.nextLine();

        if (pilihMenu == 0) {
            break; // keluar dari loop pemesanan
        }

        if (pilihMenu < 1 || pilihMenu > daftarGabungan.size()) {
            System.out.println("Menu tidak valid!");
            continue;
        }

        MenuItem itemDipilih = daftarGabungan.get(pilihMenu - 1);

        // input jumlah
        System.out.print("Jumlah: ");
        int jumlahItem = sc.nextInt();
        sc.nextLine();

        System.out.print("Catatan (optional): ");
        String catatan = sc.nextLine();

        sistem.tambahItemKePesanan(c, itemDipilih, jumlahItem, catatan);

        System.out.println("Item berhasil ditambahkan!");

        // tawarkan lagi
        System.out.print("Ingin tambah item lagi? (y/n): ");
        String lagi = sc.nextLine();

        if (!lagi.equalsIgnoreCase("y")) {
            break;
        }
    }

    // setelah selesai pilih item → konfirmasi pesanan
    System.out.println("\nMengonfirmasi pesanan...");
    sistem.konfirmasiPesanan(c);

    break;



            case 4:
                sistem.tampilkanPesananCS(c);
                break;

            case 5:
    System.out.println("Metode bayar:");
    System.out.println("1. Cash");
    System.out.println("2. Kartu");
    System.out.println("3. QRIS");
    System.out.print("Pilih: ");
    int bay = sc.nextInt();
    sc.nextLine();

    Pembayaran metode = null;

    if (bay == 1) {
        metode = new CashPayment(c.getId());
    } 
    else if (bay == 2) {
        System.out.print("Masukkan nomor kartu: ");
        int kartu = sc.nextInt();
        sc.nextLine();
        metode = new CardPayment(c.getId(), kartu);
    } 
    else if (bay == 3) {
        metode = new QRISPayment(c.getId());
    } 
    else {
        System.out.println("Pilihan tidak valid!");
        break;
    }

    sistem.prosesTransaksi(c, metode);
    break;


            case 6:
               logout = true; // keluar dari loop Customer
        }
        
    }}


// =====================================================
// =============== MENU KOKI ===========================
// =====================================================
else if (akun instanceof Koki) {
    Koki k = (Koki) akun;
    boolean logout = false;

    while (!logout) {
        System.out.println("\n=== MENU KOKI ===");
        System.out.println("1. Proses antrian dapur");
        System.out.println("0. Logout");
        System.out.print("Pilih: ");

        int pilih = sc.nextInt();

        if (pilih == 0) {
             logout = true; // keluar dari loop
        };

        if (pilih == 1) {
            sistem.prosesDapur();
        }
    }
}

// =====================================================
// =============== MENU PELAYAN ========================
// =====================================================
else if (akun instanceof Pelayan) {
    Pelayan p = (Pelayan) akun;
    boolean logout = false;

    while (!logout) {
        System.out.println("\n=== MENU PELAYAN ===");
        System.out.println("1. Antar Pesanan");
        System.out.println("0. Logout");
        System.out.print("Pilih: ");

        int pilih = sc.nextInt();

        if (pilih == 0) break;

        if (pilih == 1) {
            sistem.prosesAntarPesanan();
        }
    }
}

// =====================================================
// =============== MENU KASIR ==========================
// =====================================================
else if (akun instanceof Kasir) {
    System.out.println("masok");
    
    Kasir ks = (Kasir) akun;
    boolean logout = false;

    while (!logout) {
        System.out.println("\n=== MENU KASIR ===");
        System.out.println("1. Lihat Semua Pesanan");
        System.out.println("0. Logout");
        System.out.print("Pilih: ");

        int pilih = sc.nextInt();

        if (pilih == 0) {
            logout = true; // keluar dari loop
        };

        if (pilih == 1) {
            sistem.tampilkanSemuaPesanan();
        }
    }
}


        

        // Customer melakukan aksi
        // coba.tampilkanMenuAksi(sistem);
        // sistem.tampilkanDaftarMeja();
        // sistem.mulaiPesanan(coba, meja1);
        // sistem.mulaiPesanan(coba1, meja1);
        // sistem.mulaiPesanan(coba1, meja4);
        // sistem.tambahItemKePesanan(coba, mk3, 2, "pedas 3");
        // sistem.tambahItemKePesanan(coba, mk2, 2, "pedas 3");
        // sistem.tambahItemKePesanan(coba1, mk3, 2, "pedas 5");
        // sistem.tambahItemKePesanan(coba, mn2, 2, "dingin");
        // sistem.konfirmasiPesanan(coba);
        // sistem.konfirmasiPesanan(coba1);
        // sistem.tampilkanPesananCS(coba1);
        // sistem.tampilkanPesananCS(coba);
        // sistem.prosesDapur();
        // sistem.tampilkanDaftarMeja();
        // sistem.tampilkanPesananCS(coba1);
        // sistem.tampilkanPesananCS(coba);
        // sistem.prosesAntarPesanan();
        // sistem.tampilkanPesananCS(coba1);
        // sistem.tampilkanPesananCS(coba);
        // sistem.tampilkanSemuaPesanan();

        
        // Pembayaran metode1 = new CashPayment(coba.getId());
        // Transaksi t1 = sistem.prosesTransaksi(coba, metode1);

        // Pembayaran metode2 = new CardPayment(coba1.getId(), 777888);
        // sistem.prosesTransaksi(coba1, metode2);


    
}
}
}
