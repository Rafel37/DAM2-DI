package controladoras;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.Edad;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraInsertar implements Initializable {

    @FXML
    JFXTextField nombre, apellido;
    @FXML
    JComboBox edad;
    @FXML
    JFXTextArea direccion;

    ObservableList<Edad> listaCombo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rellenarCombo();
    }

    private void rellenarCombo() {
        listaCombo.add(new Edad("1"));
        listaCombo.add(new Edad("2"));
        listaCombo.add(new Edad("3"));

    }
}