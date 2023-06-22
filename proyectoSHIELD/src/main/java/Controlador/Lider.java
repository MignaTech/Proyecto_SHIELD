package Controlador;

import datos.Eq_liderDAO;
import datos.JuntasDAO;
import datos.LiderDAO;
import modelos.Eq_lider;
import modelos.Juntas;
import modelos.Usuario;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "Lider", value = {"/Lider1", "/Lider2","/Lider3","/Lider4","/Lider5"})
public class Lider extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/Lider1":
                Usuario usuario = (Usuario) rq.getSession().getAttribute("currentUser");
                Eq_lider eqLider = new Eq_liderDAO().getEquipos(usuario.getNombre());
                rq.setAttribute("tpEquipo", eqLider);
                rq.getRequestDispatcher("./views/UILider/modificarEquipo.jsp").forward(rq, rp);
                break;
            case "/Lider3":
                modelos.Lider perfil = (modelos.Lider) rq.getSession().getAttribute("perLider");
                rq.setAttribute("perfilLid", perfil);
                rq.getRequestDispatcher("./views/UILider/perfilLider.jsp").forward(rq, rp);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/Lider2":
                Usuario usuario = (Usuario) rq.getSession().getAttribute("currentUser");
                String user = usuario.getNombre();
                Eq_liderDAO eqLiderDAO = new Eq_liderDAO();
                Eq_lider eqLider = eqLiderDAO.getEquipos(user);
                int mandroides = Integer.parseInt(rq.getParameter("mandroides"));
                int autoVoladores = Integer.parseInt(rq.getParameter("autoVoladores"));
                int sdv = Integer.parseInt(rq.getParameter("sdv"));
                int helitrasporte = Integer.parseInt(rq.getParameter("helitrasporte"));
                if (eqLider != null) {
                    eqLider.setMandro(mandroides);
                    eqLider.setAuvola(autoVoladores);
                    eqLider.setSdvs(sdv);
                    eqLider.setHeli(helitrasporte);
                    if (eqLiderDAO.modLider(eqLider) > 0) {
                        rq.setAttribute("msj_img", "success.gif");
                        rq.setAttribute("msj_text", "Se edito exitosamente");
                    } else {
                        rq.setAttribute("msj_img", "info.gif");
                        rq.setAttribute("msj_text", "No se pudo editar");
                    }
                    rq.setAttribute("msj_title", "El Equipamiento");
                    rq.setAttribute("msj_return", "views/UILider/home.jsp");
                    rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                }
                break;
            case "/Lider4":
                LiderDAO liderDAO = new LiderDAO();
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                int grupo = Integer.parseInt(rq.getParameter("grupo"));
                String nombre = rq.getParameter("nombre");
                modelos.Lider lider = liderDAO.getByLider(codigo);
                if (lider != null) {
                    lider.setCodGpSh(grupo);
                    lider.setnLider(nombre);
                    if (liderDAO.modLider(lider) > 0) {
                        rq.getSession().setAttribute("perLider",lider);
                        rq.setAttribute("msj_img", "success.gif");
                        rq.setAttribute("msj_text", "Se edito exitosamente");
                    } else {
                        rq.setAttribute("msj_img", "info.gif");
                        rq.setAttribute("msj_text", "No se pudo edito");
                    }
                    rq.setAttribute("msj_title", "El Perfil");
                    rq.setAttribute("msj_return", "views/UILider/home.jsp");
                    rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                }
                break;
            case "/Lider5":
                modelos.Lider perfil = (modelos.Lider) rq.getSession().getAttribute("perLider");
                JuntasDAO juntasDAO = new JuntasDAO();
                codigo = juntasDAO.n_Juntas()+1;
                String contenido = rq.getParameter("contenido");
                Date fecha = Date.valueOf(rq.getParameter("fecha"));
                int codi_lider = perfil.getCodLider();
                Juntas junta = new Juntas(codigo, contenido, fecha, codi_lider);
                if (juntasDAO.addJuntas(junta)>0) {
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se agrego exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo agregar");
                }
                rq.setAttribute("msj_title", "La Junta");
                rq.setAttribute("msj_return", "views/UILider/home.jsp");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }
}
