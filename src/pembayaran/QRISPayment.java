package pembayaran;
public class QRISPayment implements Pembayaran {
    private int id;
    private String QRCode;

    public QRISPayment(int id, String QRCode) {
        this.id = id;
        this.QRCode = QRCode;
    }
    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return id;
    }
    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }
    public String getQRCode() {
        return QRCode;
    }
    
    @Override
    public void bayar(double jumlah) {
        System.out.println("QRIS Payment sebesar " + jumlah + " berhasil dilakukan dengan ID: " + id + " QR Code: " + QRCode);
    }

}
