package TCP;

import java.io.*;
import java.net.*;

public class ClientUDP
{
    public static void main(String[] args)
    {
        try
        {
            int port = 2020;
            InetAddress host = InetAddress.getByName("192.168.43.27");
            String text = "hola fondo sur";

            DatagramSocket socketUDP = new DatagramSocket();
            System.out.println("Send: " + text);
            DatagramPacket send = new DatagramPacket(text.getBytes(), text.getBytes().length, host, port);
            socketUDP.send(send);

            byte[] bufer = new byte[1000];
            DatagramPacket receive = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(receive);
            System.out.println("Receive: " + new String(receive.getData()).trim());

            socketUDP.close();
        }
        catch (SocketException e) {}
        catch (IOException e) {}
    }



}