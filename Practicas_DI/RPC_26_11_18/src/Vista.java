import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame implements ActionListener {

    JPanel arribaPanel, centroPanel, registroPanel, buscarPanel;
    JButton registro, buscar;

    Container contenedor = getContentPane();

    public Vista() throws HeadlessException {

        instancias();
        initGUI();
    }

    private void initGUI() {

        contenedor.add(configurarArriba(), BorderLayout.NORTH);
        contenedor.add(configurarCentro(), BorderLayout.CENTER);
    }

    private JPanel configurarArriba() {
        arribaPanel.add(registro);
        arribaPanel.add(buscar);
        return arribaPanel;
    }

    private JPanel configurarCentro() {
        return centroPanel;
    }

    private void instancias() {

        registro = new JButton("REGITRO");
        registro = new JButton("BUSCAR");


        arribaPanel = new JPanel(new FlowLayout());
        centroPanel = new JPanel();
        centroPanel.setLayout(new BoxLayout(centroPanel,BoxLayout.X_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
