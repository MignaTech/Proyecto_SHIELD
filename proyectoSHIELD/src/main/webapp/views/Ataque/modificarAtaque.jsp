<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Ataque,modelos.Paises,datos.PaisesDAO,java.util.List" %>
<%
    String titulo = "Modificar Ataque";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Modificar Ataque</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form action="AtaqueSV" method="post">
                <input type="hidden" name="meto2" value="edit">
                <input type="hidden" name="codigo"
                       value="<%= ((Ataque) request.getAttribute("ataque")).getCodAtk() %>">
                <div class="form-group">
                    <label>Ataque:</label>
                    <input type="text" name="nombre"
                           value="<%= ((Ataque) request.getAttribute("ataque")).getnAtk() %>"><br>
                </div>
                <div class="form-group">
                    <label># Bajas:</label>
                    <input type="number" name="bajas"
                           value="<%= ((Ataque) request.getAttribute("ataque")).getNroBajas() %>"><br>
                </div>
                <div class="form-group">
                    <label># Heridos:</label>
                    <input type="number" name="heridos"
                           value="<%= ((Ataque) request.getAttribute("ataque")).getNroHeridos() %>"><br>
                </div>
                <div class="form-group">
                    <label>Pais Afectado:</label>
                    <select id="pais" name="pais">
                        <%
                            List<Paises> paises = new PaisesDAO().getPaisess();
                            for (Paises item : paises) {
                                String idPais = item.getCodPais();
                                String nombrePais = item.getnPais();
                                String selected = "";
                                if (idPais.equals(((Ataque) request.getAttribute("ataque")).getPaisAtk())){
                                    selected = "selected";
                                }
                                out.println("<option value=\"" + idPais + "\" " + selected + ">" + nombrePais + "</option>");
                            }
                        %>
                    </select>
                </div>
                <input class="btn" type="submit" value="Guardar">
                <a class="btn secondary pull-right" href="AtaqueSV?action=list">Lista de Ataques</a>
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
