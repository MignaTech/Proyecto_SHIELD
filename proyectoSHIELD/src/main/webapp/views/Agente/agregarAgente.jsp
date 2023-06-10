<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Agentes , java.util.List" %>
<%
    String titulo = "Agregar Agente";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Añadir Agente</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form id="myForm" action="AgentesSV" method="post">
                <input type="hidden" name="meto2" value="add">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" required><br>
                </div>
                <div class="form-group">
                    <label for="especializacion">Especialidad:</label>
                    <input type="text" id="especializacion" name="especializacion" required><br>
                </div>
                <div class="form-group">
                    <label for="tipoAyuda">Tipo de Ayuda:</label>
                    <input type="text" id="tipoAyuda" name="tipoAyuda" required><br>
                </div>
                <% List<Agentes> agen = (List<Agentes>) request.getAttribute("director"); %>
                <div class="form-group">
                    <label>Director:</label>
                    <select id="director" name="director">
                        <% for (Agentes itm : agen) { %>
                        <option value="<%= itm.getCodAgen() %>"><%= itm.getnAgen() %></option>
                        <% } %>
                    </select>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
                <a class="btn secondary pull-right" href="AgentesSV?action=list">Lista de Agentes</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
