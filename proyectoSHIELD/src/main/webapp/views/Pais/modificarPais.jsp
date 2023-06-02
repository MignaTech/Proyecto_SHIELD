<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Paises" %>
<%
    String titulo = "Modificar Pais";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Pais</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="PaisesSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="codigo"
                       value="<%= ((Paises) request.getAttribute("paises")).getCodPais() %>">
                <div class="form-group">
                    <label>Pais:</label>
                    <input type="text" name="nombre"
                           value="<%= ((Paises) request.getAttribute("paises")).getnPais() %>"><br>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="PaisesSV?action=list">Lista de paises</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
