package CHAT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelCliente
{
    private JScrollPane scroll;

    private JTextArea textArea;

    private JTextField textField;

    private JButton boton;

    public PanelCliente(Container contenedor)
    {
        contenedor.setLayout(new BorderLayout());
        textArea = new JTextArea();
        scroll = new JScrollPane(textArea);

        JPanel panel = new JPanel(new FlowLayout());
        textField = new JTextField(40);
        boton = new JButton("Enviar");
        panel.add(textField);
        panel.add(boton);

        contenedor.add(scroll, BorderLayout.CENTER);
        contenedor.add(panel, BorderLayout.SOUTH);
    }

    public void addActionListener(ActionListener accion)
    {
        textField.addActionListener(accion);
        boton.addActionListener(accion);

    }

    public void addTexto(String texto)
    {
        textArea.append(texto);
    }


    public String getTexto()
    {
        String texto = "Juan: "+  textField.getText();
        textField.setText("");
        return texto;
    }
}
