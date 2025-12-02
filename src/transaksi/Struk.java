package transaksi;

import transaksi.Pesanan;

/**
 * Kelas Struk bertanggung jawab untuk mencetak struk transaksi
 * dalam bentuk output konsol. Struk menampilkan detail pesanan,
 * total pembayaran, pajak/layanan (jika ada), serta metode pembayaran.
 *
 * <p>
 * Metode utama dalam kelas ini hanya satu, yaitu {@code Cetak()},
 * yang bersifat static sehingga dapat dipanggil tanpa membuat objek Struk.
 * </p>
 */
public class Struk {

    /**
     * Mencetak struk transaksi ke layar.
     * <p>
     * Struk berisi:
     * <ul>
     * <li>ID transaksi</li>
     * <li>Nomor meja dan status meja</li>
     * <li>Daftar item pesanan (nama, jumlah, catatan, subtotal)</li>
     * <li>Subtotal keseluruhan item</li>
     * <li>Pajak / layanan (selisih total harga dengan subtotal item)</li>
     * <li>Total harga akhir</li>
     * <li>Metode pembayaran yang digunakan</li>
     * </ul>
     *
     * @param transaksi objek Transaksi yang akan dicetak struknya
     */
    public static void Cetak(Transaksi transaksi) {
        Pesanan p = transaksi.getPesanan();

        System.out.println("\n==================================");
        System.out.println("          STRUK TRANSAKSI");
        System.out.println("==================================");
        System.out.println("ID Transaksi: " + transaksi.getIdTransaksi());
        System.out.println("Meja: " + p.getMeja().getNomor() + " (" + p.getMeja().getStatus() + ")");
        System.out.println("----------------------------------");

        double subtotalItem = 0;

        for (DetailPesanan detail : p.getDaftarItem()) {
            double itemSubtotal = detail.getSubTotal();

            System.out.printf("%s (x%d) \tRp%,.0f\n",
                    detail.getItem().getNama(),
                    detail.getJumlah(),
                    itemSubtotal);

            if (detail.getCatatan() != null && !detail.getCatatan().isEmpty()) {
                System.out.println("   Catatan: " + detail.getCatatan());
            }

            subtotalItem += itemSubtotal;
        }

        double totalFinal = p.getTotalHarga();
        double pajakLayanan = totalFinal - subtotalItem;

        System.out.println("----------------------------------");
        System.out.printf("SUBTOTAL ITEM\t\tRp%,.0f\n", subtotalItem);

        if (pajakLayanan > 0) {
            System.out.printf("Pajak/Layanan\t\tRp%,.0f\n", pajakLayanan);
        }

        System.out.println("----------------------------------");
        System.out.printf("TOTAL BAYAR\t\tRp%,.0f\n", totalFinal);
        System.out.println("Metode Bayar: " + transaksi.getMetodePembayaran().getClass().getSimpleName());
        System.out.println("==================================");
        System.out.println("   Terima Kasih Atas Kunjungan Anda!");
        System.out.println("==================================");
    }
}
