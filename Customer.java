class Customer extends Akun {
    private List<Pesanan> riwayatPesanan = new ArrayList<>();

    public Customer(String username, String password) {
        super(username, password);
    }

    public void tambahPesanan(Pesanan p) {
        riwayatPesanan.add(p);
    }

    public List<Pesanan> getRiwayatPesanan() {
        return riwayatPesanan;
    }
}
