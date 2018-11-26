package Formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    Vista objetoVista;
    Modelo objetoModelo;

    public Controlador(Vista objetoVista, Modelo objetoModelo) {
        this.objetoVista = objetoVista;
        this.objetoModelo = objetoModelo;
        acciones();
    }

    private void acciones() {
        objetoVista.getBoton().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(objetoModelo.mostrarFormateo(objetoVista.getNombre().getText()));
    }


}