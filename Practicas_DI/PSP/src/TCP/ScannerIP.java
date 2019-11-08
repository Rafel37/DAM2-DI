package TCP;

import java.net.*;
import java.io.*;

public class ScannerIP {
    public static void main(String[] args) {
        //Introducir como argumento de entrada las direcciones IP
        for (int i = 0; i < args.length; i++) {
            //Comprobar puertos del 80 al 90
            for (int port = 10; port < 800; port++) {
                try {
                    Socket SocketIP = new Socket(args[i], port);
                    System.out.println("Conectar a " + SocketIP.getInetAddress() + " en el puerto " + SocketIP.getPort() + " desde el puerto " + SocketIP.getLocalPort() + " en " + SocketIP.getLocalAddress());
                    SocketIP.close();
                } // end try
                catch (UnknownHostException ex) {
                    System.err.println(ex);
                }
                catch (SocketException ex) {
                    System.err.println(ex);
                }
                catch (IOException ex) {
                    System.err.println(ex);
                }
            } // fin for IP
        } // fin for port
    } // fin main
} // fin ScannerIP