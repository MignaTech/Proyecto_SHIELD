<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.TpAlien , java.util.List" %>
<%
    String titulo = "Tipo de Alien";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Tipos de Aliens</h1>
            <div>
                <a class="btn" href="Tip_AlienSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Tipo de Alien</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% for (TpAlien tpAlien : (List<TpAlien>) request.getAttribute("aliens")) { %>
            <tr>
                <td><%= tpAlien.getCodAlien() %></td>
                <td><%= tpAlien.getRazaAlien() %></td>
                <td style="text-align: center">
                    <a class="btn" href="Tip_AlienSV?action=showEditForm&codigo=<%= tpAlien.getCodAlien() %>">Modificar</a>
                    <a class="btn secondary" href="Tip_AlienSV?action=delete&codigo=<%= tpAlien.getCodAlien() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</article>
<%@ include file="../pie.jsp" %>
