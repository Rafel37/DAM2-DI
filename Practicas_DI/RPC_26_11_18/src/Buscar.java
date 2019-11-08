import javax.swing.*;
import java.awt.*;

public class Buscar extends JFrame {

    JList listaList;
    JLabel nombreLabel, apellidoLabel, notaLabel, cicloLabel, fctsLabel;

    JPanel listaPanel, resultadoPanel;

    Container contenedor = getContentPane();

    public Buscar() throws HeadlessException {

        instancias();
        initGUI();
        acciones();
    }



    private void initGUI() {

        getContentPane().setLayout(new GridBagLayout());
        configurarPanelCentral();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

    }


    private void configurarPanelCentral() {

    }

    private void instancias() {

        listaPanel = new JPanel();
        resultadoPanel = new JPanel();


        nombreLabel = new JLabel("NOMBRE: ");
        apellidoLabel = new JLabel("APELLIDO: ");
        cicloLabel = new JLabel("CICLO: ");
        notaLabel = new JLabel("MEDIA: ");
        fctsLabel = new JLabel("FCTS: ");
    }

    private void acciones() {


    }

}
