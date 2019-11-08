package Login_Registro;

import javax.swing.*;

public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main m = new Main();    // LLAMAS A LA CLASE QUE QUIERES MOSTRAR
                m.setVisible(true);     //HACER VISIBLE LA VENTANA
            }
        });
    }
}