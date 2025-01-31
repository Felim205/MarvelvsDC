/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;


import java.util.Date;

public class Antiheroe extends Personaje {

    public Antiheroe() {
        super();
    }

    public Antiheroe(String nombre, Date fechaNacimiento, String paisResidencia, String foto,
                     TipoPersonaje personaje, String pseudonimo, String fotografia, TipoOrigen origen,
                     TipoFranquicia franquicia, double fuerza, double velocidad, double inteligencia,
                     double recursosEconomicos) {
        super(nombre, fechaNacimiento, paisResidencia, foto, personaje, pseudonimo, fotografia, origen, franquicia,
                fuerza, velocidad, inteligencia, recursosEconomicos);
    }

    @Override
    public String toString() {
        return "Antiheroe{} " + super.toString();
    }
}
