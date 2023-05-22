package modelos;

import java.io.Serializable;

public class SiArma implements Serializable {
    private int nroSerie,cantArm,capArm;
    private String siRfc;
    public SiArma(){}
    public SiArma(int nroSerie, int cantArm, int capArm, String siRfc) {
        setNroSerie(nroSerie);
        setCantArm(cantArm);
        setCapArm(capArm);
        setSiRfc(siRfc);
    }

    public int getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(int nroSerie) {
        this.nroSerie = nroSerie;
    }

    public int getCantArm() {
        return cantArm;
    }

    public void setCantArm(int cantArm) {
        this.cantArm = cantArm;
    }

    public int getCapArm() {
        return capArm;
    }

    public void setCapArm(int capArm) {
        this.capArm = capArm;
    }

    public String getSiRfc() {
        return siRfc;
    }

    public void setSiRfc(String siRfc) {
        this.siRfc = siRfc;
    }
}
