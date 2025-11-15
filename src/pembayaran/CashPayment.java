package pembayaran;
public class CashPayment implements Pembayaran {
    private int id;
    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return id;
    }
}
