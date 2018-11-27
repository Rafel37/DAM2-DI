package Formulario;

import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {

    Container contenedor;
    JTabbedPane tabbedPane;
    Registro registro;
    Busqueda busqueda;

    public Vista() throws HeadlessException { //constructor en la que va 3 clases siempre minimo

        instancias();
        initGUI();
    }

    private void initGUI() {

        tabbedPane.addTab("Registro", null, registro, "Registro");
        tabbedPane.addTab("Busqueda", null, busqueda, "Busqueda");
        contenedor.add(tabbedPane);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);
    }

    private void instancias() {

        contenedor = getContentPane();
        tabbedPane = new JTabbedPane();
        registro = new Registro();
        busqueda = new Busqueda();
    }

    public Registro getRegistro() {
        return registro;
    }

    public Busqueda getBusqueda() {
        return busqueda;
    }
}