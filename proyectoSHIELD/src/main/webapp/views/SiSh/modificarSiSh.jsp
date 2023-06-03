<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.SiSh , modelos.GrupoSh , datos.SuperHDAO , java.util.List" %>
<%
    String titulo = "Modificar CEO de Stark Industries";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar CEO de Stark Industries</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="SiShSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="rfc"
                       value="<%= ((SiSh) request.getAttribute("sish")).getRfc() %>">
                <div class="form-group">
                    <label>Nombre de CEO:</label>
                    <input type="text" name="ceo"
                           value="<%= ((SiSh) request.getAttribute("sish")).getnCeo() %>"><br>
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
                                if (idGrupo == ((SiSh) request.getAttribute("sish")).getCodGpSh()){
                                    selected = "selected";
                                }
                                out.println("<option value=\"" + idGrupo + "\" " + selected + ">" + nombreGrupo + "</option>");
                            }
                        %>
                    </select>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="SiShSV?action=list">Lista de Stark Industries</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
