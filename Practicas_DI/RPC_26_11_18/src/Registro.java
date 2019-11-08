import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame implements ActionListener {

    private JLabel nombreLabel, apellidoLabel, cicloLabel, notaLabel, fctsLabel;
    private JTextField nombreField, apellidoField, cicloField, notaField;
    private JCheckBox fctsCheck;

    private JButton agregar, limpiar;

    GridBagConstraints contenedor = new GridBagConstraints();

    public Registro() throws HeadlessException {

        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {

        this.agregar.addActionListener(this);
        this.limpiar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.limpiar) {
            nombreField.setText(null);
            apellidoField.setText(null);
            cicloField.setText(null);
            notaField.setText(null);
            fctsCheck.setSelected(false);
        }
        if (e.getSource() == this.agregar) {

            nombreField.setText(null);
            apellidoField.setText(null);
            cicloField.setText(null);
            notaField.setText(null);
            fctsCheck.setSelected(false);
        }
    }

    private void instancias() {

        nombreLabel = new JLabel("Nombre: ");
        apellidoLabel = new JLabel("Apellido: ");
        cicloLabel = new JLabel("Ciclo: ");
        notaLabel = new JLabel("Nota Media: ");
        fctsLabel = new JLabel("FCTS: ");

        nombreField = new JTextField();
        apellidoField = new JTextField();
        cicloField = new JTextField();
        notaField = new JTextField();

        fctsCheck = new JCheckBox();

        agregar = new JButton("AGREGAR");
        limpiar = new JButton("LIMPIAR");
    }

    private void initGUI() {

        getContentPane().setLayout(new GridBagLayout());
        configurarPanelCentral();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private void configurarPanelCentral() {
        configurarContenedor(0,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, nombreLabel);
        configurarContenedor(0,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, nombreField);

        configurarContenedor(1,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, apellidoLabel);
        configurarContenedor(1,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, apellidoField);

        configurarContenedor(2,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, cicloLabel);
        configurarContenedor(2,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, cicloField);

        configurarContenedor(3,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, notaLabel);
        configurarContenedor(3,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, notaField);

        configurarContenedor(4,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, fctsLabel);
        configurarContenedor(4,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, fctsCheck);

        configurarContenedor(5,0,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, agregar);
        configurarContenedor(5,1,1,1,1,1, new Insets(5,5,5,5), GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, limpiar);

    }

    private void configurarContenedor ( int fila,int columna, int tx, int ty, int px,
                                        int py, Insets ins, int anchor, int fill, Component c) {
        contenedor.gridx = columna;
        contenedor.gridy = fila;
        contenedor.gridwidth = tx;
        contenedor.gridheight = ty;
        contenedor.weightx = px;
        contenedor.weightx = py;
        contenedor.insets = ins;
        contenedor.anchor = anchor;
        contenedor.fill = fill;
        this.add(c,contenedor);
    }
}
