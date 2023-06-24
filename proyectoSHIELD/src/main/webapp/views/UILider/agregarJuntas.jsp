<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String titulo = "Agregar Junta";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Agregar Junta</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="<%=con%>/Lider5" method="post">
                <div class="form-group">
                    <label for="contenido">Contenido:</label>
                    <input type="text" id="contenido" name="contenido" required><br>
                </div>
                <div class="form-group">
                    <label for="fecha">Fecha:</label>
                    <input type="date" id="fecha" name="fecha" style="width: 97%;font-size: 16px;" required><br>
                </div>
                <input class="btn pull-left" type="submit" value="Agregar">
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
