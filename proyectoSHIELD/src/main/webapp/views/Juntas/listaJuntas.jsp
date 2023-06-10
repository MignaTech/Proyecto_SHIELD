<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Juntas , java.util.List" %>
<%
    String titulo = "Juntas";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Juntas</h1>
            <div>
                <a class="btn" href="JuntasSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Contenido de Juntas</th>
                <th>Fecha</th>
                <th>Lider</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% List<Juntas> registros = (List<Juntas>) request.getAttribute("juntas"); %>
            <% for (Juntas junta : registros) { %>
            <tr>
                <td><%= junta.getCodJunta() %></td>
                <td><%= junta.getContenido() %></td>
                <td><%= junta.getFecha() %></td>
                <td><%= junta.getLider() %></td>
                <td style="text-align: center">
                    <a class="btn"
                       href="JuntasSV?action=showEditForm&codigo=<%= junta.getCodJunta() %>">Modificar</a>
                    <a class="btn secondary" href="JuntasSV?action=delete&codigo=<%= junta.getCodJunta() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
