package controladoras;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ventanas.VentanaNueva;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    JFXButton cargarVentana,cargarEscena;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {
        cargarVentana.setOnAction(new ManejoAcciones());
        cargarEscena.setOnAction(new ManejoAcciones());
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            if (event.getSource()==cargarVentana){
                VentanaNueva v = new VentanaNueva();
                Stage stage = new Stage();
                try {
                    v.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if (event.getSource()==cargarEscena){
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../vistas/escenados.fxml"));
                    Scene scene = new Scene(root,600,600);
                    Stage stage = (Stage) cargarEscena.getScene().getWindow();
                    stage.setScene(scene);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
