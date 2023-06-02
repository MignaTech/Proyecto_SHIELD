package Controlador;

import datos.PaisesDAO;
import modelos.Paises;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PaisesSV", value = {"/PaisesSV"})
public class PaisesSV extends HttpServlet {
    PaisesDAO paisesDAO = new PaisesDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<Paises> paises = paisesDAO.getPaisess();
                rq.setAttribute("paises", paises);
                rq.getRequestDispatcher("./views/Pais/listaPais.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                rq.getRequestDispatcher("./views/Pais/agregarPais.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                String codigo = rq.getParameter("codigo");
                Paises pais = paisesDAO.getByPaises(codigo);
                if (pais != null) {
                    rq.setAttribute("paises", pais);
                    rq.getRequestDispatcher("./views/Pais/modificarPais.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("PaisesSV?action=list");
                }
                break;
            case "delete":
                codigo = rq.getParameter("codigo");
                pais = paisesDAO.getByPaises(codigo);
                if (pais != null) {
                    paisesDAO.delPaises(pais);
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "No se encontró el pais a eliminar");
                }
                rq.setAttribute("msj_title", "El Pais");
                rq.setAttribute("msj_return", "PaisesSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            String codigo = rq.getParameter("codigo");
            String nombre = rq.getParameter("nombre");
            Paises paises = new Paises(codigo, nombre);
            if (paisesDAO.addPaises(paises)>0) {
                rq.setAttribute("msj_img", "succe.svg");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El Pais");
            rq.setAttribute("msj_return", "PaisesSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            String codigo = rq.getParameter("codigo");
            String nombre = rq.getParameter("nombre");
            Paises paises = paisesDAO.getByPaises(codigo);
            if (paises != null) {
                paises.setnPais(nombre);
                if (paisesDAO.modPaises(paises)>0) {
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "borrar.png");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El Pais");
                rq.setAttribute("msj_return", "PaisesSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se encontro el id a modificar");
                rq.setAttribute("msj_title", "El Pais");
                rq.setAttribute("msj_return", "PaisesSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
