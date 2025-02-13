package com.mycompany.pp2;

import com.mycompany.pp2.clases.Ciudad;
import com.mycompany.pp2.clases.Ciudad.TipoEscenario;
import com.mycompany.pp2.managers.CiudadManager;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author gabob
 * Pantalla de gestión de ciudades en MARVEL VS DC.
 */
public class CiudadPantalla extends PantallaMadreMenues {
 
    /**
     * Constructor de PantallaMadreMenues
     */
    public CiudadPantalla() {
        super();
        initComponents();
        personalizarPantalla();
        poblarLaTablaCiudad();
    }
    
    private void personalizarPantalla() {
        // Cambiar el título de la ventana
        setTitle("Mis Ciudades - MARVEL VS DC");
        // Ocultar botones no relevantes
        CiudadesBtn.setVisible(false);
    }
    
    /**
     * Poblar la tabla sin perder información previamente ingresada.
     */
    public void poblarLaTablaCiudad() {
        DefaultTableModel model = (DefaultTableModel) ListaCiudades.getModel();
        model.setRowCount(0); // Limpiar la tabla visualmente, pero mantener los datos en CiudadManager
        
        for (Ciudad ciudad : CiudadManager.getListaCiudades()) {
            model.addRow(new Object[]{ciudad.getCuidad(), ciudad.getPais(), ciudad.getEstado(), ciudad.getEscenario().getNombre()});
        }
    }
    
    public enum Pais {
        COSTA_RICA("Costa Rica"), ESTADOS_UNIDOS("Estados Unidos"),
        ESPAÑA("España"), FRANCIA("Francia"), ALEMANIA("Alemania"),
        ARGENTINA("Argentina"), CHILE("Chile"), BRASIL("Brasil"),
        MEXICO("México"), JAPON("Japón"), CHINA("China"), RUSSIA ("Russia"),
        COLOMBIA("Colombia"), GENOSHA("Genosha"), LATVERIA("Latveria");

        private final String nombre;

        // Constructor del enum
        Pais(String nombre) {
            this.nombre = nombre;
        }

        // Método para obtener el nombre del país
        public String getNombre() {
            return nombre;
        }
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
        ListaCiudades = new javax.swing.JTable();
        AgregarBtn = new javax.swing.JButton();
        EditarBtn = new javax.swing.JButton();
        EliminarBtn = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(251, 252, 254));
        setMinimumSize(new java.awt.Dimension(931, 589));
        setPreferredSize(new java.awt.Dimension(931, 589));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListaCiudades.setBackground(new java.awt.Color(212, 223, 241));
        ListaCiudades.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        ListaCiudades.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ListaCiudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "País", "Estado / Provincia", "Escenario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ListaCiudades);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 770, 360));

        AgregarBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        AgregarBtn.setText("Agregar");
        AgregarBtn.setToolTipText("");
        AgregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 170, 40));

        EditarBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        EditarBtn.setText("Editar");
        EditarBtn.setToolTipText("");
        EditarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(EditarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 170, 40));

        EliminarBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        EliminarBtn.setText("Eliminar");
        EliminarBtn.setToolTipText("");
        EliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 170, 40));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BgCiudades.png"))); // NOI18N
        Background.setMaximumSize(new java.awt.Dimension(915, 590));
        Background.setMinimumSize(new java.awt.Dimension(915, 590));
        Background.setPreferredSize(new java.awt.Dimension(915, 590));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Agregar una nueva ciudad ingresada por el usuario.
     */
    private void AgregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBtnActionPerformed
                JTextField txtNombreCiudad = new JTextField(15);
    JComboBox<String> comboPais = new JComboBox<>();
    JTextField txtEstado = new JTextField(15);
    JComboBox<String> comboEscenario = new JComboBox<>();

    for (Pais pais : Pais.values()) {
        comboPais.addItem(pais.getNombre());
    }

    for (TipoEscenario escenario : TipoEscenario.values()) {
        comboEscenario.addItem(escenario.getNombre());
    }

    JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
    panel.add(new JLabel("Nombre de la Ciudad:"));
    panel.add(txtNombreCiudad);
    panel.add(new JLabel("País:"));
    panel.add(comboPais);
    panel.add(new JLabel("Estado/Provincia:"));
    panel.add(txtEstado);
    panel.add(new JLabel("Escenario:"));
    panel.add(comboEscenario);

    boolean datosValidos = false;
    while (!datosValidos) {
        int result = JOptionPane.showConfirmDialog(this, panel, "Agregar Ciudad", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) {
            return; // Cierra si el usuario cancela
        }

        String nombre = txtNombreCiudad.getText().trim();
        String pais = (String) comboPais.getSelectedItem();
        String estado = txtEstado.getText().trim();
        String escenarioNombre = (String) comboEscenario.getSelectedItem();

        // Validaciones
        if (nombre.isEmpty() || estado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
        }

        if (nombre.length() > 70) {
            JOptionPane.showMessageDialog(this, "El nombre de la ciudad no puede superar los 70 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
        }

        boolean ciudadExiste = CiudadManager.getListaCiudades().stream()
            .anyMatch(c -> c.getCuidad().equalsIgnoreCase(nombre));

        if (ciudadExiste) {
            JOptionPane.showMessageDialog(this, "Ya existe una ciudad con este nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
        }

        // Convertir el nombre seleccionado a su respectivo enum
        TipoEscenario escenario = null;
        for (TipoEscenario tipo : TipoEscenario.values()) {
            if (tipo.getNombre().equals(escenarioNombre)) {
                escenario = tipo;
                break;
            }
        }

        Ciudad nuevaCiudad = new Ciudad(pais, estado, nombre, escenario);
        CiudadManager.agregarCiudad(nuevaCiudad);
        poblarLaTablaCiudad();
        datosValidos = true;
    }
    }//GEN-LAST:event_AgregarBtnActionPerformed
    
    /**
     * Editar una ciudad seleccionada.
     */
    private void EditarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBtnActionPerformed
    int filaSeleccionada = ListaCiudades.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una ciudad para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Ciudad ciudadSeleccionada = CiudadManager.getListaCiudades().get(filaSeleccionada);

    JTextField txtNombreCiudad = new JTextField(ciudadSeleccionada.getCuidad(), 15);
    JComboBox<String> comboPais = new JComboBox<>();
    JTextField txtEstado = new JTextField(ciudadSeleccionada.getEstado(), 15);
    JComboBox<String> comboEscenario = new JComboBox<>();

    for (Pais pais : Pais.values()) {
        comboPais.addItem(pais.getNombre());
    }
    comboPais.setSelectedItem(ciudadSeleccionada.getPais());

    for (TipoEscenario escenario : TipoEscenario.values()) {
        comboEscenario.addItem(escenario.getNombre());
    }
    comboEscenario.setSelectedItem(ciudadSeleccionada.getEscenario().getNombre());

    JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
    panel.add(new JLabel("Nombre de la Ciudad:"));
    panel.add(txtNombreCiudad);
    panel.add(new JLabel("País:"));
    panel.add(comboPais);
    panel.add(new JLabel("Estado/Provincia:"));
    panel.add(txtEstado);
    panel.add(new JLabel("Escenario:"));
    panel.add(comboEscenario);

    boolean datosValidos = false;
    while (!datosValidos) {
        int result = JOptionPane.showConfirmDialog(this, panel, "Editar Ciudad", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) {
            return; // Cierra si el usuario cancela la edición
        }

        String nuevoNombre = txtNombreCiudad.getText().trim();
        String nuevoPais = (String) comboPais.getSelectedItem();
        String nuevoEstado = txtEstado.getText().trim();
        String escenarioNombre = (String) comboEscenario.getSelectedItem();

        // Validaciones
        if (nuevoNombre.isEmpty() || nuevoEstado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
        }

        if (nuevoNombre.length() > 70) {
            JOptionPane.showMessageDialog(this, "El nombre de la ciudad no puede superar los 70 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
        }

        // Verificar si el nombre ya está en uso en otra ciudad
        boolean ciudadExiste = CiudadManager.getListaCiudades().stream()
            .anyMatch(c -> !c.equals(ciudadSeleccionada) && c.getCuidad().equalsIgnoreCase(nuevoNombre));

        if (ciudadExiste) {
            JOptionPane.showMessageDialog(this, "Ya existe otra ciudad con este nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
        }

        // Convertir el nombre seleccionado a su respectivo enum
        TipoEscenario nuevoEscenario = null;
        for (TipoEscenario tipo : TipoEscenario.values()) {
            if (tipo.getNombre().equals(escenarioNombre)) {
                nuevoEscenario = tipo;
                break;
            }
        }

        // Actualizar la ciudad seleccionada con los nuevos datos
        ciudadSeleccionada.setCuidad(nuevoNombre);
        ciudadSeleccionada.setPais(nuevoPais);
        ciudadSeleccionada.setEstado(nuevoEstado);
        ciudadSeleccionada.setEscenario(nuevoEscenario);

        CiudadManager.editarCiudad(filaSeleccionada, ciudadSeleccionada);
        poblarLaTablaCiudad();
        datosValidos = true;
    }
    }//GEN-LAST:event_EditarBtnActionPerformed
    
    /**
     * Eliminar una ciudad seleccionada.
     */
    private void EliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBtnActionPerformed
        int filaSeleccionada = ListaCiudades.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta ciudad?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirmacion == JOptionPane.YES_OPTION) {
            CiudadManager.eliminarCiudad(filaSeleccionada);
            poblarLaTablaCiudad();
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
            java.util.logging.Logger.getLogger(CiudadPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CiudadPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CiudadPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CiudadPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            new CiudadPantalla().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBtn;
    private javax.swing.JLabel Background;
    private javax.swing.JButton EditarBtn;
    private javax.swing.JButton EliminarBtn;
    private javax.swing.JTable ListaCiudades;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
