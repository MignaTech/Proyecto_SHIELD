package datos;

import modelos.Juntas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JuntasDAO {
    public static final String INSERTsql = "INSERT INTO juntas (cod_junta,contenido,fecha,lider_j) VALUES (?, ?,?, ?)";
    public static final String UPDATEsql = "UPDATE juntas SET contenido = ?,fecha = ?,lider_j = ? WHERE cod_junta = ?";
    public static final String DELETEsql = "DELETE FROM juntas WHERE cod_junta = ?";
    public static final String FROMsql = "SELECT j.cod_junta,j.contenido,j.fecha, l.n_lider\n" +
            "FROM juntas j\n" +
            "JOIN lider l on l.cod_lider = j.lider_j";
    public static final String WHEREsql = "SELECT cod_junta,contenido,fecha,lider_j FROM juntas WHERE cod_junta = ?";

    public int addJuntas(Juntas elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodJunta());
            ps.setString(2, elem.getContenido());
            ps.setDate(3, elem.getFecha());
            ps.setInt(4, elem.getLiderJ());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modJuntas(Juntas elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, elem.getContenido());
            ps.setDate(2, elem.getFecha());
            ps.setInt(3, elem.getLiderJ());
            ps.setInt(4, elem.getCodJunta());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delJuntas(Juntas elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodJunta());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<Juntas> getJuntas() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Juntas elem = null;
        List<Juntas> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("cod_junta");
                String nombre = rs.getString("contenido");
                Date fecha = rs.getDate("fecha");
                String lider = rs.getString("n_lider");
                elem = new Juntas(codigo, nombre,fecha,lider);
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

    public Juntas getByJuntas(int cod) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("cod_junta");
                String nombre = rs.getString("contenido");
                Date fecha = rs.getDate("fecha");
                int lider = rs.getInt("lider_j");
                return new Juntas(codigo, nombre,fecha,lider);
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

    public int n_Juntas() {
        int nuevo = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT max(cod_junta) AS iden FROM juntas";
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
