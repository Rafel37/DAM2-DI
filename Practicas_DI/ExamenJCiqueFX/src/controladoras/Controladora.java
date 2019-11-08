package controladoras;

import baseDatos.Conexion;
import baseDatos.DatosDB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import utils.Pelicula;
import utils.Serie;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controladora implements Initializable {

    ObservableList<String> listaCombo_generoPelicula, listaCombo_protagonistaPelicula, listaCombo_cadenaSerie, listaCombo_generoSerie, listViewPeliculas, listViewSerie;

    @FXML
    Button btn_pelicula, btn_serie;

    @FXML
    Label titulo_pelicula, titulo_serie, genero_pelicula, protagonista_pelicula, ano_pelicula, genero_serie, cadena_serie, temporadas_serie;

    @FXML
    ComboBox generoCombo_pelicula, protagonistaCombo_pelicula, cadenaCombo_serie, generoCombo_serie;

    @FXML
    ListView lista_serie, lista_pelicula;

    Connection connection = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        rellenarListas();
        acciones();
    }

    private void instancias() {
        listaCombo_generoPelicula = FXCollections.observableArrayList();
        listaCombo_protagonistaPelicula = FXCollections.observableArrayList();
        listaCombo_cadenaSerie = FXCollections.observableArrayList();
        listaCombo_generoSerie = FXCollections.observableArrayList();
    }

    private void acciones() {
        btn_pelicula.setOnAction(new ManejoAction());
        btn_serie.setOnAction(new ManejoAction());
    }

    class ManejoAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == btn_pelicula) {
                filtrarPelicula();
            } else if (event.getSource() == btn_serie) {
                //filtrarSerie();
            }
        }
    }

    private void filtrarPelicula() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    connection = Conexion.dbConnector();
                    Statement st = connection.createStatement();
                    String query = "SELECT %s FROM %s";
                    ResultSet rs = st.executeQuery(String.format(query,DatosDB.TABLA_PELICULAS_COL_TITU, DatosDB.TABLA_PELICULAS));
                    while (rs.next()) {
                        String titulo = rs.getString(DatosDB.TABLA_PELICULAS_COL_TITU);
                        String genero = rs.getString(DatosDB.TABLA_PELICULAS_COL_GEN);
                        String protagonista = rs.getString(DatosDB.TABLA_PELICULAS_COL_PROT);
                        int anio = rs.getInt(DatosDB.TABLA_PELICULAS_COL_ID);
                        Pelicula p = new Pelicula(titulo, genero, protagonista, anio);
                        // rellenarListView();
                    }
                    //connection.commit();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private void filtrarSerie() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    connection = Conexion.dbConnector();
                    Statement st = connection.createStatement();
                    String query = "SELECT * FROM %s";
                    ResultSet rs = st.executeQuery(String.format(query, DatosDB.TABLA_SERIES));
                    while (rs.next()) {
                        String titulo = rs.getString(DatosDB.TABLA_SERIES_COL_TITU);
                        String genero = rs.getString(DatosDB.TABLA_SERIES_COL_GEN);
                        String cadena = rs.getString(DatosDB.TABLA_SERIES_COL_CAD);
                        int temporadas = rs.getInt(DatosDB.TABLA_SERIES_COL_TEMP);
                        Pelicula p = new Pelicula(titulo, genero, cadena, temporadas);
                        // rellenarListView();
                    }
                    //connection.commit();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private void selectGeneroComboPeliculas() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    connection = Conexion.dbConnector();
                    Statement st = connection.createStatement();
                    String query = "SELECT * FROM %s";
                    ResultSet rs = st.executeQuery(String.format(query, DatosDB.TABLA_PELICULAS));
                    while (rs.next()) {
                        //String titulo = rs.getString(DatosDB.TABLA_PELICULAS_COL_TITU);
                        String genero = rs.getString(DatosDB.TABLA_PELICULAS_COL_GEN);
                        //String protagonista = rs.getString(DatosDB.TABLA_PELICULAS_COL_PROT);
                        //int anio = rs.getInt(DatosDB.TABLA_PELICULAS_COL_ID);
                        //Pelicula p = new Pelicula(titulo, genero, protagonista, anio);
                        //listaCombo_generoPelicula.add(p);
                        listaCombo_generoPelicula.add(genero);
                        // rellenarListView();
                    }
                    //connection.commit();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private void selectProtagonistaComboPeliculas() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    connection = Conexion.dbConnector();
                    Statement st = connection.createStatement();
                    String query = "SELECT * FROM %s";
                    ResultSet rs = st.executeQuery(String.format(query, DatosDB.TABLA_PELICULAS));
                    while (rs.next()) {
                        //String titulo = rs.getString(DatosDB.TABLA_PELICULAS_COL_TITU);
                        //String genero = rs.getString(DatosDB.TABLA_PELICULAS_COL_GEN);
                        String protagonista = rs.getString(DatosDB.TABLA_PELICULAS_COL_PROT);
                        //int anio = rs.getInt(DatosDB.TABLA_PELICULAS_COL_ID);
                        //Pelicula p = new Pelicula(titulo, genero, protagonista, anio);
                        //listaCombo_generoPelicula.add(p);
                        listaCombo_generoPelicula.add(protagonista);
                        // rellenarListView();
                    }
                    //connection.commit();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private void selectCadenaComboSeries() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    connection = Conexion.dbConnector();
                    Statement st = connection.createStatement();
                    String query = "SELECT * FROM %s";
                    ResultSet rs = st.executeQuery(String.format(query, DatosDB.TABLA_SERIES));
                    while (rs.next()) {
                        //String titulo = rs.getString(DatosDB.TABLA_PELICULAS_COL_TITU);
                        String cadena = rs.getString(DatosDB.TABLA_SERIES_COL_CAD);
                        //String protagonista = rs.getString(DatosDB.TABLA_PELICULAS_COL_PROT);
                        //int anio = rs.getInt(DatosDB.TABLA_PELICULAS_COL_ID);
                        //Pelicula p = new Pelicula(titulo, genero, protagonista, anio);
                        //listaCombo_generoPelicula.add(p);
                        listaCombo_generoPelicula.add(cadena);
                        // rellenarListView();
                    }
                    //connection.commit();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private void selectGeneroComboSerie() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    connection = Conexion.dbConnector();
                    Statement st = connection.createStatement();
                    String query = "SELECT * FROM %s";
                    ResultSet rs = st.executeQuery(String.format(query, DatosDB.TABLA_SERIES));
                    while (rs.next()) {
                        //String titulo = rs.getString(DatosDB.TABLA_PELICULAS_COL_TITU);
                        String genero = rs.getString(DatosDB.TABLA_SERIES_COL_GEN);
                        //String protagonista = rs.getString(DatosDB.TABLA_PELICULAS_COL_PROT);
                        //int anio = rs.getInt(DatosDB.TABLA_PELICULAS_COL_ID);
                        //Pelicula p = new Pelicula(titulo, genero, protagonista, anio);
                        //listaCombo_generoPelicula.add(p);
                        listaCombo_generoPelicula.add(genero);
                        // rellenarListView();
                    }
                    //connection.commit();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private void rellenarListas() {
        selectGeneroComboPeliculas();
        selectProtagonistaComboPeliculas();
        selectCadenaComboSeries();
        selectGeneroComboSerie();

        generoCombo_pelicula.setItems(listaCombo_generoPelicula);
        protagonistaCombo_pelicula.setItems(listaCombo_protagonistaPelicula);
        cadenaCombo_serie.setItems(listaCombo_cadenaSerie);
        generoCombo_serie.setItems(listaCombo_generoSerie);

        generoCombo_pelicula.setValue("Selecciona Genero");
        protagonistaCombo_pelicula.setValue("Selecciona Protagonista");
        cadenaCombo_serie.setValue("Selecciona Cadena");
        generoCombo_serie.setValue("Selecciona Genero");

        generoCombo_pelicula.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

            }
        });
    }

    private void rellenarListViewPelicula() {
        listViewPeliculas = FXCollections.observableArrayList();

        //TODO: RELLENAR LA LISTA
        lista_pelicula.setItems(listViewPeliculas);
        lista_pelicula.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Pelicula p = (Pelicula) newValue;
                titulo_pelicula.setText(p.getTitulo());
                genero_pelicula.setText(p.getGenero());
                protagonista_pelicula.setText(p.getProtagonista());
                ano_pelicula.setText(String.valueOf(p.getAnio()));
            }
        });
    }

    private void rellenarListViewSerie() {
        listViewSerie = FXCollections.observableArrayList();

        //TODO: RELLENAR LA LISTA
        lista_serie.setItems(listViewSerie);
        lista_serie.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Serie s = (Serie) newValue;
                titulo_serie.setText(s.getTitulo());
                genero_serie.setText(s.getGenero());
                cadena_serie.setText(s.getCadena());
                temporadas_serie.setText(String.valueOf(s.getTemporadas()));
            }
        });
    }

}