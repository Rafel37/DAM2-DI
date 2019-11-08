package fundamentos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Locale.setDefault(Locale.ENGLISH);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista/componentes_css.fxml"));
        Parent root = loader.load();
        Controller_Css controller = (Controller_Css)loader.getController();
        Scene scene = new Scene(root,600,400);
        controller.setScene(scene);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
