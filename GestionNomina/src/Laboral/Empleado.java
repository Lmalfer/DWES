package Laboral;
/**
 * Clase que representa a un Empleado, que extiende de Persona.
 */
public class Empleado extends Persona {

    private int category;
    public double anios;

    /**
     * Constructor de la clase Empleado con todos los atributos.
     *
     * @param nombre    El nombre del empleado.
     * @param dni       El DNI del empleado.
     * @param sexo      El sexo del empleado.
     * @param category La categoría del empleado.
     * @param anios     Los años trabajados por el empleado.
     */
    public Empleado (String nombre, String dni, char sexo, int category, double anios) throws DatosNoCorrectosException{
        super(nombre, dni, sexo);
        this.category = category;
        if(anios >= 0){
            this.anios = anios;
        }else{
            throw new DatosNoCorrectosException("No es posible resolver ");
        }
    }

    /**
     * Constructor de la clase Empleado con nombre, sexo y DNI.
     * Se asume que la categoría es 1 y los años trabajados son 0.
     *
     * @param nombre El nombre del empleado.
     * @param sexo   El sexo del empleado.
     * @param dni    El DNI del empleado.
     */
    public Empleado(String nombre, String dni, char sexo) {
        super(nombre, dni, sexo);
    }

    /**
     * Cambia la categoría del empleado.
     *
     * @param category Nueva categoría del empleado.
     * @throws DatosNoCorrectosException
     */
    public void setCategory(int category) throws DatosNoCorrectosException{
        if (category >= 1 && category <= 10) {
            this.category = category;
        }else{
            throw new DatosNoCorrectosException("No es posible resolver");
        }
    }

    /**
     * Devuelve la categoría del empleado.
     *
     * @return La categoría del empleado.
     */
    public int getCategory() {
        return category;
    }
    /**
     * Incrementa en uno el número de años trabajados.
     */
    public void incrAnio() {
        anios++;
    }

    /**
     * Imprime todos los datos del empleado.
     */
    public void imprime() {

        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Sexo: " + sexo);
        System.out.println("Category: " + category);
        System.out.println("Anios: " + anios);
    }
}

