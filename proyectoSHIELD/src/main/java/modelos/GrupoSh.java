package modelos;

import java.io.Serializable;

public class GrupoSh implements Serializable {
    private int codGpSp;
    private String nGp;

    public GrupoSh() {}

    public GrupoSh(int codGpSp, String nGp) {
        setCodGpSp(codGpSp);
        setnGp(nGp);
    }

    public int getCodGpSp() {
        return codGpSp;
    }

    public void setCodGpSp(int codGpSp) {
        this.codGpSp = codGpSp;
    }

    public String getnGp() {
        return nGp;
    }

    public void setnGp(String nGp) {
        this.nGp = nGp;
    }
}
