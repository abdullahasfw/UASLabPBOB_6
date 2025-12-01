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

        Login login = new Login();

            Object akun = login.login();
                while (akun == null) {
                    akun = login.login();
                    if(akun != null){
                        break;
                    }
                } 
Scanner sc = new Scanner(System.in);

// =====================================================
// =============== MENU CUSTOMER =======================
// =====================================================
if (akun instanceof Customer) {
    Customer c = (Customer) akun;

    while (true) {
        System.out.println("\n=== MENU CUSTOMER ===");
        System.out.println("1. Lihat Menu");
        System.out.println("2. Lihat Daftar Meja");
        System.out.println("3. Mulai Pesanan");
        System.out.println("4. Tambah Item ke Pesanan");
        System.out.println("5. Konfirmasi Pesanan");
        System.out.println("6. Lihat Pesanan Saya");
        System.out.println("7. Bayar");
        System.out.println("8. Logout");
        System.out.println("0. Tutup Aplikasi");
        System.out.print("Pilih: ");

        int pilih = sc.nextInt();
        sc.nextLine();

        if (pilih == 0) break;

        switch (pilih) {
            case 1:
                sistem.lihatMenu();
                break;

            case 2:
                sistem.tampilkanDaftarMeja();
                break;

            case 3:
                System.out.print("Nomor meja: ");
                int no = sc.nextInt();
                sc.nextLine();
                Meja m = new Meja(no, "tersedia");
                sistem.mulaiPesanan(c, m);
                break;

            case 4:
                System.out.print("Nama menu: ");
                String namaMenu = sc.nextLine();

                System.out.print("Jumlah: ");
                int jumlah = sc.nextInt();
                sc.nextLine();

                MenuItem item = null;

                // cek di makanan
                for (Makanan mk : DatabaseManager.load("MenuMakanan.json", Makanan.class)) {
                    if (mk.getNama().equalsIgnoreCase(namaMenu))
                        item = mk;
                }

                // cek di minuman
                for (Minuman mn : DatabaseManager.load("MenuMinuman.json", Minuman.class)) {
                    if (mn.getNama().equalsIgnoreCase(namaMenu))
                        item = mn;
                }

                if (item == null) {
                    System.out.println("Menu tidak ditemukan!");
                } else {
                    System.out.print("Catatan (optional): ");
                    String catatan = sc.nextLine();
                    sistem.tambahItemKePesanan(c, item, jumlah, catatan);
                }
                break;

            case 5:
                sistem.konfirmasiPesanan(c);
                break;

            case 6:
                sistem.tampilkanPesananCS(c);
                break;

            case 7:
                System.out.println("Metode bayar:");
                System.out.println("1. Cash");
                System.out.println("2. Kartu");
                System.out.print("Pilih: ");
                int bay = sc.nextInt();

                Pembayaran metode = null;
                if (bay == 1) metode = new CashPayment(c.getId());
                else {
                    System.out.print("Masukkan nomor kartu: ");
                    int kartu = sc.nextInt();
                    metode = new CardPayment(c.getId(), kartu);
                }

                sistem.prosesTransaksi(c, metode);
                break;

            case 8:
                akun = null;
                while (akun == null) {
                    akun = login.login();
                    if(akun != null){
                        break;
                    }
                } 
                if (!(akun instanceof Customer)) {
                    break;
                }
                c = (Customer) akun;
                break;

            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}

// =====================================================
// =============== MENU KOKI ===========================
// =====================================================
else if (akun instanceof Koki) {
    Koki k = (Koki) akun;

    while (true) {
        System.out.println("\n=== MENU KOKI ===");
        System.out.println("1. Proses antrian dapur");
        System.out.println("0. Logout");
        System.out.print("Pilih: ");

        int pilih = sc.nextInt();

        if (pilih == 0) break;

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

    while (true) {
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
    Kasir ks = (Kasir) akun;

    while (true) {
        System.out.println("\n=== MENU KASIR ===");
        System.out.println("1. Lihat Semua Pesanan");
        System.out.println("0. Logout");
        System.out.print("Pilih: ");

        int pilih = sc.nextInt();

        if (pilih == 0) break;

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