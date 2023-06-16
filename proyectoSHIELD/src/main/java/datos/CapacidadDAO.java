package datos;

import modelos.Capacidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CapacidadDAO {
    public static final String INSERTsql = "INSERT INTO Capacidad (cod_cap,tp_cap) VALUES (?, ?)";
    public static final String UPDATEsql = "UPDATE Capacidad SET tp_cap = ? WHERE cod_cap = ?";
    public static final String DELETEsql = "DELETE FROM Capacidad WHERE cod_cap = ?";
    public static final String FROMsql = "SELECT cod_cap, tp_cap FROM Capacidad order by cod_cap";
    public static final String WHEREsql = "SELECT cod_cap, tp_cap FROM Capacidad WHERE cod_cap = ?";
    public int addCapacidad(Capacidad elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodCap());
            ps.setString(2, elem.getTpCap());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modCapacidad(Capacidad elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, elem.getTpCap());
            ps.setInt(2, elem.getCodCap());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delCapacidad(Capacidad elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodCap());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<Capacidad> getCapacidad() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Capacidad capacidad = null;
        List<Capacidad> elems = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("cod_cap");
                String nombre = rs.getString("tp_cap");
                capacidad = new Capacidad(codigo, nombre);
                elems.add(capacidad);
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

    public Capacidad getByCapacidad(int codEq) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, codEq);
            rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("cod_cap");
                String nombre = rs.getString("tp_cap");
                return new Capacidad(codigo, nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return null;
    }

    public int n_Capacidad() {
        int nuevo = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String query = "SELECT max(cod_cap) AS iden FROM capacidad";
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
