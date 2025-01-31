/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.clases;



import java.util.Random;
import java.util.Date;

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
    
    
    // Enumeración para Tipo de Personaje
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
    
    // Constructor vacío
    public Personaje() {
        super();
    }

    // Constructor con parámetros
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

    // Getters y setters
    public TipoPersonaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(TipoPersonaje personaje) {
        this.personaje = personaje;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

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

    public void recibirAtaque(Personaje atacante) {
        System.out.println("⚔ " + getPseudonimo() + " está recibiendo un ataque de " + atacante.getPseudonimo());

        if (!esquivarAtaque()) {
            int daño = (int) atacante.calcularAtaque();
            setVidaActual(vidaActual - daño); // ✅ Usamos `setVidaActual()` en vez de calcular manualmente

            System.out.println("🩸 Nueva vida de " + getPseudonimo() + ": " + getVidaActual());
        } else {
            System.out.println(getPseudonimo() + " esquivó el ataque!");
        }
    }
    


    // Método toString
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
