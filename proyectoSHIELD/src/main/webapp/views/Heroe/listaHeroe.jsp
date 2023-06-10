<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Heroe , java.util.List" %>
<%
    String titulo = "Heroes";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%
    int nro_pagina = Integer.parseInt(request.getAttribute("nro_pagina").toString());
    int tol_pagina = Integer.parseInt(request.getAttribute("tol_pagina").toString());
    List<Heroe> registros = (List<Heroe>) request.getAttribute("heroes");
%>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Heroes</h1>
            <div class="paginacion">
                <% if (nro_pagina > 1) { %>
                <a href="HeroeSV?page=<%= nro_pagina - 1 %>">&laquo; Anterior</a>
                <% } %>
                <% for (int i = 1; i <= tol_pagina; i++) { %>
                <% if (i == nro_pagina) { %>
                <span class="current-page"><%= i %></span>
                <% } else { %>
                <a href="HeroeSV?page=<%= i %>"><%= i %></a>
                <% } %>
                <% } %>
                <% if (nro_pagina < tol_pagina) { %>
                <a href="HeroeSV?page=<%= nro_pagina + 1 %>">Siguiente &raquo;</a>
                <% } %>
            </div>
            <div>
                <a class="btn" href="HeroeSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Nombre de Heroe</th>
                <th>Poder</th>
                <th>Grupo</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% for (Heroe heroe : registros) { %>
            <tr>
                <td><%= heroe.getCodHeroe() %></td>
                <td><%= heroe.getnHeroe() %></td>
                <td><%= heroe.getPoder() %></td>
                <td><%= heroe.getNombreGrupo() %></td>
                <td style="text-align: center">
                    <a class="btn"
                       href="HeroeSV?action=showEditForm&codigo=<%= heroe.getCodHeroe() %>">Modificar</a>
                    <a class="btn secondary" href="HeroeSV?action=delete&codigo=<%= heroe.getCodHeroe() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
