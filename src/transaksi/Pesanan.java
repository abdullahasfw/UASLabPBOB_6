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

    public void konfirmasiPesanan() {
        this.status = "Dikonfirmasi";
        System.out.println("Pesanan #" + idPesanan + " telah dikonfirmasi ke Dapur.");
    }
}
