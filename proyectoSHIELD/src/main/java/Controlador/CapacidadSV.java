package Controlador;

import datos.CapacidadDAO;
import modelos.Capacidad;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CapacidadSV", value = {"/CapacidadSV"})
public class CapacidadSV extends HttpServlet {

    CapacidadDAO capaDAO = new CapacidadDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<Capacidad> capas = capaDAO.getCapacidad();
                rq.setAttribute("capas", capas);
                rq.getRequestDispatcher("./views/Capacidad/listaCapacidad.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                rq.getRequestDispatcher("./views/Capacidad/agregarCapacidad.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                Capacidad capacidad = capaDAO.getByCapacidad(codigo);
                if (capacidad != null) {
                    rq.setAttribute("capacidad", capacidad);
                    rq.getRequestDispatcher("./views/Capacidad/modificarCapacidad.jsp").forward(rq, rp);
                } else
                    rp.sendRedirect("CapacidadSV?action=list");
                break;
            case "delete":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                capacidad = capaDAO.getByCapacidad(codigo);
                if (capacidad != null) {
                    capaDAO.delCapacidad(capacidad);
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "No se encontró la capacidad a eliminar.");
                }
                rq.setAttribute("msj_title", "La Capacidad");
                rq.setAttribute("msj_return", "CapacidadSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            String nombre = rq.getParameter("nombre");
            Capacidad capacidad = new Capacidad(codigo, nombre);
            if (capaDAO.addCapacidad(capacidad)>0) {
                rq.setAttribute("msj_img", "succe.svg");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "La Capacidad");
            rq.setAttribute("msj_return", "CapacidadSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            String nombre = rq.getParameter("nombre");
            Capacidad capacidad = capaDAO.getByCapacidad(codigo);
            if (capacidad != null) {
                capacidad.setTpCap(nombre);
                if (capaDAO.modCapacidad(capacidad)>0) {
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "borrar.png");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "La Capacidad");
                rq.setAttribute("msj_return", "CapacidadSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se encontro la capacidad a modificar.");
                rq.setAttribute("msj_title", "La Capacidad");
                rq.setAttribute("msj_return", "CapacidadSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
