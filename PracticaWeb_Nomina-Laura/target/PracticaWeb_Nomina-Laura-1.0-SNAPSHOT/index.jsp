<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            list-style: none;
            padding: 0;
        }

        .menu li {
            margin: 10px 0;
        }

        .menu a {
            display: block;
            background-color: #3498db;
            color: #fff;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 5px;
        }

        .menu a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<h1>Práctica Nóminas</h1>
<ul class="menu">
    <li>
        <a href="/PracticaWeb_Nomina-Laura/empleado?opcion=listar">Mostrar lista de empleados</a>
    </li>
    <li>
        <a href="/PracticaWeb_Nomina-Laura/obtener-sueldo">Mostrar salario de un empleado</a>
    </li>
    <li>
        <a href="resultadoBusqueda.jsp">Modificar los datos de un empleado</a>
    </li>
</ul>
</body>
</html>
