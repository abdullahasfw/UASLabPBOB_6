package transaksi;
import menu.MenuItem;

public class DetailPesanan {
    private MenuItem item;
    private int jumlah;
    private String catatan;
    private double subTotal;

    public DetailPesanan(MenuItem item, int jumlah, String catatan) {
    this.item = item;
    this.jumlah = jumlah;
    this.catatan = catatan;

    this.subTotal = item.getHarga() * jumlah;
    }
    
    public double getSubTotal() {
        double subTotal = item.getHarga() * jumlah;
        return subTotal;
    }
    public MenuItem getItem() {
    return item;
}

public int getJumlah() {
    return jumlah;
}

public String getCatatan() {
    return catatan;
}
}

