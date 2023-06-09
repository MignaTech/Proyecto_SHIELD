package modelos;

public class Eq_lider {
    private int cod_eq,cod_lidr,mandro,auvola,sdvs,heli;

    public Eq_lider() {}

    public Eq_lider(int cod_eq, int mandro, int auvola, int sdvs, int heli) {
        setCod_eq(cod_eq);
        setMandro(mandro);
        setAuvola(auvola);
        setSdvs(sdvs);
        setHeli(heli);
    }

    public Eq_lider(int cod_eq,int cod_lidr, int mandro, int auvola, int sdvs, int heli) {
        setCod_eq(cod_eq);
        setCod_lidr(cod_lidr);
        setMandro(mandro);
        setAuvola(auvola);
        setSdvs(sdvs);
        setHeli(heli);
    }

    public int getCod_eq() {
        return cod_eq;
    }

    public void setCod_eq(int cod_eq) {
        this.cod_eq = cod_eq;
    }

    public int getCod_lidr() {
        return cod_lidr;
    }

    public void setCod_lidr(int cod_lidr) {
        this.cod_lidr = cod_lidr;
    }

    public int getMandro() {
        return mandro;
    }

    public void setMandro(int mandro) {
        this.mandro = mandro;
    }

    public int getAuvola() {
        return auvola;
    }

    public void setAuvola(int auvola) {
        this.auvola = auvola;
    }

    public int getSdvs() {
        return sdvs;
    }

    public void setSdvs(int sdvs) {
        this.sdvs = sdvs;
    }

    public int getHeli() {
        return heli;
    }

    public void setHeli(int heli) {
        this.heli = heli;
    }
}
