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
public class Estadisticas_equipos extends javax.swing.JFrame {

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;
    
    
    int[] vector_marcas_cantidad = new int[4];
    String[] vector_tipos_nombre = new String[4];
    int revision, uso, almacen, desuso;
    
    
    /**
     * Creates new form Estadisticas_reporte
     */
    public Estadisticas_equipos() {
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
                    "select estado_equipo, count(estado_equipo) as Equipos from equipos group by estado_equipo");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;
                do {
                    vector_tipos_nombre[posicion] = rs.getString(1);
                    vector_marcas_cantidad[posicion] = rs.getInt(2);

                    
                    if (vector_tipos_nombre[posicion].equalsIgnoreCase("Almacen")) {
                        almacen = vector_marcas_cantidad[posicion];
                    } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("En desuso")) {
                        desuso = vector_marcas_cantidad[posicion];
                    } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("En uso")) {
                        revision = vector_marcas_cantidad[posicion];
                    } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("En revision")) {
                        uso = vector_marcas_cantidad[posicion];
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
        e_listar_usuarios_titulo.setText("Resumen Equipos");
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
            java.util.logging.Logger.getLogger(Estadisticas_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadisticas_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadisticas_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadisticas_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estadisticas_equipos().setVisible(true);
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

        int total_estados =  revision + uso + almacen + desuso;

       
        int grados_almacen = almacen * 360 / total_estados;
        int grados_desuso = desuso * 360 / total_estados;
        int grados_revision = revision * 360 / total_estados;
        int grados_uso = uso * 360 / total_estados;

        

        //Equipos en almacen
        g.setColor(new Color(153,153,0));//calor Amarillo
        g.fillArc(50, 200, 270, 270, 0, grados_almacen);
        g.fillRect(360, 250, 20, 20);
        g.drawString(almacen + " Almacen", 400, 265);

        //Equipos en desuso
        g.setColor(new Color(153,51,0));//calor Naranja
        g.fillArc(50, 200, 270, 270, grados_almacen, grados_desuso);
        g.fillRect(360, 280, 20, 20);
        g.drawString(desuso + " En desuso", 400, 295);

        //Equipos en uso
        g.setColor(new Color(0,0,102));//calor Azul
        g.fillArc(50, 200, 270, 270, grados_almacen + grados_desuso, grados_revision);
        g.fillRect(360, 310, 20, 20);
        g.drawString(revision + " En uso", 400, 325);

        //Equipos en revision
        g.setColor(new Color(0,102,0));//calor Verde
        g.fillArc(50, 200, 270, 270, grados_almacen + grados_desuso + grados_revision, grados_uso);
        g.fillRect(360, 340, 20, 20);
        g.drawString(uso + " En revision", 400, 355);
        
        //Total
        g.setColor(new Color(0,102,102));//calor Verde
        g.fillRect(360, 420, 20, 20);
        g.drawString(total_estados + " Total de Equipos", 400, 435);

    }


}
