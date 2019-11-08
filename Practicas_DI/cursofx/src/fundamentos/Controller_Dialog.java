package fundamentos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by borja on 7/8/18.
 */
public class Controller_Dialog implements Initializable, EventHandler<ActionEvent> {

    @FXML
    Button bInfo;
    @FXML
    Button bWarning;
    @FXML
    Button bError;
    @FXML
    Button bConfirm;
    @FXML
    Button bConfirmPerso;
    @FXML
    Button bEntrada;
    @FXML
    Button bEleccion;
    @FXML
    Button bPerso;
    @FXML
    Button botonFichero;
    @FXML
    Label labelFichero;
    @FXML
    GridPane gridDialogos;

    ColorPicker dialogoColor = new ColorPicker();
    DatePicker dialogoFecha = new DatePicker();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        bInfo.setOnAction(this);
        bWarning.setOnAction(this);
        bError.setOnAction(this);
        bConfirm.setOnAction(this);
        bConfirmPerso.setOnAction(this);
        bEntrada.setOnAction(this);
        bEleccion.setOnAction(this);
        bPerso.setOnAction(this);
        botonFichero.setOnAction(this);
        dialogoColor.setOnAction(this);
        dialogoFecha.setOnAction(this);
        gridDialogos.setHgap(20);
        gridDialogos.setVgap(20);
        gridDialogos.add(dialogoColor, 0, 1);
        gridDialogos.add(dialogoFecha, 1, 1);
        gridDialogos.setHalignment(dialogoColor, HPos.CENTER);
        gridDialogos.setHalignment(dialogoFecha, HPos.CENTER);
        dialogoColor.setValue(Color.YELLOWGREEN);
        dialogoFecha.setValue(LocalDate.now());
        dialogoFecha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });


    }

    @Override
    public void handle(ActionEvent event) {
        Object fuente = event.getSource();

        if (fuente.equals(bInfo)) {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Diálogo de información");
            dialogoInfo.setHeaderText("Cabecera del cuadro de diálogo de información");
            dialogoInfo.setContentText("Contenido del cuadro de diálogo de información");
            dialogoInfo.showAndWait();

        } else if (fuente.equals(bWarning)) {
            Alert dialogoWarning = new Alert(Alert.AlertType.WARNING);
            dialogoWarning.setTitle("Diálogo de warning");
            dialogoWarning.setHeaderText("Cabecera del cuadro de diálogo de warning");
            dialogoWarning.setContentText("Contenido del cuadro de diálogo de warning");
            dialogoWarning.showAndWait();

        } else if (fuente.equals(bError)) {
            Alert dialogoError = new Alert(Alert.AlertType.ERROR);
            dialogoError.setTitle("Diálogo de error");
            dialogoError.setHeaderText("Cabecera del cuadro de diálogo de error");
            dialogoError.setContentText("Contenido del cuadro de diálogo de error");
            dialogoError.showAndWait();

        } else if (fuente.equals(bConfirm)) {
            Alert dialogoConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoConfirmacion.setTitle("Diálogo de confirmación");
            dialogoConfirmacion.setHeaderText("Cabecera del cuadro de diálogo de confirmación");
            dialogoConfirmacion.setContentText("Contenido del cuadro de diálogo de confirmación");
            Optional<ButtonType> opciones = dialogoConfirmacion.showAndWait();
            if (opciones.get() == ButtonType.OK) {
                System.out.println("Pulsado botón OK");
            } else if (opciones.get() == ButtonType.CANCEL) {
                System.out.println("Pulsado botón CANCELAR");
            }
        } else if (fuente.equals(bConfirmPerso)) {

            Alert dialogoConfirmacionPerso = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoConfirmacionPerso.setTitle("Diálogo de confirmación");
            dialogoConfirmacionPerso.setHeaderText("Cabecera del cuadro de diálogo de confirmación personalizado");
            dialogoConfirmacionPerso.setContentText("Contenido del cuadro de diálogo de personalizado");
            ButtonType boton1 = new ButtonType("Botón 1");
            ButtonType boton2 = new ButtonType("Botón 2");
            ButtonType boton3 = new ButtonType("Botón 3");
            ButtonType boton4 = new ButtonType("Botón 4");
            dialogoConfirmacionPerso.getButtonTypes().setAll(boton1, boton2, boton3, boton4);
            Optional<ButtonType> opciones = dialogoConfirmacionPerso.showAndWait();
            if (opciones.get() == boton1) {
                System.out.println("Pulsado botón 1");
            } else if (opciones.get() == boton2) {
                System.out.println("Pulsado botón 2");
            } else if (opciones.get() == boton3) {
                System.out.println("Pulsado botón 3");
            } else if (opciones.get() == boton4) {
                System.out.println("Pulsado botón 4");
            }

        } else if (fuente.equals(bEntrada)) {
            TextInputDialog dialogoTexto = new TextInputDialog("Valor por defecto");
            dialogoTexto.setTitle("Diálogo de text input");
            dialogoTexto.setHeaderText("Cabecera del cuadro de diálogo de text input");
            dialogoTexto.setContentText("Contenido del cuadro de diálogo de text input");
            Optional<String> texto = dialogoTexto.showAndWait();
            if (texto.isPresent()) {
                System.out.println(texto.get());
            }

        } else if (fuente.equals(bEleccion)) {

            List<String> opciones = new ArrayList<>();
            opciones.add("opción 1");
            opciones.add("opción 2");
            opciones.add("opción 3");
            opciones.add("opción 4");

            ChoiceDialog<String> dialogoEleccion = new ChoiceDialog<String>("opción 1", opciones);
            dialogoEleccion.setTitle("Diálogo de elección");
            dialogoEleccion.setHeaderText("Cabecera del cuadro de diálogo de elección");
            dialogoEleccion.setContentText("Contenido del cuadro de diálogo de elección");
            Optional<String> texto = dialogoEleccion.showAndWait();
            if (texto.isPresent()) {
                System.out.println(texto.get());
            }

        } else if (fuente.equals(bPerso)) {
            Dialog dialogoPersonalizado = new Dialog();
            dialogoPersonalizado.setTitle("Diálogo personalizado");
            dialogoPersonalizado.setHeaderText("Cabecera del diálogo personalizado");
            dialogoPersonalizado.setContentText("Contenido del diálogo personalizado");
            dialogoPersonalizado.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("recursos/print.png"))));
            dialogoPersonalizado.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            TextField nombreFichero = new TextField();
            nombreFichero.setPromptText("nombre fichero");
            TextField ruta = new TextField();
            ruta.setPromptText("ruta fichero");
            grid.add(new Label("Nombre"), 0, 0);
            grid.add(nombreFichero, 1, 0);
            grid.add(new Label("Ruta"), 0, 1);
            grid.add(ruta, 1, 1);
            dialogoPersonalizado.getDialogPane().setContent(grid);
            Optional<ButtonType> resultado = dialogoPersonalizado.showAndWait();
            if (resultado.get() == ButtonType.APPLY) {
                System.out.println("Pulsado aceptar");
            } else {
                System.out.println("Pulsado cancelar");
            }
        } else if (fuente.equals(botonFichero)) {
            FileChooser dialogoFichero = new FileChooser();
            dialogoFichero.setTitle("Selecciona un fichero");
            File fAbrir = dialogoFichero.showOpenDialog(null);
            //labelFichero.setText(f.getAbsolutePath());
            File fGuardar = dialogoFichero.showSaveDialog(null);

            if (fGuardar != null) {
                try {
                    FileWriter fileWriter = null;
                    fileWriter = new FileWriter(fGuardar);
                    fileWriter.close();
                } catch (IOException ex) {
                    System.out.println("Excepción capturada");
                }
            }
        } else if (fuente.equals(dialogoColor)) {
            System.out.println(dialogoColor.getValue().toString());

        }else if (fuente.equals(dialogoFecha)) {
            System.out.println(dialogoFecha.getValue().toString());
        }
    }
}
