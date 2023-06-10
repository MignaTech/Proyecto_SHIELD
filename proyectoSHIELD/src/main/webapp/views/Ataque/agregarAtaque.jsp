<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="modelos.Paises,java.util.List" %>
<%
    String titulo = "Agregar Ataque";
    request.setAttribute("titulo", titulo);
%>
<%@ include file="../encabezado.jsp" %>
<%@ include file="../UIAdmin/barranav.jsp" %>
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
<article class="cont-body">
    <section class="cont-base" style="width: 570px">
        <div class="base-header">
            <h1 class="base-title">Añadir Ataque</h1>
            <a class="btn das" href="<%=esc%>">Dashboard</a>
        </div>
        <div class="form-container">
            <form id="myForm" action="AtaqueSV" method="post">
                <input type="hidden" name="meto2" value="add">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" required><br>
                </div>
                <div class="form-group">
                    <label for="bajas">Numero de Bajas:</label>
                    <input type="number" id="bajas" name="bajas" min="0" value="0" required><br>
                </div>
                <div class="form-group">
                    <label for="heridos">Numero de Heridos:</label>
                    <input type="number" id="heridos" name="heridos" min="0" value="0" required><br>
                </div>
                <% List<Paises> paises = (List<Paises>) request.getAttribute("paises"); %>
                <div class="form-group">
                    <label>Pais Afectado:</label>
                    <select id="pais" name="pais">
                        <% for (Paises itm : paises) { %>
                        <option value="<%= itm.getCodPais() %>"><%= itm.getnPais() %></option>
                        <% } %>
                    </select>
                </div>

                <div class="inputContainer">
                    <select id="tab-sel" name="tipo" class="input" style="position: inherit; margin-bottom: 20px;">
                        <option value="inva" selected>Invasión territorial</option>
                        <option value="muta">Mutante</option>
                        <option value="eco">Económica</option>
                    </select>
                    <label class="lbl">Tipo de Ataque</label>
                </div>
                <div id="inva" class="tab-cont">
                    <input type="hidden" name="iden" value="1">
                    <div class="inputContainer" style="width: 93%;">
                        <input type="text" name="region" class="input" placeholder="a">
                        <label class="lbl">Region Afectada</label>
                    </div>
                </div>
                <div id="muta" class="tab-cont hide">
                    <div class="inputContainer">
                        <input type="text" name="grupo" class="input" placeholder="a">
                        <label class="lbl">Grupos Involucrados</label>
                    </div>
                    <div class="inputContainer">
                        <input type="number" name="mutantes" class="input" min="0" value="0" placeholder="a">
                        <label class="lbl">Numero de Mutantes Afectados</label>
                    </div>
                </div>
                <div id="eco" class="tab-cont hide">
                    <div class="inputContainer">
                        <input type="text" name="bien" class="input" placeholder="a">
                        <label class="lbl">Bien Disputado</label>
                    </div>
                </div>

                <input class="btn pull-left" type="submit" value="Agregar">
                <a class="btn secondary pull-right" href="AtaqueSV?action=list">Lista de Ataques</a>
            </form>
        </div>
    </section>
</article>
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
