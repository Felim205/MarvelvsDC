package com.mycompany.pp2;

import com.mycompany.pp2.CiudadPantalla.Pais;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabob
 */
public class UsuariosPantalla extends PantallaMadreMenues {

    /**
     * Constructor de PantallaMadreMenues
     */
    public UsuariosPantalla() {
        super();
        initComponents();
        personalizarPantalla();
        poblarLaTablaUsuarios();
        
    }
    
    private void personalizarPantalla() {
        // Cambiar el título de la ventana
        setTitle("Usuarios - MARVEL VS DC");
        // Ocultar botones no relevantes
        UsuariosBtn.setVisible(false);

    }
    
    public void poblarLaTablaUsuarios(){
        String columns [] = {"ID", "Nombre", "Correo", "Rol"};
        String data [] [] = {{"001","GaBruhBaVi","gabruhbavi@outlook.com","DPS"}};    
        DefaultTableModel model = new DefaultTableModel (data, columns);
        ListaUsuarios. setModel (model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AgregarBtn = new javax.swing.JButton();
        EditarBtn = new javax.swing.JButton();
        EliminarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaUsuarios = new javax.swing.JTable();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(251, 252, 254));
        setMinimumSize(new java.awt.Dimension(931, 589));
        setPreferredSize(new java.awt.Dimension(931, 589));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AgregarBtn.setText("Agregar");
        AgregarBtn.setToolTipText("");
        AgregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 170, 40));

        EditarBtn.setText("Editar");
        EditarBtn.setToolTipText("");
        EditarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(EditarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 170, 40));

        EliminarBtn.setText("Eliminar");
        EliminarBtn.setToolTipText("");
        EliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 170, 40));

        ListaUsuarios.setBackground(new java.awt.Color(212, 223, 241));
        ListaUsuarios.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        ListaUsuarios.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ListaUsuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 770, 360));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BgUser.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBtnActionPerformed
        boolean datosValidos = false;

        JTextField txtNombreCiudad = new JTextField(15);
        JComboBox<String> comboPais = new JComboBox<>();
        JTextField txtPoblacion = new JTextField(10);
        JTextField txtCoordenadas = new JTextField(15);

        // Llenar el ComboBox con los valores del enum
        for (Pais pais : Pais.values()) {
            comboPais.addItem(pais.getNombre());
        }

        do {
            JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
            panel.add(new JLabel("Nombre de la Ciudad:"));
            panel.add(txtNombreCiudad);
            panel.add(new JLabel("País:"));
            panel.add(comboPais);
            panel.add(new JLabel("Población:"));
            panel.add(txtPoblacion);
            panel.add(new JLabel("Coordenadas:"));
            panel.add(txtCoordenadas);

            int result = JOptionPane.showConfirmDialog(this, panel, "Agregar Ciudad", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String nombre = txtNombreCiudad.getText().trim();
                String pais = (String) comboPais.getSelectedItem();
                String poblacion = txtPoblacion.getText().trim();
                String coordenadas = txtCoordenadas.getText().trim();

                // Validaciones aquí (similar al código previo)
                // ...

                DefaultTableModel model = (DefaultTableModel) ListaUsuarios.getModel();
                model.addRow(new Object[]{nombre, pais, poblacion, coordenadas});
                datosValidos = true;
            } else {
                datosValidos = true; // Cerrar si el usuario cancela
            }
        } while (!datosValidos);
    }//GEN-LAST:event_AgregarBtnActionPerformed

    private void EditarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBtnActionPerformed
        int filaSeleccionada = ListaUsuarios.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) ListaUsuarios.getModel();
        String nombreActual = model.getValueAt(filaSeleccionada, 0).toString();
        String paisActual = model.getValueAt(filaSeleccionada, 1).toString();
        String poblacionActual = model.getValueAt(filaSeleccionada, 2).toString();
        String coordenadasActual = model.getValueAt(filaSeleccionada, 3).toString();

        JTextField txtNombreCiudad = new JTextField(nombreActual, 15);
        JComboBox<String> comboPais = new JComboBox<>();
        JTextField txtPoblacion = new JTextField(poblacionActual, 10);
        JTextField txtCoordenadas = new JTextField(coordenadasActual, 15);

        // Llenar el ComboBox con los valores del enum
        for (Pais pais : Pais.values()) {
            comboPais.addItem(pais.getNombre());
        }
        // Seleccionar el país actual
        comboPais.setSelectedItem(paisActual);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.add(new JLabel("Nombre de la Ciudad:"));
        panel.add(txtNombreCiudad);
        panel.add(new JLabel("País:"));
        panel.add(comboPais);
        panel.add(new JLabel("Población:"));
        panel.add(txtPoblacion);
        panel.add(new JLabel("Coordenadas:"));
        panel.add(txtCoordenadas);

        int result = JOptionPane.showConfirmDialog(this, panel, "Editar Ciudad", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String nuevoNombre = txtNombreCiudad.getText().trim();
            String nuevoPais = (String) comboPais.getSelectedItem();
            String nuevaPoblacion = txtPoblacion.getText().trim();
            String nuevasCoordenadas = txtCoordenadas.getText().trim();

            // Validaciones aquí (similar al código previo)
            // ...

            model.setValueAt(nuevoNombre, filaSeleccionada, 0);
            model.setValueAt(nuevoPais, filaSeleccionada, 1);
            model.setValueAt(nuevaPoblacion, filaSeleccionada, 2);
            model.setValueAt(nuevasCoordenadas, filaSeleccionada, 3);

            JOptionPane.showMessageDialog(this, "Ciudad actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_EditarBtnActionPerformed

    private void EliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBtnActionPerformed
        // Verificar si hay una fila seleccionada
        int filaSeleccionada = ListaUsuarios.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar la eliminación con el usuario
        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de que desea eliminar esta ciudad?",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Eliminar la fila del modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) ListaUsuarios.getModel();
            model.removeRow(filaSeleccionada);

            // Mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Ciudad eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_EliminarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(UsuariosPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuariosPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuariosPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuariosPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new UsuariosPantalla().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBtn;
    private javax.swing.JLabel Background;
    private javax.swing.JButton EditarBtn;
    private javax.swing.JButton EliminarBtn;
    private javax.swing.JTable ListaUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
