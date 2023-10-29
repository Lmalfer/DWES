package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpleadoDAO;
import exception.DatosNoCorrectosException;
import jakarta.servlet.annotation.WebServlet;
import model.Empleado;

@WebServlet(description = "Administra solicitudes para la base de datos de gestión de empleados", urlPatterns = {"/empleado"})
public class EmpleadoServlet extends HttpServlet {
    public EmpleadoServlet() {
        super();
    }

    public void init() throws ServletException {
        super.init();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if ("listar".equals(opcion)) {
            listarEmpleados(request, response);
        } else if ("buscar_dni".equals(opcion)) {
            buscarPorDni(request, response);
        } else if ("buscar_nombre".equals(opcion)) {
            buscarPorNombre(request, response);
        } else if ("cambiar_categoria".equals(opcion)) {
            cambiarCategoria(request, response);
        } else if ("incrementar_anyos".equals(opcion)) {
            incrementarAnyos(request, response);
        } else if ("cambiar_dni".equals(opcion)) {
            cambiarDni(request, response);
        } else if ("cambiar_nombre".equals(opcion)) {
            cambiarNombre(request, response);
        } else if ("cambiar_sexo".equals(opcion)) {
            cambiarSexo(request, response);
        }
    }

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        try {
            List<Empleado> lista = empleadoDAO.todosLosEmpleados();
            request.setAttribute("listaEmpleados", lista);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listaEmpleados.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DatosNoCorrectosException e) {
            throw new RuntimeException(e);
        }
    }

    private void buscarPorDni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        Empleado empleado = null;

        if (dni != null && !dni.isEmpty()) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            try {
                empleado = empleadoDAO.busquedaPorDni(dni);
            } catch (SQLException | DatosNoCorrectosException e) {
                e.printStackTrace();
            }
        }

        if (empleado != null) {
            request.setAttribute("empleado", empleado);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/empleadoValido.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/PracticaWeb_Nomina-Laura/views/empleadoInvalido.jsp");
        }
    }

    private void buscarPorNombre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Empleado empleado = null;

        if (nombre != null && !nombre.isEmpty()) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            try {
                empleado = empleadoDAO.busquedaPorNombre(nombre);
            } catch (SQLException | DatosNoCorrectosException e) {
                e.printStackTrace();
            }
        }

        if (empleado != null) {
            request.setAttribute("empleado", empleado);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/empleadValido.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/PracticaWeb_Nomina-Laura/views/empleadoInvalido.jsp");
        }
    }

    private void cambiarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String categoriaStr = request.getParameter("categoria");

        if (dni != null && !dni.isEmpty() && categoriaStr != null && !categoriaStr.isEmpty()) {
            int categoria = Integer.parseInt(categoriaStr);
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            try {
                empleadoDAO.cambiarCategoria(dni, categoria);
                response.sendRedirect("/PracticaWeb_Nomina-Laura/views/modificaEmpleado.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/PracticaWeb_Nomina-Laura/views/error.jsp");
        }
    }

    private void incrementarAnyos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String anyosStr = request.getParameter("anyos");

        if (dni != null && !dni.isEmpty() && anyosStr != null && !anyosStr.isEmpty()) {
            double anyos = Double.parseDouble(anyosStr);
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            try {
                empleadoDAO.incrementarAnyos(dni, anyos);
                response.sendRedirect("/Practica_DWES/views/anyosIncrementados.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/Practica_DWES/views/error.jsp");
        }
    }

    private void cambiarDni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String nuevoDni = request.getParameter("nuevoDni");

        if (dni != null && !dni.isEmpty() && nuevoDni != null && !nuevoDni.isEmpty()) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            try {
                empleadoDAO.cambiarDni(dni, nuevoDni);
                response.sendRedirect("/PracticaWeb_Nomina-Laura/views/modificaEmpleado.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/PracticaWeb_Nomina-Laura/views/error.jsp");
        }
    }

    private void cambiarNombre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String nuevoNombre = request.getParameter("nuevoNombre");

        if (dni != null && !dni.isEmpty() && nuevoNombre != null && !nuevoNombre.isEmpty()) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            try {
                empleadoDAO.cambiarNombre(dni, nuevoNombre);
                response.sendRedirect("/PracticaWeb_Nomina-Laura/views/modificaEmpleado.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/PracticaWeb_Nomina-Laura/views/error.jsp");
        }
    }

    private void cambiarSexo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String nuevoSexo = request.getParameter("nuevoSexo");

        if (dni != null && !dni.isEmpty() && nuevoSexo != null && !nuevoSexo.isEmpty()) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            try {
                empleadoDAO.cambiarSexo(dni, nuevoSexo);
                response.sendRedirect("/PracticaWeb_Nomina-Laura/views/modificaEmpleado.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/PracticaWeb_Nomina-Laura/views/error.jsp");
        }
    }
}
