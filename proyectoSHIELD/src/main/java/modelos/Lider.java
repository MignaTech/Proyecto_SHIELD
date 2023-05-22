package modelos;

import java.io.Serializable;

public class Lider implements Serializable {
    private int codLider,codGpSh;
    private String nLider, grupo;

    public Lider(){}
    public Lider(int codLider, int codGpSh, String nLider) {
        setCodLider(codLider);
        setCodGpSh(codGpSh);
        setnLider(nLider);
    }

    public Lider(int codLider, String grupo, String nLider) {
        setCodLider(codLider);
        setGrupo(grupo);
        setnLider(nLider);
    }

    public int getCodLider() {
        return codLider;
    }

    public void setCodLider(int codLider) {
        this.codLider = codLider;
    }

    public int getCodGpSh() {
        return codGpSh;
    }

    public void setCodGpSh(int codGpSh) {
        this.codGpSh = codGpSh;
    }

    public String getnLider() {
        return nLider;
    }

    public void setnLider(String nLider) {
        this.nLider = nLider;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
