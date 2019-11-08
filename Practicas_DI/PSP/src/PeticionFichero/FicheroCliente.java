package PeticionFichero;

import java.io.*;
import java.net.*;

public class FicheroCliente
{
    public static void main(String[] args) throws IOException {

        int bytesRead;
        BufferedOutputStream bos = null;
        Socket socketCliente = null;
        Socket connection = null;
        BufferedInputStream bis = null;
        int in;
        String file;


        PrintWriter salida = null;

        String hostName = InetAddress.getLocalHost().getHostName();

        try{ socketCliente = new Socket(hostName, 4444);
            System.out.println("servidor conectado:" + hostName);

            salida = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socketCliente.getOutputStream())),true);
        }catch(IOException e){
            System.err.println("No puede establecer conexion");
            System.exit(-1); }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String linea = "";

        while(!linea.equalsIgnoreCase("EXIT")){

            do{
                System.out.println("Introduzca comando válido:");
                // ENTRADA DEL USUARIO
                linea = stdIn.readLine();
            }
            while (!linea.matches("[a-z][a-z][a-z] \".*\"") && !linea.equalsIgnoreCase("bye"));
            //La envia al servidor
            salida.println(linea);

            try {
                //RECIBIR ARCHIVO
                byte [] mybytearray  = new byte [66666];
                DataInputStream dis = new DataInputStream(socketCliente.getInputStream());

                //RECIBE NOMBRE ARCHIVO
                file = dis.readUTF();
                file = file.substring(file.indexOf('\\')+1);

                //GUARDAR ARCHIVO
                bos = new BufferedOutputStream(new FileOutputStream(file));
                while ((in = bis.read(mybytearray)) != -1){
                    bos.write(mybytearray,0,in);
                }


                bytesRead = dis.read(mybytearray,0,mybytearray.length);
                System.out.println(bytesRead);



                if(bytesRead == 1){
                    System.out.println("ERROR! ARCHIVO NO ENCONTRADO O COMANDO ERRONEO");
                }
                else if(bytesRead == -1){ System.out.println("Sesion finalizada"); }

                else {
                    bos.write(mybytearray, 0 , in);
                    bos.close();
                    dis.close();
                }

            }

            catch(IOException e){ System.out.println("ERROR EN TRANSMISION");
                if (bis != null) bis.close();
                if (bos != null) bos.close();
                if (socketCliente != null) socketCliente.close(); }
        }

        if (bis != null) bis.close();
        if (bos != null) bos.close();
        if (socketCliente != null) socketCliente.close();

    }
}