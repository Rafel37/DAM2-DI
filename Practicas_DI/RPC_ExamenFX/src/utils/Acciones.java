package utils;

public class Acciones {

    String accion;
    int identificador;

    public Acciones(String accion, int identificador) {
        this.accion = accion;
        this.identificador = identificador;
    }

    public String getAccion() {
        return accion;
    }

    public int getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return getAccion();
    }
}
