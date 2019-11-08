package TCP;

import java.net.*;
import java.io.*;

public class ServerUDP
{
    public static void main (String args[])
    {
        try
        {
            int port = 2020;
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true)
            {
                DatagramPacket send = new DatagramPacket(bufer, bufer.length);
                socketUDP.receive(send);
                String text = new String(send.getData()).trim();
                System.out.println("Receive: " + text);

                System.out.println("Send: " + text.toUpperCase());
                DatagramPacket receive = new DatagramPacket(text.toUpperCase().getBytes(), text.length(),send.getAddress(), send.getPort());
                socketUDP.send(receive);

                socketUDP.close();
            }
        }
        catch (SocketException e) {}
        catch (IOException e) {}
    }
}