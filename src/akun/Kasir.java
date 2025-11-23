package akun;
public class Kasir extends Pegawai {
    private String peran;
    public Kasir(int id, String nama, String password, String peran) {
        super(id, nama, password);
        this.peran = "kasir";
    }

    public String getPeran() {
        return peran;
    }

    
}