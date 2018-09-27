package Pracitica_Garage;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        new Entrada().inicio();

    }

    private void inicio() {

        Scanner scanner;
        int opcion;
        Menus menu = new Menus();
        Gestion gestion = new Gestion();
        Coche coche;


        do {

            opcion = 0;
            System.out.println(menu.menuGenerico());
            scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
            String matricula;

            switch (opcion) {

                case 1:

                    coche = new Coche();

                    System.out.println("ESCRIBE UNA MARCA: ");
                    coche.setMarca(scanner.next());

                    System.out.println("ESCRIBE UN MODELO: ");
                    coche.setModelo(scanner.next());

                    System.out.println("ESCRIBE UNA MATRICULA: ");
                    coche.setModelo(scanner.next());

                    System.out.println("ESCRIBE LOS CABALLOS DEL COCHE: ");
                    coche.setMotor(new Motor(scanner.nextInt()));

                    System.out.println("ESCRIBE EL PRECIO DE LA AVERIA: ");
                    coche.setPrecioAveria(scanner.nextDouble());

                    coche.setEstadoGarage(false);

                    System.out.println(gestion.añadirCoche(coche));

                    coche = null;

                    break;

                case 2:

                    System.out.println("INTRODUCE UNA MATRICULA: ");
                    matricula = scanner.next();

                    System.out.println(gestion.entregarCoche(matricula));

                    matricula = null;

                    break;

                case 3:

                    System.out.println(gestion.listarCoche());

                    break;

                case 4:

                    System.out.println(gestion.preciosArreglos());

                    break;

                case 5:

                    System.out.println("INTRODUCE UNA MATRICULA: ");
                    matricula = scanner.next();

                    System.out.println(gestion.buscarCoche(matricula));

                    matricula = null;
                    break;

                case 6:

                    System.out.println(gestion.exportarCoches());

                    break;
            }
        }
        while (opcion != 0);

        scanner.close();
        scanner = null;
        menu = null;
        gestion = null;
        opcion = Integer.parseInt(null);

    }

}