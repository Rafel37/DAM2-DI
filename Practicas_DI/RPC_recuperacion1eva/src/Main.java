import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener {

    Container container;
    CardLayout cardLayout;
    ArrayList<Usuarios> arrayList;

    //barra menu
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem registrar, buscar;

    //paneles
    JPanel panel;
    JPanel registrarPanel;
    JPanel buscarPanel;

    //panel registrar
    JPanel getRegistrarPanel;
    JButton nombreButton;
    JButton dniButton;
    JButton telefonoButton;
    JButton edadButton;
    JButton registrarButton;

    //panel buscar
    JPanel getBuscarPanel;
    JLabel dniLabel;
    JTextField dniText;
    JLabel nombreLabel;
    JTextField nombreText;
    JLabel telefonoLabel;
    JTextField telefonoText;
    JLabel edadLabel;
    JTextField edadText;
    JButton buscarButton;
    JButton borrarButton;


    String nombre = "", dni = "", telefono = "";
    Object edad = 0;

    public Main() throws HeadlessException {
        instancias();
        initGUI();
        acciones();
    }

    private void instancias() {

        container = getContentPane();
        cardLayout = new CardLayout();

        //barra menu
        menuBar = new JMenuBar();
        menu = new JMenu("Acciones");
        registrar = new JMenuItem("Registrar");
        buscar = new JMenuItem("Buscar");

        //paneles
        panel = new JPanel();
        registrarPanel = new JPanel();
        buscarPanel = new JPanel();

        //panel registrar
        getRegistrarPanel = new JPanel();
        nombreButton = new JButton("Intro Nombre");
        dniButton = new JButton("Intro DNI");
        telefonoButton = new JButton("Intro Telefono");
        edadButton = new JButton("Intro Edad");
        registrarButton = new JButton("Registrar");

        //panel buscar
        getBuscarPanel = new JPanel();
        dniLabel = new JLabel("DNI");
        dniText = new JTextField();
        nombreLabel = new JLabel("Nombre");
        nombreText = new JTextField();
        nombreText.setEnabled(false);
        telefonoLabel = new JLabel("Telefono");
        telefonoText = new JTextField();
        telefonoText.setEnabled(false);
        edadLabel = new JLabel("Edad");
        edadText = new JTextField();
        edadText.setEnabled(false);
        buscarButton = new JButton("Buscar");
        borrarButton = new JButton("Borrar");

    }

    private void initGUI() {

        setTitle("Examen Recuperacion");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        barraMenu();

        container.setLayout(new BorderLayout());
        container.add(menuBar, BorderLayout.NORTH);
        container.add(paneles(), BorderLayout.CENTER);
    }



    private void barraMenu() {
        menuBar.add(menu);
        menu.add(registrar);
        menu.add(buscar);
    }

    private JPanel paneles() {
        panel.setLayout(cardLayout);
        panel.add(panelRegistrar(), "registrar");
        panel.add(panelBuscar(), "buscar");
        return panel;
    }



    private JPanel panelRegistrar() {
        registrarPanel.setLayout(new GridLayout(5,1));
        registrarPanel.add(nombreButton);
        registrarPanel.add(dniButton);
        registrarPanel.add(telefonoButton);
        registrarPanel.add(edadButton);
        registrarPanel.add(registrarButton);
        return registrarPanel;
    }

    private JPanel panelBuscar() {
        buscarPanel.setLayout(new GridLayout(5,2));
        buscarPanel.add(dniLabel);
        buscarPanel.add(dniText);
        buscarPanel.add(nombreLabel);
        buscarPanel.add(nombreText);
        buscarPanel.add(telefonoLabel);
        buscarPanel.add(telefonoText);
        buscarPanel.add(edadLabel);
        buscarPanel.add(edadText);
        buscarPanel.add(buscarButton);
        buscarPanel.add(borrarButton);
        return buscarPanel;
    }


    private void acciones() {
        registrar.addActionListener(this);
        buscar.addActionListener(this);
        nombreButton.addActionListener(this);
        dniButton.addActionListener(this);
        telefonoButton.addActionListener(this);
        edadButton.addActionListener(this);
        registrarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        if (actionEvent.getSource() == registrar) {
            cardLayout.show(panel, "registrar");
        }
        else if (actionEvent.getSource() == buscar) {
            cardLayout.show(panel, "buscar");
        }
        else if (actionEvent.getSource() == nombreButton) {
            nombre = JOptionPane.showInputDialog(this, "Intoduzca el nombre", "NOMBRE", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(nombre);

        }
        else if (actionEvent.getSource() == dniButton) {
            dni = JOptionPane.showInputDialog(this, "Intoduzca el DNI", "DNI", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(dni);
        }
        else if (actionEvent.getSource() == telefonoButton) {
            telefono = JOptionPane.showInputDialog(this, "Intoduzca el telefono", "TELEFONO", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(telefono);
        }
        else if (actionEvent.getSource() == edadButton) {

            int j = 0;
            String[]edades = new String[100];
                    for (int i=1; i<100; i++){
                        edades[j] = String.valueOf(i);
                        j++;
                    }
            edad = JOptionPane.showInputDialog(null, "Intoduzca la edad", "EDAD", JOptionPane.INFORMATION_MESSAGE, null, edades, 1);
            System.out.println(edad);
        }
        else if (actionEvent.getSource() == registrarButton) {

            if (!nombre.equals(null) && !dni.equals(null) && !telefono.equals(null) && edad != null){
                JOptionPane.showMessageDialog(this, "Usuario registrado con exito", "EXITO", JOptionPane.INFORMATION_MESSAGE);
                Usuarios usuarios = new Usuarios(nombre, dni, String.valueOf(edad), Integer.valueOf(telefono));
                System.out.println(usuarios.nombre);
                System.out.println(usuarios.dni);
                System.out.println(usuarios.edad);
                System.out.println(usuarios.telefono);
            }
            else {
                JOptionPane.showMessageDialog(this, "Rellene todos loscampos por favor.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


}