package modelos;

import java.io.Serializable;
import java.util.Date;

public class AgenJuntas implements Serializable {
    private int codAgen,codJunta;
    private String n_agente,n_junta;
    private Date fechaJ;
    public AgenJuntas(){}
    public AgenJuntas(int codAgen, int codJunta) {
        setCodAgen(codAgen);
        setCodJunta(codJunta);
    }

    public AgenJuntas(int codAgen, int codJunta, String n_agente, String n_junta) {
        setCodAgen(codAgen);
        setCodJunta(codJunta);
        setN_agente(n_agente);
        setN_junta(n_junta);
    }

    public AgenJuntas(int codAgen, int codJunta, String n_agente, String n_junta, Date fechaJ) {
        setCodAgen(codAgen);
        setCodJunta(codJunta);
        setN_agente(n_agente);
        setN_junta(n_junta);
        setFechaJ(fechaJ);
    }

    public int getCodAgen() {
        return codAgen;
    }

    public void setCodAgen(int codAgen) {
        this.codAgen = codAgen;
    }

    public int getCodJunta() {
        return codJunta;
    }

    public void setCodJunta(int codJunta) {
        this.codJunta = codJunta;
    }

    public String getN_agente() {
        return n_agente;
    }

    public void setN_agente(String n_agente) {
        this.n_agente = n_agente;
    }

    public String getN_junta() {
        return n_junta;
    }

    public void setN_junta(String n_junta) {
        this.n_junta = n_junta;
    }

    public Date getFechaJ() {
        return fechaJ;
    }

    public void setFechaJ(Date fechaJ) {
        this.fechaJ = fechaJ;
    }
}
