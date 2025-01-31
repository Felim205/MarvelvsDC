package com.mycompany.pp2.managers;

import com.mycompany.pp2.clases.Partida;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de gestión para partidas.
 */
public class PartidaManager {
    private static final String ARCHIVO_PARTIDAS = "partidas.dat";
    private static final List<Partida> listaPartidas = new ArrayList<>();

    static {
        cargarPartidas(); // Carga las partidas al iniciar la aplicación
    }

    public static void agregarPartida(Partida partida) {
        listaPartidas.add(partida);
        guardarPartidas();
    }

    public static List<Partida> getListaPartidas() {
        if (listaPartidas.isEmpty()) {
            cargarPartidas(); // Asegura que los datos se carguen si no están en memoria
        }
        return listaPartidas;
    }

    public static void eliminarPartida(int indice) {
        if (indice >= 0 && indice < listaPartidas.size()) {
            listaPartidas.remove(indice);
            guardarPartidas();
        }
    }

    public static void editarPartida(int indice, Partida partida) {
        if (indice >= 0 && indice < listaPartidas.size()) {
            listaPartidas.set(indice, partida);
            guardarPartidas();
        }
    }

    private static void guardarPartidas() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PARTIDAS))) {
            out.writeObject(listaPartidas);
            System.out.println("Partidas guardadas correctamente en " + ARCHIVO_PARTIDAS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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