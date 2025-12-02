package menu;

/**
 * Kelas {@code Makanan} merupakan turunan dari {@link MenuItem} yang
 * merepresentasikan item makanan pada menu restoran. Selain nama dan harga,
 * kelas ini menambahkan informasi tingkat pedas dan kategori makanan.
 */
public class Makanan extends MenuItem {
    /** Menyimpan tingkat kepedasan makanan (misalnya: Tidak Pedas, Sedang, Pedas). */
    private String tingkatPedas;
    /** Menyimpan kategori makanan (misalnya: Main Course, Appetizer, Dessert). */
    private String kategori;
    
     /**
     * Membuat objek Makanan baru dengan nama, harga, tingkat pedas, dan kategori.
     *
     * @param nama         Nama makanan
     * @param harga        Harga makanan
     * @param tingkatPedas Tingkat kepedasan makanan
     * @param kategori     Kategori makanan
     */
    public Makanan(String nama, double harga, String tingkatPedas, String kategori) {
        super(nama, harga);
        this.tingkatPedas = tingkatPedas;
        this.kategori = kategori;
    }

    /**
     * Mengembalikan informasi lengkap mengenai makanan ini dalam bentuk string.
     *
     * @return String berisi detail makanan (nama, harga, tingkat pedas, kategori)
     */
    @Override
    public String getInfo() {
        return "Makanan: " + getNama() + ", Harga: " + getHarga() + ", Tingkat Pedas: " + tingkatPedas + ", Kategori: " + kategori;
    }
}    
