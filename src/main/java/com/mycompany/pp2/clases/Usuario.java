/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;

import java.io.Serializable;


/**
 * Representa un usuario en el sistema. Implementa la interfaz {@link Serializable} 
 * para permitir la persistencia de los objetos de esta clase.
 * 
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * Usuario usuario = new Usuario("Gabriel", "Barrantes", "GaboBaVi",
 *     "gabbarrantes@estudiantec.cr", "password123");
 * }
 * </pre>
 *
 * @author gabob
 */
public class Usuario implements Serializable { // Se agrega Serializable
    /**
     * Identificador de versión para la serialización.
     */
    private static final long serialVersionUID = 1L;
    // Atributos privados
    private String nombre;
    private String apellidos;
    private String userName;
    private String correo;
    private String contraseña;
    
    /**
     * Constructor por defecto que inicializa los valores con cadenas vacías.
     */
    public Usuario() {
        this.nombre = "";
        this.apellidos = "";
        this.userName = "";
        this.correo = "";
        this.contraseña = "";
    }
    
    /**
     * Constructor que inicializa un usuario con los valores proporcionados.
     *
     * @param nombre Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param userName Nombre de usuario único.
     * @param correo Correo electrónico del usuario.
     * @param contraseña Contraseña del usuario.
     */
    public Usuario(String nombre, String apellidos, String userName, String correo, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.userName = userName;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    /**
     * Obtiene el nombre del usuario.
     * 
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene los apellidos del usuario.
     * 
     * @return Apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }
    
    /**
     * Obtiene el nombre de usuario único.
     * 
     * @return Nombre de usuario.
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return Correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }
    
    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return Contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }
    
    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre Nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Establece los apellidos del usuario.
     * 
     * @param apellidos Apellidos del usuario.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    /**
     * Establece el nombre de usuario único.
     * 
     * @param userName Nombre de usuario.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param correo Correo electrónico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * Establece la contraseña del usuario.
     * 
     * @param contraseña Contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    /**
     * Devuelve una representación en cadena del usuario, ocultando la contraseña por seguridad.
     *
     * @return Representación en texto del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", userName='" + userName + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña='********'" + // Por seguridad no mostramos la contraseña
                '}';
    }
}
