<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<div class="navbar">
    <nav class="nav">
        <div class="ac-container">
            <button class="nav-ul" onclick="window.location.href='<%=esc%>'">
                <img src="<%=con%>/assets/img/escri.png" class="nav-img">
                Dashboard
            </button>
            <c:if test="${!empty sessionScope.currentUser}">
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
            </c:if>
        </div>
    </nav>
</div>
