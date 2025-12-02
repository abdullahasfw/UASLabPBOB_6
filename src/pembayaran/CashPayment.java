package pembayaran;

/**
 * Kelas {@code CashPayment} mengimplementasikan metode pembayaran menggunakan uang tunai.
 * Kelas ini menyimpan ID pembayaran dan menyediakan metode untuk memproses pembayaran
 * serta menampilkan informasi metode pembayaran.
 */
public class CashPayment implements Pembayaran {
    private int id;

    /**
     * Konstruktor untuk membuat objek pembayaran tunai baru.
     *
     * @param id ID unik untuk pembayaran
     */
    public CashPayment(int id) {
        this.id = id;
    }

    /**
     * Mengatur ulang ID pembayaran.
     *
     * @param id ID baru untuk pembayaran
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
     * Memproses pembayaran tunai sebanyak jumlah tertentu.
     * Metode ini menampilkan informasi bahwa pembayaran berhasil dilakukan.
     *
     * @param jumlah Besaran pembayaran
     */
    @Override
    public void bayar(double jumlah) {
        System.out.println("Cash Payment sebesar " + jumlah + " berhasil dilakukan dengan ID: " + id);
    }

     /**
     * Menampilkan informasi metode pembayaran yang digunakan.
     */
    @Override
    public void idPembayaran() {
        System.out.println("Metode Pembayaran: Cash (ID: " + id + ")");
    }
}
