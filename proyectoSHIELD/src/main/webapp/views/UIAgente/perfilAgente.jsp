<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Agentes, datos.AgentesDAO, java.util.List" %>
<%
    String titulo = "Editar Perfil";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="barranav.jsp" %>
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Editar Perfil</h1>
            <button class="btn das" onclick="window.location.href='<%=esc%>'">Dashboard</button>
        </div>
        <div class="form-container">
            <form action="<%=con%>/Agente4" method="post">
                <input type="hidden" name="codigo"
                       value="<%= ((Agentes) request.getAttribute("agente")).getCodAgen() %>">
                <div class="form-group">
                    <label>Agente:</label>
                    <input type="text" name="nombre" value="<%= ((Agentes) request.getAttribute("agente")).getnAgen() %>"><br>
                </div>
                <div class="form-group">
                    <label>Especialidad:</label>
                    <input type="text" name="especializacion" value="<%= ((Agentes) request.getAttribute("agente")).getEspe() %>"><br>
                </div>
                <div class="form-group">
                    <label>Tipo de ayuda:</label>
                    <input type="text" name="tipoAyuda" value="<%= ((Agentes) request.getAttribute("agente")).getTpAyuda() %>"><br>
                </div>
                <div class="form-group">
                    <label>Director:</label>
                    <select id="director" name="director">
                        <%
                            List<Agentes> agen = new AgentesDAO().getAgentes();
                            for (Agentes item : agen) {
                                int idAgente = item.getCodAgen();
                                if (((Agentes) request.getAttribute("agente")).getCodAgen()!=idAgente){
                                    String nombreAgente = item.getnAgen();
                                    String selected = "";
                                    if (idAgente==((Agentes) request.getAttribute("agente")).getAgenDir()){
                                        selected = "selected";
                                    }
                                    out.println("<option value=\"" + idAgente + "\" " + selected + ">" + nombreAgente + "</option>");
                                }
                            }
                        %>
                    </select>
                </div>
                <input class="btn pull-left" type="submit" value="Guardar">
            </form>
        </div>
    </section>
</article>
<%@ include file="../pie.jsp" %>
