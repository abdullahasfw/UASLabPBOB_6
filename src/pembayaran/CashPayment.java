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

    @Override
    public void bayar(double jumlah) {
        System.out.println("Cash Payment sebesar " + jumlah + " berhasil dilakukan dengan ID: " + id);
    }

    @Override
    public void idPembayaran() {
        System.out.println("Metode Pembayaran: Cash (ID: " + id + ")");
    }
}
