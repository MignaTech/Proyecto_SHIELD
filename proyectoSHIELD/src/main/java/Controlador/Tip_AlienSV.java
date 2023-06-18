package Controlador;

import datos.Tip_AlienDAO;
import modelos.TpAlien;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Tip_AlienSV", value = {"/Tip_AlienSV"})
public class Tip_AlienSV extends HttpServlet {

    Tip_AlienDAO tip_alienDAO = new Tip_AlienDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<TpAlien> aliens = tip_alienDAO.getTpAlien();
                rq.setAttribute("aliens", aliens);
                rq.getRequestDispatcher("./views/TpAlien/listaTpAlien.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                rq.getRequestDispatcher("./views/TpAlien/agregarTpAlien.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                TpAlien alien = tip_alienDAO.getByTpAlien(codigo);
                if (alien != null) {
                    rq.setAttribute("alien", alien);
                    rq.getRequestDispatcher("./views/TpAlien/modificarTpAlien.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("TpAlien?action=list");
                }
                break;
            case "delete":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                alien = tip_alienDAO.getByTpAlien(codigo);
                if (alien != null) {
                    tip_alienDAO.delTpAlien(alien);
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se encontró");
                }
                rq.setAttribute("msj_title", "El Tipo de Alien");
                rq.setAttribute("msj_return", "Tip_AlienSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            int codigo = tip_alienDAO.n_TpAlien()+1;
            String nombre = rq.getParameter("nombre");
            TpAlien alien = new TpAlien(codigo, nombre);
            if (tip_alienDAO.addTip_Alien(alien)>0) {
                rq.setAttribute("msj_img", "success.gif");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El Tipo de Alien");
            rq.setAttribute("msj_return", "Tip_AlienSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            String nombre = rq.getParameter("nombre");
            TpAlien alien = tip_alienDAO.getByTpAlien(codigo);
            if (alien != null) {
                alien.setRazaAlien(nombre);
                if (tip_alienDAO.modTpAlien(alien)>0) {
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El Tipo de Alien");
                rq.setAttribute("msj_return", "Tip_AlienSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se encontro el id a modificar");
                rq.setAttribute("msj_title", "El Tipo de Alien");
                rq.setAttribute("msj_return", "Tip_AlienSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
