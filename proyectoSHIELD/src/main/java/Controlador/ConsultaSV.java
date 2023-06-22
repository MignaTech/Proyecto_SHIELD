package Controlador;

import datos.*;
import modelos.*;
import modelos.Lider;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ConsultaSV", value = {"/ConsulAgen","/ConsulAtk","/ConsulLider","/ConsulGrupo",
        "/ConsulDirector","/ConsulJuntas","/ConsulStark","/ConsulSubdi"})
public class ConsultaSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/ConsulAgen":
                List<Agentes> agentes = new AgentesDAO().getAgentes();
                rq.setAttribute("agentes", agentes);
                rq.getRequestDispatcher("./views/Consulta/listaAgente.jsp").forward(rq, rp);
                break;
            case "/ConsulAtk":
                List<Ataque> ataques = new AtaqueDAO().getAtaque();
                rq.setAttribute("ataques", ataques);
                rq.getRequestDispatcher("./views/Consulta/listaAtaque.jsp").forward(rq, rp);
                break;
            case "/ConsulLider":
                List<Lider> lideres = new LiderDAO().getLider();
                rq.setAttribute("lideres", lideres);
                rq.getRequestDispatcher("./views/Consulta/listaLider.jsp").forward(rq, rp);
                break;
            case "/ConsulGrupo":
                List<GrupoSh> superH = new SuperHDAO().getSuperHs();
                rq.setAttribute("superH", superH);
                rq.getRequestDispatcher("./views/Consulta/listaSuperH.jsp").forward(rq, rp);
                break;
            case "/ConsulDirector":
                List<Director> directores = new DirectorDAO().getDirector();
                rq.setAttribute("directores", directores);
                rq.getRequestDispatcher("./views/Consulta/listaDirector.jsp").forward(rq, rp);
                break;
            case "/ConsulJuntas":
                List<Juntas> juntas = new JuntasDAO().getJuntas();
                rq.setAttribute("juntas", juntas);
                rq.getRequestDispatcher("./views/Consulta/listaJuntas.jsp").forward(rq, rp);
                break;
            case "/ConsulStark":
                List<SiSh> si_sh = new SiShDAO().getSiSh();
                rq.setAttribute("si_sh", si_sh);
                rq.getRequestDispatcher("./views/Consulta/listaSiSh.jsp").forward(rq, rp);
                break;

            case "/ConsulSubdi":
                List<Subdivisiones> subdivisiones = new SubdivisionesDAO().getSubdivisiones();
                rq.setAttribute("subdivi", subdivisiones);
                rq.getRequestDispatcher("./views/Consulta/listaSubdi.jsp").forward(rq, rp);
                break;
        }
    }
}
