package ModeloVistaControlador;

import javax.swing.*;

public class Vista extends JFrame {

    JTextField nombre;
    JButton boton;
    JPanel contenedor;
    JPanel pPrincipal;

    Vista() {
        initComponent();
    }

    private void initComponent() {
        instancias();
        configurarEspacio();

        this.setTitle("Ejemplo modelo vista controlador");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

    }

    private void configurarEspacio() {
        pPrincipal.add(new JLabel("Introduce un nombre para probar"));
        pPrincipal.add(nombre);
        pPrincipal.add(boton);
        contenedor.add(pPrincipal);


    }

    private void instancias() {
        nombre = new JTextField("Introduce nombre", 10);
        boton = new JButton("Enviar");
        pPrincipal = new JPanel();
        contenedor = (JPanel) getContentPane();
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JButton getBoton() {
        return boton;
    }
}