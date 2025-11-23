package akun;
import static akun.Pegawai.PERAN_VALID;

public class Kasir extends Pegawai {
    
    public Kasir(int id, String nama, String password, String peran) {
        super(id, nama, password, peran);
        if (!isPeranValid(peran)) {
            throw new IllegalArgumentException("Peran'" + peran + "' tidak valid!");
        }
    }

     private boolean isPeranValid(String peran) {
        for (String p : PERAN_VALID) {
            if (p.equalsIgnoreCase(peran)) {
                return true;
            }
        }
        return false;
    }
}