package transaksi;
import pembayaran.Pembayaran;

public class Transaksi {
  private int idTransaksi;
  private Pesanan pesanan;
  private Pembayaran metodePembayaran;

  private static int counterId = 0;
  
  public Transaksi(Pesanan pesanan, Pembayaran metodePembayaran) {
        this.idTransaksi = ++counterId;
        this.pesanan = pesanan;
        this.metodePembayaran = metodePembayaran;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public Pesanan getPesanan() {
        return pesanan;
    }

    public Pembayaran getMetodePembayaran() {
        return metodePembayaran;
    }

    public void konfirmasi() {
        //konfirmasi pembayaran
        System.out.println("Transaksi ID " + idTransaksi + " berhasil dikonfirmasi.");
    }

  
}
