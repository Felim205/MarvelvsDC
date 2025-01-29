/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.managers;

import com.mycompany.pp2.Usuario;
import com.mycompany.pp2.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabob
 */

public class UsuarioManager {
    private static final List<Usuario> listaUsuarios = new ArrayList<>();

    public static List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public static void editarUsuario(int indice, Usuario usuarioActualizado) {
        if (indice >= 0 && indice < listaUsuarios.size()) {
            listaUsuarios.set(indice, usuarioActualizado);
        }
    }

    public static void eliminarUsuario(int indice) {
        if (indice >= 0 && indice < listaUsuarios.size()) {
            listaUsuarios.remove(indice);
        }
    }
}