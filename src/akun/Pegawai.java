package akun;

import sistem.RestaurantSystem;

public class Pegawai extends Akun {
    private String peran;
    private boolean isOnline;

    public Pegawai(int id, String nama, String password, String peran) {
        super(id, nama, password);
        this.peran = peran;
    }

    public void updateStatusPesanan() {
        System.out.println("Status pesanan diperbarui oleh " + getNama());
    }

    @Override
    public void tampilkanMenuAksi(RestaurantSystem system) {
        System.out.println("Menu Pegawai ditampilkan.");
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean getOnline() {
        return isOnline;
    }
}
