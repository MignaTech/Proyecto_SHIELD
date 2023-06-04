<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.AgenAtk , java.util.List" %>
<%
    String titulo = "Relacion Agentes y Ataque";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Agentes que atienden Ataque</h1>
            <div>
                <a class="btn" href="AgenAtkSV?action=showAddForm">Agregar</a>
                <a class="btn das" href="<%=esc%>">Dashboard</a>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Fecha de Incorporacion</th>
                <th>Fecha de Retiro</th>
                <th>Agente</th>
                <th>Ataque</th>
                <th style="text-align: center">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% List<AgenAtk> registros = (List<AgenAtk>) request.getAttribute("agen_atk"); %>
            <% for (AgenAtk a_a : registros) { %>
            <tr>
                <td><%= a_a.getfInco() %></td>
                <td><%= a_a.getfReti() %></td>
                <td><%= a_a.getAgente() %></td>
                <td><%= a_a.getAtaque() %></td>
                <td style="text-align: center">
                    <a class="btn"
                       href="AgenAtkSV?action=showEditForm&codigo1=<%= a_a.getCodAgen() %>&codigo2=<%= a_a.getCodAtk() %>">Modificar</a>
                    <a class="btn secondary" href="AgenAtkSV?action=delete&codigo1=<%= a_a.getCodAgen() %>&codigo2=<%= a_a.getCodAtk() %>">Eliminar</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
