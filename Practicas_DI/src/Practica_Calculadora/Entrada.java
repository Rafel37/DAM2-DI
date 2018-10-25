package Practica_Calculadora;

import javax.swing.*;

public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Calculadora c = new Calculadora();
                c.setVisible(true); //HACER VISIBLE LA VENTANA
            }
        });
    }
}
