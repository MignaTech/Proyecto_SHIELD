<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="navbar">
    <nav class="nav">
        <div class="ac-container">
            <button class="nav-ul" onclick="window.location.href='<%=esc%>'">
                <img src="<%=con%>/assets/img/escri.png" class="nav-img">
                Dashboard
            </button>
            <button class="nav-ul" onclick="mosBTN('capacidad')">
                <img src="<%=con%>/assets/img/danio.png" class="nav-img">
                Capacidad
            </button>
            <div class="sec" id="capacidad">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/CapacidadSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/CapacidadSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('agente')">
                <img src="<%=con%>/assets/img/agente.png" class="nav-img">
                Agentes
            </button>
            <div class="sec" id="agente">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/AgentesSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/AgentesSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('equipo')">
                <img src="<%=con%>/assets/img/equip.png" class="nav-img">
                Equipo
            </button>
            <div class="sec" id="equipo">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/EquipoSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/EquipoSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('grupoSH')">
                <img src="<%=con%>/assets/img/grupo.png" class="nav-img">
                Grupo-SH
            </button>
            <div class="sec" id="grupoSH">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/SuperH_SV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/SuperH_SV?action=showAddForm'">Agregar</button>
            </div>
        </div>
    </nav>
</div>
