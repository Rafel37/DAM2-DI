package Formulario.utils;

public class Persona {

    String nombre, apellido1, direccion, puerta, pais, ciudad, comentario;
    int tratamiento, telefono, pago;

    @Override
    public String toString() {
        return getNombre();
    }

    public Persona(String nombre, String apellido1, String direccion, String puerta, String pais,
                   String ciudad, String comentario, int tratamiento, int telefono, int pago) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.direccion = direccion;
        this.puerta = puerta;
        this.pais = pais;
        this.ciudad = ciudad;
        this.comentario = comentario;
        this.tratamiento = tratamiento;
        this.telefono = telefono;
        this.pago = pago;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPuerta() {
        return puerta;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getComentario() {
        return comentario;
    }

    public int getTratamiento() {
        return tratamiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getPago() {
        return pago;
    }
}