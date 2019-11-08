package utils;

public class Persona {

    String nombre, apellido;
    int id, telefono;

    public Persona(String nombre, String apellido, int id, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId() {
        return id;
    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}