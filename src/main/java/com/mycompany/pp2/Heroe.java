/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2;



import java.util.Date;

public class Heroe extends Personaje {

    // Constructor vacío
    public Heroe() {
        super();
    }

    // Constructor con parámetros
    public Heroe(String nombre, Date fechaNacimiento, String paisResidencia, String foto,
                 TipoPersonaje personaje, String pseudonimo, String fotografia, TipoOrigen origen,
                 TipoFranquicia franquicia, double fuerza, double velocidad, double inteligencia,
                 double recursosEconomicos) {
        super(nombre, fechaNacimiento, paisResidencia, foto, personaje, pseudonimo, fotografia, origen, franquicia,
                fuerza, velocidad, inteligencia, recursosEconomicos);
    }

    // Método toString
    @Override
    public String toString() {
        return "Heroe{} " + super.toString();
    }
}
