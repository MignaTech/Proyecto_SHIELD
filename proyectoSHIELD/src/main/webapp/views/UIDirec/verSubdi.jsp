<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Subdivisiones , java.util.List, modelos.GrupoSh, datos.SuperHDAO" %>
<%
    String titulo = "Subdivision";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="encabezado.jsp" %>
<%@ include file="barranav.jsp" %>
<article class="cont-body">
    <div class="cont-base">
        <div class="base-header">
            <h1 class="base-title">Subdivision</h1>
            <div>
                <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
            </div>
        </div>
        <c:choose>
            <c:when test="${sessionScope.tie_Sub == null}">
            <div class="form-container">
                <form action="<%=con%>/Direc5" method="post">
                    <div class="form-group">
                        <label>Nombre de Subdivisión:</label>
                        <input type="text" name="nombre" required><br>
                    </div>
                    <% List<GrupoSh> grd = new SuperHDAO().getSuperHs(); %>
                    <div class="form-group">
                        <label>Grupo de Super Heroe que apoyara:</label>
                        <select name="grupo">
                            <% for (GrupoSh itm : grd) { %>
                            <option value="<%= itm.getCodGpSp() %>"><%= itm.getnGp() %></option>
                            <% } %>
                        </select>
                    </div>
                    <input class="btn pull-left" type="submit" value="Agregar">
                </form>
            </div>
            </c:when>
            <c:otherwise>
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
                <% Subdivisiones re = (Subdivisiones) request.getSession().getAttribute("tie_Sub"); %>
                <tr>
                    <td><%= re.getCodSub() %></td>
                    <td><%= re.getnSub() %></td>
                    <td><%= re.getGrupo() %></td>
                    <td><%= re.getnDir() %></td>
                </tr>
                </tbody>
            </table>
            </c:otherwise>
        </c:choose>
    </div>
</article>
<%@ include file="../pie.jsp" %>
