package fundamentos;

import fundamentos.utils.AlumnoTabla;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Tabla implements Initializable {

    @FXML
    TableView tabla;
    @FXML
    TableColumn colNombre;
    @FXML
    TableColumn colApellido;
    @FXML
    TableColumn colMail;
    @FXML
    TableColumn colTelefono;
    @FXML
    TableColumn colMatriculado;

    @FXML
    Button anadirTabla;
    @FXML
    Button borrarTabla;


    ObservableList listaAlumnos = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rellenarTabla();
        modificarDatos();

    }

    private void rellenarTabla() {

        listaAlumnos.addAll(new AlumnoTabla("Nombre1", "Apellido1", "email1@gmail.com", 123, true),
                new AlumnoTabla("Nombre2", "Apellido2", "emai21@gmail.com", 123, false),
                new AlumnoTabla("Nombre3", "Apellido3", "emai31@gmail.com", 123, true),
                new AlumnoTabla("Nombre4", "Apellido4", "emai41@gmail.com", 123, false),
                new AlumnoTabla("Nombre5", "Apellido5", "emai51@gmail.com", 123, false));

        // se asocia a cada columna la propierdad que se desea del objeto indicado en el PropertyValueFactory
        colNombre.setCellValueFactory(new PropertyValueFactory<AlumnoTabla, String>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<AlumnoTabla, String>("apellido"));
        colMail.setCellValueFactory(new PropertyValueFactory<AlumnoTabla, String>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<AlumnoTabla, Integer>("telefono"));
        colMatriculado.setCellValueFactory(new PropertyValueFactory<AlumnoTabla,Boolean>("matriculado"));

        // se asocia la lista de datos a la tabla
        tabla.setItems(listaAlumnos);

        // modifica el aspecto minimo y máximo que tendrá la tabla
        tabla.setPrefWidth(600);
        tabla.setMinWidth(0);

        // modifica el aspecto que tendrán las columnas
        colNombre.prefWidthProperty().bind(tabla.widthProperty().multiply(0.25));
        colApellido.prefWidthProperty().bind(tabla.widthProperty().multiply(0.25));
        colTelefono.prefWidthProperty().bind(tabla.widthProperty().multiply(0.25));
        colMail.prefWidthProperty().bind(tabla.widthProperty().multiply(0.25));


        // añade el boton para selección de columnas
        tabla.setTableMenuButtonVisible(true);

        // muestra un elemento si la tabla está vacía
        tabla.setPlaceholder(new Label("La tabla con contiene datos"));

    }

    private void modificarDatos() {

        // añadir un elemento a la tabla
        anadirTabla.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listaAlumnos.add(new AlumnoTabla("NombreNuevo", "ApellidoNuevo", "nuevo@gmail.com", 123,true));
                tabla.refresh();
            }
        });

        // eliminar un elemento de la tabla
        borrarTabla.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listaAlumnos.remove(tabla.getSelectionModel().getSelectedIndex());
                tabla.refresh();
            }
        });

        // evaluar la selección de la tabla según el cambio
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                AlumnoTabla seleccionado = (AlumnoTabla) newValue;
                System.out.println(seleccionado.getNombre());
                System.out.println(((AlumnoTabla)tabla.getSelectionModel().getSelectedItem()).getNombre());
            }
        });
    }
}
