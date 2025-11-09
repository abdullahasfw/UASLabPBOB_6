public abstract class Akun {
    private int id; 
    private String nama;
    private String password;

    public Akun(int id, String nama, String password) {
        this.id = id;
        this.nama = nama;
        this.password = password;
    }
    public abstract void tampilkanMenuAksi();

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }
}

  
  
