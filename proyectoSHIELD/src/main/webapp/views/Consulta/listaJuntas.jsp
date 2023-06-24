<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String titulo = "Juntas";
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
            <h1 class="base-title">Lista de Juntas</h1>
            <div>
                <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Contenido de Juntas</th>
                <th>Fecha</th>
                <th>Lider</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="junta" items="${juntas}">
                <c:set var="fechahoy" value="<%= new java.util.Date() %>"/>
                <c:if test="${fechahoy.after(junta.fecha)}">
                    <tr style="background: red">
                </c:if>
                <c:if test="${!fechahoy.after(junta.fecha)}"><tr></c:if>
                <td>${junta.codJunta}</td>
                <td>${junta.contenido}</td>
                <td>${junta.fecha}</td>
                <td>${junta.lider}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
