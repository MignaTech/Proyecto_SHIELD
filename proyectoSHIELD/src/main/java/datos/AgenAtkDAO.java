package datos;

import modelos.AgenAtk;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenAtkDAO {
    public static final String INSERTsql = "INSERT INTO agen_atk (f_inco, f_reti, cod_agen, cod_atk) VALUES (?, ?,?, ?)";
    public static final String UPDATEsql = "UPDATE agen_atk SET f_inco=?, f_reti=? WHERE cod_agen=? AND cod_atk=?";
    public static final String DELETEsql = "DELETE FROM agen_atk WHERE cod_agen=? AND cod_atk=?";
    public static final String FROMsql = "SELECT aa.*, a.n_agen, a2.n_atk\n" +
            "FROM agen_atk aa\n" +
            "JOIN agentes a on a.cod_agen = aa.cod_agen\n" +
            "JOIN ataque a2 on a2.cod_atk = aa.cod_atk";
    public static final String FROMsql2 = "SELECT aa.*, a.n_agen, a2.n_atk\n" +
            "FROM agen_atk aa\n" +
            "JOIN agentes a on a.cod_agen = aa.cod_agen\n" +
            "JOIN ataque a2 on a2.cod_atk = aa.cod_atk\n" +
            "where a.n_agen = ?";
    public static final String WHEREsql = "SELECT f_inco, f_reti, cod_agen, cod_atk FROM agen_atk WHERE cod_agen=? AND cod_atk=?";

    public int addAgenAtk(AgenAtk elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setDate(1, elem.getfInco());
            ps.setDate(2, elem.getfReti());
            ps.setInt(3, elem.getCodAgen());
            ps.setInt(4, elem.getCodAtk());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modAgenAtk(AgenAtk elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setDate(1, elem.getfInco());
            ps.setDate(2, elem.getfReti());
            ps.setInt(3, elem.getCodAgen());
            ps.setInt(4, elem.getCodAtk());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delAgenAtk(AgenAtk elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodAgen());
            ps.setInt(2, elem.getCodAtk());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<AgenAtk> getAgenAtk() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AgenAtk elem = null;
        List<AgenAtk> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Date inicio = rs.getDate("f_inco");
                Date fin = rs.getDate("f_reti");
                int idagente = rs.getInt("cod_agen");
                int idataque = rs.getInt("cod_atk");
                String agente = rs.getString("n_agen");
                String ataque = rs.getString("n_atk");
                elem = new AgenAtk(inicio,fin,idagente,idataque,agente,ataque);
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

    public List<AgenAtk> idAgenAtk(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AgenAtk elem = null;
        List<AgenAtk> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql2);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                Date inicio = rs.getDate("f_inco");
                Date fin = rs.getDate("f_reti");
                int idagente = rs.getInt("cod_agen");
                int idataque = rs.getInt("cod_atk");
                String agente = rs.getString("n_agen");
                String ataque = rs.getString("n_atk");
                elem = new AgenAtk(inicio,fin,idagente,idataque,agente,ataque);
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

    public AgenAtk getByAgenAtk(int cod1,int cod2) {
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
                Date inicio = rs.getDate("f_inco");
                Date fin = rs.getDate("f_reti");
                int agente = rs.getInt("cod_agen");
                int ataque = rs.getInt("cod_atk");
                return new AgenAtk(inicio,fin,agente,ataque);
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
