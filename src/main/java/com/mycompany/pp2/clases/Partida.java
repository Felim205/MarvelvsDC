package com.mycompany.pp2.clases;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representa una partida en el sistema, almacenando información sobre 
 * los participantes, el número de turnos, el ganador y otros detalles.
 * <p>
 * La clase implementa {@link Serializable} para permitir la persistencia 
 * de las partidas guardadas.
 * </p>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * Partida partida = new Partida(10, "Jugador1 vs Jugador2", "Jugador1", 1, "Partida intensa");
 * System.out.println(partida.toString());
 * }
 * </pre>
 * 
 * @author gabob
 */
public class Partida implements Serializable {
    private static int contadorPartidas = 1; // Controla el ID de cada partida
    private String idPartida;
    private final String fecha; // Formato DD/MM/YYYY
    private int turnos; // Contador de turnos en la partida
    private String participantes;
    private String ganador; // Nombre del ganador de la partida
    private int rank;
    private String descripcion;

    /**
     * Constructor que inicializa una nueva partida con los valores proporcionados.
     * <p>
     * El ID de la partida se genera automáticamente de forma secuencial
     * y la fecha se establece como la fecha actual en formato "DD/MM/YYYY".
     * </p>
     *
     * @param turnos Número de turnos jugados en la partida.
     * @param participantes Lista de participantes en la partida.
     * @param ganador Nombre del ganador de la partida.
     * @param rank Ranking obtenido en la partida.
     * @param descripcion Descripción detallada de la partida.
     */
    public Partida(int turnos, String participantes, String ganador, int rank, String descripcion) {
        this.idPartida = String.format("%03d", contadorPartidas++); // Genera IDs secuenciales 001, 002, etc.
        this.fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date()); // Fecha actual formateada
        this.turnos = turnos;
        this.participantes = participantes;
        this.ganador = ganador;
        this.rank = rank;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador único de la partida.
     * 
     * @return ID de la partida en formato "001", "002", etc.
     */
    public String getIdPartida() {
        return idPartida;
    }

    /**
     * Obtiene la fecha en la que se jugó la partida.
     * 
     * @return Fecha de la partida en formato "DD/MM/YYYY".
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Obtiene la cantidad de turnos que duró la partida.
     * 
     * @return Número de turnos de la partida.
     */
    public int getTurnos() {
        return turnos;
    }

    /**
     * Establece la cantidad de turnos de la partida.
     * 
     * @param turnos Número de turnos.
     */
    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    /**
     * Obtiene la lista de participantes en la partida.
     * 
     * @return Cadena con los nombres de los participantes.
     */
    public String getParticipantes() {
        return participantes;
    }

    /**
     * Establece la lista de participantes en la partida.
     * 
     * @param participantes Nombres de los participantes.
     */
    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    /**
     * Obtiene el nombre del jugador que ganó la partida.
     * 
     * @return Nombre del ganador.
     */
    public String getGanador() {
        return ganador;
    }

    /**
     * Establece el nombre del jugador que ganó la partida.
     * 
     * @param ganador Nombre del ganador de la partida.
     */
    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    /**
     * Obtiene el ranking obtenido en la partida.
     * 
     * @return Ranking de la partida.
     */
    public int getRank() {
        return rank;
    }

    /**
     * Establece el ranking obtenido en la partida.
     * 
     * @param rank Ranking de la partida.
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Obtiene la descripción detallada de la partida.
     * 
     * @return Descripción de la partida.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece una descripción detallada de la partida.
     * 
     * @param descripcion Texto con la descripción de la partida.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

     /**
     * Devuelve una representación en cadena de la partida con su información relevante.
     *
     * @return Representación en texto de la partida con su ID, fecha, turnos, participantes y ganador.
     */
    public String toString() {
        return "Partida{" +
                "ID='" + idPartida + '\'' +
                ", Fecha='" + fecha + '\'' +
                ", Turnos=" + turnos +
                ", Participantes='" + participantes + '\'' +
                ", Ganador='" + ganador + '\'' +
                ", Rank=" + rank +
                ", Descripción='" + descripcion + '\'' +
                '}';
    }
}