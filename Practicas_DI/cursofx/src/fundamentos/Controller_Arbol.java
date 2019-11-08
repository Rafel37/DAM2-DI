package fundamentos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.tree.TreeNode;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by borja on 29/7/18.
 */
public class Controller_Arbol implements Initializable {

    @FXML
    private TreeView arbol;

    @FXML
    private Button botonAnadir;

    @FXML
    private Button botonEliminar;

    @FXML
    private Label labelInfo;

    private TreeItem nodoRaiz;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        implementaciones();
        iniciarArbol();
        accionesArbol();
    }

    private void implementaciones() {

        ImageView imagen = new ImageView(new Image(getClass().getResourceAsStream("recursos/open.png")));
        nodoRaiz = new TreeItem("Raiz", imagen);
    }

    private void iniciarArbol() {

        arbol.setRoot(nodoRaiz);
        for (int i = 0; i < 11; i++) {
            ImageView imagen = new ImageView(new Image(getClass().getResourceAsStream("recursos/new.png")));
            TreeItem nodo = new TreeItem("Nodo " + i, imagen);
            // añade elementos al nodo correspondiente
            nodoRaiz.getChildren().add(nodo);
            nodo.getChildren().add(new TreeItem("Ejemplo"));
        }
    }

    public void métodosArbol(){
        // modifica la edición del árbol
        arbol.setEditable(true);
        // hace visible el nodo root
        arbol.setShowRoot(true);
        // añade un tooltip al árbol
        arbol.setTooltip(new Tooltip("Ejemplo de árbol"));
        // abre un nodo correspondiente
        nodoRaiz.setExpanded(true);
        // indica si el nodo es hoja
        nodoRaiz.isLeaf();
        // obtiene una lista con todos los hijos del nodo
        nodoRaiz.getChildren();
        // obtiene el valor asociado del nodo correspondiente
        nodoRaiz.getValue();
    }

    private void accionesArbol() {
        botonAnadir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TreeItem nodoSeleccionado = (TreeItem) arbol.getSelectionModel().getSelectedItem();
                nodoSeleccionado.getChildren().add(new TreeItem("Nodo añadido"));
            }
        });

        botonEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println(arbol.getSelectionModel().getSelectedIndex());
                TreeItem nodoSeleccionado = (TreeItem) arbol.getSelectionModel().getSelectedItem();
                if (nodoSeleccionado.getChildren().size() == 0 && nodoSeleccionado != arbol.getRoot()) {
                    TreeItem nodoPadre = (TreeItem)nodoSeleccionado.getParent();
                    nodoPadre.getChildren().remove(nodoSeleccionado);
                }
                else {
                    System.out.println("El nodo no se puede borrar");
                }
            }
        });
        arbol.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                labelInfo.setText(((TreeItem)newValue).getValue().toString());
            }
        });
    }
}
