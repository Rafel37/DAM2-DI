package Practica_Alumnos;

public class Profesor {

    protected void ponerNotas (Alumno a) {

        a.getmatematicas().setCalificacionAsignatura(Math.random()*11);
        a.getlengua().setCalificacionAsignatura(Math.random()*11);
        a.getingles().setCalificacionAsignatura(Math.random()*11);
    }

    protected double calcularMedia (Alumno a) {

        return (a.getmatematicas().getCalificacionAsignatura() +
                a.getlengua().getCalificacionAsignatura() +
                a.getingles().getCalificacionAsignatura()) / 3;
    }
}