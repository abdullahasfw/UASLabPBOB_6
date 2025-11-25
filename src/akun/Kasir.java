package akun;

import pembayaran.Pembayaran;
import transaksi.Pesanan;

public class Kasir extends Pegawai {
    
    public Kasir(int id, String nama, String password, String peran) {
        super(id, nama, password);

    }

    public void prosesPembayaran(Pesanan p, Customer c, Pembayaran metode) {
    System.out.println("Kasir memproses transaksi pesanan #" + p.getIdPesanan());
    c.bayarPesanan(p, metode);
    p.setStatus("Sudah Dibayar");
    }

}