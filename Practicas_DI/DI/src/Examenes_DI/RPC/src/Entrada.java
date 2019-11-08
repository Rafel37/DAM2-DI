package Examenes_DI.RPC.src;


import RPC.src.Llamadas;

import java.io.File;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Scanner scanner;
        int opcion;

        File f = new File("/src/ficheros/archivo.obj");
        Menu menu = new Menu();

        do {
            opcion = 0;
            System.out.println(menu.menuGenerico());
            scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
            Locales locales;

            switch (opcion) {

                case 1:
                    do {
                        System.out.println(menu.menuRegistrarLlamada());
                        int opcionR = scanner.nextInt();
                        switch (opcionR) {
                            case 1:

                                break;
                            case 2:
                                break;
                            case 3:
                                break;


                        }
                    }
                    while (opcion != 0);
                    break;

                case 2:
                    do {
                        System.out.println(menu.menuRegistrarLlamada());
                        Llamadas llamadas = null;
                        int opcionI = scanner.nextInt();
                        switch (opcionI) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;


                        }
                    }
                    while (opcion != 0);
                    break;
                case 3:

                    break;
                case 4:
                    ObjectOutputStream exportar = null;
                    break;
                case 5:

                    break;
            }

        }
        while (opcion != 0);
        scanner.close();
        scanner = null;
        menu = null;
        opcion = Integer.parseInt(null);
    }
}
