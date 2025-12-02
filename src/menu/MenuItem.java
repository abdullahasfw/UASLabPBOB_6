package menu;

/**
 * Kelas abstrak {@code MenuItem} merepresentasikan item dasar dalam menu
 * restoran. Setiap item menu memiliki nama dan harga, dan kelas ini
 * menyediakan getter serta setter untuk keduanya.
 * <p>
 * Kelas ini bersifat abstrak karena setiap jenis menu (misalnya makanan
 * atau minuman) harus menentukan implementasi detail melalui metode
 * {@link #getInfo()}.
 */
public abstract class MenuItem {
    /** Nama item menu. */
    private String nama;
     /** Harga item menu. */
    private double harga;

    /**
     * Membuat objek MenuItem dengan nama dan harga tertentu.
     *
     * @param nama  Nama item menu
     * @param harga Harga item menu
     */
    public MenuItem(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    /**
     * Mendapatkan nama item menu.
     *
     * @return Nama item
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mendapatkan harga item menu.
     *
     * @return Harga item
     */
    public double getHarga() {
        return harga;
    }

    /**
     * Mengubah nama item menu.
     *
     * @param nama Nama baru item
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Mengubah harga item menu.
     *
     * @param harga Harga baru item
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }
    
     /**
     * Mengembalikan informasi lengkap tentang item menu.
     * <p>
     * Setiap subclass wajib mengimplementasikan metode ini sesuai
     * kebutuhan masing-masing.
     *
     * @return Informasi item menu dalam bentuk string
     */
    public abstract String getInfo();
}
