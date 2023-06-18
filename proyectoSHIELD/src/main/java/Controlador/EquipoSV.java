package Controlador;

import datos.EquipoDAO;
import modelos.Equipo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EquipoSV", value = {"/EquipoSV"})
public class EquipoSV extends HttpServlet {

    EquipoDAO equipoDAO = new EquipoDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<Equipo> equipos = equipoDAO.getEquipos();
                rq.setAttribute("equipos", equipos);
                rq.getRequestDispatcher("./views/Equipo/listaEquipos.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                rq.getRequestDispatcher("./views/Equipo/agregarEquipo.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                Equipo equipo = equipoDAO.getByEquipo(codigo);
                if (equipo != null) {
                    rq.setAttribute("equipo", equipo);
                    rq.getRequestDispatcher("./views/Equipo/modificarEquipo.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("EquipoSV?action=list");
                }
                break;
            case "delete":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                equipo = equipoDAO.getByEquipo(codigo);
                if (equipo != null) {
                    equipoDAO.delEquipo(equipo);
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se encontró el equipo a eliminar");
                }
                rq.setAttribute("msj_title", "El Equipo");
                rq.setAttribute("msj_return", "EquipoSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            int codigo = equipoDAO.n_Equipo()+1;
            String nombre = rq.getParameter("nombre");
            Equipo equipo = new Equipo(codigo, nombre);
            if (equipoDAO.addEquipo(equipo)>0) {
                rq.setAttribute("msj_img", "success.gif");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El Equipo");
            rq.setAttribute("msj_return", "EquipoSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            String nombre = rq.getParameter("nombre");
            Equipo equipo = equipoDAO.getByEquipo(codigo);
            if (equipo != null) {
                equipo.setnEq(nombre);
                if (equipoDAO.modEquipo(equipo)>0) {
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El Equipo");
                rq.setAttribute("msj_return", "EquipoSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se encontro el id a modificar");
                rq.setAttribute("msj_title", "El Equipo");
                rq.setAttribute("msj_return", "EquipoSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
