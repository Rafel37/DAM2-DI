package fundamentos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by borja on 17/7/18.
 */
public class Controller_Menus implements Initializable {

    @FXML
    MenuItem menuAbrir;
    @FXML
    MenuItem menuGuardar;
    @FXML
    MenuItem menuSalir;
    @FXML
    MenuItem menuCopiar;
    @FXML
    MenuItem menuCortar;
    @FXML
    MenuItem menuPegar;
    @FXML
    CheckMenuItem menuMayusculas;
    @FXML
    RadioMenuItem menuCursiva;
    @FXML
    RadioMenuItem menuSubrayada;
    @FXML
    MenuItem menuSobre;
    @FXML
    TextArea textArea;
    ToggleGroup grupoTipoLetra = new ToggleGroup();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // asigna una imagen a cada menú
        Image imagenAbrir = new Image(getClass().getResourceAsStream("recursos/open.png"));
        menuAbrir.setGraphic(new ImageView(imagenAbrir));
        menuGuardar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("recursos/save.png"))));
        menuSalir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("recursos/unselected.png"))));
        menuCopiar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("recursos/copy.png"))));
        menuCortar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("recursos/cut.png"))));
        menuPegar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("recursos/paste.png"))));
        menuMayusculas.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("recursos/unselected.png"))));
        menuCursiva.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("recursos/italic.png"))));
        menuSubrayada.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("recursos/unselected.png"))));

        menuAbrir.setOnAction(new ClaseManejoPulsaciones());
        menuGuardar.setOnAction(new ClaseManejoPulsaciones());
        menuGuardar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        menuSalir.setOnAction(new ClaseManejoPulsaciones());
        menuCopiar.setOnAction(new ClaseManejoPulsaciones());
        menuCortar.setOnAction(new ClaseManejoPulsaciones());
        menuPegar.setOnAction(new ClaseManejoPulsaciones());
        menuMayusculas.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }
        });

        // asigna una convinación de teclas a cada opción del menú
        menuAbrir.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        menuGuardar.setAccelerator(KeyCombination.keyCombination("Ctrl+G"));
        menuSalir.setAccelerator(KeyCombination.keyCombination("Ctrl+Alt+S"));
        menuCopiar.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        menuCortar.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        menuPegar.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
        menuCursiva.setAccelerator(KeyCombination.keyCombination("Ctrl+K"));
        menuSubrayada.setAccelerator(KeyCombination.keyCombination("Ctrl+U"));

        grupoTipoLetra.getToggles().addAll(menuCursiva, menuSubrayada);
        grupoTipoLetra.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                System.out.println(newValue);
            }
        });

        // Constructor del menú contextual
        ContextMenu contextMenu = new ContextMenu();
        // Se añaden todos los items que se quieran
        //contextMenu.getItems().addAll(menuCopiar,menuCopiar,menuCortar);
        MenuItem menuItemContext = new MenuItem("Opción contextual");
        contextMenu.getItems().addAll(menuItemContext);
        // Se agregar un escuchador que evalua la pulsación del botón derecho
        textArea.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (event.getButton() == MouseButton.SECONDARY){
                    // muestra el menu contextual en la posición de la pantalla donde se ha producido el evento
                    contextMenu.show(textArea,event.getScreenX(),event.getScreenY());
                }

            }
        });
    }

    class ClaseManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            Object o = event.getSource();
            //TODO incluir la funcionalidad de cada botón con su acción
            if (o == menuAbrir) {

            } else if (o == menuCopiar) {

            } else if (o == menuCortar) {

            } else if (o == menuCursiva) {

            } else if (o == menuGuardar) {

            } else if (o == menuMayusculas) {

            } else if (o == menuPegar) {

            } else if (o == menuSalir) {

            } else if (o == menuSobre) {

            } else if (o == menuSubrayada) {

            }
        }
    }
}
