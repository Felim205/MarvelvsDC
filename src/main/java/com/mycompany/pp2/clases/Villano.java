/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;

import java.util.Date;

/**
 * Representa un villano en el sistema, extendiendo la clase {@link Personaje}.
 * Los villanos heredan todas las características de un personaje y pueden acumular daño durante una partida.
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * Villano joker = new Villano("Joker", new Date(), "Estados Unidos", "/images/joker.png",
 *     Personaje.TipoPersonaje.VILLANO, "El Guasón", "/images/joker.png",
 *     Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC,
 *     40, 75, 90, 60);
 * }
 * </pre>
 *
 * @author gabob
 */
public class Villano extends Personaje {
    /**
     * Representa el daño acumulado por el villano durante una partida.
     */
    private double dañoAcumulado = 0;

    /**
     * Constructor por defecto que inicializa un villano sin valores asignados.
     */
    public Villano() {
        super();
    }

    /**
     * Constructor que inicializa un villano con los atributos especificados.
     *
     * @param nombre            Nombre real del villano.
     * @param fechaNacimiento   Fecha de nacimiento del villano.
     * @param paisResidencia    País de residencia del villano.
     * @param foto              Ruta de la imagen del villano.
     * @param personaje         Tipo de personaje (debe ser VILLANO).
     * @param pseudonimo        Alias o nombre de supervillano.
     * @param fotografia        Ruta de la imagen del villano con su disfraz.
     * @param origen            Origen del villano (ej. META_HUMANO, ALIENIGENA).
     * @param franquicia        Franquicia a la que pertenece el villano (MARVEL, DC, etc.).
     * @param fuerza            Nivel de fuerza del villano.
     * @param velocidad         Nivel de velocidad del villano.
     * @param inteligencia      Nivel de inteligencia del villano.
     * @param recursosEconomicos Cantidad de recursos económicos del villano.
     */
    public Villano(String nombre, Date fechaNacimiento, String paisResidencia, String foto,
                   TipoPersonaje personaje, String pseudonimo, String fotografia, TipoOrigen origen,
                   TipoFranquicia franquicia, double fuerza, double velocidad, double inteligencia,
                   double recursosEconomicos) {
        super(nombre, fechaNacimiento, paisResidencia, foto, personaje, pseudonimo, fotografia, origen, franquicia,
                fuerza, velocidad, inteligencia, recursosEconomicos);
    }

    /**
     * Devuelve una representación en cadena del villano.
     *
     * @return Representación en texto del villano incluyendo los atributos heredados de {@link Personaje}.
     */
    @Override
    public String toString() {
        return "Villano{} " + super.toString();
    }
}
