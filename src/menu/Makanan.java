package menu;
public class Makanan extends MenuItem {
    private String tingkatPedas;
    private String kategori;
    
    public Makanan(String nama, double harga, String tingkatPedas, String kategori) {
        super(nama, harga);
        this.tingkatPedas = tingkatPedas;
        this.kategori = kategori;
    }

    @Override
    public String getInfo() {
        return "Makanan: " + getNama() + ", Harga: " + getHarga() + ", Tingkat Pedas: " + tingkatPedas + ", Kategori: " + kategori;
    }
}    
