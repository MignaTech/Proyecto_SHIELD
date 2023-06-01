<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String titulo = "Agregar Capacidad";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Agregar Capacidad</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="CapacidadSV" method="post">
                <input type="hidden" name="meto2" value="add">
                <div class="form-group">
                    <label for="codigo">Código:</label>
                    <input type="number" id="codigo" name="codigo" required><br>
                </div>
                <div class="form-group">
                    <label for="nombre">Tipo de Capacidad:</label>
                    <input type="text" id="nombre" name="nombre" required><br>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
                <a class="btn secondary pull-right" href="CapacidadSV?action=list">Lista de Capacidad</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
