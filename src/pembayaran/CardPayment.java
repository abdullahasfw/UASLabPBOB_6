package pembayaran;

/**
 * Kelas {@code CardPayment} merupakan implementasi dari interface {@link Pembayaran}
 * yang menangani proses pembayaran menggunakan kartu (debit/kredit).
 * <p>
 * Kelas ini menyimpan ID pembayaran dan nomor kartu, lalu menyediakan metode
 * untuk memproses pembayaran serta menampilkan informasi metode pembayaran.
 */
public class CardPayment implements Pembayaran {
    private int id;
    private int nomorKartu;

    /**
     * Membuat objek CardPayment baru dengan ID dan nomor kartu tertentu.
     *
     * @param id          ID pembayaran
     * @param nomorKartu  Nomor kartu yang digunakan
     */
     public CardPayment(int id, int nomorKartu) {
        this.id = id;
        this.nomorKartu = nomorKartu;
    }

     /**
     * Mengatur ulang ID pembayaran.
     *
     * @param id ID baru yang ingin diset
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Mendapatkan ID pembayaran.
     *
     * @return ID pembayaran
     */
    public int getID() {
        return id;
    }

    /**
     * Mengatur ulang nomor kartu.
     *
     * @param nomorKartu Nomor kartu baru
     */
    public void setNomorKartu(int nomorKartu) {
        this.nomorKartu = nomorKartu;
    }
    /**
     * Mendapatkan nomor kartu.
     *
     * @return Nomor kartu
     */
    public int getNomorKartu() {
        return nomorKartu;
    }

    /**
     * Memproses pembayaran sejumlah nilai tertentu dan menampilkan hasilnya
     * pada konsol.
     *
     * @param jumlah Jumlah uang yang dibayarkan
     */
    @Override
    public void bayar(double jumlah) {
        System.out.println("Card Payment sebesar " + jumlah + " berhasil dilakukan dengan ID: " + id + " dengan Nomor Kartu: " + nomorKartu);
    }
    
    /**
     * Menampilkan informasi metode pembayaran pada konsol.
     */
    @Override
    public void idPembayaran() {
        System.out.println("Metode Pembayaran: Card (No: " + nomorKartu + ")");
    }
}
