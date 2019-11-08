package Examenes_DI.RPC.src;


import RPC.src.Llamadas;
import jdk.nashorn.internal.parser.Scanner;

import java.io.Serializable;
//import java.util.Scanner;

public class Nacionales extends Llamadas implements Serializable {


    //VARIABLES
    int nOrigen;
    int nDestino;
    int duracion;
    double coste;
    int franja;
    double totalFacturado;


    //CONSTRUCTOR
    public Nacionales(int nOrigen, int nDestino, int duracion, double coste, double totalFacturado) {
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.duracion = duracion;
        this.coste = coste;
        this.totalFacturado = totalFacturado;
    }

    //GETTERS
    public int getnOrigen() {
        return nOrigen;
    }

    public int getnDestino() {
        return nDestino;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getCoste() {
        return coste;
    }

    //SETTERS
    public void setnOrigen(int nOrigen) {
        this.nOrigen = nOrigen;
    }
    public void setnDestino(int nDestino) {
        this.nDestino = nDestino;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public String registrarLlamada() {

        //Scanner scanner = new Scanner(System.in);

        System.out.println("NUMERO DE ORIGEN: ");
        //setnOrigen(scanner.);
        System.out.println("NUMERO DE DESTINO: ");
        //setnDestino(scanner.nextInt());
        System.out.println("DURACION: ");
        //setDuracion(scanner.nextInt());
        System.out.println("FACTURADO: ");
        //setCoste(scanner);
        return registrarLlamada();
    }

    protected String informacionLlamada() {

        String salida = "ORIGEN: " + getnOrigen() +
                "DESTINO: " + getnDestino() +
                "DURACION: " + getDuracion();
        return salida;
    }
}
