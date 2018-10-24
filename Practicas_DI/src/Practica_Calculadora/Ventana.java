package Practica_Calculadora;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    Container contenedor;//esto es para que la ventana tenga un area de botones, edittext, etc darle cuerpo,. are de juego//siempre

    //declaro botones, crear
    JButton boton1;


    public Ventana() throws HeadlessException { //constructor en la que va 3 clases siempre
        instancias(); //para las variables logicas, textos botones, etc
        intGUI(); //para hacer la ventana de verdad
        acciones();//donde van los listener
    }

    private void acciones() { //que va a hacer cada elemento, para los listener

    }

    private void intGUI() { //la colocacion en el tablero de juego
        setTitle("Ejemplo inicial");
        contenedor.setLayout(new BorderLayout());
        setVisible(true);//para ver la ventana//siempre
        setSize(500, 500); //pones un tamaño de serie a la ventana
        setLocationRelativeTo(null);
    }

    private void instancias() {//darles valor
        boton1 = new JButton("BOTON 1");//ALGUNOS TENDRE LA OPORTUNIDAD DE METER TEXTO ROLLO, ACEPOTAR, CANCELAR
        contenedor = getContentPane();//este siempre se instancia AQUI
    }
}
