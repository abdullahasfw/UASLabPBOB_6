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

    }

    public double getTotalHarga() {
        double totalHarga = 0;
        for (DetailPesanan dp : daftarItem) {
            totalHarga += dp.getSubTotal();
        }
        return totalHarga;
    }

    public void addDetail(DetailPesanan dp) {
        daftarItem.add(dp);
    }

    public List<DetailPesanan> getDaftarItem() {
    return daftarItem;
    }

    public Meja getMeja() {
        return meja;
    }

    



    // public void konfirmasiPesanan() {
    //     this.status = "Dikonfirmasi";
    //     System.out.println("Pesanan #" + idPesanan + " telah dikonfirmasi ke Dapur.");
    // }

    //     public double hitungTotal() {
//     double total = 0;
//     for (DetailPesanan dp : daftarItem) {
//         total += dp.getSubTotal();
//     }
//     return total;
// }
}
