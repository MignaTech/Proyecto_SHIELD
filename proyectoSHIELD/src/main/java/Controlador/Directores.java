package Controlador;

import datos.*;
import modelos.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Directores", value = {"/Direc1","/Direc2","/Direc3","/Direc4","/Direc5"})
public class Directores extends HttpServlet {
    AgentesDAO agentesDAO = new AgentesDAO();
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        switch (rq.getServletPath()){
            case "/Direc1":
                Director perfil = (Director) rq.getSession().getAttribute("perDirec");
                List<Subdivisiones> subdi = new SubdivisionesDAO().getBySubdivisiones(perfil.getCodDir());
                rq.setAttribute("subdivi", subdi);
                rq.getRequestDispatcher("./views/UIDirec/listaSubdi.jsp").forward(rq, rp);
                break;
            case "/Direc2":
                List<AgenJuntas> agenjuntas = new AgenJuntasDAO().getAgenJuntas();
                rq.setAttribute("agenjuntas", agenjuntas);
                rq.getRequestDispatcher("./views/UIAgente/listaAgenJuntas.jsp").forward(rq, rp);
                break;
            case "/Direc3":
                perfil = (Director) rq.getSession().getAttribute("perDirec");
                Director director = new DirectorDAO().getByDirector(perfil.getCodDir());
                rq.setAttribute("director", director);
                rq.getRequestDispatcher("./views/UIDirec/perfilDirector.jsp").forward(rq, rp);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/Direc4":
                DirectorDAO directorDAO = new DirectorDAO();
                int codigo = Integer.parseInt(rq.getParameter("codigo"));
                String nombre = rq.getParameter("nombre");
                String rango = rq.getParameter("rango");
                int lider = Integer.parseInt(rq.getParameter("lider"));
                Director director = directorDAO.getByDirector(codigo);
                if (director != null) {
                    director.setnDir(nombre);
                    director.setRangoDir(rango);
                    director.setLider(lider);
                    if (directorDAO.modDirector(director) > 0) {
                        rq.getSession().setAttribute("perDirec",director);
                        rq.setAttribute("msj_img", "succe.svg");
                        rq.setAttribute("msj_text", "Se modifico exitosamente");
                    } else {
                        rq.setAttribute("msj_img", "info.gif");
                        rq.setAttribute("msj_text", "No se pudo modificar");
                    }
                    rq.setAttribute("msj_title", "El Perfil");
                    rq.setAttribute("msj_return", "views/UIDirec/home.jsp");
                    rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                }
                break;
            case "/Direc5":
                Director perfil = (Director) rq.getSession().getAttribute("perDirec");
                SubdivisionesDAO subdivisionesDAO = new SubdivisionesDAO();
                int cod_sub = subdivisionesDAO.n_Subdivisiones()+1;
                int codshapoya = Integer.parseInt(rq.getParameter("grupo"));
                String n_sub = rq.getParameter("nombre");
                int dir_sub = perfil.getCodDir();
                Subdivisiones subdivisiones = new Subdivisiones(cod_sub, codshapoya, n_sub, dir_sub);
                if (subdivisionesDAO.addSubdivisiones(subdivisiones) > 0) {
                    subdivisiones = subdivisionesDAO.getBy(dir_sub);
                    rq.getSession().setAttribute("tie_Sub",subdivisiones);
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se agrego exitosamente");
                } else {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo agregar");
                }
                rq.setAttribute("msj_title", "La Subdivision");
                rq.setAttribute("msj_return", "views/UIDirec/home.jsp");
                rq.getRequestDispatcher("./views/mensage.jsp").forward(rq, rp);
                break;
        }
    }
}
