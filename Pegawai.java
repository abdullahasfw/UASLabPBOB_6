class Pegawai extends Akun {
    private String peran;

    public Pegawai(String nama, String password, String peran) {
        super(nama, password);
        this.peran = peran;
    }

    public void updateStatusPesanan() {
        System.out.println("Status pesanan diperbarui oleh " + getNama());
    }

    @Override
    public void tampilkanMenuAksi() {
        System.out.println("Menu Pegawai ditampilkan.");
    }
}
