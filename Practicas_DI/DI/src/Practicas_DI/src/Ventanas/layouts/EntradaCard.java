package Ventanas.layouts;

import javax.swing.*;

public class EntradaCard {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana v=new Ventana();
            }
        });
    }
}