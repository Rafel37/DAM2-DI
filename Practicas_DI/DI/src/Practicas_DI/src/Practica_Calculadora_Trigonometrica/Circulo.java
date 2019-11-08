package Practica_Calculadora_Trigonometrica;
import java.util.Scanner;

public class Circulo extends Figura {

    int x,y;
    double radio;

    public Circulo(){

    }

    public Circulo(int x, int y, double radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }

    public Circulo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getRadio() {
        return radio;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    protected double calcularPerimetro() {
        return (2 * Math.PI) * getRadio();
    }

    protected double calcularArea(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el radio del circulo a calcular");
        this.radio = sc.nextDouble();
        return Math.PI * Math.pow(this.radio,2);

    }
    protected double calcularDiametro(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el radio del circulo a calcular");
        this.radio = sc.nextDouble();
        return 2*this.radio;

    }

    protected int calcularDistancia(Circulo circulo){

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce posición x del circulo 2");
        this.x = sc.nextInt();
        System.out.println("Introduce posición y del circulo 2");
        this.y = sc.nextInt();
        int max,min;

        if (this.x > circulo.getX()){
            max = this.x;
            min = circulo.getX();
        }
        else {
            max = circulo.getX();
            min = this.x;

        }

        return max - min;

    }
}
