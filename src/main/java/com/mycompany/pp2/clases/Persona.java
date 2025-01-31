/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;

import java.util.Date;
import java.io.Serializable;

public class Persona implements Serializable { // Se agrega Serializable
    private static final long serialVersionUID = 1L;
    // Atributos protegidos
    protected String nombre;
    protected Date fechaNacimiento;
    protected String paisResidencia;
    protected String foto;

    // Constructor vacío
    public Persona() {
    }

    // Constructor con parámetros
    public Persona(String nombre, Date fechaNacimiento, String paisResidencia, String foto) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.paisResidencia = paisResidencia;
        this.foto = foto;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    // Método toString
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", paisResidencia='" + paisResidencia + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
