<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Subdivisiones , java.util.List" %>
<%
    String titulo = "Subdivisiones";
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
            <h1 class="base-title">Lista de Subdivisiones</h1>
            <div>
                <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
            </div>
        </div>
        <table>
            <thead>
            <tr>
                <th>Codigo</th>
                <th>Subdivisión</th>
                <th>Grupo de Super Heroes que Apoya</th>
                <th>Director</th>
            </tr>
            </thead>
            <tbody>
            <% List<Subdivisiones> registros = (List<Subdivisiones>) request.getAttribute("subdivi"); %>
            <% for (Subdivisiones re : registros) { %>
            <tr>
                <td><%= re.getCodSub() %></td>
                <td><%= re.getnSub() %></td>
                <td><%= re.getGrupo() %></td>
                <td><%= re.getnDir() %></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</article>
<%@ include file="../pie.jsp" %>
