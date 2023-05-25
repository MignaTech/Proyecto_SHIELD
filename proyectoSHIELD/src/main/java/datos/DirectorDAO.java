package datos;

import modelos.Director;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAO {
    public static final String INSERTsql = "INSERT INTO director (cod_dir,n_dir,rango_dir,lider) VALUES (?, ?,?, ?)";
    public static final String UPDATEsql = "UPDATE director SET n_dir = ?, rango_dir = ?, lider = ? WHERE cod_dir = ?";
    public static final String DELETEsql = "DELETE FROM director WHERE cod_dir = ?";
    public static final String FROMsql = "SELECT d.cod_dir, d.n_dir,d.rango_dir,l.n_lider\n" +
            "FROM director d\n" +
            "JOIN lider l ON l.cod_lider = d.lider";
    public static final String WHEREsql = "SELECT cod_dir,n_dir,rango_dir,lider FROM director WHERE cod_dir = ?";

    public int addDirector(Director elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodDir());
            ps.setString(2, elem.getnDir());
            ps.setString(3, elem.getRangoDir());
            ps.setInt(4, elem.getLider());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modDirector(Director elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, elem.getnDir());
            ps.setString(2, elem.getRangoDir());
            ps.setInt(3, elem.getLider());
            ps.setInt(4, elem.getCodDir());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delDirector(Director elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodDir());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<Director> getDirector() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Director elem = null;
        List<Director> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = Integer.parseInt(rs.getString("cod_dir"));
                String nombre = rs.getString("n_dir");
                String rango = rs.getString("rango_dir");
                String lider = rs.getString("n_lider");
                elem = new Director(codigo, nombre, rango, lider);
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

    public Director getByDirector(int cod) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = Integer.parseInt(rs.getString("cod_dir"));
                String nombre = rs.getString("n_dir");
                String rango = rs.getString("rango_dir");
                int lider = Integer.parseInt(rs.getString("lider"));
                return new Director(codigo, nombre,rango,lider);
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

    public int n_Director() {
        int nuevo = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT max(cod_dir) AS iden FROM director";
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
