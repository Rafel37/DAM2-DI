package vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelEntrada extends JPanel {

    JLabel titulo,nombre,apellido,curso;
    JTextField jtNombre,jtApellido;
    JSpinner spCurso;
    SpinnerListModel splmCurso;
    JButton bValidar;
    GridBagConstraints constraints;
    ArrayList aa;

    public PanelEntrada() {
        instancias();
        configurarLayout();
    }

    private void instancias() {
        aa = new ArrayList();
        aa.add("DAM");
        aa.add("GI");
        aa.add("ASIR");

        titulo = new JLabel("Examen DI");
        nombre = new JLabel("Nombre");
        apellido = new JLabel("Apellido");
        curso = new JLabel("Curso");
        bValidar = new JButton("Validar");
        splmCurso = new SpinnerListModel();
        splmCurso.setList(aa);
        jtNombre = new JTextField();
        jtApellido = new JTextField();
        spCurso = new JSpinner(splmCurso);
        constraints = new GridBagConstraints();
    }



     private void  configurarLayout(){
        setLayout(new GridBagLayout());
        Insets insets = new Insets(5,5,5,5);
        configConstraints(1,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,titulo);
        configConstraints(1,1,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,jtNombre);
        configConstraints(1,2,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,jtApellido);
        configConstraints(1,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,spCurso);
        configConstraints(0,1,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,nombre);
        configConstraints(0,2,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,apellido);
        configConstraints(0,3,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,curso);
        configConstraints(0,4,4,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,bValidar);

    }

    private void configConstraints(int x, int y, int tx, int ty, double wx, double wy, int anchor, int fill, Insets i, Component c) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = tx;
        constraints.gridheight = ty;
        constraints.weightx = wx;
        constraints.weighty = wy;
        constraints.anchor = anchor;
        constraints.insets = i;
        constraints.fill = fill;
        this.add(c,constraints);
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public JLabel getNombre() {
        return nombre;
    }

    public JLabel getApellido() {
        return apellido;
    }

    public JLabel getCurso() {
        return curso;
    }

    public JTextField getJtNombre() {
        return jtNombre;
    }

    public JTextField getJtApellido() {
        return jtApellido;
    }

    public JSpinner getSpCurso() {
        return spCurso;
    }

    public JButton getbValidar() {
        return bValidar;
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }

    public SpinnerListModel getSplmCurso() {
        return splmCurso;
    }

}
