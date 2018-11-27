
package Formulario;

import Formulario.Vista;

import javax.swing.*;


public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Vista v = new Vista();
                v.setVisible(true);
                Controlador c = new Controlador(v);
            }
        });
    }
}