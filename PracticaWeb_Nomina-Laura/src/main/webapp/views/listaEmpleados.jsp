<%@ page import="model.Empleado" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lista de empleados</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        .menu-container {
            width: 60%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: cornflowerblue;
            font-size: 36px;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        td, th {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        tr.principal {
            font-weight: bold;
        }

        .inicio a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            padding: 10px 20px;
            background-color: cornflowerblue;
            color: white;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .inicio a:hover {
            background-color: cadetblue;
        }

    </style>
</head>
<body>
<div class="menu-container">
    <h1>Listar Empleados</h1>
    <table border="1">
        <tr class="principal">
            <td>Nombre</td>
            <td>Dni</td>
            <td>Sexo</td>
            <td>Categoria</td>
            <td>Años</td>
        </tr>
        <%
            List<Empleado> lista = (List<Empleado>) request.getAttribute("lista");
            for (Empleado empleado : lista) {
        %>
        <tr>
            <td><%= empleado.getNombre() %></td>
            <td><%= empleado.getDni() %></td>
            <td><%= empleado.getSexo() %></td>
            <td><%= empleado.getCategoria() %></td>
            <td><%= empleado.getAnyos() %></td>
        </tr>
        <% } %>
    </table>
    <br>
    <div class="inicio">
        <a href="index.jsp">Volver</a>
    </div>

</div>
</body>
</html>