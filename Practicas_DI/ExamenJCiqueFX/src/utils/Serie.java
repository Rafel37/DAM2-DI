package utils;

public class Serie {

    String titulo, genero, cadena;
    int id, temporadas;

    public Serie(int id, String titulo, String genero, String cadena, int temporadas) {
        this.titulo = titulo;
        this.genero = genero;
        this.cadena = cadena;
        this.id = id;
        this.temporadas = temporadas;
    }

    public Serie(String titulo, String genero, String cadena, int temporadas) {
        this.titulo = titulo;
        this.genero = genero;
        this.cadena = cadena;
        this.temporadas = temporadas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getCadena() {
        return cadena;
    }

    public int getId() {
        return id;
    }

    public int getTemporadas() {
        return temporadas;
    }

    @Override
    public String toString() {
        return titulo;
    }
}