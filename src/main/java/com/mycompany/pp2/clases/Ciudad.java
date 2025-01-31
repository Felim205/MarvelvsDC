/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;
import java.io.Serializable;



public class Ciudad implements Serializable { // Se agrega Serializable
    private static final long serialVersionUID = 1L; // Se recomienda agregar este identificador único

    // Atributos privados
    private String pais;
    private String estado;
    private String ciudad;
    private TipoEscenario escenario;
    
    // Enumeración para TipoEscenario    
    public enum TipoEscenario {
        CIUDAD("Ciudad"),
        BOSQUE("Bosque"),
        MONTAÑA("Montaña"),
        DESIERTO("Desierto"),
        PLAYA("Playa"),
        MAR("Mar");

        private final String nombre;

        TipoEscenario(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }
    
    // Constructor vacío
    public Ciudad() {
    }

    // Constructor con parámetros
    public Ciudad(String pais, String estado, String ciudad, TipoEscenario escenario) {
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.escenario = escenario;
    }

    // Getters y setters
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public TipoEscenario getEscenario() {
        return escenario;
    }

    public void setEscenario(TipoEscenario escenario) {
        this.escenario = escenario;
    }

    // Método toString
    @Override
    public String toString() {
        return "Ciudad{" +
                "pais='" + pais + '\'' +
                ", estado='" + estado + '\'' +
                ", Ciudad='" + ciudad + '\'' +
                ", escenario=" + escenario +
                '}';
    }
}
