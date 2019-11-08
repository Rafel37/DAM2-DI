package controladora;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


public class ControladoraInicio implements Initializable {

    @FXML
    JFXTextField campoUsuarioMaterial;

    @FXML
    JFXPasswordField campoContraseniaMaterial;

    @FXML
    JFXButton botonRegistrarMaterial, botonIniciarSesionMaterial, botonOlvidoContraseniaMaterial;

    @FXML
    JFXCheckBox checkContraseniaMaterial;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
        leerfichero();
    }

    private void acciones() {
        botonRegistrarMaterial.setOnAction(new manejoAcciones());
        botonIniciarSesionMaterial.setOnAction(new manejoAcciones());
    }


    class manejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == botonRegistrarMaterial) {

                try {
                    Parent root = FXMLLoader.load(getClass().getResource("../vistas/registro.fxml"));
                    Scene scene = new Scene(root, 600, 600);
                    Stage stage = (Stage) botonRegistrarMaterial.getScene().getWindow();
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (event.getSource() == botonIniciarSesionMaterial && checkContraseniaMaterial.isSelected()) {
                escribirFichero();
            }
            if (event.getSource() == botonIniciarSesionMaterial && utils.Sentencias.iniciarSesion(campoUsuarioMaterial.getText().toString(),
                    utils.Encriptacion.encriptar(campoContraseniaMaterial.getText().toString()))) {

                //ACCION DE PASAR A LA SIGUIENTE PANTALLA
                System.out.println("ACCESO PERMITIDO");
            } else {
                //PANTALLA ERRONEA
                System.out.println("ACCESO DENEGADO, Usuario y/o contraseña erroneo");
            }
        }
    }

    private void leerfichero() {
        //LEER FICHERO
        File file = new File("src/recursos/datos.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String usuario, passwd;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            usuario = bufferedReader.readLine();
            passwd = bufferedReader.readLine();
            campoUsuarioMaterial.setText(usuario);
            campoContraseniaMaterial.setText(passwd);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void escribirFichero() {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        File file = new File("src/recursos/datos.txt");
        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(campoUsuarioMaterial.getText().toString());
            bufferedWriter.newLine();
            bufferedWriter.write(campoContraseniaMaterial.getText().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("El archivo no existe");
            }
        }
    }
}