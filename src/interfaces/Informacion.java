/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import clase_base_datos.Conexion_sql;
import static interfaces.Crear_usuario.tipo;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Informacion extends javax.swing.JFrame {

    public static String desdeF = "";
    public static String hastaF = "";

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;

    public Informacion() {
        initComponents();
        setTitle("Listado de usuario");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(550, 560);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound5 = new prueba_diseño.PanelRound();
        jComboBox2 = new javax.swing.JComboBox<>();
        barra_mover4 = new javax.swing.JLabel();
        panelRound9 = new prueba_diseño.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new prueba_diseño.PanelRound();
        jLabel12 = new javax.swing.JLabel();
        panelRound10 = new prueba_diseño.PanelRound();
        cmb_tipo = new javax.swing.JComboBox<>();
        e_estado_articulo1 = new javax.swing.JLabel();
        e_tipo_reporte2 = new javax.swing.JLabel();
        diaD = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        mesD = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        annoD = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        annoH = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        mesH = new javax.swing.JComboBox<>();
        mes = new javax.swing.JLabel();
        diaH = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        e_tipo_reporte = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Servicio Tecnico", "Cambio de Toner" }));
        panelRound5.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 70, 110, 40));
        panelRound5.add(barra_mover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 20));

        panelRound9.setBackground(new java.awt.Color(0, 102, 102));
        panelRound9.setRoundBottomLeft(50);
        panelRound9.setRoundBottomRight(50);
        panelRound9.setRoundTopLeft(50);
        panelRound9.setRoundTopRight(50);
        panelRound9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menuA/cerdo.png"))); // NOI18N
        panelRound9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 90));

        jLabel2.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menu Estadísticas");
        panelRound9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, 70));

        panelRound1.setBackground(new java.awt.Color(0, 102, 102));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_login/tarjeta-de-direccion (1).png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        panelRound1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        panelRound9.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 50, 40));

        panelRound5.add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 450, 80));

        getContentPane().add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 120));

        panelRound10.setBackground(new java.awt.Color(36, 22, 74));
        panelRound10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmb_tipo.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------", "Equipos", "Tecnologia General", "Cambio de Toner", "Servicios Tecnicos" }));
        cmb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipoActionPerformed(evt);
            }
        });
        panelRound10.add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 180, 40));

        e_estado_articulo1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        e_estado_articulo1.setForeground(new java.awt.Color(255, 255, 255));
        e_estado_articulo1.setText("Mostrar Área");
        panelRound10.add(e_estado_articulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 200, -1));

        e_tipo_reporte2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        e_tipo_reporte2.setForeground(new java.awt.Color(255, 255, 255));
        e_tipo_reporte2.setText("Desde:");
        panelRound10.add(e_tipo_reporte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, -1));

        diaD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        panelRound10.add(diaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 50, 30));

        jLabel4.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("día");
        panelRound10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        mesD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        panelRound10.add(mesD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 50, 30));

        jLabel5.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("mes");
        panelRound10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        annoD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));
        panelRound10.add(annoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 70, 30));

        jLabel3.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("año");
        panelRound10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        annoH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));
        panelRound10.add(annoH, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 70, 30));

        jLabel8.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("año");
        panelRound10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        mesH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        panelRound10.add(mesH, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 50, 30));

        mes.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        mes.setForeground(new java.awt.Color(255, 255, 255));
        mes.setText("mes");
        panelRound10.add(mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        diaH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        panelRound10.add(diaH, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 50, 30));

        jLabel6.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("día");
        panelRound10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        e_tipo_reporte.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        e_tipo_reporte.setForeground(new java.awt.Color(255, 255, 255));
        e_tipo_reporte.setText("Hasta:");
        panelRound10.add(e_tipo_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 70, -1));

        btn_buscar.setBackground(new java.awt.Color(38, 22, 74));
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setText("Generar Grafica");
        btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarMouseClicked(evt);
            }
        });
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        panelRound10.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 160, 100));

        getContentPane().add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 550, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        //
        if (tipo.equals("Administrador")) {
            dispose();
            Administrador menu = new Administrador();
            menu.setVisible(true);

        } else if (tipo.equals("Tecnico")) {
            dispose();
            Tecnico menu = new Tecnico();
            menu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Error del servidor");
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void cmb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipoActionPerformed
        int tipo = cmb_tipo.getSelectedIndex();

        if (tipo == 0) {

            diaD.setSelectedIndex(0);
            mesD.setSelectedIndex(0);
            annoD.setSelectedIndex(0);

            diaH.setSelectedIndex(0);
            mesH.setSelectedIndex(0);
            annoH.setSelectedIndex(0);

            diaD.setEnabled(false);
            mesD.setEnabled(false);
            annoD.setEnabled(false);

            diaH.setEnabled(false);
            mesH.setEnabled(false);
            annoH.setEnabled(false);

        } else if (tipo == 1) {

            diaD.setSelectedIndex(0);
            mesD.setSelectedIndex(0);
            annoD.setSelectedIndex(0);

            diaH.setSelectedIndex(0);
            mesH.setSelectedIndex(0);
            annoH.setSelectedIndex(0);

            diaD.setEnabled(false);
            mesD.setEnabled(false);
            annoD.setEnabled(false);

            diaH.setEnabled(false);
            mesH.setEnabled(false);
            annoH.setEnabled(false);

        } else if (tipo == 2) {

            diaD.setSelectedIndex(0);
            mesD.setSelectedIndex(0);
            annoD.setSelectedIndex(0);

            diaH.setSelectedIndex(0);
            mesH.setSelectedIndex(0);
            annoH.setSelectedIndex(0);

            diaD.setEnabled(false);
            mesD.setEnabled(false);
            annoD.setEnabled(false);

            diaH.setEnabled(false);
            mesH.setEnabled(false);
            annoH.setEnabled(false);

        } else if (tipo == 3) {

            diaD.setEnabled(true);
            mesD.setEnabled(true);
            annoD.setEnabled(true);

            diaH.setEnabled(true);
            mesH.setEnabled(true);
            annoH.setEnabled(true);

        } else if (tipo == 4) {

            diaD.setEnabled(true);
            mesD.setEnabled(true);
            annoD.setEnabled(true);

            diaH.setEnabled(true);
            mesH.setEnabled(true);
            annoH.setEnabled(true);

        } else {
        }

    }//GEN-LAST:event_cmb_tipoActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        String desde = annoD.getSelectedItem() + "-" + mesD.getSelectedItem() + "-" + diaD.getSelectedItem();
        String hasta = annoH.getSelectedItem() + "-" + mesH.getSelectedItem() + "-" + diaH.getSelectedItem();

        int tipo = cmb_tipo.getSelectedIndex();

        if (tipo == 0) {

            JOptionPane.showMessageDialog(null, "Selecciona un Area de informacion");

        } else if (tipo == 1) {

            Estadisticas_equipos eq = new Estadisticas_equipos();
            eq.setVisible(true);
            dispose();

        } else if (tipo == 2) {

            Estadisticas_reporte rp = new Estadisticas_reporte();
            rp.setVisible(true);
            dispose();

        } else if (tipo == 3) {

            desdeF = desde;
            hastaF = hasta;

            Estadisticas_cambioD ct = new Estadisticas_cambioD();
            ct.setVisible(true);
            dispose();

        } else if (tipo == 4) {

            desdeF = desde;
            hastaF = hasta;

            Estadisticas_servicio st = new Estadisticas_servicio();
            st.setVisible(true);
            dispose();

        } else {
        }
    }//GEN-LAST:event_btn_buscarMouseClicked

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
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> annoD;
    private javax.swing.JComboBox<String> annoH;
    private javax.swing.JLabel barra_mover4;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JComboBox<String> diaD;
    private javax.swing.JComboBox<String> diaH;
    private javax.swing.JLabel e_estado_articulo1;
    private javax.swing.JLabel e_tipo_reporte;
    private javax.swing.JLabel e_tipo_reporte2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel mes;
    private javax.swing.JComboBox<String> mesD;
    private javax.swing.JComboBox<String> mesH;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound10;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panelRound9;
    // End of variables declaration//GEN-END:variables

}
