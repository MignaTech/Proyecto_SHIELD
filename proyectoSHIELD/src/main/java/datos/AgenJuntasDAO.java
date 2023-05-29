package datos;

import modelos.AgenJuntas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenJuntasDAO {
    public static final String INSERTsql = "INSERT INTO agen_juntas (cod_agen,cod_junta) VALUES (?, ?)";
    public static final String DELETEsql = "DELETE FROM agen_juntas WHERE cod_agen=? AND cod_junta=?";
    public static final String FROMsql = "SELECT aj.cod_agen, aj.cod_junta,a.n_agen,j.contenido,j.fecha\n" +
            "FROM agen_juntas aj\n" +
            "JOIN agentes a on a.cod_agen = aj.cod_agen\n" +
            "JOIN juntas j on aj.cod_junta = j.cod_junta\n" +
            "ORDER BY j.fecha";
    public static final String WHEREsql = "SELECT aj.cod_agen, aj.cod_junta,a.n_agen,j.contenido,j.fecha\n" +
            "FROM agen_juntas aj\n" +
            "JOIN agentes a on a.cod_agen = aj.cod_agen\n" +
            "JOIN juntas j on aj.cod_junta = j.cod_junta\n" +
            "WHERE aj.cod_agen=? AND aj.cod_junta=?";

    public int addAgenJuntas(AgenJuntas elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodAgen());
            ps.setInt(2, elem.getCodJunta());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delAgenJuntas(AgenJuntas elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodAgen());
            ps.setInt(2, elem.getCodJunta());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<AgenJuntas> getAgenJuntas() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AgenJuntas elem = null;
        List<AgenJuntas> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int c_agen = rs.getInt("cod_agen");
                int c_junta = rs.getInt("cod_junta");
                String agente = rs.getString("n_agen");
                String junta = rs.getString("contenido");
                Date fecha = rs.getDate("fecha");
                elem = new AgenJuntas(c_agen, c_junta, agente, junta, fecha);
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

    public AgenJuntas getByAgenJuntas(int cod1, int cod2) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, cod1);
            ps.setInt(2, cod2);
            rs = ps.executeQuery();
            if (rs.next()) {
                int c_agen = rs.getInt("cod_agen");
                int c_junta = rs.getInt("cod_junta");
                String agente = rs.getString("n_agen");
                String junta = rs.getString("contenido");
                Date fecha = rs.getDate("fecha");
                return new AgenJuntas(c_agen, c_junta, agente, junta, fecha);
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
}
