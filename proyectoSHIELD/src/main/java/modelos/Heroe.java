package modelos;

import java.io.Serializable;

public class Heroe implements Serializable {
    private int codHeroe,codGp;
    private String nHeroe,poder,nombreGrupo;

    public Heroe() {}

    public Heroe(int codHeroe, String nHeroe, String poder, int codGp) {
        setCodHeroe(codHeroe);
        setnHeroe(nHeroe);
        setPoder(poder);
        setCodGp(codGp);
    }

    public Heroe(int codHeroe, String nHeroe, String poder, String nombreGrupo) {
        setCodHeroe(codHeroe);
        setnHeroe(nHeroe);
        setPoder(poder);
        setNombreGrupo(nombreGrupo);
    }

    public int getCodHeroe() {
        return codHeroe;
    }

    public void setCodHeroe(int codHeroe) {
        this.codHeroe = codHeroe;
    }

    public String getnHeroe() {
        return nHeroe;
    }

    public void setnHeroe(String nHeroe) {
        this.nHeroe = nHeroe;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public int getCodGp() {
        return codGp;
    }

    public void setCodGp(int codGp) {
        this.codGp = codGp;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
}
