/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;

/**
 *
 *
 */
import java.util.Collection;


public class Ranking {
    // Atributos
    private int partidasGanadas;
    private int partidasPerdidas;
    private double efectividadAtaques;
    private Collection<Partida> partidas;

    // Constructor por defecto
    public Ranking() {
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
        this.efectividadAtaques = 0.0;
    }

    // Constructor con parámetros
    public Ranking(int partidasGanadas, int partidasPerdidas, double efectividadAtaques, Collection<Partida> partidas) {
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.efectividadAtaques = efectividadAtaques;
        this.partidas = partidas;
    }

    // Métodos
    public int calcularGanadas() {
        return 2;//Impletar codigo
    }

    public int calcularPerdidas() {
        return 2;//Impletar codigo
    }

    public double calcularEfectividad() {
        return  2;//Impletar codigo
    }

    public String obtenerRankingGlobal() {
        double porcentajeVictorias = 0.0;
        if ((partidasGanadas + partidasPerdidas) > 0) {
            porcentajeVictorias = (double) partidasGanadas / (partidasGanadas + partidasPerdidas) * 100;
        }
        return String.format("Ranking Global: %.2f%%", porcentajeVictorias);
    }


    // Getters y Setters
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    public double getEfectividadAtaques() {
        return efectividadAtaques;
    }

    public void setEfectividadAtaques(double efectividadAtaques) {
        this.efectividadAtaques = efectividadAtaques;
    }

    public Collection<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(Collection<Partida> partidas) {
        this.partidas = partidas;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "partidasGanadas=" + partidasGanadas +
                ", partidasPerdidas=" + partidasPerdidas +
                ", efectividadAtaques=" + efectividadAtaques +
                ", total partidas=" + (partidas != null ? partidas.size() : 0) +
                '}';
    }
}
