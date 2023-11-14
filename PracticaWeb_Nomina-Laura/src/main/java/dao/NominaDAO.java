package dao;

import conexion.Connector;
import model.Sueldo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NominaDAO {
    public Sueldo findSueldoByDni(String dniEmpleado) throws SQLException {
        Sueldo sueldoEmpleado = null;
        Connection conn = null;


        try {
            conn = Connector.getConnection();
            PreparedStatement pt = null;

            String query = "SELECT  dni, sueldo FROM nominas WHERE dni = ?";
            pt = conn.prepareStatement(query);

            pt.setString(1, dniEmpleado);

            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                String dni = rs.getString("dni");
                double sueldo = rs.getDouble("sueldo");

                sueldoEmpleado = new Sueldo(dni, sueldo);

            } else {

                System.out.println("No se encontró ningún empleado con el DNI proporcionado");

            }

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return sueldoEmpleado;
    }
}
