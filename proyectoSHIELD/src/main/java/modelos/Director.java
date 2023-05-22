package modelos;

import java.io.Serializable;

public class Director implements Serializable {
    private int codDir,lider;
    private String nDir,rangoDir,n_lider;
    public Director(){}
    public Director(int codDir, String nDir, String rangoDir, int lider) {
        setCodDir(codDir);
        setnDir(nDir);
        setRangoDir(rangoDir);
        setLider(lider);
    }
    public Director(int codDir, String nDir, String rangoDir, String n_lider) {
        setCodDir(codDir);
        setnDir(nDir);
        setRangoDir(rangoDir);
        setN_lider(n_lider);
    }

    public int getCodDir() {
        return codDir;
    }

    public void setCodDir(int codDir) {
        this.codDir = codDir;
    }

    public String getnDir() {
        return nDir;
    }

    public void setnDir(String nDir) {
        this.nDir = nDir;
    }

    public String getRangoDir() {
        return rangoDir;
    }

    public void setRangoDir(String rangoDir) {
        this.rangoDir = rangoDir;
    }

    public int getLider() {
        return lider;
    }

    public void setLider(int lider) {
        this.lider = lider;
    }

    public String getN_lider() {
        return n_lider;
    }

    public void setN_lider(String n_lider) {
        this.n_lider = n_lider;
    }
}
