public class Usuarios {

    String nombre, dni, edad;
    int telefono;

    public Usuarios(String nombre, String dni, String edad, int telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getEdad() {
        return edad;
    }

    public int getTelefono() {
        return telefono;
    }
}
