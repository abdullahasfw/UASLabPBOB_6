package pembayaran;
public class CardPayment implements Pembayaran {
    private int id;
    private int nomorKartu;

     public CardPayment(int id, int nomorKartu) {
        this.id = id;
        this.nomorKartu = nomorKartu;
    }

    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return id;
    }
    public void setNomorKartu(int nomorKartu) {
        this.nomorKartu = nomorKartu;
    }
    public int getNomorKartu() {
        return nomorKartu;
    }

    public void bayarCard(double jumlah) {
        System.out.println("Card Payment sebesar " + jumlah + " berhasil dilakukan dengan ID: " + id + "dengan Nomor Kartu: " + nomorKartu);
    }
}
