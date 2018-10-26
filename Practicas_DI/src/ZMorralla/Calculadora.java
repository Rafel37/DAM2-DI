package ZMorralla;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {

    Container contenedor;//esto es para que la ventana tenga un area de juego

    //declaro botones, crear
//    JButton boton1;

    public Calculadora() throws HeadlessException { //constructor en la que va 3 clases siempre
        instancias(); //para las variables logicas, textos botones, etc
        intGUI(); //para hacer la ventana de verdad
        acciones();//donde van los listener
    }
    private void acciones() { //que va a hacer cada elemento, para los listener

    }
    private void intGUI() { //la colocacion en el tablero de juego
        setDefaultCloseOperation(EXIT_ON_CLOSE); //la aplicacion se detiene cuando cierro la ventana
        setTitle("CALCULADORA"); //titulo de la ventana
        setSize(500, 500); //pones un tamaño de serie a la ventana
        setLocationRelativeTo(null);//poner la ventana en el centro
//        this.getContentPane().setBackground(Color.BLUE);//color de fondo azul


//        contenedor.setLayout(new BorderLayout());
//        setVisible(true);//para ver la ventana//siempre
    }
    private void instancias() {//darles valor
        JPanel panel = new JPanel();//creacion de un panel
//        panel.setBackground(Color.green); //ponerle color al panel
        this.getContentPane().add(panel); //agregamos el contenido de la ventana


//        boton1 = new JButton("BOTON 1");//ALGUNOS TENDRE LA OPORTUNIDAD DE METER TEXTO ROLLO, ACEPOTAR, CANCELAR
//        contenedor = getContentPane();//este siempre se instancia AQUI
    }
}