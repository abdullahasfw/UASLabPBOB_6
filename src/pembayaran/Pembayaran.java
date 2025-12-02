package pembayaran;

/**
 * Interface Pembayaran mendefinisikan struktur dasar untuk berbagai metode pembayaran.
 * Setiap kelas yang mengimplementasikan interface ini harus menyediakan
 * cara menetapkan ID pembayaran, mendapatkan ID, memproses pembayaran,
 * serta menampilkan informasi metode pembayaran.
 */
public interface Pembayaran {
 
  /**
     * Mengatur ID untuk metode pembayaran.
     *
     * @param id ID pembayaran
     */
  public void setID(int id);
  
  /**
     * Mendapatkan ID dari metode pembayaran.
     *
     * @return ID pembayaran
     */
  public int getID();

  /**
     * Memproses pembayaran sejumlah nilai tertentu.
     *
     * @param jumlah Jumlah uang yang dibayarkan
     */
  public void bayar(double jumlah);   // semua metode harus implement ini
  
  /**
     * Menampilkan informasi metode pembayaran.
     */
  public void idPembayaran();
}
