/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;

/**
 * Representa un anti-héroe en el sistema, extendiendo la clase {@link Personaje}.
 * <p>
 * Un anti-héroe es un tipo de personaje que no sigue los principios tradicionales de los héroes,
 * pero tampoco es un villano. Comparte características de ambos bandos y suele tener motivaciones personales.
 * </p>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * Antiheroe deadpool = new Antiheroe("Wade Wilson", new Date(), "Canadá", "/images/deadpool.png",
 *     Personaje.TipoPersonaje.ANTIHEROE, "Deadpool", "/images/deadpool.png",
 *     Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
 *     85, 80, 70, 40);
 * System.out.println(deadpool.toString());
 * }
 * </pre>
 * 
 * @author gabob
 */
import java.util.Date;

    /**
     * Constructor por defecto que inicializa un anti-héroe sin valores asignados.
     */
public class Antiheroe extends Personaje {

    
    /**
     * Constructor que inicializa un anti-héroe con los valores especificados.
     *
     * param nombre Nombre real del anti-héroe.
     * param fechaNacimiento Fecha de nacimiento del anti-héroe.
     * param paisResidencia País de residencia del anti-héroe.
     * param foto Ruta de la imagen del anti-héroe.
     * param personaje Tipo de personaje (Héroe, Villano o Anti-héroe).
     * param pseudonimo Nombre alternativo del anti-héroe.
     * param fotografia Ruta de la imagen del anti-héroe en su identidad secreta.
     * param origen Tipo de origen del anti-héroe.
     * param franquicia Franquicia a la que pertenece el anti-héroe.
     * param fuerza Nivel de fuerza del anti-héroe.
     * param velocidad Nivel de velocidad del anti-héroe.
     * param inteligencia Nivel de inteligencia del anti-héroe.
     * param recursosEconomicos Cantidad de recursos económicos del anti-héroe.
     */
    public Antiheroe() {
        super();
    }

    /**
     * Devuelve una representación en cadena del anti-héroe.
     *
     * @return Representación en texto del anti-héroe con sus atributos heredados de {@link Personaje}.
     */
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
