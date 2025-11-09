public abstract class Akun {
    private int id = 0; 
    private String nama;
    private String password;

    public Akun(String nama, String password) {
        id++;
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

  
  
