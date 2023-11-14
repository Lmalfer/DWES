<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Muestra Salario</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 0;
    }

    .menu-container {
        width: 60%;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    h1 {
        color: #333;
        text-align: center;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    td {
        padding: 12px;
        border: 1px solid #ccc;
        text-align: center;
    }

    .inicio a {
        display: block;
        text-align: center;
        margin-top: 20px;
        text-decoration: none;
        padding: 10px 20px;
        background-color: #333;
        color: white;
        border-radius: 5px;
        font-weight: bold;
        transition: background-color 0.3s;
    }

    .inicio a:hover {
        background-color: #555;
    }

</style>
</head>
<body>
<div class="menu-container">
    <h1>Mostrar Salarios</h1>
    <table border="1">
        <tr>
            <td>DNI</td>
            <td>Sueldo</td>
        </tr>
        <tr>
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
