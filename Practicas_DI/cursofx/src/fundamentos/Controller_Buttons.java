package fundamentos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller_Buttons implements Initializable {

    @FXML
    Button botonNormal;
    @FXML
    Button botonImagen;
    @FXML
    Button botonEfecto;

    @FXML
    RadioButton radioNormal;
    @FXML
    RadioButton radioImagen;
    @FXML
    RadioButton radioGrupo1;
    @FXML
    RadioButton radioGrupo2;

    @FXML
    Toggle toggleNormal;

    @FXML CheckBox checkNormal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        configuracionBotones();
        configuracionRadios();
        configuracioToggle();
        configuracionCheck();


    }

    private void configuracionBotones() {
        Image imagenOk = new Image(getClass().getResourceAsStream("recursos/ok.png"));
        Image imagenCancel = new Image(getClass().getResourceAsStream("recursos/cancel.png"));

        botonNormal.setText("Normal");
        botonNormal.setDefaultButton(true);
        botonNormal.setCancelButton(true);
        botonNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón pulsado");
            }
        });

        DropShadow sombra = new DropShadow();
        botonEfecto.setGraphic(new ImageView(imagenOk));
        botonEfecto.setBorder(null);
        botonEfecto.setBackground(Background.EMPTY);
        botonEfecto.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                botonEfecto.setEffect(sombra);
            }
        });
        botonEfecto.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                botonEfecto.setEffect(null);
            }
        });

        botonImagen.setGraphic(new ImageView(imagenCancel));
        botonImagen.setBorder(null);
        botonImagen.setBackground(Background.EMPTY);
        botonImagen.setDefaultButton(true);
        botonImagen.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                botonImagen.setEffect(sombra);
            }
        });
        botonImagen.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                botonImagen.setEffect(null);
            }
        });


    }

    private void configuracionRadios() {


        Image imagenDeseleccionado = new Image(getClass().getResourceAsStream("recursos/unselected.png"));
        Image imagenSeleccionado = new Image(getClass().getResourceAsStream("recursos/selected.png"));
        Image imagenSobre = new Image(getClass().getResourceAsStream("recursos/over.png"));

        radioImagen.setGraphic(new ImageView(imagenDeseleccionado));

        radioNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Radio pulsado");
            }
        });

        radioImagen.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!radioImagen.isSelected()) {
                    radioImagen.setGraphic(new ImageView(imagenSobre));
                }
            }
        });

        radioImagen.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!radioImagen.isSelected()) {
                    radioImagen.setGraphic(new ImageView(imagenDeseleccionado));
                }
            }
        });

        radioImagen.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    radioImagen.setGraphic(new ImageView(imagenSeleccionado));
                } else {
                    radioImagen.setGraphic(new ImageView(imagenDeseleccionado));
                }
            }
        });

        ToggleGroup grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioGrupo1, radioGrupo2);
        radioGrupo1.setUserData("Radio 1");
        radioGrupo2.setUserData("Radio 2");
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                System.out.println("El radio seleccionado es el " + newValue.getUserData().toString());
            }
        });


    }

    private void configuracioToggle() {

        toggleNormal.isSelected();

        toggleNormal.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue){
                    System.out.println("El toggle está activado");
                }
                else
                    System.out.println("El toggle está desactivado");
            }
        });

    }

    private void configuracionCheck() {
        Image imagenOn = new Image(getClass().getResourceAsStream("recursos/togOn.png"));
        Image imagenOff = new Image(getClass().getResourceAsStream("recursos/togOff.png"));
        checkNormal.setGraphic(new ImageView(imagenOff));
        checkNormal.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue){
                    checkNormal.setGraphic(new ImageView(imagenOn));
                }
                else
                    checkNormal.setGraphic(new ImageView(imagenOff));
            }
        });
    }


}
