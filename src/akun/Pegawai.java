package akun;

import sistem.RestaurantSystem;

public class Pegawai extends Akun {
    private boolean isOnline;
    
    public Pegawai(int id, String nama, String password) {
        super(id, nama, password);
    }


    public void updateStatusPesanan() {
        System.out.println("Status pesanan diperbarui oleh " + getNama());
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean getOnline() {
        return isOnline;
    }
}
