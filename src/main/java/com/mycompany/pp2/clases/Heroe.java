/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;

import java.util.Date;

/**
 * Representa un héroe en el sistema, extendiendo la clase {@link Personaje}.
 * <p>
 * Un héroe es un tipo de personaje con atributos específicos como fuerza, 
 * velocidad, inteligencia y recursos económicos.
 * </p>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * Heroe superman = new Heroe("Clark Kent", new Date(), "Estados Unidos", "/images/superman.png",
 *     Personaje.TipoPersonaje.HEROE, "Superman", "/images/superman.png",
 *     Personaje.TipoOrigen.ALIENIGENA, Personaje.TipoFranquicia.DC,
 *     100, 95, 65, 15);
 * System.out.println(superman.toString());
 * }
 * </pre>
 * 
 * @author gabob
 */
public class Heroe extends Personaje {
    
    /**
     * Constructor por defecto que inicializa un héroe sin valores definidos.
     */
    public Heroe() {
        super();
    }

    /**
     * Constructor que inicializa un héroe con los valores especificados.
     *
     * @param nombre Nombre real del héroe.
     * @param fechaNacimiento Fecha de nacimiento del héroe.
     * @param paisResidencia País de residencia del héroe.
     * @param foto Ruta de la imagen del héroe.
     * @param personaje Tipo de personaje (Héroe, Villano o Anti-héroe).
     * @param pseudonimo Nombre alternativo del héroe.
     * @param fotografia Ruta de la imagen del héroe en su identidad secreta.
     * @param origen Tipo de origen del héroe.
     * @param franquicia Franquicia a la que pertenece el héroe.
     * @param fuerza Nivel de fuerza del héroe.
     * @param velocidad Nivel de velocidad del héroe.
     * @param inteligencia Nivel de inteligencia del héroe.
     * @param recursosEconomicos Cantidad de recursos económicos del héroe.
     */
    public Heroe(String nombre, Date fechaNacimiento, String paisResidencia, String foto,
                 TipoPersonaje personaje, String pseudonimo, String fotografia, TipoOrigen origen,
                 TipoFranquicia franquicia, double fuerza, double velocidad, double inteligencia,
                 double recursosEconomicos) {
        super(nombre, fechaNacimiento, paisResidencia, foto, personaje, pseudonimo, fotografia, origen, franquicia,
                fuerza, velocidad, inteligencia, recursosEconomicos);
    }

    /**
     * Devuelve una representación en cadena del héroe.
     *
     * @return Representación en texto del héroe con sus atributos heredados de {@link Personaje}.
     */
    @Override
    public String toString() {
        return "Heroe{} " + super.toString();
    }
}
