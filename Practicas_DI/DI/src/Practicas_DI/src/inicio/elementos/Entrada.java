package Practicas_DI.src.inicio.elementos;

import Practicas_DI.src.inicio.elementos.Ventana;

import javax.swing.*;

public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana v = new Ventana();
            }
        });
    }

}