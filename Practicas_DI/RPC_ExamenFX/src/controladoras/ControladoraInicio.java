package controladoras;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Acciones;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraInicio implements Initializable, EventHandler<ActionEvent> {

    ObservableList<Acciones> listaCombo;

    @FXML
    JFXComboBox comboInicio;

    @FXML
    JFXButton bInicio;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rellenarLista();
        acciones();
    }

    private void acciones() {
        bInicio.setOnAction(this);
    }

    private void rellenarLista() {
        //rellenar
        listaCombo = FXCollections.observableArrayList();
        listaCombo.add(new Acciones("ver",1));
        listaCombo.add(new Acciones("insertar",2));
        //asignar
        comboInicio.setItems(listaCombo);



        //listener evaluar
        comboInicio.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(((Acciones) newValue).getAccion());
            }
        });
    }



    @Override
    public void handle(ActionEvent event) {
        Parent root;
        Scene scene;
        Stage stage;

        if (event.getSource() == bInicio) {
            // VER
            if (comboInicio.getValue() == "ver") {
                try {
                    root = FXMLLoader.load(getClass().getResource("../vistas/ver.fxml"));
                    scene = new Scene(root, 300, 275);
                    stage = (Stage) bInicio.getScene().getWindow();
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // INSERTAR
            else if (comboInicio.getValue() == "insertar") {
                try {
                    root = FXMLLoader.load(getClass().getResource("../vistas/insertar.fxml"));
                    scene = new Scene(root, 300, 275);
                    stage = (Stage) bInicio.getScene().getWindow();
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        }

}
