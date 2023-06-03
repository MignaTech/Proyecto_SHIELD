<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Lider, java.util.List" %>
<%
    String titulo = "Agregar Junta";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Añadir Junta</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="JuntasSV" method="post">
                <input type="hidden" name="meto2" value="add">
                <div class="form-group">
                    <label for="codigo">Código:</label>
                    <input type="number" id="codigo" name="codigo" required><br>
                </div>
                <div class="form-group">
                    <label for="contenido">Contenido:</label>
                    <input type="text" id="contenido" name="contenido" required><br>
                </div>
                <div class="form-group">
                    <label for="fecha">Fecha:</label>
                    <input type="date" id="fecha" name="fecha" style="width: 97%;font-size: 16px;" required><br>
                </div>
                <%
                    List<Lider> lidr = (List<Lider>) request.getAttribute("lider");
                %>
                <div class="form-group">
                    <label>Lider:</label>
                    <select id="lider" name="lider" style="width: 97%">
                        <% for (Lider itm : lidr) { %>
                        <option value="<%= itm.getCodLider() %>"><%= itm.getnLider() %></option>
                        <% } %>
                    </select>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
                <a class="btn secondary pull-right" href="JuntasSV?action=list">Lista de Juntas</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
