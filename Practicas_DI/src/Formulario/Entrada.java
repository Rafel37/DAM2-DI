
package Formulario;

import javax.swing.*;

public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Formulario f = new Formulario();
                Modelo m = new Modelo();
                f.setVisible(true); //HACER VISIBLE LA VENTANA
            }
        });
    }
}