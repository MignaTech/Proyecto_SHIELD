<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Paises,java.util.List" %>
<%
    String titulo = "Agregar Ataque";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Añadir Ataque</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form id="myForm" action="AtaqueSV" method="post">
                <input type="hidden" name="meto2" value="add">
                <div class="form-group">
                    <label for="codigo">Código:</label>
                    <input type="number" id="codigo" name="codigo" required><br>
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" required><br>
                </div>
                <div class="form-group">
                    <label for="bajas">Numero de Bajas:</label>
                    <input type="number" id="bajas" name="bajas" min="0" value="0" required><br>
                </div>
                <div class="form-group">
                    <label for="heridos">Numero de Heridos:</label>
                    <input type="number" id="heridos" name="heridos" min="0" value="0" required><br>
                </div>
                <% List<Paises> paises = (List<Paises>) request.getAttribute("paises"); %>
                <div class="form-group">
                    <label>Pais Afectado:</label>
                    <select id="pais" name="pais">
                        <% for (Paises itm : paises) { %>
                        <option value="<%= itm.getCodPais() %>"><%= itm.getnPais() %></option>
                        <% } %>
                    </select>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
                <a class="btn secondary pull-right" href="AtaqueSV?action=list">Lista de Ataques</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
