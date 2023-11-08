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

@WebServlet(description = "administra peticiones para la base de datos de gestión de nóminas", urlPatterns = {"/listar", "/modificar"})
public class EmpleadoController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if ("/listar".equals(pathInfo)) {
            listarEmpleados(request, response);
        } else if ("/modificar".equals(pathInfo)) {
            mostrarFormularioModificar(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if ("/modificar".equals(pathInfo)) {
            try {
                buscarEmpleados(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmpleadoDAO EmpleadoDAO = new EmpleadoDAO();

        try {
            List<Empleado> lista = EmpleadoDAO.obtenerEmpleados();

            request.setAttribute("lista", lista);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listaEmpleados.jsp");
            requestDispatcher.forward(request, response);

        } catch (SQLException e) {
            // Maneja excepciones de SQL
            e.printStackTrace();
        } catch (DatosNoCorrectosException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarFormularioModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("mensaje", "");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/modificaEmpleado.jsp");
        requestDispatcher.forward(request, response);
    }

    private void buscarEmpleados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String campo = request.getParameter("campo");
        String valor = request.getParameter("valor");

        if (campo != null && valor != null) {
            List<Empleado> empleados = new ArrayList<>();
            EmpleadoDAO EmpleadoDAO = new EmpleadoDAO();

            empleados = EmpleadoDAO.buscarEmpleadoPorCampo(campo, valor);

            if (empleados.isEmpty()) {
                request.setAttribute("mensaje", "No se encontraron empleados para el campo " + campo + " con valor " + valor);
            } else {
                request.setAttribute("empleados", empleados);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/resultados.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
}
