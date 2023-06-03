<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.SiSh , java.util.List" %>
<%
    String titulo = "Stark Industries";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Stark Industries</h1>
            <div>
                <a class="btn" href="SiShSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>RFC</th>
                <th>Nombre de CEO</th>
                <th>Grupo Super H</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% List<SiSh> registros = (List<SiSh>) request.getAttribute("si_sh"); %>
            <% for (SiSh sish : registros) { %>
            <tr>
                <td><%= sish.getRfc() %></td>
                <td><%= sish.getnCeo() %></td>
                <td><%= sish.getGrupo() %></td>
                <td style="text-align: center">
                    <a class="btn"
                       href="SiShSV?action=showEditForm&codigo=<%= sish.getRfc() %>">Modificar</a>
                    <a class="btn secondary" href="SiShSV?action=delete&codigo=<%= sish.getRfc() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
