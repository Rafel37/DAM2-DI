package Pracitica_Garaje;

import java.io.Serializable;

public class Coche implements Serializable {

    //VARIABLES

    String marca;
    String modelo;
    String matricula;
    double precioAveria;
    boolean estadoGarage;

    //VARIABLE TIPO MOTOR

    Motor motor;

    //TRADUCTOR BOOLEAN

    protected String traductor() {

        if (isEstadoGarage()) {

            return "ENTREGADO";
        }
        else {
            return "PENDIENTE";
        }

    }

    //CONSTRUCTOR

    public Coche(String marca, String modelo, String matricula, double precioAveria, boolean estadoGarage, Motor motor) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precioAveria = precioAveria;
        this.estadoGarage = estadoGarage;
        this.motor = motor;
    }

    public Coche() {

    }

    //GETTER

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPrecioAveria() {
        return precioAveria;
    }

    public boolean isEstadoGarage() {
        return estadoGarage;
    }

    public Motor getMotor() {
        return motor;
    }

    //SETTER

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPrecioAveria(double precioAveria) {
        this.precioAveria = precioAveria;
    }

    public void setEstadoGarage(boolean estadoGarage) {
        this.estadoGarage = estadoGarage;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
