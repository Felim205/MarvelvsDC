/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;



import com.mycompany.pp2.managers.SonidoManager;
import java.util.Random;
import java.util.Date;

/**
 * Representa un personaje en el sistema, heredando de la clase {@link Persona}.
 * Incluye atributos como fuerza, velocidad, inteligencia y recursos económicos,
 * así como métodos para calcular su poder total y manejar interacciones de combate.
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * Personaje spiderman = new Personaje("Peter Parker", new Date(), "Estados Unidos", "/images/spiderman.png",
 *     Personaje.TipoPersonaje.HEROE, "Spider-Man", "/images/spiderman.png",
 *     Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
 *     90, 85, 85, 5);
 * }
 * </pre>
 * 
 * @author gabob
 */
public class Personaje extends Persona {
    
    // Atributos específicos de Personaje
    protected TipoPersonaje personaje;
    protected String pseudonimo;
    protected String fotografia;
    protected TipoOrigen origen;
    protected TipoFranquicia franquicia;

    protected double fuerza;
    protected double velocidad;
    protected double inteligencia;
    protected double recursosEconomicos;
    
    private int vidaActual = 100;
    
    
    // Enumeraciones de tipos de personaje, origen y franquicia
    /**
     * Tipos de personaje disponibles.
     */
    public enum TipoPersonaje {
        HEROE("Héroe"),
        ANTIHEROE("Anti-Héroe"),
        VILLANO("Villano");

        private final String nombre;

        TipoPersonaje(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }

     // Enumeración para el Origen del Personaje
    /**
     * Tipos de origen disponibles.
     */
    public enum TipoOrigen {
        ALIENIGENA("Alienígena"),
        MUTANTE("Mutante"),
        META_HUMANO("Meta-Humano");

        private final String nombre;

        TipoOrigen(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }


    // Enumeración para la Franquicia
    /**
     * Tipos de franquicia disponibles.
     */
    public enum TipoFranquicia {
        MARVEL("Marvel"),
        DC("DC"),
        NINGUNA("Ninguna");

        private final String nombre;

        TipoFranquicia(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }
    
    /**
     * Constructor vacío que inicializa un personaje sin valores definidos.
     */
    public Personaje() {
        super();
    }

    /**
     * Constructor que inicializa un personaje con valores específicos.
     *
     * @param nombre Nombre real del personaje.
     * @param fechaNacimiento Fecha de nacimiento del personaje.
     * @param paisResidencia País de residencia del personaje.
     * @param foto Ruta de la imagen del personaje.
     * @param personaje Tipo de personaje (Héroe, Villano o Anti-héroe).
     * @param pseudonimo Nombre alternativo del personaje.
     * @param fotografia Ruta de la imagen del personaje con su identidad secreta.
     * @param origen Tipo de origen del personaje.
     * @param franquicia Franquicia a la que pertenece el personaje.
     * @param fuerza Nivel de fuerza del personaje.
     * @param velocidad Nivel de velocidad del personaje.
     * @param inteligencia Nivel de inteligencia del personaje.
     * @param recursosEconomicos Cantidad de recursos económicos del personaje.
     */
    public Personaje(String nombre, Date fechaNacimiento, String paisResidencia, String foto,
                     TipoPersonaje personaje, String pseudonimo, String fotografia, TipoOrigen origen,
                     TipoFranquicia franquicia, double fuerza, double velocidad, double inteligencia,
                     double recursosEconomicos) {
        super(nombre, fechaNacimiento, paisResidencia, foto);
        this.personaje = personaje;
        this.pseudonimo = pseudonimo;
        this.fotografia = fotografia;
        this.origen = origen;
        this.franquicia = franquicia;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.inteligencia = inteligencia;
        this.recursosEconomicos = recursosEconomicos;
    }

    /**
     * Calcula el poder total del personaje basado en sus atributos principales.
     * 
     * @return Un valor entero representando el poder total.
     */
    public TipoPersonaje getPersonaje() {
        return personaje;
    }

    /**
     * Calcula el daño de ataque del personaje en función de su fuerza y recursos económicos.
     * 
     * @return Cantidad de daño infligido en un ataque.
     */
    public void setPersonaje(TipoPersonaje personaje) {
        this.personaje = personaje;
    }

    /**
     * Determina si el personaje logra esquivar un ataque basándose en su inteligencia y velocidad.
     * 
     * @return {@code true} si el personaje esquiva el ataque, {@code false} en caso contrario.
     */
    public String getPseudonimo() {
        return pseudonimo;
    }

    /**
     * Obtiene la vida actual del personaje.
     * 
     * @return Vida actual del personaje (0 - 100).
     */
    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    /**
     * Establece la vida actual del personaje, asegurando que no sea menor a 0 ni mayor a 100.
     * 
     * @param nuevaVida Nueva cantidad de vida.
     */
    public String getFotografia() {
        return fotografia;
    }

 
    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    
    public TipoOrigen getOrigen() {
        return origen;
    }

    public void setOrigen(TipoOrigen origen) {
        this.origen = origen;
    }

    public TipoFranquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(TipoFranquicia franquicia) {
        this.franquicia = franquicia;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(double inteligencia) {
        this.inteligencia = inteligencia;
    }

    public double getRecursosEconomicos() {
        return recursosEconomicos;
    }

    public void setRecursosEconomicos(double recursosEconomicos) {
        this.recursosEconomicos = recursosEconomicos;
    }

    // Método para calcular el poder total
    public int poderTotal() {
        return (int) ((fuerza + velocidad + inteligencia + recursosEconomicos) / 4);
    }

    // Método para calcular el daño de ataque
    public double calcularAtaque() {
        return (getFuerza() * getRecursosEconomicos()) / 100;
    }
    
    public boolean esquivarAtaque() {
        Random random = new Random();
        double probabilidadEsquivar = ((getInteligencia() * getVelocidad()) / 100)/2;
        double randomValue = random.nextDouble() * 100; // Número entre 0 y 100
        return randomValue <= probabilidadEsquivar;
    }
    
    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int nuevaVida) {
        if (nuevaVida < 0) {
            vidaActual = 0;
        } else if (nuevaVida > 100) {
            vidaActual = 100;
        } else {
            vidaActual = nuevaVida;
        }
    }

     /**
     * Maneja la recepción de un ataque por parte del personaje.
     * Si el ataque no es esquivado, se reduce la vida del personaje.
     *
     * @param atacante Personaje que realiza el ataque.
     * @param historialPartida Historial donde se almacena la información del combate.
     */
    public void recibirAtaque(Personaje atacante, StringBuilder historialPartida) {
        System.out.println(getPseudonimo() + " recibió un ataque de " + atacante.getPseudonimo());
        historialPartida.append(getPseudonimo())
                        .append(" recibió un ataque de ")
                        .append(atacante.getPseudonimo())
                        .append("\n");

        System.out.println(" ");
        historialPartida.append("\n");

        if (!esquivarAtaque()) {
            int daño = (int) atacante.calcularAtaque();
            setVidaActual(vidaActual - daño);

            System.out.println("La vida de " + getPseudonimo() + " es : " + getVidaActual());
            historialPartida.append("La vida de ").append(getPseudonimo()).append(" es : ").append(getVidaActual()).append("\n");

            System.out.println("-----------------------------------------");
            historialPartida.append("-----------------------------------------\n");

            SonidoManager.playSound("ataque.wav");
        } else {
            System.out.println("---------------------------------------------------------");
            System.out.println(getPseudonimo() + " esquivó el ataque!");
            historialPartida.append(getPseudonimo()).append(" esquivó el ataque!\n");

            System.out.println(" ");
            historialPartida.append("\n");

            SonidoManager.playSound("Miss.wav");
        }
    }

    /**
     * Devuelve una representación en cadena del personaje.
     *
     * @return Representación en texto del personaje y sus atributos.
     */
    @Override
    public String toString() {
        return "Personaje{" +
                "personaje=" + personaje +
                ", pseudonimo='" + pseudonimo + '\'' +
                ", fotografia='" + fotografia + '\'' +
                ", origen=" + origen +
                ", franquicia=" + franquicia +
                ", fuerza=" + fuerza +
                ", velocidad=" + velocidad +
                ", inteligencia=" + inteligencia +
                ", recursosEconomicos=" + recursosEconomicos +
                ", poderTotal=" + poderTotal() +
                "} " + super.toString();
    }
}
