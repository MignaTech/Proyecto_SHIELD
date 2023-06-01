<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Capacidad , java.util.List" %>
<%
    String titulo = "Capacidad";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Capacidades</h1>
            <div>
                <a class="btn" href="CapacidadSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Tipo de Capacidad</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% for (Capacidad capa : (List<Capacidad>) request.getAttribute("capas")) { %>
            <tr>
                <td><%= capa.getCodCap() %>
                </td>
                <td><%= capa.getTpCap() %>
                </td>
                <td style="text-align: center">
                    <a class="btn"
                       href="CapacidadSV?action=showEditForm&codigo=<%= capa.getCodCap() %>">Modificar</a>
                    <a class="btn secondary" href="CapacidadSV?action=delete&codigo=<%= capa.getCodCap() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
