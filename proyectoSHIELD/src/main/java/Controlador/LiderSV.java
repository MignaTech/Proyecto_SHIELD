package Controlador;

import datos.LiderDAO;
import datos.SuperHDAO;
import modelos.GrupoSh;
import modelos.Lider;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LiderSV", value = {"/LiderSV"})
public class LiderSV extends HttpServlet {

    LiderDAO liderDAO = new LiderDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<Lider> lideres = liderDAO.getLider();
                rq.setAttribute("lideres", lideres);
                rq.getRequestDispatcher("./views/Lider/listaLider.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                SuperHDAO grupo = new SuperHDAO();
                List<GrupoSh> grupoShes = grupo.getSuperHs();
                rq.setAttribute("grupoShes", grupoShes);
                rq.getRequestDispatcher("./views/Lider/agregarLider.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                Lider lider = liderDAO.getByLider(codigo);
                if (lider != null) {
                    rq.setAttribute("lider", lider);
                    rq.getRequestDispatcher("./views/Lider/modificarLider.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("LiderSV?action=list");
                }
                break;
            case "delete":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                lider = liderDAO.getByLider(codigo);
                if (lider != null) {
                    liderDAO.delLider(lider);
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se encontró");
                }
                rq.setAttribute("msj_title", "El Lider");
                rq.setAttribute("msj_return", "LiderSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            int codigo = liderDAO.n_Lider()+1;
            int grupo = Integer.parseInt(rq.getParameter("grupo"));
            String nombre = rq.getParameter("nombre");
            Lider lider = new Lider(codigo, grupo, nombre);
            if (liderDAO.addLider(lider) > 0) {
                rq.setAttribute("msj_img", "success.gif");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El Lider");
            rq.setAttribute("msj_return", "LiderSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            int grupo = Integer.parseInt(rq.getParameter("grupo"));
            String nombre = rq.getParameter("nombre");
            Lider lider = liderDAO.getByLider(codigo);
            if (lider != null) {
                lider.setCodGpSh(grupo);
                lider.setnLider(nombre);
                if (liderDAO.modLider(lider) > 0) {
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El Lider");
                rq.setAttribute("msj_return", "LiderSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se encontro");
                rq.setAttribute("msj_title", "El Lider");
                rq.setAttribute("msj_return", "LiderSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
