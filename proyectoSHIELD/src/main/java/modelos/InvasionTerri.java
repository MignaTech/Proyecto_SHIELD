package modelos;

import java.io.Serializable;

public class InvasionTerri implements Serializable {
    private int codAtk;
    private String regionAfec;
    public InvasionTerri(){}

    public InvasionTerri(int codAtk, String regionAfec) {
        setCodAtk(codAtk);
        setRegionAfec(regionAfec);
    }

    public int getCodAtk() {
        return codAtk;
    }

    public void setCodAtk(int codAtk) {
        this.codAtk = codAtk;
    }

    public String getRegionAfec() {
        return regionAfec;
    }

    public void setRegionAfec(String regionAfec) {
        this.regionAfec = regionAfec;
    }
}
