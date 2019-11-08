package fundamentos;

import com.sun.org.apache.xml.internal.security.Init;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by borja on 6/8/18.
 */
public class Controller_ArbolTabla implements Initializable{

    @FXML
    TreeTableView arboltabla;

    @FXML
    TreeTableColumn columna;

    TreeItem root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root = new TreeItem<>("Raiz");
        arboltabla.setRoot(root);
        arboltabla.setShowRoot(true);
    }
}
