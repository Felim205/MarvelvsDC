package com.mycompany.pp2;

import com.mycompany.pp2.clases.Personaje;
import com.mycompany.pp2.clases.Usuario;
import com.mycompany.pp2.clases.Ciudad;
import com.mycompany.pp2.managers.CiudadManager;
import com.mycompany.pp2.managers.PersonajeManager;
import com.mycompany.pp2.managers.UsuarioManager;
import java.awt.GridLayout;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author gabob
 */
public class PartidaPantalla extends PantallaMadreMenues {

    /**
     * Constructor de PantallaMadreMenues
     */
    public PartidaPantalla() {
        super();
        initComponents();
        personalizarPantalla();
    }
    
    private void personalizarPantalla() {
        // Cambiar el título de la ventana
        setTitle("Comenzar Partida - MARVEL VS DC");
        // Ocultar botones no relevantes
        PartidaBtn.setVisible(false);
    }
    
    /**
     * Permite a la GUI abrir la pantalla Usuarios, cerrándo la pantalla pasada
     */   
    
    private void seleccionarJugadores() {
        List<Usuario> listaUsuarios = UsuarioManager.getListaUsuarios();
        List<Personaje> listaPersonajes = PersonajeManager.getListaPersonajes();
        List<Ciudad> listaCiudades = CiudadManager.getListaCiudades(); // Se obtiene la lista de objetos Ciudad

        // Extraer solo los nombres de las ciudades
        List<String> nombresCiudades = listaCiudades.stream()
                .map(Ciudad::getCuidad) // Obtiene solo el nombre de la ciudad
                .collect(Collectors.toList());

        // Validar si hay suficientes elementos para jugar
        int usuariosFaltantes = 2 - listaUsuarios.size();
        int personajesFaltantes = 1 - listaPersonajes.size();
        boolean noHayCiudades = nombresCiudades.isEmpty();

        if (usuariosFaltantes > 0 || personajesFaltantes > 0 || noHayCiudades) {
            String mensajeError = "No se puede iniciar la partida:\n";
            if (usuariosFaltantes > 0) mensajeError += "- Faltan " + usuariosFaltantes + " usuario(s).\n";
            if (personajesFaltantes > 0) mensajeError += "- No hay personajes creados.\n";
            if (noHayCiudades) mensajeError += "- No hay ciudades disponibles.\n";
            JOptionPane.showMessageDialog(this, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario jugador1Usuario = null;
        Usuario jugador2Usuario = null;
        Personaje jugador1Personaje = null;
        Personaje jugador2Personaje = null;
        String ciudadSeleccionada = null;

        for (int i = 1; i <= 2; i++) {
            JComboBox<String> comboUsuarios = new JComboBox<>();
            for (Usuario usuario : listaUsuarios) {
                if (i == 1 || !usuario.equals(jugador1Usuario)) {
                    comboUsuarios.addItem(usuario.getUserName());
                }
            }

            JComboBox<String> comboPersonajes = new JComboBox<>();
            for (Personaje personaje : listaPersonajes) {
                comboPersonajes.addItem(personaje.getPseudonimo());
            }

            JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
            panel.add(new JLabel("Selecciona un Usuario:"));
            panel.add(comboUsuarios);
            panel.add(new JLabel("Selecciona un Personaje:"));
            panel.add(comboPersonajes);

            int result = JOptionPane.showConfirmDialog(this, panel, 
                "Seleccionar Jugador " + i, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
                return; // Salir si se cancela
            }

            String usuarioSeleccionado = (String) comboUsuarios.getSelectedItem();
            String personajeSeleccionado = (String) comboPersonajes.getSelectedItem();

            Usuario usuarioElegido = listaUsuarios.stream()
                .filter(u -> u.getUserName().equals(usuarioSeleccionado))
                .findFirst().orElse(null);

            Personaje personajeElegido = listaPersonajes.stream()
                .filter(p -> p.getPseudonimo().equals(personajeSeleccionado))
                .findFirst().orElse(null);

            if (usuarioElegido == null || personajeElegido == null) {
                JOptionPane.showMessageDialog(this, "Error al seleccionar usuario o personaje.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (i == 1) {
                jugador1Usuario = usuarioElegido;
                jugador1Personaje = personajeElegido;
            } else {
                jugador2Usuario = usuarioElegido;
                jugador2Personaje = personajeElegido;
            }
        }

        // Ahora se selecciona la ciudad
        JComboBox<String> comboCiudades = new JComboBox<>();
        for (String ciudad : nombresCiudades) {
            comboCiudades.addItem(ciudad);
        }

        JPanel ciudadPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        ciudadPanel.add(new JLabel("Selecciona una Ciudad:"));
        ciudadPanel.add(comboCiudades);

        int ciudadResult = JOptionPane.showConfirmDialog(this, ciudadPanel, 
            "Seleccionar Ciudad", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (ciudadResult == JOptionPane.CANCEL_OPTION || ciudadResult == JOptionPane.CLOSED_OPTION) {
            return; // Salir si se cancela la selección de ciudad
        }

        ciudadSeleccionada = (String) comboCiudades.getSelectedItem();

        // 📌 Mostramos en consola la selección para depuración.
        System.out.println("Jugador 1: " + jugador1Usuario.getUserName() + " con " + jugador1Personaje.getPseudonimo());
        System.out.println("Jugador 2: " + jugador2Usuario.getUserName() + " con " + jugador2Personaje.getPseudonimo());
        System.out.println("Escenario elegido: " + ciudadSeleccionada);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListaPartidas = new javax.swing.JTable();
        JugarBtn = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(251, 252, 254));
        setMinimumSize(new java.awt.Dimension(931, 589));
        setPreferredSize(new java.awt.Dimension(931, 589));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListaPartidas.setBackground(new java.awt.Color(212, 223, 241));
        ListaPartidas.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        ListaPartidas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ListaPartidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID de Partida", "Fecha", "Duración", "Participantes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ListaPartidas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 760, 340));

        JugarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PlayBtn.png"))); // NOI18N
        JugarBtn.setBorderPainted(false);
        JugarBtn.setContentAreaFilled(false);
        JugarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(JugarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 270, 60));

        Actualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        Actualizar.setText("Ver Detalles");
        Actualizar.setToolTipText("");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 140, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BgPartida.png"))); // NOI18N
        Background.setMaximumSize(new java.awt.Dimension(915, 590));
        Background.setMinimumSize(new java.awt.Dimension(915, 590));
        Background.setPreferredSize(new java.awt.Dimension(915, 590));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JugarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarBtnActionPerformed
        seleccionarJugadores();
    }//GEN-LAST:event_JugarBtnActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed

    }//GEN-LAST:event_ActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(PartidaPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartidaPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartidaPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartidaPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PartidaPantalla().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JLabel Background;
    private javax.swing.JButton JugarBtn;
    private javax.swing.JTable ListaPartidas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
