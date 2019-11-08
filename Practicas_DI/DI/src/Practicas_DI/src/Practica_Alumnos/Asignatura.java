package Practica_Alumnos;

public class Asignatura {




    //VARIABLES
    private int nombreAsignatura;
    private double calificacionAsignatura;




    //CONSTRUCTOR
    public Asignatura(int nombreAsignatura) {

        this.nombreAsignatura = nombreAsignatura;
    }




    //GETTERS
    public int getNombreAsignatura() {
        return nombreAsignatura;
    }

    public double getCalificacionAsignatura() {
        return calificacionAsignatura;
    }



    //SETTERS
    public void setCalificacionAsignatura(double calificacionAsignatura) {
        this.calificacionAsignatura = calificacionAsignatura;
    }
}
