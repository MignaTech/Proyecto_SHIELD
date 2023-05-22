package modelos;

import java.io.Serializable;

public class Paises implements Serializable {
    private String codPais,nPais;

    public Paises() {}

    public Paises(String codPais, String nPais) {
        setCodPais(codPais);
        setnPais(nPais);
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getnPais() {
        return nPais;
    }

    public void setnPais(String nPais) {
        this.nPais = nPais;
    }
}
