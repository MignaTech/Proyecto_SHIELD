package datos;

import modelos.Ataque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtaqueDAO {
    public static final String INSERTsql = "INSERT INTO ataque (cod_atk,n_atk,nro_bajas,nro_heridos,pais_atk) VALUES (?, ?,?,?,?)";
    public static final String UPDATEsql = "UPDATE ataque SET n_atk = ?,nro_bajas = ?,nro_heridos = ?, pais_atk = ? WHERE cod_atk = ?";
    public static final String DELETEsql = "DELETE FROM ataque WHERE cod_atk = ?";
    public static final String FROMsql = "SELECT a.cod_atk, a.n_atk, a.nro_bajas, a.nro_heridos, a.pais_atk,  p.n_pais\n" +
            "FROM ataque a\n" +
            "JOIN paises p ON a.pais_atk = p.cod_pais\n" +
            "ORDER BY a.cod_atk";
    public static final String WHEREsql = "SELECT a.cod_atk, a.n_atk, a.nro_bajas, a.nro_heridos, a.pais_atk,  p.n_pais\n" +
            "FROM ataque a\n" +
            "JOIN paises p ON a.pais_atk = p.cod_pais\n" +
            "WHERE cod_atk = ?";

    public int addAtaque(Ataque elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodAtk());
            ps.setString(2, elem.getnAtk());
            ps.setInt(3, elem.getNroBajas());
            ps.setInt(4, elem.getNroHeridos());
            ps.setString(5, elem.getPaisAtk());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modAtaque(Ataque elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, elem.getnAtk());
            ps.setInt(2, elem.getNroBajas());
            ps.setInt(3, elem.getNroHeridos());
            ps.setString(4, elem.getPaisAtk());
            ps.setInt(5, elem.getCodAtk());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delAtaque(Ataque elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodAtk());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<Ataque> getAtaque() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Ataque elem = null;
        List<Ataque> elems = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("cod_atk");
                String nombre = rs.getString("n_atk");
                int nBajas = rs.getInt("nro_bajas");
                int nHeridos = rs.getInt("nro_heridos");
                String pais = rs.getString("pais_atk");
                String n_pais = rs.getString("n_pais");
                elem = new Ataque(codigo, nombre,nBajas,nHeridos,pais,n_pais);
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

    public Ataque getByAtaque(int cod) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("cod_atk");
                String nombre = rs.getString("n_atk");
                int nBajas = rs.getInt("nro_bajas");
                int nHeridos = rs.getInt("nro_heridos");
                String pais = rs.getString("pais_atk");
                String n_pais = rs.getString("n_pais");
                return new Ataque(codigo, nombre,nBajas,nHeridos,pais,n_pais);
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
