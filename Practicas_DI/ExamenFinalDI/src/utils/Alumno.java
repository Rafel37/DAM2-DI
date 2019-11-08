package utils;

public class Alumno {
    private String nombre;
    private String apellido;
    private String curso;
    private double media;

    public Alumno(String nombre, String apellido, String curso, double media) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.media = media;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
