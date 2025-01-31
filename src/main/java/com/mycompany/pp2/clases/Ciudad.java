/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;
import java.io.Serializable;


/**
 * Representa una ciudad dentro del sistema, almacenando información sobre 
 * su país, estado y tipo de escenario en el que se encuentra.
 * <p>
 * La clase implementa {@link Serializable} para permitir la persistencia 
 * de los datos de las ciudades.
 * </p>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * Ciudad metropolis = new Ciudad("Estados Unidos", "New York", "Metrópolis", Ciudad.TipoEscenario.CIUDAD);
 * System.out.println(metropolis.toString());
 * }
 * </pre>
 * 
 * @author gabob
 */
public class Ciudad implements Serializable { // Se agrega Serializable
    private static final long serialVersionUID = 1L; // Se recomienda agregar este identificador único

    // Atributos privados
    private String pais;
    private String estado;
    private String cuidad;
    private TipoEscenario escenario;
    
    /**
     * Enumeración de los diferentes tipos de escenarios disponibles para una ciudad.
     */   
    public enum TipoEscenario {
        CIUDAD("Ciudad"),
        BOSQUE("Bosque"),
        MONTAÑA("Montaña"),
        DESIERTO("Desierto"),
        PLAYA("Playa"),
        MAR("Mar");

        private final String nombre;

        /**
         * Constructor que asigna el nombre al tipo de escenario.
         *
         * @param nombre Nombre del tipo de escenario.
         */
        TipoEscenario(String nombre) {
            this.nombre = nombre;
        }

        /**
         * Obtiene el nombre descriptivo del tipo de escenario.
         * 
         * @return Nombre del escenario.
         */
        public String getNombre() {
            return nombre;
        }
    }
    
    /**
     * Constructor por defecto que inicializa una ciudad sin valores asignados.
     */
    public Ciudad() {
    }

    /**
     * Constructor que inicializa una ciudad con valores específicos.
     *
     * @param pais País en el que se encuentra la ciudad.
     * @param estado Estado o provincia en el que se encuentra la ciudad.
     * @param cuidad Nombre de la ciudad.
     * @param escenario Tipo de escenario de la ciudad.
     */
    public Ciudad(String pais, String estado, String cuidad, TipoEscenario escenario) {
        this.pais = pais;
        this.estado = estado;
        this.cuidad = cuidad;
        this.escenario = escenario;
    }

    /**
     * Obtiene el país en el que se encuentra la ciudad.
     * 
     * @return País de la ciudad.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país en el que se encuentra la ciudad.
     * 
     * @param pais País de la ciudad.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene el estado o provincia en el que se encuentra la ciudad.
     * 
     * @return Estado o provincia de la ciudad.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado o provincia en el que se encuentra la ciudad.
     * 
     * @param estado Estado o provincia de la ciudad.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el nombre de la ciudad.
     * 
     * @return Nombre de la ciudad.
     */
    public String getCuidad() {
        return cuidad;
    }

    /**
     * Establece el nombre de la ciudad.
     * 
     * @param cuidad Nombre de la ciudad.
     */
    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    /**
     * Obtiene el tipo de escenario de la ciudad.
     * 
     * @return Tipo de escenario.
     */
    public TipoEscenario getEscenario() {
        return escenario;
    }

    /**
     * Establece el tipo de escenario de la ciudad.
     * 
     * @param escenario Tipo de escenario.
     */
    public void setEscenario(TipoEscenario escenario) {
        this.escenario = escenario;
    }

    /**
     * Devuelve una representación en cadena de la ciudad con su información relevante.
     *
     * @return Representación en texto de la ciudad con su país, estado, nombre y escenario.
     */
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
