<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String titulo = "Lista de Juntas";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="encabezado.jsp" %>
<%@ include file="barranav.jsp" %>
<article class="cont-body">
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Lista de Juntas</h1>
            <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
        </div>
        <table>
            <thead>
            <tr>
                <th>Agente</th>
                <th>Junta</th>
                <th>Fecha</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="registros" value="${requestScope.agenjuntas}" />
            <c:forEach var="a_j" items="${registros}">
                <c:if test="${a_j.getN_agente() eq sessionScope.currentUser.nombre}">
                    <tr>
                        <td>${a_j.getN_agente()}</td>
                        <td>${a_j.getN_junta()}</td>
                        <td>${a_j.getFechaJ()}</td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
