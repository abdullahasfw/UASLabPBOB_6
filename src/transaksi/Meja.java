package transaksi;

/**
 * Kelas Meja merepresentasikan meja di restoran.
 * Setiap meja memiliki nomor dan status, seperti "tersedia" atau "dipakai".
 */
public class Meja {
    private int nomor;
    private String status;

    /**
     * Konstruktor untuk membuat objek Meja dengan nomor dan status tertentu.
     *
     * @param nomor  nomor meja
     * @param status status meja (misalnya: "tersedia", "dipakai")
     */
    public Meja(int nomor, String status) {
        this.nomor = nomor;
        this.status = status;
    }

    /**
     * Konstruktor untuk membuat Meja dengan status default "tersedia".
     *
     * @param nomorMeja nomor meja
     */
    public Meja(int nomorMeja) {
        this.nomor = nomorMeja;
        this.status = "tersedia";
    }

    /**
     * Mengubah status meja.
     *
     * @param status status baru meja
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Mengambil status meja.
     *
     * @return status meja
     */
    public String getStatus() {
        return status;
    }

    /**
     * Mengambil nomor meja.
     *
     * @return nomor meja
     */
    public int getNomor() {
        return nomor;
    }

    /**
     * Alias dari getNomor(), disediakan untuk kompatibilitas kode.
     *
     * @return nomor meja
     */
    public int getNomorMeja() {
        return nomor;
    }

}
