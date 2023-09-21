package Laboral;

public class CalculaNominas {
    Empleado empl;
    public CalculaNominas() {
    }

    private void escribe(Empleado empl) {
        empl.imprime();
        Nomina nomina = new Nomina();
        String var10001 = empl.nombre;
        System.out.println("El empleado " + var10001 + "tiene un sueldo de " + nomina.sueldo(empl));
    }

    public static void main(String[] args) throws DatosNoCorrectosException {
        Empleado emp1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7.0);
        Empleado emp2 = new Empleado("Ada Lovelace", "32000031r", 'F');
        CalculaNominas calcula = new CalculaNominas();
        calcula.escribe(emp1);
        calcula.escribe(emp2);
        System.out.println();
        System.out.println();
        emp2.incrAnio();
        emp2.incrAnio();
        emp1.setCategory(9);
        calcula.escribe(emp1);
        calcula.escribe(emp2);
    }
}
