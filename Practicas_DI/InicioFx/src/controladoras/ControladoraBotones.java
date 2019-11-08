package controladoras;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraBotones implements Initializable {

    @FXML
    Button botonNormal;

    @FXML
    JFXButton botonMaterial;

    @FXML
    Label etiquetaCambio;

    @FXML
    BorderPane borderPane;

    @FXML
    ToggleButton toggleNormal;

    @FXML
    JFXToggleButton toggleMaterial;

    @FXML
    RadioButton radioNormal, radioG1, radioG2, radioG3;

    @FXML
    JFXRadioButton radioMaterial;

    @FXML
    CheckBox checkNormal;

    @FXML
    JFXCheckBox checkMaterial;

    ToggleGroup grupo;
    DropShadow sombra;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instancias();
        Image image = new Image(getClass().getResourceAsStream("/recursos/blanka.png"));
        persoBoton(image, botonNormal);
        //botonNormal.setEffect(sombra);
        //personalizarBotones();
        // personalizarCheck();
        acciones();


    }

    private void personalizarCheck() {
        checkNormal.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        /*
        checkMaterial.setOnAction(new EventHandler<ActionEvent>() {


        @Override
        public void handle (ActionEvent event){
            if (checkMaterial.isSelected()) {
                checkNormal.setSelected(true);
            } else {
                checkNormal.setSelected(false);
                    }
                }
            });
        */
        checkMaterial.setOnAction(new ManejoAction());


        radioNormal.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });
        radioMaterial.setOnAction(new ManejoAction());

        toggleMaterial.setOnAction(new ManejoAction());

    }

    private void personalizarBotones() {
        checkNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(checkNormal.isSelected());
            }
        });
    }

    private void acciones() {
        botonNormal.setOnAction(new ManejoAction());
        botonMaterial.setOnAction(new ManejoAction());
        botonNormal.setOnMouseEntered(new ManejoRaton());
        botonNormal.setOnMouseExited(new ManejoRaton());

        checkMaterial.setOnAction(new ManejoAction());
        toggleMaterial.setOnAction(new ManejoAction());
        radioMaterial.setOnAction(new ManejoAction());

        grupo.getToggles().addAll(radioG1, radioG2, radioG3);

        //voy a evaluar del elemento seleccionado cuando va a verdadero
        //da fallo porque no esta seleccionado ninguno
        /*
        grupo.getSelectedToggle().selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }
        });
        */

        //voy a evaluar cuando cambia, del grupo completo
        grupo.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                System.out.println(newValue.toString());
            }
        });
        /*
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        */
        /*
        borderPane.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        */

    }

    private void instancias() {

        sombra = new DropShadow();
        grupo = new ToggleGroup();
    }

    public void persoBoton(Image image, Button b) {
        ImageView imageView = new ImageView(image);
        b.setGraphic(imageView);
        b.setText(null);
        b.setBackground(null);
        b.setBorder(null);
    }

    class ManejoAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == botonNormal) {
                etiquetaCambio.setText("Cambio desde el botón normal");
            } else if (event.getSource() == botonMaterial) {
                etiquetaCambio.setText("Cambio desde el botón material");
            } else if (event.getSource() == checkMaterial) {
                if (checkMaterial.isSelected()) {
                    checkNormal.setSelected(checkMaterial.selectedProperty().getValue());
                } else {
                    checkNormal.setSelected(checkMaterial.selectedProperty().getValue());
                }
            } else if (event.getSource() == toggleMaterial) {
                if (toggleMaterial.isSelected()) {
                    toggleNormal.setSelected(toggleMaterial.selectedProperty().getValue());
                } else {
                    toggleNormal.setSelected(toggleMaterial.selectedProperty().getValue());
                }
            }else if (event.getSource() == radioMaterial) {
                if (radioMaterial.isSelected()) {
                    radioNormal.setSelected(radioMaterial.selectedProperty().getValue());
                } else {
                    radioNormal.setSelected(radioMaterial.selectedProperty().getValue());
                }
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                botonNormal.setEffect(sombra);
            } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                botonNormal.setEffect(null);
            }
        }
    }
}
