/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;

import java.io.Serializable;



public class Usuario implements Serializable { // Se agrega Serializable
    private static final long serialVersionUID = 1L;
    // Atributos privados
    private String nombre;
    private String apellidos;
    private String userName;
    private String correo;
    private String contraseña;
    
    // Constructor por defecto
    public Usuario() {
        this.nombre = "";
        this.apellidos = "";
        this.userName = "";
        this.correo = "";
        this.contraseña = "";
    }
    
    // Constructor con parámetros
    public Usuario(String nombre, String apellidos, String userName, String correo, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.userName = userName;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    // Método para verificar el correo
    public void verificarCorreo() {
        // Verificación básica de formato de correo electrónico
        if (correo != null && correo.contains("@") && correo.contains(".")) {
            System.out.println("Formato de correo válido");
        } else {
            System.out.println("Formato de correo inválido");
        }
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    // Método toString
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
