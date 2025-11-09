class Customer extends Akun {
    private List<Pesanan> riwayatPesanan = new ArrayList<>();

    public Customer(int id, String nama, String password) {
        super(id, nama, password);
    }

    public void tambahPesanan(Pesanan p) {
        riwayatPesanan.add(p);
    }

    public List<Pesanan> getRiwayatPesanan() {
        return riwayatPesanan;
    }
