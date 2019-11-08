package vista;

import utils.Alumno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoPerso extends JDialog {
    JLabel mensaje;
    JButton aceptar;
    private JPanel jPanel;

    public DialogoPerso(Alumno a, String s){
        jPanel = new JPanel();
        setContentPane(jPanel);

        setTitle(s);
        setModal(true);
        aceptar = new JButton("Aceptar");
        mensaje = new JLabel();
        if (a.getMedia()>5){
            mensaje.setText("Enhorabuena "+a.getNombre()+" has aprobado el curso de "+a.getCurso()+" con una media de: "+a.getMedia());
        }else{
            mensaje.setText("La media no es suficiente");
        }
        jPanel.add(mensaje,BorderLayout.CENTER);
        jPanel.add(aceptar,BorderLayout.SOUTH);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        pack();
    }

}
