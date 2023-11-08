<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Datos del Empleado</title>
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
        form {
            margin: 20px auto;
            width: 60%;
        }
        input[type="text"] {
            padding: 10px;
            border: 2px solid #F3C734;
            border-radius: 5px;
            width: 100%;
            margin: 10px 0;
            font-weight: bold;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #F3C734;
            color: black;
            border: none;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
        }
        p {
            font-weight: bold;
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Modificar Datos del Empleado</h1>
    <form action="modificar" method="post">
        DNI: <input type="text" name="dni">
        <input type="submit" value="Modificar">
    </form>
    <p>${mensaje}</p>
</div>
</body>
</html>
