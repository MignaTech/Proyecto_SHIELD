<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ include file="./encabezado.jsp" %>
<c:if test="${sessionScope.currentUser!=null}">
    <%@ include file="./barranav.jsp" %>
    <div class="cont-body" style="background-image: url('<%=con%>/assets/img/logo_shield.webp');
            background-position: center;">
        <div style="color: red">
            <p>Nombre del usuario es = ${sessionScope.currentUser.nombre}</p>
            <p>Contra del usuario es = ${sessionScope.currentUser.contrasenia}</p>
            <p>tipo del usuario es = ${sessionScope.currentUser.f_rol}</p>
            <p>tipo del usuario es = ${sessionScope.currentUser.rol.n_rol}</p>
        </div>
    </div>
</c:if>
<%@ include file="./pie.jsp" %>

<%--<%--%>
<%--    if (uhome.getRol().getN_rol() == null)--%>
<%--    } else if (uhome.getRol().getN_rol().equals("Administrador")) {--%>
<%--        response.sendRedirect(request.getContextPath()+"/views/UIAdmin/home.jsp");--%>
<%--    } else if (uhome.getRol().getN_rol().equals("Agente")) {--%>
<%--        response.sendRedirect(request.getContextPath()+"/views/UIAgente/home.jsp");--%>
<%--    }--%>
<%--%>--%>

