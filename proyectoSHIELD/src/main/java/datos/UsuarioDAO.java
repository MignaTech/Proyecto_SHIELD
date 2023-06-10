package datos;

import modelos.Rol;
import modelos.Usuario;
import java.sql.*;
public class UsuarioDAO {
    public static final String DELETEsql = "DELETE FROM usuario WHERE nombre = ?";
    public Usuario identifica(Usuario user) throws Exception{
        Usuario usuario = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT u.id_user, r.n_rol, a.cod_agen, l.cod_lider, d.cod_dir\n" +
                "FROM usuario u\n" +
                "left JOIN roles r ON u.rol = r.cod_rol\n" +
                "left join agentes a on u.id_user = a.id_user\n" +
                "left join lider l on u.id_user = l.id_user\n" +
                "left join director d on u.id_user = d.id_user\n" +
                "WHERE u.nombre = '"+user.getNombre()+"' AND u.contrasenia = '"+user.getContrasenia()+"'";
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Rol rol = new Rol(rs.getString("n_rol"));
                switch (rs.getString("n_rol")){
                    case "Agente":
                        rol.setCod_rol(rs.getInt("cod_agen"));
                        break;
                    case "Lider":
                        rol.setCod_rol(rs.getInt("cod_lider"));
                        break;
                    case "Director":
                        rol.setCod_rol(rs.getInt("cod_dir"));
                        break;
                }
                usuario = new Usuario(rs.getInt("id_user"), user.getNombre(), rol);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(st);
            Conexion.close(conn);
        }
        return usuario;
    }
    public int insert(Usuario u) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        String INSERTsql = "INSERT INTO usuario (nombre, rol, contrasenia) VALUES (?, ?, ?)";
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getF_rol());
            ps.setInt(3, u.getContrasenia());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                System.out.println("\nLA LLAVE FUE DUPLICADA\n");
                registros = 23505;
            } else {
                e.printStackTrace(System.out);
            }
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }
    public int delUsuario(String elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setString(1,elem);
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }
}
