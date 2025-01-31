/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.managers;

import com.mycompany.pp2.clases.Ciudad;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabob
 */

public class CiudadManager {
    private static final String ARCHIVO_CIUDADES = "ciudades.dat";
    private static final List<Ciudad> listaCiudades = new ArrayList<>();

    public static void agregarCiudad(Ciudad ciudad) {
        listaCiudades.add(ciudad);
        guardarCiudades();
    }

    public static List<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    public static void eliminarCiudad(int indice) {
        if (indice >= 0 && indice < listaCiudades.size()) {
            listaCiudades.remove(indice);
            guardarCiudades();
        }
    }

    public static void editarCiudad(int indice, Ciudad ciudad) {
        if (indice >= 0 && indice < listaCiudades.size()) {
            listaCiudades.set(indice, ciudad);
            guardarCiudades();
        }
    }

    private static void guardarCiudades() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CIUDADES))) {
            out.writeObject(listaCiudades);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cargarCiudades() {
        File archivo = new File(ARCHIVO_CIUDADES);
        if (archivo.exists() && archivo.length() > 0) { 
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_CIUDADES))) {
                List<Ciudad> ciudadesCargadas = (List<Ciudad>) in.readObject();
                listaCiudades.clear(); // Evita duplicados
                listaCiudades.addAll(ciudadesCargadas);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void inicializarCiudades() {
        cargarCiudades();
        if (listaCiudades.isEmpty()) { // Solo inicializa si la lista está vacía
            listaCiudades.add(new Ciudad("Estados Unidos", "New York", "New York", Ciudad.TipoEscenario.CIUDAD));
            listaCiudades.add(new Ciudad("Latveria", "Doomstadt", "Reino de Latveria", Ciudad.TipoEscenario.MONTAÑA));
            listaCiudades.add(new Ciudad("Genosha", "Hammer Bay", "República de Genosha", Ciudad.TipoEscenario.CIUDAD));
            listaCiudades.add(new Ciudad("Estados Unidos", "New Jersey", "Gotham", Ciudad.TipoEscenario.CIUDAD));
            listaCiudades.add(new Ciudad("Estados Unidos", "New York", "Metrópolis", Ciudad.TipoEscenario.CIUDAD));
            listaCiudades.add(new Ciudad("Estados Unidos", "California", "Jump City", Ciudad.TipoEscenario.CIUDAD));
            listaCiudades.add(new Ciudad("Estados Unidos", "Kansas", "Central City", Ciudad.TipoEscenario.CIUDAD));
            listaCiudades.add(new Ciudad("Estados Unidos", "California", "Los Angeles", Ciudad.TipoEscenario.CIUDAD));
            listaCiudades.add(new Ciudad("Asgard", "Desconocido", "Asgard", Ciudad.TipoEscenario.MONTAÑA));
            listaCiudades.add(new Ciudad("Japón", "Tokyo", "Tokyo", Ciudad.TipoEscenario.CIUDAD));
            listaCiudades.add(new Ciudad("Europa del Este", "Desconocido", "Sokovia", Ciudad.TipoEscenario.CIUDAD));
            listaCiudades.add(new Ciudad("Estados Unidos", "Texas", "Dallas", Ciudad.TipoEscenario.CIUDAD));
            guardarCiudades();
        }
    }
}