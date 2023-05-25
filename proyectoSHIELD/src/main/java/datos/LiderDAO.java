package datos;

import modelos.Lider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LiderDAO {
    public static final String INSERTsql = "INSERT INTO lider (cod_lider,cod_gp_sh,n_lider) VALUES (?, ?, ?)";
    public static final String UPDATEsql = "UPDATE lider SET cod_gp_sh = ?, n_lider = ? WHERE cod_lider = ?";
    public static final String DELETEsql = "DELETE FROM lider WHERE cod_lider = ?";
    public static final String FROMsql = "SELECT l.cod_lider, gs.n_gp, l.n_lider\n" +
            "FROM lider l\n" +
            "JOIN grupo_sh gs ON gs.cod_gp_sp = l.cod_gp_sh";
    public static final String WHEREsql = "SELECT cod_lider,cod_gp_sh,n_lider FROM lider WHERE cod_lider = ?";

    public int addLider(Lider elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodLider());
            ps.setInt(2, elem.getCodGpSh());
            ps.setString(3, elem.getnLider());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modLider(Lider elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setInt(1, elem.getCodGpSh());
            ps.setString(2, elem.getnLider());
            ps.setInt(3, elem.getCodLider());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delLider(Lider elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodLider());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<Lider> getLider() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Lider elem = null;
        List<Lider> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("cod_lider");
                String grupo = rs.getString("n_gp");
                String nombre = rs.getString("n_lider");
                elem = new Lider(codigo, grupo, nombre);
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

    public Lider getByLider(int cod) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("cod_lider");
                int grupo = rs.getInt("cod_gp_sh");
                String nombre = rs.getString("n_lider");
                return new Lider(codigo, grupo, nombre);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return null;
    }

    public int n_Lider() {
        int nuevo = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT max(cod_lider) AS iden FROM lider";
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
