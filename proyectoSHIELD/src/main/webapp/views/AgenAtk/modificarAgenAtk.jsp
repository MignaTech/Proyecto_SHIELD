<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.AgenAtk , modelos.Agentes , modelos.Ataque , java.util.List" %>
<%@ page import="datos.AgentesDAO , datos.AtaqueDAO" %>
<%
    String titulo = "Modificar Heroe";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Agentes que atienden Ataques</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="AgenAtkSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="agente"
                       value="<%= ((AgenAtk) request.getAttribute("agenAtk")).getCodAgen() %>">
                <input type="hidden" name="ataque"
                       value="<%= ((AgenAtk) request.getAttribute("agenAtk")).getCodAtk() %>">
                <div class="form-group">
                    <%  List<Agentes> agentes = new AgentesDAO().getAgentes();
                        for (Agentes item : agentes) {
                            int idAgente = item.getCodAgen();
                            String nombreAgente = item.getnAgen();
                            if (idAgente == ((AgenAtk) request.getAttribute("agenAtk")).getCodAgen()) { %>
                    <label>Agente: <%=nombreAgente%></label>
                    <% } } %>
                    <%  List<Ataque> ataques = new AtaqueDAO().getAtaque();
                        for (Ataque item : ataques) {
                            int idAtaque = item.getCodAtk();
                            String nombreAtaque = item.getnAtk();
                            if (idAtaque == ((AgenAtk) request.getAttribute("agenAtk")).getCodAtk()) { %>
                    <label>Ataque: <%=nombreAtaque%></label>
                    <% } } %>
                </div>
                <div class="form-group">
                    <label>Fecha de Incorporacion:</label>
                    <input type="date" name="inicio" style="font-size: 16px; width: 97%; text-align: center"
                           value="<%= ((AgenAtk) request.getAttribute("agenAtk")).getfInco() %>"><br>
                </div>
                <div class="form-group">
                    <label>Fecha de Retirada:</label>
                    <input type="date" name="fin" style="font-size: 16px; width: 97%; text-align: center"
                           value="<%= ((AgenAtk) request.getAttribute("agenAtk")).getfReti() %>"><br>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="AgenAtkSV?action=list">Lista de Agentes-Ataques</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
