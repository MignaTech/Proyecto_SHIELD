<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Director , modelos.Lider , datos.LiderDAO , java.util.List" %>
<%
    String titulo = "Modificar Director";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Director</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="DirectorSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="codigo"
                       value="<%= ((Director) request.getAttribute("director")).getCodDir() %>">
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" name="nombre"
                           value="<%= ((Director) request.getAttribute("director")).getnDir() %>"><br>
                </div>
                <div class="form-group">
                    <label>Rango:</label>
                    <input type="text" name="rango"
                           value="<%= ((Director) request.getAttribute("director")).getRangoDir() %>"><br>
                </div>
                <div class="form-group">
                    <label>Lider:</label>
                    <select id="lider" name="lider">
                        <%
                            LiderDAO lideres = new LiderDAO();
                            List<Lider> lider = lideres.getLider();
                            for (Lider item : lider) {
                                int idLider = item.getCodLider();
                                String nombreLider = item.getnLider();
                                String selected = "";
                                if (idLider == ((Director) request.getAttribute("director")).getLider()){
                                    selected = "selected";
                                }
                                out.println("<option value=\"" + idLider + "\" " + selected + ">" + nombreLider + "</option>");
                            }
                        %>
                    </select>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="DirectorSV?action=list">Lista de Directores</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
