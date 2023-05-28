package datos;

import modelos.SiSh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiShDAO {
    public static final String INSERTsql = "INSERT INTO si_sh (rfc,n_ceo,cod_gp_sh) VALUES (?, ?, ?)";
    public static final String UPDATEsql = "UPDATE si_sh SET n_ceo = ?, cod_gp_sh = ? WHERE rfc = ?";
    public static final String DELETEsql = "DELETE FROM si_sh WHERE rfc = ?";
    public static final String FROMsql = "SELECT sh.rfc,sh.n_ceo, gs.n_gp\n" +
            "FROM si_sh sh\n" +
            "JOIN grupo_sh gs ON gs.cod_gp_sp = sh.cod_gp_sh";
    public static final String WHEREsql = "SELECT rfc,n_ceo,cod_gp_sh FROM si_sh WHERE rfc = ?";

    public int addSiSh(SiSh elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setString(1, elem.getRfc());
            ps.setString(2, elem.getnCeo());
            ps.setInt(3, elem.getCodGpSh());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modSiSh(SiSh elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, elem.getnCeo());
            ps.setInt(2, elem.getCodGpSh());
            ps.setString(3, elem.getRfc());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delSiSh(SiSh elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setString(1, elem.getRfc());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<SiSh> getSiSh() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SiSh elem = null;
        List<SiSh> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("rfc");
                String nombre = rs.getString("n_ceo");
                String grupo = rs.getString("n_gp");
                elem = new SiSh(codigo, nombre, grupo);
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

    public SiSh getBySiSh(String cod) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                String codigo = rs.getString("rfc");
                String nombre = rs.getString("n_ceo");
                int grupo = rs.getInt("cod_gp_sh");
                return new SiSh(codigo, nombre, grupo);
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
