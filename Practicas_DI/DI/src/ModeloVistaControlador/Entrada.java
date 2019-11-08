package ModeloVistaControlador;


public class Entrada {

    public static void main (String [] args){
        Vista v = new Vista();
        Modelo m = new Modelo();
        Controlador c = new Controlador(v,m);
    }
}