<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String con = request.getContextPath(); %>
<% String esc = con + "/views/home.jsp"; %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%
        String titu = (String) request.getAttribute("titulo");
        if (titu == null || titu.isEmpty()) {
            titu = "S.H.I.E.L.D.";
        }
    %>
    <title><%= titu %></title>
    <link rel="stylesheet" href="<%=con%>/assets/css/estilos.css" />
    <link rel="stylesheet" href="<%=con%>/assets/css/tabla.css" />
    <link rel="stylesheet" href="<%=con%>/assets/css/formulario.css" />
</head>
<body>
    <header>
        <div class="divlogo">
            <div class="logo">S.H.I.E.L.D</div>
            <img src="<%=con%>/assets/img/toggle.png" class="icono iconomenu" id="menuicn">
        </div>
        <div class="menu">
            <button class="ver-menu" onclick="toggleDropdown('cuentaU')">
                <img src="<%=con%>/assets/img/usuarios.png" class="user-image" alt="User Image"/>
                <span style="color: black">Nick Fury</span>
            </button>
            <ul class="desp-menu" id="cuentaU">
                <li class="menu-header">
                    <img src="<%=con%>/assets/img/usuarios.png" class="img-circle" alt="User Image"/>
                    <p>Nick Fury</p>
                    <p>Lider</p>
                    <small>Lider de S.H.I.E.L.D.</small>
                </li>
                <li class="menu-footer">
                    <div>
                        <a href="#" class="btn secondary">Salir</a>
                    </div>
                </li>
            </ul>
        </div>
    </header>
    <div class="contenedor">
