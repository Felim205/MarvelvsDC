/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.managers;

import javax.sound.sampled.*;
import java.io.InputStream;

/**
 * Clase de gestión para la reproducción de sonidos en el sistema.
 * Permite reproducir archivos de sonido almacenados en la carpeta de recursos `/sounds/`.
 * 
 * <p>Esta clase utiliza la API de `javax.sound.sampled` para manejar clips de audio.</p>
 * 
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * {@code
 * SonidoManager.playSound("efecto_sonido.wav");
 * }
 * </pre>
 * 
 * @author felipp
 */
public class SonidoManager {

     /**
     * Reproduce un archivo de sonido desde la carpeta de recursos `/sounds/`.
     * 
     * @param soundFile Nombre del archivo de sonido que se desea reproducir, incluyendo su extensión (ej. "click.wav").
     */
    public static void playSound(String soundFile) {
        try {
            // Cargar el archivo de sonido desde resources
            InputStream audioSrc = SonidoManager.class.getResourceAsStream("/sounds/" + soundFile);
            if (audioSrc == null) {
                System.err.println("❌ No se encontró el archivo: " + soundFile);
                return;
            }
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioSrc);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


