<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Lider , java.util.List" %>
<%
    String titulo = "Lider";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de los Lideres</h1>
            <div>
                <a class="btn" href="LiderSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Grupo Super Heroe</th>
                <th>Nombre Lider</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% for (Lider lider : (List<Lider>) request.getAttribute("lideres")) { %>
            <tr>
                <td><%= lider.getCodLider() %></td>
                <td><%= lider.getGrupo() %></td>
                <td><%= lider.getnLider() %></td>
                <td style="text-align: center">
                    <a class="btn" href="LiderSV?action=showEditForm&codigo=<%= lider.getCodLider() %>">Modificar</a>
                    <a class="btn secondary" href="LiderSV?action=delete&codigo=<%= lider.getCodLider() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</article>
<%@ include file="../pie.jsp" %>
