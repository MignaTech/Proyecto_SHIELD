<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./views/encabezado.jsp" %>
<c:choose>
    <c:when test="${sessionScope.currentUser.rol.n_rol eq 'Administrador'}">
        <c:redirect url="${request.contextPath}/views/UIAdmin/home.jsp"/>
    </c:when>
    <c:when test="${sessionScope.currentUser.rol.n_rol eq 'Agente'}">
        <c:redirect url="${request.contextPath}/views/UIAgente/home.jsp"/>
    </c:when>
    <c:when test="${sessionScope.currentUser.rol.n_rol eq 'Lider'}">
        <c:redirect url="${request.contextPath}/views/UILider/home.jsp"/>
    </c:when>
    <c:when test="${sessionScope.currentUser.rol.n_rol eq 'Director'}">
        <c:redirect url="${request.contextPath}/views/UIDirec/home.jsp"/>
    </c:when>
    <c:otherwise>
        <div class="cont-body"
             style="background-image: url('<%=con%>/assets/img/shield.svg');background-position: center;">
            <div style="background-color: #dce5fd;padding: 15px;width: 333px;">
                <h1 style="text-align: center">S.H.I.E.L.D.</h1>
                <p style="font-size: large;">
                    En el universo de Marvel Comics, SHIELD (acrónimo de Strategic Homeland Intervention, Enforcement,
                    and
                    Logistics Division) es una organización ficticia de seguridad y espionaje internacional. SHIELD fue
                    creado por Stan Lee y Jack Kirby, y apareció por primera vez en el cómic "Strange Tales" #135 en
                    agosto
                    de 1965.
                </p>
            </div>
        </div>
        <%@ include file="./views/pie.jsp" %>
    </c:otherwise>
</c:choose>
<%--
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>S.H.I.E.L.D.</title>
    <link rel="stylesheet" href="./assets/css/carga.css" />
</head>
<body>
    <script src="./assets/js/carga.js"></script>
</body>
</html>
--%>

