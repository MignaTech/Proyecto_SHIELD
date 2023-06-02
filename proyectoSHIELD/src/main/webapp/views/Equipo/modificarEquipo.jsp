<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Equipo" %>
<%
    String titulo = "Modificar Equipo";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Equipo</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="EquipoSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="codigo" value="<%= ((Equipo) request.getAttribute("equipo")).getCodEq() %>">
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" name="nombre"
                           value="<%= ((Equipo) request.getAttribute("equipo")).getnEq() %>"><br>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="EquipoSV?action=list">Lista de equipos</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
