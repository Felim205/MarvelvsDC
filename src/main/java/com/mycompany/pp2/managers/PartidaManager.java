/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.managers;

import com.mycompany.pp2.clases.Partida;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de gestión para la administración de partidas en el sistema.
 * Permite agregar, eliminar, editar y cargar partidas desde un archivo de almacenamiento persistente.
 *
 * <p>Esta clase maneja la persistencia de las partidas utilizando serialización en archivos.</p>
 * 
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * List<Partida> partidas = PartidaManager.getListaPartidas();
 * PartidaManager.agregarPartida(new Partida(...));
 * }
 * </pre>
 *
 * @author gabob
 */
public class PartidaManager {
    /**
     * Nombre del archivo donde se almacenan las partidas.
     */
    private static final String ARCHIVO_PARTIDAS = "partidas.dat";
    
    /**
     * Lista de partidas almacenadas en el sistema.
     */
    private static final List<Partida> listaPartidas = new ArrayList<>();

    /**
     * Carga las partidas al iniciar la clase.
     */
    static {
        cargarPartidas(); // Carga las partidas al iniciar la aplicación
    }

    /**
     * Agrega una nueva partida a la lista y guarda los cambios en el archivo de almacenamiento.
     *
     * @param partida La partida que se desea agregar.
     */
    public static void agregarPartida(Partida partida) {
        List<Partida> partidas = getListaPartidas(); // Asegura que esté cargado

        // 📌 Obtener el último ID de partida registrado y generar el siguiente en orden
        int nuevoId = partidas.isEmpty() ? 1 : partidas.size() + 1;
        partida.setIdPartida(String.format("%03d", nuevoId)); // Asigna ID en formato "001", "002", etc.

        listaPartidas.add(partida);
        guardarPartidas();
    }

    /**
     * Retorna la lista actual de partidas almacenadas en el sistema.
     * Si la lista está vacía, intenta cargar las partidas desde el almacenamiento persistente.
     *
     * @return Lista de partidas registradas.
     */
    public static List<Partida> getListaPartidas() {
        if (listaPartidas.isEmpty()) {
            cargarPartidas(); // Asegura que los datos se carguen si no están en memoria
        }
        return listaPartidas;
    }

    /**
     * Elimina una partida de la lista según su índice y guarda los cambios en el archivo.
     *
     * @param indice Índice de la partida a eliminar en la lista.
     */
    public static void eliminarPartida(int indice) {
        if (indice >= 0 && indice < listaPartidas.size()) {
            listaPartidas.remove(indice);
            guardarPartidas();
        }
    }

    /**
     * Edita una partida existente en la lista y guarda los cambios en el archivo de almacenamiento.
     *
     * @param indice Índice de la partida a editar.
     * @param partida Nuevo objeto Partida con la información actualizada.
     */
    public static void editarPartida(int indice, Partida partida) {
        if (indice >= 0 && indice < listaPartidas.size()) {
            listaPartidas.set(indice, partida);
            guardarPartidas();
        }
    }

    /**
     * Guarda la lista de partidas en el archivo de almacenamiento persistente.
     */
    private static void guardarPartidas() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PARTIDAS))) {
            out.writeObject(listaPartidas);
            System.out.println("Partidas guardadas correctamente en " + ARCHIVO_PARTIDAS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga las partidas desde el archivo de almacenamiento y las almacena en la lista.
     * Si el archivo no existe o está vacío, no se realiza ninguna acción.
     */
    private static void cargarPartidas() {
        File archivo = new File(ARCHIVO_PARTIDAS);
        if (archivo.exists() && archivo.length() > 0) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_PARTIDAS))) {
                List<Partida> partidasCargadas = (List<Partida>) in.readObject();
                listaPartidas.clear(); // Evita duplicados
                listaPartidas.addAll(partidasCargadas);
                System.out.println("Partidas cargadas correctamente desde " + ARCHIVO_PARTIDAS);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se encontró el archivo de partidas o está vacío.");
        }
    }
}