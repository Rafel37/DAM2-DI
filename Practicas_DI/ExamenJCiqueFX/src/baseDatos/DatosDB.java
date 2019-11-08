package baseDatos;

public interface DatosDB {

    String TABLA_PELICULAS = "peliculas";
    String TABLA_PELICULAS_COL_ID = "id";
    String TABLA_PELICULAS_COL_TITU = "titulo";
    String TABLA_PELICULAS_COL_GEN = "genero";
    String TABLA_PELICULAS_COL_PROT = "protagonista";
    String TABLA_PELICULAS_COL_ANIO = "anio";

    String TABLA_SERIES = "series";
    String TABLA_SERIES_COL_ID = "id";
    String TABLA_SERIES_COL_TITU = "titulo";
    String TABLA_SERIES_COL_GEN = "genero";
    String TABLA_SERIES_COL_CAD = "cadena";
    String TABLA_SERIES_COL_TEMP = "temporadas";
}