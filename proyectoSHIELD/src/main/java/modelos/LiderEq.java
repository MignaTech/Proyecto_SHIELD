package modelos;

import java.io.Serializable;

public class LiderEq implements Serializable {
    private int codLider,codEq,cantEq;
    public LiderEq(){}
    public LiderEq(int codLider, int codEq, int cantEq) {
        setCodLider(codLider);
        setCodEq(codEq);
        setCantEq(cantEq);
    }

    public int getCodLider() {
        return codLider;
    }

    public void setCodLider(int codLider) {
        this.codLider = codLider;
    }

    public int getCodEq() {
        return codEq;
    }

    public void setCodEq(int codEq) {
        this.codEq = codEq;
    }

    public int getCantEq() {
        return cantEq;
    }

    public void setCantEq(int cantEq) {
        this.cantEq = cantEq;
    }
}
