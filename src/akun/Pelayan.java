package akun;
import sistem.RestaurantSystem;
import transaksi.Pesanan;

/**
 * Kelas {@code Pelayan} merupakan turunan dari {@link Pegawai} yang bertugas
 * mengantar pesanan pelanggan ke meja yang sesuai. Pelayan bertanggung jawab
 * memperbarui status pesanan dan memberikan notifikasi proses pengantaran.
 */
public class Pelayan extends Pegawai {
    
    /**
     * Membuat objek Pelayan baru.
     *
     * @param id        ID unik pelayan
     * @param nama      Nama pelayan
     * @param password  Password untuk autentikasi login
     * @param peran     Peran atau jabatan pelayan dalam sistem
     */
    public Pelayan(int id, String nama, String password, String peran) {
        super(id, nama, password, peran);
       
    }
    
     /**
     * Mengantar pesanan ke meja pelanggan dan mengubah status pesanan menjadi
     * "Diantar". Informasi pengantaran akan ditampilkan ke konsol.
     *
     * @param p Pesanan yang akan diantar oleh pelayan
     */
    public void antarPesanan(Pesanan p) {
    p.setStatus("Diantar");

    System.out.println(
        "Pelayan " + this.getNama() +
        " mengantar pesanan #" + p.getIdPesanan() +
        " untuk customer: " + p.getCustomerName() +
        " ke meja #" + p.getMeja().getNomor()
    );
}

}