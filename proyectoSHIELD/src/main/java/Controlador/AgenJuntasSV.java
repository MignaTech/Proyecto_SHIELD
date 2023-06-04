package Controlador;

import datos.AgenJuntasDAO;
import datos.AgentesDAO;
import datos.JuntasDAO;
import modelos.AgenJuntas;
import modelos.Agentes;
import modelos.Juntas;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AgenJuntasSV", value = {"/AgenJuntasSV"})
public class AgenJuntasSV extends HttpServlet {

    AgenJuntasDAO agenjuntasDAO = new AgenJuntasDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<AgenJuntas> agenjuntas = agenjuntasDAO.getAgenJuntas();
                rq.setAttribute("agenjuntas", agenjuntas);
                rq.getRequestDispatcher("./views/AgenJuntas/listaAgenJuntas.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                List<Agentes> agentes = new AgentesDAO().getAgentes();
                List<Juntas> juntas = new JuntasDAO().getJuntas();
                rq.setAttribute("agentes", agentes);
                rq.setAttribute("juntas",juntas);
                rq.getRequestDispatcher("./views/AgenJuntas/agregarAgenJuntas.jsp").forward(rq, rp);
                break;
            case "delete":
                int codigo1 = Integer.parseInt(rq.getParameter("codigo1"));
                int codigo2 = Integer.parseInt(rq.getParameter("codigo2"));
                AgenJuntas equipo = agenjuntasDAO.getByAgenJuntas(codigo1,codigo2);
                if (equipo != null) {
                    agenjuntasDAO.delAgenJuntas(equipo);
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "No se encontró");
                }
                rq.setAttribute("msj_title", "El agente que ira a la junta");
                rq.setAttribute("msj_return", "AgenJuntasSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            int agente = Integer.parseInt(rq.getParameter("agente"));
            int junta = Integer.parseInt(rq.getParameter("junta"));
            AgenJuntas equipo = new AgenJuntas(agente,junta);
            if (agenjuntasDAO.addAgenJuntas(equipo) > 0) {
                rq.setAttribute("msj_img", "succe.svg");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El agente que ira a la junta");
            rq.setAttribute("msj_return", "AgenJuntasSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        }
    }
}
