package Practica_Alumnos;

import Practica_Alumnos.Alumno;

public class Profesor {

    public void ponerNotas (Alumno param ){
        param.matematicas = Math.random();
        param.lengua = Math.random();
        param.ingles = Math.random();
    }
    public double calcularMedia (){
        return (Alumno.matematicas + Alumno.lengua + Alumno.ingles)/3;
    }
}
