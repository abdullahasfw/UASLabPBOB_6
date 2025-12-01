package akun;

import sistem.RestaurantSystem;
/**
 * Kelas abstrak yang merepresentasikan sebuah akun di dalam sistem restoran.
 * Setiap akun memiliki ID, nama, dan password, serta harus dapat menampilkan
 * menu aksi sesuai perannya masing-masing.
 */
public abstract class Akun {
    private int id;
    private String nama;
    private String password;

    /**
     * Membuat objek akun baru dengan informasi dasar pengguna.
     *
     * @param id        ID unik akun
     * @param nama      nama pemilik akun
     * @param password  password akun
     */
    public Akun(int id, String nama, String password) {
        this.id = id;
        this.nama = nama;
        this.password = password;
    }

    /**
     * Mengambil ID dari akun.
     *
     * @return ID akun
     */
    public int getId() {
        return id;
    }

     /**
     * Mengambil password dari akun.
     *
     * @return password akun
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Mengambil nama pemilik akun.
     *
     * @return nama akun
     */
    public String getNama() {
        return nama;
    }
}
