package controladoras;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import utils.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraListas implements Initializable {

    ObservableList<Persona> listaCombo, listaComboMaterial, listaChoice, listaListView;


    @FXML
    ComboBox comboNormal;

    @FXML
    ChoiceBox choiceNormal;

    @FXML
    JFXComboBox comboMaterial;

    @FXML
    ListView listaNormal;

    @FXML
    JFXListView listaMaterial;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        rellenarListas();
        rellenarListasMaterial();
        rellenarChoice();
        rellenarListView();
        acciones();

    }

    private void rellenarListView() {
        listaListView = FXCollections.observableArrayList();
        listaListView.add(new Persona("nomb1", "ape1", 123));
        listaListView.add(new Persona("nomb2", "ape2", 234));
        listaListView.add(new Persona("nomb3", "ape3", 345));
        listaListView.add(new Persona("nomb4", "ape4", 456));
        listaNormal.setItems(listaListView);
        listaNormal.getSelectionModel().select(0);
        //tener cuidado con el metodo '.getSelectedItem() porque ahi otro igual pero con s
        //y ese coge toda la lista
        ((Persona) listaNormal.getSelectionModel().getSelectedItem()).getNombre();
        listaNormal.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Persona p = (Persona) newValue;
                System.out.println(p.getApellido());
            }
        });
        listaMaterial.setItems(listaListView);
        listaMaterial.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Persona p = (Persona) newValue;
                System.out.println(p.getApellido());
            }
        });
    }

    private void rellenarChoice() {
        listaChoice.add(new Persona("nomb1", "ape1", 123));
        listaChoice.add(new Persona("nomb2", "ape2", 456));
        listaChoice.add(new Persona("nomb3", "ape3", 789));
        listaChoice.add(new Persona("nomb4", "ape4", 012));

        choiceNormal.setItems(listaChoice);
        choiceNormal.setValue(listaChoice.get(0));
        choiceNormal.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(((Persona) newValue).getTelefono());
            }
        });
    }


    private void acciones() {

        /*
        comboNormal.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    listaCombo.add(new Persona(comboNormal.getEditor().getText(), "", 234));
                }
            }
        });
        */
    }

    private void rellenarListasMaterial() {
        listaComboMaterial.add(new Persona("nomb1", "ape1", 123));
        listaComboMaterial.add(new Persona("nomb2", "ape2", 456));
        listaComboMaterial.add(new Persona("nomb3", "ape3", 789));
        listaComboMaterial.add(new Persona("nomb4", "ape4", 012));

        comboMaterial.setItems(listaComboMaterial);
        comboMaterial.setValue(listaComboMaterial.get(0));
        comboMaterial.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(((Persona) newValue).getTelefono());
            }
        });
    }

    private void rellenarListas() {
        listaCombo.add(new Persona("nombre1", "apellido1", 123));
        listaCombo.add(new Persona("nombre2", "apellido2", 456));
        listaCombo.add(new Persona("nombre3", "apellido3", 789));
        listaCombo.add(new Persona("nombre4", "apellido4", 012));

        comboNormal.setItems(listaCombo);
        comboNormal.setValue(listaCombo.get(0));
        //apartir de este momento el combo puede ser editable
        //comboNormal.setEditable(true);
        Persona a = (Persona) comboNormal.getSelectionModel().getSelectedItem();
        //System.out.println(a.getTelefono());
        comboNormal.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(((Persona) newValue).getTelefono());
            }
        });
    }


    private void instancias() {
        listaCombo = FXCollections.observableArrayList();
        listaComboMaterial = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
    }

}
