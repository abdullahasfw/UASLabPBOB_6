package akun;

import pembayaran.Pembayaran;
import transaksi.Pesanan;
import transaksi.Transaksi;
import transaksi.Struk;

/**
 * Kelas {@code Kasir} merupakan turunan dari {@link Pegawai} yang bertugas
 * memproses pembayaran pesanan pelanggan. Kasir melakukan pembuatan transaksi,
 * konfirmasi pembayaran, dan mencetak struk.
 */
public class Kasir extends Pegawai {
    
    
    /**
     * Membuat objek Kasir baru.
     *
     * @param id        ID unik kasir
     * @param nama      Nama kasir
     * @param password  Password untuk autentikasi
     * @param peran     Peran atau jabatan kasir dalam sistem
     */
    public Kasir(int id, String nama, String password, String peran) {
        super(id, nama, password, peran);

    }


    /**
     * Memproses pembayaran dari suatu pesanan oleh seorang customer.
     * <p>
     * Langkah-langkah yang dilakukan:
     * <ol>
     *   <li>Membuat objek {@link Transaksi}</li>
     *   <li>Menampilkan informasi pembayaran</li>
     *   <li>Melakukan konfirmasi transaksi</li>
     *   <li>Mencetak struk melalui {@link Struk#Cetak(Transaksi)}</li>
     *   <li>Mengembalikan objek Transaksi</li>
     * </ol>
     *
     * @param p       Objek pesanan yang akan dibayar
     * @param c       Customer yang melakukan pembayaran
     * @param metode  Metode pembayaran yang digunakan (cash, e-wallet, dll)
     * @return        Objek {@link Transaksi} yang telah diproses dan dikonfirmasi
     */
    public Transaksi prosesPembayaran(Pesanan p, Customer c, Pembayaran metode) {
        // 1. Buat Objek Transaksi (ID otomatis dari constructor Transaksi)
        Transaksi t = new Transaksi(p, metode); 

        System.out.println("\n[Kasir " + getNama() + "]: Memproses pembayaran untuk Pesanan #" + p.getIdPesanan());
        System.out.println("Total Tagihan: " + p.getTotalHarga());
        metode.idPembayaran(); 

        // 2. Konfirmasi Transaksi
        t.konfirmasi(); 

        // 3. PENCETAKAN STRUK TERJADI DI SINI
        System.out.println("\n--- Struk Sedang Dicetak ---");
        Struk.Cetak(t);
        
        // 4. Kembalikan Transaksi
        return t;
    }

}