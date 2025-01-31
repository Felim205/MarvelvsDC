package com.mycompany.pp2.clases;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa una partida en el sistema.
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
     * Constructor de la clase Partida.
     * @param turnos Cantidad de turnos jugados en la partida.
     * @param participantes Lista de participantes en la partida.
     * @param ganador Jugador que ganó la partida.
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

    // Getters y Setters
    public String getIdPartida() {
        return idPartida;
    }

    public String getFecha() {
        return fecha;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }
    @Override
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