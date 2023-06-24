<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.SiSh , java.util.List" %>
<%
    String titulo = "Stark Industries";
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
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Stark Industries</h1>
            <div>
                <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>RFC</th>
                <th>Nombre de CEO</th>
                <th>Grupo Super Heroes</th>
            </tr>
            </thead>
            <tbody>
            <% List<SiSh> registros = (List<SiSh>) request.getAttribute("si_sh"); %>
            <% for (SiSh sish : registros) { %>
            <tr>
                <td><%= sish.getRfc() %></td>
                <td><%= sish.getnCeo() %></td>
                <td><%= sish.getGrupo() %></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
