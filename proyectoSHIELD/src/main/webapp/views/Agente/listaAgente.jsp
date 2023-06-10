<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Agentes , java.util.List" %>
<%
    String titulo = "Agentes";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de los Agentes</h1>
            <div>
                <a class="btn" href="AgentesSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Agente</th>
                <th>Especialidad</th>
                <th>Tipo Ayuda</th>
                <th>Director</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% for (Agentes agente : (List<Agentes>) request.getAttribute("agentes")) { %>
            <tr>
                <% if (agente.getCodAgen()!=0) { %>
                <td><%= agente.getCodAgen() %></td>
                <td><%= agente.getnAgen() %></td>
                <td><%= agente.getEspe() %></td>
                <td><%= agente.getTpAyuda() %></td>
                <td><%= agente.getNombreDir() %></td>
                <td style="text-align: center">
                    <a class="btn" href="AgentesSV?action=showEditForm&codigo=<%= agente.getCodAgen() %>">Modificar</a>
                    <a class="btn secondary" href="AgentesSV?action=delete&codigo=<%= agente.getCodAgen() %>">Eliminar</a>
                </td>
                <% } %>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</article>
<%@ include file="../pie.jsp" %>
