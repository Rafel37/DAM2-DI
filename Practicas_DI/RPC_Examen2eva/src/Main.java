import javafx.application.Application;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application implements Initializable {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/vistas/splash.fxml"));
        primaryStage.setTitle("EXAMEN 2 EVA");
        primaryStage.setScene(new Scene(root, 600, 370));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    MenuItem menuInsertar, menuVer;
    @FXML
    BorderPane panelInsertar, panelVer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        menuInsertar.setOnAction(new ManejoAccion());
        menuVer.setOnAction(new ManejoAccion());
    }

    private class ManejoAccion implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            if (event.getSource() == menuInsertar) {
                System.out.println("menu Insertar");
                Parent root;
                Scene scene;
                Stage stage;
                try{
                    root = FXMLLoader.load(getClass().getResource("../vistas/insertar.fxml"));
                    scene = new Scene(root, 900, 900);
                    stage = (Stage) panelInsertar.getScene().getWindow();
                    stage.setScene(scene);
                } catch (
                        IOException e) {
                    e.printStackTrace();
                }

            }
            else if (event.getSource() == menuVer) {
                System.out.println("menu Ver");
                Parent root;
                Scene scene;
                Stage stage;
                try{
                    root = FXMLLoader.load(getClass().getResource("../vistas/ver.fxml"));
                    scene = new Scene(root, 900, 900);
                    stage = (Stage) panelVer.getScene().getWindow();
                    stage.setScene(scene);
                } catch (
                        IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
