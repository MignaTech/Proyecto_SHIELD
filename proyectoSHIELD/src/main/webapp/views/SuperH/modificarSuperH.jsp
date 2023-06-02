<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.GrupoSh" %>
<%
    String titulo = "Modificar Grupo Super Heroe";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Grupo Super Heroe</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="SuperH_SV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="codigo"
                       value="<%= ((GrupoSh) request.getAttribute("gp_sh")).getCodGpSp() %>">
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" name="nombre"
                           value="<%= ((GrupoSh) request.getAttribute("gp_sh")).getnGp() %>"><br>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="SuperH_SV?action=list">Lista de Grupo de Super Heroes</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
