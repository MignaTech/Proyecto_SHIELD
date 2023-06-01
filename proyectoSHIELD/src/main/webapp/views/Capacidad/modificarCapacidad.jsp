<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Capacidad" %>
<%
    String titulo = "Modificar Capacidad";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px;">
        <div class="base-header">
            <h1 class="base-title">Modificar Capacidad</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="CapacidadSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="codigo"
                       value="<%= ((Capacidad) request.getAttribute("capacidad")).getCodCap() %>">
                <div class="form-group">
                    <label>Tipo de Capacidad:</label>
                    <input type="text" name="nombre"
                           value="<%= ((Capacidad) request.getAttribute("capacidad")).getTpCap() %>"><br>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="CapacidadSV?action=list">Lista de Capacidad</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
