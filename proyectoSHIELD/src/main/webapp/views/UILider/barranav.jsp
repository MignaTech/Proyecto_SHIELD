<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<% esc = request.getContextPath() + "/views/UILider/home.jsp"; %>
<div class="navbar">
    <nav class="nav">
        <div class="ac-container">
            <button class="nav-ul" onclick="window.location.href='<%=con%>/views/UILider/home.jsp'">
                <img src="<%=con%>/assets/img/escri.png" class="nav-img">
                Dashboard
            </button>
            <button class="nav-ul" onclick="window.location.href='<%=con%>/Lider3'">
                <img src="<%=con%>/assets/img/usuarios.png" class="nav-img">
                Editar Perfil
            </button>
            <button class="nav-ul" onclick="window.location.href='<%=con%>/Lider1'">
                <img src="<%=con%>/assets/img/equip.png" class="nav-img">
                Equipo Disponible
            </button>
            <button class="nav-ul" onclick="window.location.href='<%=con%>/views/UILider/agregarJuntas.jsp'">
                <img src="<%=con%>/assets/img/junta.png" class="nav-img">
                Agregar Junta
            </button>
            <button class="nav-ul" onclick="mosBTN('cata_Lider')">
                <img src="<%=con%>/assets/img/catalagos.png" class="nav-img">
                Catalagos
            </button>
            <div class="sec" id="cata_Lider">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulAgen'">Agentes</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulAtk'">Ataques</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulLider'">Lideres</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulGrupo'">Grupos</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulDirector'">Directores</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulJuntas'">Juntas</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/ConsulStark'">Stark</button>
            </div>
        </div>
    </nav>
</div>
