<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Agentes , java.util.List" %>
<%
    String titulo = "Agentes";
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
            <h1 class="base-title">Lista de los Agentes</h1>
            <div>
                <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th>Especialidad</th>
                <th>Tipo Ayuda prestada</th>
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
                <% } %>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</article>
<%@ include file="../pie.jsp" %>
