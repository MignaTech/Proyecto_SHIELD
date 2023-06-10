<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String titulo = "Agregar Grupo Super Heroe";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">A�adir Grupo de Super Heroes</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="SuperH_SV" method="post">
                <input type="hidden" name="meto2" value="add">
                <div class="form-group">
                    <label for="nombre">Nombre de Grupo de Super Heroes:</label>
                    <input type="text" id="nombre" name="nombre" required><br>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
                <a class="btn secondary pull-right" href="SuperH_SV?action=list">Lista de Super Heroes</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
