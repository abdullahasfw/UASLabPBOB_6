class Makanan extends MenuItem{
    private int tingkatPedas;
    private String kategori;
    
    public Makanan(String nama, double harga, int tingkatPedas, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.tingkatPedas = tingkatPedas;
        this.kategori = kategori;
    }

    @Override
    public String getInfo() {
        return "Makanan: " + nama + ", Harga: " + harga + ", Tingkat Pedas: " + tingkatPedas + ", Kategori: " + kategori;
    }
    
