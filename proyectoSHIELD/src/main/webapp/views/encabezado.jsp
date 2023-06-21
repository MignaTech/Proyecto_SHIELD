<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String con = request.getContextPath(); %>
<% String esc = con + "/views/home.jsp"; %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <% String titu = (String) request.getAttribute("titulo");
        if (titu == null || titu.isEmpty()) {
            titu = "S.H.I.E.L.D.";}%>
    <title><%= titu %></title>
    <link rel="shortcut icon" href="<%=con%>/assets/img/icoShield.png" type="image/x-icon">
    <link rel="stylesheet" href="<%=con%>/assets/css/estilos.css"/>
    <link rel="stylesheet" href="<%=con%>/assets/css/tabla.css"/>
    <link rel="stylesheet" href="<%=con%>/assets/css/formulario.css"/>
    <style>
        .navTop a {
            float: left;
            color: black;
            text-align: center;
            padding: 12px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .navTop a:hover {
            background-color: #ddd;
            color: black;
        }

        .button {
            display: flex;
            align-items: center;
            padding: 5px 10px;
            border: none;
            background-color: #cad7fda4;
            text-align: left;
            cursor: pointer;
         }

        .button img {
            margin-right: 10px;
        }

    </style>
</head>
<body>
<header>
    <div class="divlogo iconomenu">
        <img src="<%=con%>/assets/img/icoShield.png" class="user-image"/>
        <div class="logo">S.H.I.E.L.D</div>
    </div>
    <div class="navTop">
        <c:if test="${empty sessionScope.currentUser}">
            <a href="<%=con%>/index.jsp">Inicio</a>
            <a href="<%=con%>/views/user/signup.jsp">Registrarse</a>
            <a href="<%=con%>/views/user/login.jsp">Iniciar sesión</a>
        </c:if>
        <c:if test="${sessionScope.currentUser != null && sessionScope.currentUser.rol.n_rol eq 'Administrador'}">
            <a href="<%=con%>/views/user/signup.jsp">Registrar usuario</a>
        </c:if>
        <a href="#" onclick="document.getElementById('contact').showModal()">Contacto</a>
    </div>
    <dialog id="contact" style="margin: 45px auto;border-radius: 30px; padding: 18px;">
        <button class="btn secondary pull-right" onclick="document.getElementById('contact').close()">
            X
        </button>
        <p>
            Desarrollado por: Sixtega Escribano Miguel Ángel<br>
            Estudiante de Ingeniería Informática<br>
            Correo: <a style="color: black"
                       href="mailto:migna0519@gmail.com?Subject=Interesado%20en%20el%20proyecto%20SHIELD"
                       target="_blank" rel="noopener noreferrer">
            migna0519@gmail.com</a><br>
            GitHub: <a style="color: black"
                       href="https://github.com/MignaTech/"
                       target="_blank" rel="noopener noreferrer">
            @MignaTech</a>
        </p>
    </dialog>
    <c:if test="${sessionScope.currentUser != null}">
        <div class="menu">
            <button class="button" onclick="toggleDropdown('cuentaU')">
                <img src="<%=con%>/assets/img/usuarios.png" class="user-image" alt="User Image"/>
                <span>${sessionScope.currentUser.nombre}</span>
            </button>
            <ul class="desp-menu" id="cuentaU">
                <li class="menu-header">
                    <img src="<%=con%>/assets/img/usuarios.png" class="img-circle" alt="User Image"/>
                    <p>${sessionScope.currentUser.nombre}</p>
                    <p>Tipo de Usuario: ${sessionScope.currentUser.rol.n_rol}</p
                </li>
                <li class="menu-footer">
                    <form action="<%=con%>/logout" method="post">
                        <button class="btn secondary" type="submit">Cerrar sesión</button>
                    </form>
                </li>
            </ul>
        </div>
    </c:if>
</header>
<div class="contenedor">
