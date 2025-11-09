class Customer extends Akun {
    public Customer(int id, String nama, String password) {
        super(id, nama, password);
    }

    public void buatPesanan() {
        System.out.println("Pesanan dibuat oleh " + getNama());
    }

    @Override
    public void tampilkanMenuAksi() {
        System.out.println("Menu Customer ditampilkan.");
    }
}
