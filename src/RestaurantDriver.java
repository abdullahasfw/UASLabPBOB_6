import akun.*;
import menu.*;
import transaksi.*;
import pembayaran.*;
import database.DatabaseManager;

public class RestaurantDriver {
    public static void main(String[] args) {

        System.out.println("ini adalah");

        Makanan mk1 = new Makanan("nasi goreng", 10000, "1 - 5", "Makanan");
        DatabaseManager.add("MenuMakanan.json", menu.Makanan.class, mk1);

        Makanan mk2 = new Makanan("mie goreng kuah", 10000, "1 - 5", "Makanan");
        DatabaseManager.add("MenuMakanan.json", menu.Makanan.class, mk2);

        Makanan mk3 = new Makanan("mie goreng kering", 10000, "1 - 5", "Makanan");
        DatabaseManager.add("MenuMakanan.json", menu.Makanan.class, mk3);

        Minuman mn1 = new Minuman("jus", 6000, "sedang", "dingin/sedang");
        DatabaseManager.add("MenuMinuman.json", menu.Minuman.class, mn1);

        Minuman mn2 = new Minuman("teh", 5000, "sedang", "panas/hangat");
        DatabaseManager.add("MenuMinuman.json", menu.Minuman.class, mn2);

        Minuman mn3 = new Minuman("kopi", 8000, "sedang", "panas/dingin");
        DatabaseManager.add("MenuMinuman.json", menu.Minuman.class, mn3);

        Customer coba = new Customer(1, "shara", "shara123");
        DatabaseManager.add("Customer.json", akun.Customer.class, coba);

        // new CardPayment(1, 1234567);
        // coba.bayarCard(21000);


    }
}
