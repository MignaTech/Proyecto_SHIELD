package datos;
import modelos.GrupoSh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SuperHDAO {
    public static final String INSERTsql = "INSERT INTO grupo_sh (cod_gp_sp,n_gp) VALUES (?, ?)";
    public static final String UPDATEsql = "UPDATE grupo_sh SET n_gp = ? WHERE cod_gp_sp = ?";
    public static final String DELETEsql = "DELETE FROM grupo_sh WHERE cod_gp_sp = ?";
    public static final String FROMsql = "SELECT cod_gp_sp, n_gp FROM grupo_sh";
    public static final String WHEREsql = "SELECT cod_gp_sp, n_gp FROM grupo_sh WHERE cod_gp_sp = ?";
    public int addSuperH(GrupoSh elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodGpSp());
            ps.setString(2, elem.getnGp());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modSuperH(GrupoSh elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, elem.getnGp());
            ps.setInt(2, elem.getCodGpSp());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delSuperH(GrupoSh elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodGpSp());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<GrupoSh> getSuperHs() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        GrupoSh grupoSh = null;
        List<GrupoSh> elems = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("cod_gp_sp");
                String nombre = rs.getString("n_gp");
                grupoSh = new GrupoSh(codigo, nombre);
                elems.add(grupoSh);
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

    public GrupoSh getBySuperH(int codEq) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, codEq);
            rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("cod_gp_sp");
                String nombre = rs.getString("n_gp");
                return new GrupoSh(codigo, nombre);
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

    public int n_SuperHs() {
        int nuevo = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String query = "SELECT max(cod_gp_sp) AS iden FROM grupo_sh";
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
