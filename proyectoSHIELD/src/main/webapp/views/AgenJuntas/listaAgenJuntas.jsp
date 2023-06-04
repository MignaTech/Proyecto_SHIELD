<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.AgenJuntas , java.util.List" %>
<%
    String titulo = "Relacion Agentes y Juntas";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Agentes que asistiran a Juntas</h1>
            <div>
                <a class="btn" href="AgenJuntasSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Agente</th>
                <th>Junta</th>
                <th>Fecha</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% List<AgenJuntas> registros = (List<AgenJuntas>) request.getAttribute("agenjuntas"); %>
            <% for (AgenJuntas a_j : registros) { %>
            <tr>
                <td><%= a_j.getN_agente() %></td>
                <td><%= a_j.getN_junta() %></td>
                <td><%= a_j.getFechaJ() %></td>
                <td style="text-align: center">
                    <a class="btn secondary" href="AgenJuntasSV?action=delete&codigo1=<%= a_j.getCodAgen() %>&codigo2=<%= a_j.getCodJunta() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
