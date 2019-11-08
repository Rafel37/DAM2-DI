package PeticionFichero;

import java.io.*;
import java.net.*;

public class FicheroServidor
{
    public static final int PORT = 4444;

    public static void main (String args[]) throws IOException {
        ServerSocket servidor = null;
        Socket cliente;
        BufferedReader entrada = null;
        OutputStream sendChannel = null;
        String cadena = "";
        String comando = "";

        try{
            servidor = new ServerSocket(PORT);
        }
        catch(IOException e){System.out.println("ERROR! FALLO AL CONECTAR CON EL SERVIDOR");
        System.exit(-1);}

        System.out.println("SERVIDOR ESCUCHANDO: " + servidor + " " + servidor.getInetAddress());

        cliente = servidor.accept();
        while(!cliente.isClosed()){
            try{
                entrada = new BufferedReader (new InputStreamReader(cliente.getInputStream()));
                sendChannel = cliente.getOutputStream();
                cadena = entrada.readLine();
            }
            catch(IOException e ) {
                System.out.println(e.getMessage());
            }

            System.out.println("BUSCANDO ARCHIVO EN EL COMANDO:  " + cadena);

            for (int x = 0; x < cadena.length(); x++){
                if(!cadena.substring(x, x+1).equals(" ") && !cadena.substring(x, x+1).equals("\"")){
                    comando = comando + cadena.substring(x, x+1);
                }
            }
            cadena = comando.substring(0, 3);

            switch(cadena){
                case "bye": System.out.println("CONEXION CON EL CLIENTE FINALIZADA.");
                cliente.close();
                break;

                case "get":
                    BuscarArchivo find = new BuscarArchivo();
                    File archivoEncontrado = find.buscador(comando.substring(3), new File("/home/"));
                    if(archivoEncontrado != null){
                        new HiloEnvio (cliente, archivoEncontrado).start();
                    }
                    else {
                        sendChannel.write(-1);
                    }
                    cadena = "";
                    comando = "";
                    break;

                default:
                    sendChannel.write(-1);
                    cadena = "";
                    comando = "";
            }
        }
    }
}