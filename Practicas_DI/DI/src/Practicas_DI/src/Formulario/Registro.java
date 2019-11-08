package Formulario;


import javax.swing.*;
import java.awt.*;

public class Registro extends JPanel {

    private JLabel nombreLabel, tratamientoLabel, apellidoLabel, telefonoLabel, direccionLabel, numeroLabel, puertaLabel, ciudadLabel, paisLabel, pagoLabel;
    private JTextField nombreField, apellido1Field, telefonoField, direccionField, numeroField, puertaField, ciudadField, paisField, finalField;

    SpinnerNumberModel modeloTratamiento, modeloPago;
    JSpinner tratamientoSpinner, pagoSpinner;

    private JButton aceptar, limpiar;

    GridBagConstraints contenedor = new GridBagConstraints(); //es el tipo de colocacion que hemos elegido


    //Constructos de la ventana
    public Registro() throws HeadlessException {

        instancias();
        intGUI();
    }


    private void instancias() {//darles valor

        //INSTANCIAMOS LOS ELEMENTOS Y LES DAMOS VALOR

        nombreLabel = new JLabel("Nombre:");
        tratamientoLabel = new JLabel("Tratamiento:");
        apellidoLabel = new JLabel("Apellido:");
        telefonoLabel = new JLabel("Telefono:");
        direccionLabel = new JLabel("Dirección:");
        numeroLabel = new JLabel("Numero:");
        puertaLabel = new JLabel("Puerta:");
        ciudadLabel = new JLabel("Ciudad:");
        paisLabel = new JLabel("Pais:");
        pagoLabel = new JLabel("Forma de pago:");

        modeloTratamiento = new SpinnerNumberModel();
        modeloPago = new SpinnerNumberModel();
        tratamientoSpinner = new JSpinner(modeloTratamiento);
        pagoSpinner = new JSpinner(modeloPago);

        nombreField = new JTextField();
        apellido1Field = new JTextField();
        telefonoField = new JTextField();
        direccionField = new JTextField();
        numeroField = new JTextField();
        puertaField = new JTextField();
        ciudadField = new JTextField();
        paisField = new JTextField();
        finalField = new JTextField();

        aceptar = new JButton("Aceptar");
        limpiar = new JButton("Limpiar");
    }

    //la colocacion de los elementos en la ventana
    private void intGUI() {

        setLayout(new GridBagLayout()); //poner estos siempre
        configurarPanelCentral(); //metodo
    }

    private void configurarPanelCentral() {

        configurarContenedor(0, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, nombreLabel);
        configurarContenedor(0, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, nombreField);
        configurarContenedor(0, 2, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, tratamientoLabel);
        configurarContenedor(0, 3, 2, 1,1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, tratamientoSpinner);

        configurarContenedor(1, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, apellidoLabel);
        configurarContenedor(1, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, apellido1Field);
        configurarContenedor(1, 2, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, telefonoLabel);
        configurarContenedor(1, 3, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, telefonoField);

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
        configurarContenedor(10, 2, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, limpiar);
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

    public JTextField getNombreField() {
        return nombreField;
    }

    public JTextField getApellido1Field() {
        return apellido1Field;
    }

    public JTextField getTelefonoField() {
        return telefonoField;
    }

    public JTextField getDireccionField() {
        return direccionField;
    }

    public JTextField getNumeroField() {
        return numeroField;
    }

    public JTextField getPuertaField() {
        return puertaField;
    }

    public JTextField getCiudadField() {
        return ciudadField;
    }

    public JTextField getPaisField() {
        return paisField;
    }

    public JTextField getFinalField() {
        return finalField;
    }

    public JLabel getNombreLabel() {
        return nombreLabel;
    }

    public SpinnerNumberModel getModeloTratamiento() {
        return modeloTratamiento;
    }

    public SpinnerNumberModel getModeloPago() {
        return modeloPago;
    }

    public JSpinner getTratamientoSpinner() {
        return tratamientoSpinner;
    }

    public JSpinner getPagoSpinner() {
        return pagoSpinner;
    }

    public JButton getAceptar() {
        return aceptar;
    }

    public JButton getLimpiar() {
        return limpiar;
    }
}