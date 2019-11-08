package ListarFicheros.src;

import javax.swing.*;


import javax.swing.SwingUtilities;

public class Entrada {
    public Entrada() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ventana();
            }
        });
    }
}