package Practica_Calculadora_Trigonometrica;

public class Menus {

    protected String menuGenerico() {

        String menu = "*** Calculadora trigonometrica *** \n" +
                "1.- Operaciones con circulos\n" +
                "2.- Operaciones con rectángulos\n" +
                "3.- Operaciones con triágunlos\n" +
                "4.- Salir\n" +
                "Introduce una opción: ";
        return menu;
    }

    protected String menuCirculo() {

        String menuCr = "*** Calculadora circulos *** \n" +
                "1.- Calcular área\n" +
                "2.- Calcular perímetro\n" +
                "3.- Calcular distancia\n" +
                "4.- Atras\n" +
                "Introduce una opción: ";

        return menuCr;
    }

    protected String menuTriangulo() {

        String menuTr = "*** Calculadora triángulos *** \n" +
                "1.- Calcular área\n" +
                "2.- Atras\n+ " +
                "Introduce una opción: ";

        return menuTr;
    }

    protected String menuRectangulo() {

        String menuRc = "*** Calculadora rectángulos *** \n" +
                "1.- Calcular área\n" +
                "2.- Calcular perímetro\n" +
                "3.- Atras\n" +
                "Introduce una opción: ";

        return menuRc;
    }

}