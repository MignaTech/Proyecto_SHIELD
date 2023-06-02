<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Paises , java.util.List" %>
<%
    String titulo = "Paises";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de los Paises</h1>
            <div>
                <a class="btn" href="PaisesSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Pais</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% for (Paises pais : (List<Paises>) request.getAttribute("paises")) { %>
            <tr>
                <td><%= pais.getCodPais() %></td>
                <td><%= pais.getnPais() %></td>
                <td style="text-align: center">
                    <a class="btn" href="PaisesSV?action=showEditForm&codigo=<%= pais.getCodPais() %>">Modificar</a>
                    <a class="btn secondary" href="PaisesSV?action=delete&codigo=<%= pais.getCodPais() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</article>
<%@ include file="../pie.jsp" %>
