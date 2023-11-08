<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Práctica Nóminas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f2f2f2;
        }

        h1 {
            color: #333;
        }

        .menu {
            margin-top: 20px;
        }

        .menu a {
            display: inline-block;
            background-color: #3498db;
            color: #fff;
            text-decoration: none;
            padding: 10px 20px;
            margin: 10px;
            border-radius: 5px;
        }

        .menu a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<h1>Práctica Nóminas</h1>
<div class="menu">
    <a href="listar">Mostrar lista de empleados</a>
    <a href="sueldo">Mostrar salario de un empleado</a>
    <a href="modificar">Modificar los datos de un empleado</a>
</div>
</body>
</html>
