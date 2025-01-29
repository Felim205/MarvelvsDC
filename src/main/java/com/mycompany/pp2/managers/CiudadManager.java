/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.managers;

import com.mycompany.pp2.Ciudad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabob
 */


/**
 * Clase para gestionar las ciudades de manera global.
 */
public class CiudadManager {
    private static final List<Ciudad> listaCiudades = new ArrayList<>();

    /**
     * Agrega una nueva ciudad a la lista.
     * @param ciudad Objeto Ciudad a agregar.
     */
    public static void agregarCiudad(Ciudad ciudad) {
        listaCiudades.add(ciudad);
    }

    /**
     * Obtiene la lista de ciudades almacenadas.
     * @return Lista de ciudades.
     */
    public static List<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    /**
     * Elimina una ciudad por su índice en la lista.
     * @param indice Índice de la ciudad a eliminar.
     */
    public static void eliminarCiudad(int indice) {
        if (indice >= 0 && indice < listaCiudades.size()) {
            listaCiudades.remove(indice);
        }
    }

    /**
     * Modifica una ciudad en la lista.
     * @param indice Índice de la ciudad a modificar.
     * @param ciudad Nueva ciudad con datos actualizados.
     */
    public static void editarCiudad(int indice, Ciudad ciudad) {
        if (indice >= 0 && indice < listaCiudades.size()) {
            listaCiudades.set(indice, ciudad);
        }
    }
}