/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.managers;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.io.InputStream;

public class SonidoManager {

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


