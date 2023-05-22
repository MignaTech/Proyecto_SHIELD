package modelos;

import java.io.Serializable;
import java.sql.Date;

public class AgenAtk implements Serializable {
    private Date fInco,fReti;
    private int codAgen,codAtk;
    private String agente,ataque;

    public AgenAtk() {}

    public AgenAtk(Date fInco, Date fReti, int codAgen, int codAtk) {
        setfInco(fInco);
        setfReti(fReti);
        setCodAgen(codAgen);
        setCodAtk(codAtk);
    }

    public AgenAtk(Date fInco, Date fReti, String agente, String ataque) {
        setfInco(fInco);
        setfReti(fReti);
        setAgente(agente);
        setAtaque(ataque);
    }

    public AgenAtk(Date fInco, Date fReti, int codAgen, int codAtk, String agente, String ataque) {
        setfInco(fInco);
        setfReti(fReti);
        setCodAgen(codAgen);
        setCodAtk(codAtk);
        setAgente(agente);
        setAtaque(ataque);
    }

    public Date getfInco() {
        return fInco;
    }

    public void setfInco(Date fInco) {
        this.fInco = fInco;
    }

    public Date getfReti() {
        return fReti;
    }

    public void setfReti(Date fReti) {
        this.fReti = fReti;
    }

    public int getCodAgen() {
        return codAgen;
    }

    public void setCodAgen(int codAgen) {
        this.codAgen = codAgen;
    }

    public int getCodAtk() {
        return codAtk;
    }

    public void setCodAtk(int codAtk) {
        this.codAtk = codAtk;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }
}
