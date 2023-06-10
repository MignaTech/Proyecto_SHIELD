<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.GrupoSh, java.util.List" %>
<%
    String titulo = "Agregar Lider";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Añadir Lider</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="LiderSV" method="post">
                <input type="hidden" name="meto2" value="add">
                <%
                    List<GrupoSh> grups = (List<GrupoSh>) request.getAttribute("grupoShes");
                %>
                <div class="form-group">
                    <label>Grupo al que pertenece:</label>
                    <select id="grupo" name="grupo">
                        <% for (GrupoSh itm : grups) { %>
                        <option value="<%= itm.getCodGpSp() %>"><%= itm.getnGp() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre del Lider:</label>
                    <input type="text" id="nombre" name="nombre" required><br>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
                <a class="btn secondary pull-right" href="LiderSV?action=list">Lista de Lideres</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
