package fundamentos.utils;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AlumnoTabla {


    // se definen cada una de las propiedades que más tarde se asociarán a cada una de las columnas de la tabla
    SimpleStringProperty nombre, apellido, email;
    SimpleIntegerProperty telefono;
    SimpleBooleanProperty matriculado;

    public AlumnoTabla(String nombre, String apellido, String email, int telefono, Boolean matriculado) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.email = new SimpleStringProperty(email);
        this.telefono = new SimpleIntegerProperty(telefono);
        this.matriculado = new SimpleBooleanProperty(matriculado);
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getApellido() {
        return apellido.get();
    }

    public String getEmail() {
        return email.get();
    }

    public int getTelefono() {
        return telefono.get();
    }

    public boolean isMatriculado() {
        return matriculado.get();
    }
}
