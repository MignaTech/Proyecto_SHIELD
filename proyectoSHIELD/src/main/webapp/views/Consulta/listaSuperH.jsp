<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.GrupoSh , java.util.List" %>
<%
    String titulo = "Grupo de Super Heroe";
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
            <h1 class="base-title">Lista de Grupo de Super Heroes</h1>
            <div>
                <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>C�digo</th>
                <th>Grupo de Super Heroes</th>
            </tr>
            </thead>
            <tbody>
            <% for (GrupoSh gp_sh : (List<GrupoSh>) request.getAttribute("superH")) { %>
            <tr>
                <td><%= gp_sh.getCodGpSp() %></td>
                <td><%= gp_sh.getnGp() %></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>
</article>
<%@ include file="../pie.jsp" %>
