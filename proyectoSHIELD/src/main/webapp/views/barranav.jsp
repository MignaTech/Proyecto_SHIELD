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
            <button class="nav-ul" onclick="mosBTN('pais')">
                <img src="<%=con%>/assets/img/pais.png" class="nav-img">
                Pais
            </button>
            <div class="sec" id="pais">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/PaisesSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/PaisesSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('tip_aliens')">
                <img src="<%=con%>/assets/img/alien.png" class="nav-img">
                Tipos Aliens
            </button>
            <div class="sec" id="tip_aliens">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/Tip_AlienSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/Tip_AlienSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('ataques')">
                <img src="<%=con%>/assets/img/ataque.png" class="nav-img">
                Ataques
            </button>
            <div class="sec" id="ataques">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/AtaqueSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/AtaqueSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('lideres')">
                <img src="<%=con%>/assets/img/lider.png" class="nav-img">
                Lideres
            </button>
            <div class="sec" id="lideres">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/LiderSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/LiderSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('director')">
                <img src="<%=con%>/assets/img/director.png" class="nav-img">
                Director
            </button>
            <div class="sec" id="director">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/DirectorSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/DirectorSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('junta')">
                <img src="<%=con%>/assets/img/junta.png" class="nav-img">
                Juntas
            </button>
            <div class="sec" id="junta">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/JuntasSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/JuntasSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('stark')">
                <img src="<%=con%>/assets/img/Stark.png" class="nav-img">
            </button>
            <div class="sec" id="stark">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/SiShSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/SiShSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('age_jun')">
                <img src="<%=con%>/assets/img/junta.png" class="nav-img">
                Agentes-Juntas
            </button>
            <div class="sec" id="age_jun">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/AgenJuntasSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/AgenJuntasSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('age_atk')">
                <img src="<%=con%>/assets/img/protege.png" class="nav-img">
                Agentes-Ataque
            </button>
            <div class="sec" id="age_atk">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/AgenAtkSV'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/AgenAtkSV?action=showAddForm'">Agregar</button>
            </div>
            <button class="nav-ul" onclick="mosBTN('heroe')">
                <img src="<%=con%>/assets/img/superHero.png" class="nav-img">
                Heroe
            </button>
            <div class="sec" id="heroe">
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/HeroeSV?page=1'">Listar</button>
                <button class="nav-ul ocultar" onclick="window.location.href='<%=con%>/HeroeSV?action=showAddForm'">Agregar</button>
            </div>
        </div>
    </nav>
</div>
