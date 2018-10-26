
package Practica_Calculadora;


import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {

    private JButton ac, cambiarSigno, porcentaje, dividir, multiplicar, restar, sumar, x2, coma, igual,
                    b1, b2, b3, b4, b5, b6, b7, b8, b9, bcero,
                    calculadoraNormal, calculadoraCientifica;

    private JTextField resultado;
    GridBagConstraints contenedor = new GridBagConstraints(); //es el tipo de colocacion que hemos elegido


    //Constructos de la ventana
    public Calculadora() throws HeadlessException { //constructor en la que va 3 clases siempre minimo
        instancias(); //para las variables logicas, textos botones, etc
        intGUI(); //para hacer la ventana de verdad
        acciones();//donde van los listener
    }


    private void instancias() {//darles valor

        //INSTANCIAMOS LOS ELEMENTOS Y LES DAMOS VALOR
        ac = new JButton("AC");
        cambiarSigno = new JButton("+/-");
        porcentaje = new JButton("%");
        dividir = new JButton("/");
        multiplicar = new JButton("X");
        restar = new JButton("-");
        sumar = new JButton("+");
        x2 = new JButton("x2");
        coma = new JButton(",");
        igual = new JButton("=");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bcero = new JButton("0");
        calculadoraNormal = new JButton("Normal");
        calculadoraCientifica = new JButton("Cientifica");
        resultado = new JTextField();
    }

    //la colocacion de los elementos en la ventana
    private void intGUI() {
        getContentPane().setLayout(new GridBagLayout()); //poner estos siempre
        configurarPanelCentral(); //metodo
        setTitle("Calculadoras"); //titulo
        setVisible(true); //Hace que la ventana sea visible
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Detiene la aplicacion cuando cierras la ventana
        setSize(300,300); //tamaño del cuadro
        setLocationRelativeTo(null); //colocas el cuadro en el centro
        //setResizable(false); //No se puede mover
    }

    private void configurarPanelCentral() {

        configurarContenedor(0, 0, 2, 1, 1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, calculadoraNormal);
        configurarContenedor(0, 2, 2, 1,1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, calculadoraCientifica );

        configurarContenedor(1,0,4,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, resultado);

        configurarContenedor(2,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, ac);
        configurarContenedor(2,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, cambiarSigno);
        configurarContenedor(2,2,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, porcentaje);
        configurarContenedor(2,3,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, dividir);

        configurarContenedor(3,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, b7);
        configurarContenedor(3,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, b8);
        configurarContenedor(3,2,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, b9);
        configurarContenedor(3,3,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, multiplicar);

        configurarContenedor(4,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, b4);
        configurarContenedor(4,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, b5);
        configurarContenedor(4,2,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, b6);
        configurarContenedor(4,3,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, restar);

        configurarContenedor(5,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, b1);
        configurarContenedor(5,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, b2);
        configurarContenedor(5,2,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, b3);
        configurarContenedor(5,3,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, sumar);

        configurarContenedor(6,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, bcero);
        configurarContenedor(6,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, igual);
        configurarContenedor(6,2,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, coma);
        configurarContenedor(6,3,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, x2);
    }

    private void configurarContenedor ( int fila,int columna, int tx, int ty, int px,
                                        int py, Insets ins, int anchor, int fill, Component c){
        contenedor.gridx=columna; //seleccionas la columna donde se coloca (empiezan por cero)
        contenedor.gridy=fila; //seleccionas la fila donde se coloca (empiezan por cero)
        contenedor.gridwidth=tx; //tamaño de la celda en X (filas) cuantas ocupa
        contenedor.gridheight=ty; //tamaño de la celda en Y (columnas) cuantas ocupa
        contenedor.weightx=px; //Agrandar esa columna
        contenedor.weightx=py; //Agrandar fila
        contenedor.insets=ins; //margen interno
        contenedor.anchor=anchor; //donde anclas el elemento, CENTER = centrar
        contenedor.fill=fill; //direccion del elemento, HORIZONTAL = horizontal
        this.add(c,contenedor);
    }


    //Para los escuchadores y dar funcionalidad a cada elemento
    private void acciones() {


    }


}