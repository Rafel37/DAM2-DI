package fundamentos;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Css implements Initializable {

    @FXML
    BorderPane root;

    Scene scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setScene(Scene scene) {
        this.scene = scene;
        scene.getStylesheets().add(getClass().getResource("recursos/css/stylecss.css").toExternalForm());
    }
}
