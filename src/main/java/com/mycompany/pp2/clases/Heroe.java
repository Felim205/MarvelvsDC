/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;


import java.util.Date;

import java.util.Date;
import java.util.Random;

public class Heroe extends Personaje {
    private double vida = 100; // Vida inicial
    private Random random = new Random(); // Para generar la probabilidad de esquivar

    public Heroe() {
        super();
    }

    public Heroe(String nombre, Date fechaNacimiento, String paisResidencia, String foto,
                 TipoPersonaje personaje, String pseudonimo, String fotografia, TipoOrigen origen,
                 TipoFranquicia franquicia, double fuerza, double velocidad, double inteligencia,
                 double recursosEconomicos) {
        super(nombre, fechaNacimiento, paisResidencia, foto, personaje, pseudonimo, fotografia, origen, franquicia,
                fuerza, velocidad, inteligencia, recursosEconomicos);
    }

    // Método para calcular la probabilidad de esquivar
    public boolean esquivarAtaque() {
        double probabilidadEsquivar = (getInteligencia() * getVelocidad()) / 100;
        double randomValue = random.nextDouble() * 100; // Número entre 0 y 100
        return randomValue <= probabilidadEsquivar;
    }

    // Método para recibir un ataque
    public void recibirAtaque(Personaje atacante) {
        if (!esquivarAtaque()) { // Si no esquiva el ataque
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
        return "Heroe{} " + super.toString();
    }
}
