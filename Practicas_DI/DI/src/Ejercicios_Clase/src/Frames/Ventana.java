package Frames;


import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    JLabel etiqueta0, etiqueta1;
    JButton boton0 , boton1, boton2, boton3, boton4 , boton5, boton6, boton7, boton8 , boton9, boton10, boton11;
    Container contenedor;
    JPanel contenedorEste, contenedorOeste, contenedorNorte;

    public Ventana() throws HeadlessException {
        instancias();
        initGUI();
    }

    private void instancias() {
        etiqueta0 = new JLabel("Centro");
        etiqueta1 = new JLabel("Pie de de la ventana");
        boton0 = new JButton("Boton  0");
        boton1 = new JButton("Boton  1");
        boton2 = new JButton("Boton  2");
        boton3 = new JButton("Boton  3");
        boton4 = new JButton("Boton  4");
        boton5 = new JButton("Boton  5");
        boton6 = new JButton("Boton  6");
        boton7 = new JButton("Boton  7");
        boton8 = new JButton("Boton  8");
        boton9 = new JButton("Boton  9");
        boton10 = new JButton("Boton  10");
        boton11 = new JButton("Boton  11");
        contenedor = getContentPane();
        contenedorEste = new JPanel();
        contenedorOeste = new JPanel();
        contenedorNorte = new JPanel();
    }

    private void initGUI() {
        configuracionesPanelCentral();
        setTitle("Ejemplo inicial");
        setVisible(true);
        setSize(300,300);
        //setResizable(false);
        //setLocationRelativeTo(null);
        //setExtendedState(MAXIMIZED_BOTH);
        //pack();
        //setLocation(50,50);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void configuracionesPanelCentral() {

        //contenedor.setLayout(new GridLayout(1,2,50,50));
        //contenedor.setLayout(new FlowLayout());

        contenedor.setLayout(new BorderLayout());

        contenedor.add(etiqueta0, BorderLayout.CENTER);
        contenedor.add(etiqueta1, BorderLayout.SOUTH);

        contenedor.add(  contenedorNorte, BorderLayout.NORTH);
        contenedor.add( confirgurarEste(), BorderLayout.EAST);
        contenedor.add(confirgurarOeste(), BorderLayout.WEST);



    }

    protected JPanel confirgurarNorte(){
        contenedorOeste.setLayout(new FlowLayout());
        contenedorOeste.add(boton4);
        contenedorOeste.add(boton5);
        contenedorOeste.add(boton6);
        contenedorOeste.add(boton7);
        return contenedorNorte;

    }
    protected JPanel confirgurarOeste(){
        contenedorEste.setLayout(new FlowLayout());
        contenedorEste.add(boton0);
        contenedorEste.add(boton1);
        contenedorEste.add(boton2);
        contenedorEste.add(boton3);
        return contenedorOeste;

    }
    protected JPanel confirgurarEste(){
        contenedorNorte.setLayout(new FlowLayout());
        contenedorNorte.add(boton8);
        contenedorNorte.add(boton9);
        contenedorNorte.add(boton10);
        contenedorNorte.add(boton11);
        return contenedorEste;
    }

}