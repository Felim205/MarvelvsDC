/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2;

import java.util.ArrayList;
import java.util.Collection;

public class JuegoMarvelvsDC {
    // Atributos
    private String nombreJuego;
    private Collection<Usuario> usuarios;
    private Collection<Persona> personajes;
    private Collection<Cuidad> ciudades;

    // Constructor vacío
    public JuegoMarvelvsDC() {
        this.nombreJuego = "Marvel vs DC";
        this.usuarios = new ArrayList<>();
        this.personajes = new ArrayList<>();
        this.ciudades = new ArrayList<>();
    }

    // Constructor con nombre del juego
    public JuegoMarvelvsDC(String nombreJuego) {
        this.nombreJuego = nombreJuego;
        this.usuarios = new ArrayList<>();
        this.personajes = new ArrayList<>();
        this.ciudades = new ArrayList<>();
    }

    // Getters y setters
    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Collection<Persona> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Collection<Persona> personajes) {
        this.personajes = personajes;
    }

    public Collection<Cuidad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(Collection<Cuidad> ciudades) {
        this.ciudades = ciudades;
    }

    // Métodos para Usuarios
    public void registrarUsuario(Usuario usuario) {
        if (usuario != null && !usuarios.contains(usuario)) {
            usuarios.add(usuario);
            System.out.println("Usuario registrado: " + usuario);
        } else {
            System.out.println("El usuario ya está registrado o es inválido.");
        }
    }

    public void editarUsuario(Usuario usuario, String nuevoNombre, String nuevoCorreo) {
        if (usuarios.contains(usuario)) {
            usuario.setNombre(nuevoNombre);
            usuario.setCorreo(nuevoCorreo);
            System.out.println("Usuario editado: " + usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void eliminarUsuario(Usuario usuario) {
        if (usuarios.contains(usuario)) {
            usuarios.remove(usuario);
            System.out.println("Usuario eliminado: " + usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Métodos para Personajes
    public void registrarPersonaje(Persona personaje) {
        if (personaje != null && !personajes.contains(personaje)) {
            personajes.add(personaje);
            System.out.println("Personaje registrado: " + personaje);
        } else {
            System.out.println("El personaje ya está registrado o es inválido.");
        }
    }

    public void editarPersonaje(Persona personaje, String nuevoNombre) {
        if (personajes.contains(personaje)) {
            personaje.setNombre(nuevoNombre);
            System.out.println("Personaje editado: " + personaje);
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    public void eliminarPersonaje(Persona personaje) {
        if (personajes.contains(personaje)) {
            personajes.remove(personaje);
            System.out.println("Personaje eliminado: " + personaje);
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    // Métodos para Ciudades
    public void cargarCiudad(Cuidad ciudad) {
        if (ciudad != null && !ciudades.contains(ciudad)) {
            ciudades.add(ciudad);
            System.out.println("Ciudad cargada: " + ciudad);
        } else {
            System.out.println("La ciudad ya está cargada o es inválida.");
        }
    }

    public void editarCiudad(Cuidad ciudad, String nuevoEstado, String nuevoPais) {
        if (ciudades.contains(ciudad)) {
            ciudad.setEstado(nuevoEstado);
            ciudad.setPais(nuevoPais);
            System.out.println("Ciudad editada: " + ciudad);
        } else {
            System.out.println("Ciudad no encontrada.");
        }
    }

    public void agregarCiudad(Cuidad ciudad) {
        if (ciudad != null && !ciudades.contains(ciudad)) {
            ciudades.add(ciudad);
            System.out.println("Ciudad agregada: " + ciudad);
        } else {
            System.out.println("La ciudad ya existe o es inválida.");
        }
    }

    public void guardarCiudad(Cuidad ciudad) {
        if (!ciudades.contains(ciudad)) {
            ciudades.add(ciudad);
            System.out.println("Ciudad guardada: " + ciudad);
        } else {
            System.out.println("La ciudad ya estaba guardada.");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "JuegoMarvelvsDC{" +
                "nombreJuego='" + nombreJuego + '\'' +
                ", usuarios=" + usuarios +
                ", personajes=" + personajes +
                ", ciudades=" + ciudades +
                '}';
    }

    public static void main(String[] args) {
        
    }
}

