package controladoras;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import utils.Pelis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraMain implements Initializable {

    @FXML
    MenuItem importar, exportar;

    @FXML
    ImageView imagen;
    @FXML
    TextArea text;

    @FXML
    TableView<Pelis> pelis;
    @FXML
    TableColumn<String,Pelis> titulo, estreno, valoracion;

    ObservableList<Pelis> listPelis;
    String pulsacion;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instancias();
        configurarTabla();
        acciones();
    }

    private void acciones() {
        importar.setOnAction(new ControladoraMain.ManejoAccion());
        exportar.setOnAction(new ControladoraMain.ManejoAccion());
    }

    private void configurarTabla() {
        titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        estreno.setCellValueFactory(new PropertyValueFactory<>("estreno"));
        valoracion.setCellValueFactory(new PropertyValueFactory<>("valoracion"));
        pelis.setItems(listPelis);
    }

    private void instancias() {
        listPelis = FXCollections.observableArrayList();
    }

    private void realizarPeticion() throws IOException, JSONException {

        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println(myResponse.toString());
        JSONArray array = myResponse.getJSONArray("results");
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = (JSONObject) array.get(i);
            String nombre = object.get("original_title").toString();
            String fecha = object.get("release_date").toString();
            double val = Double.parseDouble(object.get("vote_average").toString());
            Pelis p = new Pelis(nombre, fecha, val);
            listPelis.add(p);
            System.out.println(listPelis);
        }
    }


    public class ManejoAccion implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == importar) {
                System.out.println("importar");
                listPelis.clear();
                try {
                    realizarPeticion();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if (event.getSource() == exportar) {
                System.out.println("exportar");
            }
        }
    }
}
