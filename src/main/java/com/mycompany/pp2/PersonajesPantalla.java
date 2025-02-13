package com.mycompany.pp2;

import com.mycompany.pp2.clases.Personaje;
import com.mycompany.pp2.managers.PersonajeManager;
import java.awt.GridLayout;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

/**
 *
 * @author gabob
 */
public class PersonajesPantalla extends PantallaMadreMenues {

    /**
     * Constructor de PantallaMadreMenues
     */
    public PersonajesPantalla() {
        super();
        initComponents();
        personalizarPantalla();
        poblarLaTablaPersonajes();
    }
    
    private void personalizarPantalla() {
        // Cambiar el título de la ventana
        setTitle("Mis Personajes - MARVEL VS DC");
        // Ocultar botones no relevantes
        PersonajesBtn.setVisible(false);
    }
    
    public void poblarLaTablaPersonajes() {
        DefaultTableModel model = (DefaultTableModel) ListaPersonajes.getModel();
        model.setRowCount(0);

        for (Personaje personaje : PersonajeManager.getListaPersonajes()) {
            model.addRow(new Object[]{
                personaje.getNombre(),
                personaje.getPseudonimo(),
                personaje.getPersonaje().getNombre(),
                personaje.getOrigen().getNombre(),
                personaje.getFranquicia().getNombre(),
                personaje.getFuerza() + "%",
                personaje.getVelocidad() + "%",
                personaje.getInteligencia() + "%",
                personaje.getRecursosEconomicos() + "%",
                personaje.poderTotal() + "%"
            });
        }
    }
    
    private Date generarFechaNacimientoAleatoria() {
        Random rand = new Random();
        Calendar calendar = Calendar.getInstance();
        int edadAleatoria = rand.nextInt(43) + 18; // Edad entre 18 y 60 años
        calendar.add(Calendar.YEAR, -edadAleatoria);
        return calendar.getTime();
    }
    
private void AgregarPersonaje() {
    JTextField txtNombre = new JTextField(15);
    JTextField txtPseudonimo = new JTextField(15);
    JTextField txtPais = new JTextField(15);
    JComboBox<String> comboTipo = new JComboBox<>();
    JComboBox<String> comboOrigen = new JComboBox<>();
    JComboBox<String> comboFranquicia = new JComboBox<>();
    JTextField txtFuerza = new JTextField(5);
    JTextField txtVelocidad = new JTextField(5);
    JTextField txtInteligencia = new JTextField(5);
    JTextField txtRecursos = new JTextField(5);

    for (Personaje.TipoPersonaje tipo : Personaje.TipoPersonaje.values()) {
        comboTipo.addItem(tipo.getNombre());
    }
    for (Personaje.TipoOrigen origen : Personaje.TipoOrigen.values()) {
        comboOrigen.addItem(origen.getNombre());
    }
    for (Personaje.TipoFranquicia franquicia : Personaje.TipoFranquicia.values()) {
        comboFranquicia.addItem(franquicia.getNombre());
    }

    JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
    panel.add(new JLabel("Nombre:"));
    panel.add(txtNombre);
    panel.add(new JLabel("Pseudónimo:"));
    panel.add(txtPseudonimo);
    panel.add(new JLabel("País de Residencia:"));
    panel.add(txtPais);
    panel.add(new JLabel("Tipo:"));
    panel.add(comboTipo);
    panel.add(new JLabel("Origen:"));
    panel.add(comboOrigen);
    panel.add(new JLabel("Franquicia:"));
    panel.add(comboFranquicia);
    panel.add(new JLabel("Fuerza (1-100):"));
    panel.add(txtFuerza);
    panel.add(new JLabel("Velocidad (1-100):"));
    panel.add(txtVelocidad);
    panel.add(new JLabel("Inteligencia (1-100):"));
    panel.add(txtInteligencia);
    panel.add(new JLabel("Recursos Económicos (1-100):"));
    panel.add(txtRecursos);

    boolean datosValidos;
    do {
        datosValidos = true;
        int result = JOptionPane.showConfirmDialog(this, panel, "Agregar Personaje", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
            return;
        }

        try {
            String nombre = txtNombre.getText().trim();
            String pseudonimo = txtPseudonimo.getText().trim();
            String paisResidencia = txtPais.getText().trim();
            int fuerza = Integer.parseInt(txtFuerza.getText().trim());
            int velocidad = Integer.parseInt(txtVelocidad.getText().trim());
            int inteligencia = Integer.parseInt(txtInteligencia.getText().trim());
            int recursos = Integer.parseInt(txtRecursos.getText().trim());

            // Validaciones
            if (nombre.length() > 60 || pseudonimo.length() > 60) {
                JOptionPane.showMessageDialog(this, "El nombre y pseudónimo no pueden superar 60 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
                continue;
            }

            if (!Pattern.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+", paisResidencia)) {
                JOptionPane.showMessageDialog(this, "El país solo puede contener letras y espacios.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
                continue;
            }

            if (fuerza < 1 || fuerza > 100 || velocidad < 1 || velocidad > 100 ||
                inteligencia < 1 || inteligencia > 100 || recursos < 1 || recursos > 100) {
                JOptionPane.showMessageDialog(this, "Los valores de atributos deben estar entre 1 y 100.", "Error", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
                continue;
            }

            for (Personaje p : PersonajeManager.getListaPersonajes()) {
                if (p.getNombre().equalsIgnoreCase(nombre) && p.getPseudonimo().equalsIgnoreCase(pseudonimo)) {
                    JOptionPane.showMessageDialog(this, "Ya existe un personaje con el mismo Nombre y Pseudónimo.", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                    break;
                }
            }

            if (!datosValidos) continue;

            // Asignación de valores
            Personaje.TipoPersonaje tipo = null;
            for (Personaje.TipoPersonaje t : Personaje.TipoPersonaje.values()) {
                if (t.getNombre().equals(comboTipo.getSelectedItem())) {
                    tipo = t;
                    break;
                }
            }

            Personaje.TipoOrigen origen = null;
            for (Personaje.TipoOrigen o : Personaje.TipoOrigen.values()) {
                if (o.getNombre().equals(comboOrigen.getSelectedItem())) {
                    origen = o;
                    break;
                }
            }

            Personaje.TipoFranquicia franquicia = null;
            for (Personaje.TipoFranquicia f : Personaje.TipoFranquicia.values()) {
                if (f.getNombre().equals(comboFranquicia.getSelectedItem())) {
                    franquicia = f;
                    break;
                }
            }

            // Generar fecha de nacimiento aleatoria entre 18 y 60 años atrás
            Date fechaNacimiento = generarFechaNacimientoAleatoria();

            // Forzar que la imagen del personaje sea "default.png"
            String imagenDefault = "default.png";

            // Crear y agregar el personaje
            Personaje nuevoPersonaje = new Personaje(
                nombre, 
                fechaNacimiento, 
                paisResidencia, 
                imagenDefault,  // "foto"
                tipo, 
                pseudonimo, 
                imagenDefault,  // "fotografia"
                origen, 
                franquicia, 
                fuerza, 
                velocidad, 
                inteligencia, 
                recursos
            );

            // Imprimir en consola para verificar si la imagen es "default.png"
            System.out.println("Imagen asignada al personaje: " + nuevoPersonaje.getFotografia());

            PersonajeManager.agregarPersonaje(nuevoPersonaje);
            poblarLaTablaPersonajes();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos para atributos.", "Error", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }
    } while (!datosValidos);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AgregarBtn = new javax.swing.JButton();
        EditarBtn = new javax.swing.JButton();
        EliminarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaPersonajes = new javax.swing.JTable();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(251, 252, 254));
        setMinimumSize(new java.awt.Dimension(931, 589));
        setPreferredSize(new java.awt.Dimension(931, 589));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        ListaPersonajes.setBackground(new java.awt.Color(212, 223, 241));
        ListaPersonajes.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        ListaPersonajes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ListaPersonajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Pseudónimo", "Tipo", "Origen", "Franquicia", "Fuerza", "Velocidad", "Inteligencia", "R. Económicos", "Poder Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ListaPersonajes);
        if (ListaPersonajes.getColumnModel().getColumnCount() > 0) {
            ListaPersonajes.getColumnModel().getColumn(0).setPreferredWidth(80);
            ListaPersonajes.getColumnModel().getColumn(1).setResizable(false);
            ListaPersonajes.getColumnModel().getColumn(1).setPreferredWidth(95);
            ListaPersonajes.getColumnModel().getColumn(2).setMinWidth(70);
            ListaPersonajes.getColumnModel().getColumn(2).setPreferredWidth(70);
            ListaPersonajes.getColumnModel().getColumn(3).setMinWidth(100);
            ListaPersonajes.getColumnModel().getColumn(3).setPreferredWidth(100);
            ListaPersonajes.getColumnModel().getColumn(4).setMinWidth(70);
            ListaPersonajes.getColumnModel().getColumn(4).setPreferredWidth(70);
            ListaPersonajes.getColumnModel().getColumn(5).setResizable(false);
            ListaPersonajes.getColumnModel().getColumn(5).setPreferredWidth(60);
            ListaPersonajes.getColumnModel().getColumn(6).setResizable(false);
            ListaPersonajes.getColumnModel().getColumn(6).setPreferredWidth(70);
            ListaPersonajes.getColumnModel().getColumn(7).setResizable(false);
            ListaPersonajes.getColumnModel().getColumn(7).setPreferredWidth(80);
            ListaPersonajes.getColumnModel().getColumn(8).setResizable(false);
            ListaPersonajes.getColumnModel().getColumn(8).setPreferredWidth(90);
            ListaPersonajes.getColumnModel().getColumn(9).setResizable(false);
            ListaPersonajes.getColumnModel().getColumn(9).setPreferredWidth(80);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 860, 360));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BgPersonajes.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBtnActionPerformed
        AgregarPersonaje();
    }//GEN-LAST:event_AgregarBtnActionPerformed

    private void EditarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBtnActionPerformed
        int filaSeleccionada = ListaPersonajes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un personaje para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Personaje personaje = PersonajeManager.getListaPersonajes().get(filaSeleccionada);

        JTextField txtNombre = new JTextField(personaje.getNombre(), 15);
        JTextField txtPseudonimo = new JTextField(personaje.getPseudonimo(), 15);
        JComboBox<String> comboTipo = new JComboBox<>();
        JComboBox<String> comboOrigen = new JComboBox<>();
        JComboBox<String> comboFranquicia = new JComboBox<>();
        JTextField txtFuerza = new JTextField(String.valueOf(personaje.getFuerza()), 5);
        JTextField txtVelocidad = new JTextField(String.valueOf(personaje.getVelocidad()), 5);
        JTextField txtInteligencia = new JTextField(String.valueOf(personaje.getInteligencia()), 5);
        JTextField txtRecursos = new JTextField(String.valueOf(personaje.getRecursosEconomicos()), 5);

        for (Personaje.TipoPersonaje tipo : Personaje.TipoPersonaje.values()) {
            comboTipo.addItem(tipo.getNombre());
        }
        comboTipo.setSelectedItem(personaje.getPersonaje().getNombre());

        for (Personaje.TipoOrigen origen : Personaje.TipoOrigen.values()) {
            comboOrigen.addItem(origen.getNombre());
        }
        comboOrigen.setSelectedItem(personaje.getOrigen().getNombre());

        for (Personaje.TipoFranquicia franquicia : Personaje.TipoFranquicia.values()) {
            comboFranquicia.addItem(franquicia.getNombre());
        }
        comboFranquicia.setSelectedItem(personaje.getFranquicia().getNombre());

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Pseudónimo:"));
        panel.add(txtPseudonimo);
        panel.add(new JLabel("Tipo:"));
        panel.add(comboTipo);
        panel.add(new JLabel("Origen:"));
        panel.add(comboOrigen);
        panel.add(new JLabel("Franquicia:"));
        panel.add(comboFranquicia);
        panel.add(new JLabel("Fuerza:"));
        panel.add(txtFuerza);
        panel.add(new JLabel("Velocidad:"));
        panel.add(txtVelocidad);
        panel.add(new JLabel("Inteligencia:"));
        panel.add(txtInteligencia);
        panel.add(new JLabel("Recursos Económicos:"));
        panel.add(txtRecursos);

        int result = JOptionPane.showConfirmDialog(this, panel, "Editar Personaje", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            personaje.setPseudonimo(txtPseudonimo.getText().trim());

            // Buscar el enum correspondiente en base al texto seleccionado
            String tipoSeleccionado = (String) comboTipo.getSelectedItem();
            for (Personaje.TipoPersonaje tipo : Personaje.TipoPersonaje.values()) {
                if (tipo.getNombre().equals(tipoSeleccionado)) {
                    personaje.setPersonaje(tipo);
                    break;
                }
            }

            String origenSeleccionado = (String) comboOrigen.getSelectedItem();
            for (Personaje.TipoOrigen origen : Personaje.TipoOrigen.values()) {
                if (origen.getNombre().equals(origenSeleccionado)) {
                    personaje.setOrigen(origen);
                    break;
                }
            }

            String franquiciaSeleccionada = (String) comboFranquicia.getSelectedItem();
            for (Personaje.TipoFranquicia franquicia : Personaje.TipoFranquicia.values()) {
                if (franquicia.getNombre().equals(franquiciaSeleccionada)) {
                    personaje.setFranquicia(franquicia);
                    break;
                }
            }

            personaje.setFuerza(Double.parseDouble(txtFuerza.getText().trim()));
            personaje.setVelocidad(Double.parseDouble(txtVelocidad.getText().trim()));
            personaje.setInteligencia(Double.parseDouble(txtInteligencia.getText().trim()));
            personaje.setRecursosEconomicos(Double.parseDouble(txtRecursos.getText().trim()));

            PersonajeManager.editarPersonaje(filaSeleccionada, personaje);
            poblarLaTablaPersonajes();
        }
    }//GEN-LAST:event_EditarBtnActionPerformed

    private void EliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBtnActionPerformed
        int filaSeleccionada = ListaPersonajes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un personaje para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de que desea eliminar este personaje?",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            PersonajeManager.eliminarPersonaje(filaSeleccionada);
            poblarLaTablaPersonajes();
            JOptionPane.showMessageDialog(this, "Personaje eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(PersonajesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonajesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonajesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonajesPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new PersonajesPantalla().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBtn;
    private javax.swing.JLabel Background;
    private javax.swing.JButton EditarBtn;
    private javax.swing.JButton EliminarBtn;
    private javax.swing.JTable ListaPersonajes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
