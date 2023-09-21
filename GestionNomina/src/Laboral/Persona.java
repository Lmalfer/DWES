package Laboral;

/**
 * Clase que representa a una Persona.
 */
public class Persona {
    public String nombre, dni;
    public char sexo;
    /**
     * Constructor de la clase Persona con todos los atributos.
     *
     * @param nombre El nombre de la persona.
     * @param dni    El DNI de la persona.
     * @param sexo   El sexo de la persona.
     */
    public Persona(String nombre, String dni, char sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
    }

    /**
     * Constructor de la clase Persona con nombre y sexo.
     *
     * @param nombre El nombre de la persona.
     * @param sexo   El sexo de la persona.
     */
    public Persona(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }

    /**
     * Modifica el valor del DNI de la persona.
     *
     * @param dni El nuevo DNI de la persona.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Imprime el nombre y el DNI de la persona.
     */
    public void imprime() {

        System.out.println("Nombre: "+ nombre);
        System.out.println("DNI: " + dni);
    }
}
