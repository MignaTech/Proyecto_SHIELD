<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Agentes" %>
<%
    String titulo = "Modificar Agente";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Agente</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="AgentesSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="codigo"
                       value="<%= ((Agentes) request.getAttribute("agente")).getCodAgen() %>">
                <div class="form-group">
                    <label>Agente:</label>
                    <input type="text" name="nombre" value="<%= ((Agentes) request.getAttribute("agente")).getnAgen() %>"><br>
                </div>
                <div class="form-group">
                    <label>Especialidad:</label>
                    <input type="text" name="nombre" value="<%= ((Agentes) request.getAttribute("agente")).getEspe() %>"><br>
                </div>
                <div class="form-group">
                    <label>Tipo de ayuda:</label>
                    <input type="text" name="nombre" value="<%= ((Agentes) request.getAttribute("agente")).getTpAyuda() %>"><br>
                </div>
                <div class="form-group">
                    <label>Director:</label>
                    <input type="text" name="nombre" value="<%= ((Agentes) request.getAttribute("agente")).getAgenDir() %>"><br>
                </div>
                <input class="btn pull-left" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="AgentesSV?action=list">Lista de Agentes</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
