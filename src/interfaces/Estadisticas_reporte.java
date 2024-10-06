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

/**
 *
 * @author usuario
 */
public class Estadisticas_reporte extends javax.swing.JFrame {

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;
    
    
    int[] vector_marcas_cantidad = new int[2];
    String[] vector_tipos_nombre = new String[2];
    int servicio_tecnico, Cambio_toner;
    
    
    /**
     * Creates new form Estadisticas_reporte
     */
    public Estadisticas_reporte() {
        initComponents();
        setTitle("Listado de usuario");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(550, 560);
        
        
        //select tipo_equipo, count(tipo_equipo) as Equipos from equipos group by tipo_equipo
        //select tipo_reporte, count(tipo_reporte) as Reportes from reporte_detallado group by tipo_reporte
        
        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select tipo_reporte, count(tipo_reporte) as Reportes from reporte_detallado group by tipo_reporte");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;
                do {
                    vector_tipos_nombre[posicion] = rs.getString(1);
                    vector_marcas_cantidad[posicion] = rs.getInt(2);

                    if (vector_tipos_nombre[posicion].equalsIgnoreCase("Cambio de Toner")) {
                        Cambio_toner = vector_marcas_cantidad[posicion];
                    } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("Servicio Tecnico")) {
                        servicio_tecnico = vector_marcas_cantidad[posicion];
                    } 
                    posicion++;
                } while (rs.next());
            }

        } catch (SQLException e) {
            System.err.println("Error en la consulta" + e);
            JOptionPane.showMessageDialog(null, "Error en consultar datos. Contacte al administrador.");
        }
        
        repaint();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound5 = new prueba_diseño.PanelRound();
        panelRound8 = new prueba_diseño.PanelRound();
        i_cerdo = new javax.swing.JLabel();
        e_listar_usuarios_titulo = new javax.swing.JLabel();
        b_salir = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        barra_mover4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound8.setBackground(new java.awt.Color(36, 22, 74));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);
        panelRound8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i_cerdo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        i_cerdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menuA/cerdo.png"))); // NOI18N
        panelRound8.add(i_cerdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 100));

        e_listar_usuarios_titulo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        e_listar_usuarios_titulo.setForeground(new java.awt.Color(255, 255, 255));
        e_listar_usuarios_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e_listar_usuarios_titulo.setText("Resumen Actividades");
        panelRound8.add(e_listar_usuarios_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 270, 100));

        b_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_login/tarjeta-de-direccion (1).png"))); // NOI18N
        b_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_salirMouseClicked(evt);
            }
        });
        panelRound8.add(b_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 80, 60));

        panelRound5.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 500, 100));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Servicio Tecnico", "Cambio de Toner" }));
        panelRound5.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 70, 110, 40));
        panelRound5.add(barra_mover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 20));

        getContentPane().add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_salirMouseClicked
        //Boton
        //Salir de la interface
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
    }//GEN-LAST:event_b_salirMouseClicked

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
            java.util.logging.Logger.getLogger(Estadisticas_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadisticas_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadisticas_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadisticas_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estadisticas_reporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_salir;
    private javax.swing.JLabel barra_mover4;
    private javax.swing.JLabel e_listar_usuarios_titulo;
    private javax.swing.JLabel i_cerdo;
    private javax.swing.JComboBox<String> jComboBox2;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panelRound8;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int total_marcas =  servicio_tecnico + Cambio_toner;

       
        int grados_servicio_tecnico = servicio_tecnico * 360 / total_marcas;
        int grados_Cambio_toner = Cambio_toner * 360 / total_marcas;

        

        //Cambio_toner
        g.setColor(new Color(21, 42, 160));//calor azul marino
        g.fillArc(50, 200, 270, 270, 0, grados_Cambio_toner);
        g.fillRect(360, 300, 20, 20);
        g.drawString(Cambio_toner + " Cambio de toner", 400, 315);

        //servicio_tecnico
        g.setColor(new Color(215, 96, 0));//calor naranja
        g.fillArc(50, 200, 270, 270, grados_Cambio_toner, grados_servicio_tecnico);
        g.fillRect(360, 330, 20, 20);
        g.drawString(servicio_tecnico + " Servicio tecnico", 400, 345);
        
        
        //Total
        g.setColor(new Color(0,102,102));//calor Verde
        g.fillRect(360, 470, 20, 20);
        g.drawString(total_marcas + " Total Actividades", 400, 485);

    }


}
