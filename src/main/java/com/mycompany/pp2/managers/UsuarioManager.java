/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.managers;

import com.mycompany.pp2.clases.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de gestión para la administración de usuarios en el sistema.
 * Permite agregar, eliminar, editar y cargar usuarios desde un archivo de almacenamiento persistente.
 * 
 * @author gabob
 */
public class UsuarioManager {
     /**
     * Nombre del archivo donde se almacenan los usuarios.
     */
    private static final String ARCHIVO_USUARIOS = "usuarios.dat";
     /**
     * Lista de usuarios almacenados en el sistema.
     */
    private static final List<Usuario> listaUsuarios = new ArrayList<>();
    
    /**
     * Agrega un nuevo usuario a la lista y guarda los cambios en el archivo de almacenamiento.
     *
     * @param usuario El usuario que se desea agregar.
     */
    public static void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        guardarUsuarios();
    }
    
    /**
     * Retorna la lista actual de usuarios almacenados en el sistema.
     *
     * @return Lista de usuarios registrados.
     */
    public static List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

     /**
     * Elimina un usuario de la lista según su índice y guarda los cambios en el archivo.
     *
     * @param indice Índice del usuario a eliminar en la lista.
     */
    public static void eliminarUsuario(int indice) {
        if (indice >= 0 && indice < listaUsuarios.size()) {
            listaUsuarios.remove(indice);
            guardarUsuarios();
        }
    }

     /**
     * Edita un usuario existente en la lista y guarda los cambios en el archivo de almacenamiento.
     *
     * @param indice Índice del usuario a editar.
     * @param usuario Nuevo objeto Usuario con la información actualizada.
     */
    public static void editarUsuario(int indice, Usuario usuario) {
        if (indice >= 0 && indice < listaUsuarios.size()) {
            listaUsuarios.set(indice, usuario);
            guardarUsuarios();
        }
    }

     /**
     * Guarda la lista de usuarios en el archivo de almacenamiento persistente.
     */
    private static void guardarUsuarios() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            out.writeObject(listaUsuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /**
     * Carga los usuarios desde el archivo de almacenamiento y los almacena en la lista.
     * Si el archivo no existe o está vacío, no se realiza ninguna acción.
     */
    private static void cargarUsuarios() {
        File archivo = new File(ARCHIVO_USUARIOS);
        if (archivo.exists() && archivo.length() > 0) { 
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS))) {
                List<Usuario> usuariosCargados = (List<Usuario>) in.readObject();
                listaUsuarios.clear(); // Evitar duplicados
                listaUsuarios.addAll(usuariosCargados);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

     /**
     * Inicializa la lista de usuarios cargando los datos desde el archivo.
     * Si la lista está vacía tras la carga, se añaden usuarios predeterminados y se guardan en el archivo.
     */
    public static void inicializarUsuarios() {
        cargarUsuarios();
        if (listaUsuarios.isEmpty()) { // Solo inicializa si la lista está vacía
            listaUsuarios.add(new Usuario(
                "Gabriel", "Barrantes Villalobos", "GaboBaVi",
                "gabbarrantes@estudiantec.cr", "estoesprivado!!!"
                ));
                listaUsuarios.add(new Usuario(
                "Felipe Javier", "Murillo Chaves", "Falopp",
                "falopp@outlook.com", "contraseña1234"
                ));
                listaUsuarios.add(new Usuario(
                "Daniela Maria", "Sanchez Acuña", "Gatoniela",
                "danielasanchez@outlook.com", "contraseña1234"
                ));
            guardarUsuarios();
        }
    }
}