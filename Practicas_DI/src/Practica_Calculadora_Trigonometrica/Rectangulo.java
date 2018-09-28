package Practica_Calculadora_Trigonometrica;

import java.util.Scanner;

public class Rectangulo extends Figura {

    int altura, anchura;

    public Rectangulo(int altura, int anchura) {
        this.altura = altura;
        this.anchura = anchura;
    }

    public Rectangulo(){

    }

    public int getAltura() {
        return altura;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    protected double calcularArea() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la altura del rectángulo a calcular");
        altura = sc.nextInt();
        System.out.println("Introduce la anchura del rectángulo a calcular");
        anchura = sc.nextInt();

        return this.altura * this.anchura;
    }
    protected double calcularPerimetro() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la altura del rectángulo a calcular");
        altura = sc.nextInt();
        System.out.println("Introduce la anchura del rectángulo a calcular");
        anchura = sc.nextInt();
        return (2*this.altura) + (2 * this.anchura);
    }
}
