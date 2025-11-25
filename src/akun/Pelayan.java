package akun;
import sistem.RestaurantSystem;
import transaksi.Pesanan;

public class Pelayan extends Pegawai {
    
    public Pelayan(int id, String nama, String password, String peran) {
        super(id, nama, password);
    }
    
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