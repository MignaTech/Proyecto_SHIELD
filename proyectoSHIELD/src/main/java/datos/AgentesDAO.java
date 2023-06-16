package datos;

import modelos.Agentes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentesDAO {
    public static final String INSERTsql = "INSERT INTO agentes (cod_agen,n_agen,espe,tp_ayuda,agen_dir,id_user) " +
            "VALUES (?,?,?,?,?,(SELECT (max(id_user)) FROM usuario))";
//    public static final String INSERTsql = "INSERT INTO agentes (cod_agen,n_agen,espe,tp_ayuda,agen_dir) VALUES (?, ?,?, ?,?)";
    public static final String UPDATEsql = "UPDATE agentes SET n_agen = ?,espe = ?,tp_ayuda = ?,agen_dir = ? WHERE cod_agen = ?";
    public static final String DELETEsql = "DELETE FROM agentes WHERE cod_agen = ?";
    public static final String FROMsql = "SELECT a.cod_agen,a.n_agen,a.espe,a.tp_ayuda,a.agen_dir, a2.n_agen AS n_Dir\n" +
            "FROM agentes a\n" +
            "join agentes a2 on a.agen_dir = a2.cod_agen\n" +
            "ORDER BY a.cod_agen";
    public static final String WHEREsql = "SELECT a.cod_agen,a.n_agen,a.espe,a.tp_ayuda,a.agen_dir, a2.n_agen AS n_Dir\n" +
            "FROM agentes a\n" +
            "join agentes a2 on a.agen_dir = a2.cod_agen\n" +
            "WHERE a.cod_agen = ?";

    public int addAgentes(Agentes elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodAgen());
            ps.setString(2, elem.getnAgen());
            ps.setString(3, elem.getEspe());
            ps.setString(4, elem.getTpAyuda());
            ps.setInt(5, elem.getAgenDir());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modAgentes(Agentes elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, elem.getnAgen());
            ps.setString(2, elem.getEspe());
            ps.setString(3, elem.getTpAyuda());
            ps.setInt(4, elem.getAgenDir());
            ps.setInt(5, elem.getCodAgen());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delAgentes(Agentes elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodAgen());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<Agentes> getAgentes() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Agentes elem = null;
        List<Agentes> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("cod_agen");
                String nombre = rs.getString("n_agen");
                String especi = rs.getString("espe");
                String t_ayuda = rs.getString("tp_ayuda");
                int dirid = rs.getInt("agen_dir");
                String dir = rs.getString("n_Dir");
                elem = new Agentes(codigo,nombre,especi,t_ayuda,dirid,dir);
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

    public Agentes getByAgentes(int cod) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("cod_agen");
                String nombre = rs.getString("n_agen");
                String especi = rs.getString("espe");
                String t_ayuda = rs.getString("tp_ayuda");
                int dir = rs.getInt("agen_dir");
                String direc = rs.getString("n_Dir");
                return new Agentes(codigo,nombre,especi,t_ayuda,dir,direc);
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

    public int n_Agentes() {
        int nuevo = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String query = "SELECT max(cod_agen) AS iden FROM agentes";
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
