/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;

import java.util.Date;
import java.io.Serializable;

/**
 * Representa una persona en el sistema, proporcionando atributos básicos como nombre,
 * fecha de nacimiento, país de residencia y una imagen asociada.
 * <p>
 * Implementa la interfaz {@link Serializable} para permitir la persistencia de datos.
 * </p>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * Persona persona = new Persona("Bruce Wayne", new Date(), "Estados Unidos", "/images/batman.png");
 * System.out.println(persona.getNombre());
 * }
 * </pre>
 * 
 * @author gabob
 */
public class Persona implements Serializable { // Se agrega Serializable
    
    /**
     * Identificador de versión para la serialización.
     */
    private static final long serialVersionUID = 1L;
    // Atributos protegidos
    protected String nombre;
    protected Date fechaNacimiento;
    protected String paisResidencia;
    protected String foto;

    /**
     * Constructor que inicializa una persona con los valores especificados.
     *
     * @param nombre Nombre de la persona.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     * @param paisResidencia País de residencia de la persona.
     * @param foto Ruta de la imagen asociada a la persona.
     */
    public Persona() {
    }

    // Constructor con parámetros
    public Persona(String nombre, Date fechaNacimiento, String paisResidencia, String foto) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.paisResidencia = paisResidencia;
        this.foto = foto;
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
        
    }
    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre Nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la fecha de nacimiento de la persona.
     * 
     * @return Fecha de nacimiento.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * 
     * @param fechaNacimiento Fecha de nacimiento.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el país de residencia de la persona.
     * 
     * @return País de residencia.
     */
    public String getPaisResidencia() {
        return paisResidencia;
    }

    /**
     * Establece el país de residencia de la persona.
     * 
     * @param paisResidencia País de residencia.
     */
    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    /**
     * Obtiene la ruta de la imagen asociada a la persona.
     * 
     * @return Ruta de la imagen.
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Establece la ruta de la imagen asociada a la persona.
     * 
     * @param foto Ruta de la imagen.
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Devuelve una representación en cadena de la persona.
     * 
     * @return Cadena con los atributos de la persona.
     */
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
