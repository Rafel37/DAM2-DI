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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControldoraScena implements Initializable,EventHandler<ActionEvent> {
    @FXML
    JFXButton irAtras;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {
        irAtras.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource()==irAtras){
            Parent root ;
            try {
                root = FXMLLoader.load(getClass().getResource("../vistas/inicio.fxml"));
                Scene scene = new Scene(root, 600, 600);
                Stage stage = (Stage) irAtras.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
