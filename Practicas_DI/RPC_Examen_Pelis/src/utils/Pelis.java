package utils;

public class Pelis {

    String titulo, estreno;
    double valoracion;

    public Pelis(String titulo, String estreno, double valoracion) {
        this.titulo = titulo;
        this.estreno = estreno;
        this.valoracion = valoracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEstreno() {
        return estreno;
    }

    public double getVaoracion() {
        return valoracion;
    }

    @Override
    public String toString() {
        return getTitulo();
    }
}
