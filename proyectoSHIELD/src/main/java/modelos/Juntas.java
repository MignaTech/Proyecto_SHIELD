package modelos;

import java.io.Serializable;
import java.sql.Date;

public class Juntas implements Serializable {
    private int codJunta,liderJ;
    private String contenido,lider;
    private Date fecha;
    public Juntas(){}
    public Juntas(int codJunta, String contenido, Date fecha, int liderJ) {
        setCodJunta(codJunta);
        setContenido(contenido);
        setFecha(fecha);
        setLiderJ(liderJ);
    }
    public Juntas(int codJunta, String contenido, Date fecha, String lider) {
        setCodJunta(codJunta);
        setContenido(contenido);
        setFecha(fecha);
        setLider(lider);
    }

    public int getCodJunta() {
        return codJunta;
    }

    public void setCodJunta(int codJunta) {
        this.codJunta = codJunta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getLiderJ() {
        return liderJ;
    }

    public void setLiderJ(int liderJ) {
        this.liderJ = liderJ;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }
}
