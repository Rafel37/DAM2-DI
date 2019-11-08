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

    public Alumno(int matematicas, int lengua, int ingles) {
        this.matematicas = new Asignatura(matematicas);
        this.lengua = new Asignatura(lengua);
        this.ingles = new Asignatura(ingles);
    }


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
