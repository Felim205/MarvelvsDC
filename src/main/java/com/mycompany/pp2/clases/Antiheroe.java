/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;


import java.util.Date;
import java.util.Random;

public class Antiheroe extends Personaje {
    private double vida = 100;
    private Random random = new Random();

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

    public boolean esquivarAtaque() {
        double probabilidadEsquivar = (getInteligencia() * getVelocidad()) / 100;
        double randomValue = random.nextDouble() * 100;
        return randomValue <= probabilidadEsquivar;
    }

    public void recibirAtaque(Personaje atacante) {
        if (!esquivarAtaque()) {
            double daño = atacante.calcularAtaque();
            vida -= daño;
            if (vida < 0) vida = 0;
        }
    }

    public int getVidaPorcentaje() {
        return (int) vida;
    }

    public double getVida() {
        return vida;
    }

    @Override
    public String toString() {
        return "Antiheroe{} " + super.toString();
    }
}
