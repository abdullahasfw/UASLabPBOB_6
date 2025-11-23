package transaksi;
public class Meja {
    private int nomor;
    private String status;
    
<<<<<<< HEAD
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


=======
    public Meja(int nomorMeja) {
        this.nomor = nomorMeja;
        this.status = "Terisi";
    }

    public int getNomorMeja() {
        return nomor;
    }
>>>>>>> b36d179bafa7ac7cb24972d74b6608b7dd743e7a
}
