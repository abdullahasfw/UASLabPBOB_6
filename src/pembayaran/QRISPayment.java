package pembayaran;
public class QRISPayment implements Pembayaran {
    private int id;
    private String QRCode;

    public QRISPayment(int id) {
        this.id = id;
        this.QRCode = generateQRCode();
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

    public String generateQRCode() {
        return "QRIS" + id + System.currentTimeMillis();
    }
    
    @Override
    public void bayar(double jumlah) {
        System.out.println("QRIS Payment sebesar " + jumlah + " berhasil dilakukan dengan ID: " + id + " QR Code: " + QRCode);
    }

    @Override
    public void idPembayaran() {
        System.out.println("Metode Pembayaran: QRIS (Code: " + QRCode + ")");
    }

}
