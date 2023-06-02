<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Ataque , java.util.List" %>
<%
    String titulo = "Ataque";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de los Ataques</h1>
            <div>
                <a class="btn" href="AtaqueSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Ataque</th>
                <th># Bajas</th>
                <th># Heridos</th>
                <th>Pais Afectado</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% for (Ataque ataque : (List<Ataque>) request.getAttribute("ataques")) { %>
            <tr>
                <td><%= ataque.getCodAtk() %></td>
                <td><%= ataque.getnAtk() %></td>
                <td><%= ataque.getNroBajas() %></td>
                <td><%= ataque.getNroHeridos() %></td>
                <td><%= ataque.getN_pais() %></td>
                <td style="text-align: center">
                    <a class="btn" href="AtaqueSV?action=showEditForm&codigo=<%= ataque.getCodAtk() %>">Modificar</a>
                    <a class="btn secondary" href="AtaqueSV?action=delete&codigo=<%= ataque.getCodAtk() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</article>
<%@ include file="../pie.jsp" %>
