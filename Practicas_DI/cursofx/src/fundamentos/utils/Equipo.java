package fundamentos.utils;

public class Equipo {

    String nombre, web;

    public Equipo(String nombre, String web) {
        this.nombre = nombre;
        this.web = web;
    }

    public String getNombre() {
        return nombre;
    }

    public String getWeb() {
        return web;
    }
}
