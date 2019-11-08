package utils;

public class Edad {

    String edad;

    public Edad(String edad) {
        this.edad = edad;
    }

    public String getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return getEdad();
    }
}
