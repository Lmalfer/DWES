package dao;

import conexion.Connector;

import exception.DatosNoCorrectosException;
import model.Empleado;
import model.Nomina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NominaDAO {
    private Connection connection;

    public NominaDAO() {
    }

    public double obtenerSueldoPorDni(String dniEmpleado) throws SQLException, DatosNoCorrectosException{
        double sueldo = 0.0;

        try {
            connection = Connector.getConnection();
            PreparedStatement pt = null;

            // Consulta para obtener la categoría del empleado por su DNI
            String categoriaQuery = "SELECT categoria FROM empleados WHERE dni = ?";
            pt = connection.prepareStatement(categoriaQuery);
            pt.setString(1, dniEmpleado);

            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                int categoria = rs.getInt("categoria");
                Empleado empleado = new Empleado();
                empleado.setCategoria(categoria);

                // Utiliza la clase Nomina para calcular el sueldo
                Nomina nomina = new Nomina();
                sueldo = nomina.sueldo(empleado);
            }
        } catch (SQLException | DatosNoCorrectosException e) {
            System.out.println("Ocurrió un error al conectar u operar con la BD");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return sueldo;
    }
}
