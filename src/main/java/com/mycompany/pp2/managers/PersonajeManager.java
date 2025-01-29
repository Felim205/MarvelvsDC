/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.managers;

import com.mycompany.pp2.Personaje;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabob
 */

public class PersonajeManager {
    private static final List<Personaje> listaPersonajes = new ArrayList<>();

    public static void agregarPersonaje(Personaje personaje) {
        listaPersonajes.add(personaje);
    }

    public static List<Personaje> getListaPersonajes() {
        return listaPersonajes;
    }

    public static void editarPersonaje(int indice, Personaje personajeActualizado) {
        if (indice >= 0 && indice < listaPersonajes.size()) {
            listaPersonajes.set(indice, personajeActualizado);
        }
    }

    public static void eliminarPersonaje(int indice) {
        if (indice >= 0 && indice < listaPersonajes.size()) {
            listaPersonajes.remove(indice);
        }
    }
}