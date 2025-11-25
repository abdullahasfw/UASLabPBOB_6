package akun;

import pembayaran.Pembayaran;
import sistem.RestaurantSystem;
import transaksi.Pesanan;

public class Customer extends Akun {
    public Customer(int id, String nama, String password) {
        super(id, nama, password);
    }

    public int getId() {
        return super.getId();
    }

    public String getNama() {
        return super.getNama();
    }

    public void pilihMeja(){
        System.out.println("Meja atas nama: " + getNama() + "\nid: " + getId());
    }

    public void buatPesanan() {
        System.out.println("Pesanan dibuat oleh " + getNama());
    }

    @Override
    public void tampilkanMenuAksi(RestaurantSystem system) {
        System.out.println("Menu Customer ditampilkan.");
        system.lihatMenu(); // Memanggil method dari parameter system
    }

    public void bayarPesanan(Pesanan p, Pembayaran metode) {
    System.out.println("Customer " + getNama() + " memilih metode pembayaran.");
    metode.bayar(p.getTotalHarga()); // PANGGIL method dari interface
    }

    

}
