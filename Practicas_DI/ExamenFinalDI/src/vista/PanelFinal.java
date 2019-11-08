package vista;

import javax.swing.*;
import java.awt.*;

public class PanelFinal extends JPanel {
    JLabel p1,p2;
    JCheckBox chFCTS,chProyecto;
    JButton bValidar3;
    GridBagConstraints constraints;

    public PanelFinal(){
        instancias();
        configurarLayout();

    }

    private void instancias() {
        p1 = new JLabel("¿Has Aprobado las FCTS?");
        p2 = new JLabel("¿Has Aprobado el Proyecto?");
        chFCTS = new JCheckBox();
        chProyecto = new JCheckBox();
        bValidar3 = new JButton("Validar");
        constraints = new GridBagConstraints();
    }

    private void  configurarLayout(){
        setLayout(new GridBagLayout());
        Insets insets = new Insets(5,5,5,5);
        configConstraints(0,0,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,p1);
        configConstraints(0,1,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,p2);
        configConstraints(1,0,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,chFCTS);
        configConstraints(1,1,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,chProyecto);
        configConstraints(0,2,2,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,insets,bValidar3);


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

    public JLabel getP1() {
        return p1;
    }

    public void setP1(JLabel p1) {
        this.p1 = p1;
    }

    public JLabel getP2() {
        return p2;
    }

    public void setP2(JLabel p2) {
        this.p2 = p2;
    }

    public JCheckBox getChFCTS() {
        return chFCTS;
    }

    public void setChFCTS(JCheckBox chFCTS) {
        this.chFCTS = chFCTS;
    }

    public JCheckBox getChProyecto() {
        return chProyecto;
    }

    public void setChProyecto(JCheckBox chProyecto) {
        this.chProyecto = chProyecto;
    }

    public JButton getbValidar3() {
        return bValidar3;
    }

    public void setbValidar3(JButton bValidar3) {
        this.bValidar3 = bValidar3;
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

}
