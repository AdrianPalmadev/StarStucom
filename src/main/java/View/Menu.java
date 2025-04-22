package View;

//NETBEANS
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

//PROYECTO
import static Controller.Controlador.*;
import Model.*;
import Excepcion.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imgs/stucom100.png")).getImage());
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        logostucom = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        crearciudadano = new javax.swing.JButton();
        crearplaneta = new javax.swing.JButton();
        baja = new javax.swing.JButton();
        modificar = new javax.swing.JToggleButton();
        buscar = new javax.swing.JButton();
        logostarktrek = new javax.swing.JLabel();
        inciar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        setMaximumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(1060, 600));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logostucom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logo-Stucom.png"))); // NOI18N
        jPanel2.add(logostucom, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 850, 60));

        jPanel1.setBackground(new java.awt.Color(0, 67, 188));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        crearciudadano.setBackground(new java.awt.Color(255, 250, 250));
        crearciudadano.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        crearciudadano.setForeground(new java.awt.Color(51, 51, 51));
        crearciudadano.setText("Crear ciudadano");
        crearciudadano.setMaximumSize(new java.awt.Dimension(0, 0));
        crearciudadano.setMinimumSize(new java.awt.Dimension(0, 0));
        crearciudadano.setPreferredSize(new java.awt.Dimension(168, 40));
        crearciudadano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearciudadanoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(25, 5, 25, 5);
        jPanel1.add(crearciudadano, gridBagConstraints);

        crearplaneta.setBackground(new java.awt.Color(255, 250, 250));
        crearplaneta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        crearplaneta.setForeground(new java.awt.Color(51, 51, 51));
        crearplaneta.setText("Crear planeta");
        crearplaneta.setBorder(null);
        crearplaneta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearplaneta.setMinimumSize(new java.awt.Dimension(50, 25));
        crearplaneta.setPreferredSize(new java.awt.Dimension(168, 40));
        crearplaneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearplanetaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 5, 25, 5);
        jPanel1.add(crearplaneta, gridBagConstraints);

        baja.setBackground(new java.awt.Color(255, 250, 250));
        baja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        baja.setForeground(new java.awt.Color(51, 51, 51));
        baja.setText("Baja ");
        baja.setPreferredSize(new java.awt.Dimension(168, 40));
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(25, 5, 25, 5);
        jPanel1.add(baja, gridBagConstraints);

        modificar.setBackground(new java.awt.Color(255, 250, 250));
        modificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        modificar.setForeground(new java.awt.Color(51, 51, 51));
        modificar.setText("Modificar");
        modificar.setPreferredSize(new java.awt.Dimension(168, 40));
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(25, 5, 25, 5);
        jPanel1.add(modificar, gridBagConstraints);

        buscar.setBackground(new java.awt.Color(255, 250, 250));
        buscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buscar.setForeground(new java.awt.Color(51, 51, 51));
        buscar.setText("Buscar");
        buscar.setPreferredSize(new java.awt.Dimension(168, 40));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(25, 5, 25, 5);
        jPanel1.add(buscar, gridBagConstraints);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 600));

        logostarktrek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Star-Trek-Logo-PNG-Picture.png"))); // NOI18N
        jPanel2.add(logostarktrek, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 590, 140));

        inciar.setText("Iniciar");
        inciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inciarActionPerformed(evt);
            }
        });
        jPanel2.add(inciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, -1, -1));

        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jPanel2.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        try {
            if (getCiudadano()) {
                BuscarModificar modificar = new BuscarModificar(this, true);
                modificar.setLocationRelativeTo(null);
                modificar.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No hay ningun ciudadano creado",
                        "No existen ciudadanos", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DAO_Excep ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void crearplanetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearplanetaActionPerformed
        CrearPlaneta crearplaneta = new CrearPlaneta(this, true);
        crearplaneta.setLocationRelativeTo(null);
        crearplaneta.setVisible(true);
    }//GEN-LAST:event_crearplanetaActionPerformed

    private void crearciudadanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearciudadanoActionPerformed
        try {
            if (obtainPlanets().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay ningun planeta creado",
                        "No existen planetas", JOptionPane.ERROR_MESSAGE);
            } else {
                CrearCiudadano crearciudadano = new CrearCiudadano(this, true);
                crearciudadano.setLocationRelativeTo(null);
                crearciudadano.setVisible(true);
            }
        } catch (DAO_Excep ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_crearciudadanoActionPerformed

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        try {
            if (obtainPlanets().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay ningun planeta creado",
                        "No existen planetas", JOptionPane.ERROR_MESSAGE);
            } else {
                Baja baja = new Baja(this, true);
                baja.setLocationRelativeTo(null);
                baja.setVisible(true);
            }
        } catch (DAO_Excep ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bajaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

        try {
            if (getCiudadano()) {
                Buscar buscar = new Buscar(this, true);
                buscar.setLocationRelativeTo(null);
                buscar.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No hay ningun ciudadano creado",
                        "No existen ciudadanos", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DAO_Excep ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void inciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inciarActionPerformed
        Planeta p1 = new Planeta("Planeta1", "Andromeda", 100, "Calido", true, false);
        Planeta p2 = new Planeta("Planeta2", "Andromeda", 10, "Frio", true, false);
        Ser s1 = new Humano(40, "Masculino", "Juan");
        Ser s2 = new Humano(10, "Femenino", "Maria");
        try {
            createplaneta(p1);
            createplaneta(p2);
            JOptionPane.showMessageDialog(this, "Se ha registrado correctamente el planeta",
                    "Planeta Registrado", JOptionPane.INFORMATION_MESSAGE);
        } catch (PlanetaExcepcion ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Planeta No Registrado", JOptionPane.ERROR_MESSAGE);
        }
        try {
            createser(s1, p2);
            createser(s2, p1);
            JOptionPane.showMessageDialog(this, "Se ha registrado correctamente los ciudadanos",
                    "Ciudadanos Registrado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SerExcepcion ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Ciudadanos No Registrado", JOptionPane.ERROR_MESSAGE);
        } catch (DAO_Excep ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inciarActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        dispose();
    }//GEN-LAST:event_cerrarActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baja;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton crearciudadano;
    private javax.swing.JButton crearplaneta;
    private javax.swing.JButton inciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logostarktrek;
    private javax.swing.JLabel logostucom;
    private javax.swing.JToggleButton modificar;
    // End of variables declaration//GEN-END:variables
}
