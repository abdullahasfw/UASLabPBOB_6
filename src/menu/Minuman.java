package menu;

/**
 * Kelas {@code Minuman} merupakan turunan dari {@link MenuItem} yang
 * merepresentasikan item minuman pada menu restoran. Selain nama dan harga,
 * kelas ini menambahkan informasi ukuran dan suhu minuman.
 */
public class Minuman extends MenuItem {
    /** Ukuran minuman (misalnya: Small, Medium, Large). */
    private String ukuran;
    /** Suhu minuman (misalnya: Dingin, Hangat, Panas). */
    private String suhu;

     /**
     * Membuat objek Minuman baru dengan atribut lengkap.
     *
     * @param nama   Nama minuman
     * @param harga  Harga minuman
     * @param ukuran Ukuran minuman
     * @param suhu   Suhu minuman
     */
    public Minuman(String nama, double harga, String ukuran, String suhu) {
        super(nama, harga);
        this.ukuran = ukuran;
        this.suhu = suhu;
    }

    /**
     * Mengembalikan informasi lengkap mengenai minuman dalam bentuk string.
     *
     * @return String berisi detail minuman (nama, harga, ukuran, suhu)
     */
    @Override
    public String getInfo() {
        return "Minuman: " + getNama() + ", Harga: " + getHarga() + ", Ukuran: " + ukuran + ", Suhu: " + suhu;
    }
}
