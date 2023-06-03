package Controlador;

import datos.JuntasDAO;
import datos.LiderDAO;
import datos.SuperHDAO;
import modelos.GrupoSh;
import modelos.Juntas;
import modelos.Lider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "JuntasSV", value = {"/JuntasSV"})
public class JuntasSV extends HttpServlet {

    JuntasDAO juntaDAO = new JuntasDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                List<Juntas> juntas = juntaDAO.getJuntas();
                rq.setAttribute("juntas", juntas);
                rq.getRequestDispatcher("./views/Juntas/listaJuntas.jsp").forward(rq, rp);
                break;
            case "showAddForm":
                LiderDAO lideres = new LiderDAO();
                List<Lider> lider = lideres.getLider();
                rq.setAttribute("lider", lider);
                rq.getRequestDispatcher("./views/Juntas/agregarJuntas.jsp").forward(rq, rp);
                break;
            case "showEditForm":
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                Juntas junta = juntaDAO.getByJuntas(codigo);
                if (junta != null) {
                    rq.setAttribute("junta", junta);
                    rq.getRequestDispatcher("./views/Juntas/modificarJuntas.jsp").forward(rq, rp);
                } else {
                    rp.sendRedirect("JuntasSV?action=list");
                }
                break;
            case "delete":
                codigo = Integer.parseInt(rq.getParameter("codigo"));
                junta = juntaDAO.getByJuntas(codigo);
                if (junta != null) {
                    juntaDAO.delJuntas(junta);
                    rq.setAttribute("msj_img", "succe.svg");
				    rq.setAttribute("msj_text", "Se elimino exitosamente");
                } else {
                    rq.setAttribute("msj_img", "succe.svg");
				    rq.setAttribute("msj_text", "No se encontró");
                }
                rq.setAttribute("msj_title", "La Junta");
                rq.setAttribute("msj_return", "JuntasSV");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            String contenido = rq.getParameter("contenido");
            Date fecha = Date.valueOf(rq.getParameter("fecha"));
            int lider = Integer.parseInt(rq.getParameter("lider"));
            Juntas junta = new Juntas(codigo, contenido, fecha, lider);
            if (juntaDAO.addJuntas(junta)>0) {
				rq.setAttribute("msj_img", "succe.svg");
				rq.setAttribute("msj_text", "Se agrego exitosamente");
			} else {
				rq.setAttribute("msj_img", "borrar.png");
				rq.setAttribute("msj_text", "No se pudo agregar");
			}
			rq.setAttribute("msj_title", "La Junta");
			rq.setAttribute("msj_return", "JuntasSV");
			rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
        } else if (action.equals("edit")) {
            int codigo = Integer.parseInt(rq.getParameter("codigo"));
            String contenido = rq.getParameter("contenido");
            Date fecha = Date.valueOf(rq.getParameter("fecha"));
            int lider = Integer.parseInt(rq.getParameter("lider"));
            Juntas junta = juntaDAO.getByJuntas(codigo);
            if (junta != null) {
                junta.setContenido(contenido);
                junta.setFecha(fecha);
                junta.setLiderJ(lider);
                if (juntaDAO.modJuntas(junta)>0) {
					rq.setAttribute("msj_img", "succe.svg");
					rq.setAttribute("msj_text", "Se modifico exitosamente");
				} else {
					rq.setAttribute("msj_img", "borrar.png");
					rq.setAttribute("msj_text", "No se pudo modificar");
				}
				rq.setAttribute("msj_title", "La Junta");
				rq.setAttribute("msj_return", "JuntasSV");
				rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
			} else {
				rq.setAttribute("msj_img", "borrar.png");
				rq.setAttribute("msj_text", "No se encontro");
				rq.setAttribute("msj_title", "La Junta");
				rq.setAttribute("msj_return", "JuntasSV");
				rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
			}
        }
    }
}
