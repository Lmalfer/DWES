package dao;

import conexion.Connector;
import exception.DatosNoCorrectosException;
import model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    private Connection connection;

    public EmpleadoDAO() {

    }

    public List<Empleado> todosLosEmpleados() throws SQLException, DatosNoCorrectosException {
        List<Empleado> listaEmpleados = new ArrayList<>();

        try {
            connection = Connector.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre, dni, sexo, categoria, anyos FROM empleados");

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String dni = rs.getString("dni");
                char sexo = rs.getString("sexo").charAt(0);
                int categoria = rs.getInt("categoria");
                double anyos = rs.getDouble("anyos");

                Empleado empleado = new Empleado(nombre, dni, sexo, categoria, anyos);
                listaEmpleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        } catch (DatosNoCorrectosException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return listaEmpleados;
    }

    public Empleado busquedaPorDni(String dniEmp) throws SQLException, DatosNoCorrectosException {
        Empleado empleado = null;

        try {
            connection = Connector.getConnection();
            PreparedStatement pt = null;

            String query = "SELECT nombre, dni, sexo, categoria, anyos FROM empleados WHERE dni = ?";
            pt = connection.prepareStatement(query);

            pt.setString(1, dniEmp);

            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String dni = rs.getString("dni");
                char sexo = rs.getString("sexo").charAt(0);
                int categoria = rs.getInt("categoria");
                double anyos = rs.getDouble("anyos");

                empleado = new Empleado(nombre, dni, sexo, categoria, anyos);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        if (empleado == null) {
            throw new DatosNoCorrectosException("Empleado no encontrado con este dni");
        }

        return empleado;
    }

    public Empleado busquedaPorNombre(String name) throws SQLException, DatosNoCorrectosException {
        Empleado empleado = null;
        try {
            connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT nombre, dni, sexo, categoria, anyos FROM empleados WHERE nombre = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String dni = resultSet.getString("dni");
                char sexo = resultSet.getString("sexo").charAt(0);
                int categoria = resultSet.getInt("categoria");
                double anyos = resultSet.getDouble("anyos");

                empleado = new Empleado(nombre, dni, sexo, categoria, anyos);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        if (empleado == null) {
            throw new DatosNoCorrectosException("Empleado no encontrado con dicho nombre");
        }
        return empleado;
    }



    public void cambiarCategoria(String dniEmpleado, int cat) throws SQLException {
        try {
            connection = Connector.getConnection();
            PreparedStatement pt = null;

            String query = "UPDATE empleados SET categoria = ? WHERE dni = ?";
            pt = connection.prepareStatement(query);
            pt.setInt(1, cat);
            pt.setString(2, dniEmpleado);

            int rowCount = pt.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Categoría modificada");
            } else {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado");
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void incrementarAnyos(String dniEmpleado, double anyos) throws SQLException {
        try {
            connection = Connector.getConnection();
            PreparedStatement pt = null;

            String query = "UPDATE empleados SET anyos = ? WHERE dni = ?";
            pt = connection.prepareStatement(query);
            pt.setDouble(1, anyos);
            pt.setString(2, dniEmpleado);

            int rowCount = pt.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Años trabajados modificados");
            } else {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado");
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void cambiarNombre(String dniEmpleado, String nombre) throws SQLException {
        try {
            connection = Connector.getConnection();
            PreparedStatement pt = null;

            String query = "UPDATE empleados SET nombre = ? WHERE dni = ?";
            pt = connection.prepareStatement(query);
            pt.setString(1, nombre);
            pt.setString(2, dniEmpleado);

            int rowCount = pt.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Nombre modificado");
            } else {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado");
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void cambiarSexo(String dniEmpleado, String sexo) throws SQLException {
        try {
            connection = Connector.getConnection();
            PreparedStatement pt = null;

            String query = "UPDATE empleados SET sexo = ? WHERE dni = ?";
            pt = connection.prepareStatement(query);
            pt.setString(1, sexo);
            pt.setString(2, dniEmpleado);

            int rowCount = pt.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Sexo modificado");
            } else {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado");
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void cambiarDni(String dniEmpleado, String nuevoDni) throws SQLException {
        try {
            connection = Connector.getConnection();
            PreparedStatement pt = null;

            String query = "UPDATE empleados SET dni = ? WHERE dni = ?";
            pt = connection.prepareStatement(query);
            pt.setString(1, nuevoDni);
            pt.setString(2, dniEmpleado);

            int rowCount = pt.executeUpdate();

            if (rowCount > 0) {
                System.out.println("DNI modificado");
            } else {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado");
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
