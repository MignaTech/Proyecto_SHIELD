<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Heroe , modelos.GrupoSh , datos.SuperHDAO , java.util.List" %>
<%
    String titulo = "Modificar Heroe";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Heroe</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="HeroeSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="codigo"
                       value="<%= ((Heroe) request.getAttribute("heroes")).getCodHeroe() %>">
                <div class="form-group">
                    <label>Heroe:</label>
                    <input type="text" name="nombre"
                           value="<%= ((Heroe) request.getAttribute("heroes")).getnHeroe() %>"><br>
                </div>
                <div class="form-group">
                    <label>Poder:</label>
                    <input type="text" name="poder"
                           value="<%= ((Heroe) request.getAttribute("heroes")).getPoder() %>"><br>
                </div>
                <div class="form-group">
                    <label>Grupo:</label>
                    <select id="grupo" name="grupo">
                        <%
                            SuperHDAO superHDAO = new SuperHDAO();
                            List<GrupoSh> grupoSH = superHDAO.getSuperHs();
                            for (GrupoSh item : grupoSH) {
                                int idGrupo = item.getCodGpSp();
                                String nombreGrupo = item.getnGp();
                                String selected = "";
                                if (idGrupo == ((Heroe) request.getAttribute("heroes")).getCodGp()){
                                    selected = "selected";
                                }
                                out.println("<option value=\"" + idGrupo + "\" " + selected + ">" + nombreGrupo + "</option>");
                            }
                        %>
                    </select>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="HeroeSV?page=1">Lista de Grupo de Super Heroes</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
