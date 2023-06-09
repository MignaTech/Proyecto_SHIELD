package Controlador;
import datos.*;
import modelos.*;
import modelos.Lider;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Login", value = {"/login", "/signup", "/logout", "/signupAdmin",
        "/signupAgente","/signupLid","/signupDirector","/signupCeo"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        rp.sendRedirect("./views/user/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
        switch (rq.getServletPath()) {
            case "/login":
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario user = new Usuario(rq.getParameter("nombre"), rq.getParameter("password"));
                try {
                    user = usuarioDAO.identifica(user);
                } catch (Exception e) {
                    System.out.println("Error en las credenciales");
                }
                if (user == null) {
                    rq.setAttribute("msj","Error en las credenciales");
                    rq.getRequestDispatcher("/views/user/login.jsp").forward(rq, rp);
                } else {
                    rq.getSession().setAttribute("usuario", user);
                    rq.getSession().setAttribute("currentUser", user);
                    switch (user.getRol().getN_rol()){
                        case "Administrador":
                            rq.getSession().setAttribute("IsAdmin", true);
                            rp.sendRedirect("views/UIAdmin/home.jsp");
                            break;
                        case "Agente":
                            modelos.Agentes temp = new AgentesDAO().getByAgentes(user.getRol().getCod_rol());
                            rq.getSession().setAttribute("perAgente", temp);
                            rp.sendRedirect("views/UIAgente/home.jsp");
                            break;
                        case "Lider":
                            Lider perLider = new LiderDAO().getByLider(user.getRol().getCod_rol());
                            rq.getSession().setAttribute("perLider",perLider);
                            rp.sendRedirect("views/UILider/home.jsp");
                            break;
                        case "Director":
                            Director perDirec = new DirectorDAO().getByDirector(user.getRol().getCod_rol());
                            rq.getSession().setAttribute("perDirec",perDirec);
                            Subdivisiones ejem = new SubdivisionesDAO().getBy(perDirec.getCodDir());
                            rq.getSession().setAttribute("tie_Sub",ejem);
                            rp.sendRedirect("views/UIDirec/home.jsp");
                            break;
                        case "Ceo":
                            rp.sendRedirect("views/UILider/home.jsp");
                            break;
                        default:
                            rp.sendRedirect("views/user/login.jsp");
                    }
                }
                break;
            case "/signup":
                UsuarioDAO usuarioDAO1 = new UsuarioDAO();
                String nombre = rq.getParameter("userName");
                String contrasenia = rq.getParameter("contrasenia");
                int rolID = Integer.parseInt(rq.getParameter("role"));
                Usuario newUser = new Usuario(nombre, contrasenia, rolID);
                int resSig = usuarioDAO1.insert(newUser);
                if (resSig==0) {
                    rq.setAttribute("errorSig", "Error al registrar. Inténtelo de nuevo.");
                    rq.getRequestDispatcher("views/user/signup.jsp").forward(rq, rp);
                } else if (resSig==23505) {
                    rq.setAttribute("errorSig", "Error el usuario ya Existe");
                    rq.getRequestDispatcher("views/user/signup.jsp").forward(rq, rp);
                } else {
                    if (rq.getSession().getAttribute("currentUser") == null)
                        rq.getSession().setAttribute("currentUser", newUser);
                    rp.sendRedirect("views/home.jsp");
                }
                break;
            case "/signupAdmin":
                String nombreAdmin = rq.getParameter("userNameAdmin");
                String passAdmin = rq.getParameter("contraseniaAdmin");
                int rolAdmin = Integer.parseInt(rq.getParameter("idenAdmin"));
                newUser = new Usuario(nombreAdmin, passAdmin, rolAdmin);
                resSig = new UsuarioDAO().insert(newUser);
                rq.setAttribute("msj_title", "El Administrador");
                if (resSig==0) {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo registrar. Inténtelo de nuevo.");
                    rq.setAttribute("msj_return", "views/user/signup.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                } else if (resSig==23505) {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo agregar. Error el usuario ya Existe");
                    rq.setAttribute("msj_return", "views/user/signup.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                } else {
                    if (rq.getSession().getAttribute("currentUser") == null)
                        rq.getSession().setAttribute("currentUser", newUser);
                    rq.setAttribute("msj_img", "success.gif");
                    rq.setAttribute("msj_text", "Se agrego exitosamente");
                    rq.setAttribute("msj_return", "views/UIAdmin/home.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                }
                break;
            case "/signupAgente":
                String userAgen = rq.getParameter("userName");
                String passAgen = rq.getParameter("contrasenia");
                int rolAgen = Integer.parseInt(rq.getParameter("idenAgen"));
                Usuario newAgen = new Usuario(userAgen, passAgen, rolAgen);
                int resAgen = new UsuarioDAO().insert(newAgen);
                rq.setAttribute("msj_title", "El Agente");
                if (resAgen==0) {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo registrar. Inténtelo de nuevo.");
                    rq.setAttribute("msj_return", "views/user/signup.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                } else if (resAgen==23505) {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo agregar. Error el usuario ya Existe");
                    rq.setAttribute("msj_return", "views/user/signup.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                } else {
                    AgentesDAO agentesDAO = new AgentesDAO();
                    int codigo = agentesDAO.n_Agentes()+1;
                    String n_Agen = rq.getParameter("nombre");
                    String especialidad = rq.getParameter("especialidad");
                    String tp_ayuda = rq.getParameter("tp_ayuda");
                    Agentes agente = new Agentes(codigo,n_Agen,especialidad,tp_ayuda,0);
                    if (agentesDAO.addAgentes(agente)>0) {
                        rq.setAttribute("msj_img", "success.gif");
                        rq.setAttribute("msj_text", "Se agrego exitosamente");
                    } else {
                        new UsuarioDAO().delUsuario(userAgen);
                        rq.setAttribute("msj_img", "info.gif");
                        rq.setAttribute("msj_text", "No se pudo agregar");
                        rq.setAttribute("msj_return", "views/user/signup.jsp");
                        rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                    }
                    rq.setAttribute("msj_return", "views/user/login.jsp");
                    if (rq.getSession().getAttribute("currentUser") == null)
                        rq.getSession().setAttribute("currentUser", newAgen);
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                }
                break;
            case "/signupLid":
                String userLid = rq.getParameter("userNameLid");
                String passLid = rq.getParameter("contraseniaLid");
                int rolLid = Integer.parseInt(rq.getParameter("idenLid"));
                Usuario newLid = new Usuario(userLid, passLid, rolLid);
                int resLid = new UsuarioDAO().insert(newLid);
                rq.setAttribute("msj_title", "El Lider");
                if (resLid==0) {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo registrar. Inténtelo de nuevo.");
                    rq.setAttribute("msj_return", "views/user/signup.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                } else if (resLid==23505) {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo agregar. Error el usuario ya Existe");
                    rq.setAttribute("msj_return", "views/user/signup.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                } else {
                    LiderDAO liderDAO = new LiderDAO();
                    int codLider = liderDAO.n_Lider()+1;
                    int grupo = Integer.parseInt(rq.getParameter("grupo"));
                    String n_Lider = rq.getParameter("nombreLid");
                    Lider lider = new Lider(codLider, grupo, n_Lider);
                    if (liderDAO.addLider(lider)>0) {
                        rq.setAttribute("msj_img", "success.gif");
                        rq.setAttribute("msj_text", "Se agrego exitosamente");
                    } else {
                        new UsuarioDAO().delUsuario(userLid);
                        rq.setAttribute("msj_img", "info.gif");
                        rq.setAttribute("msj_text", "No se pudo agregar");
                        rq.setAttribute("msj_return", "views/user/signup.jsp");
                        rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                    }
                    int mandro = Integer.parseInt(rq.getParameter("e1"));
                    int auvola = Integer.parseInt(rq.getParameter("e2"));
                    int sdvs = Integer.parseInt(rq.getParameter("e3"));
                    int heli = Integer.parseInt(rq.getParameter("e4"));
                    Eq_liderDAO eqLiderDAO = new Eq_liderDAO();
                    Eq_lider eqLider = new Eq_lider(1 , codLider, mandro, auvola, sdvs, heli);
                    eqLiderDAO.addLider(eqLider);
                    rq.setAttribute("msj_return", "views/user/login.jsp");
                    if (rq.getSession().getAttribute("currentUser") == null)
                        rq.getSession().setAttribute("currentUser", newLid);
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                }
                break;
            case "/signupDirector":
                String userDir = rq.getParameter("userNameDir");
                String passDir = rq.getParameter("contraseniaDir");
                int rolDir = Integer.parseInt(rq.getParameter("idenDir"));
                Usuario newDir = new Usuario(userDir, passDir, rolDir);
                int resDir = new UsuarioDAO().insert(newDir);
                rq.setAttribute("msj_title", "El Director");
                if (resDir==0) {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo registrar. Inténtelo de nuevo.");
                    rq.setAttribute("msj_return", "views/user/signup.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                } else if (resDir==23505) {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo agregar. Error el usuario ya Existe");
                    rq.setAttribute("msj_return", "views/user/signup.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                } else {
                    DirectorDAO directorDAO = new DirectorDAO();
                    int codigo = directorDAO.n_Director()+1;
                    String nombreDir = rq.getParameter("nombreDir");
                    String rangoDir = rq.getParameter("rangoDir");
                    int liderDir = Integer.parseInt(rq.getParameter("liderDir"));
                    Director director = new Director(codigo, nombreDir, rangoDir, liderDir);
                    if (directorDAO.addDirector(director) > 0) {
                        rq.setAttribute("msj_img", "success.gif");
                        rq.setAttribute("msj_text", "Se agrego exitosamente");
                    } else {
                        rq.setAttribute("msj_img", "info.gif");
                        rq.setAttribute("msj_text", "No se pudo agregar");
                        rq.setAttribute("msj_return", "views/user/signup.jsp");
                        rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                    }
                    rq.setAttribute("msj_return", "views/user/login.jsp");
                    if (rq.getSession().getAttribute("currentUser") == null)
                        rq.getSession().setAttribute("currentUser", newDir);
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                }
                break;
            case "/signupCeo":
                String userCeo = rq.getParameter("userNameCeo");
                String passCeo = rq.getParameter("contraseniaCeo");
                int rolCeo = Integer.parseInt(rq.getParameter("idenCeo"));
                Usuario newCeo = new Usuario(userCeo, passCeo, rolCeo);
                int resCeo = new UsuarioDAO().insert(newCeo);
                rq.setAttribute("msj_title", "El Ceo de Stark");
                if (resCeo==0) {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo registrar. Inténtelo de nuevo.");
                    rq.setAttribute("msj_return", "views/user/signup.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                } else if (resCeo==23505) {
                    rq.setAttribute("msj_img", "info.gif");
                    rq.setAttribute("msj_text", "No se pudo agregar. Error el usuario ya Existe");
                    rq.setAttribute("msj_return", "views/user/signup.jsp");
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                } else {
                    SiShDAO siShDAO = new SiShDAO();
                    String rfcCeo = rq.getParameter("rfc");
                    String nombreCeo = rq.getParameter("nombreCeo");
                    int grupoCeo = Integer.parseInt(rq.getParameter("grupoCeo"));
                    SiSh sish = new SiSh(rfcCeo, nombreCeo, grupoCeo);
                    if (siShDAO.addSiSh(sish) > 0) {
                        rq.setAttribute("msj_img", "success.gif");
                        rq.setAttribute("msj_text", "Se agrego exitosamente");
                    } else {
                        rq.setAttribute("msj_img", "info.gif");
                        rq.setAttribute("msj_text", "No se pudo agregar");
                    }
                    rq.setAttribute("msj_title", "El CEO de Stark Industries");
                    rq.setAttribute("msj_return", "views/user/login.jsp");
                    if (rq.getSession().getAttribute("currentUser") == null)
                        rq.getSession().setAttribute("currentUser", newCeo);
                    rq.getRequestDispatcher("/views/mensage.jsp").forward(rq, rp);
                }
                break;
            case "/logout":
                rq.getSession().invalidate();
                rp.sendRedirect("./index.jsp");
                break;
        }
    }
}