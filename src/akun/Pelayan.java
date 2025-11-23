package akun;

import static akun.Pegawai.PERAN_VALID;

public class Pelayan extends Pegawai {
    
    public Pelayan(int id, String nama, String password, String peran) {
        super(id, nama, password, "pelayan");
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