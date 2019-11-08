package controladora;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Ciclos;
import utils.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraRegistro implements Initializable {

    ObservableList<Ciclos> listaCombo;
    @FXML
    JFXButton botonVolverInicioMaterial, botonRRegistroMaterial;

    @FXML
    JFXTextField campoNombreRegistroMaterial, campoApellidosRegistroMaterial, campoCorreoRegistroMaterial, campoConfCorreoMaterial;

    @FXML
    JFXPasswordField campoContraseniaRegistroMaterial;

    @FXML
    JFXComboBox comboCicloRegistroMaterial;

    @FXML
    JFXCheckBox checkConocimientosRegistroMaterial;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        acciones();
        rellenarLista();
    }

    private void instancias() {
        listaCombo = FXCollections.observableArrayList();
    }


    private void acciones() {
        botonVolverInicioMaterial.setOnAction(new manejoAcciones());
        botonRRegistroMaterial.setOnAction(new manejoAcciones());
    }

    private void rellenarLista() {
        listaCombo.add(new Ciclos("ASIR"));
        listaCombo.add(new Ciclos("DAM"));
        listaCombo.add(new Ciclos("DAW"));

        comboCicloRegistroMaterial.setItems(listaCombo);
        comboCicloRegistroMaterial.setValue(listaCombo.get(1));
    }

    class manejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == botonVolverInicioMaterial) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("../vistas/inicio.fxml"));
                    Scene scene = new Scene(root, 600, 600);
                    Stage stage = (Stage) botonVolverInicioMaterial.getScene().getWindow();
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (event.getSource() == botonRRegistroMaterial &&
                    campoCorreoRegistroMaterial.getText().toString().equals(campoConfCorreoMaterial.getText().toString())
                    //AL MENOS UNA MAYUSCULA, MINUSCULA, CARACTER ESPECIAL, NUMERO Y UNA LONGITUD DE ENTRE 6 Y 15 CARACTERES
                    && campoContraseniaRegistroMaterial.getText().toString().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})")
                    && campoCorreoRegistroMaterial.getText().toString().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")
                    && !campoNombreRegistroMaterial.getText().isEmpty()
                    && !campoContraseniaRegistroMaterial.getText().isEmpty()
                    && !campoCorreoRegistroMaterial.getText().isEmpty()
                    && !campoConfCorreoMaterial.getText().isEmpty()) {

                int aux;
                if (checkConocimientosRegistroMaterial.isSelected()) {
                    aux = 1;
                } else {
                    aux = 0;
                }
                Usuario u = new Usuario(campoNombreRegistroMaterial.getText().toString(),
                        campoApellidosRegistroMaterial.getText().toString(),
                        campoCorreoRegistroMaterial.getText().toString(),
                        utils.Encriptacion.encriptar(campoContraseniaRegistroMaterial.getText().toString()),
                        comboCicloRegistroMaterial.getSelectionModel().getSelectedItem().toString(),
                        aux);
                utils.Sentencias.registrarUsuario(u);
                //    utils.Sentencias.registrarCicloUsuario(u);

                System.out.println("El Registro se ha realizado correctamente");
            } else {
                System.out.println("Ha habido un error durante el registro");
                if (!campoCorreoRegistroMaterial.getText().toString().equals(campoConfCorreoMaterial.getText().toString())) {
                    System.out.println("Ha introducido direcciones de correo distintas. Por favor, introduzca dos iguales");
                }
                if (!campoContraseniaRegistroMaterial.getText().toString().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})")) {
                    if (campoContraseniaRegistroMaterial.getText().isEmpty()) {
                        System.out.println("El campo Contrasenia esta vacio");
                    } else {
                        System.out.println("La contraseña introducida no cumple los requisitos. La contraseña debe tener mayusculas, minusculas, caracteres especiales, " +
                                "numeros. Longitud de entre 6 y 15 caracteres");
                    }
                }
                if (!campoCorreoRegistroMaterial.getText().toString().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")) {
                    if (campoCorreoRegistroMaterial.getText().isEmpty()) {
                        System.out.println("El campo Correo esta vacio");
                    } else {
                        System.out.println("El correo introducido no es valido");
                    }
                }
                if (campoNombreRegistroMaterial.getText().isEmpty()) {
                    System.out.println("El campo Nombre esta vacio");
                }
                if (campoConfCorreoMaterial.getText().isEmpty()) {
                    System.out.println("El campo Confirmar Correo esta vacio");
                }
            }
        }
    }
}


