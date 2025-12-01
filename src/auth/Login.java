package auth;

import java.util.List;
import java.util.Scanner;

import akun.Customer;
import akun.Pegawai;
import database.DatabaseManager;

public class Login {

    public Object login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        // ===========================
        // LOAD DATA DARI JSON !!!
        // ===========================
        List<Pegawai> pegawaiList = DatabaseManager.load("Pegawai.json", Pegawai.class);
        List<Customer> customerList = DatabaseManager.load("Customer.json", Customer.class);

        // 1. Cek Pegawai
        for (Pegawai p : pegawaiList) {
            if (p.getNama().equals(username) && p.getPassword().equals(password)) {
                System.out.println("Login Pegawai Berhasil!");
                return p;
            }
        }

        // 2. Cek Customer
        for (Customer c : customerList) {
            if (c.getNama().equals(username) && c.getPassword().equals(password)) {
                System.out.println("Login Customer Berhasil!");
                return c;
            }
        }

        System.out.println("Login gagal! Username/Password salah.");
        return null;
    }
}
