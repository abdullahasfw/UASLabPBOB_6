package transaksi;
import menu.MenuItem;

public class DetailPesanan {
    private MenuItem item;
    private int jumlah;
    private String catatan;

    public DetailPesanan(MenuItem item, int jumlah, String catatan) {
    this.item = item;
    this.jumlah = jumlah;
    this.catatan = catatan;
}
}
