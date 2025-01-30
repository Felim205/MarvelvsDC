package com.mycompany.pp2;

import com.mycompany.pp2.clases.JuegoMarvelvsDC;
import com.mycompany.pp2.managers.CiudadManager;
import com.mycompany.pp2.managers.PersonajeManager;
import com.mycompany.pp2.managers.UsuarioManager;


/**
 *
 * @author gabob
 */

public class MainMenuPantalla extends PantallaMadreMenues {
    
    /**
     * Constructor de PantallaMadreMenues
     */
    public MainMenuPantalla() {
        super();
        initComponents();
        personalizarPantalla();

        CiudadManager.inicializarCiudades();
        PersonajeManager.inicializarPersonajes();
        UsuarioManager.inicializarUsuarios();
    }

  
    
    private void personalizarPantalla() {
        // Cambiar el título de la ventana
        setTitle("Menú Principal - MARVEL VS DC");
        
        // Ocultar botones no relevantes
        MainMenuBtn.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(251, 252, 254));
        setMinimumSize(new java.awt.Dimension(931, 589));
        setPreferredSize(new java.awt.Dimension(931, 589));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BgMM.png"))); // NOI18N
        Background.setMaximumSize(new java.awt.Dimension(915, 590));
        Background.setMinimumSize(new java.awt.Dimension(915, 590));
        Background.setPreferredSize(new java.awt.Dimension(915, 590));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenuPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenuPantalla().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    // End of variables declaration//GEN-END:variables
}
