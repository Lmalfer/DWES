<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modificar Empleado</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px 0px #000000;
            width: 300px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        p {
            margin: 20px 0;
        }

        a {
            text-decoration: none;
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
        }

        a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<h1>Modificar Empleado</h1>
<form method="post" action="modificar-empleado">
    <label for="dni">DNI del empleado:</label>
    <input type="text" id="dni" name="dni">

    <label for="nombre">Nuevo nombre:</label>
    <input type="text" id="nombre" name="nombre">

    <label for="categoria">Nueva categoría:</label>
    <select id="categoria" name="categoria">
        <option value="1">Categoría 1</option>
        <option value="2">Categoría 2</option>
        <!-- Agrega más opciones aquí -->
    </select>

    <label for="anyos">Nuevos años trabajados:</label>
    <input type="text" id="anyos" name="anyos">

    <label for="sexo">Nuevo sexo:</label>
    <select id="sexo" name="sexo">
        <option value="M">Masculino</option>
        <option value="F">Femenino</option>
        <!-- Agrega más opciones aquí -->
    </select>

    <input type="submit" value="Modificar Empleado">
</form>

<c:if test="${not empty mensaje}">
    <p>${mensaje}</p>
</c:if>

<a href="index.jsp">Volver al menú principal</a>
</body>
</html>
