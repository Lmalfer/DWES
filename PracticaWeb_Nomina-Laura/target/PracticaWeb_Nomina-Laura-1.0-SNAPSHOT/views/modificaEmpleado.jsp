<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Datos del Empleado</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .container table {
            width: 100%;
        }

        .container input[type="text"],
        .container input[type="number"] {
            width: calc(100% - 10px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 5px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-top: 10px;
        }

        input[type="submit"]:hover {
            background-color: cornflowerblue;
        }

        .inicio a {
            display: block;
            text-align: center;
            margin-top: 10px;
            text-decoration: none;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .inicio a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<div class="container">
    <form >
    <table>
        <tr>
            <td>DNI:</td>
            <td><input type="text" name="dni"
                       placeholder="Ejemplo: 12345678M" pattern="[0-9]{8}[A-Za-z]{1}"
                       title="Formato válido: 12345678M" required maxlength="9"></td>
        </tr>
        <tr>
            <td>Nombre:</td>
            <td><input type="text" name="nombre"
                       placeholder="Ejemplo: Patricia Delgado" required maxlength="70"></td>
        </tr>
        <tr>
            <td>Sexo:</td>
            <td><input type="text" name="sexo" placeholder="Ejemplo: M o F"
                       pattern="[MF]{1}" title="Formato válido: M o F" required
                       maxlength="1"></td>
        </tr>
        <tr>
            <td>Categoría:</td>
            <td><input type="number" name="categoria"
                       placeholder="Ejemplo: 2" required min="1" max="10"></td>
        </tr>
        <tr>
            <td>Años:</td>
            <td><input type="number" name="anyos" placeholder="Ejemplo: 5"
                       required min="0" max="99"></td>
        </tr>
    </table>
    <input type="submit" value="Editar">
    </form>
    <div class="inicio">
        <a href="index.jsp">Volver</a>
    </div>

</div>
</body>
</html>
