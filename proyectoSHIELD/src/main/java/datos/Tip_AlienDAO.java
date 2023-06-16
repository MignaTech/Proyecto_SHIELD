package datos;

import modelos.TpAlien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tip_AlienDAO {
    public static final String INSERTsql = "INSERT INTO tp_alien (cod_alien,raza_alien) VALUES (?, ?)";
    public static final String UPDATEsql = "UPDATE tp_alien SET raza_alien = ? WHERE cod_alien = ?";
    public static final String DELETEsql = "DELETE FROM tp_alien WHERE cod_alien = ?";
    public static final String FROMsql = "SELECT cod_alien,raza_alien FROM tp_alien";
    public static final String WHEREsql = "SELECT cod_alien,raza_alien FROM tp_alien WHERE cod_alien = ?";

    public int addTip_Alien(TpAlien elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodAlien());
            ps.setString(2, elem.getRazaAlien());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modTpAlien(TpAlien elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, elem.getRazaAlien());
            ps.setInt(2, elem.getCodAlien());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delTpAlien(TpAlien elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodAlien());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<TpAlien> getTpAlien() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TpAlien elem = null;
        List<TpAlien> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("cod_alien");
                String nombre = rs.getString("raza_alien");
                elem = new TpAlien(codigo, nombre);
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

    public TpAlien getByTpAlien(int cod) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("cod_alien");
                String nombre = rs.getString("raza_alien");
                return new TpAlien(codigo, nombre);
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
    public int n_TpAlien() {
        int nuevo = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String query = "SELECT max(cod_alien) AS iden FROM tp_alien";
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
