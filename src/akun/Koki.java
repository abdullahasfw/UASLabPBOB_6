package akun;
import sistem.RestaurantSystem;

import transaksi.Pesanan;


/**
 * Kelas {@code Koki} merupakan turunan dari {@link Pegawai} yang bertugas
 * menyiapkan dan memasak pesanan pelanggan. Koki dapat mengubah status pesanan,
 * melihat daftar pesanan yang ada di dapur, dan memproses antrean dapur.
 */
public class Koki extends Pegawai{

      /**
     * Membuat objek Koki baru.
     *
     * @param id        ID unik koki
     * @param nama      Nama koki
     * @param password  Password untuk autentikasi
     * @param peran     Peran atau jabatan koki dalam sistem
     */
    public Koki(int id, String nama, String password, String peran) {
        super(id, nama, password, peran);
        
    }

    /**
     * Mengubah status pesanan menjadi "Dimasak".
     *
     * @param p Pesanan yang akan mulai dimasak
     */
    public void mulaiMasak(Pesanan p) {
        p.setStatus("Dimasak");
    }

    /**
     * Mengubah status pesanan menjadi "Selesai Dimasak".
     *
     * @param p Pesanan yang telah selesai dimasak
     */
    public void selesaiMasak(Pesanan p) {
        p.setStatus("Selesai Dimasak");
    }

    /**
     * Menampilkan seluruh pesanan yang sedang berada di dapur melalui
     * objek {@link RestaurantSystem}. Informasi ditampilkan pada konsol.
     *
     * @param system Sistem restoran yang digunakan untuk menampilkan pesanan dapur
     */
    public void lihatPesananDapur(RestaurantSystem system) {
        System.out.println("Pesanan di Dapur dilihat oleh " + getNama());
        system.tampilkanSemuaPesanan();
    }

    /**
     * Memproses antrean pesanan di dapur yang dikelola oleh
     * {@link RestaurantSystem}. Biasanya berisi logika pemasakan terjadwal.
     *
     * @param system Sistem restoran yang memproses antrean dapur
     */
    public void prosesDapur(RestaurantSystem system) {
        system.prosesDapur();
    }

}
