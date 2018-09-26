package Practica_Alumnos;

public class Alumno {



    //VARIABLES
    private Asignatura matematicas;
    private Asignatura lengua;
    private Asignatura ingles;



    //CONSTRUCTOR

    public Alumno(Asignatura matematicas, Asignatura lengua, Asignatura ingles) {
        this.matematicas = matematicas;
        this.lengua = lengua;
        this.ingles = ingles;
    }
/**
    public Practica_Alumnos.Alumno (Practica_Alumnos.Asignatura matematicas, Practica_Alumnos.Asignatura lengua, Practica_Alumnos.Asignatura ingles) {
        this.matematicas = new Practica_Alumnos.Asignatura();
        this.lengua = new Practica_Alumnos.Asignatura();
        this.ingles = new Practica_Alumnos.Asignatura();
    }
*/

    //GETTERS
    public Asignatura getmatematicas() {
        return matematicas;
    }

    public Asignatura getlengua() {
        return lengua;
    }

    public Asignatura getingles() {
        return ingles;
    }
}
