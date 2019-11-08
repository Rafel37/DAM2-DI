package vista;

import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;
import java.awt.*;

public class Ventana extends JFrame {

    PanelEntrada pe;
    PanelAsignaturas pa;
    PanelFinal pf;
    JMenuBar barra;
    JMenu acciones;
    JMenuItem panel1,panel2,panel3;
    JTabbedPane tb;
    Container container;

    public Ventana() throws HeadlessException{

        instancias();
        configurarMenu();
        initGUI();
    }

    private void initGUI() {
        setTitle("ExamenFinalDI");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(true);
        pack();
    }

    private void configurarMenu(){
        this.setJMenuBar(barra);
        barra.add(acciones);
        acciones.add(panel1);
        acciones.add(panel2);
        acciones.add(panel3);
        tb.addTab("Panel1",null,pe);
        tb.addTab("Panel2",null,pa);
        tb.addTab("Panel3",null,pf);
    }

    private void instancias() {
        tb = new JTabbedPane();
        pe = new PanelEntrada();
        pa = new PanelAsignaturas();
        pf = new PanelFinal();
        barra = new JMenuBar();
        acciones = new JMenu("Acciones");
        panel1 = new JMenuItem("Panel1");
        panel2 = new JMenuItem("Panel2");
        panel3 = new JMenuItem("Panel3");

        container = getContentPane();
        container.add(tb);

    }

    public PanelEntrada getPe() {
        return pe;
    }

    public PanelAsignaturas getPa() {
        return pa;
    }

    public PanelFinal getPf() {
        return pf;
    }

    public JMenuBar getBarra() {
        return barra;
    }

    public JMenu getAcciones() {
        return acciones;
    }

    public JMenuItem getPanel1() {
        return panel1;
    }

    public JMenuItem getPanel2() {
        return panel2;
    }

    public JMenuItem getPanel3() {
        return panel3;
    }

    public Container getContainer() {
        return container;
    }
}
