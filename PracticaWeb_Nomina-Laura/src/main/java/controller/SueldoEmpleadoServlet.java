package controller;

import dao.NominaDAO;
import exception.DatosNoCorrectosException;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Obtiene el sueldo de un empleado por su DNI", urlPatterns = {"/obtener-sueldo"})
public class SueldoEmpleadoServlet extends HttpServlet {
    public SueldoEmpleadoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtiene el DNI del parámetro de la solicitud
        String dni = request.getParameter("dni");

        if (dni != null && !dni.isEmpty()) {
            try {
                NominaDAO nominaDAO = new NominaDAO();
                double sueldo = nominaDAO.obtenerSueldoPorDni(dni);

                // Configura el sueldo como un atributo para mostrarlo en la página JSP
                request.setAttribute("sueldo", sueldo);

                // Reenvía la solicitud a una página JSP que mostrará el sueldo
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/sueldoEmpleado.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException | DatosNoCorrectosException e) {
                e.printStackTrace();
                // Maneja errores o excepciones según sea necesario
            }
        } else {
            // Manejo de DNI no válido
            response.getWriter().write("DNI no válido");
        }
    }
}
