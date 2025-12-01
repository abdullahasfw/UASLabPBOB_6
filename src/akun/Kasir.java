package akun;

import pembayaran.Pembayaran;
import transaksi.Pesanan;
import transaksi.Transaksi;
import transaksi.Struk;

public class Kasir extends Pegawai {
    private String peran;
    
    public Kasir(int id, String nama, String password, String peran) {
        super(id, nama, password);
        this.peran = peran;

    }

   /*  public void prosesPembayaran(Pesanan p, Customer c, Pembayaran metode) {
    System.out.println("Kasir memproses transaksi pesanan #" + p.getIdPesanan());
    c.bayarPesanan(p, metode);
    p.setStatus("Sudah Dibayar");
    } */

    public Transaksi prosesPembayaran(Pesanan p, Customer c, Pembayaran metode) {
        // 1. Buat Objek Transaksi (ID otomatis dari constructor Transaksi)
        Transaksi t = new Transaksi(p, metode); 

        System.out.println("\n[Kasir " + getNama() + "]: Memproses pembayaran untuk Pesanan #" + p.getIdPesanan());
        System.out.println("Total Tagihan: " + p.getTotalHarga());
        metode.idPembayaran(); 

        // 2. Konfirmasi Transaksi
        t.konfirmasi(); 

        // 3. PENCETAKAN STRUK TERJADI DI SINI
        System.out.println("\n--- Struk Sedang Dicetak ---");
        Struk.Cetak(t);
        
        // 4. Kembalikan Transaksi
        return t;
    }

}