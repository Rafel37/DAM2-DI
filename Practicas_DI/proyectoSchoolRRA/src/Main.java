import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String [] args){
        launch(args);//LANZA LA APP
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("vistas/inicio.fxml")); //inicia la aplicacion en esa  ventana
        Parent root = FXMLLoader.load(getClass().getResource("vistas/splash.fxml")); //inicia la aplicacion en esa  ventana
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);//a la ventana le pone una escena
        primaryStage.setTitle("Proyecto School");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }
}
/*
Mouse event hand
File
centrar imagen

 */