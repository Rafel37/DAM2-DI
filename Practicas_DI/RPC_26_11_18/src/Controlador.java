import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    Registro objetoRegistro;
    Modelo objetoModelo;

    public Controlador(Vista objetoRegistro, Modelo objetoModelo) {
        this.objetoRegistro = objetoRegistro;
        this.objetoModelo = objetoModelo;
        acciones();
    }

    private void acciones() {
        objetoRegistro.getBoton().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(objetoModelo.mostrarFormateo(objetoRegistro.getNombre().getText()));
    }
}