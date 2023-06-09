package modelos;

public class Rol {
    private int cod_rol;
    private String n_rol;

    public Rol() {}

    public Rol(String n_rol) {
        this.n_rol = n_rol;
    }

    public int getCod_rol() {
        return cod_rol;
    }

    public void setCod_rol(int cod_rol) {
        this.cod_rol = cod_rol;
    }

    public String getN_rol() {
        return n_rol;
    }

    public void setN_rol(String n_rol) {
        this.n_rol = n_rol;
    }
}
