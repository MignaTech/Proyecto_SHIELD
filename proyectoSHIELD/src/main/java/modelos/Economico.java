package modelos;

import java.io.Serializable;

public class Economico implements Serializable {
    private int codAtk;
    private String biebDispu;
    public Economico(){}

    public Economico(int codAtk, String biebDispu) {
        setCodAtk(codAtk);
        setBiebDispu(biebDispu);
    }

    public int getCodAtk() {
        return codAtk;
    }

    public void setCodAtk(int codAtk) {
        this.codAtk = codAtk;
    }

    public String getBiebDispu() {
        return biebDispu;
    }

    public void setBiebDispu(String biebDispu) {
        this.biebDispu = biebDispu;
    }
}
