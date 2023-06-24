<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Eq_lider" %>
<%
    String titulo = "Equipo";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="encabezado.jsp" %>
<%@ include file="barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Equipo</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="<%=con%>/Lider2" method="post">
                <div class="form-group">
                    <label>Mandroides:</label>
                    <input type="number" name="mandroides" min="0"
                           value="<%= ((Eq_lider) request.getAttribute("tpEquipo")).getMandro() %>">
                </div>
                <div class="form-group">
                    <label>Autos Voladores:</label>
                    <input type="number" name="autoVoladores" min="0"
                           value="<%= ((Eq_lider) request.getAttribute("tpEquipo")).getAuvola() %>">
                </div>
                <div class="form-group">
                    <label>SDVs:</label>
                    <input type="number" name="sdv" min="0"
                           value="<%= ((Eq_lider) request.getAttribute("tpEquipo")).getSdvs() %>">
                </div>
                <div class="form-group">
                    <label>Helitransporte:</label>
                    <input type="number" name="helitrasporte" min="0"
                           value="<%= ((Eq_lider) request.getAttribute("tpEquipo")).getHeli() %>">
                </div>
                <input class="btn" type="submit" value="Guardar">
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
