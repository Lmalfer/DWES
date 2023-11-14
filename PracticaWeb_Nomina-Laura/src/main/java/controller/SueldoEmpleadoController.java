package controller;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import model.*;



@WebServlet(description = "administra peticiones para la base de datos de gestión de nóminas", urlPatterns = {"/sueldo"})

public class SueldoEmpleadoController extends HttpServlet {

    public SueldoEmpleadoController() {
        super();
    }

    public void init() throws ServletException {
        try {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } finally {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if ("consultarSueldo".equals(opcion)) {
            request.setAttribute("mensaje", "");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/formDNI.jsp");
            requestDispatcher.forward(request, response);
        } else if ("buscarSueldoPorDni".equals(opcion)) {
            String dni = request.getParameter("dni");

            if (dni != null && !dni.isEmpty()) {
                NominaDAO nominaDAO = new NominaDAO();
                double sueldo = 0;
                try {
                    Sueldo sueldoObj = nominaDAO.findSueldoByDni(dni);
                    if (sueldoObj != null) {
                        sueldo = sueldoObj.getSueldo();
                        request.setAttribute("dni", dni);
                        request.setAttribute("sueldo", sueldo);
                        // request.setAttribute("nombre", nombreEmpleado);
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/salario.jsp");
                        requestDispatcher.forward(request, response);
                    } else {
                        // Mostrar un mensaje en caso de que el sueldo no se haya encontrado
                        request.setAttribute("mensaje", "No se encontró el sueldo para el DNI: " + dni);
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/formDNI.jsp");
                        requestDispatcher.forward(request, response);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // Enviar respuesta de error
                response.setContentType("text/plain");
                response.getWriter().write("DNI no proporcionado.");
            }
        }
    }
}

