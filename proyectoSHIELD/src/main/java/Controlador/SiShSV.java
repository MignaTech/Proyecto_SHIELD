package Controlador;

import datos.SiShDAO;
import datos.SuperHDAO;
import modelos.GrupoSh;
import modelos.SiSh;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SiShSV", value = {"/SiShSV"})
public class SiShSV extends HttpServlet {

    SiShDAO sishDAO = new SiShDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<SiSh> si_sh = sishDAO.getSiSh();
                rq.setAttribute("si_sh", si_sh);
                rq.getRequestDispatcher("./views/SiSh/listaSiSh.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                SuperHDAO grupo = new SuperHDAO();
                List<GrupoSh> grupoShes = grupo.getSuperHs();
                rq.setAttribute("grupoShes", grupoShes);
                rq.getRequestDispatcher("./views/SiSh/agregarSiSh.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                String codigo = rq.getParameter("codigo");
                SiSh sish = sishDAO.getBySiSh(codigo);
                if (sish != null) {
                    rq.setAttribute("sish", sish);
                    rq.getRequestDispatcher("./views/SiSh/modificarSiSh.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("SiShSV?action=list");
                }
                break;
            case "delete":
                codigo = rq.getParameter("codigo");
                sish = sishDAO.getBySiSh(codigo);
                if (sish != null) {
                    sishDAO.delSiSh(sish);
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se encontró");
                }
                rq.setAttribute("msj_title", "El CEO de Stark Industries");
                rq.setAttribute("msj_return", "SiShSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            String codigo = rq.getParameter("rfc");
            String nombre = rq.getParameter("ceo");
            int grupo = Integer.parseInt(rq.getParameter("grupo"));
            SiSh sish = new SiSh(codigo, nombre, grupo);
            if (sishDAO.addSiSh(sish) > 0) {
                rq.setAttribute("msj_img", "success.gif");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El CEO de Stark Industries");
            rq.setAttribute("msj_return", "SiShSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            String codigo = rq.getParameter("rfc");
            String nombre = rq.getParameter("ceo");
            int grupo = Integer.parseInt(rq.getParameter("grupo"));
            SiSh sish = sishDAO.getBySiSh(codigo);
            if (sish != null) {
                sish.setnCeo(nombre);
                sish.setCodGpSh(grupo);
                if (sishDAO.modSiSh(sish) > 0) {
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El CEO de Stark Industries");
                rq.setAttribute("msj_return", "SiShSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "info.gif");
                rq.setAttribute("msj_text", "No se encontro");
                rq.setAttribute("msj_title", "El CEO de Stark Industries");
                rq.setAttribute("msj_return", "SiShSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
