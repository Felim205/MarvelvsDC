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
 *
 * @author gabob
 */

public class UsuarioManager {
    private static final String ARCHIVO_USUARIOS = "usuarios.dat";
    private static final List<Usuario> listaUsuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        guardarUsuarios();
    }

    public static List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void eliminarUsuario(int indice) {
        if (indice >= 0 && indice < listaUsuarios.size()) {
            listaUsuarios.remove(indice);
            guardarUsuarios();
        }
    }

    public static void editarUsuario(int indice, Usuario usuario) {
        if (indice >= 0 && indice < listaUsuarios.size()) {
            listaUsuarios.set(indice, usuario);
            guardarUsuarios();
        }
    }

    private static void guardarUsuarios() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            out.writeObject(listaUsuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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