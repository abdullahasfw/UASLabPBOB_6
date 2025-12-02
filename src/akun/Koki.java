package akun;
import sistem.RestaurantSystem;

import transaksi.Pesanan;


public class Koki extends Pegawai{

    public Koki(int id, String nama, String password, String peran) {
        super(id, nama, password, peran);
        
    }
    
    public void mulaiMasak(Pesanan p) {
        p.setStatus("Dimasak");
    }

    public void selesaiMasak(Pesanan p) {
        p.setStatus("Selesai Dimasak");
    }

    public void lihatPesananDapur(RestaurantSystem system) {
        System.out.println("Pesanan di Dapur dilihat oleh " + getNama());
        system.tampilkanSemuaPesanan();
    }

    public void prosesDapur(RestaurantSystem system) {
        system.prosesDapur();
    }



}
