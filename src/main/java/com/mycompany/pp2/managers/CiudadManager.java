package com.mycompany.pp2.managers;

import com.mycompany.pp2.clases.Ciudad;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de gestión para ciudades
 */
public class CiudadManager {
    private static final String ARCHIVO_CIUDADES = "ciudades.dat";
    private static final List<Ciudad> listaCiudades = new ArrayList<>();

    static {
        cargarCiudades(); // Asegura que los datos se carguen correctamente al iniciar
        if (listaCiudades.isEmpty()) {
            inicializarCiudades(); // Si el archivo está vacío, inicializa las ciudades
        }
    }

    public static void agregarCiudad(Ciudad ciudad) {
        listaCiudades.add(ciudad);
        guardarCiudades();
    }

    public static List<Ciudad> getListaCiudades() {
        if (listaCiudades.isEmpty()) {
            cargarCiudades(); // Asegura que los datos se carguen si no han sido cargados previamente
        }
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
            System.out.println("Ciudades guardadas correctamente en " + ARCHIVO_CIUDADES);
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
                System.out.println("Ciudades cargadas correctamente desde " + ARCHIVO_CIUDADES);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se encontró el archivo de ciudades o está vacío.");
        }
    }

    public static void inicializarCiudades() {
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