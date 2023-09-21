package Laboral;

public class DatosNoCorrectosException extends Exception {
    public DatosNoCorrectosException(String e) {
        System.out.println("Los datos no son correctos");
    }
}
