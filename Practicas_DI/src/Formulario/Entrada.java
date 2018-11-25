
package Practicas_DI.src.Formulario;

import javax.swing.*;

public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Formulario c = new Formulario();
                c.setVisible(true); //HACER VISIBLE LA VENTANA
            }
        });
    }
}