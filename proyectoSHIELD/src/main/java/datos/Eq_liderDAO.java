package datos;

import modelos.Eq_lider;
import modelos.Equipo;
import modelos.Lider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Eq_liderDAO {
    public static final String INSERTsql = "INSERT INTO eq_lider (cod_eq, cod_lider, mandro, auvola, sdvs, heli) " +
            "VALUES((SELECT (max(cod_eq))+1 FROM eq_lider), ?, ?, ?, ?, ?);";
    public static final String UPDATEsql = "UPDATE eq_lider SET mandro = ?, auvola = ?, sdvs = ?, heli = ? " +
            "WHERE cod_eq = ?";
    public static final String WHEREsql = "select el.cod_eq, el.mandro ,el.auvola ,el.sdvs ,el.heli \n" +
            "from eq_lider el\n" +
            "join lider l ON el.cod_lider = l.cod_lider\n" +
            "join usuario u on l.id_user = u.id_user\n" +
            "where u.nombre = ?";

    public int addLider(Eq_lider elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(INSERTsql);
            ps.setInt(1, elem.getCod_lidr());
            ps.setInt(2, elem.getMandro());
            ps.setInt(3, elem.getAuvola());
            ps.setInt(4, elem.getSdvs());
            ps.setInt(5, elem.getHeli());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public int modLider(Eq_lider elem) {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(UPDATEsql);
            ps.setInt(1, elem.getMandro());
            ps.setInt(2, elem.getAuvola());
            ps.setInt(3, elem.getSdvs());
            ps.setInt(4, elem.getHeli());
            ps.setInt(5, elem.getCod_eq());
            registros = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return registros;
    }

    public Eq_lider getEquipos(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(WHEREsql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                int cod_eq = rs.getInt("cod_eq");
                int mand = rs.getInt("mandro");
                int auvo = rs.getInt("auvola");
                int sdvs = rs.getInt("sdvs");
                int heli = rs.getInt("heli");
                return new Eq_lider(cod_eq,mand,auvo,sdvs,heli);
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
