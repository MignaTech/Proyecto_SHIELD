package modelos;

import java.io.Serializable;

public class Subdivisiones implements Serializable {
    private int codSub,codshapoya;
    private String nSub;
    private int dirSub;
    public Subdivisiones(){}
    public Subdivisiones(int codSub, int codshapoya, String nSub, int dirSub) {
        setCodSub(codSub);
        setCodshapoya(codshapoya);
        setnSub(nSub);
        setDirSub(dirSub);
    }

    public int getCodSub() {
        return codSub;
    }

    public void setCodSub(int codSub) {
        this.codSub = codSub;
    }

    public int getCodshapoya() {
        return codshapoya;
    }

    public void setCodshapoya(int codshapoya) {
        this.codshapoya = codshapoya;
    }

    public String getnSub() {
        return nSub;
    }

    public void setnSub(String nSub) {
        this.nSub = nSub;
    }

    public int getDirSub() {
        return dirSub;
    }

    public void setDirSub(int dirSub) {
        this.dirSub = dirSub;
    }
}
