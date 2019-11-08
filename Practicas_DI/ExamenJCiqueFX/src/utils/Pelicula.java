package utils;

public class Pelicula {

    String titulo, genero, protagonista;
    int id, anio;

    public Pelicula(int id, String titulo, String genero, String protagonista, int anio) {
        this.titulo = titulo;
        this.genero = genero;
        this.protagonista = protagonista;
        this.id = id;
        this.anio = anio;
    }

    public Pelicula(String titulo, String genero, String protagonista, int anio) {
        this.titulo = titulo;
        this.genero = genero;
        this.protagonista = protagonista;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public int getId() {
        return id;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return titulo;
    }
}