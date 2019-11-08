package Practicas;

import java.lang.*;
import java.util.List;

public class Palabra extends Thread {

    String palabra;
    Palabra(List<String> linea) {}
    Palabra(String pal) {

        palabra = pal;
    }

    public void run() {
        boolean palindromo = true;
        int i = 0;
        int j = palabra.length() - 1;
        while(palindromo && i < j) {
            if(palabra.charAt(i) == palabra.charAt(j)) {
                ++i;
                --j;
            }
            else
                palindromo = false;
        }
        if(palindromo)
            System.out.println("La palabra " + palabra + " es un palindromo.");
        else
            System.out.println("La palabra " + palabra + " no es un palindromo.");
    }
}