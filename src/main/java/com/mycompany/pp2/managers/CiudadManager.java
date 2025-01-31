package com.mycompany.pp2.managers;

import com.mycompany.pp2.clases.Ciudad;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de gestión para la administración de ciudades en el sistema.
 * Permite agregar, eliminar, editar y cargar ciudades desde un archivo de almacenamiento persistente.
 *
 * <p>Esta clase maneja la persistencia de las ciudades utilizando serialización en archivos.</p>
 * 
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * List<Ciudad> ciudades = CiudadManager.getListaCiudades();
 * CiudadManager.agregarCiudad(new Ciudad("España", "Madrid", "Madrid", Ciudad.TipoEscenario.CIUDAD));
 * }
 * </pre>
 *
 * @author gabob
 */
public class CiudadManager {
    /**
     * Nombre del archivo donde se almacenan las ciudades.
     */
    private static final String ARCHIVO_CIUDADES = "ciudades.dat";
    
    /**
     * Lista de ciudades almacenadas en el sistema.
     */
    private static final List<Ciudad> listaCiudades = new ArrayList<>();

    /**
     * Carga las ciudades al iniciar la clase.
     * Si el archivo está vacío, se inicializan ciudades por defecto.
     */
    static {
        cargarCiudades(); // Asegura que los datos se carguen correctamente al iniciar
        if (listaCiudades.isEmpty()) {
            inicializarCiudades(); // Si el archivo está vacío, inicializa las ciudades
        }
    }

    /**
     * Agrega una nueva ciudad a la lista y guarda los cambios en el archivo de almacenamiento.
     *
     * @param ciudad La ciudad que se desea agregar.
     */
    public static void agregarCiudad(Ciudad ciudad) {
        listaCiudades.add(ciudad);
        guardarCiudades();
    }

    /**
     * Retorna la lista actual de ciudades almacenadas en el sistema.
     * Si la lista está vacía, intenta cargar las ciudades desde el almacenamiento persistente.
     *
     * @return Lista de ciudades registradas.
     */
    public static List<Ciudad> getListaCiudades() {
        if (listaCiudades.isEmpty()) {
            cargarCiudades(); // Asegura que los datos se carguen si no han sido cargados previamente
        }
        return listaCiudades;
    }

    /**
     * Elimina una ciudad de la lista según su índice y guarda los cambios en el archivo.
     *
     * @param indice Índice de la ciudad a eliminar en la lista.
     */
    public static void eliminarCiudad(int indice) {
        if (indice >= 0 && indice < listaCiudades.size()) {
            listaCiudades.remove(indice);
            guardarCiudades();
        }
    }

    /**
     * Edita una ciudad existente en la lista y guarda los cambios en el archivo de almacenamiento.
     *
     * @param indice Índice de la ciudad a editar.
     * @param ciudad Nuevo objeto Ciudad con la información actualizada.
     */
    public static void editarCiudad(int indice, Ciudad ciudad) {
        if (indice >= 0 && indice < listaCiudades.size()) {
            listaCiudades.set(indice, ciudad);
            guardarCiudades();
        }
    }

    /**
     * Guarda la lista de ciudades en el archivo de almacenamiento persistente.
     */
    private static void guardarCiudades() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CIUDADES))) {
            out.writeObject(listaCiudades);
            System.out.println("Ciudades guardadas correctamente en " + ARCHIVO_CIUDADES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga las ciudades desde el archivo de almacenamiento y las almacena en la lista.
     * Si el archivo no existe o está vacío, no se realiza ninguna acción.
     */
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

    /**
     * Inicializa la lista de ciudades cargando los datos desde el archivo.
     * Si la lista está vacía tras la carga, se añaden ciudades predeterminadas y se guardan en el archivo.
     */
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