package Controlador;

import datos.SuperHDAO;
import modelos.GrupoSh;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SuperH_SV", value = {"/SuperH_SV"})
public class SuperH_SV extends HttpServlet {

    SuperHDAO shDAO = new SuperHDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<GrupoSh> superH = shDAO.getSuperHs();
                rq.setAttribute("superH", superH);
                rq.getRequestDispatcher("./views/SuperH/listaSuperH.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                rq.getRequestDispatcher("./views/SuperH/agregarSuperH.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                GrupoSh gp_sh = shDAO.getBySuperH(codigo);
                if (gp_sh != null) {
                    rq.setAttribute("gp_sh", gp_sh);
                    rq.getRequestDispatcher("./views/SuperH/modificarSuperH.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("SuperH_SV?action=list");
                }
                break;
            case "delete":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                gp_sh = shDAO.getBySuperH(codigo);
                if (gp_sh != null) {
                    shDAO.delSuperH(gp_sh);
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se encontró el pais a eliminar");
                }
                rq.setAttribute("msj_title", "El Grupo de Super Heroe");
                rq.setAttribute("msj_return", "SuperH_SV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            int codigo = shDAO.n_SuperHs()+1;
            String nombre = rq.getParameter("nombre");
            GrupoSh gp_sh = new GrupoSh(codigo, nombre);
            if (shDAO.addSuperH(gp_sh)>0) {
                rq.setAttribute("msj_img", "success.gif");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El Grupo de Super Heroe");
            rq.setAttribute("msj_return", "SuperH_SV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            String nombre = rq.getParameter("nombre");
            GrupoSh gp_sh = shDAO.getBySuperH(codigo);
            if (gp_sh != null) {
                gp_sh.setnGp(nombre);
                if (shDAO.modSuperH(gp_sh)>0) {
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El Grupo de Super Heroe");
                rq.setAttribute("msj_return", "SuperH_SV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se encontro");
                rq.setAttribute("msj_title", "El Grupo de Super Heroe");
                rq.setAttribute("msj_return", "SuperH_SV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
