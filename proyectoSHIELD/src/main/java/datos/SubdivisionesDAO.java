package datos;

import modelos.Subdivisiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubdivisionesDAO {
    public static final String INSERTsql = "INSERT INTO subdivisiones (cod_sub, codshapoya, n_sub, dir_sub) " +
            "VALUES (?,?,?,?)";
    public static final String FROMsql = "SELECT s.*, gs.n_gp, d.n_dir " +
            "FROM subdivisiones s JOIN grupo_sh gs ON s.codshapoya = gs.cod_gp_sp " +
            "JOIN director d ON s.dir_sub = d.cod_dir";
    public static final String WHEREsql = "SELECT s.*, gs.n_gp, d.n_dir " +
            "FROM subdivisiones s JOIN grupo_sh gs ON s.codshapoya = gs.cod_gp_sp " +
            "JOIN director d ON s.dir_sub = d.cod_dir " +
            "WHERE s.dir_sub = ?";

    public int addSubdivisiones(Subdivisiones elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodSub());
            ps.setInt(2, elem.getCodshapoya());
            ps.setString(3, elem.getnSub());
            ps.setInt(4, elem.getDirSub());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<Subdivisiones> getSubdivisiones() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Subdivisiones elem = null;
        List<Subdivisiones> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int cod_sub = rs.getInt("cod_sub");
                int codshapoya = rs.getInt("codshapoya");
                String n_sub = rs.getString("n_sub");
                int dir_sub = rs.getInt("dir_sub");
                String n_gp = rs.getString("n_gp");
                String n_dir = rs.getString("n_dir");
                elem = new Subdivisiones(cod_sub,codshapoya,n_sub,dir_sub,n_gp,n_dir);
                elems.add(elem);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return elems;
    }

    public List<Subdivisiones> getBySubdivisiones(int cod) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Subdivisiones elem = null;
        List<Subdivisiones> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            while (rs.next()) {
                int cod_sub = rs.getInt("cod_sub");
                int codshapoya = rs.getInt("codshapoya");
                String n_sub = rs.getString("n_sub");
                int dir_sub = rs.getInt("dir_sub");
                elem = new Subdivisiones(cod_sub,codshapoya,n_sub,dir_sub);
                elems.add(elem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return elems;
    }

    public Subdivisiones getBy(int cod) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Subdivisiones elem = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                int cod_sub = rs.getInt("cod_sub");
                int codshapoya = rs.getInt("codshapoya");
                String n_sub = rs.getString("n_sub");
                int dir_sub = rs.getInt("dir_sub");
                String grupo = rs.getString("n_gp");
                String n_dir = rs.getString("n_dir");
                elem = new Subdivisiones(cod_sub,codshapoya,n_sub,dir_sub,grupo,n_dir);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return elem;
    }

    public int n_Subdivisiones() {
        int nuevo = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT max(cod_sub) AS iden FROM subdivisiones";
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                nuevo = rs.getInt("iden");
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return nuevo;
    }
}
