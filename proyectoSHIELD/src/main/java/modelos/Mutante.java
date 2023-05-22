package modelos;

import java.io.Serializable;

public class Mutante implements Serializable {
    private int codAtk,mutanAfec;
    private String grupInvolu;
    public Mutante(){}

    public Mutante(int codAtk, String grupInvolu, int mutanAfec) {
        setCodAtk(codAtk);
        setGrupInvolu(grupInvolu);
        setMutanAfec(mutanAfec);
    }

    public String getGrupInvolu() {
        return grupInvolu;
    }

    public void setGrupInvolu(String grupInvolu) {
        this.grupInvolu = grupInvolu;
    }

    public int getMutanAfec() {
        return mutanAfec;
    }

    public void setMutanAfec(int mutanAfec) {
        this.mutanAfec = mutanAfec;
    }

    public int getCodAtk() {
        return codAtk;
    }

    public void setCodAtk(int codAtk) {
        this.codAtk = codAtk;
    }
}
