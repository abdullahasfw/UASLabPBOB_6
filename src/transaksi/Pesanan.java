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
}
