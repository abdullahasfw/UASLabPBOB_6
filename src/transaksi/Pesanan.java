package transaksi;

import java.util.List;
import java.util.ArrayList;
import transaksi.DetailPesanan;

public class Pesanan {
    private int idPesanan;
    private String status;
    private List<DetailPesanan> daftarItem = new ArrayList<>();
    private Meja meja;
    private double totalHarga;

    public Pesanan(int idPesanan, Meja meja) {
        this.idPesanan = idPesanan;
        this.meja = meja;
<<<<<<< HEAD
        this.status = "dipesan";
        this.totalHarga = hitungTotal();
    }

    public double hitungTotal() {
    double total = 0;
    for (DetailPesanan dp : daftarItem) {
        total += dp.getSubTotal();
    }
    return total;
}
=======
        this.status = "Draft"; // Status awal
        this.daftarItem = new ArrayList<>();
        this.totalHarga = 0.0;
    }

    public void konfirmasiPesanan() {
        this.status = "Dikonfirmasi";
        System.out.println("Pesanan #" + idPesanan + " telah dikonfirmasi ke Dapur.");
    }
>>>>>>> b36d179bafa7ac7cb24972d74b6608b7dd743e7a
}
