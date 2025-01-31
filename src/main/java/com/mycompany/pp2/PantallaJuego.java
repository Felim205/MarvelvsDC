package com.mycompany.pp2;

import static com.mycompany.pp2.PantallaMadre.imageStretcher;
import static com.mycompany.pp2.PantallaMadre.setCustomIcon;
import com.mycompany.pp2.clases.Ciudad;
import com.mycompany.pp2.clases.Heroe;
import com.mycompany.pp2.clases.Personaje;
import com.mycompany.pp2.clases.Villano;
import com.mycompany.pp2.clases.Antiheroe;
import com.mycompany.pp2.clases.Usuario;
import com.mycompany.pp2.managers.SonidoManager;
import java.awt.Color;
import java.awt.Image;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Clase que representa la pantalla del juego.
 * @author gabob
 */
public class PantallaJuego extends PantallaMadre {
    private Usuario jugador1;
    private Usuario jugador2;
    private Personaje personaje1;
    private Personaje personaje2;
    private Ciudad ciudad;
    private Date fechaInicio;
    private int duracion;
    
    private boolean turnoJugador1 = true;

    private int ataquesJugador1 = 0;
    private int ataquesJugador2 = 0;
    /**
     * Constructor de PantallaJuego.
     * @param jugador1 Usuario del primer jugador
     * @param personaje1 Personaje seleccionado por el primer jugador
     * @param jugador2 Usuario del segundo jugador
     * @param personaje2 Personaje seleccionado por el segundo jugador
     * @param ciudad Ciudad donde se desarrolla la partida
     * @param fechaInicio Fecha de inicio de la partida
     * @param duracion Duración inicializada en 0
     */
    public PantallaJuego(Usuario jugador1, Personaje personaje1, Usuario jugador2, Personaje personaje2, Ciudad ciudad, Date fechaInicio, int duracion) {
        this.jugador1 = jugador1;
        this.personaje1 = personaje1;
        this.jugador2 = jugador2;
        this.personaje2 = personaje2;
        this.ciudad = ciudad;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;

        initComponents();
        personalizarPantalla();
        setCustomIcon(this, "images/MvDCicon.png");
        imageStretcher(ImgIzq);
        imageStretcher(ImgDer);
        imageStretcher(Vs);
        
        actualizarPantalla();
        actualizarTurno();
    }

    /**
     * Actualiza la interfaz gráfica con la información de los personajes.
     */
    private void actualizarPantalla() {
        if (personaje1 != null && personaje2 != null && ciudad != null) {
            NombreIzq.setText(personaje1.getPseudonimo());
            NombreDer.setText(personaje2.getPseudonimo());

            JugadorIzq.setText(jugador1.getUserName());
            JugadorDer.setText(jugador2.getUserName());

            Stage.setText("-" + ciudad.getCuidad() + "-");

            setImagenEscalada(ImgIzq, personaje1.getFotografia());
            setImagenEscalada(ImgDer, personaje2.getFotografia());

            int vida1 = personaje1.getVidaActual();
            int vida2 = personaje2.getVidaActual();

            ProgressBarIzq.setValue(vida1);
            ProgressBarIzq.repaint();

            ProgressBarDer.setValue(vida2);
            ProgressBarDer.repaint();
        }
    }

     /**
     * Actualiza el turno y habilita/deshabilita los botones de ataque.
     */
    private void actualizarTurno() {
        if (turnoJugador1) {
            BtnIzq.setEnabled(true);  
            BtnDer.setEnabled(false); 
        } else {
            BtnIzq.setEnabled(false); 
            BtnDer.setEnabled(true);  
        }
    }
    
    /**
    * Escala y asigna una imagen a un JLabel.
    */
   private void setImagenEscalada(JLabel label, String rutaImagen) {
       try {
           ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
           Image img = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
           label.setIcon(new ImageIcon(img));
       } catch (Exception e) {
           label.setText("Imagen no disponible");
       }
   }
    
    /**
     * Verifica si el juego ha terminado y muestra el ganador.
     */
/**
 * ✅ Verifica si el juego ha terminado y muestra la ventana de ganador con opciones.
 */
    private void verificarFinDeJuego() {
        actualizarPantalla();

        int vida1 = personaje1.getVidaActual(); 
        int vida2 = personaje2.getVidaActual(); 

        if (vida1 <= 0 || vida2 <= 0) {
            SonidoManager.playSound("victoria.wav"); // 🎵 Sonido de victoria

            String ganador = (vida1 <= 0) ? personaje2.getPseudonimo() : personaje1.getPseudonimo();
            System.out.println(ganador + " GANA LA PARTIDA! ");

            // Crear opciones personalizadas
            Object[] opciones = {"Volver a Jugar", "Volver al Menú Principal"};
            int seleccion = JOptionPane.showOptionDialog(
                this,
                ganador + " ha ganado! 🏆",
                "Fin del Juego",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0] // Opción por defecto
            );

            if (seleccion == JOptionPane.YES_OPTION) {
                reiniciarPartida(); // 🔄 Volver a jugar
            } else {
                volverAlMenu(); // 🔙 Volver al menú principal
            }
        } else {
            // 🔄 Cambiar el turno si nadie ha ganado
            turnoJugador1 = !turnoJugador1;
            actualizarTurno();
        }
    }

    /**
     * 🔄 Reinicia la partida con los mismos jugadores y personajes, restaurando la vida.
     */
    private void reiniciarPartida() {
        // 🔄 Restaurar vida de los personajes antes de reiniciar
        personaje1.setVidaActual(100);
        personaje2.setVidaActual(100);

        // 🔥 Crear una nueva instancia de la pantalla de juego
        new PantallaJuego(jugador1, personaje1, jugador2, personaje2, ciudad, new Date(), 0).setVisible(true);
        this.dispose(); // 🔥 Cerrar la pantalla actual
    }

    /**
     * 🔙 Vuelve al menú principal cerrando la partida actual.
     */
    private void volverAlMenu() {
        new MainMenuPantalla().setVisible(true); // 🔥 Asegúrate de tener esta clase creada
        this.dispose(); // 🔥 Cerrar la pantalla actual
    }
    
    /**
     * Personaliza la apariencia de la pantalla.
     */
    private void personalizarPantalla() {
        setTitle("Partida en progreso... - MARVEL VS DC");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Stage = new javax.swing.JLabel();
        Vs = new javax.swing.JLabel();
        JugadorIzq = new javax.swing.JLabel();
        NombreIzq = new javax.swing.JLabel();
        ImgIzq = new javax.swing.JLabel();
        BtnIzq = new javax.swing.JButton();
        ProgressBarIzq = new javax.swing.JProgressBar();
        JugadorDer = new javax.swing.JLabel();
        NombreDer = new javax.swing.JLabel();
        ImgDer = new javax.swing.JLabel();
        BtnDer = new javax.swing.JButton();
        ProgressBarDer = new javax.swing.JProgressBar();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(251, 252, 254));
        setMinimumSize(new java.awt.Dimension(931, 589));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Stage.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        Stage.setText("-Ciudad-");
        getContentPane().add(Stage, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        Vs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vs.png"))); // NOI18N
        getContentPane().add(Vs, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 126, 290, 290));

        JugadorIzq.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        JugadorIzq.setText("Jugador 1");
        getContentPane().add(JugadorIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        NombreIzq.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        NombreIzq.setText("Personaje 1");
        getContentPane().add(NombreIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        ImgIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/default.png"))); // NOI18N
        ImgIzq.setText("jLabel2");
        getContentPane().add(ImgIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 270, 430));

        BtnIzq.setBackground(new java.awt.Color(53, 152, 155));
        BtnIzq.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        BtnIzq.setForeground(new java.awt.Color(51, 51, 51));
        BtnIzq.setText("Atacar");
        BtnIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIzqActionPerformed(evt);
            }
        });
        getContentPane().add(BtnIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 110, 40));
        getContentPane().add(ProgressBarIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, 10));

        JugadorDer.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        JugadorDer.setText("Jugador 2");
        getContentPane().add(JugadorDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, -1, -1));

        NombreDer.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 26)); // NOI18N
        NombreDer.setText("Personaje 2");
        getContentPane().add(NombreDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, -1));

        ImgDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/default.png"))); // NOI18N
        ImgDer.setText("jLabel2");
        getContentPane().add(ImgDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 270, 430));

        BtnDer.setBackground(new java.awt.Color(227, 150, 92));
        BtnDer.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        BtnDer.setForeground(new java.awt.Color(51, 51, 51));
        BtnDer.setText("Atacar");
        BtnDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDerActionPerformed(evt);
            }
        });
        getContentPane().add(BtnDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 110, 40));
        getContentPane().add(ProgressBarDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, 10));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BgJuego.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIzqActionPerformed
        if (!turnoJugador1) return;

        personaje2.recibirAtaque(personaje1);

        ataquesJugador1++; // 📊 Incrementamos el contador de ataques del Jugador 1
        System.out.println("Ataques realizados - " + jugador1.getUserName() + ": " + ataquesJugador1);
        System.out.println("---------------------------------------------------------");

        actualizarPantalla(); 
        verificarFinDeJuego();  
    }//GEN-LAST:event_BtnIzqActionPerformed

    private void BtnDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDerActionPerformed
        if (turnoJugador1) return;

        personaje1.recibirAtaque(personaje2);

        ataquesJugador2++; // 📊 Incrementamos el contador de ataques del Jugador 2
        System.out.println("Ataques realizados - " + jugador2.getUserName() + ": " + ataquesJugador2);
        System.out.println("---------------------------------------------------------");

        actualizarPantalla(); 
        verificarFinDeJuego(); 
    }//GEN-LAST:event_BtnDerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Personaje personaje1 = new Heroe("Batman", new Date(), "Gotham", "/images/batman.png",
                Personaje.TipoPersonaje.HEROE, "Batman", "/images/batman.png", 
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC, 
                80, 70, 85, 60);

        Personaje personaje2 = new Villano("Joker", new Date(), "Gotham", "/images/joker.png",
                Personaje.TipoPersonaje.VILLANO, "Joker", "/images/joker.png", 
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC, 
                75, 65, 90, 50);

        java.awt.EventQueue.invokeLater(() -> {
            new PantallaJuego(null, personaje1, null, personaje2, null, new Date(), 0).setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton BtnDer;
    private javax.swing.JButton BtnIzq;
    private javax.swing.JLabel ImgDer;
    private javax.swing.JLabel ImgIzq;
    private javax.swing.JLabel JugadorDer;
    private javax.swing.JLabel JugadorIzq;
    private javax.swing.JLabel NombreDer;
    private javax.swing.JLabel NombreIzq;
    private javax.swing.JProgressBar ProgressBarDer;
    private javax.swing.JProgressBar ProgressBarIzq;
    private javax.swing.JLabel Stage;
    private javax.swing.JLabel Vs;
    // End of variables declaration//GEN-END:variables
}
