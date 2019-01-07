import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.UndoableEditListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;
import java.beans.EventHandler;
import java.io.*;

public class Main extends JFrame implements ActionListener {

    // contenedor y eventos
    Container container;
    EventHandler eventHandler;
    String archivo = null;

    //panel lateral
    //TODO

    // texto
    JTextArea textArea;
    JScrollPane scroll;

    // barra del menu
    JMenuBar menuBar;
    JMenu archivoMenu;
    JMenuItem nuevo;
    JMenuItem abrir;
    JMenuItem cerrar;
    JMenuItem guardar;
    JMenuItem guardarComo;
    JMenuItem imprimir;
    JMenu edicionMenu;
    JMenuItem copiar;
    JMenuItem cortar;
    JMenuItem pegar;
    JMenu estilo;
    JMenuItem normal;
    JMenuItem bold;
    JMenuItem cursiva;

    // barra de herramientas
    JToolBar toolBar;
    JButton nuevoButton;
    JButton abrirButton;
    JButton guardarButton;
    JButton imprimirButton;
    JButton copiarButton;
    JButton cortarButton;
    JButton pegarButton;
    JButton boldButton;
    JLabel sizeLabel;
    JSpinner size;
    SpinnerNumberModel modeloNumero;
    JLabel typeLabel;
    JComboBox type;

    public Main() throws HeadlessException {
        instancias();
        initGUI();
        acciones();
        setVisible(true);
        setTitle("Procesador de texto");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);
    }

    private void initGUI() {
        confiMenuBar();
        confiTexArea();
    }


    private void instancias() {
        container = getContentPane();
        menuBar = new JMenuBar();
        textArea = new JTextArea();
        scroll = new JScrollPane();

        // barra menu
        archivoMenu = new JMenu("Archivo");
        nuevo = new JMenuItem("Nuevo", new ImageIcon(getClass().getResource("/resources/new.png")));
        abrir = new JMenuItem("Abrir", new ImageIcon(getClass().getResource("/resources/open.png")));
        cerrar = new JMenuItem("Cerrar", new ImageIcon(getClass().getResource("/resources/close.png")));
        guardar = new JMenuItem("Guardar", new ImageIcon(getClass().getResource("/resources/save.png")));
        guardarComo = new JMenuItem("Guardar como...");
        imprimir = new JMenuItem("Imprimir", new ImageIcon(getClass().getResource("/resources/print.png")));
        edicionMenu = new JMenu("Edicion");
        copiar = new JMenuItem("Copiar", new ImageIcon(getClass().getResource("/resources/copy.png")));
        cortar = new JMenuItem("Cortar", new ImageIcon(getClass().getResource("/resources/cut.png")));
        pegar = new JMenuItem("Pegar", new ImageIcon(getClass().getResource("/resources/paste.png")));
        estilo = new JMenu("Estilo de la fuente");
        normal = new JMenuItem("Normal", new ImageIcon(getClass().getResource("/resources/normal.png")));
        bold = new JMenuItem("Bold", new ImageIcon(getClass().getResource("/resources/bold.png")));
        cursiva = new JMenuItem("Cursiva", new ImageIcon(getClass().getResource("/resources/italic.png")));

        // barra herramientas
        toolBar = new JToolBar();
        nuevoButton = new JButton(new ImageIcon(getClass().getResource("/resources/new.png")));
        abrirButton = new JButton(new ImageIcon(getClass().getResource("/resources/open.png")));
        guardarButton = new JButton(new ImageIcon(getClass().getResource("/resources/save.png")));
        imprimirButton = new JButton(new ImageIcon(getClass().getResource("/resources/print.png")));
        copiarButton = new JButton(new ImageIcon(getClass().getResource("/resources/copy.png")));
        cortarButton = new JButton(new ImageIcon(getClass().getResource("/resources/cut.png")));
        pegarButton = new JButton(new ImageIcon(getClass().getResource("/resources/paste.png")));
        boldButton = new JButton(new ImageIcon(getClass().getResource("/resources/bold.png")));
        sizeLabel = new JLabel("Tamaño de letra ");
        size = new JSpinner();
        modeloNumero = new SpinnerNumberModel();
        typeLabel = new JLabel(" Tipo de letra ");
        type = new JComboBox();
    }

    private void confiMenuBar() {

        // Barra menu
        this.setJMenuBar(menuBar);
        menuBar.add(archivoMenu);
        menuBar.add(edicionMenu);
        archivoMenu.add(nuevo);
        archivoMenu.add(abrir);
        archivoMenu.add(cerrar);
        archivoMenu.add(guardar);
        archivoMenu.add(guardarComo);
        archivoMenu.add(new JSeparator()); //rayita separadora
        archivoMenu.add(imprimir);
        edicionMenu.add(copiar);
        edicionMenu.add(cortar);
        edicionMenu.add(pegar);
        edicionMenu.add(new JSeparator()); //rayita separadora
        edicionMenu.add(estilo);
        estilo.add(normal);
        estilo.add(bold);
        estilo.add(cursiva);

        // spinner tamaño
        size.setModel(modeloNumero);
        size.setValue(7);
        modeloNumero.setMaximum(20);
        modeloNumero.setMinimum(1);
        modeloNumero.setStepSize(1);
        toolBar.add(size);

        // Barra herramientas
        toolBar.add(nuevoButton);
        toolBar.add(abrirButton);
        toolBar.add(guardarButton);
        toolBar.add(imprimirButton);
        toolBar.add(copiarButton);
        toolBar.add(cortarButton);
        toolBar.add(pegarButton);
        toolBar.add(boldButton);
        toolBar.add(sizeLabel);
        toolBar.add(size);
        toolBar.add(typeLabel);
        toolBar.add(type);

        // rellenar tipos
        type.addItem("hola");
        type.addItem("adios");
        type.addItem("cuvi");

        //extras

        // añadir al contenedor
        container.add(toolBar, BorderLayout.NORTH);
        container.add(textArea, BorderLayout.CENTER);
        container.add(scroll, BorderLayout.CENTER);
    }

    private void confiTexArea() {

        //limita las lineas
        textArea.setLineWrap(true);
        // limita las palabras al final de la linea
        textArea.setWrapStyleWord(true);
        //añade scroll
        scroll.setViewportView(textArea);
        //eventos para el cursor
        textArea.addCaretListener((CaretListener) eventHandler);
        //eventos para el ratón
        textArea.addMouseListener((MouseListener) eventHandler);
        //eventos para los cambios sobre el documento
        textArea.getDocument().addUndoableEditListener((UndoableEditListener) eventHandler);
    }

    private void acciones() {

        // barra menu
        archivoMenu.addActionListener(this);
        nuevo.addActionListener(this);
        abrir.addActionListener(this);
        cerrar.addActionListener(this);
        guardar.addActionListener(this);
        guardarComo.addActionListener(this);
        imprimir.addActionListener(this);
        edicionMenu.addActionListener(this);
        copiar.addActionListener(this);
        copiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copiar.setActionCommand("cmd_copy");
        cortar.addActionListener(this);
        cortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cortar.setActionCommand("cmd_cut");
        pegar.addActionListener(this);
        pegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        pegar.setActionCommand("cmd_paste");
        estilo.addActionListener(this);
        normal.addActionListener(this);
        bold.addActionListener(this);
        cursiva.addActionListener(this);

        // barra herramientas
        nuevoButton.addActionListener(this);
        abrirButton.addActionListener(this);
        guardarButton.addActionListener(this);
        imprimirButton.addActionListener(this);
        copiarButton.addActionListener(this);
        cortarButton.addActionListener(this);
        pegarButton.addActionListener(this);
        boldButton.addActionListener(this);
        type.addActionListener(this);

    }





    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        //FUNCIONES DEL MENU ARCHIVO
        //nuevo
        if (e.getSource() == nuevo || e.getSource() == nuevo || e.getSource() == nuevoButton) {

            setTitle("Procesador de texto - Sin Título");
            textArea.setText("");
        }
        //abrir
        else if (e.getSource() == abrir || e.getSource() == abrir || e.getSource() == abrirButton) {
            JFileChooser fc = new JFileChooser();
            int state = fc.showOpenDialog(null);

            if (state == JFileChooser.APPROVE_OPTION) {
                File f  = fc.getSelectedFile();
                archivo = fc.getSelectedFile().toString();

                try {
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    textArea.read(br, null);
                    br.close();

                    setTitle("TextPad Demo - " + f.getName());

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        //cerrar
        else if (e.getSource() == cerrar) {
            System.exit(0);
        }
        //guardar
        else if (e.getSource() == guardar || e.getSource() == guardar || e.getSource() == guardarButton) {
            if (archivo != null && !("").equals(archivo)) {
                guardar(archivo);
            } else {
                guardarComo();
            }
        }
        //guardarcomo
        else if (e.getSource() == guardarComo) {
            guardarComo();
        }
        //imprimir
        //todo


        //FUNCIONES DEL MENU EDICION

        else if (ac.equals("cmd_copy") == true) {
            textArea.copy();
        }
        else if (ac.equals("cmd_cut") == true) {
            textArea.cut();
        }
        else if (ac.equals("cmd_paste") == true) {
            textArea.paste();
        }

        //ESTILO
         //bold
        else if (e.getSource() == bold || e.getSource() == boldButton) {
            Font fuente = new Font(type.getSelectedItem().toString(), Font.BOLD, Integer.parseInt(size.getValue().toString()));
            textArea.setFont(fuente);
        }
        //normal
        else if (e.getSource() == normal) {
            Font fuente = new Font(type.getSelectedItem().toString(), Font.PLAIN, Integer.parseInt(size.getValue().toString()));
            textArea.setFont(fuente);
        }
        //cursiva
        else if (e.getSource() == cursiva) {
            Font fuente = new Font(type.getSelectedItem().toString(), Font.ITALIC, Integer.parseInt(size.getValue().toString()));
            textArea.setFont(fuente);
        }

        //TAMAÑO LETRA
        else if (e.getSource() == size.getValue()) {
            textArea.setFont(textArea.getFont().deriveFont(Integer.parseInt(size.getValue().toString())));
        }

        //TIPO LETRA

    }



























    // FUNCIONES DE LOS BOTONES

    public void guardar(String s) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        String contenido = "";
        try {
            fileWriter = new FileWriter(s);
            bufferedWriter = new BufferedWriter(fileWriter);
            BufferedReader reader = new BufferedReader(new StringReader(textArea.getText()));
            String linea;

            while ((linea = reader.readLine()) != null) {
                contenido += linea + "\n";
            }
            bufferedWriter.write(contenido);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void guardarComo() {
        JFileChooser guardarArchivo = new JFileChooser();
        guardarArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int seleccion = guardarArchivo.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File f = guardarArchivo.getSelectedFile();
            String path = f.getAbsolutePath();

            if (f.exists()) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(container, "Ya existe un fichero con ese nombre \n ¿Desea reemplazarlo?", "Confirmar guardar fichero", JOptionPane.YES_NO_OPTION)) {
                    guardar(path);
                }
            } else {
                try {
                    f.createNewFile();
                    guardar(path);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}