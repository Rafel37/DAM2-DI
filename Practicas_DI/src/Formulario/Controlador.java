package Formulario;

import Formulario.utils.Pais;
import Formulario.utils.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Controlador implements ActionListener, ItemListener {

    Vista objetoVista;
    ArrayList<Persona> listaPersonas = new ArrayList();
    ArrayList<Pais> paises = new ArrayList();

    public Controlador(Vista objetoVista) {
        this.objetoVista = objetoVista;
        rellenarPaises();
        acciones();
    }

    private void rellenarPaises() {

        ArrayList<String> ciudades = new ArrayList();
        ciudades.add("Madrid");
        ciudades.add("Barcelona");
        ciudades.add("Murcia");
        ciudades.add("Valencia");

        paises.add(new Pais("España", ciudades));
        for (String c: ciudades) {

            objetoVista.getBusqueda().getCiudadModel().addElement(c);
        }
        objetoVista.getBusqueda().getModeloCombo().addElement(paises);
    }

    private void acciones() {

        objetoVista.getRegistro().getAceptar().addActionListener(this);
        objetoVista.getRegistro().getLimpiar().addActionListener(this);
        objetoVista.getBusqueda().getBuscar().addActionListener(this);
        objetoVista.getBusqueda().getPaisCombo().addItemListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == objetoVista.getRegistro().getAceptar()) {

            Persona p = new Persona(objetoVista.getRegistro().getNombreField().getText(),
                    objetoVista.getRegistro().getApellido1Field().getText(),
                    objetoVista.getRegistro().getDireccionField().getText(),
                    objetoVista.getRegistro().getPuertaField().getText(),
                    objetoVista.getRegistro().getPaisField().getText(),
                    objetoVista.getRegistro().getCiudadField().getText(),
                    objetoVista.getRegistro().getFinalField().getText(),
                    objetoVista.getRegistro().getModeloTratamiento().getNumber().intValue(),
                    Integer.parseInt(objetoVista.getRegistro().getTelefonoField().getText()),
                    objetoVista.getRegistro().getModeloPago().getNumber().intValue());

            listaPersonas.add(p);
            Limpiar();
        }

        else if (e.getSource() == objetoVista.getRegistro().getLimpiar()) {

            Limpiar();
        }

        else if (e.getSource() == objetoVista.getBusqueda().getBuscar()) {

            System.out.println(listaPersonas.size());

            if (!objetoVista.getBusqueda().getNombreField().getText().isEmpty() &&
                    !objetoVista.getBusqueda().getTelefonoField().getText().isEmpty() &&
                    objetoVista.getBusqueda().getCiudadList().getSelectedIndex()!=-1) {

                objetoVista.getBusqueda().getPersonaModel().clear();

                for (Persona c : listaPersonas) {
                    if (c.getNombre().equals(objetoVista.getBusqueda().getNombreField().getText()) &&
                            c.getTelefono() == Integer.parseInt(objetoVista.getBusqueda().getTelefonoField().getText()) &&
                            c.getCiudad().equals(objetoVista.getBusqueda().getCiudadList().getSelectedValue().toString()))
                        objetoVista.getBusqueda().getPersonaModel().addElement(c);
                }
            }
            else if (!objetoVista.getBusqueda().getNombreField().getText().isEmpty() &&
                    !objetoVista.getBusqueda().getTelefonoField().getText().isEmpty()) {

                objetoVista.getBusqueda().getPersonaModel().clear();

                for (Persona c : listaPersonas) {
                    if (c.getNombre().equals(objetoVista.getBusqueda().getNombreField().getText()) &&
                            c.getTelefono() == Integer.parseInt(objetoVista.getBusqueda().getTelefonoField().getText()))
                        objetoVista.getBusqueda().getPersonaModel().addElement(c);
                }
            }
            else if (!objetoVista.getBusqueda().getNombreField().getText().isEmpty() &&
                    objetoVista.getBusqueda().getCiudadList().getSelectedIndex()!=-1) {

                objetoVista.getBusqueda().getPersonaModel().clear();

                for (Persona c : listaPersonas) {
                    if (c.getNombre().equals(objetoVista.getBusqueda().getNombreField().getText()) &&
                            c.getCiudad().equals(objetoVista.getBusqueda().getCiudadList().getSelectedValue().toString()))
                        objetoVista.getBusqueda().getPersonaModel().addElement(c);
                }
            }
            else if (!objetoVista.getBusqueda().getTelefonoField().getText().isEmpty() &&
                    objetoVista.getBusqueda().getCiudadList().getSelectedIndex()!=-1) {

                objetoVista.getBusqueda().getPersonaModel().clear();

                for (Persona c : listaPersonas) {
                    if (c.getTelefono() == Integer.parseInt(objetoVista.getBusqueda().getTelefonoField().getText()) &&
                            c.getCiudad().equals(objetoVista.getBusqueda().getCiudadList().getSelectedValue().toString()))
                        objetoVista.getBusqueda().getPersonaModel().addElement(c);
                }
            }

            else if (!objetoVista.getBusqueda().getNombreField().getText().isEmpty() ) {

                objetoVista.getBusqueda().getPersonaModel().clear();

                for (Persona c : listaPersonas) {
                    if (c.getNombre().equals(objetoVista.getBusqueda().getNombreField().getText()))
                        objetoVista.getBusqueda().getPersonaModel().addElement(c);
                }
            }
            else if (objetoVista.getBusqueda().getCiudadList().getSelectedIndex()!=-1) {

                objetoVista.getBusqueda().getPersonaModel().clear();

                for (Persona c : listaPersonas) {
                    if (c.getCiudad().equals(objetoVista.getBusqueda().getCiudadList().getSelectedValue().toString()))
                        objetoVista.getBusqueda().getPersonaModel().addElement(c);
                }
            }
            else if (!objetoVista.getBusqueda().getTelefonoField().getText().isEmpty()) {

                objetoVista.getBusqueda().getPersonaModel().clear();

                for (Persona c : listaPersonas) {
                    if (c.getTelefono() == Integer.parseInt(objetoVista.getBusqueda().getTelefonoField().getText()))
                        objetoVista.getBusqueda().getPersonaModel().addElement(c);
                }
            }




            Limpiar();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    private void Limpiar() {

        objetoVista.getRegistro().getNombreField().setText("");
        objetoVista.getRegistro().getApellido1Field().setText("");
        objetoVista.getRegistro().getDireccionField().setText("");
        objetoVista.getRegistro().getPuertaField().setText("");
        objetoVista.getRegistro().getPaisField().setText("");
        objetoVista.getRegistro().getCiudadField().setText("");
        objetoVista.getRegistro().getFinalField().setText("");
        objetoVista.getRegistro().getNumeroField().setText("");
        objetoVista.getRegistro().getModeloTratamiento().setValue(0);
        objetoVista.getRegistro().getTelefonoField().setText("");
        objetoVista.getRegistro().getModeloPago().setValue(0);
    }
}