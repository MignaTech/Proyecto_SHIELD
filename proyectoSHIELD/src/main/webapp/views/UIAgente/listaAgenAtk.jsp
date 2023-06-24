<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String titulo = "Ataques atendidos/por atender";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="encabezado.jsp" %>
<%@ include file="barranav.jsp" %>
<article class="cont-body">
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Ataques atendidos/por atender</h1>
            <button class="btn " onclick="window.location.href='<%=con%>/Agente5'">Agregar</button>
            <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
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
            <c:set var="registros" value="${requestScope.agen_atk}" />
            <c:forEach var="a" items="${registros}">
                <c:if test="${a.getAgente() eq sessionScope.perAgente.nAgen}">
                    <tr>
                        <td>${a.getfInco()}</td>
                        <td>${a.getfReti()}</td>
                        <td>${a.getAgente()}</td>
                        <td>${a.getAtaque()}</td>
                        <td style="text-align: center">
                            <a class="btn"
                               href="Agente7?codigo1=${a.getCodAgen()}&codigo2=${a.getCodAtk()}">Modificar</a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
