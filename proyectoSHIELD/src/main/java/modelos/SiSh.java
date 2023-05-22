package modelos;

import java.io.Serializable;

public class SiSh implements Serializable {
    private String rfc,nCeo,grupo;
    private int codGpSh;
    public SiSh(){}
    public SiSh(String rfc, String nCeo, int codGpSh) {
        setRfc(rfc);
        setnCeo(nCeo);
        setCodGpSh(codGpSh);
    }

    public SiSh(String rfc, String nCeo, String grupo) {
        setRfc(rfc);
        setnCeo(nCeo);
        setGrupo(grupo);
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getnCeo() {
        return nCeo;
    }

    public void setnCeo(String nCeo) {
        this.nCeo = nCeo;
    }

    public int getCodGpSh() {
        return codGpSh;
    }

    public void setCodGpSh(int codGpSh) {
        this.codGpSh = codGpSh;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
