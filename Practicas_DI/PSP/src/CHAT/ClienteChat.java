package CHAT;

import javax.swing.*;
import java.net.Socket;


public class ClienteChat
{
    private Socket socket;

    private PanelCliente panel;

    public static void main(String[] args)
    {
        new ClienteChat();
    }

    public ClienteChat()
    {
        try
        {
            creaYVisualizaVentana();
            socket = new Socket("192.168.43.167", 4444);
            ControlCliente control = new ControlCliente(socket, panel);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void creaYVisualizaVentana()
    {
        JFrame v = new JFrame();
        panel = new PanelCliente(v.getContentPane());
        v.pack();
        v.setVisible(true);
        v.setSize(600, 600);
        v.setLocationRelativeTo(null);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
