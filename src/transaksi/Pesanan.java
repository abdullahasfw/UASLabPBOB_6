package transaksi;

import java.util.List;
import java.util.ArrayList;

public class Pesanan {
    private int idPesanan;
    private String status;
    private List<DetailPesanan> daftarItem = new ArrayList<>();
    private Meja meja;
    private double totalHarga;

    public Pesanan(int idPesanan, Meja meja) {
        this.idPesanan = idPesanan;
        this.meja = meja;
        this.status = "Draft"; // Status awal
        this.daftarItem = new ArrayList<>();
        this.totalHarga = 0.0;
    }


    // Method untuk menambah item ke dalam list (Sesuai diagram komposisi)
    public void tambahItem(DetailPesanan detail) {
        daftarItem.add(detail);
        // Update total harga langsung saat item ditambah
        totalHarga += detail.getSubtotal(); 
    }

    public void konfirmasiPesanan() {
        this.status = "Dikonfirmasi";
        System.out.println("Pesanan #" + idPesanan + " telah dikonfirmasi ke Dapur.");
    }

    public void tampilkanStruk() {
        System.out.println("========= STRUK PESANAN #" + idPesanan + " =========");
        System.out.println("Meja: " + meja.getNomorMeja());
        System.out.println("----------------------------------------------");
        for (DetailPesanan dp : daftarItem) {
            System.out.println(dp.getInfo());
        }
        System.out.println("----------------------------------------------");
        System.out.println("TOTAL HARGA \t: Rp " + totalHarga);
        System.out.println("==============================================");
    }
}
