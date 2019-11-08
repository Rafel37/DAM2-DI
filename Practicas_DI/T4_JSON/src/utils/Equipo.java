package utils;

public class Equipo {

    String nombre, estadio, descripcion, url, liga;

    public Equipo(String nombre, String estadio, String descripcion, String url, String liga) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.descripcion = descripcion;
        this.url = url;
        this.liga = liga;
    }

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLiga() {
        return liga;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
