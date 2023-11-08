<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Empleado" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listar Empleados</title>
    <style>
        body {
            background-color: #f7ecd6;
            text-align: center;
        }
        .container {
            margin: 100px auto;
            width: 800px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
        }
        h1 {
            font-size: 40px;
            color: #F3C734;
            -webkit-text-stroke-width: 1px;
            -webkit-text-stroke-color: black;
        }
        table {
            width: 100%;
            border: 2px solid #F3C734;
            margin: 20px auto;
        }
        tr {
            background-color: #f2f2f2;
        }
        td {
            padding: 12px;
            border: 1px solid #333;
        }
        .menu-container a {
            text-decoration: none;
            color: #F3C734;
            font-weight: bold;
            -webkit-text-stroke-width: 0.2px;
            -webkit-text-stroke-color: black;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Listar Empleados Por Campo</h1>
    <table border="1">
        <tr>
            <td>Nombre</td>
            <td>DNI</td>
            <td>Sexo</td>
            <td>Categoría</td>
            <td>Años Trabajados</td>
            <td>Acciones</td>
        </tr>
        <c:forEach var="empleado" items="${empleados}">
            <tr>
                <td>${empleado.nombre}</td>
                <td>${empleado.dni}</td>
                <td>${empleado.sexo}</td>
                <td>${empleado.categoria}</td>
                <td>${empleado.anyosTrabajados}</td>
                <td><a href="#">MODIFICAR</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div class="menu-container">
        <a href="index.jsp">Volver</a>
    </div>
</div>
</body>
</html>
