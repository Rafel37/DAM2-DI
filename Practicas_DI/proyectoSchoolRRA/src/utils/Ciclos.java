package utils;

public class Ciclos {
    String nombreCiclo;

    public Ciclos(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }

    public String getNombreCiclo() {
        return nombreCiclo;
    }

    @Override
    public String toString() {
        return getNombreCiclo();
    }
}
