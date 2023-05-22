package datos;
import modelos.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    public static final String INSERTsql = "INSERT INTO equipo (cod_eq,n_eq) VALUES (?, ?)";
    public static final String UPDATEsql = "UPDATE equipo SET n_eq = ? WHERE cod_eq = ?";
    public static final String DELETEsql = "DELETE FROM equipo WHERE cod_eq = ?";
    public static final String FROMsql = "SELECT cod_eq, n_eq FROM equipo";
    public static final String WHEREsql = "SELECT cod_eq, n_eq FROM equipo WHERE cod_eq = ?";
    public int addEquipo(Equipo equipo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, equipo.getCodEq());
            ps.setString(2, equipo.getnEq());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }
    public int modEquipo(Equipo equipoModificado) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, equipoModificado.getnEq());
            ps.setInt(2, equipoModificado.getCodEq());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delEquipo(Equipo equipo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, equipo.getCodEq());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }
    public List<Equipo> getEquipos() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Equipo equipo = null;
        List<Equipo> equipos = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("cod_eq");
                String nombre = rs.getString("n_eq");
                equipo = new Equipo(codigo, nombre);
                equipos.add(equipo);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return equipos;
    }
    public Equipo getByEquipo(int codEq) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, codEq);
            rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("cod_eq");
                String nombre = rs.getString("n_eq");
                return new Equipo(codigo, nombre);
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
