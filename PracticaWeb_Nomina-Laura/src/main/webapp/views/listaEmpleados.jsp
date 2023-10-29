<%@ page import="model.Empleado" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<% List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Empleados</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f2f2f2;
        }

        h1 {
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            border-collapse: collapse;
            box-shadow: 0px 0px 10px #888888;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #3498db;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<h1>Lista de Empleados</h1>
<table>
    <tr>
        <th>Nombre</th>
        <th>DNI</th>
        <th>Sexo</th>
        <th>Categoria</th>
        <th>Años Trabajados</th>
    </tr>
    <% for (Empleado empleado : empleados) { %>
    <tr>
                <td><%= empleado.nombre %></td>
                <td><%= empleado.dni %></td>
                <td><%= empleado.sexo %></td>
                <td><%= empleado.getCategoria() %></td>
                <td><%= empleado.anyos %></td>

            <% } %>

        </tr>

</table>
</body>
</html>
