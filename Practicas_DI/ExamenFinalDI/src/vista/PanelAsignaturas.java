package vista;

import javax.swing.*;
import java.awt.*;

public class PanelAsignaturas extends JPanel {

    JLabel asig1,asig2,asig3;
    JSpinner spAsig1,spAsig2,spAsig3;
    SpinnerNumberModel spNM1,spNM2,spNM3;

    JButton bValidar2;
    GridBagConstraints constraints;

    public PanelAsignaturas(){
        instancias();
        configurarLayout();
    }

    private void instancias() {
        asig1 = new JLabel("Asignatura 1");
        asig2 = new JLabel("Asignatura 2");
        asig3 = new JLabel("Asignatura 3");
        spNM1 = new SpinnerNumberModel();
        spNM1.setMinimum(0);
        spNM1.setMaximum(10);
        spNM2 = new SpinnerNumberModel();
        spNM2.setMinimum(0);
        spNM2.setMaximum(10);
        spNM3 = new SpinnerNumberModel();
        spNM3.setMinimum(0);
        spNM3.setMaximum(10);
        spAsig1 = new JSpinner(spNM1);
        spAsig2 = new JSpinner(spNM2);
        spAsig3 = new JSpinner(spNM3);
        bValidar2 = new JButton("Validar");
        constraints = new GridBagConstraints();
    }
    private void  configurarLayout(){
        setLayout(new GridBagLayout());
        Insets insets = new Insets(5,5,5,5);
        configConstraints(0,0,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,asig1);
        configConstraints(0,1,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,asig2);
        configConstraints(0,2,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,asig3);
        configConstraints(1,0,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,spAsig1);
        configConstraints(1,1,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,spAsig2);
        configConstraints(1,2,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,spAsig3);
        configConstraints(0,3,2,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,bValidar2);


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

    public JLabel getAsig1() {
        return asig1;
    }

    public void setAsig1(JLabel asig1) {
        this.asig1 = asig1;
    }

    public JLabel getAsig2() {
        return asig2;
    }

    public void setAsig2(JLabel asig2) {
        this.asig2 = asig2;
    }

    public JLabel getAsig3() {
        return asig3;
    }

    public void setAsig3(JLabel asig3) {
        this.asig3 = asig3;
    }

    public JSpinner getSpAsig1() {
        return spAsig1;
    }

    public void setSpAsig1(JSpinner spAsig1) {
        this.spAsig1 = spAsig1;
    }

    public JSpinner getSpAsig2() {
        return spAsig2;
    }

    public void setSpAsig2(JSpinner spAsig2) {
        this.spAsig2 = spAsig2;
    }

    public JSpinner getSpAsig3() {
        return spAsig3;
    }

    public void setSpAsig3(JSpinner spAsig3) {
        this.spAsig3 = spAsig3;
    }

    public JButton getbValidar2() {
        return bValidar2;
    }

    public void setbValidar2(JButton bValidar2) {
        this.bValidar2 = bValidar2;
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    public SpinnerNumberModel getSpNM1() {
        return spNM1;
    }

    public SpinnerNumberModel getSpNM2() {
        return spNM2;
    }

    public SpinnerNumberModel getSpNM3() {
        return spNM3;
    }
}
