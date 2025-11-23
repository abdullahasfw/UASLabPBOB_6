package pembayaran;
public class CashPayment implements Pembayaran {
    private int id;

    public CashPayment(int id) {
        this.id = id;
    }
    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return id;
    }

    public void bayarCash(double jumlah) {
        System.out.println("Cash Payment sebesar " + jumlah + " berhasil dilakukan dengan ID: " + id);
    }
}
