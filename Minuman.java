class Minuman extends MenuItem {
    private String ukuran;
    private String suhu;

    public Minuman(String nama, double harga, String ukuran, String suhu) {
        this.nama = nama;
        this.harga = harga;
        this.ukuran = ukuran;
        this.suhu = suhu;
    }

    @Override
    public String getInfo() {
        return "Minuman: " + nama + ", Harga: " + harga + ", Ukuran: " + ukuran + ", Suhu: " + suhu;
    }
}
