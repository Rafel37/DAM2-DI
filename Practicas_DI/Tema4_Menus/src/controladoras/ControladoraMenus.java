package controladoras;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraMenus implements Initializable {


    @FXML
    MenuItem menuAbrir, menuCerrar;

    @FXML
    RadioMenuItem menuRadio1, menuRadio2;

    @FXML
    CheckMenuItem menuCheck1, menuCheck2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuAbrir.setOnAction(new ManejoAccion());
        menuCerrar.setOnAction(new ManejoAccion());
        menuRadio1.setOnAction(new ManejoAccion());
        menuRadio2.setOnAction(new ManejoAccion());
        menuCheck1.setOnAction(new ManejoAccion());
        menuCheck2.setOnAction(new ManejoAccion());

        menuCheck1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("Seleccionado check1 " + newValue);
                if (newValue == true) {
                    menuCheck2.setSelected(false);
                }
            }
        });
        menuCheck2.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("Seleccionado check2 " + newValue);
                if (newValue == true) {
                    menuCheck1.setSelected(false);
                }
            }
        });
        menuRadio1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("Seleccionado radio1 " + newValue);
                if (newValue == true) {
                    menuRadio2.setSelected(false);
                }
            }
        });
        menuRadio2.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("Seleccionado radio2 " + newValue);
                if (newValue == true) {
                    menuRadio1.setSelected(false);
                }
            }
        });
    }

    class ManejoAccion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == menuAbrir){
                System.out.println("pulsado abrir");
            }
            else if (event.getSource() == menuCerrar){
                System.out.println("pulsado cerrar");
                Platform.exit();
            }
            else if (event.getSource() == menuRadio1){
                System.out.println("pulsado radio1");
            }
            else if (event.getSource() == menuRadio2){
                System.out.println("pulsado radio2");
            }
            else if (event.getSource() == menuCheck1){
                if (menuCheck1.isSelected()){
                    System.out.println("seleccionado check1");
                }
                else {
                    System.out.println("deseleccionado check1");
                }
            }
            else if (event.getSource() == menuCheck2){
                System.out.println("pulsado check2");
            }
        }
    }
}
