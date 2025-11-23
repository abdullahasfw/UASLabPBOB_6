package transaksi;
public class Meja {
    private int nomor;
    private String status;
    
    public Meja(int nomorMeja) {
        this.nomorMeja = nomorMeja;
        this.status = "Terisi";
    }

    public int getNomorMeja() {
        return nomorMeja;
    }
}
