package controlador;

import utils.Alumno;
import vista.DialogoPerso;
import vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Controlador implements ActionListener, ItemListener {
    
    private Ventana v;
    private static final double DIVIDENDO = 3;
    String nombAux = "";
    String apeAux = "";
    String cursoAux = "";
    Alumno a = null;
    int n1AUX;
    int n2AUX;
    int n3AUX;
    double media;

    public Controlador(Ventana v){
        this.v = v;
        
        acciones();
    }

    private void acciones() {
        v.getPe().getbValidar().addActionListener(this);
        v.getPa().getbValidar2().addActionListener(this);
        v.getPf().getbValidar3().addActionListener(this);
        v.getPf().getChFCTS().addItemListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.getPe().getbValidar()){
            if (v.getPe().getJtNombre().getText().isEmpty() && v.getPe().getJtApellido().getText().isEmpty()){

                JOptionPane.showMessageDialog(null,"Rellene todos los campos","Error",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Todo correcto","Exito",JOptionPane.INFORMATION_MESSAGE);
                nombAux = v.getPe().getJtNombre().getText();
                apeAux = v.getPe().getJtApellido().getText();
                cursoAux = (String) v.getPe().getSplmCurso().getValue();
            }
        }else if (e.getSource() == v.getPa().getbValidar2()){

            n1AUX = (int) v.getPa().getSpNM1().getValue();
            n2AUX = (int) v.getPa().getSpNM2().getValue();
            n3AUX = (int) v.getPa().getSpNM3().getValue();

            media = (n1AUX + n2AUX + n3AUX)/DIVIDENDO;

            if (!nombAux.equals("") && !apeAux.equals("")){
                JOptionPane.showMessageDialog(null,"Media Insertada","Exito",JOptionPane.INFORMATION_MESSAGE);
                 a = new Alumno(nombAux,apeAux,cursoAux,media);
            }else{
                JOptionPane.showMessageDialog(null,"Rellene su nombre y apellidos primer panel","Error",JOptionPane.WARNING_MESSAGE);
            }

        }else if (e.getSource() == v.getPf().getbValidar3()){
                if ( v.getPf().getChFCTS().isSelected() && v.getPf().getChProyecto().isSelected()){
                        if (a!=null){
                            if (a.getMedia()<5){
                                DialogoPerso dp = new DialogoPerso(a,"suspendiste");
                                dp.setVisible(true);
                            }else{
                                DialogoPerso dp = new DialogoPerso(a,"aprobaste");
                                dp.setVisible(true);
                            }

                        }else{
                            JOptionPane.showMessageDialog(null,"Rellene todos los paneles anteriores","Error",JOptionPane.WARNING_MESSAGE);
                        }
                }else{
                    JOptionPane.showMessageDialog(null,"Rellene los checkbox","Error",JOptionPane.WARNING_MESSAGE);
                }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
