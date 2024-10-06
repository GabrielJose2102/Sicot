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
public class Estadisticas_cambioD extends javax.swing.JFrame {

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;

    String desde = Informacion.desdeF;
    String hasta = Informacion.hastaF;

    int[] vector_marcas_cantidad = new int[19];
    String[] vector_tipos_nombre = new String[19];
    int OGH, AUI, COJ, CBI, COC, CCT, CMER, CSG, CTE, DAG, GCC, GCM, GGE, OGA, OPP, OTI, GPR, GPC, SAS;

    /**
     * Creates new form Estadisticas_reporte
     */
    public Estadisticas_cambioD() {
        initComponents();
        setTitle("Estadisticas de Cambio de Toner");
        setResizable(false);
        setSize(1100, 760);

        System.out.println(desde);
        System.out.println(hasta);
        //select tipo_equipo, count(tipo_equipo) as Equipos from equipos group by tipo_equipo
        //select tipo_reporte, count(tipo_reporte) as Reportes from reporte_detallado group by tipo_reporte

        //SELECT id_departamento, COUNT(*) AS total_reportes FROM reporte_detallado WHERE tipo_reporte = 'cambio de tóner' GROUP BY ID_departamento
        //SELECT id_departamento, COUNT(id_departamento) AS total_reportes FROM reporte_detallado WHERE tipo_reporte = 'cambio de tóner' AND fecha_ejecucion BETWEEN '2023-01-15' AND '2024-01-10' GROUP BY id_departamento
        
        
        if (!desde.equals("----------") && !hasta.equals("----------")) {

                e_toner.setText("Cambios de Toner: " + desde + "   " + hasta);
            
            try {
                Connection cn = Conexion_sql.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT id_departamento, COUNT(id_departamento) AS total_reportes "
                                + "FROM reporte_detallado "
                                + "WHERE tipo_reporte = 'Cambio de Toner' "
                                + "AND fecha_ejecucion BETWEEN '" + desde + "' AND '" + hasta + "'"
                                + "GROUP BY id_departamento");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    int posicion = 0;
                    do {
                        vector_tipos_nombre[posicion] = rs.getString(1);
                        vector_marcas_cantidad[posicion] = rs.getInt(2);

                        if (vector_tipos_nombre[posicion].equalsIgnoreCase("OFICINA DE GESTION HUMANA")) {
                            OGH = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("AUDITORIA INTERNA")) {
                            AUI = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("CONSULTORIA JURIDICA")) {
                            COJ = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE BIENES")) {
                            CBI = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE COMPRAS")) {
                            COC = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE CONTABILIDAD")) {
                            CCT = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE MERCADEO")) {
                            CMER = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE SERVICIOS GENERALES")) {
                            CSG = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE TESORERIA")) {
                            CTE = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("DELAGRO")) {
                            DAG = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("GERENCIA DE CALIDAD")) {
                            GCC = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("GERENCIA DE COMERCIALIZACIÓN Y LOGÍSTICA")) {
                            GCM = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("GERENCIA GENERAL")) {
                            GGE = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("OFICINA DE GESTION ADMINISTRATIVA")) {
                            OGA = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("OFICINA DE PLANIFICACIÓN Y PRESUPUESTO")) {
                            OPP = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("OFICINA DE TECNOLOGÍAS DE LA INFORMACION")) {
                            OTI = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("PRESIDENCIA")) {
                            GPR = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("PRODUCCION Y ASISTENCIA TECNICA")) {
                            GPC = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("SAS")) {
                            SAS = vector_marcas_cantidad[posicion];
                        }
                        
                        posicion++;
                    } while (rs.next());
                }

            } catch (SQLException e) {
                System.err.println("Error en la consulta" + e);
                JOptionPane.showMessageDialog(null, "Error en consultar datos. Contacte al administrador.");
            }

        } else {

            try {
                Connection cn = Conexion_sql.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT id_departamento, COUNT(id_departamento) AS total_reportes "
                        + "FROM reporte_detallado "
                        + "WHERE tipo_reporte = 'Cambio de Toner' "
                        + "GROUP BY id_departamento");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    int posicion = 0;
                    do {
                        vector_tipos_nombre[posicion] = rs.getString(1);
                        vector_marcas_cantidad[posicion] = rs.getInt(2);

                        if (vector_tipos_nombre[posicion].equalsIgnoreCase("OFICINA DE GESTION HUMANA")) {
                            OGH = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("AUDITORIA INTERNA")) {
                            AUI = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("CONSULTORIA JURIDICA")) {
                            COJ = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE BIENES")) {
                            CBI = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE COMPRAS")) {
                            COC = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE CONTABILIDAD")) {
                            CCT = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE MERCADEO")) {
                            CMER = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE SERVICIOS GENERALES")) {
                            CSG = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("COORDINACION DE TESORERIA")) {
                            CTE = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("DELAGRO")) {
                            DAG = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("GERENCIA DE CALIDAD")) {
                            GCC = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("GERENCIA DE COMERCIALIZACIÓN Y LOGÍSTICA")) {
                            GCM = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("GERENCIA GENERAL")) {
                            GGE = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("OFICINA DE GESTION ADMINISTRATIVA")) {
                            OGA = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("OFICINA DE PLANIFICACIÓN Y PRESUPUESTO")) {
                            OPP = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("OFICINA DE TECNOLOGÍAS DE LA INFORMACION")) {
                            OTI = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("PRESIDENCIA")) {
                            GPR = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("PRODUCCION Y ASISTENCIA TECNICA")) {
                            GPC = vector_marcas_cantidad[posicion];
                        } else if (vector_tipos_nombre[posicion].equalsIgnoreCase("SAS")) {
                            SAS = vector_marcas_cantidad[posicion];
                        }

                        posicion++;
                    } while (rs.next());
                }

            } catch (SQLException e) {
                System.err.println("Error en la consulta" + e);
                JOptionPane.showMessageDialog(null, "Error en consultar datos. Contacte al administrador.");
            }

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
        barra_mover4 = new javax.swing.JLabel();
        e_toner = new javax.swing.JLabel();

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
        e_listar_usuarios_titulo.setText("Resumen de Cambios de Tóner ");
        panelRound8.add(e_listar_usuarios_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 410, 100));

        b_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_login/tarjeta-de-direccion (1).png"))); // NOI18N
        b_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_salirMouseClicked(evt);
            }
        });
        panelRound8.add(b_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 80, 60));

        panelRound5.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 900, 100));
        panelRound5.add(barra_mover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 20));

        getContentPane().add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 130));

        e_toner.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        e_toner.setForeground(new java.awt.Color(0, 0, 0));
        e_toner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e_toner.setText("Cambios de Tóner ");
        getContentPane().add(e_toner, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 540, -1));

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
            java.util.logging.Logger.getLogger(Estadisticas_cambioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadisticas_cambioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadisticas_cambioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadisticas_cambioD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estadisticas_cambioD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_salir;
    private javax.swing.JLabel barra_mover4;
    private javax.swing.JLabel e_listar_usuarios_titulo;
    private javax.swing.JLabel e_toner;
    private javax.swing.JLabel i_cerdo;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panelRound8;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int total_estados = OGH + AUI + COJ + CBI + COC + CCT + CMER + CSG + CTE + DAG + GCC + GCM + GGE + OGA + OPP + OTI + GPR + GPC + SAS;

        int grados_OGH = OGH * 360 / total_estados;
        int grados_AUI = AUI * 360 / total_estados;
        int grados_COJ = COJ * 360 / total_estados;
        int grados_CBI = CBI * 360 / total_estados;
        int grados_COC = COC * 360 / total_estados;
        int grados_CCT = CCT * 360 / total_estados;
        int grados_CMER = CMER * 360 / total_estados;
        int grados_CSG = CSG * 360 / total_estados;
        int grados_CTE = CTE * 360 / total_estados;
        int grados_DAG = DAG * 360 / total_estados;
        int grados_GCC = GCC * 360 / total_estados;
        int grados_GCM = GCM * 360 / total_estados;
        int grados_GGE = GGE * 360 / total_estados;
        int grados_OGA = OGA * 360 / total_estados;
        int grados_OPP = OPP * 360 / total_estados;
        int grados_OTI = OTI * 360 / total_estados;
        int grados_GPR = GPR * 360 / total_estados;
        int grados_GPC = GPC * 360 / total_estados;
        int grados_SAS = SAS * 360 / total_estados;

        //Gerencia de Administracion 1
        g.setColor(new Color(0, 51, 204));
        g.fillArc(50, 300, 270, 270, 0, grados_OGH);
        g.fillRect(360, 200, 20, 20);
        g.drawString(OGH + " OFICINA DE GESTION HUMANA", 400, 215);

        //Auditoria Interna 2
        g.setColor(new Color(153, 0, 51));
        g.fillArc(50, 300, 270, 270, grados_OGH, grados_AUI);
        g.fillRect(360, 240, 20, 20);
        g.drawString(AUI + " AUDITORIA INTERNA", 400, 255);

        //Oficina de Compras 3
        g.setColor(new Color(153, 153, 0));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI, grados_COJ);
        g.fillRect(360, 280, 20, 20);
        g.drawString(COJ + " CONSULTORIA JURIDICA", 400, 295);

        //Gerencia de Consultoria Juridica 4
        g.setColor(new Color(102, 102, 0));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ, grados_CBI);
        g.fillRect(360, 320, 20, 20);
        g.drawString(CBI + " COORDINACION DE BIENES", 400, 335);

        //Gerencia de servicios Generales 5
        g.setColor(new Color(153, 0, 153));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI, grados_COC);
        g.fillRect(360, 360, 20, 20);
        g.drawString(COC + " COORDINACION DE COMPRAS", 400, 375);

        //Gerencia de Comercializacion y logistica 6
        g.setColor(new Color(0, 102, 102));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC, grados_CCT);
        g.fillRect(360, 400, 20, 20);
        g.drawString(CCT + " COORDINACION DE CONTABILIDAD", 400, 415);

        //Gerencia de calidad 7
        g.setColor(new Color(200, 100, 50));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT, grados_CMER);
        g.fillRect(360, 440, 20, 20);
        g.drawString(CMER + " COORDINACION DE MERCADEO", 400, 455);

        //Gerencia General 8
        g.setColor(new Color(102, 102, 255));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER, grados_CSG);
        g.fillRect(360, 480, 20, 20);
        g.drawString(CSG + " COORDINACION DE SERVICIOS GENERALES", 400, 495);

        //Gerencia de Gestion Humana 9
        g.setColor(new Color(255, 102, 102));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG, grados_CTE);
        g.fillRect(360, 520, 20, 20);
        g.drawString(CTE + " COORDINACION DE TESORERIA", 400, 535);

        //Gerencia de Produccion y Asistencia Tecnica 10
        g.setColor(new Color(51, 51, 0));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG + grados_CTE, grados_DAG);
        g.fillRect(360, 560, 20, 20);
        g.drawString(DAG + " DELAGRO", 400, 575);

        //Gerencia de Tecnologia de la informacion 11
        g.setColor(new Color(0, 102, 0));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG + grados_CTE + grados_DAG, grados_GCC);
        g.fillRect(700, 200, 20, 20);
        g.drawString(GCC + " GERENCIA DE CALIDAD", 740, 215);

        //Oficina de Planificacion y presupuesto 12
        g.setColor(new Color(51, 0, 51));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG + grados_CTE + grados_DAG + grados_GCC, grados_GCM);
        g.fillRect(700, 240, 20, 20);
        g.drawString(GCM + " GERENCIA DE COMERCIALIZACIÓN Y LOGÍSTICA", 740, 255);

        //SAS 13
        g.setColor(new Color(153, 100, 200));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG + grados_CTE + grados_DAG + grados_GCC + grados_GCM, grados_GGE);
        g.fillRect(700, 280, 20, 20);
        g.drawString(GGE + " GERENCIA GENERAL", 740, 295);

        //ADMINISTRATIVA  14
        g.setColor(new Color(0, 0, 0));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG + grados_CTE + grados_DAG + grados_GCC + grados_GCM + grados_GGE, grados_OGA);
        g.fillRect(700, 320, 20, 20);
        g.drawString(OGA + " OFICINA DE GESTION ADMINISTRATIVA", 740, 335);
        
        //PLANIFICACIÓN Y PRESUPUESTO  15
        g.setColor(new Color(100, 0, 20));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG + grados_CTE + grados_DAG + grados_GCC + grados_GCM + grados_GGE + grados_OGA, grados_OPP);
        g.fillRect(700, 360, 20, 20);
        g.drawString(OPP + " OFICINA DE PLANIFICACIÓN Y PRESUPUESTO", 740, 375);
        
        //TECNOLOGÍAS 16
        g.setColor(new Color(0, 20, 100));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG + grados_CTE + grados_DAG + grados_GCC + grados_GCM + grados_GGE + grados_OGA + grados_OPP, grados_OTI);
        g.fillRect(700, 400, 20, 20);
        g.drawString(OTI + " OFICINA DE TECNOLOGÍAS DE LA INFORMACION", 740, 415);
        
        //Presidencia  17
        g.setColor(new Color(200, 100, 90));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG + grados_CTE + grados_DAG + grados_GCC + grados_GCM + grados_GGE + grados_OGA + grados_OPP + grados_OTI, grados_GPR);
        g.fillRect(700, 440, 20, 20);
        g.drawString(GPR + " PRESIDENCIA", 740, 455);
        
        //PRODUCCION  18
        g.setColor(new Color(200, 120, 10));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG + grados_CTE + grados_DAG + grados_GCC + grados_GCM + grados_GGE+ grados_OGA + grados_OPP + grados_OTI + grados_GPR, grados_GPC);
        g.fillRect(700, 480, 20, 20);
        g.drawString(GPC + " PRODUCCION Y ASISTENCIA TECNICA", 740, 495);
        
        //SAS  19
        g.setColor(new Color(150, 80, 50));
        g.fillArc(50, 300, 270, 270, grados_OGH + grados_AUI + grados_COJ + grados_CBI + grados_COC + grados_CCT + grados_CMER + grados_CSG + grados_CTE + grados_DAG + grados_GCC + grados_GCM + grados_GGE + grados_OGA + grados_OPP + grados_OTI + grados_GPR + grados_GPC, grados_SAS);
        g.fillRect(700, 520, 20, 20);
        g.drawString(SAS + " SAS", 740, 535);
        
        //Total de Cambios de toner
        g.setColor(new Color(60, 80, 100));
        g.fillRect(600, 650, 30, 30);
        g.drawString(total_estados + " Total", 640, 670);

    }

}
