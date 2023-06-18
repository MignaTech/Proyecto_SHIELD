package Controlador;

import datos.AtaqueDAO;
import datos.Conexion;
import datos.PaisesDAO;
import modelos.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AtaqueSV", value = {"/AtaqueSV"})
public class AtaqueSV extends HttpServlet {

    AtaqueDAO ataqueDAO = new AtaqueDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<Ataque> ataques = ataqueDAO.getAtaque();
                rq.setAttribute("ataques", ataques);
                rq.getRequestDispatcher("./views/Ataque/listaAtaque.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                List<Paises> paises = new PaisesDAO().getPaisess();
                rq.setAttribute("paises", paises);
                rq.getRequestDispatcher("./views/Ataque/agregarAtaque.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                Ataque ataque = ataqueDAO.getByAtaque(codigo);
                if (ataque != null) {
                    rq.setAttribute("ataque", ataque);
                    rq.getRequestDispatcher("./views/Ataque/modificarAtaque.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("AtaqueSV?action=list");
                }
                break;

            case "showDetail":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                String WHEREsql = "SELECT a.*, p.n_pais ,it.region_afec ,m.grup_involu ,m.mutan_afec ,e.bien_dispu " +
                        "FROM ataque a LEFT JOIN invasion_terri it ON a.cod_atk = it.cod_atk " +
                        "LEFT JOIN paises p ON a.pais_atk = p.cod_pais " +
                        "LEFT JOIN mutante m ON a.cod_atk = m.cod_atk " +
                        "LEFT JOIN economico e ON a.cod_atk = e.cod_atk WHERE a.cod_atk = ?";
                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                String nombre = "",pais = "",region_afec = "",grup_involu = "",bienes = "";
                int nBajas = 0,nHeridos = 0,mutan_afec = 0;
                try {
                    conn = Conexion.getConnection();
                    ps = conn.prepareStatement(WHEREsql);
                    ps.setInt(1, codigo);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        nombre = rs.getString("n_atk");
                        nBajas = rs.getInt("nro_bajas");
                        nHeridos = rs.getInt("nro_heridos");
                        pais = rs.getString("n_pais");
                        region_afec = rs.getString("region_afec");
                        mutan_afec = rs.getInt("mutan_afec");
                        grup_involu = rs.getString("grup_involu");
                        bienes = rs.getString("bien_dispu");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                } finally {
                    Conexion.close(rs);
                    Conexion.close(ps);
                    Conexion.close(conn);
                }

                String textos = "Nombre: "+nombre+"\n" +
                        "Nro Bajas: "+nBajas+"\n" +
                        "Nro Heridos: "+nHeridos+"\n" +
                        "Pais Atacado: "+pais+"\n";
                System.out.println("region_afec: "+region_afec+" mutan_afec: "+mutan_afec+" grup_involu: "+grup_involu+" bienes: "+bienes);
                if (region_afec != null && !region_afec.equals("null")) {
                    textos += "Region Afectada: "+region_afec;
                } else if (grup_involu != null && !grup_involu.equals("null")) {
                    textos += "Grupo Involucrado: "+grup_involu+"\n#Mutantes Afectados: "+mutan_afec;
                } else if (bienes != null && !bienes.equals("null")) {
                    textos += "Bien Disputado: "+bienes;
                } else {
                    textos = textos;
                }
                rq.setAttribute("msj_img", "catalagos.png");
                rq.setAttribute("msj_title", "Detalles del Ataque");
                rq.setAttribute("msj_text", textos);
                rq.setAttribute("msj_return", "AtaqueSV?action=list");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;

            case "delete":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                ataque = ataqueDAO.getByAtaque(codigo);
                if (ataque != null) {
                    ataqueDAO.delAtaque(ataque);
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se encontró");
                }
                rq.setAttribute("msj_title", "El Ataque");
                rq.setAttribute("msj_return", "AtaqueSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            int codigo = ataqueDAO.n_Ataque()+1;
            String nombre = rq.getParameter("nombre");
            int bajas = Integer.parseInt(rq.getParameter("bajas"));
            int heridos = Integer.parseInt(rq.getParameter("heridos"));
            String pais = rq.getParameter("pais");
            String tipo = rq.getParameter("tipo");
            Ataque ataque = new Ataque(codigo, nombre,bajas,heridos,pais);
            if (ataqueDAO.addAtaque(ataque)>0) {
                Connection conn = null;
                PreparedStatement ps = null;
                conn = Conexion.getConnection();
                switch (tipo){
                    case "inva":
                        try {
                            ps = conn.prepareStatement("INSERT INTO invasion_terri (cod_atk, region_afec) VALUES(?, ?)");
                            ps.setInt(1, codigo);
                            ps.setString(2, rq.getParameter("region"));
                            ps.executeUpdate();
                            Conexion.close(ps);
                            Conexion.close(conn);
                        } catch (SQLException e) {System.out.println(e.getMessage());}
                        break;
                    case "muta":
                        try {
                            ps = conn.prepareStatement("INSERT INTO mutante (cod_atk, grup_involu, mutan_afec) VALUES(?,?,?)");
                            ps.setInt(1, codigo);
                            ps.setString(2, rq.getParameter("grupo"));
                            ps.setInt(3, Integer.parseInt(rq.getParameter("mutantes")));
                            ps.executeUpdate();
                            Conexion.close(ps);
                            Conexion.close(conn);
                        } catch (SQLException e) {System.out.println(e.getMessage());}
                        break;
                    case "eco":
                        try {
                            ps = conn.prepareStatement("INSERT INTO economico (cod_atk, bien_dispu) VALUES(?,?)");
                            ps.setInt(1, codigo);
                            ps.setString(2, rq.getParameter("bien"));
                            ps.executeUpdate();
                            Conexion.close(ps);
                            Conexion.close(conn);
                        } catch (SQLException e) {System.out.println(e.getMessage());}
                        break;
                }

                rq.setAttribute("msj_img", "success.gif");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El Ataque");
            rq.setAttribute("msj_return", "AtaqueSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            String nombre = rq.getParameter("nombre");
            int bajas = Integer.parseInt(rq.getParameter("bajas"));
            int heridos = Integer.parseInt(rq.getParameter("heridos"));
            String pais = rq.getParameter("pais");
            Ataque ataque = ataqueDAO.getByAtaque(codigo);
            if (ataque != null) {
                ataque.setnAtk(nombre);
                ataque.setNroBajas(bajas);
                ataque.setNroHeridos(heridos);
                ataque.setPaisAtk(pais);
                if (ataqueDAO.modAtaque(ataque)>0) {
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El Ataque");
                rq.setAttribute("msj_return", "AtaqueSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se encontro");
                rq.setAttribute("msj_title", "El Ataque");
                rq.setAttribute("msj_return", "AtaqueSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
