<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calcular Salario del Empleado</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        h1 {
            text-align: center;
        }
        form {
            text-align: center;
        }
        label {
            display: block;
            font-weight: bold;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        p {
            text-align: center;
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Calcular Salario del Empleado</h1>
    <form action="sueldo" method="post">
        <label for="dni">DNI del Empleado:</label>
        <input type="text" id="dni" name="dni" placeholder="Ingrese el DNI del empleado" required>
        <br>
        <input type="submit" value="Calcular Salario">
    </form>
    <p>${mensaje}</p>
</div>
</body>
</html>
