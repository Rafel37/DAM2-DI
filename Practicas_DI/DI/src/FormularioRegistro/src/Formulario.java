
package FormularioRegistro.src;


import javax.swing.*;
import java.awt.*;

public class Formulario extends JFrame {

    private JLabel nombreLabel, tratamientoLabel, apellidoLabel, direccionLabel, numeroLabel, puertaLabel, ciudadLabel, paisLabel, pagoLabel;
    private JTextField nombreField, apellido1Field, apellido2Field, direccionField, numeroField, puertaField, ciudadField, paisField, finalField;

    JSpinner tratamientoSpinner, pagoSpinner;

    private JButton aceptar, cancelar;

    GridBagConstraints contenedor = new GridBagConstraints(); //es el tipo de colocacion que hemos elegido


    //Constructos de la ventana
    public Formulario() throws HeadlessException { //constructor en la que va 3 clases siempre minimo
        instancias(); //para las variables logicas, textos botones, etc
        intGUI(); //para hacer la ventana de verdad
        acciones();//donde van los listener
    }


    private void instancias() {//darles valor

        //INSTANCIAMOS LOS ELEMENTOS Y LES DAMOS VALOR

        nombreLabel = new JLabel("Nombre:");
        tratamientoLabel = new JLabel("Tratamiento:");
        apellidoLabel = new JLabel("Apellido:");
        direccionLabel = new JLabel("Dirección:");
        numeroLabel = new JLabel("Numeros:");
        puertaLabel = new JLabel("Puerta:");
        ciudadLabel = new JLabel("Ciudad:");
        paisLabel = new JLabel("Pais:");
        pagoLabel = new JLabel("Forma de pago:");

        tratamientoSpinner = new JSpinner();
        pagoSpinner = new JSpinner();

        nombreField = new JTextField();
        apellido1Field = new JTextField();
        apellido2Field = new JTextField();
        direccionField = new JTextField();
        numeroField = new JTextField();
        puertaField = new JTextField();
        ciudadField = new JTextField();
        paisField = new JTextField();
        finalField = new JTextField();

        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");
    }

    //la colocacion de los elementos en la ventana
    private void intGUI() {
        getContentPane().setLayout(new GridBagLayout()); //poner estos siempre
        configurarPanelCentral(); //metodo
        setTitle("Formulario"); //titulo
        setVisible(true); //Hace que la ventana sea visible
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Detiene la aplicacion cuando cierras la ventana
        setSize(500,500); //tamaño del cuadro
        setLocationRelativeTo(null); //colocas el cuadro en el centro
        //setResizable(false); //No se puede mover
    }

    private void configurarPanelCentral() {

        configurarContenedor(0, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, nombreLabel);
        configurarContenedor(0, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, nombreField);
        configurarContenedor(0, 2, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, tratamientoLabel);
        configurarContenedor(0, 3, 2, 1,1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, tratamientoSpinner);

        configurarContenedor(1, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, apellidoLabel);
        configurarContenedor(1, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, apellido1Field);
        configurarContenedor(1, 2, 2, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, apellido2Field);

        configurarContenedor(2, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, numeroLabel);
        configurarContenedor(2, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, numeroField);
        configurarContenedor(2, 2, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, puertaLabel);
        configurarContenedor(2, 3, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, puertaField);

        configurarContenedor(3, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, ciudadLabel);
        configurarContenedor(3, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, ciudadField);
        configurarContenedor(3, 2, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, paisLabel);
        configurarContenedor(3, 3, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, paisField);

        configurarContenedor(4, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, pagoLabel);
        configurarContenedor(4, 1, 1, 1,1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, pagoSpinner);

        configurarContenedor(5, 0, 4, 4, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, finalField);

        configurarContenedor(10, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, aceptar);
        configurarContenedor(10, 2, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, cancelar);


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