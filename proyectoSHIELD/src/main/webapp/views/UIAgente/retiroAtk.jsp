<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.AgenAtk" %>
<%
    String titulo = "Retiro de Ataque";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Retiro de Ataque</h1>
            <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
        </div>
        <div class="form-container">
            <form action="<%=con%>/Agente8" method="post">
                <input type="hidden" name="agente"
                       value="<%= ((AgenAtk) request.getAttribute("agenAtk")).getCodAgen() %>">
                <input type="hidden" name="ataque"
                       value="<%= ((AgenAtk) request.getAttribute("agenAtk")).getCodAtk() %>">
                <div class="form-group">
                    <label>Fecha de Incorporacion:</label>
                    <label><%= ((AgenAtk) request.getAttribute("agenAtk")).getfInco() %></label>
                </div>
                <div class="form-group">
                    <label>Fecha de Retirada:</label>
                    <input type="date" name="fin" style="font-size: 16px; width: 97%; text-align: center"
                           value="<%= ((AgenAtk) request.getAttribute("agenAtk")).getfReti() %>"><br>
                </div>
                <input class="btn" type="submit" value="Guardar">
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
