package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexion.Connector;
import dao.EmpleadoDAO;
import exception.DatosNoCorrectosException;
import model.Empleado;

@WebServlet(description = "administra peticiones para la base de datos de gestión de nóminas", urlPatterns = {"/gestor"})

public class EmpleadoController extends HttpServlet {

    public EmpleadoController() {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        if ("listar".equals(opcion)) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            try {
                List<Empleado> lista = empleadoDAO.obtenerEmpleados();

                request.setAttribute("lista", lista);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listaEmpleados.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                // Maneja excepciones de SQL
                e.printStackTrace();
            } catch (DatosNoCorrectosException e) {
                // Lanza una excepción de tiempo de ejecución si los datos no son correctos
                throw new RuntimeException(e);
            }
        } else if("editarEmpleado".equals(opcion)) {

                request.setAttribute("mensaje", "");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/modificaEmpleado.jsp");
                requestDispatcher.forward(request, response);

            }
        }
    }



