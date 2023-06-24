<%@ page import="modelos.GrupoSh" %>
<%@ page import="java.util.List" %>
<%@ page import="datos.SuperHDAO" %>
<%@ page import="modelos.Lider" %>
<%@ page import="datos.LiderDAO" %>
<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ include file="../encabezado.jsp" %>
<style>
    * {
        padding: 0;
        margin: 0;
        border: none;
    }
    .form-container .show {
        display: block;
    }
    .form-container .hide {
        display: none;
    }
    .form-container .tabs {
        display: grid;
        grid-template-columns: repeat(5, 1fr);
        background: #179b77;
        height: 45px;
        margin-bottom: 20px;
    }
    .form-container .tabs a {
        text-align: center;
        color: white;
        text-decoration: none;
        padding: 12px 22px;
    }
    .form-container .tabs a.active,
    .form-container .tabs a:hover {
        background: rgba(19, 35, 47, 0.9);
        border-right: none;
        transition: all 0.5s linear;
    }
    .form-container .form-action {
        padding: 0 20px;
        position: relative;
    }
    .form-container h1 {
        text-align: center;
        color: #fff;
        font-weight: 300;
        margin: 0 0 40px;
    }
    .inputContainer {
        position: relative;
        height: 45px;
        width: 100%;
        margin-bottom: 25px;
    }
    .input {
        font-size: 22px;
        position: absolute;
        top: 0;
        left: 0;
        padding: 0 20px;
        height: 100%;
        width: 100%;
        color: black;
        border-bottom: 1px solid #a0b3b0;
        border-radius: 5px;
        outline: none;
        background: none;
        z-index: 1;
    }
    .input:focus {
        border-color: #1ab188;
    }
    .lbl {
        position: absolute;
        user-select: none;
        color: gray;
        top: 10px;
        left: 15px;
        padding: 0 4px;
        font-size: 22px;
        transition: 0.5s;
        z-index: 0;
    }
    ::placeholder {
        color: transparent;
    }
    .input:focus + .lbl,
    .input:not(:placeholder-shown)+ .lbl {
        top: -12px;
        left: 3px;
        z-index: 10;
        font-size: 19px;
        font-weight: 600;
        color: #1ab188;
    }
    .btn-form {
        display: block;
        width: 100%;
        border: 0;
        outline: none;
        border-radius: 5px;
        cursor: pointer;
        padding: 15px 0;
        font-size: 2rem;
        background: #1ab188;
        color: #fff;
        transition: all 0.5s ease;
    }
    .btn-form:hover,
    .btn-form:active {
        background: #008000b2
    }

    .top-row:after {
        content: "";
        display: table;
        clear: both;
    }
    .top-row > div {
        float: left;
        width: 48%;
        margin-right: 4%;
    }
    .top-row > div:last-child {
        margin: 0;
    }
</style>
    <div class="cont-body">
        <section class="cont-base" style="width: 570px;">
            <div class="base-header">
                <h1 class="base-title">Sig Up</h1>
            </div>
            <div class="form-container">
                <c:if test="${not empty requestScope.errorSig}">
                    <span style="text-align: center;color: red; font-weight: bold; font-size: large;display: block;">
                            ${requestScope.errorSig}
                    </span>
                </c:if>
                <select id="tab-sel" class="input" style="position: inherit; margin-bottom: 20px;">
                    <c:if test="${not empty sessionScope.IsAdmin}">
                        <option value="admi">Administrador</option>
                    </c:if>
                    <option value="agen" selected>Agente</option>
                    <option value="lide">Lider</option>
                    <option value="dire">Director</option>
                    <option value="ceos">Ceo Stark Industries</option>
                </select>
                <div id="admi" class="tab-cont hide">
                    <form action="<%=con%>/signupAdmin" method="post">
                        <input type="hidden" name="idenAdmin" value="1">
                        <div class="inputContainer">
                            <input type="text" name="userNameAdmin" class="input" placeholder="a">
                            <label class="lbl">UserName</label>
                        </div>
                        <div class="inputContainer">
                            <input type="password" name="contraseniaAdmin" class="input" placeholder="a">
                            <label class="lbl">Contraseña</label>
                        </div>
                        <input type="submit" class="btn-form" value="Registrarse">
                    </form>
                </div>
                <div id="lide" class="tab-cont hide">
                    <form action="<%=con%>/signupLid" method="post">
                        <%
                            List<GrupoSh> grups = new SuperHDAO().getSuperHs();
                        %>
                        <div class="inputContainer">
                            <select name="grupo" class="input">
                                <% for (GrupoSh itm : grups) { %>
                                <option value="<%= itm.getCodGpSp() %>"><%= itm.getnGp() %></option>
                                <% } %>
                            </select>
                            <label class="lbl">Grupo de Super Heroes que Lidera</label>
                        </div>
                        <div class="inputContainer">
                            <input type="text" name="nombreLid" class="input" placeholder="a">
                            <label class="lbl">Nombre del Lider:</label>
                        </div>
                        <div class="top-row">
                            <div class="inputContainer">
                                <input type="number" name="e1" class="input" min="0" value="0">
                                <label class="lbl">Mandroides:</label>
                            </div>
                            <div class="inputContainer">
                                <input type="number" name="e2" class="input" min="0" value="0">
                                <label class="lbl">Autos Voladores:</label>
                        </div></div>
                        <div class="top-row">
                            <div class="inputContainer">
                                <input type="number" name="e3" class="input" min="0" value="0">
                                <label class="lbl">SDVs:</label>
                            </div>
                            <div class="inputContainer">
                                <input type="number" name="e4" class="input" min="0" value="0">
                                <label class="lbl">Helitransporte:</label>
                        </div></div>
                        <div class="top-row">
                            <input type="hidden" name="idenLid" value="3">
                            <div class="inputContainer">
                                <input type="text" name="userNameLid" class="input" placeholder="a">
                                <label class="lbl">UserName</label>
                            </div>
                            <div class="inputContainer">
                                <input type="password" name="contraseniaLid" class="input" placeholder="a">
                                <label class="lbl">Contraseña</label>
                        </div></div>
                        <input type="submit" class="btn-form" value="Registrarse">
                    </form>
                </div>
                <div id="dire" class="tab-cont hide">
                    <form action="<%=con%>/signupDirector" method="post">
                        <div class="inputContainer">
                            <input type="text" name="nombreDir" class="input" placeholder="a">
                            <label class="lbl">Nombre</label>
                        </div>
                        <div class="inputContainer">
                            <input type="text" name="rangoDir" class="input" placeholder="a">
                            <label class="lbl">Rango</label>
                        </div>
                        <% List<Lider> lider = new LiderDAO().getLider(); %>
                        <div class="inputContainer">
                            <select name="liderDir" class="input">
                                <% for (Lider itm : lider) { %>
                                <option value="<%= itm.getCodLider() %>"><%= itm.getnLider() %></option>
                                <% } %>
                            </select>
                            <label class="lbl">Lider</label>
                        </div>

                        <div class="top-row">
                            <input type="hidden" name="idenDir" value="4">
                            <div class="inputContainer">
                                <input type="text" name="userNameDir" class="input" placeholder="a">
                                <label class="lbl">UserName</label>
                            </div>
                            <div class="inputContainer">
                                <input type="password" name="contraseniaDir" class="input" placeholder="a">
                                <label class="lbl">Contraseña</label>
                        </div></div>
                        <input type="submit" class="btn-form" value="Registrarse">
                    </form>
                </div>
                <div id="ceos" class="tab-cont hide">
                    <form action="<%=con%>/signupCeo" method="post">
                        <div class="inputContainer">
                            <input type="text" name="nombreCeo" class="input" placeholder="a">
                            <label class="lbl">Nombre</label>
                        </div>
                        <div class="inputContainer">
                            <input type="text" name="rfcCeo" class="input" placeholder="a">
                            <label class="lbl">RFC</label>
                        </div>
                        <% List<GrupoSh> grupox = new SuperHDAO().getSuperHs(); %>
                        <div class="inputContainer">
                            <select name="grupoCeo" class="input">
                                <% for (GrupoSh itm : grupox) { %>
                                <option value="<%= itm.getCodGpSp() %>"><%= itm.getnGp() %></option>
                                <% } %>
                            </select>
                            <label class="lbl">Grupo de Super Heroe que Suministra</label>
                        </div>
                        <div class="top-row">
                            <input type="hidden" name="idenCeo" value="5">
                            <div class="inputContainer">
                                <input type="text" name="userNameCeo" class="input" placeholder="a">
                                <label class="lbl">UserName</label>
                            </div>
                            <div class="inputContainer">
                                <input type="password" name="contraseniaCeo" class="input" placeholder="a">
                                <label class="lbl">Contraseña</label>
                            </div></div>
                        <input type="submit" class="btn-form" value="Registrarse">
                    </form>
                </div>
                <div id="agen" class="tab-cont">
                    <form action="<%=con%>/signupAgente" method="post">
                        <div class="inputContainer">
                            <input type="text" name="nombre" class="input" placeholder="a">
                            <label class="lbl">Nombre</label>
                        </div>
                        <div class="inputContainer">
                            <input type="text" name="especialidad" class="input" placeholder="a">
                            <label class="lbl">Especialidad</label>
                        </div>
                        <div class="inputContainer">
                            <input type="text" name="tp_ayuda" class="input" placeholder="a">
                            <label class="lbl">Tipo de ayuda</label>
                        </div>
                        <div class="top-row">
                            <input type="hidden" name="iden" value="2">
                            <div class="inputContainer">
                                <input type="text" name="userName" class="input" placeholder="a">
                                <label class="lbl">UserName</label>
                            </div>
                            <div class="inputContainer">
                                <input type="password" name="contrasenia" class="input" placeholder="a">
                                <label class="lbl">Contraseña</label>
                        </div></div>
                        <input type="submit" class="btn-form" value="Registrarse">
                    </form>
                </div>

            </div>
        </section>
    </div>
    <script>
        var tabSel = document.getElementById('tab-sel');
        tabSel.addEventListener('change', function(e) {
            var opc = e.target.value;
            var cont = document.querySelectorAll('.tab-cont');
            cont.forEach(function(f) {
                if (f.id === opc) {
                    f.classList.remove('hide');
                } else {
                    f.classList.add('hide');
                }
            });
        });
    </script>
<%@ include file="../pie.jsp" %>
