package pembayaran;
public interface Pembayaran {
  public void setID(int id);
  public int getID();
  public void bayar(double jumlah);   // semua metode harus implement ini
  public void idPembayaran();
}
