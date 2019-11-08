package Practicas_DI.src.Ventanas;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    JLabel etiqueta;
    JButton boton0,boton1,boton2,boton3,boton4;
    Container contenedor;

    public Ventana() throws HeadlessException {
        instancias();
        initGUI();
    }
    public void instancias() {
        etiqueta = new JLabel("etiqueta de ejemplo");
        boton0 = new JButton("Ejemplo de boton0");
        boton1 = new JButton("Ejemplo de boton1");
        boton2 = new JButton("Ejemplo de boton2");
        boton3 = new JButton("Ejemplo de boton3");
        boton4 = new JButton("Ejemplo de boton4");
        contenedor=getContentPane();

    }
    private void initGUI() {
        setTitle("Ejemplo inicial");
        configuracionesPanelCentral();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 300);
        //setResizable(false);
        setLocationRelativeTo(null);
        //setLocation(50, 50);
        pack();
    }
    private void configuracionesPanelCentral(){
        //contenedor.setLayout(new GridLayout(1,2,50,50));
        //contenedor.setLayout(new FlowLayout());
        contenedor.setLayout(new BorderLayout());
        contenedor.add(boton0,BorderLayout.SOUTH);
        contenedor.add(boton1,BorderLayout.NORTH);
        contenedor.add(boton2,BorderLayout.WEST);
        contenedor.add(boton3,BorderLayout.EAST);
        contenedor.add(boton4,BorderLayout.CENTER);
    }

}