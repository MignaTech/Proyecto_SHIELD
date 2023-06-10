<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Lider, java.util.List" %>
<%
    String titulo = "Agregar Director";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Añadir Director</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="DirectorSV" method="post">
                <input type="hidden" name="meto2" value="add">
                <div class="form-group">
                    <label for="nombre">Nombre del Director:</label>
                    <input type="text" id="nombre" name="nombre" required><br>
                </div>
                <div class="form-group">
                    <label for="rango">Rango:</label>
                    <input type="text" id="rango" name="rango" required><br>
                </div>
                <%
                    List<Lider> lider = (List<Lider>) request.getAttribute("lider");
                %>
                <div class="form-group">
                    <label>Lider:</label>
                    <select id="lider" name="lider">
                        <% for (Lider itm : lider) { %>
                        <option value="<%= itm.getCodLider() %>"><%= itm.getnLider() %></option>
                        <% } %>
                    </select>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
                <a class="btn secondary pull-right" href="DirectorSV?action=list">Lista de Directores</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
