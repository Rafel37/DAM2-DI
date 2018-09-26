package Pracitica_Garage;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.Enumeration;
import java.util.Hashtable;

public class Gestion {

    Hashtable<String, Coche> listaCoches = new Hashtable<>();
    double totalCobrado = 0;

    // OPCION 1.- Añadir coche

    protected String añadirCoche (Coche c) {

        if (listaCoches.get(c.getMatricula()) != null) {
            return "ESTE COCHE YA ESTA REGISTRADO";
        }
        else {
            listaCoches.put(c.getMatricula(), c);
            return "ESTE COCHE HA SIDO REGISTRADO CON EXITO";
        }
    }

    // OPCION 2.- Entregar coche

    protected String entregarCoche (String matricula) {

        if (listaCoches.get(matricula) == null) {
            return "ESTE COCHE NO ESTA REGISTRADO";
        }
        else {
            listaCoches.get(matricula).setEstadoGarage(true);
            totalCobrado += listaCoches.get(matricula).getPrecioAveria();
            listaCoches.get(matricula).setPrecioAveria(0);
            return "COCHE ENTREGADO CON EXITO";
        }


    }

    // OPCION3.- Listar coche

    protected String listarCoche (String marca, String modelo, String matricula, Motor cv, double estado) {

        if (listaCoches.get(matricula) == null) {
            return "EL LISTADO DE COCHES ESTA VACIO";
        }
        else {
            Enumeration<Coche> Listado;
            String salida = "MARCA: " + marca + "\n" +
                    "MODELO: " + modelo + "\n" +
                    "MATRICULA: " + matricula + "\n" +
                    "CV: " + cv  + "\n" +
                    "ESTADO: " + estado + "\n";
            return salida;
        }
    }

    // OPCION 4.- Mostrar precios arreglos

    // OPCION 5.- Buscar coche

    // OPCION 6.- Exportar coches

    // OPCION 0.- Salir

}
