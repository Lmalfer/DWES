package Laboral;

public class Empleado extends Persona {

    private int category;
    public double anios;


    public Empleado (String nombre, String dni, char sexo, int category, double anios) throws DatosNoCorrectosException{
        super(nombre, dni, sexo);
        this.category = category;
        if(anios >= 0){
            this.anios = anios;
        }else{
            throw new DatosNoCorrectosException("No es posible resolver ");
        }
    }

    public Empleado(String nombre, String dni, char sexo) {
        super(nombre, dni, sexo);
    }

    public void setCategory(int category) throws DatosNoCorrectosException{
        if (category >= 1 && category <= 10) {
            this.category = category;
        }else{
            throw new DatosNoCorrectosException("No es posible resolver");
        }
    }

    public int getCategory() {
        return category;
    }

    public void incrAnio() {
        anios++;
    }

    public void imprime() {

        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Sexo: " + sexo);
        System.out.println("Category: " + category);
        System.out.println("Anios: " + anios);
    }
}

