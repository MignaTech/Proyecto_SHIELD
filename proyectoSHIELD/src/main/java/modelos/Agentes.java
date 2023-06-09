package modelos;

import java.io.Serializable;

public class Agentes implements Serializable {
    private int codAgen;
    private String nAgen,espe,tpAyuda;
    private int agenDir,idUsuario;
    private String nombreDir;
    public Agentes () {}
    public Agentes(int codAgen, String nAgen, String espe, String tpAyuda, int agenDir) {
        setCodAgen(codAgen);
        setnAgen(nAgen);
        setEspe(espe);
        setTpAyuda(tpAyuda);
        setAgenDir(agenDir);
    }

    public Agentes(int codAgen, String nAgen, String espe, String tpAyuda, int agenDir, int idUsuario) {
        setCodAgen(codAgen);
        setnAgen(nAgen);
        setEspe(espe);
        setTpAyuda(tpAyuda);
        setAgenDir(agenDir);
        setIdUsuario(idUsuario);
    }

    public Agentes(int codAgen, String nAgen, String espe, String tpAyuda, int agenDir, String nombreDir) {
        setCodAgen(codAgen);
        setnAgen(nAgen);
        setEspe(espe);
        setTpAyuda(tpAyuda);
        setAgenDir(agenDir);
        setNombreDir(nombreDir);
    }

    public Agentes(int codAgen, String nAgen, String espe, String tpAyuda, String nombreDir) {
        setCodAgen(codAgen);
        setnAgen(nAgen);
        setEspe(espe);
        setTpAyuda(tpAyuda);
        setNombreDir(nombreDir);
    }

    public int getCodAgen() {
        return codAgen;
    }

    public void setCodAgen(int codAgen) {
        this.codAgen = codAgen;
    }

    public String getnAgen() {
        return nAgen;
    }

    public void setnAgen(String nAgen) {
        this.nAgen = nAgen;
    }

    public String getEspe() {
        return espe;
    }

    public void setEspe(String espe) {
        this.espe = espe;
    }

    public String getTpAyuda() {
        return tpAyuda;
    }

    public void setTpAyuda(String tpAyuda) {
        this.tpAyuda = tpAyuda;
    }

    public int getAgenDir() {
        return agenDir;
    }

    public void setAgenDir(int agenDir) {
        this.agenDir = agenDir;
    }

    public String getNombreDir() {
        return nombreDir;
    }

    public void setNombreDir(String nombreDir) {
        this.nombreDir = nombreDir;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
