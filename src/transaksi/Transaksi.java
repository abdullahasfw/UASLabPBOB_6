package transaksi;

import pembayaran.Pembayaran;

/**
 * Kelas Transaksi merepresentasikan proses pembayaran dari sebuah pesanan,
 * termasuk ID transaksi, pesanan terkait, dan metode pembayarannya.
 */
public class Transaksi {
    private int idTransaksi;
    private Pesanan pesanan;
    private Pembayaran metodePembayaran;

    private static int counterId = 0;

    /**
     * Membuat transaksi baru dengan ID otomatis.
     * 
     * @param pesanan          pesanan yang dibayar
     * @param metodePembayaran objek pembayaran (Cash, Card, QRIS)
     */
    public Transaksi(Pesanan pesanan, Pembayaran metodePembayaran) {
        this.idTransaksi = ++counterId;
        this.pesanan = pesanan;
        this.metodePembayaran = metodePembayaran;
    }

    /**
     * Mengambil ID transaksi.
     * 
     * @return ID transaksi
     */
    public int getIdTransaksi() {
        return idTransaksi;
    }

    /**
     * Mengambil pesanan terkait transaksi.
     * 
     * @return objek Pesanan
     */
    public Pesanan getPesanan() {
        return pesanan;
    }

    /**
     * Mengambil metode pembayaran.
     * 
     * @return metode pembayaran yang digunakan
     */
    public Pembayaran getMetodePembayaran() {
        return metodePembayaran;
    }

    /**
     * Mengonfirmasi transaksi dan menampilkan informasi keberhasilan.
     */
    public void konfirmasi() {
        // konfirmasi pembayaran
        System.out.println("Transaksi ID " + idTransaksi + " berhasil dikonfirmasi.");
    }

}
