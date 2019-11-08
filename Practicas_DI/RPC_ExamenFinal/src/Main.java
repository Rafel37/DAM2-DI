import util.Persona;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener {

    Container container;
    CardLayout cardLayout;

    //BARRA MENU
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem introducir, ver;

    //PANELES
    JPanel panel;
    JPanel introducirPanel;
    JPanel verPanel;

    //PANEL INTRODUCIR
    JPanel getIntroducirPanel;
    JTextField nombreIntro;
    JTextField apellidoIntro;
    JComboBox edadIntro;
    String[] anos;
    JButton introducirIntro;
    private String nombreTemp, apellidoTemp;
    private Object edadTemp;

    //PANEL VER
    JPanel getVerPanel;
    JList nombresVer;
    DefaultListModel modeloNombres;
    JTextField nombreVer;
    JTextField apellidoVer;
    JTextField edadVer;
    ArrayList<Persona> arrayList;

    public Main() throws HeadlessException {
        instancias();
        innitGUI();
        acciones();
    }

    private void instancias() {

        container = getContentPane();
        cardLayout = new CardLayout();

        //BARRA MENU
        menuBar = new JMenuBar();
        menu = new JMenu("Acciones");
        introducir = new JMenuItem("Introducir Alumnos");
        ver = new JMenuItem("Ver Alumnos");

        //PANELES
        panel = new JPanel();
        introducirPanel = new JPanel();
        verPanel = new JPanel();

        //PANEL INTRODUCIR
        getIntroducirPanel = new JPanel();
        nombreIntro = new JTextField("Introduce Nombre");
        apellidoIntro = new JTextField("Introduce Apellido");
        anos = new String[100];

        int j = 0;
        for (int i = 1; i < 100; i++) {
            anos[j] = String.valueOf(i);
            j++;
        }

        edadIntro = new JComboBox(anos);
        introducirIntro = new JButton("Registrar");

        //PANEL VER
        getVerPanel = new JPanel();
        modeloNombres = new DefaultListModel();
        nombresVer = new JList<Persona>();
        nombreVer = new JTextField();
        apellidoVer = new JTextField();
        edadVer = new JTextField();
        arrayList = new ArrayList<>();
    }

    private void innitGUI() {
        setTitle("EXAMEN FINAL");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);

        barraMenu();
        container.setLayout(new BorderLayout());
        container.add(menuBar, BorderLayout.NORTH);
        container.add(paneles(), BorderLayout.CENTER);

    }

    private void barraMenu() {
        menuBar.add(menu);
        menu.add(introducir);
        menu.add(ver);
    }

    private JPanel paneles() {
        panel.setLayout(cardLayout);
        panel.add(panelIntroducir(), "introducir");
        panel.add(panerVer(), "ver");
        return panel;
    }

    private JPanel panelIntroducir() {
        introducirPanel.setLayout(new GridLayout(4,1));
        introducirPanel.add(nombreIntro);
        introducirPanel.add(apellidoIntro);
        introducirPanel.add(edadIntro);
        introducirPanel.add(introducirIntro);
        return introducirPanel;
    }

    private JPanel panerVer() {
        verPanel.setLayout(new GridLayout(4,1));
        nombresVer.setModel(modeloNombres);
        verPanel.add(nombresVer);
        verPanel.add(nombreVer);
        verPanel.add(apellidoVer);
        verPanel.add(edadVer);
        return verPanel;
    }

    private void acciones() {
        introducir.addActionListener(this);{

        }
        ver.addActionListener(this);
        introducirIntro.addActionListener(this);
        nombresVer.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                String nombreBuscar = listSelectionEvent.toString();
                for (Persona p: arrayList) {
                    if (p.getNombre().equals(nombreBuscar)){
                        nombreVer.setText(p.getNombre());
                        apellidoVer.setText(p.getApellidos());
                        edadVer.setText(p.getEdad());
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == introducir) {
            cardLayout.show(panel, "introducir");
        }
        else if (actionEvent.getSource() == ver) {
            cardLayout.show(panel, "ver");
        }

        else if (actionEvent.getSource() == introducirIntro) {
            nombreTemp = nombreIntro.getText();
            apellidoTemp = apellidoIntro.getText();
            edadTemp = edadIntro.getSelectedItem();
            if (nombreTemp != null && apellidoTemp != null && edadTemp != null){
                Persona persona = new Persona(nombreTemp, apellidoTemp, String.valueOf(edadTemp));
                modeloNombres.addElement(persona);
                JOptionPane.showMessageDialog(Main.this, "Usuario registrado con exito", "OKEY!!", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(persona.getNombre());
                System.out.println(persona.getApellidos());
                System.out.println(persona.getEdad());
            }
            else{
                JOptionPane.showMessageDialog(Main.this, "Complete todos los campos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if (actionEvent.getSource() == ver) {
            cardLayout.show(panel, "ver");
        }

        else if (actionEvent.getSource() == nombresVer) {

        }
    }
}