<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Muestra Salario</title>
    <style>
        body {
            background-color: #f7ecd6; /* Fondo de tono pastel */
            text-align: center;
        }
        .menu-container {
            margin: 100px auto;
            width: 800px; /* Ancho del menú */
            background-color: #ffffff; /* Fondo blanco */
            padding: 20px;
            border-radius: 10px;
        }

        h1{
            font-size: 40px;
            color: #F3C734;
            -webkit-text-stroke-width: 1px;
            -webkit-text-stroke-color: black;
        }

        table {
            width: 80%;
            border: 2px solid #F3C734;
            margin: 20px auto;
        }

        tr {
            background-color: #f2f2f2;
            text-align: center;
        }

        td {
            padding: 12px;
            border: 1px solid #333;
            text-align: center;
        }

        input {
            padding: 10px;
            border: 2px solid #F3C734;
            border-radius: 5px;
            width: 40%;
            margin: 10px 0;
            font-weight: bold;
        }

        .inicio a {
            text-decoration: none;
            padding: 10px 20px;
            background-color: #F3C734;
            color: black;
            border-radius: 5px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="menu-container">
    <h1>Mostrar Salarios</h1>
    <table border="1">
        <tr>
            <td>Nombre</td>
            <td>DNI</td>
            <td>Sueldo</td>
        </tr>
        <tr>
            <td>${nombre}</td>
            <td>${dni}</td>
            <td>
                <fmt:formatNumber value="${sueldo}" type="currency" currencySymbol="€" />
            </td>
        </tr>
    </table>
    <div class="inicio">
        <a href="index.jsp">Volver</a>
    </div>
</div>
</body>
</html>
