package TCP;

import java.io.*;
import java.net.*;

public class PuertoAbierto
{
    public static void main(String[] args)
    {
        int puerto=8888;
        try
        {
            Socket clientSocket = new Socket("192.168.42.144",puerto);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            System.out.println("Puerto " + puerto + " abierto");
            out.close();
            clientSocket.close();
        }
        catch (UnknownHostException e){
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println("Puerto " + puerto + " cerrado");
        }
    }
}
