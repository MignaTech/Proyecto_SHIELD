<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.TpAlien" %>
<%
    String titulo = "Modificar Tipo de Alien";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Tipo de Alien</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="Tip_AlienSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="codigo"
                       value="<%= ((TpAlien) request.getAttribute("alien")).getCodAlien() %>">
                <div class="form-group">
                    <label>Raza Alien:</label>
                    <input type="text" name="nombre"
                           value="<%= ((TpAlien) request.getAttribute("alien")).getRazaAlien() %>"><br>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="Tip_AlienSV?action=list">Lista de Tipo Aliens</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
