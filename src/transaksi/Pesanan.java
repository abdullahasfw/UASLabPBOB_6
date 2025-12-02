package transaksi;

import java.util.List;
import java.util.ArrayList;
import transaksi.DetailPesanan;

/**
 * Kelas Pesanan merepresentasikan satu transaksi pesanan di restoran.
 * Di dalamnya terdapat informasi meja, daftar item yang dipesan,
 * total harga, status pesanan, dan nama customer.
 */
public class Pesanan {
    /** ID unik untuk pesanan */
    private int idPesanan;
    /** Status pesanan, misalnya: "Menunggu", "Dimasak", "Selesai" */
    private String status;
    /** Daftar item atau detail pesanan */
    private List<DetailPesanan> daftarItem = new ArrayList<>();
    /** Meja tempat pesanan dibuat */
    private Meja meja;
    /** Total harga pesanan */
    private double totalHarga;
    /** Nama customer yang membuat pesanan */
    private String customerName;

    /**
     * Konstruktor untuk membuat objek Pesanan.
     *
     * @param idPesanan    ID dari pesanan
     * @param meja         Meja yang digunakan customer
     * @param status       Status awal pesanan
     * @param customerName Nama customer yang memesan
     */
    public Pesanan(int idPesanan, Meja meja, String status, String customerName) {
        this.idPesanan = idPesanan;
        this.meja = meja;
        this.status = status;
        this.customerName = customerName;
    }

    /**
     * Mengembalikan nama customer yang membuat pesanan.
     *
     * @return nama customer
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Menghitung dan mengambil total harga seluruh item pesanan.
     * Total dihitung berdasarkan subtotal dari tiap DetailPesanan.
     *
     * @return total harga seluruh pesanan
     */
    public double getTotalHarga() {
        double totalHarga = 0;
        for (DetailPesanan dp : daftarItem) {
            totalHarga += dp.getSubTotal();
        }
        return totalHarga;
    }

    /**
     * Menambahkan item pesanan ke daftar.
     * Juga menambahkan subtotal item ke total harga pesanan.
     *
     * @param dp detail pesanan (item + jumlah + harga)
     */
    public void addDetail(DetailPesanan dp) {
        daftarItem.add(dp);

        this.totalHarga += dp.getSubTotal();
    }

    /**
     * Mengambil ID pesanan.
     *
     * @return id pesanan
     */
    public int getIdPesanan() {
        return idPesanan;
    }

    /**
     * Mengambil meja dari pesanan.
     *
     * @return objek Meja
     */
    public Meja getMeja() {
        return meja;
    }

    /**
     * Mengambil seluruh daftar item pesanan dalam bentuk list.
     *
     * @return List DetailPesanan
     */
    public List<DetailPesanan> getDaftarItem() {
        return daftarItem;
    }

    /**
     * Mengubah status pesanan.
     *
     * @param status status baru pesanan
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Mengambil status pesanan saat ini.
     *
     * @return status pesanan
     */
    public String getStatus() {
        return status;
    }

}
