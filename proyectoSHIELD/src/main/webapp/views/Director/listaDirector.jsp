<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Director , java.util.List" %>
<%
    String titulo = "Directores";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Directores</h1>
            <div>
                <a class="btn" href="DirectorSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Nombre de Director</th>
                <th>Rango</th>
                <th>Lider</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Director> registros = (List<Director>) request.getAttribute("directores");
            %>
            <% for (Director director : registros) { %>
            <tr>
                <td><%= director.getCodDir() %></td>
                <td><%= director.getnDir() %></td>
                <td><%= director.getRangoDir() %></td>
                <td><%= director.getN_lider() %></td>
                <td style="text-align: center">
                    <a class="btn"
                       href="DirectorSV?action=showEditForm&codigo=<%= director.getCodDir() %>">Modificar</a>
                    <a class="btn secondary" href="DirectorSV?action=delete&codigo=<%= director.getCodDir() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
