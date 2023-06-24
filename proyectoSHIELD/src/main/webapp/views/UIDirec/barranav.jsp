<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<% esc = request.getContextPath() + "/views/UIDirec/home.jsp"; %>
<c:choose>
    <c:when test="${sessionScope.currentUser.rol.n_rol eq 'Director'}">
        <div class="navbar">
            <nav class="nav">
                <div class="ac-container">
                    <button class="nav-ul" onclick="window.location.href='<%=esc%>'">
                        <img src="<%=con%>/assets/img/escri.png" class="nav-img">
                        Dashboard
                    </button>
                    <button class="nav-ul" onclick="window.location.href='<%=con%>/Direc3'">
                        <img src="<%=con%>/assets/img/usuarios.png" class="nav-img">
                        Editar Perfil
                    </button>
                    <button class="nav-ul" onclick="window.location.href='<%=con%>/views/UIDirec/verSubdi.jsp'">
                        <img src="<%=con%>/assets/img/catalagos.png" class="nav-img">
                        Subdivisión
                    </button>
                    <button class="nav-ul" onclick="mosBTN('cata_agente')">
                        <img src="<%=con%>/assets/img/catalagos.png" class="nav-img">
                        Catalagos
                    </button>
                    <div class="sec" id="cata_agente">
                        <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulAgen'">Agentes</button>
                        <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulAtk'">Ataques</button>
                        <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulLider'">Lideres</button>
                        <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulGrupo'">Grupos</button>
                        <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulDirector'">Directores</button>
                        <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulJuntas'">Juntas</button>
                        <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulStark'">Stark</button>
                        <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulSubdi'">Subdivision</button>
                    </div>

                </div>
            </nav>
        </div>
    </c:when>
    <c:when test="${sessionScope.currentUser.rol.n_rol eq 'Agente'}">
        <c:redirect url="${request.contextPath}/views/UIAgente/home.jsp" />
    </c:when>
    <c:when test="${sessionScope.currentUser.rol.n_rol eq 'Administrador'}">
        <c:redirect url="${request.contextPath}/views/UIAdmin/home.jsp" />
    </c:when>
    <c:when test="${sessionScope.currentUser.rol.n_rol eq 'Lider'}">
        <c:redirect url="${request.contextPath}/views/UILider/home.jsp" />
    </c:when>
    <c:otherwise>
        <c:redirect url="${request.contextPath}/views/user/login.jsp" />
    </c:otherwise>
</c:choose>
