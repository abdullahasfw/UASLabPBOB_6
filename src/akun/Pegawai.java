package akun;

import sistem.RestaurantSystem;

/**
 * Kelas {@code Pegawai} merupakan turunan dari {@link Akun} dan menjadi
 * superclass bagi berbagai jenis pegawai di restoran seperti kasir dan koki.
 * <p>
 * Kelas ini menyimpan informasi dasar pegawai, seperti status online dan peran,
 * serta menyediakan metode umum yang dapat digunakan atau dioverride oleh
 * subclass.
 */
public class Pegawai extends Akun {
    /** Menyimpan status apakah pegawai sedang online atau tidak. */
    private boolean isOnline;
    /** Peran atau jabatan pegawai dalam sistem (misalnya: Kasir, Koki). */
    protected String peran;
    
    /**
     * Membuat objek Pegawai baru.
     *
     * @param id        ID unik pegawai
     * @param nama      Nama pegawai
     * @param password  Password untuk autentikasi login
     * @param peran     Peran atau jabatan pegawai dalam sistem
     */
    public Pegawai(int id, String nama, String password, String peran) {
        super(id, nama, password);
        this.peran = peran;
    }

    /**
     * Menampilkan informasi bahwa status pesanan telah diperbarui oleh pegawai.
     * <p>
     * Metode ini biasanya dioverride oleh subclass untuk menambahkan
     * implementasi logika yang lebih spesifik.
     */
    public void updateStatusPesanan() {
        System.out.println("Status pesanan diperbarui oleh " + getNama());
    }

    /**
     * Mengatur status online pegawai.
     *
     * @param online {@code true} jika pegawai sedang online, {@code false} jika offline
     */
    public void setOnline(boolean online) {
        isOnline = online;
    }

    /**
     * Mendapatkan status online pegawai.
     *
     * @return {@code true} jika pegawai sedang online, {@code false} jika offline
     */
    public boolean getOnline() {
        return isOnline;
    }
}
