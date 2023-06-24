<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ page import="datos.*" %>
<%@ include file="encabezado.jsp" %>
<%@ include file="barranav.jsp" %>
<%
    int countAgentes = new AgentesDAO().getAgentes().size();
    int countAtaque = new AtaqueDAO().getAtaque().size();
    int countLider = new LiderDAO().getLider().size();
    int countGruS = new SuperHDAO().getSuperHs().size();
    int countDirector = new DirectorDAO().getDirector().size();
    int countJunta = new JuntasDAO().getJuntas().size();
    int countSiSh = new SiShDAO().getSiSh().size();
    int countSubdi = new SubdivisionesDAO().getSubdivisiones().size();
%>
<div class="cont-body">
    <c:if test="${sessionScope.currentUser != null}">
        <p>
            Bienvenid@ del Director@ ${sessionScope.perDirec.nDir}
        </p>
    </c:if>
    <div class="box-container" style="padding-bottom: 20px">
        <div class="box bg-das" onclick="window.location.href='<%=con%>/Direc3'">
            <div class="text">
                <h2 class="nom-tabla">Editar Perfil</h2>
            </div>
            <img src="<%=con%>/assets/img/usuarios.png">
        </div>
        <div class="box bg-das" onclick="window.location.href='<%=con%>/views/UIDirec/verSubdi.jsp'">
            <div class="text">
                <h2 class="nom-tabla">Subdivision</h2>
            </div>
            <img src="<%=con%>/assets/img/catalagos.png">
        </div>
    </div>
    <div class="box-container">
        <div class="box bg-das2" onclick="window.location.href='<%=con%>/ConsulAgen'">
            <div class="text">
                <h2 class="cant-tabla"><%= countAgentes %>
                </h2>
                <h2 class="nom-tabla">Agentes de SHIELD</h2>
            </div>
            <img src="<%=con%>/assets/img/agente.png">
        </div>
        <div class="box bg-das2" onclick="window.location.href='<%=con%>/ConsulAtk'">
            <div class="text">
                <h2 class="cant-tabla"><%= countAtaque %>
                </h2>
                <h2 class="nom-tabla">Ataques</h2>
            </div>
            <img src="<%=con%>/assets/img/ataque.png">
        </div>
        <div class="box bg-das2" onclick="window.location.href='<%=con%>/ConsulLider'">
            <div class="text">
                <h2 class="cant-tabla"><%= countLider %>
                </h2>
                <h2 class="nom-tabla">Lideres</h2>
            </div>
            <img src="<%=con%>/assets/img/lider.png">
        </div>
        <div class="box bg-das2" onclick="window.location.href='<%=con%>/ConsulGrupo'">
            <div class="text">
                <h2 class="cant-tabla"><%= countGruS %>
                </h2>
                <h2 class="nom-tabla">Grupos Super Heroes</h2>
            </div>
            <img src="<%=con%>/assets/img/grupo.png">
        </div>
        <div class="box bg-das2" onclick="window.location.href='<%=con%>/ConsulDirector'">
            <div class="text">
                <h2 class="cant-tabla"><%= countDirector %>
                </h2>
                <h2 class="nom-tabla">Directores</h2>
            </div>
            <img src="<%=con%>/assets/img/director.png">
        </div>
        <div class="box bg-das2" onclick="window.location.href='<%=con%>/ConsulJuntas'">
            <div class="text">
                <h2 class="cant-tabla"><%= countJunta %>
                </h2>
                <h2 class="nom-tabla">Juntas</h2>
            </div>
            <img src="<%=con%>/assets/img/junta.png">
        </div>
        <div class="box bg-das2" onclick="window.location.href='<%=con%>/ConsulStark'">
            <div class="text">
                <h2 class="cant-tabla"><%= countSiSh %>
                </h2>
                <h2 class="nom-tabla">Stark Industries</h2>
            </div>
            <img src="<%=con%>/assets/img/Stark.png">
        </div>

        <div class="box bg-das2" onclick="window.location.href='<%=con%>/ConsulSubdi'">
            <div class="text">
                <h2 class="cant-tabla"><%= countSubdi %></h2>
                <h2 class="nom-tabla">Subdivisiones</h2>
            </div>
            <img src="<%=con%>/assets/img/catalagos.png">
        </div>

    </div>
</div>
<%@ include file="../pie.jsp" %>
