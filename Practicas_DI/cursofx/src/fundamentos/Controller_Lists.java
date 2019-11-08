package fundamentos;

import fundamentos.utils.Alumno;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by borja on 6/7/18.
 */
public class Controller_Lists implements Initializable {

    @FXML
    ChoiceBox choiceBox;
    @FXML
    ComboBox comboBox;
    @FXML
    ListView listView;

    ObservableList listaChoice = FXCollections.observableArrayList();
    ObservableList listaCombo = FXCollections.observableArrayList();
    ObservableList listaListView = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        persoChoice();
        persoCombo();
        persoListView();

    }

    private void persoChoice() {
        listaChoice.add(new Alumno("Alumno1", "Apellido1", 1, 123));
        listaChoice.add(new Alumno("Alumno2", "Apellido2", 2, 223));
        listaChoice.add(new Alumno("Alumno3", "Apellido3", 3, 323));
        listaChoice.add(new Alumno("Alumno4", "Apellido4", 4, 423));
        listaChoice.add(new Alumno("Alumno5", "Apellido5", 5, 523));

        //Asocia unos elemenos determiandos al choicebox
        choiceBox.setItems(listaChoice);
        // obtiene el elemento seleccionado en la posición indicada
        choiceBox.getSelectionModel().select(0);
        // obtiene el elemento seleccioando
        choiceBox.getSelectionModel().getSelectedItem();
        //obtiene el índice del elemento seleccionado
        choiceBox.getSelectionModel().getSelectedIndex();

        //manejo de los elementos de la lista
        //choiceBox.getItems().add();
        //choiceBox.getItems().remove()

        Alumno alumno = (Alumno) choiceBox.getSelectionModel().getSelectedItem();

        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Alumno alumno = (Alumno) newValue;
                System.out.println("Seleccionado " + alumno.getNombre() + " " + alumno.getApellido());
            }
        });

    }

    private void persoCombo() {

        listaCombo.add(new Alumno("Alumno1", "Apellido1", 1, 123));
        listaCombo.add(new Alumno("Alumno2", "Apellido2", 2, 223));
        listaCombo.add(new Alumno("Alumno3", "Apellido3", 3, 323));
        listaCombo.add(new Alumno("Alumno4", "Apellido4", 4, 423));
        listaCombo.add(new Alumno("Alumno5", "Apellido5", 5, 523));

        //Asocia unos elemenos determiandos al combo
        comboBox.setItems(listaChoice);
        // obtiene el elemento seleccionado en la posición indicada
        comboBox.getSelectionModel().select(0);
        // obtiene el elemento seleccioando
        comboBox.getSelectionModel().getSelectedItem();
        //obtiene el índice del elemento seleccionado
        comboBox.getSelectionModel().getSelectedIndex();

        //manejo de los elementos de la lista
        //choiceBox.getItems().add();
        //choiceBox.getItems().remove()

        comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Alumno alumno = (Alumno) newValue;
                System.out.println("Seleccionado " + alumno.getNombre() + " " + alumno.getApellido());
            }
        });

        // Indica que el contenido del combo se puede editar
        // comboBox.setEditable(true);

    }

    private void persoListView() {

        listaListView.add(new Alumno("Alumno1", "Apellido1", 1, 123));
        listaListView.add(new Alumno("Alumno2", "Apellido2", 2, 223));
        listaListView.add(new Alumno("Alumno3", "Apellido3", 3, 323));
        listaListView.add(new Alumno("Alumno4", "Apellido4", 4, 423));
        listaListView.add(new Alumno("Alumno5", "Apellido5", 5, 523));

        //Asocia unos elemenos determiandos a la lista
        listView.setItems(listaChoice);
        // obtiene el elemento seleccionado en la posición indicada
        listView.getSelectionModel().select(0);
        // obtiene el elemento seleccioando
        listView.getSelectionModel().getSelectedItem();
        //obtiene el índice del elemento seleccionado
        listView.getSelectionModel().getSelectedIndex();

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Alumno alumno = (Alumno) newValue;
                System.out.println("Seleccionado " + alumno.getNombre() + " " + alumno.getApellido());
            }
        });

        // modifica el tipo de selección de la lista
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //Obtiene el elemento con el foco activo
        listView.setTooltip(new Tooltip(((Alumno) listView.getFocusModel().getFocusedItem()).getNombre()));

    }
}
