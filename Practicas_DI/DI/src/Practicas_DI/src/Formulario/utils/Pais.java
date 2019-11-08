package Formulario.utils;

import java.util.ArrayList;

public class Pais {

    String nombre;
    ArrayList<String> ciudades;

    public Pais(String nombre, ArrayList<String> ciudades) {
        this.nombre = nombre;
        this.ciudades = ciudades;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getCiudades() {
        return ciudades;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
