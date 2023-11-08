package dao;

import conexion.Connector;
import exception.DatosNoCorrectosException;
import model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    public List<Empleado> obtenerEmpleados() throws SQLException, DatosNoCorrectosException {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleados";

        try (Connection conn = Connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String dni = rs.getString("dni");
                char sexo = rs.getString("sexo").charAt(0); // Asumiendo que se almacena como un carácter
                int categoria = rs.getInt("categoria");
                double anyos = rs.getDouble("anyos");

                Empleado empleado = new Empleado(nombre, dni, sexo, categoria, anyos);
                empleados.add(empleado);
            }
        }

        return empleados;
    }

    public Empleado obtenerEmpleado(String dni) throws SQLException, DatosNoCorrectosException {
        String query = "SELECT * FROM nominas WHERE dni = ?";
        Empleado empleado = null;

        try (Connection conn = Connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                char sexo = rs.getString("sexo").charAt(0); // Asumiendo que se almacena como un carácter
                int categoria = rs.getInt("categoria");
                double anyos = rs.getDouble("anyos");

                empleado = new Empleado(nombre, dni, sexo, categoria, anyos);
            }
        }

        if (empleado == null) {
            throw new DatosNoCorrectosException("Empleado no encontrado");
        }

        return empleado;
    }

    public List<Empleado> buscarEmpleadoPorCampo(String campo, String valor) throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleados WHERE " + campo + " = ?";

        try (Connection conn = Connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, valor);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String dni = rs.getString("dni");
                char sexo = rs.getString("sexo").charAt(0); // Asumiendo que se almacena como un carácter
                int categoria = rs.getInt("categoria");
                double anyos = rs.getDouble("anyos");

                Empleado empleado = new Empleado(nombre, dni, sexo, categoria, anyos);
                empleados.add(empleado);
            }
        } catch (DatosNoCorrectosException e) {
            throw new RuntimeException(e);
        }

        return empleados;
    }
}
