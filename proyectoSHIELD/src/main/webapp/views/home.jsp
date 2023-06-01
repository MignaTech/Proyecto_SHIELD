<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="datos.*" %>
<%@ include file="./encabezado.jsp" %>
<%
    int countCapacidad = new CapacidadDAO().getCapacidad().size();
    int countEquipo = new EquipoDAO().getEquipos().size();
    int countPais = new PaisesDAO().getPaisess().size();
    int countGruS = new SuperHDAO().getSuperHs().size();
    int countHeroes = new HeroeDAO().countHeroe();
    int countAgentes = new AgentesDAO().getAgentes().size();
    int countRaza = new Tip_AlienDAO().getTpAlien().size();
    int countAtaque = new AtaqueDAO().getAtaque().size();
    int countLider = new LiderDAO().getLider().size();
    int countDirector = new DirectorDAO().getDirector().size();
    int countJunta = new JuntasDAO().getJuntas().size();
    int countSiSh = new SiShDAO().getSiSh().size();
    int countAgenAtk = new AgenAtkDAO().getAgenAtk().size();
    int countAgenJuntas = new AgenJuntasDAO().getAgenJuntas().size();
%>
<%@ include file="./barranav.jsp" %>
    <div class="cont-body">
        <div class="box-container">
            <div id="btnListAgente" class="box bg-das">
                <div class="text">
                    <h2 class="cant-tabla"><%= countAgentes %></h2>
                    <h2 class="nom-tabla">Agentes</h2>
                </div>
                <img src="<%=con%>/assets/img/agente.png">
            </div>
            <div id="btnListCapacidad" class="box bg-das">
                <div class="text">
                    <h2 class="cant-tabla"><%= countCapacidad %></h2>
                    <h2 class="nom-tabla">Capacidades</h2>
                </div>
                <img src="<%=con%>/assets/img/danio.png">
            </div>
            <div id="btnListEquipo" class="box bg-das">
                <div class="text">
                    <h2 class="cant-tabla"><%= countEquipo %></h2>
                    <h2 class="nom-tabla">Equipos</h2>
                </div>
                <img src="<%=con%>/assets/img/equip.png">
            </div>
            <div id="btnListGrupo" class="box bg-das">
                <div class="text">
                    <h2 class="cant-tabla"><%= countGruS %></h2>
                    <h2 class="nom-tabla">Grupos Super Heroes</h2>
                </div>
                <img src="<%=con%>/assets/img/grupo.png">
            </div>
            <div id="btnListPais" class="box bg-das">
                <div class="text">
                    <h2 class="cant-tabla"><%= countPais %></h2>
                    <h2 class="nom-tabla">Paises</h2>
                </div>
                <img src="<%=con%>/assets/img/pais.png">
            </div>
            <div id="btnListTpRaza" class="box bg-das">
                <div class="text">
                    <h2 class="cant-tabla"><%= countRaza %></h2>
                    <h2 class="nom-tabla">Tipos de Alien</h2>
                </div>
                <img src="<%=con%>/assets/img/alien.png">
            </div>
            <div id="btnListAtaque" class="box bg-das2">
                <div class="text">
                    <h2 class="cant-tabla"><%= countAtaque %></h2>
                    <h2 class="nom-tabla">Ataques</h2>
                </div>
                <img src="<%=con%>/assets/img/ataque.png">
            </div>
            <div id="btnListLider" class="box bg-das2">
                <div class="text">
                    <h2 class="cant-tabla"><%= countLider %></h2>
                    <h2 class="nom-tabla">Lideres</h2>
                </div>
                <img src="<%=con%>/assets/img/lider.png">
            </div>
            <div id="btnListDirector" class="box bg-das2">
                <div class="text">
                    <h2 class="cant-tabla"><%= countDirector %></h2>
                    <h2 class="nom-tabla">Directores</h2>
                </div>
                <img src="<%=con%>/assets/img/director.png">
            </div>
            <div id="btnListHeroe" class="box bg-das2">
                <div class="text">
                    <h2 class="cant-tabla"><%= countHeroes %></h2>
                    <h2 class="nom-tabla">Heroes</h2>
                </div>
                <img src="<%=con%>/assets/img/superHero.png">
            </div>
            <div id="btnListJuntas" class="box bg-das2">
                <div class="text">
                    <h2 class="cant-tabla"><%= countJunta %></h2>
                    <h2 class="nom-tabla">Juntas</h2>
                </div>
                <img src="<%=con%>/assets/img/junta.png">
            </div>
            <div id="btnListStark" class="box bg-das2">
                <div class="text">
                    <h2 class="cant-tabla"><%= countSiSh %></h2>
                    <h2 class="nom-tabla">Stark Industries</h2>
                </div>
                <img src="<%=con%>/assets/img/Stark.png">
            </div>
            <div id="btnListAgenJunta" class="box bg-das2">
                <div class="text">
                    <h2 class="cant-tabla"><%= countAgenJuntas %></h2>
                    <h2 class="nom-tabla">Agentes-Juntas</h2>
                </div>
                <img src="<%=con%>/assets/img/junta.png">
            </div>
            <div id="btnListAgenAtk" class="box bg-das2">
                <div class="text">
                    <h2 class="cant-tabla"><%= countAgenAtk %></h2>
                    <h2 class="nom-tabla">Agentes-Ataque</h2>
                </div>
                <img src="<%=con%>/assets/img/protege.png">
            </div>
        </div>
    </div>
<%@ include file="./pie.jsp" %>

