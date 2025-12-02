package akun;

import javax.xml.crypto.Data;

import pembayaran.Pembayaran;
import sistem.RestaurantSystem;
import transaksi.Pesanan;
import database.DatabaseManager;

/**
 * Kelas {@code Customer} merepresentasikan akun pelanggan
 * dalam sistem restoran. Customer dapat memilih meja, dan
 * membuat pesanan menggunakan metode yang tersedia.
 *
 * <p>Kelas ini merupakan turunan dari {@link Akun}.</p>
 */
public class Customer extends Akun {

    /**
     * Mengambil ID customer.
     *
     * @return ID customer
     */
    public Customer(int id, String nama, String password) {
        super(id, nama, password);
      
    }

    /**
     * Mengambil ID customer.
     *
     * @return ID customer
     */
    public int getId() {
        return super.getId();
    }

    /**
     * Mengambil nama customer.
     *
     * @return nama customer
     */
    public String getNama() {
        return super.getNama();
    }

     /**
     * Menampilkan informasi meja yang dipilih oleh customer.
     * (Hanya mencetak ke konsol).
     */
    public void pilihMeja(){
        System.out.println("Meja atas nama: " + getNama() + "\nid: " + getId());
    }

    /**
     * Menandai bahwa customer membuat pesanan.
     */
    public void buatPesanan() {
        System.out.println("Pesanan dibuat oleh " + getNama());
    }


    

}
