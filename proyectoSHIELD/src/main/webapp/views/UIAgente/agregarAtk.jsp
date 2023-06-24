<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Ataque,java.util.List" %>
<%
    String titulo = "Agregar Ataque";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Agregar Ataque</h1>
            <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
        </div>
        <div class="form-container">
            <form action="<%=con%>/Agente6" method="post">
                <div class="form-group">
                    <label>Fecha de Incorporacion:
                        <input type="date" id="fechaInput" name="inicio" style="font-size: 16px"></label><br>
                    <label>Fecha de Retirada:
                        <input type="date" name="fin" style="font-size: 16px"></label>
                </div>
                <% List<Ataque> ataques = (List<Ataque>) request.getAttribute("filtroAtk"); %>
                <div class="form-group">
                    <label>Ataque:</label>
                    <select name="ataque">
                        <% for (Ataque itm : ataques) { %>
                        <option value="<%= itm.getCodAtk() %>"><%= itm.getnAtk() %></option>
                        <% } %>
                    </select>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
            </form>
        </div>
    </section>
</article>
<script>
    var fechaActual = new Date().toISOString().split("T")[0];
    document.getElementById("fechaInput").value = fechaActual;
</script>
<%@ include file="../pie.jsp" %>
