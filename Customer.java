class Customer extends Akun {
    public Customer(String nama, String password) {
        super(nama, password);
    }

    public void buatPesanan() {
        System.out.println("Pesanan dibuat oleh " + getNama());
    }

    @Override
    public void tampilkanMenuAksi() {
        System.out.println("Menu Customer ditampilkan.");
    }
}
