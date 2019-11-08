package utils;

public class Usuario {

    static String nombre, apellidos, correo, contrasenia, ciclo;
    static int conocimientoPrevio;

    public Usuario(String nombre, String apellidos, String correo, String contrasenia, String ciclo, int conocimientoPrevio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.ciclo = ciclo;
        this.conocimientoPrevio = conocimientoPrevio;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getApellidos() {
        return apellidos;
    }

    public static String getCorreo() {
        return correo;
    }

    public static String getContrasenia() {
        return contrasenia;
    }

    public static String getCiclo() {
        return ciclo;
    }

    public static int getConocimientoPrevio() {
        return conocimientoPrevio;
    }
}
