<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 0;
    }

    .standard {
        width: 60%;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    h2 {
        color: #333;
        text-align: center;
    }

    p {
        color: #888;
        text-align: center;
    }

    form {
        display: flex;
        flex-direction: column;
    }

    label {
        margin: 10px 0;
        color: #333;
    }

    input[type="text"] {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin: 10px 0;
    }

    input[type="submit"] {
        padding: 10px 20px;
        background-color: cornflowerblue;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: cornflowerblue;
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
<div class="standard">
    <h2>Consultar sueldo Empleado</h2>
    <p><%=request.getAttribute("mensaje")%></p>
<form action="sueldo" method="get">
    <input type="hidden" name="opcion" value="buscarSueldoPorDni">
    <label for="dni">Introduce el DNI del empleado:</label>
    <input type="text" name="dni" id="dni" required>
    <br>
    <input type="submit" value="Consultar Sueldo">
</form>
    <div class="inicio">
        <a href="index.jsp">Volver</a>
    </div>
</div>
</body>
</html>
