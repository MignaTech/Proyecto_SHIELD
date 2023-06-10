<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="datos.LiderDAO, modelos.Lider, modelos.Juntas , java.util.List" %>
<%
    String titulo = "Modificar Junta";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Junta</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="JuntasSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="codigo"
                       value="<%= ((Juntas) request.getAttribute("junta")).getCodJunta() %>">
                <div class="form-group">
                    <label>Contenido:</label>
                    <input type="text" name="contenido"
                           value="<%= ((Juntas) request.getAttribute("junta")).getContenido() %>"><br>
                </div>
                <div class="form-group">
                    <label>Fecha:</label>
                    <input type="date" name="fecha"
                           value="<%= ((Juntas) request.getAttribute("junta")).getFecha() %>"><br>
                </div>
                <div class="form-group">
                    <label>Lider:</label>
                    <select id="lider" name="lider">
                        <%
                            LiderDAO liderDAO = new LiderDAO();
                            List<Lider> lideres = liderDAO.getLider();
                            for (Lider item : lideres) {
                                int idLider = item.getCodLider();
                                String nombreLider = item.getnLider();
                                String selected = "";
                                if (idLider == ((Juntas) request.getAttribute("junta")).getLiderJ()){
                                    selected = "selected";
                                }
                                out.println("<option value=\"" + idLider + "\" " + selected + ">" + nombreLider + "</option>");
                            }
                        %>
                    </select>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="JuntasSV?action=list">Lista de Juntas</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
