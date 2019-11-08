package Examenes_DI.RPC.src;


import RPC.src.Llamadas;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Scanner;

public class Locales extends Llamadas implements Serializable {


    //VARIABLES
    int nOrigen;
    int nDestino;
    int duracion;
    double totalFacturado;

    Scanner scanner;

    protected String registrarLlamada() {

        System.out.println("NUMERO DE ORIGEN: ");
        setnOrigen(scanner.nextInt());
        System.out.println("NUMERO DE DESTINO: ");
        setnDestino(scanner.nextInt());
        System.out.println("DURACION: ");
        setDuracion(scanner.nextInt());

        return registrarLlamada();
    }

    protected String informacionLlamada() {

        String salida = "ORIGEN: " + getnOrigen() +
                "DESTINO: " + getnDestino() +
                "DURACION: " + getDuracion();
        return salida;
    }
    //CONSTRUCTOR
    public Locales(int nOrigen, int nDestino, int duracion) {
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.duracion = duracion;
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



}
