package modelos;

import java.io.Serializable;
import java.sql.Date;

public class ShAtk implements Serializable {
    private Date fReti,fInco;
    private int codAtk,codGpSp;
    public ShAtk(){}
    public ShAtk(Date fReti, Date fInco, int codAtk, int codGpSp) {
        setfReti(fReti);
        setfInco(fInco);
        setCodAtk(codAtk);
        setCodGpSp(codGpSp);
    }

    public Date getfReti() {
        return fReti;
    }

    public void setfReti(Date fReti) {
        this.fReti = fReti;
    }

    public Date getfInco() {
        return fInco;
    }

    public void setfInco(Date fInco) {
        this.fInco = fInco;
    }

    public int getCodAtk() {
        return codAtk;
    }

    public void setCodAtk(int codAtk) {
        this.codAtk = codAtk;
    }

    public int getCodGpSp() {
        return codGpSp;
    }

    public void setCodGpSp(int codGpSp) {
        this.codGpSp = codGpSp;
    }
}
