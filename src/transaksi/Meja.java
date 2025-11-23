package transaksi;
public class Meja {
    private int nomor;
    private String status;
    

    public Meja(int nomor, String status) {
        this.nomor = nomor;
        this.status = status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public int getNomor() {
        return nomor;
    }

    public Meja(int nomorMeja) {
        this.nomor = nomorMeja;
        this.status = "Terisi";
    }

    public int getNomorMeja() {
        return nomor;
    }

}
