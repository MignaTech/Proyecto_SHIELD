package datos;

import modelos.Paises;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PaisesDAO {
    public static final String INSERTsql = "INSERT INTO paises (cod_pais,n_pais) VALUES (?, ?)";
    public static final String UPDATEsql = "UPDATE paises SET n_pais = ? WHERE cod_pais = ?";
    public static final String DELETEsql = "DELETE FROM paises WHERE cod_pais = ?";
    public static final String FROMsql = "SELECT cod_pais, n_pais FROM paises";
    public static final String WHEREsql = "SELECT cod_pais, n_pais FROM paises WHERE cod_pais = ?";

    public int addPaises(Paises elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setString(1, elem.getCodPais());
            ps.setString(2, elem.getnPais());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062)
                System.out.println("La llave está duplicada.");
            else
                e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modPaises(Paises elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, elem.getnPais());
            ps.setString(2, elem.getCodPais());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delPaises(Paises elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setString(1, elem.getCodPais());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<Paises> getPaisess() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Paises paises = null;
        List<Paises> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("cod_pais");
                String nombre = rs.getString("n_pais");
                paises = new Paises(codigo, nombre);
                elems.add(paises);
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

    public Paises getByPaises(String cod) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                String codigo = rs.getString("cod_pais");
                String nombre = rs.getString("n_pais");
                return new Paises(codigo, nombre);
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
