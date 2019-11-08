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

public class Controladora implements Initializable{

    @FXML
    JFXButton bVentanaNueva, bEscenaNueva;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {
        bVentanaNueva.setOnAction(new ManejoAcciones());
        bEscenaNueva.setOnAction(new ManejoAcciones());
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            if (event.getSource()== bVentanaNueva){
                VentanaNueva v = new VentanaNueva();
                Stage stage = new Stage();
                try {
                    v.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if (event.getSource()== bEscenaNueva){
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../vistas/escenados.fxml"));
                    Scene scene = new Scene(root,600,600);
                    Stage stage = (Stage) bEscenaNueva.getScene().getWindow();
                    stage.setScene(scene);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
