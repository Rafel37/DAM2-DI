package fundamentos;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Eventos implements Initializable {

    @FXML
    TextField editNombre;
    @FXML
    TextField editApellido;
    @FXML
    TextField editDireccion;
    @FXML
    TextField editMovil;
    @FXML
    TextField editFijo;
    @FXML
    TextField editNumero;
    @FXML
    Button botonValidar;
    @FXML
    Button botonLimpiar;
    @FXML
    GridPane layoutNumeros;
    @FXML
    GridPane layoutLetras;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        layoutLetras.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                try {
                    if (Character.isDigit(event.getCharacter().charAt(0))) {
                        event.consume();
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    //TODO detectar backspace
                }
            }
        });

        layoutNumeros.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                try {
                    if (!Character.isDigit(event.getCharacter().charAt(0))) {

                        event.consume();
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    //TODO detectar backspace
                }
            }
        });

        editMovil.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (editMovil.getText().length() > 8) {
                    event.consume();
                }
            }
        });

        botonValidar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                ObservableList<Node> elementosNumeros = layoutNumeros.getChildren();
                ObservableList<Node> elementosLetras = layoutNumeros.getChildren();

                for (Node n: elementosNumeros
                        ) {
                    if (((TextField)n).getText().isEmpty()){
                        System.out.println("Existe algún elemento vacío");
                    }
                }
                for (Node n: elementosLetras
                        ) {
                    if (((TextField)n).getText().isEmpty()){
                        System.out.println("Existe algún elemento vacío");
                    }
                }

               elementosNumeros = null;
               elementosLetras = null;

            }
        });
    }

     @FXML public void limpiarContenidos(){


        ObservableList<Node> elementosNumeros = layoutNumeros.getChildren();
         for (Node n: elementosNumeros
              ) {
             ((TextField)n).setText("");
         }

         ObservableList<Node> elementosLetras = layoutLetras.getChildren();
         for (Node n: elementosLetras
              ) {
             ((TextField)n).setText("");
         }

         elementosLetras = null;
         elementosNumeros = null;
    }
}
