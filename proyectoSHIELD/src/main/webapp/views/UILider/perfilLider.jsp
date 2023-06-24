<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Lider , modelos.GrupoSh , datos.SuperHDAO , java.util.List" %>
<%
    String titulo = "Modificar Perfil";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="encabezado.jsp" %>
<%@ include file="barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Perfil</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="<%=con%>/Lider4" method="post">
                <input type="hidden" name="codigo"
                       value="<%= ((Lider) request.getAttribute("perfilLid")).getCodLider() %>">
                <div class="form-group">
                    <label>Grupo que Lidera:</label>
                    <select id="grupo" name="grupo">
                        <%
                            SuperHDAO superHDAO = new SuperHDAO();
                            List<GrupoSh> grupoSH = superHDAO.getSuperHs();
                            for (GrupoSh item : grupoSH) {
                                int idGrupo = item.getCodGpSp();
                                String nombreGrupo = item.getnGp();
                                String selected = "";
                                if (idGrupo == ((Lider) request.getAttribute("perfilLid")).getCodGpSh()){
                                    selected = "selected";
                                }
                                out.println("<option value=\"" + idGrupo + "\" " + selected + ">" + nombreGrupo + "</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" name="nombre"
                           value="<%= ((Lider) request.getAttribute("perfilLid")).getnLider() %>"><br>
                </div>
                <input class="btn" type="submit" value="Guardar">
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
