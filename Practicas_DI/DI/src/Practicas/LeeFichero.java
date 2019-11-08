package Practicas;

import Practicas.Palabra;

import java.io.*;

class LeeFichero {
    public static void main(String [] arg) throws InterruptedException {
        File fichero = null;
        FileReader fileread = null;
        BufferedReader br = null;

        try {
            fichero = new File ("/home/kalimero/Documentos/fichero.txt");
            fileread = new FileReader (fichero);
            br = new BufferedReader(fileread);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null) {

                System.out.println(linea);
                Palabra palalabra = new Palabra(linea);
                palalabra.start();
                palalabra.join();
                System.out.println("");
            }


            System.out.println("Hilos terminados.");
        }
        catch(Exception e){
            e.printStackTrace();

        }
        finally{
            try{
                if( null != fileread ) {
                    fileread.close();
                }
            }catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}