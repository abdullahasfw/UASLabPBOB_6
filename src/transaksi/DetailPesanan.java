package transaksi;

import menu.MenuItem;

/**
 * DetailPesanan merepresentasikan satu item dalam sebuah pesanan,
 * berisi menu, jumlah item, catatan tambahan, serta subtotal.
 */
public class DetailPesanan {
    private MenuItem item;
    private int jumlah;
    private String catatan;
    private double subTotal;

    /**
     * Membuat objek DetailPesanan baru.
     *
     * @param item    item menu yang dipesan
     * @param jumlah  jumlah item yang dibeli
     * @param catatan catatan tambahan dari customer
     */
    public DetailPesanan(MenuItem item, int jumlah, String catatan) {
        this.item = item;
        this.jumlah = jumlah;
        this.catatan = catatan;

        this.subTotal = item.getHarga() * jumlah;
    }

    /**
     * Menghitung dan mengembalikan subtotal harga.
     *
     * @return subtotal berdasarkan harga item × jumlah
     */
    public double getSubTotal() {
        double subTotal = item.getHarga() * jumlah;
        return subTotal;
    }

    /**
     * Mengembalikan item menu yang dipesan.
     *
     * @return item menu
     */
    public MenuItem getItem() {
        return item;
    }

    /**
     * Mengembalikan jumlah item yang dipesan.
     *
     * @return jumlah item
     */
    public int getJumlah() {
        return jumlah;
    }

    /**
     * Mengembalikan catatan tambahan customer.
     *
     * @return catatan pesanan
     */
    public String getCatatan() {
        return catatan;
    }
}
