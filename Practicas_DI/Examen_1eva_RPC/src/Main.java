import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main extends JFrame implements ActionListener, ItemListener {

    Container container;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem item_panel1,item_panel2,item_panel3;

    JPanel panel_central, panel1, panel2, panel3;
    CardLayout cardLayout;
    Font fuente = new Font("Arial", Font.PLAIN, 24);
    Integer nota1, nota2, nota3, media;
    String nombre, apellido;
    String ciclo;

    /*---------------Panel 1 -------------*/
    JLabel label_titulo, label_nombre, label_apellido, label_curso;
    JTextField texto_nombre, texto_apellido;
    JComboBox curso;
    DefaultComboBoxModel modelo_curso;
    JButton boton_validar;
    JPanel panel_central_1;

    /*---------------Panel 2 -------------*/
    JLabel label_asignatura_1, label_asignatura_2, label_asignatura_3;
    JSpinner spinner1, spinner2, spinner3;
    SpinnerNumberModel modelo1, modelo2, modelo3;
    JButton boton_validar2;
    JPanel panel_central_2;

    /*---------------Panel 3 -------------*/
    JLabel info1, info2;
    JCheckBox check1, check2;
    JButton boton_validar3;
    JPanel panel_central_3;


    public Main(){
        instancias();
        initGUI();
        operaciones();
    }

    private void instancias() {
        container = getContentPane();
        cardLayout = new CardLayout();
        menuBar = new JMenuBar();
        menu = new JMenu("Acciones");
        item_panel1 = new JMenuItem("Ver panel 1");
        item_panel2 = new JMenuItem("Ver panel 2");
        item_panel2.setEnabled(false);
        item_panel3 = new JMenuItem("Ver panel 3");
        item_panel3.setEnabled(false);
        panel_central = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        /*---------------Panel 1-------------*/
        label_titulo = new JLabel("Examen DI");
        label_titulo.setFont(fuente);
        label_nombre = new JLabel("Nombre");
        label_apellido = new JLabel("Apellido");
        label_curso = new JLabel("Curso");
        texto_nombre = new JTextField("");
        texto_apellido = new JTextField("");
        modelo_curso = new DefaultComboBoxModel();
        curso = new JComboBox(modelo_curso);
        boton_validar = new JButton("Validar");
        panel_central_1 = new JPanel();

        /*---------------Panel 2-------------*/
        label_asignatura_1 = new JLabel("Asignatura 1");
        label_asignatura_2 = new JLabel("Asignatura 2");
        label_asignatura_3 = new JLabel("Asignatura 3");
        modelo1 = new SpinnerNumberModel();
        modelo2 = new SpinnerNumberModel();
        modelo3 = new SpinnerNumberModel();
        spinner1 = new JSpinner(modelo1);
        spinner2 = new JSpinner(modelo2);
        spinner3 = new JSpinner(modelo3);
        boton_validar2 = new JButton("Validar");
        panel_central_2 = new JPanel();

        /*---------------Panel 3 -------------*/
        info1 = new JLabel("¿Has aprobado FCTS?");
        info2 = new JLabel("¿Has aprobado Proyecto?");
        check1 = new JCheckBox();
        check2 = new JCheckBox();
        check2.setEnabled(false);
        boton_validar3 = new JButton("Validar");
        panel_central_3 = new JPanel();


    }

    private void initGUI() {
        rellenarMenu();
        rellenarCombo();
        rellenarSpinner();
        container.setLayout(new BorderLayout());
        container.add(menuBar, BorderLayout.NORTH);
        container.add(configuracion_Panel_Central(), BorderLayout.CENTER);

        setTitle("Examen Evaluacion - Jose Luis Garcia");
        setSize(350,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void operaciones() {
        item_panel1.addActionListener(this);
        item_panel2.addActionListener(this);
        item_panel3.addActionListener(this);
        boton_validar.addActionListener(this);
        boton_validar2.addActionListener(this);
        boton_validar3.addActionListener(this);
        check1.addItemListener(this);
    }

    private JPanel configuracion_Panel_Central(){
        panel_central.setLayout(cardLayout);
        panel_central.add(configuracionPanel1(), "panel1");
        panel_central.add(configuracionPanel2(), "panel2");
        panel_central.add(configuracionPanel3(), "panel3");
        return panel_central;
    }

    private JPanel configuracionPanel1(){
        panel1.setLayout(new BorderLayout());
        panel1.add(label_titulo, BorderLayout.NORTH);
        panel1.add(configurar_panel1_centro(), BorderLayout.CENTER);
        panel1.add(boton_validar, BorderLayout.SOUTH);
        return panel1;
    }

    private JPanel configuracionPanel2(){
        panel2.setLayout(new BorderLayout());
        panel2.add(configurar_panel2_centro(), BorderLayout.CENTER);
        panel2.add(boton_validar2, BorderLayout.SOUTH);
        return panel2;
    }

    private JPanel configuracionPanel3(){
        panel3.setLayout(new BorderLayout());
        panel3.add(configurar_panel3_centro(), BorderLayout.CENTER);
        panel3.add(boton_validar3, BorderLayout.SOUTH);
        return panel3;
    }




    private JPanel configurar_panel1_centro(){
        panel_central_1.setLayout(new GridLayout(3,2));
        panel_central_1.add(label_nombre);
        panel_central_1.add(texto_nombre);
        panel_central_1.add(label_apellido);
        panel_central_1.add(texto_apellido);
        panel_central_1.add(label_curso);
        panel_central_1.add(curso);
        return panel_central_1;
    }

    private JPanel configurar_panel2_centro() {
        panel_central_2.setLayout(new GridLayout(3,2));
        panel_central_2.add(label_asignatura_1);
        panel_central_2.add(spinner1);
        panel_central_2.add(label_asignatura_2);
        panel_central_2.add(spinner2);
        panel_central_2.add(label_asignatura_3);
        panel_central_2.add(spinner3);
        return panel_central_2;
    }

    private JPanel configurar_panel3_centro(){
        panel_central_3.setLayout(new GridLayout(2,2));
        panel_central_3.add(info1);
        panel_central_3.add(check1);
        panel_central_3.add(info2);
        panel_central_3.add(check2);
        return panel_central_3;
    }



    private void rellenarMenu(){
        menuBar.add(menu);
        menu.add(item_panel1);
        menu.add(item_panel2);
        menu.add(item_panel3);
    }

    private void rellenarCombo(){
        modelo_curso.addElement("DAM");
        modelo_curso.addElement("GI");
        modelo_curso.addElement("ASIR");
    }

    private  void rellenarSpinner(){
        modelo1.setValue(1);
        modelo1.setMinimum(1);
        modelo1.setMaximum(10);
        modelo1.setStepSize(1);

        modelo2.setValue(1);
        modelo2.setMinimum(1);
        modelo2.setMaximum(10);
        modelo2.setStepSize(1);

        modelo3.setValue(1);
        modelo3.setMinimum(1);
        modelo3.setMaximum(10);
        modelo3.setStepSize(1);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== item_panel1){
            cardLayout.show(panel_central, "panel1");
        }else if(e.getSource()== item_panel2){
            cardLayout.show(panel_central, "panel2");
        }else if(e.getSource()== item_panel3){
            cardLayout.show(panel_central, "panel3");
        }else if(e.getSource()== boton_validar){
            if(!(texto_nombre.getText().isEmpty() || texto_apellido.getText().isEmpty())){
                nombre = texto_nombre.getText();
                apellido = texto_apellido.getText();
                ciclo = curso.getModel().getSelectedItem().toString();
                JOptionPane.showMessageDialog(this, "PERFECTO!!  El panel 2 acaba de activarse", "BIEN!!", JOptionPane.INFORMATION_MESSAGE);
                item_panel2.setEnabled(true);

            } else{
                JOptionPane.showMessageDialog(this, "Porfavor, rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == boton_validar2){
            JOptionPane.showMessageDialog(this, "PERFECTO!!  El panel 3 acaba de activarse", "BIEN!!", JOptionPane.INFORMATION_MESSAGE);
            nota1 = (Integer) spinner1.getValue();
            nota2 = (Integer) spinner2.getValue();
            nota3 = (Integer) spinner3.getValue();
            item_panel3.setEnabled(true);

        }else if(e.getSource() == boton_validar3){
            media = (nota1 + nota2 + nota3)/3;
            if(media>=5){
                JOptionPane.showMessageDialog(this, "Felicidades " + nombre + " " + apellido + " has aprobado  " + ciclo + " con media de " + media, "BIEN!!", JOptionPane.INFORMATION_MESSAGE);

            } else if(media < 5){
                JOptionPane.showMessageDialog(this, "Lo siento " + nombre + " " + apellido + " has suspendido " + ciclo, "BIEN!!", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(check1.isSelected() == true){
            check2.setEnabled(true);

        } else{


        }

    }
}