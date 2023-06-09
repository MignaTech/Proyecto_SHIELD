package modelos;

import java.io.Serializable;

public class Ataque implements Serializable {
    private int codAtk,nroBajas,nroHeridos;
    private String nAtk,paisAtk,n_pais;
    public Ataque(){}
    public Ataque(int codAtk) {
        setCodAtk(codAtk);
    }
    public Ataque(int codAtk, String nAtk, int nroBajas, int nroHeridos, String paisAtk) {
        setCodAtk(codAtk);
        setnAtk(nAtk);
        setNroBajas(nroBajas);
        setNroHeridos(nroHeridos);
        setPaisAtk(paisAtk);
    }

    public Ataque(int codAtk, String nAtk, int nroBajas, int nroHeridos, String paisAtk, String n_pais) {
        setCodAtk(codAtk);
        setnAtk(nAtk);
        setNroBajas(nroBajas);
        setNroHeridos(nroHeridos);
        setPaisAtk(paisAtk);
        setN_pais(n_pais);
    }

    public int getCodAtk() {
        return codAtk;
    }

    public void setCodAtk(int codAtk) {
        this.codAtk = codAtk;
    }

    public String getnAtk() {
        return nAtk;
    }

    public void setnAtk(String nAtk) {
        this.nAtk = nAtk;
    }

    public int getNroBajas() {
        return nroBajas;
    }

    public void setNroBajas(int nroBajas) {
        this.nroBajas = nroBajas;
    }

    public int getNroHeridos() {
        return nroHeridos;
    }

    public void setNroHeridos(int nroHeridos) {
        this.nroHeridos = nroHeridos;
    }

    public String getPaisAtk() {
        return paisAtk;
    }

    public void setPaisAtk(String paisAtk) {
        this.paisAtk = paisAtk;
    }

    public String getN_pais() {
        return n_pais;
    }

    public void setN_pais(String n_pais) {
        this.n_pais = n_pais;
    }
}
