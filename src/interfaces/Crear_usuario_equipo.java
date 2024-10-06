package interfaces;

import clase_base_datos.Conexion_sql;
import funcionabilidad.ValidacionesGenerales;
import funcionabilidad.ValidacionesIndividual;
import static interfaces.Crear_usuario.tipo;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Crear_usuario_equipo extends javax.swing.JFrame {

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;

    public Crear_usuario_equipo() {
        initComponents();
        setTitle("Crear Usuario Equipo");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500, 620);

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_departamento FROM `departamentos`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_departamento.addItem(rs.getString("nombre_departamento"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound10 = new prueba_diseño.PanelRound();
        panelRound8 = new prueba_diseño.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new prueba_diseño.PanelRound();
        salir = new javax.swing.JLabel();
        p_rgistro_usuario_nombre_usuario = new prueba_diseño.PanelRound();
        txt_nombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_departamento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        p_rgistro_usuario_cedula = new prueba_diseño.PanelRound();
        txt_cedula = new javax.swing.JTextField();
        p_rgistro_usuario_nombre = new prueba_diseño.PanelRound();
        txt_cargo = new javax.swing.JTextField();
        p_rgistro_usuario_contraseña = new prueba_diseño.PanelRound();
        txt_apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        p_registro = new prueba_diseño.PanelRound();
        b_registrar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        barra_mover4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound10.setBackground(new java.awt.Color(0, 102, 102));
        panelRound10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound8.setBackground(new java.awt.Color(36, 22, 74));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);
        panelRound8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menuA/cerdo.png"))); // NOI18N
        panelRound8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registro Usuario de Equipo");
        panelRound8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, 70));

        panelRound1.setBackground(new java.awt.Color(36, 22, 74));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_login/tarjeta-de-direccion (1).png"))); // NOI18N
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        panelRound1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        panelRound8.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 50, 40));

        panelRound10.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, 80));

        p_rgistro_usuario_nombre_usuario.setRoundBottomLeft(50);
        p_rgistro_usuario_nombre_usuario.setRoundBottomRight(50);
        p_rgistro_usuario_nombre_usuario.setRoundTopLeft(50);
        p_rgistro_usuario_nombre_usuario.setRoundTopRight(50);
        p_rgistro_usuario_nombre_usuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.setBackground(new java.awt.Color(218, 215, 220));
        txt_nombre.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(null);
        p_rgistro_usuario_nombre_usuario.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        panelRound10.add(p_rgistro_usuario_nombre_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 275, 180, 50));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre");
        panelRound10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 235, 160, -1));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Departamento");
        panelRound10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 140, -1));

        cmb_departamento.setForeground(new java.awt.Color(36, 22, 74));
        cmb_departamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));
        cmb_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departamentoActionPerformed(evt);
            }
        });
        panelRound10.add(cmb_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 180, 40));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cédula");
        panelRound10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 235, 80, -1));

        p_rgistro_usuario_cedula.setRoundBottomLeft(50);
        p_rgistro_usuario_cedula.setRoundBottomRight(50);
        p_rgistro_usuario_cedula.setRoundTopLeft(50);
        p_rgistro_usuario_cedula.setRoundTopRight(50);
        p_rgistro_usuario_cedula.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cedula.setBackground(new java.awt.Color(218, 215, 220));
        txt_cedula.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        txt_cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cedula.setBorder(null);
        txt_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedulaActionPerformed(evt);
            }
        });
        p_rgistro_usuario_cedula.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        panelRound10.add(p_rgistro_usuario_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 275, 180, 50));

        p_rgistro_usuario_nombre.setRoundBottomLeft(50);
        p_rgistro_usuario_nombre.setRoundBottomRight(50);
        p_rgistro_usuario_nombre.setRoundTopLeft(50);
        p_rgistro_usuario_nombre.setRoundTopRight(50);
        p_rgistro_usuario_nombre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cargo.setBackground(new java.awt.Color(218, 215, 220));
        txt_cargo.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        txt_cargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cargo.setBorder(null);
        p_rgistro_usuario_nombre.add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        panelRound10.add(p_rgistro_usuario_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 180, 50));

        p_rgistro_usuario_contraseña.setRoundBottomLeft(50);
        p_rgistro_usuario_contraseña.setRoundBottomRight(50);
        p_rgistro_usuario_contraseña.setRoundTopLeft(50);
        p_rgistro_usuario_contraseña.setRoundTopRight(50);
        p_rgistro_usuario_contraseña.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_apellido.setBackground(new java.awt.Color(218, 215, 220));
        txt_apellido.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(null);
        p_rgistro_usuario_contraseña.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        panelRound10.add(p_rgistro_usuario_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 180, 50));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido");
        panelRound10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 160, -1));

        p_registro.setBackground(new java.awt.Color(36, 22, 74));
        p_registro.setRoundBottomLeft(50);
        p_registro.setRoundBottomRight(50);
        p_registro.setRoundTopLeft(50);
        p_registro.setRoundTopRight(50);
        p_registro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_registrar.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        b_registrar.setForeground(new java.awt.Color(255, 255, 255));
        b_registrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_registrar.setText("Registrar");
        b_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_registrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_registrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_registrarMouseExited(evt);
            }
        });
        p_registro.add(b_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        panelRound10.add(p_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 180, 50));

        jLabel10.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cargo");
        panelRound10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 80, -1));

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
        panelRound10.add(barra_mover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 20));

        getContentPane().add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
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
    }//GEN-LAST:event_salirMouseClicked

    private void cmb_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_departamentoActionPerformed

    private void txt_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaActionPerformed

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

    private void b_registrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrarMouseEntered
        // cambiar color al pasar el mouse por encima del boton registrar del modulo, 
        // "CREAR USUARIO DE EQUIPO"
        p_registro.setBackground(new Color(20, 22, 84));
    }//GEN-LAST:event_b_registrarMouseEntered

    private void b_registrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrarMouseExited
        // volver al color original del boton al no estar el mouse encima del boton "REGISTRAR" del modulo 
        // "CREAR USUARIO DE EQUIPO"
        p_registro.setBackground(new Color(36, 22, 74));
    }//GEN-LAST:event_b_registrarMouseExited

    private void b_registrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrarMouseClicked
        //Registrar Usuario y guardar en la base de datos

        //Llamado de clases
        ValidacionesGenerales vg = new ValidacionesGenerales();
        ValidacionesIndividual vi = new ValidacionesIndividual();

        //Obtener datos de los campos de textos
        String cedula = txt_cedula.getText().trim();
        String nombre = txt_nombre.getText().trim();
        String apellido = txt_apellido.getText().trim();
        String cargo = txt_cargo.getText().trim();
        String departamento = (String) cmb_departamento.getSelectedItem();

        //Arreglos para validar los datos
        String[] camposT = {cedula, nombre, apellido, departamento, cargo};
        String[] camposL = {nombre, apellido, cargo};
        String[] camposN = {cedula};
        String[] camposA = {departamento};

        //Consultas
        String comprobacion = "SELECT cedula FROM usuarios_equipos "
                + "WHERE cedula ='" + cedula + "'";
        String agregar = "INSERT INTO usuarios_equipos values (?,?,?,?,?,?)";

        //Validacion de campos vacios
        if (vg.camposVaciosArray(camposT)) {

                //Validacion de los diferentes caracteres de los campos
                if (!vg.validarLetras(camposL)) {
                    JOptionPane.showMessageDialog(null, "Los campos (nombre, apellido, nombreUsuario) solo deben contener letras...");
                } else if (!vg.validarNumerosC(camposN)) {
                    JOptionPane.showMessageDialog(null, "El campo (Cedula) solo deben contener Numeros...");
                } else if (!vg.validarTodos(camposA)) {
                    JOptionPane.showMessageDialog(null, "Los campos (contraseña, contraseñaConfirmar) no debe contener caracters especiales...");
                } else {

                    //Verificaion de ecistencia de usuario
                    try {
                        Connection cn = Conexion_sql.conectar();
                        PreparedStatement pst = cn.prepareStatement(comprobacion);
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Usuario ya existe...");
                        } else if (!rs.next()) {

                            //Registrar usuario
                            try {
                                Connection cn2 = Conexion_sql.conectar();
                                PreparedStatement pst2 = cn.prepareStatement(agregar);

                                pst2.setString(1, null);
                                pst2.setString(2, cedula);
                                pst2.setString(3, nombre);
                                pst2.setString(4, apellido);
                                pst2.setString(5, cargo);
                                pst2.setString(6, departamento);
                                pst2.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Usuario Registrado...");

                                cn2.close();
                                cn.close();

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

//                        
                            } catch (Exception e) {
                                System.err.println(e);
                                JOptionPane.showMessageDialog(null, "Error al registrar usuario...");
                            }

                        }
                    } catch (Exception e) {
                        System.err.println(e);
                        JOptionPane.showMessageDialog(null, "Error al verificar usuario");
                    }
                }
        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacios...");
        }
    }//GEN-LAST:event_b_registrarMouseClicked

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
            java.util.logging.Logger.getLogger(Crear_usuario_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_usuario_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_usuario_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_usuario_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_usuario_equipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_registrar;
    private javax.swing.JLabel barra_mover4;
    private javax.swing.JComboBox<String> cmb_departamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private prueba_diseño.PanelRound p_registro;
    private prueba_diseño.PanelRound p_rgistro_usuario_cedula;
    private prueba_diseño.PanelRound p_rgistro_usuario_contraseña;
    private prueba_diseño.PanelRound p_rgistro_usuario_nombre;
    private prueba_diseño.PanelRound p_rgistro_usuario_nombre_usuario;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound10;
    private prueba_diseño.PanelRound panelRound8;
    private javax.swing.JLabel salir;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cargo;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
