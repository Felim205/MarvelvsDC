package com.mycompany.pp2;

import java.util.regex.Pattern;

/**
 *
 * @author gabob
 */
public class PantallaMadreMenues extends PantallaMadre {

    /**
     * Constructor de PantallaMadreMenues
     */
    public PantallaMadreMenues() {
        super();
        initComponents();
    }
    
    /**
     * Permite a la GUI abrir la pantalla MainMenu, cerrando la pantalla pasada
     */    
    protected void abrirMainMenuPantalla() {
        MainMenuBtn.setEnabled(false);
        MainMenuPantalla pantalla = new MainMenuPantalla();
        pantalla.setVisible(true);
        this.dispose();
    }
    
    /**
     * Permite a la GUI abrir la pantalla Mi Ciudad, cerrando la pantalla pasada
     */   
    protected void abrirCiudadesPantalla() {
        CiudadesBtn.setEnabled(false);
        CiudadPantalla pantalla = new CiudadPantalla();
        pantalla.setVisible(true);
        this.dispose();
    }

    /**
     * Permite a la GUI abrir la pantalla Partida, cerrando la pantalla pasada
     */       
    protected void abrirPartidaPantalla() {
        PartidaBtn.setEnabled(false);
        PartidaPantalla pantalla = new PartidaPantalla();
        pantalla.setVisible(true);
        this.dispose();
    }

     /**
     * Permite a la GUI abrir la pantalla Mis Personajes, cerrando la pantalla pasada
     */   
    protected void abrirPersonajesPantalla() {
        PersonajesBtn.setEnabled(false);
        PersonajesPantalla pantalla = new PersonajesPantalla();
        pantalla.setVisible(true);
        this.dispose();
    }
    
    /**
     * Permite a la GUI abrir la pantalla Rankings, cerrándo la pantalla pasada
     */   
    protected void abrirRankingsPantalla() {
        RankingsBtn.setEnabled(false);
        RankingsPantalla pantalla = new RankingsPantalla();
        pantalla.setVisible(true);
        this.dispose();
    }
    
    /**
     * Permite a la GUI abrir la pantalla Usuarios, cerrándo la pantalla pasada
     */   
    protected void abrirUsuariosPantalla() {
        UsuariosBtn.setEnabled(false);
        UsuariosPantalla pantalla = new UsuariosPantalla();
        pantalla.setVisible(true);
        this.dispose();
    }
    
// ----------------------- Métodos de validación -----------------------

    /**
     * Valida un texto basado en su longitud mínima y máxima, y que contenga solo letras.
     */
    protected boolean validarTexto(String texto, int longitudMinima, int longitudMaxima) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        // Patrón que incluye letras con acentos y caracteres como la ñ
        return texto.length() >= longitudMinima && texto.length() <= longitudMaxima && texto.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñüÜ\\s]+");
    }

    /**
     * Valida un número con longitud fija.
     */
    protected boolean validarNumero(String numero, int longitudFija) {
        return numero != null && numero.matches("\\d{" + longitudFija + "}");
    }

    /**
     * Valida si un número está dentro de un rango.
     */
    protected boolean validarRangoNumerico(int numero, int min, int max) {
        return numero >= min && numero <= max;
    }

    /**
     * Valida si un correo electrónico tiene el formato correcto.
     */
    protected boolean validarCorreo(String correo) {
        String regexCorreo = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return correo != null && Pattern.matches(regexCorreo, correo);
    }

    /**
     * Valida una contraseña basada en requisitos de seguridad.
     */
    protected boolean validarContraseña(String contraseña) {
        return contraseña != null && contraseña.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    /**
     * Verifica que dos contraseñas coincidan.
     */
    protected boolean coincidirContraseñas(String contraseña, String confirmacion) {
        return contraseña != null && contraseña.equals(confirmacion);
    }

    /**
     * Valida si una fecha tiene el formato correcto (DD/MM/AAAA).
     */
    protected boolean validarFecha(String fecha) {
        String patronFecha = "^\\d{2}/\\d{2}/\\d{4}$";
        return fecha != null && Pattern.matches(patronFecha, fecha);
    }

    /**
     * Valida que una dirección contenga los campos requeridos.
     */
    protected boolean validarDireccion(String provincia, String canton, String distrito) {
        return provincia != null && canton != null && distrito != null
                && !provincia.trim().isEmpty() && !canton.trim().isEmpty() && !distrito.trim().isEmpty();
    }

    /**
     * Valida que una selección esté dentro de un conjunto de opciones válidas.
     */
    protected boolean validarSeleccion(String seleccion, String[] opcionesValidas) {
        if (seleccion == null) {
            return false;
        }
        for (String opcion : opcionesValidas) {
            if (seleccion.equals(opcion)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sanitiza una entrada para evitar caracteres peligrosos.
     */
    protected boolean sanitizarEntrada(String entrada) {
        if (entrada == null) {
            return false;
        }
        return !entrada.matches(".*['\"<>].*");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainMenuBtn = new javax.swing.JButton();
        PartidaBtn = new javax.swing.JButton();
        CiudadesBtn = new javax.swing.JButton();
        PersonajesBtn = new javax.swing.JButton();
        RankingsBtn = new javax.swing.JButton();
        UsuariosBtn = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(251, 252, 254));
        setMinimumSize(new java.awt.Dimension(931, 589));
        setPreferredSize(new java.awt.Dimension(931, 589));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainMenuBtn.setBorderPainted(false);
        MainMenuBtn.setContentAreaFilled(false);
        MainMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuBtnActionPerformed(evt);
            }
        });
        getContentPane().add(MainMenuBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 130, 80));

        PartidaBtn.setBorderPainted(false);
        PartidaBtn.setContentAreaFilled(false);
        PartidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PartidaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(PartidaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 140, 80));

        CiudadesBtn.setBorderPainted(false);
        CiudadesBtn.setContentAreaFilled(false);
        CiudadesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiudadesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(CiudadesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 140, 80));

        PersonajesBtn.setBorderPainted(false);
        PersonajesBtn.setContentAreaFilled(false);
        PersonajesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonajesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(PersonajesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 130, 80));

        RankingsBtn.setBorderPainted(false);
        RankingsBtn.setContentAreaFilled(false);
        RankingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RankingsBtnActionPerformed(evt);
            }
        });
        getContentPane().add(RankingsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 140, 80));

        UsuariosBtn.setBorderPainted(false);
        UsuariosBtn.setContentAreaFilled(false);
        UsuariosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosBtnActionPerformed(evt);
            }
        });
        getContentPane().add(UsuariosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 100, 80));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuBtnActionPerformed
        abrirMainMenuPantalla();
    }//GEN-LAST:event_MainMenuBtnActionPerformed

    private void PartidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PartidaBtnActionPerformed
        abrirPartidaPantalla();
    }//GEN-LAST:event_PartidaBtnActionPerformed

    private void CiudadesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiudadesBtnActionPerformed
        abrirCiudadesPantalla();
    }//GEN-LAST:event_CiudadesBtnActionPerformed

    private void PersonajesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonajesBtnActionPerformed
        abrirPersonajesPantalla();
    }//GEN-LAST:event_PersonajesBtnActionPerformed

    private void UsuariosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosBtnActionPerformed
        abrirUsuariosPantalla();
    }//GEN-LAST:event_UsuariosBtnActionPerformed

    private void RankingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RankingsBtnActionPerformed
        abrirRankingsPantalla();
    }//GEN-LAST:event_RankingsBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaMadreMenues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaMadreMenues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaMadreMenues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaMadreMenues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PantallaMadreMenues().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    protected javax.swing.JButton CiudadesBtn;
    protected javax.swing.JButton MainMenuBtn;
    protected javax.swing.JButton PartidaBtn;
    protected javax.swing.JButton PersonajesBtn;
    protected javax.swing.JButton RankingsBtn;
    protected javax.swing.JButton UsuariosBtn;
    // End of variables declaration//GEN-END:variables
}
