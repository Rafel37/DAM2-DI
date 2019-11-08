package Practica_Alumnos;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        new Entrada().inicio();

    }

    private void inicio() {

        // VARIABLE PARA EL SWITCH
        int opcion;
        Scanner scanner;
        Menu menu = new Menu();

        //VARIABLES PARA TRABAJAR CON ELLAS
        Asignatura a1=null, a2=null, a3=null;
        Alumno alumno=null;
        Profesor profesor = new Profesor();

        do {
            opcion = 0;
            scanner = new Scanner(System.in);
            System.out.println(menu.menuGenerico());

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("INTRODUCE ID DE LA PRIMERA MATERIA: ");
                    a1 = new Asignatura(scanner.nextInt());

                    System.out.println("INTRODUCE ID DE LA SEGUNDA MATERIA: ");
                    a2 = new Asignatura(scanner.nextInt());

                    System.out.println("INTRODUCE ID DE LA TERCERA MATERIA: ");
                    a3 = new Asignatura(scanner.nextInt());

                    System.out.println("ASIGNATURAS REGISTRADAS CON EXITO");

                    break;

                case 2:

                    alumno = new Alumno(a1, a2, a3);
                    System.out.println("ALUMNO REGISTRADO CON EXITO");

                    break;

                case 3:

                    profesor.ponerNotas(alumno);

                    System.out.println("LA MEDIA DEL ALUMNO ES: " + profesor.calcularMedia(alumno));

                    break;
            }
        }

        while (opcion!=0);

        scanner.close();
        scanner=null;

        a1=null;
        a2=null;
        a3=null;

        alumno=null;
        profesor=null;
        menu=null;
    }
}