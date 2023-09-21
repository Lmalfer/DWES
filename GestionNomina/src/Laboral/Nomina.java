package Laboral;

/**
 * Clase que define los sueldos base de los empleados según su categoría.
 */
public class Nomina {

    private static final int SUELDO_BASE[] = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};

    /**
     * Calcula el sueldo de un empleado en base a su categoría y años trabajados.
     *
     * @param empleado El empleado del que se calcula el sueldo.
     * @return El sueldo calculado.
     */
    public double sueldo(Empleado empleado) {
        int sueldoBase = SUELDO_BASE[empleado.getCategory() - 1];


        return sueldoBase + 5000 * empleado.anios;
    }
}