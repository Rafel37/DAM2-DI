package controladora;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import utils.Equipo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class ContoladoraMain implements Initializable {

    @FXML
    ListView lista;
    @FXML
    TextArea descripcion;

    @FXML
    ImageView imagen;

    @FXML
    MenuItem menuLaLiga, menuAdelante, menuSin;

    ObservableList<Equipo> listaEquipos;
    String pulsacion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        menuLaLiga.setOnAction(new ContoladoraMain.ManejoAccion());
        menuAdelante.setOnAction(new ContoladoraMain.ManejoAccion());
        menuSin.setOnAction(new ContoladoraMain.ManejoAccion());

        instancias();
        try {
            rellenarInicio();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Equipo equipo = (Equipo) newValue;
                URL url = null;
                try {
                    url = new URL(equipo.getUrl());
                    BufferedImage imageURL = ImageIO.read(url);
                    Image image = SwingFXUtils.toFXImage(imageURL,null);
                    imagen.setImage(image);
                    descripcion.setText(equipo.getDescripcion());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void instancias() {
        listaEquipos = FXCollections.observableArrayList();
        lista.setItems(listaEquipos);
    }

    public void realizarPeticion(String s) throws IOException, JSONException {

        String url = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain";
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
        JSONArray array = myResponse.getJSONArray("teams");
        for (int i = 0; i<array.length();i++){
            JSONObject object = (JSONObject) array.get(i);

            // LA LIGA
            if ((object.get("strLeague").equals(pulsacion))){
                String nombre1 = (String) object.get("strTeam");
                String estadio1 = (String) object.get("strStadium");
                String description1 = (String) object.get("strDescriptionES").toString();
                String imagen1 = (String) object.get("strTeamBadge").toString();
                String liga1 = (String) object.get("strLeague").toString();
                Equipo e1 = new Equipo(nombre1,estadio1,description1,imagen1, liga1);
                listaEquipos.add(e1);
            }

            // ADELANTE
            else if ((object.get("strLeague").equals(pulsacion))){
                String nombre2 = (String) object.get("strTeam");
                String estadio2 = (String) object.get("strStadium");
                String description2 = (String) object.get("strDescriptionES").toString();
                String imagen2 = (String) object.get("strTeamBadge").toString();
                String liga2 = (String) object.get("strLeague").toString();
                Equipo e2 = new Equipo(nombre2,estadio2,description2,imagen2, liga2);
                listaEquipos.add(e2);
            }

            // SIN LIGA
            else if ((object.get("strLeague").equals(pulsacion)) ){
                String nombre3 = (String) object.get("strTeam");
                String estadio3 = (String) object.get("strStadium");
                String description3 = (String) object.get("strDescriptionES").toString();
                String imagen3 = (String) object.get("strTeamBadge").toString();
                String liga3 = (String) object.get("strLeague").toString();
                Equipo e3 = new Equipo(nombre3,estadio3,description3,imagen3, liga3);
                listaEquipos.add(e3);
            }
//            System.out.println((String) object.get("strLeague"));
        }
    }


    class ManejoAccion implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == menuLaLiga){
                System.out.println("La Liga");
                listaEquipos.clear();
                pulsacion = "Spanish La Liga";

                try {
                    listaEquipos.clear();
                    realizarPeticion(pulsacion);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if (event.getSource() == menuAdelante){
                System.out.println("Adelante");
                listaEquipos.clear();
                pulsacion = "Spanish Adelante";
                try {
                    realizarPeticion(pulsacion);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if (event.getSource() == menuSin){
                System.out.println("Sin liga :(");
                listaEquipos.clear();
                pulsacion = "_No League";
                try {
                    realizarPeticion(pulsacion);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void rellenarInicio() throws JSONException, IOException {
        String url = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain";
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
        JSONArray array = myResponse.getJSONArray("teams");
        for (int i = 0; i<array.length();i++){
            JSONObject object = (JSONObject) array.get(i);
            String nombre = (String) object.get("strTeam");
            String estadio = (String) object.get("strStadium");
            String description = object.get("strDescriptionES").toString();
            String imagen = object.get("strTeamBadge").toString();
            String liga = object.get("strLeague").toString();
            Equipo e = new Equipo(nombre,estadio,description,imagen, liga);
            listaEquipos.add(e);

        }
    }
}
