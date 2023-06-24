<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Ataque , java.util.List" %>
<%
    String titulo = "Ataque";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<c:if test="${sessionScope.currentUser.rol.n_rol eq 'Agente'}">
    <%@ include file="../UIAgente/barranav.jsp" %>
</c:if>
<c:if test="${sessionScope.currentUser.rol.n_rol eq 'Lider'}">
    <%@ include file="../UILider/barranav.jsp" %>
</c:if>
<c:if test="${sessionScope.currentUser.rol.n_rol eq 'Director'}">
    <%@ include file="../UIDirec/barranav.jsp" %>
</c:if>
<article class="cont-body">
    <section class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de los Ataques</h1>
            <div>
                <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
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
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</article>
<%@ include file="../pie.jsp" %>
