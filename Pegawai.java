class Pegawai extends Akun {
    private String peran;

    public Pegawai(String username, String password, String peran, int id) {
        super(username, password, id);
        this.peran = peran;
    }

    public void inputDataPesanan() {
        System.out.println("Pegawai " + username + " memasukkan data pesanan.");
    }
}
