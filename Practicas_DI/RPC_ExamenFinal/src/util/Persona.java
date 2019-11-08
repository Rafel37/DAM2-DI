package util;

public class Persona {

   String nombre, apellidos, edad;

    public Persona(String nombre, String apellidos, String edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return getNombre();
    }

}

