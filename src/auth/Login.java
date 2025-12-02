package auth;

import java.util.List;
import java.util.Scanner;
import akun.Customer;
import akun.Kasir;
import akun.Koki;
import akun.Pelayan;
import database.DatabaseManager;

public class Login {
    public Object login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        // 1. Cek Customer
        List<Customer> customerList = DatabaseManager.load("Customer.json", Customer.class);
        for (Customer c : customerList) {
            if (c.getNama().equals(username) && c.getPassword().equals(password)) {
                System.out.println("Login Customer Berhasil!");
                return c;
            }
        }

        // 2. Cek Koki
        List<Koki> kokiList = DatabaseManager.load("Koki.json", Koki.class);
        for (Koki k : kokiList) {
            if (k.getNama().equals(username) && k.getPassword().equals(password)) {
                System.out.println("Login Koki Berhasil!");
                return k;
            }
        }

        // 3. Cek Kasir
        List<Kasir> kasirList = DatabaseManager.load("Kasir.json", Kasir.class);
        for (Kasir k : kasirList) {
            if (k.getNama().equals(username) && k.getPassword().equals(password)) {
                System.out.println("Login Kasir Berhasil!");
                return k;
            }
        }

        // 4. Cek Pelayan
        List<Pelayan> pelayanList = DatabaseManager.load("Pelayan.json", Pelayan.class);
        for (Pelayan p : pelayanList) {
            if (p.getNama().equals(username) && p.getPassword().equals(password)) {
                System.out.println("Login Pelayan Berhasil!");
                return p;
            }
        }

        System.out.println("Login gagal! Username/Password salah.");
        return null;
    }
}