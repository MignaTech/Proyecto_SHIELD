<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ include file="../encabezado.jsp" %>
    <div class="cont-body">
        <section class="cont-base" style="width: 570px">
            <div class="base-header">
                <h1 class="base-title">Login</h1>
            </div>
            <%  String mensaje =  (String) request.getAttribute("msj");
                if (request.getAttribute("msj") != null && !mensaje.isEmpty()){
                    pageContext.setAttribute("msj", mensaje);%>
            <h1 style="color: red"><b><%=mensaje%></b></h1> <% } %>
            <div class="form-container">
                <form action="<%=con%>/login" method="post">
                    <div class="form-group">
                    <label for="nombre"><b>Nombre</b></label>
                    <input type="text" placeholder="Ingrese su nombre" id="nombre" name="nombre" required>
                    </div>
                    <div class="form-group">
                    <label for="password"><b>Contraseña</b></label>
                    <input type="password" placeholder="Ingrese su Contraseña" name="password" id="password" required>
                    </div>
                    <button class="btn" type="submit">Ingresar</button>
                    <a class="btn secondary pull-right" href="./signup.jsp">No tiene cuenta? Registrese ahora!</a>
                </form>
            </div>
        </section>
    </div>
<%@ include file="../pie.jsp" %>
