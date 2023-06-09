package modelos;

public class Usuario {

    private int id_User,contrasenia,f_rol;
    private String nombre;
    private Rol rol;

    public Usuario() {}

    public Usuario(String nombre, String contrasena) {
        setNombre(nombre);
        setContrasenia(contrasena);
    }

    public Usuario(String nombre, String contrasena, int f_rol) {
        setNombre(nombre);
        setContrasenia(contrasena);
        setF_rol(f_rol);
    }

    public Usuario(int id_User, String nombre, Rol rol) {
        setId_User(id_User);
        setNombre(nombre);
        setRol(rol);
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        if (contrasenia != null) {
            this.contrasenia = contrasenia.hashCode();
        } else {
            this.contrasenia = 0;
        }
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getF_rol() {
        return f_rol;
    }

    public void setF_rol(int f_rol) {
        this.f_rol = f_rol;
    }
}