/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2;



public class Cuidad {

    // Atributos privados
    private String pais;
    private String estado;
    private String cuidad;
    private TipoEscenario escenario;
    
    // Enumeración para TipoEscenario
    public enum TipoEscenario {
        CUIDAD,
        BOSQUE,
        MONTAÑA,
        DESIERTO
    }

    // Constructor vacío
    public Cuidad() {
    }

    // Constructor con parámetros
    public Cuidad(String pais, String estado, String cuidad, TipoEscenario escenario) {
        this.pais = pais;
        this.estado = estado;
        this.cuidad = cuidad;
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

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
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
        return "Cuidad{" +
                "pais='" + pais + '\'' +
                ", estado='" + estado + '\'' +
                ", cuidad='" + cuidad + '\'' +
                ", escenario=" + escenario +
                '}';
    }
}
