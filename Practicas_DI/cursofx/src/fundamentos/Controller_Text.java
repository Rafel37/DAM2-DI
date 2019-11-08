package fundamentos;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Text implements Initializable {

    @FXML
    Text text;

    @FXML
    TextField textFieldNormal;

    @FXML
    TextArea textAreaNormal;

    @FXML
    PasswordField textPassNormal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        persoTitutlo();
        persoTextField();
        persoTextArea();

    }

    private void persoTitutlo() {
        // cambia el texto del elemento texto
        text.setText("Elementos de Texto");
        // configura el tipo de letra al texto
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        //P personalizar la letra con un archivo .ttf
        //text.setFont(Font.loadFont("file:resources/fonts/miletra.ttf", 120));
        text.setFill(Color.YELLOWGREEN);
    }

    private void persoTextField() {

        // obtiene el texto puesto en el componente
        textFieldNormal.getText();
        // modifica el hint del componente
        textFieldNormal.setPromptText("Introducir el texto");
        // indica si se puede editar el contenido del componente
        textFieldNormal.setEditable(true);
        // indica el numero de columnas iniciales que tiene el componente
        textFieldNormal.setPrefColumnCount(10);

        textFieldNormal.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!(textFieldNormal.getText().length() < 11)) {

                    textFieldNormal.deletePreviousChar();
                }

                if (textFieldNormal.getText().length() > 11) {
                    textFieldNormal.deleteText(11, textFieldNormal.getText().length());
                }
            }
        });

        //TODO
        textAreaNormal.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.X){
                    textAreaNormal.cut();
                }
                else if (event.getCode() == KeyCode.V){
                    textAreaNormal.paste();
                }
                else if (event.getCode() == KeyCode.C){
                    textAreaNormal.paste();
                }
            }
        });
    }

    private void persoTextArea() {

        // obtiene el texto puesto en el componente
        textAreaNormal.getText();
        // modifica el hint del componente
        textAreaNormal.setPromptText("Introducir el texto");
        // indica si se puede editar el contenido del componente
        textAreaNormal.setEditable(true);
        // permite que las palabras no se separen en dos lineas
        textAreaNormal.setWrapText(true);
        // indica el número de pixels que ocupan las barras de scroll
        textAreaNormal.setScrollLeft(10);
        textAreaNormal.setScrollTop(10);
    }
}
