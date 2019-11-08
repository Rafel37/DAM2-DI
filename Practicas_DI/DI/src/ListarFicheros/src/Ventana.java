package ListarFicheros.src;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Ventana extends JFrame implements ActionListener, ListSelectionListener {
    JList lista;
    JButton boton;
    DefaultListModel modeloDatos;
    Container container;
    ScrollPane scrollPane;
    File ruta;

    public Ventana() throws HeadlessException {
        this.instancias();
        this.initGUI();
        this.rellenarLista(this.ruta);
        this.acciones();
        this.setLocation(60, 50);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.pack();
        this.setSize(600, 500);
    }

    private void rellenarLista(File file) {
        File[] ficheros = file.listFiles();
        File[] var3 = ficheros;
        int var4 = ficheros.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            File temporal = var3[var5];
            this.modeloDatos.addElement(temporal.getName());
        }

    }

    private void acciones() {
        this.boton.addActionListener(this);
        this.lista.addListSelectionListener(this);
    }

    private void initGUI() {
        this.container.add(this.scrollPane, "Center");
        this.container.add(this.boton, "South");
    }

    private void instancias() {
        this.modeloDatos = new DefaultListModel();
        this.lista = new JList(this.modeloDatos);
        this.scrollPane = new ScrollPane();
        this.scrollPane.add(this.lista);
        this.boton = new JButton("Acceder");
        this.container = this.getContentPane();
        this.ruta = new File("/home/kalimero/Documentos");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.boton) {
            System.out.println(this.lista.getModel().getElementAt(this.lista.getSelectedIndex()).toString());
            String nombre = this.lista.getModel().getElementAt(this.lista.getSelectedIndex()).toString();
            String rutaNueva = this.ruta + "\\" + nombre;
            File fichero = new File(rutaNueva);
            System.out.printf(fichero.toString());
            if (fichero.isDirectory()) {
                this.modeloDatos.clear();
                this.rellenarLista(fichero);
            }
        }

    }

    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == this.lista && e.getValueIsAdjusting()) {
            System.out.println(this.lista.getModel().getElementAt(this.lista.getSelectedIndex()).toString());
        }

    }
}