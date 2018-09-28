package Practica_Calculadora_Trigonometrica;
import java.util.Scanner;

public class Triangulo extends Figura{

    int base, altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo(){

    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    protected double calcularPerimetro() {
        return getBase() * 3;
    }

    protected double calcularArea(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la base del triángulo a calcular");
        base = sc.nextInt();
        System.out.println("Introduce la altura del triángulo a calcular");
        altura = sc.nextInt();
        return (this.base * this.altura)/2;
    }
}
