package Controlador;

import datos.*;
import modelos.AgenAtk;
import modelos.AgenJuntas;
import modelos.Agentes;
import modelos.Ataque;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Agente", value = {"/Agente1","/Agente2","/Agente3","/Agente4",
        "/Agente5","/Agente6","/Agente7","/Agente8"})
public class Agente extends HttpServlet {
    AgentesDAO agentesDAO = new AgentesDAO();
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        switch (rq.getServletPath()){
            case "/Agente1":
                List<AgenAtk> agen_atk = new AgenAtkDAO().getAgenAtk();
                rq.setAttribute("agen_atk", agen_atk);
                rq.getRequestDispatcher("./views/UIAgente/listaAgenAtk.jsp").forward(rq, rp);
                break;
            case "/Agente2":
                List<AgenJuntas> agenjuntas = new AgenJuntasDAO().getAgenJuntas();
                rq.setAttribute("agenjuntas", agenjuntas);
                rq.getRequestDispatcher("./views/UIAgente/listaAgenJuntas.jsp").forward(rq, rp);
                break;
            case "/Agente3":
                modelos.Agentes perfil = (Agentes) rq.getSession().getAttribute("perAgente");
                Agentes agente = new AgentesDAO().getByAgentes(perfil.getCodAgen());
                rq.setAttribute("agente", agente);
                rq.getRequestDispatcher("./views/UIAgente/perfilAgente.jsp").forward(rq, rp);
                break;
            case "/Agente5":
                perfil = (Agentes) rq.getSession().getAttribute("perAgente");
                String FROMsql = "SELECT a.* FROM ataque a " +
                        "WHERE cod_atk NOT IN " +
                        "(SELECT aa.cod_atk FROM agen_atk aa " +
                        "JOIN agentes a ON aa.cod_agen = a.cod_agen " +
                        "WHERE a.n_agen LIKE ?);";
                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                List<Ataque> elems = new ArrayList<>();
                try {
                    conn = Conexion.getConnection();
                    ps = conn.prepareStatement(FROMsql);
                    ps.setString(1, perfil.getnAgen());
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        int codigo = rs.getInt("cod_atk");
                        String nombre = rs.getString("n_atk");
                        int nBajas = rs.getInt("nro_bajas");
                        int nHeridos = rs.getInt("nro_heridos");
                        String pais = rs.getString("pais_atk");
                        elems.add(new Ataque(codigo, nombre,nBajas,nHeridos,pais));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                } finally {
                    Conexion.close(rs);
                    Conexion.close(ps);
                    Conexion.close(conn);
                }
                rq.setAttribute("filtroAtk", elems);
                rq.getRequestDispatcher("./views/UIAgente/agregarAtk.jsp").forward(rq, rp);
                break;
            case "/Agente7":
                AgenAtkDAO agenAtkDAO = new AgenAtkDAO();
                int codigo1 = Integer.parseInt(rq.getParameter("codigo1"));
                int codigo2 = Integer.parseInt(rq.getParameter("codigo2"));
                AgenAtk agenAtk = agenAtkDAO.getByAgenAtk(codigo1,codigo2);
                rq.setAttribute("agenAtk", agenAtk);
                rq.getRequestDispatcher("./views/UIAgente/retiroAtk.jsp").forward(rq, rp);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/Agente4":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                String nombre = rq.getParameter("nombre");
                String espe = rq.getParameter("especializacion");
                String ayuda = rq.getParameter("tipoAyuda");
                int direc = Integer.parseInt(rq.getParameter("director"));
                Agentes agente = agentesDAO.getByAgentes(codigo);
                if (agente != null) {
                    agente.setnAgen(nombre);
                    agente.setEspe(espe);
                    agente.setTpAyuda(ayuda);
                    agente.setAgenDir(direc);
                    if (agentesDAO.modAgentes(agente)>0) {
                        rq.getSession().setAttribute("perAgente",agente);
                        rq.setAttribute("msj_img", "success.gif");
                        rq.setAttribute("msj_text", "Se edito exitosamente");
                    } else {
                        rq.setAttribute("msj_img", "info.gif");
                        rq.setAttribute("msj_text", "No se pudo edito");
                    }
                    rq.setAttribute("msj_title", "El Perfil");
                    rq.setAttribute("msj_return", "views/UIAgente/home.jsp");
                    rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                }
                break;
            case "/Agente6":
                AgenAtkDAO agenAtkDAO = new AgenAtkDAO();
                modelos.Agentes perfil = (Agentes) rq.getSession().getAttribute("perAgente");
                int codigo6 = perfil.getCodAgen();
                Date inicio = Date.valueOf((rq.getParameter("inicio")));
                Date fin = null;
                if (!rq.getParameter("fin").isEmpty()){
                    fin = Date.valueOf(rq.getParameter("fin"));
                }
                int ataque = Integer.parseInt(rq.getParameter("ataque"));
                AgenAtk agenAtk = new AgenAtk(inicio,fin,codigo6,ataque);
                if (agenAtkDAO.addAgenAtk(agenAtk) > 0) {
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se agrego exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo agregar");
                }
                rq.setAttribute("msj_title", "El Ataque");
                rq.setAttribute("msj_return", "views/UIAgente/home.jsp");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
            case "/Agente8":
                agenAtkDAO = new AgenAtkDAO();
                fin = null;
                if (!rq.getParameter("fin").isEmpty()){
                    fin = Date.valueOf(rq.getParameter("fin"));
                }
                int codagente = Integer.parseInt(rq.getParameter("agente"));
                ataque = Integer.parseInt(rq.getParameter("ataque"));
                agenAtk = agenAtkDAO.getByAgenAtk(codagente,ataque);
                if (agenAtk != null) {
                    agenAtk.setfReti(fin);
                    if (agenAtkDAO.modAgenAtk(agenAtk) > 0) {
                        rq.setAttribute("msj_img", "success.gif");
                        rq.setAttribute("msj_text", "Se retiro exitosamente");
                    } else {
                        rq.setAttribute("msj_img", "info.gif");
                        rq.setAttribute("msj_text", "No se pudo modificar");
                    }
                    rq.setAttribute("msj_title", "El Agente");
                    rq.setAttribute("msj_return", "views/UIAgente/home.jsp");
                    rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                }
                break;
        }
    }
}
