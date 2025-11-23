package akun;

import sistem.RestaurantSystem;

public class Pegawai extends Akun {
    private boolean isOnline;
    private String peran;

    // daftar peran valid
    public static final String[] PERAN_VALID = {"kasir", "koki", "pelayan"};

    public Pegawai(int id, String nama, String password, String peran) {
        super(id, nama, password);

        if (!isPeranValid(peran)) {
            throw new IllegalArgumentException("Peran'" + peran + "' tidak valid!");
        }

        this.peran = peran;
    }

    private boolean isPeranValid(String peran) {
        for (String p : PERAN_VALID) {
            if (p.equalsIgnoreCase(peran)) {
                return true;
            }
        }
        return false;
    }

    public String getPeran() {
        return peran;
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
