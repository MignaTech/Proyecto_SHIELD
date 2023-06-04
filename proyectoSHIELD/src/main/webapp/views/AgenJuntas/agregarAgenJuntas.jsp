<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Agentes, modelos.Juntas, java.util.List" %>
<%
    String titulo = "Agregar Agente a Junta";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Añadir Agente a Junta</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="AgenJuntasSV" method="post">
                <input type="hidden" name="meto2" value="add">
                <% List<Agentes> agentes = (List<Agentes>) request.getAttribute("agentes"); %>
                <div class="form-group">
                    <label>Agente:</label>
                    <select id="agente" name="agente">
                        <% for (Agentes itm : agentes) { %>
                            <% if (itm.getCodAgen()!=0) { %>
                                <option value="<%= itm.getCodAgen() %>"><%= itm.getnAgen() %></option>
                        <% }} %>
                    </select>
                </div>
                <% List<Juntas> juntas = (List<Juntas>) request.getAttribute("juntas"); %>
                <div class="form-group">
                    <label>Juntas:</label>
                    <select id="junta" name="junta">
                        <% for (Juntas itm : juntas) { %>
                            <option value="<%= itm.getCodJunta() %>"><%= itm.getContenido() %></option>
                        <% } %>
                    </select>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
                <a class="btn secondary pull-right" href="AgenJuntasSV?action=list">Lista de Agente-Juntas</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
