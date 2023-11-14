package dao;

import conexion.Connector;
import exception.DatosNoCorrectosException;
import model.Empleado;
import model.Sueldo;

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
                char sexo = rs.getString("sexo").charAt(0);
                int categoria = rs.getInt("categoria");
                double anyos = rs.getDouble("anyos");

                Empleado empleado = new Empleado(nombre, dni, sexo, categoria, anyos);
                empleados.add(empleado);
            }
        }

        return empleados;
    }

}
