/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;

/**
 * Representa el ranking de un usuario en el sistema, basado en el desempeño en partidas.
 * Incluye estadísticas de victorias, derrotas y efectividad de ataques.
 * 
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * Ranking ranking = new Ranking(5, 2, 75.0, partidas);
 * String rankingGlobal = ranking.obtenerRankingGlobal();
 * }
 * </pre>
 * 
 * @author gabob
 */
import java.util.Collection;


public class Ranking {
    // Atributos
    private int partidasGanadas;
    private int partidasPerdidas;
    private double efectividadAtaques;
    private Collection<Partida> partidas;

    /**
     * Constructor por defecto que inicializa las estadísticas en cero.
     */
    public Ranking() {
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
        this.efectividadAtaques = 0.0;
    }

    /**
     * Constructor que inicializa el ranking con valores específicos.
     *
     * @param partidasGanadas Número de partidas ganadas.
     * @param partidasPerdidas Número de partidas perdidas.
     * @param efectividadAtaques Porcentaje de efectividad en ataques.
     * @param partidas Colección de partidas registradas en el ranking.
     */
    public Ranking(int partidasGanadas, int partidasPerdidas, double efectividadAtaques, Collection<Partida> partidas) {
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.efectividadAtaques = efectividadAtaques;
        this.partidas = partidas;
    }

    /**
     * Calcula el número de partidas ganadas.
     * 
     * @return Número total de partidas ganadas.
     * @implNote Este método debe ser implementado correctamente.
     */
    public int calcularGanadas() {
        return 2;//Impletar codigo
    }

    /**
     * Calcula el número de partidas perdidas.
     * 
     * @return Número total de partidas perdidas.
     * @implNote Este método debe ser implementado correctamente.
     */
    public int calcularPerdidas() {
        return 2;//Impletar codigo
    }

    /**
     * Calcula la efectividad de los ataques en base a estadísticas de las partidas.
     * 
     * @return Porcentaje de efectividad de ataques.
     * @implNote Este método debe ser implementado correctamente.
     */
    public double calcularEfectividad() {
        return  2;//Impletar codigo
    }

    /**
     * Obtiene el ranking global del usuario basado en la relación de victorias y derrotas.
     *
     * @return Cadena con el porcentaje de victorias en formato "Ranking Global: XX.XX%".
     */
    public String obtenerRankingGlobal() {
        double porcentajeVictorias = 0.0;
        if ((partidasGanadas + partidasPerdidas) > 0) {
            porcentajeVictorias = (double) partidasGanadas / (partidasGanadas + partidasPerdidas) * 100;
        }
        return String.format("Ranking Global: %.2f%%", porcentajeVictorias);
    }


    /**
     * Obtiene el número de partidas ganadas.
     * 
     * @return Número de partidas ganadas.
     */
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    /**
     * Establece el número de partidas ganadas.
     * 
     * @param partidasGanadas Número de partidas ganadas.
     */
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    /**
     * Obtiene el número de partidas perdidas.
     * 
     * @return Número de partidas perdidas.
     */
    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    /**
     * Establece el número de partidas perdidas.
     * 
     * @param partidasPerdidas Número de partidas perdidas.
     */
    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    /**
     * Obtiene la efectividad de ataques.
     * 
     * @return Porcentaje de efectividad de ataques.
     */
    public double getEfectividadAtaques() {
        return efectividadAtaques;
    }

    /**
     * Establece la efectividad de ataques.
     * 
     * @param efectividadAtaques Porcentaje de efectividad de ataques.
     */
    public void setEfectividadAtaques(double efectividadAtaques) {
        this.efectividadAtaques = efectividadAtaques;
    }

    /**
     * Obtiene la colección de partidas asociadas a este ranking.
     * 
     * @return Colección de partidas.
     */
    public Collection<Partida> getPartidas() {
        return partidas;
    }

    /**
     * Establece la colección de partidas asociadas a este ranking.
     * 
     * @param partidas Colección de partidas.
     */
    public void setPartidas(Collection<Partida> partidas) {
        this.partidas = partidas;
    }

    /**
     * Devuelve una representación en cadena del ranking del usuario.
     *
     * @return Representación en texto del ranking con el número de partidas ganadas, perdidas y la cantidad de partidas registradas.
     */
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
