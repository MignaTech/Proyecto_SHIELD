package modelos;

import java.io.Serializable;

public class Capacidad implements Serializable {
    private int codCap;
    private String tpCap;

    public Capacidad() {}

    public Capacidad(int codCap, String tpCap) {
        setCodCap(codCap);
        setTpCap(tpCap);
    }

    public int getCodCap() {
        return codCap;
    }

    public void setCodCap(int codCap) {
        this.codCap = codCap;
    }

    public String getTpCap() {
        return tpCap;
    }

    public void setTpCap(String tpCap) {
        this.tpCap = tpCap;
    }
}
