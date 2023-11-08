package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexion.Connector;
import dao.*;
import exception.DatosNoCorrectosException;
import model.*;



@WebServlet(description = "administra peticiones para la base de datos de gestion de nominas", urlPatterns = {"/sueldo"})
public class SueldoEmpleadoController extends HttpServlet{



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("mensaje", "");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/formDNI.jsp");
        requestDispatcher.forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado empleado = new Empleado();
        empleado.setDni(request.getParameter("dni"));
        if (empleado.getDni().isEmpty() || !obtenerDni(empleado.getDni())) {
            request.setAttribute("mensaje", "Empleado no encontrado");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/formDNI.jsp");
            requestDispatcher.forward(request, response);
        } else {
            empleado = obtenerEmpleadoPorDni(empleado.getDni());

            if (empleado != null) {
                Nomina nomina = new Nomina();
                double sueldo = nomina.calculaSueldo(empleado);

                request.setAttribute("nombre", empleado.getNombre());
                request.setAttribute("dni", empleado.getDni());
                request.setAttribute("sueldo", sueldo);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/Salario.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }



    public boolean obtenerDni(String dni) {
        return !dni.isEmpty();
    }



    public Empleado obtenerEmpleadoPorDni(String dni) {
        EmpleadoDAO gestionDAO = new EmpleadoDAO();
        try {
            return gestionDAO.obtenerEmpleado(dni);
        } catch (SQLException | DatosNoCorrectosException e) {
            e.printStackTrace();
            return null;
        }
    }
}