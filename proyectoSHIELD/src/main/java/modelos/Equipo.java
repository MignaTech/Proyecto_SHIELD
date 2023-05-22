package modelos;

import java.io.Serializable;

public class Equipo implements Serializable {
    private int codEq;
    private String nEq;
    public Equipo(){}
    public Equipo(int codEq, String nEq) {
        setCodEq(codEq);
        setnEq(nEq);
    }
    public int getCodEq() {
        return codEq;
    }

    public void setCodEq(int codEq) {
        this.codEq = codEq;
    }

    public String getnEq() {
        return nEq;
    }

    public void setnEq(String nEq) {
        this.nEq = nEq;
    }
}
