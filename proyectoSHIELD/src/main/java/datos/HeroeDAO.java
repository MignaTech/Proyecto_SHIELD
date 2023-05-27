package datos;
import modelos.Heroe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroeDAO {
    public static final String INSERTsql = "INSERT INTO heroe (cod_heroe,n_heroe,poder,cod_gp) VALUES (?, ?, ?, ?)";
    public static final String UPDATEsql = "UPDATE heroe SET n_heroe = ?, poder = ?,cod_gp = ? WHERE cod_heroe = ?";
    public static final String DELETEsql = "DELETE FROM heroe WHERE cod_heroe = ?";
    public static final String WHEREsql = "SELECT cod_heroe,n_heroe,poder,cod_gp FROM heroe WHERE cod_heroe = ?";
    public static final String FROMsql = "SELECT h.cod_heroe , h.n_heroe ,h.poder , gs.n_gp\n" +
            "FROM heroe h\n" +
            "join grupo_sh gs on h.cod_gp = gs.cod_gp_sp\n" +
            "LIMIT ? OFFSET ?";
    public int addHeroe(Heroe elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCodHeroe());
            ps.setString(2, elem.getnHeroe());
            ps.setString(3, elem.getPoder());
            ps.setInt(4, elem.getCodGp());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modHeroe(Heroe elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setString(1, elem.getnHeroe());
            ps.setString(2, elem.getPoder());
            ps.setInt(3, elem.getCodGp());
            ps.setInt(4, elem.getCodHeroe());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int delHeroe(Heroe elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros=0;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(DELETEsql);
            ps.setInt(1, elem.getCodHeroe());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public List<Heroe> getHeroes(int nro_pagina, int regis_pagina) {
        List<Heroe> registros = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Heroe elem = null;
        try{
            int startIndex = (nro_pagina - 1) * regis_pagina;
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(FROMsql);
            ps.setInt(1,regis_pagina);
            ps.setInt(2,startIndex);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("cod_heroe");
                String nombre = rs.getString("n_heroe");
                String poder = rs.getString("poder");
                String grupo = rs.getString("n_gp");
                elem = new Heroe(codigo, nombre, poder, grupo);
                registros.add(elem);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }
    public int countHeroe() {
        int totalRecords = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String query = "SELECT COUNT(*) AS total FROM heroe";
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalRecords = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return totalRecords;
    }

    public Heroe getByHeroe(int codEq) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setInt(1, codEq);
            rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("cod_heroe");
                String nombre = rs.getString("n_heroe");
                String poder = rs.getString("poder");
                int cod_gp = rs.getInt("cod_gp");
                return new Heroe(codigo, nombre, poder, cod_gp);
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
