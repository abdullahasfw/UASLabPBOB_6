package Menu;
public class Makanan extends MenuItem {
    private int tingkatPedas;
    private String kategori;
    
    public Makanan(String nama, double harga, int tingkatPedas, String kategori) {
        super(nama, harga);
        this.tingkatPedas = tingkatPedas;
        this.kategori = kategori;
    }

    @Override
    public String getInfo() {
        return "Makanan: " + getNama() + ", Harga: " + getHarga() + ", Tingkat Pedas: " + tingkatPedas + ", Kategori: " + kategori;
    }
}    
