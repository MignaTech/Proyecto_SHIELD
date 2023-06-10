<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Equipo , java.util.List" %>
<%
    String titulo = "Equipo";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Listar Equipos</h1>
            <div>
                <a class="btn" href="EquipoSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% for (Equipo equipo : (List<Equipo>) request.getAttribute("equipos")) { %>
            <tr>
                <td><%= equipo.getCodEq() %>
                </td>
                <td><%= equipo.getnEq() %>
                </td>
                <td style="text-align: center">
                    <a class="btn"
                       href="EquipoSV?action=showEditForm&codigo=<%= equipo.getCodEq() %>">Modificar</a>
                    <a class="btn secondary"
                       href="EquipoSV?action=delete&codigo=<%= equipo.getCodEq() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</article>
<%@ include file="../pie.jsp" %>
