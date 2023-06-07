package Controlador;

import datos.AgentesDAO;
import modelos.Agentes;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AgentesSV", value = {"/AgentesSV"})
public class AgentesSV extends HttpServlet {

    AgentesDAO agentesDAO = new AgentesDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<Agentes> agentes = agentesDAO.getAgentes();
                rq.setAttribute("agentes", agentes);
                rq.getRequestDispatcher("./views/Agente/listaAgente.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                AgentesDAO grupoAgen = new AgentesDAO();
                List<Agentes> director = grupoAgen.getAgentes();
                rq.setAttribute("director", director);
                rq.getRequestDispatcher("./views/Agente/agregarAgente.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                Agentes agente = agentesDAO.getByAgentes(codigo);
                if (agente != null) {
                    rq.setAttribute("agente", agente);
                    rq.getRequestDispatcher("./views/Agente/modificarAgente.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("Agentes?action=list");
                }
                break;
            case "delete":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                agente = agentesDAO.getByAgentes(codigo);
                if (agente != null) {
                    agentesDAO.delAgentes(agente);
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "No se encontró el pais a eliminar");
                }
                rq.setAttribute("msj_title", "El Agente");
                rq.setAttribute("msj_return", "AgentesSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            int codigo = agentesDAO.n_Agentes()+1;
            String nombre = rq.getParameter("nombre");
            String espe = rq.getParameter("especializacion");
            String ayuda = rq.getParameter("tipoAyuda");
            int direc = Integer.parseInt(rq.getParameter("director"));
            Agentes agente = new Agentes(codigo,nombre,espe,ayuda,direc);
            if (agentesDAO.addAgentes(agente)>0) {
                rq.setAttribute("msj_img", "succe.svg");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El Agente");
            rq.setAttribute("msj_return", "AgentesSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
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
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "borrar.png");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El Agente");
                rq.setAttribute("msj_return", "AgentesSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se encontro");
                rq.setAttribute("msj_title", "El Agente");
                rq.setAttribute("msj_return", "AgentesSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
