package Controlador;

import datos.AgenAtkDAO;
import datos.AgentesDAO;
import datos.AtaqueDAO;
import modelos.AgenAtk;
import modelos.Agentes;
import modelos.Ataque;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "AgenAtkSV", value = {"/AgenAtkSV"})
public class AgenAtkSV extends HttpServlet {

    AgenAtkDAO agenAtkDAO = new AgenAtkDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<AgenAtk> agen_atk = agenAtkDAO.getAgenAtk();
                rq.setAttribute("agen_atk", agen_atk);
                rq.getRequestDispatcher("./views/AgenAtk/listaAgenAtk.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                List<Agentes> agentes = new AgentesDAO().getAgentes();
                List<Ataque> ataques = new AtaqueDAO().getAtaque();
                rq.setAttribute("agentes", agentes);
                rq.setAttribute("ataques", ataques);
                rq.getRequestDispatcher("./views/AgenAtk/agregarAgenAtk.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo1 = Integer.parseInt(rq.getParameter("codigo1"));
                int codigo2 = Integer.parseInt(rq.getParameter("codigo2"));
                AgenAtk agenAtk = agenAtkDAO.getByAgenAtk(codigo1,codigo2);
                if (agenAtk != null) {
                    rq.setAttribute("agenAtk", agenAtk);
                    rq.getRequestDispatcher("./views/AgenAtk/modificarAgenAtk.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("AgenAtkSV?action=list");
                }
                break;
            case "delete":
                codigo1 = Integer.parseInt(rq.getParameter("codigo1"));
                codigo2 = Integer.parseInt(rq.getParameter("codigo2"));
                agenAtk = agenAtkDAO.getByAgenAtk(codigo1,codigo2);
                if (agenAtk != null) {
                    agenAtkDAO.delAgenAtk(agenAtk);
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se encontró");
                }
                rq.setAttribute("msj_title", "El Agente que atiende al Ataque");
                rq.setAttribute("msj_return", "AgenAtkSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            Date inicio = Date.valueOf((rq.getParameter("inicio")));
            Date fin = Date.valueOf(rq.getParameter("fin"));
            int agente = Integer.parseInt(rq.getParameter("agente"));
            int ataque = Integer.parseInt(rq.getParameter("ataque"));
            AgenAtk agenAtk = new AgenAtk(inicio,fin,agente,ataque);
            if (agenAtkDAO.addAgenAtk(agenAtk) > 0) {
                rq.setAttribute("msj_img", "success.gif");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El Agente que atiende al Ataque");
            rq.setAttribute("msj_return", "AgenAtkSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            Date inicio = Date.valueOf((rq.getParameter("inicio")));
            Date fin = Date.valueOf(rq.getParameter("fin"));
            int agente = Integer.parseInt(rq.getParameter("agente"));
            int ataque = Integer.parseInt(rq.getParameter("ataque"));
            AgenAtk agenAtk = agenAtkDAO.getByAgenAtk(agente,ataque);
            if (agenAtk != null) {
                agenAtk.setfInco(inicio);
                agenAtk.setfReti(fin);
                if (agenAtkDAO.modAgenAtk(agenAtk) > 0) {
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El Agente que atiende al Ataque");
                rq.setAttribute("msj_return", "AgenAtkSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se encontro");
                rq.setAttribute("msj_title", "El Agente que atiende al Ataque");
                rq.setAttribute("msj_return", "AgenAtkSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
