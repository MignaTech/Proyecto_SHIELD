<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Agentes,modelos.Ataque,java.util.List" %>
<%
    String titulo = "Agregar Heroe";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Añadir Agente-Ataque</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="AgenAtkSV" method="post">
                <input type="hidden" name="meto2" value="add">
                <div class="form-group">
                    <label for="inicio">Fecha de Incorporacion:
                        <input type="date" id="inicio" name="inicio" style="font-size: 16px" required></label><br>
                    <label for="fin">Fecha de Retirada:
                        <input type="date" id="fin" name="fin" style="font-size: 16px" required></label>
                </div>
                <% List<Agentes> agentes = (List<Agentes>) request.getAttribute("agentes"); %>
                <div class="form-group">
                    <label>Agente:</label>
                    <select id="agente" name="agente">
                        <% for (Agentes itm : agentes) { %>
                        <option value="<%= itm.getCodAgen() %>"><%= itm.getnAgen() %></option>
                        <% } %>
                    </select>
                </div>
                <% List<Ataque> ataques = (List<Ataque>) request.getAttribute("ataques"); %>
                <div class="form-group">
                    <label>Ataque:</label>
                    <select id="ataque" name="ataque">
                        <% for (Ataque itm : ataques) { %>
                        <option value="<%= itm.getCodAtk() %>"><%= itm.getnAtk() %></option>
                        <% } %>
                    </select>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
                <a class="btn secondary pull-right" href="AgenAtkSV?action=list">Lista de Agente-Ataque</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
