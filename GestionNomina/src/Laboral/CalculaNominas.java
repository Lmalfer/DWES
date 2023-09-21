package Laboral;

/**
 * Clase que calcula nóminas y muestra información de los empleados.
 */
public class CalculaNominas {
    /**
     * Constructor de la clase CalculaNominas.
     */
    public CalculaNominas() {
    }

    /**
     * Muestra información sobre un empleado y su sueldo.
     *
     * @param empl El empleado del que se mostrará la información.
     */
    private void escribe(Empleado empl) {
        empl.imprime();
        Nomina nomina = new Nomina();
        String var10001 = empl.nombre;
        System.out.println("El empleado " + var10001 + " tiene un sueldo de " + nomina.sueldo(empl));
    }

    /**
     * Método principal que crea empleados, calcula nóminas y muestra información.
     *
     * @param args Los argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        try {
            Empleado emp1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7.0);
            Empleado emp2 = new Empleado("Ada Lovelace", "32000031r", 'F');

            CalculaNominas calcula = new CalculaNominas();
            calcula.escribe(emp1);
            calcula.escribe(emp2);
            System.out.println();
            System.out.println();
            emp2.incrAnio();
            emp1.setCategory(9);
            calcula.escribe(emp1);
            calcula.escribe(emp2);
        } catch (DatosNoCorrectosException e) {
            System.err.println("Datos no correctos: " + e.getMessage());
        }
    }
}
