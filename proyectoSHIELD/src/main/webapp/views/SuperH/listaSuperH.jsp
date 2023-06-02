<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.GrupoSh , java.util.List" %>
<%
    String titulo = "Grupo de Super Heroe";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Grupo de Super Heroes</h1>
            <div>
                <a class="btn" href="SuperH_SV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Grupo de Super Heroes</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% for (GrupoSh gp_sh : (List<GrupoSh>) request.getAttribute("superH")) { %>
            <tr>
                <td><%= gp_sh.getCodGpSp() %>
                </td>
                <td><%= gp_sh.getnGp() %>
                </td>
                <td style="text-align: center">
                    <a class="btn"
                       href="SuperH_SV?action=showEditForm&codigo=<%= gp_sh.getCodGpSp() %>">Modificar</a>
                    <a class="btn secondary" href="SuperH_SV?action=delete&codigo=<%= gp_sh.getCodGpSp() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</article>
<%@ include file="../pie.jsp" %>
