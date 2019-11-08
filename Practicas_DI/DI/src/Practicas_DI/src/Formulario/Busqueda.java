package Formulario;

import javax.swing.*;
import java.awt.*;

public class Busqueda extends JPanel {

    private JLabel nombreLabel,  telefonoLabel, ciudadLabel, paisLabel, resultadoLabel;
    private JTextField nombreField, telefonoField, ciudadField, resultadoField;

    DefaultListModel ciudadModel, personaModel;
    private JList ciudadList, personaList;

    DefaultComboBoxModel modeloCombo;
    JComboBox paisCombo;

    private JButton buscar;

    GridBagConstraints contenedor = new GridBagConstraints(); //es el tipo de colocacion que hemos elegido

    //Constructos de la ventana
    public Busqueda() throws HeadlessException { //constructor en la que va 3 clases siempre minimo
        instancias();
        intGUI();
    }


    private void instancias() {//darles valor

        //INSTANCIAMOS LOS ELEMENTOS Y LES DAMOS VALOR

        nombreLabel = new JLabel("Nombre:");
        telefonoLabel = new JLabel("Telefono:");
        paisLabel = new JLabel("Pais:");
        ciudadLabel = new JLabel("Ciudad:");
        resultadoLabel = new JLabel("Resultado:");
        nombreField = new JTextField();
        telefonoField = new JTextField();

        ciudadModel = new DefaultListModel();
        personaModel = new DefaultListModel();
        ciudadList = new JList(ciudadModel);
        personaList = new JList(personaModel);

        modeloCombo = new DefaultComboBoxModel();
        paisCombo = new JComboBox(modeloCombo);

        buscar = new JButton("Buscar");
    }

    //la colocacion de los elementos en la ventana
    private void intGUI() {
        setLayout(new GridBagLayout()); //poner estos siempre
        configurarPanelCentral(); //metodo
    }

    private void configurarPanelCentral() {

        configurarContenedor(0, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, nombreLabel);
        configurarContenedor(0, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, nombreField);

        configurarContenedor(1, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, telefonoLabel);
        configurarContenedor(1, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, telefonoField);


        configurarContenedor(2, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, paisLabel);
        configurarContenedor(2, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, paisCombo);

        configurarContenedor(3, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, ciudadLabel);
        configurarContenedor(3, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new JScrollPane(ciudadList));

        configurarContenedor(5, 0, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, resultadoLabel);
        configurarContenedor(5, 1, 1, 1, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new JScrollPane(personaList));

        configurarContenedor(7, 0, 2, 2, 1, 1, new Insets(5,5,5,5), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, buscar);


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

    public JTextField getTelefonoField() {
        return telefonoField;
    }

    public DefaultComboBoxModel getModeloCombo() {
        return modeloCombo;
    }

    public JComboBox getPaisCombo() {
        return paisCombo;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public DefaultListModel getCiudadModel() {
        return ciudadModel;
    }

    public DefaultListModel getPersonaModel() {
        return personaModel;
    }

    public JList getCiudadList() {
        return ciudadList;
    }

    public JList getPersonaList() {
        return personaList;
    }
}