package modelos;

import java.io.Serializable;

public class TpAlien implements Serializable {
    private int codAlien;
    private String razaAlien;
    public TpAlien(){}
    public TpAlien(int codAlien, String razaAlien) {
        setCodAlien(codAlien);
        setRazaAlien(razaAlien);
    }

    public String getRazaAlien() {
        return razaAlien;
    }

    public void setRazaAlien(String razaAlien) {
        this.razaAlien = razaAlien;
    }

    public int getCodAlien() {
        return codAlien;
    }

    public void setCodAlien(int codAlien) {
        this.codAlien = codAlien;
    }
}
