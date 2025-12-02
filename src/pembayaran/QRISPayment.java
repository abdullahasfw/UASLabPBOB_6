package pembayaran;

/**
 * QRISPayment adalah implementasi dari interface Pembayaran
 * yang menggunakan metode pembayaran QRIS. Setiap transaksi
 * memiliki ID dan QR Code yang dihasilkan otomatis.
 */
public class QRISPayment implements Pembayaran {
    private int id;
    private String QRCode;

    /**
     * Membuat objek QRISPayment dan langsung menghasilkan QR Code unik.
     *
     * @param id ID pembayaran
     */
    public QRISPayment(int id) {
        this.id = id;
        this.QRCode = generateQRCode();
    }

    /**
     * Mengatur ulang ID pembayaran.
     *
     * @param id ID baru
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Mengambil ID pembayaran.
     *
     * @return ID pembayaran
     */
    public int getID() {
        return id;
    }

    /**
     * Mengatur QR Code secara manual jika dibutuhkan.
     *
     * @param QRCode kode QR baru
     */
    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    /**
     * Mengambil QR Code.
     *
     * @return QR Code
     */
    public String getQRCode() {
        return QRCode;
    }

     /**
     * Menghasilkan QR Code unik berdasarkan ID dan waktu saat ini.
     *
     * @return QR Code unik
     */
    public String generateQRCode() {
        return "QRIS" + id + System.currentTimeMillis();
    }
    
    /**
     * Memproses pembayaran menggunakan QRIS.
     *
     * @param jumlah jumlah uang yang dibayar
     */
    @Override
    public void bayar(double jumlah) {
        System.out.println("QRIS Payment sebesar " + jumlah + " berhasil dilakukan dengan ID: " + id + " QR Code: " + QRCode);
    }

    /**
     * Menampilkan informasi metode pembayaran QRIS.
     */
    @Override
    public void idPembayaran() {
        System.out.println("Metode Pembayaran: QRIS (Code: " + QRCode + ")");
    }

}
