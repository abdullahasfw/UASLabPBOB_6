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
    private String customerName;

    public Pesanan(int idPesanan, Meja meja, String status, String customerName) {
    this.idPesanan = idPesanan;
    this.meja = meja;
    this.status = status;
    this.customerName = customerName;
}

public String getCustomerName() {
    return customerName;
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

        this.totalHarga += dp.getSubTotal();
    }
    public int getIdPesanan() {
    return idPesanan;
}

public Meja getMeja() {
    return meja;
}

public List<DetailPesanan> getDaftarItem() {
    return daftarItem;
}

public void setStatus(String status) {
    this.status = status;
}

public String getStatus(){
    return status;
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
