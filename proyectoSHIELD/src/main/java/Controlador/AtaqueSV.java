package Controlador;

import datos.AtaqueDAO;
import datos.PaisesDAO;
import modelos.Ataque;
import modelos.Paises;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AtaqueSV", value = {"/AtaqueSV"})
public class AtaqueSV extends HttpServlet {

    AtaqueDAO ataqueDAO = new AtaqueDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<Ataque> ataques = ataqueDAO.getAtaque();
                rq.setAttribute("ataques", ataques);
                rq.getRequestDispatcher("./views/Ataque/listaAtaque.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                List<Paises> paises = new PaisesDAO().getPaisess();
                rq.setAttribute("paises", paises);
                rq.getRequestDispatcher("./views/Ataque/agregarAtaque.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                Ataque ataque = ataqueDAO.getByAtaque(codigo);
                if (ataque != null) {
                    rq.setAttribute("ataque", ataque);
                    rq.getRequestDispatcher("./views/Ataque/modificarAtaque.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("Ataque?action=list");
                }
                break;
            case "delete":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                ataque = ataqueDAO.getByAtaque(codigo);
                if (ataque != null) {
                    ataqueDAO.delAtaque(ataque);
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "No se encontró");
                }
                rq.setAttribute("msj_title", "El Ataque");
                rq.setAttribute("msj_return", "AtaqueSV");
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
            int bajas = Integer.parseInt(rq.getParameter("bajas"));
            int heridos = Integer.parseInt(rq.getParameter("heridos"));
            String pais = rq.getParameter("pais");
            Ataque ataque = new Ataque(codigo, nombre,bajas,heridos,pais);
            if (ataqueDAO.addAtaque(ataque)>0) {
                rq.setAttribute("msj_img", "succe.svg");
                rq.setAttribute("msj_text", "Se agrego exitosamente");
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se pudo agregar");
            }
            rq.setAttribute("msj_title", "El Ataque");
            rq.setAttribute("msj_return", "AtaqueSV");
            rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            String nombre = rq.getParameter("nombre");
            int bajas = Integer.parseInt(rq.getParameter("bajas"));
            int heridos = Integer.parseInt(rq.getParameter("heridos"));
            String pais = rq.getParameter("pais");
            Ataque ataque = ataqueDAO.getByAtaque(codigo);
            if (ataque != null) {
                ataque.setnAtk(nombre);
                ataque.setNroBajas(bajas);
                ataque.setNroHeridos(heridos);
                ataque.setPaisAtk(pais);
                if (ataqueDAO.modAtaque(ataque)>0) {
                    rq.setAttribute("msj_img", "succe.svg");
                    rq.setAttribute("msj_text", "Se modifico exitosamente");
                } else {
                    rq.setAttribute("msj_img", "borrar.png");
                    rq.setAttribute("msj_text", "No se pudo modificar");
                }
                rq.setAttribute("msj_title", "El Ataque");
                rq.setAttribute("msj_return", "AtaqueSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            } else {
                rq.setAttribute("msj_img", "borrar.png");
                rq.setAttribute("msj_text", "No se encontro");
                rq.setAttribute("msj_title", "El Ataque");
                rq.setAttribute("msj_return", "AtaqueSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
            }
        }
    }
}
