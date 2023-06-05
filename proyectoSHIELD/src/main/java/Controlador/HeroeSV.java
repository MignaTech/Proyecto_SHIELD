package Controlador;

import datos.HeroeDAO;
import datos.SuperHDAO;
import modelos.GrupoSh;
import modelos.Heroe;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HeroeSV", value = {"/HeroeSV"})
public class HeroeSV extends HttpServlet {

    HeroeDAO heroeDAO = new HeroeDAO();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "list":
                listarHeroe(rq, rp);
                break;
            case "showAddForm":
                mostrarFormularioAgregar(rq, rp);
                break;
            case "showEditForm":
                mostrarFormularioEditar(rq, rp);
                break;
            case "delete":
                eliminarHeroe(rq, rp);
                break;
            default:
                listarHeroe(rq, rp);
                break;
        }
    }

    private void listarHeroe(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        int nro_pagina = Integer.parseInt(rq.getParameter("page"));
        int limitar = 10;
        List<Heroe> heroes = heroeDAO.getHeroes(nro_pagina,limitar);
        int tol_registros = heroeDAO.countHeroe();
        int tol_pagina = (int) Math.ceil((double) tol_registros / limitar);
        rq.setAttribute("heroes", heroes);
        rq.setAttribute("nro_pagina", nro_pagina);
        rq.setAttribute("tol_pagina", tol_pagina);
        rq.getRequestDispatcher("./views/Heroe/listaHeroe.jsp").forward(rq, rp);
    }

    private void mostrarFormularioAgregar(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        SuperHDAO grupo = new SuperHDAO();
        List<GrupoSh> grupoShes = grupo.getSuperHs();
        rq.setAttribute("grupoShes", grupoShes);
        rq.getRequestDispatcher("./views/Heroe/agregarHeroe.jsp").forward(rq, rp);
    }

    private void mostrarFormularioEditar(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        Heroe heroes = heroeDAO.getByHeroe(codigo);
        if (heroes != null) {
            rq.setAttribute("heroes", heroes);
            rq.getRequestDispatcher("./views/Heroe/modificarHeroe.jsp").forward(rq, rp);
        } else {
            rp.sendRedirect("HeroeSV?page=1");
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        String action = rq.getParameter("meto2");
        if (action.equals("add")) {
            agregarHeroe(rq, rp);
        } else if (action.equals("edit")) {
            modificarHeroe(rq, rp);
        }
    }

    private void agregarHeroe(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        String nombre = rq.getParameter("nombre");
        String poder = rq.getParameter("poder");
        int grupo = Integer.parseInt(rq.getParameter("grupo"));
        Heroe heroe = new Heroe(codigo, nombre, poder, grupo);
        heroeDAO.addHeroe(heroe);
        rp.sendRedirect("HeroeSV?page=1");
    }

    private void modificarHeroe(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        String nombre = rq.getParameter("nombre");
        String poder = rq.getParameter("poder");
        int grupo = Integer.parseInt(rq.getParameter("grupo"));
        Heroe heroes = heroeDAO.getByHeroe(codigo);
        if (heroes != null) {
            heroes.setnHeroe(nombre);
            heroes.setPoder(poder);
            heroes.setCodGp(grupo);
            heroeDAO.modHeroe(heroes);
            rq.setAttribute("mensaje", "Heroe modificado exitosamente.");
            rq.setAttribute("color", "green");
        } else {
            rq.setAttribute("mensaje", "No se encontró el heroe a modificar.");
            rq.setAttribute("color", "red");
        }
        rp.sendRedirect("HeroeSV?page=1");
    }

    private void eliminarHeroe(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        Heroe heroes = heroeDAO.getByHeroe(codigo);
        if (heroes != null) {
            heroeDAO.delHeroe(heroes);
            rq.setAttribute("mensaje", "Heroe eliminado exitosamente.");
            rq.setAttribute("color", "green");
        } else {
            rq.setAttribute("mensaje", "No se encontró el heroe a eliminar.");
            rq.setAttribute("color", "red");
        }
        rp.sendRedirect("HeroeSV?page=1");
    }
}
