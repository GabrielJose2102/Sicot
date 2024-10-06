package interfaces;

import clase_base_datos.Conexion_sql;
import static interfaces.Crear_usuario.tipo;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Listar_Usuarios extends javax.swing.JFrame {

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;

    public static int IDequipo_update = 0;
    public static String IDusuario_update = "";
    
    DefaultTableModel usuarioS = new DefaultTableModel();
    DefaultTableModel usuarioE = new DefaultTableModel();

    int num_usuarioS = 0;
    int num_usuarioE = 0;
    
    
    

    public Listar_Usuarios() {
        initComponents();
        setTitle("Listado de usuario");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(700, 920);

        scrol_usuariosS.setVisible(true);
        scrol_usuarioE.setVisible(false);

        cmb_us.setVisible(true);
        cmb_ue.setVisible(false);

        /*Llenado de Tabla Usuarios de sistema*/
        try {
            Connection cn2 = Conexion_sql.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "SELECT `cedula`, `nombre`, `apellido`, `nombre_usuario`,"
                    + " `contraseña`, `permiso`, `estado` FROM `usuarios_sistema` ORDER BY nombre ASC");
            ResultSet rs2 = pst2.executeQuery();

            tabla_usuarioS = new JTable(usuarioS);
            scrol_usuariosS.setViewportView(tabla_usuarioS);

            usuarioS.addColumn("Cedula");
            usuarioS.addColumn("Nombre");
            usuarioS.addColumn("Apellido");
            usuarioS.addColumn("usuario");
            usuarioS.addColumn("contraseña");
            usuarioS.addColumn("permiso");
            usuarioS.addColumn("estado");

            while (rs2.next()) {
                Object[] filas = new Object[7];

                for (int i = 0; i < 7; i++) {
                    filas[i] = rs2.getObject(i + 1);
                }
                num_usuarioS++;
                usuarioS.addRow(filas);
            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        /*Llenado de Tabla Usuario de equipo*/
        try {
            Connection cn2 = Conexion_sql.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "SELECT u.cedula, u.nombre, u.apellido, u.cargo,"
                    + " u.departamento, d.nombre_departamento FROM usuarios_equipos u"
                    + " INNER JOIN departamentos d ON u.departamento=d.codigo_departamento "
                    + "ORDER BY nombre ASC");
            ResultSet rs2 = pst2.executeQuery();

            tabla_usuarioE = new JTable(usuarioE);
            scrol_usuarioE.setViewportView(tabla_usuarioE);

            usuarioE.addColumn("Cedula");
            usuarioE.addColumn("Nombre");
            usuarioE.addColumn("Apellido");
            usuarioE.addColumn("Cargo");
            usuarioE.addColumn("Departamento");
            usuarioE.addColumn("nombre_departamento");

            while (rs2.next()) {
                Object[] filas = new Object[6];

                for (int i = 0; i < 6; i++) {
                    filas[i] = rs2.getObject(i + 1);
                }
                num_usuarioE++;
                usuarioE.addRow(filas);
            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }
        
        ObtenerDatosTablaS();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new prueba_diseño.PanelRound();
        scrol_usuariosS = new javax.swing.JScrollPane();
        tabla_usuarioS = new javax.swing.JTable();
        scrol_usuarioE = new javax.swing.JScrollPane();
        tabla_usuarioE = new javax.swing.JTable();
        panelRound5 = new prueba_diseño.PanelRound();
        panelRound8 = new prueba_diseño.PanelRound();
        i_cerdo = new javax.swing.JLabel();
        e_listar_usuarios_titulo = new javax.swing.JLabel();
        b_salir = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        barra_mover4 = new javax.swing.JLabel();
        cmb_tipo_lista = new javax.swing.JComboBox<>();
        e_tipo_listado = new javax.swing.JLabel();
        e_ue = new javax.swing.JLabel();
        cmb_ue = new javax.swing.JComboBox<>();
        cmb_us = new javax.swing.JComboBox<>();
        e_us = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_usuarioS.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        tabla_usuarioS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Usuario", "Contraseña", "Permisso", "Estado"
            }
        ));
        scrol_usuariosS.setViewportView(tabla_usuarioS);

        panelRound1.add(scrol_usuariosS, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, 600, 450));

        tabla_usuarioE.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        tabla_usuarioE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Cargo", "Departamento"
            }
        ));
        scrol_usuarioE.setViewportView(tabla_usuarioE);

        panelRound1.add(scrol_usuarioE, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, 600, 450));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 280, 650, 500));

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
        e_listar_usuarios_titulo.setText("Listar Usuarios");
        panelRound8.add(e_listar_usuarios_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 270, 100));

        b_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_login/tarjeta-de-direccion (1).png"))); // NOI18N
        b_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_salirMouseClicked(evt);
            }
        });
        panelRound8.add(b_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 80, 60));

        panelRound5.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 600, 100));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Servicio Tecnico", "Cambio de Toner" }));
        panelRound5.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 70, 110, 40));

        barra_mover4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barra_mover4MouseDragged(evt);
            }
        });
        barra_mover4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barra_mover4MousePressed(evt);
            }
        });
        panelRound5.add(barra_mover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 20));

        jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 130));

        cmb_tipo_lista.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cmb_tipo_lista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USUARIOS DE SISTEMA", "USUARIOS DE EQUIPOS" }));
        cmb_tipo_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipo_listaActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_tipo_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 170, 40));

        e_tipo_listado.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        e_tipo_listado.setForeground(new java.awt.Color(255, 255, 255));
        e_tipo_listado.setText("Tipo de Listado");
        jPanel1.add(e_tipo_listado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 200, -1));

        e_ue.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        e_ue.setForeground(new java.awt.Color(255, 255, 255));
        e_ue.setText("Ordenar por:");
        jPanel1.add(e_ue, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 160, -1));

        cmb_ue.setFont(new java.awt.Font("Serif", 0, 11)); // NOI18N
        cmb_ue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------", "Nombre", "Departamento" }));
        cmb_ue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ueActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_ue, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 170, 40));

        cmb_us.setFont(new java.awt.Font("Serif", 0, 11)); // NOI18N
        cmb_us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------", "Nombre", "Usuario", "Estado" }));
        cmb_us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_usActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 170, 40));

        e_us.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        e_us.setForeground(new java.awt.Color(255, 255, 255));
        e_us.setText("Ordenar por:");
        jPanel1.add(e_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 920));

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

    private void barra_mover4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barra_mover4MouseDragged
        //Obtener posicion x,y de la interfaz al arrastrar con el mouse
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        //Posicionar la ventana segun los valores obtenidos
        this.setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_barra_mover4MouseDragged

    private void barra_mover4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barra_mover4MousePressed
        //Obtener posiciones x,y del mouse cuando se mantiene presionado
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_barra_mover4MousePressed

    private void cmb_tipo_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipo_listaActionPerformed
        if (cmb_tipo_lista.getSelectedIndex() == 0) {

            scrol_usuariosS.setVisible(true);
            scrol_usuarioE.setVisible(false);

            e_us.setVisible(true);
            cmb_us.setVisible(true);
            e_ue.setVisible(false);
            cmb_ue.setVisible(false);

        } else if (cmb_tipo_lista.getSelectedIndex() == 1) {

            scrol_usuariosS.setVisible(false);
            scrol_usuarioE.setVisible(true);

            e_us.setVisible(false);
            cmb_us.setVisible(false);
            e_ue.setVisible(true);
            cmb_ue.setVisible(true);

        } else {

        }
    }//GEN-LAST:event_cmb_tipo_listaActionPerformed

    private void cmb_usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_usActionPerformed
        if (cmb_us.getSelectedIndex() == 1) {

            usuarioS.setRowCount(0);
            usuarioS.setColumnCount(0);

            /*Llenado de Tabla Usuarios de sistema*/
            try {
                Connection cn2 = Conexion_sql.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        "SELECT `cedula`, `nombre`, `apellido`, `nombre_usuario`,"
                        + " `contraseña`, `permiso`, `estado` FROM `usuarios_sistema` ORDER BY nombre ASC");
                ResultSet rs2 = pst2.executeQuery();

                tabla_usuarioS = new JTable(usuarioS);
                scrol_usuariosS.setViewportView(tabla_usuarioS);

                usuarioS.addColumn("Cedula");
                usuarioS.addColumn("Nombre");
                usuarioS.addColumn("Apellido");
                usuarioS.addColumn("usuario");
                usuarioS.addColumn("contraseña");
                usuarioS.addColumn("permiso");
                usuarioS.addColumn("estado");

                while (rs2.next()) {
                    Object[] filas = new Object[7];

                    for (int i = 0; i < 7; i++) {
                        filas[i] = rs2.getObject(i + 1);
                    }
                    num_usuarioS++;
                    usuarioS.addRow(filas);
                }
                cn2.close();

            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
            }

        } else if (cmb_us.getSelectedIndex() == 2) {

            usuarioS.setRowCount(0);
            usuarioS.setColumnCount(0);

            /*Llenado de Tabla Usuarios de sistema*/
            try {
                Connection cn2 = Conexion_sql.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        "SELECT `cedula`, `nombre`, `apellido`, `nombre_usuario`,"
                        + " `contraseña`, `permiso`, `estado` FROM `usuarios_sistema` ORDER BY nombre_usuario ASC");
                ResultSet rs2 = pst2.executeQuery();

                tabla_usuarioS = new JTable(usuarioS);
                scrol_usuariosS.setViewportView(tabla_usuarioS);

                usuarioS.addColumn("Cedula");
                usuarioS.addColumn("Nombre");
                usuarioS.addColumn("Apellido");
                usuarioS.addColumn("usuario");
                usuarioS.addColumn("contraseña");
                usuarioS.addColumn("permiso");
                usuarioS.addColumn("estado");

                while (rs2.next()) {
                    Object[] filas = new Object[7];

                    for (int i = 0; i < 7; i++) {
                        filas[i] = rs2.getObject(i + 1);
                    }
                    num_usuarioS++;
                    usuarioS.addRow(filas);
                }
                cn2.close();

            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
            }

        } else if (cmb_us.getSelectedIndex() == 3) {

            usuarioS.setRowCount(0);
            usuarioS.setColumnCount(0);

            /*Llenado de Tabla Usuarios de sistema*/
            try {
                Connection cn2 = Conexion_sql.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        "SELECT `cedula`, `nombre`, `apellido`, `nombre_usuario`,"
                        + " `contraseña`, `permiso`, `estado` FROM `usuarios_sistema` ORDER BY estado ASC");
                ResultSet rs2 = pst2.executeQuery();

                tabla_usuarioS = new JTable(usuarioS);
                scrol_usuariosS.setViewportView(tabla_usuarioS);

                usuarioS.addColumn("Cedula");
                usuarioS.addColumn("Nombre");
                usuarioS.addColumn("Apellido");
                usuarioS.addColumn("usuario");
                usuarioS.addColumn("contraseña");
                usuarioS.addColumn("permiso");
                usuarioS.addColumn("estado");

                while (rs2.next()) {
                    Object[] filas = new Object[7];

                    for (int i = 0; i < 7; i++) {
                        filas[i] = rs2.getObject(i + 1);
                    }
                    num_usuarioS++;
                    usuarioS.addRow(filas);
                }
                cn2.close();

            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
            }

        } else {

        }
    }//GEN-LAST:event_cmb_usActionPerformed

    private void cmb_ueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_ueActionPerformed
        if (cmb_us.getSelectedIndex() == 1) {

            usuarioE.setRowCount(0);
            usuarioE.setColumnCount(0);

            /*Llenado de Tabla Usuario de equipo*/
            try {
                Connection cn2 = Conexion_sql.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        "SELECT u.cedula, u.nombre, u.apellido, u.cargo,"
                        + " u.departamento, d.nombre_departamento FROM usuarios_equipos u"
                        + " INNER JOIN departamentos d ON u.departamento=d.codigo_departamento "
                        + "ORDER BY nombre ASC");
                ResultSet rs2 = pst2.executeQuery();

                tabla_usuarioE = new JTable(usuarioE);
                scrol_usuarioE.setViewportView(tabla_usuarioE);

                usuarioE.addColumn("Cedula");
                usuarioE.addColumn("Nombre");
                usuarioE.addColumn("Apellido");
                usuarioE.addColumn("Cargo");
                usuarioE.addColumn("Departamento");
                usuarioE.addColumn("nombre_departamento");

                while (rs2.next()) {
                    Object[] filas = new Object[6];

                    for (int i = 0; i < 6; i++) {
                        filas[i] = rs2.getObject(i + 1);
                    }
                    num_usuarioE++;
                    usuarioE.addRow(filas);
                }
                cn2.close();

            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
            }

        } else if (cmb_ue.getSelectedIndex() == 2) {

            usuarioE.setRowCount(0);
            usuarioE.setColumnCount(0);

            /*Llenado de Tabla Usuario de equipo*/
            try {
                Connection cn2 = Conexion_sql.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        "SELECT u.cedula, u.nombre, u.apellido, u.cargo,"
                        + " u.departamento, d.nombre_departamento FROM usuarios_equipos u"
                        + " INNER JOIN departamentos d ON u.departamento=d.codigo_departamento "
                        + "ORDER BY u.departamento ASC");
                ResultSet rs2 = pst2.executeQuery();

                tabla_usuarioE = new JTable(usuarioE);
                scrol_usuarioE.setViewportView(tabla_usuarioE);

                usuarioE.addColumn("Cedula");
                usuarioE.addColumn("Nombre");
                usuarioE.addColumn("Apellido");
                usuarioE.addColumn("Cargo");
                usuarioE.addColumn("Departamento");
                usuarioE.addColumn("nombre_departamento");

                while (rs2.next()) {
                    Object[] filas = new Object[6];

                    for (int i = 0; i < 6; i++) {
                        filas[i] = rs2.getObject(i + 1);
                    }
                    num_usuarioE++;
                    usuarioE.addRow(filas);
                }
                cn2.close();

            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
            }

        } else {

        }
    }//GEN-LAST:event_cmb_ueActionPerformed

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
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_salir;
    private javax.swing.JLabel barra_mover4;
    private javax.swing.JComboBox<String> cmb_tipo_lista;
    private javax.swing.JComboBox<String> cmb_ue;
    private javax.swing.JComboBox<String> cmb_us;
    private javax.swing.JLabel e_listar_usuarios_titulo;
    private javax.swing.JLabel e_tipo_listado;
    private javax.swing.JLabel e_ue;
    private javax.swing.JLabel e_us;
    private javax.swing.JLabel i_cerdo;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JPanel jPanel1;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panelRound8;
    private javax.swing.JScrollPane scrol_usuarioE;
    private javax.swing.JScrollPane scrol_usuariosS;
    private javax.swing.JTable tabla_usuarioE;
    private javax.swing.JTable tabla_usuarioS;
    // End of variables declaration//GEN-END:variables

    public void ObtenerDatosTablaS() {
        tabla_usuarioS.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla_usuarioS.rowAtPoint(e.getPoint());
                int columna_point = 3;

                if (fila_point > -1) {
                    IDusuario_update = (String) usuarioS.getValueAt(fila_point, columna_point);
                    Modificar_usuarios info = new Modificar_usuarios();
                    info.setVisible(true);
                    dispose();
                }
            }
        });
    }
}
