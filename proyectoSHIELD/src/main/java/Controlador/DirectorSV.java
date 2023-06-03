package Controlador;

import datos.DirectorDAO;
import datos.LiderDAO;
import modelos.Director;
import modelos.Lider;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DirectorSV", value = {"/DirectorSV"})
public class DirectorSV extends HttpServlet {

    DirectorDAO directorDAO = new DirectorDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<Director> directores = directorDAO.getDirector();
                rq.setAttribute("directores", directores);
                rq.getRequestDispatcher("./views/Director/listaDirector.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                LiderDAO lideres = new LiderDAO();
                List<Lider> lider = lideres.getLider();
                rq.setAttribute("lider", lider);
                rq.getRequestDispatcher("./views/Director/agregarDirector.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                Director director = directorDAO.getByDirector(codigo);
                if (director != null) {
                    rq.setAttribute("director", director);
                    rq.getRequestDispatcher("./views/Director/modificarDirector.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("DirectorSV?action=list");
                }
                break;
            case "delete":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                director = directorDAO.getByDirector(codigo);
                if (director != null) {
                    directorDAO.delDirector(director);
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "No se encontró");
                }
                rq.setAttribute("msj_title", "El Director");
                rq.setAttribute("msj_return", "DirectorSV");
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
            String rango = rq.getParameter("rango");
            int lider = Integer.parseInt(rq.getParameter("lider"));
            Director director = new Director(codigo, nombre, rango, lider);
            if (directorDAO.addDirector(director) > 0) {
                rq.setAttribute("msj_img", "succe.svg");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El Director");
            rq.setAttribute("msj_return", "DirectorSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            String nombre = rq.getParameter("nombre");
            String rango = rq.getParameter("rango");
            int lider = Integer.parseInt(rq.getParameter("lider"));
            Director director = directorDAO.getByDirector(codigo);
            if (director != null) {
                director.setN_lider(nombre);
                director.setRangoDir(rango);
                director.setLider(lider);
                if (directorDAO.modDirector(director) > 0) {
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "borrar.png");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El Director");
                rq.setAttribute("msj_return", "DirectorSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se encontro");
                rq.setAttribute("msj_title", "El Director");
                rq.setAttribute("msj_return", "DirectorSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
