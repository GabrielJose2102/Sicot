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

public class Modificar_equipo extends javax.swing.JFrame {

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;

    String IDequipo = "";

    public Modificar_equipo() {

        IDequipo = Listar_equipos.IDequipo_update;

        initComponents();
        setSize(500, 820);
        setLocationRelativeTo(null);
        setTitle("Modificar Equipos");
        setResizable(false);

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_tipo_equipo FROM `tipo_equipo`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_tipo.addItem(rs.getString("nombre_tipo_equipo"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

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

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT cedula FROM `usuarios_equipos` ORDER BY cedula");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_usuario.addItem(rs.getString("cedula"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }
        
        

        if (IDequipo.equals("")) {

        } else {

            try {
                Connection cn = Conexion_sql.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT `nombre_equipo`, `marca`, `sistema_operativo`, `estado_equipo`,"
                        + " `departamento`, `usuario_equipo`, `tipo_equipo`"
                        + " FROM `bd_porcinos`.`equipos`WHERE nombre_equipo='" + IDequipo + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    String nombre = rs.getString("nombre_equipo");
                    String marca = rs.getString("marca");
                    String so = rs.getString("sistema_operativo");
                    String estado = rs.getString("estado_equipo");
                    String departamento = rs.getString("departamento");
                    String usuario = rs.getString("usuario_equipo");
                    String tipo = rs.getString("tipo_equipo");

                    txt_nombre.setText(nombre);
                    txt_marca.setText(marca);
                    txt_so.setText(so);
                    cmb_estado.setSelectedItem(estado);
                    cmb_tipo.setSelectedItem(tipo);
                    cmb_usuario.setSelectedItem(usuario);
                    cmb_departamento.setSelectedItem(departamento);

                } else {
                    JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");

                }
                cn.close();

            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
            }
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

        jLabel6 = new javax.swing.JLabel();
        panelRound10 = new prueba_diseño.PanelRound();
        panelRound8 = new prueba_diseño.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new prueba_diseño.PanelRound();
        jLabel12 = new javax.swing.JLabel();
        p_modificar_equipo_nombre = new prueba_diseño.PanelRound();
        txt_nombre = new javax.swing.JTextField();
        p_modificar_equipo_Marca = new prueba_diseño.PanelRound();
        txt_marca = new javax.swing.JTextField();
        p_modificar_equipo_sistema_operativo = new prueba_diseño.PanelRound();
        txt_so = new javax.swing.JTextField();
        p_modificar_equipo_b_eliminar_e = new prueba_diseño.PanelRound();
        b_eliminar_modificar_equipo = new javax.swing.JLabel();
        p_modificar_equipo_b_actulizar_e = new prueba_diseño.PanelRound();
        b_actualizar_modificar_equipo = new javax.swing.JLabel();
        cmb_tipo = new javax.swing.JComboBox<>();
        cmb_estado = new javax.swing.JComboBox<>();
        cmb_departamento = new javax.swing.JComboBox<>();
        cmb_usuario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelRound2 = new prueba_diseño.PanelRound();
        buscar = new javax.swing.JLabel();
        barra_mover4 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellido");

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

        jLabel2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modificar  Equipo");
        panelRound8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 220, 80));

        panelRound1.setBackground(new java.awt.Color(36, 22, 74));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_login/tarjeta-de-direccion (1).png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        panelRound1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        panelRound8.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 50, 40));

        panelRound10.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 450, 80));

        p_modificar_equipo_nombre.setRoundBottomLeft(50);
        p_modificar_equipo_nombre.setRoundBottomRight(50);
        p_modificar_equipo_nombre.setRoundTopLeft(50);
        p_modificar_equipo_nombre.setRoundTopRight(50);
        p_modificar_equipo_nombre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.setBackground(new java.awt.Color(218, 215, 220));
        txt_nombre.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(null);
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        p_modificar_equipo_nombre.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 270, 40));

        panelRound10.add(p_modificar_equipo_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 290, 50));

        p_modificar_equipo_Marca.setRoundBottomLeft(50);
        p_modificar_equipo_Marca.setRoundBottomRight(50);
        p_modificar_equipo_Marca.setRoundTopLeft(50);
        p_modificar_equipo_Marca.setRoundTopRight(50);
        p_modificar_equipo_Marca.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_marca.setBackground(new java.awt.Color(218, 215, 220));
        txt_marca.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        txt_marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_marca.setBorder(null);
        p_modificar_equipo_Marca.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        panelRound10.add(p_modificar_equipo_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 180, 50));

        p_modificar_equipo_sistema_operativo.setRoundBottomLeft(50);
        p_modificar_equipo_sistema_operativo.setRoundBottomRight(50);
        p_modificar_equipo_sistema_operativo.setRoundTopLeft(50);
        p_modificar_equipo_sistema_operativo.setRoundTopRight(50);
        p_modificar_equipo_sistema_operativo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_so.setBackground(new java.awt.Color(218, 215, 220));
        txt_so.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        txt_so.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_so.setBorder(null);
        p_modificar_equipo_sistema_operativo.add(txt_so, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        panelRound10.add(p_modificar_equipo_sistema_operativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 180, 50));

        p_modificar_equipo_b_eliminar_e.setBackground(new java.awt.Color(36, 22, 74));
        p_modificar_equipo_b_eliminar_e.setRoundBottomLeft(50);
        p_modificar_equipo_b_eliminar_e.setRoundBottomRight(50);
        p_modificar_equipo_b_eliminar_e.setRoundTopLeft(50);
        p_modificar_equipo_b_eliminar_e.setRoundTopRight(50);
        p_modificar_equipo_b_eliminar_e.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_eliminar_modificar_equipo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        b_eliminar_modificar_equipo.setForeground(new java.awt.Color(255, 255, 255));
        b_eliminar_modificar_equipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_eliminar_modificar_equipo.setText("Eliminar");
        b_eliminar_modificar_equipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_eliminar_modificar_equipoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_eliminar_modificar_equipoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_eliminar_modificar_equipoMouseExited(evt);
            }
        });
        p_modificar_equipo_b_eliminar_e.add(b_eliminar_modificar_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        panelRound10.add(p_modificar_equipo_b_eliminar_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 710, 180, 50));

        p_modificar_equipo_b_actulizar_e.setBackground(new java.awt.Color(36, 22, 74));
        p_modificar_equipo_b_actulizar_e.setRoundBottomLeft(50);
        p_modificar_equipo_b_actulizar_e.setRoundBottomRight(50);
        p_modificar_equipo_b_actulizar_e.setRoundTopLeft(50);
        p_modificar_equipo_b_actulizar_e.setRoundTopRight(50);
        p_modificar_equipo_b_actulizar_e.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_actualizar_modificar_equipo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        b_actualizar_modificar_equipo.setForeground(new java.awt.Color(255, 255, 255));
        b_actualizar_modificar_equipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_actualizar_modificar_equipo.setText("Actualizar");
        b_actualizar_modificar_equipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_actualizar_modificar_equipoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_actualizar_modificar_equipoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_actualizar_modificar_equipoMouseExited(evt);
            }
        });
        p_modificar_equipo_b_actulizar_e.add(b_actualizar_modificar_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        panelRound10.add(p_modificar_equipo_b_actulizar_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 710, 180, 50));

        cmb_tipo.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cmb_tipo.setForeground(new java.awt.Color(36, 22, 74));
        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        cmb_tipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipoActionPerformed(evt);
            }
        });
        panelRound10.add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 180, 40));

        cmb_estado.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cmb_estado.setForeground(new java.awt.Color(36, 22, 74));
        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------", "En revision", "En uso", "almacen", "En desuso" }));
        cmb_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_estadoActionPerformed(evt);
            }
        });
        panelRound10.add(cmb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 180, 40));

        cmb_departamento.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cmb_departamento.setForeground(new java.awt.Color(36, 22, 74));
        cmb_departamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        cmb_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departamentoActionPerformed(evt);
            }
        });
        panelRound10.add(cmb_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, 180, 40));

        cmb_usuario.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cmb_usuario.setForeground(new java.awt.Color(36, 22, 74));
        cmb_usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        cmb_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_usuarioActionPerformed(evt);
            }
        });
        panelRound10.add(cmb_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 180, 40));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado");
        panelRound10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 140, -1));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre de equipo");
        panelRound10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 160, -1));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sistema operativo");
        panelRound10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 160, -1));

        jLabel10.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Marca");
        panelRound10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 80, -1));

        jLabel13.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Usuario");
        panelRound10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 140, -1));

        jLabel14.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tipo");
        panelRound10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 140, -1));

        jLabel15.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Departamento");
        panelRound10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, 140, -1));

        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu_equipos/busqueda.png"))); // NOI18N
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });
        panelRound2.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        panelRound10.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 50, 50));

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
        panelRound10.add(barra_mover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 20));

        getContentPane().add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void cmb_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_usuarioActionPerformed

    private void cmb_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_departamentoActionPerformed

    private void cmb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_tipoActionPerformed

    private void cmb_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_estadoActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
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
    }//GEN-LAST:event_jLabel12MouseClicked

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

    private void b_eliminar_modificar_equipoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_eliminar_modificar_equipoMouseEntered
        // Cambiar el color al hacer focus en el boton "ELIMINAR", del modulo
        //"MODIFICAR EQUIPO"
        p_modificar_equipo_b_eliminar_e.setBackground(new Color(164, 48, 48));
    }//GEN-LAST:event_b_eliminar_modificar_equipoMouseEntered

    private void b_eliminar_modificar_equipoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_eliminar_modificar_equipoMouseExited
        // Volver al color orginal , cuando el mouse no este sobre el boton "ELIMINAR", de
        //Modulo ",MODIFICAR EQUIPO"
        p_modificar_equipo_b_eliminar_e.setBackground(new Color(36, 22, 74));
    }//GEN-LAST:event_b_eliminar_modificar_equipoMouseExited

    private void b_actualizar_modificar_equipoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_actualizar_modificar_equipoMouseEntered
        //Cambiar el color al pasar el mouse por encima del boton "ACTUALIZAR", del modulo
        // "MODIFICAR EQUIPO", 
        p_modificar_equipo_b_actulizar_e.setBackground(new Color(20, 22, 84));
    }//GEN-LAST:event_b_actualizar_modificar_equipoMouseEntered

    private void b_actualizar_modificar_equipoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_actualizar_modificar_equipoMouseExited
        // Volver al color orginal , cuando el mouse no este sobre el boton "REGISTRAR", de
        //Modulo ",MODIFICAR EQUIPO"
        p_modificar_equipo_b_actulizar_e.setBackground(new Color(36, 22, 74));
    }//GEN-LAST:event_b_actualizar_modificar_equipoMouseExited

    private void b_actualizar_modificar_equipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_actualizar_modificar_equipoMouseClicked
        //Modificacion equipos y guardar en la base de datos

        //Llamado de clases
        ValidacionesGenerales vg = new ValidacionesGenerales();
        ValidacionesIndividual vi = new ValidacionesIndividual();

        //Obtener datos de los campos de textos
        String usuario = (String) cmb_usuario.getSelectedItem();
        String nombre = txt_nombre.getText().trim();
        String marca = txt_marca.getText().trim();
        String so = txt_so.getText().trim();
        String tipo_e = (String) cmb_tipo.getSelectedItem();
        String estado = (String) cmb_estado.getSelectedItem();
        String departamento = (String) cmb_departamento.getSelectedItem();

        //Arreglos para validar los datos
        String[] camposT = {usuario, nombre, marca, so};
        String[] camposL = {tipo_e, estado};
        String[] camposN = {usuario};
        String[] camposA = {marca, departamento, nombre};

        //Consultas
        String comprobacion = "SELECT nombre_equipo FROM equipos "
                + "WHERE nombre_equipo ='" + nombre + "'";
        String modificar = "UPDATE equipos SET nombre_equipo=?, marca=?, sistema_operativo"
                + "=?, estado_equipo=?, departamento=?, usuario_equipo=?, tipo_equipo=?"
                + " WHERE nombre_equipo='" + nombre + "'";

        //Validacion de campos vacios
        if (vg.camposVaciosArray(camposT)) {

            //Confirmacion de contraseña
            if (!usuario.equals("------") && !tipo_e.equals("------") && !estado.equals("------") && !departamento.equals("------")) {

                //Validacion de los diferentes caracteres de los campos
                if (!vg.validarLetras(camposL)) {
                    JOptionPane.showMessageDialog(null, "Los campos (tipo, estado) solo deben contener letras...");
                } else if (!vg.validarNumerosC(camposN)) {
                    JOptionPane.showMessageDialog(null, "El campo (usuario) solo deben contener Numeros...");
                } else if (!vg.validarTodos(camposA)) {
                    JOptionPane.showMessageDialog(null, "Los campos (marca, departamento, nombre) no debe contener (-) este caracter especial...");
                } else {

                    //Modificar usuario
                    try {
                        Connection cn2 = Conexion_sql.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(modificar);

                        pst2.setString(1, nombre);
                        pst2.setString(2, marca);
                        pst2.setString(3, so);
                        pst2.setString(4, estado);
                        pst2.setString(5, departamento);
                        pst2.setString(6, usuario);
                        pst2.setString(7, tipo_e);
                        pst2.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Equipo Modificado");

                        cn2.close();

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
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "debes selecionar los campos de la listas....");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacios...");
        }
    }//GEN-LAST:event_b_actualizar_modificar_equipoMouseClicked

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
        //
        String nombre_consulta = txt_nombre.getText().trim();

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT `nombre_equipo`, `marca`, `sistema_operativo`, `estado_equipo`,"
                    + " `departamento`, `usuario_equipo`, `tipo_equipo`"
                    + " FROM `bd_porcinos`.`equipos`WHERE nombre_equipo='" + nombre_consulta + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                String nombre = rs.getString("nombre_equipo");
                String marca = rs.getString("marca");
                String so = rs.getString("sistema_operativo");
                String estado = rs.getString("estado_equipo");
                String departamento = rs.getString("departamento");
                String usuario = rs.getString("usuario_equipo");
                String tipo = rs.getString("tipo_equipo");

                txt_nombre.setText(nombre);
                txt_marca.setText(marca);
                txt_so.setText(so);
                cmb_estado.setSelectedItem(estado);
                cmb_tipo.setSelectedItem(tipo);
                cmb_usuario.setSelectedItem(usuario);
                cmb_departamento.setSelectedItem(departamento);

            } else {
                JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

    }//GEN-LAST:event_buscarMouseClicked

    private void b_eliminar_modificar_equipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_eliminar_modificar_equipoMouseClicked
        String busqueda = txt_nombre.getText().trim();

        //Consultas
        String eliminar = "DELETE FROM `equipos` WHERE `nombre_equipo`='" + busqueda + "'";

        //Validacion de campos vacios
        if (!busqueda.equals("------")) {

            String clave = JOptionPane.showInputDialog("Introduce contraseña");

            if (clave.equals("EMSPA-01")) {

                int elimina = JOptionPane.showConfirmDialog(rootPane, "seguro que deeas eliminar el equipo");

                if (elimina == 0) {

                    //Eliminar usuario
                    try {
                        Connection cn2 = Conexion_sql.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(eliminar);
                        pst2.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Equipo Eliminado");

                        cn2.close();

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
                    } catch (Exception e) {
                        System.err.println(e);
                    }

                } else if (elimina == 1) {
                    JOptionPane.showMessageDialog(null, "Operacion Abortada...");

                } else if (elimina == 2) {
                    JOptionPane.showMessageDialog(null, "Se cancelo la accion...");

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
                }

            } else {
                JOptionPane.showMessageDialog(null, "Clave incorrecta");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes de seleccionar el usuario en el buscdor...");
        }
    }//GEN-LAST:event_b_eliminar_modificar_equipoMouseClicked

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
            java.util.logging.Logger.getLogger(Modificar_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_equipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_actualizar_modificar_equipo;
    private javax.swing.JLabel b_eliminar_modificar_equipo;
    private javax.swing.JLabel barra_mover4;
    private javax.swing.JLabel buscar;
    private javax.swing.JComboBox<String> cmb_departamento;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JComboBox<String> cmb_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private prueba_diseño.PanelRound p_modificar_equipo_Marca;
    private prueba_diseño.PanelRound p_modificar_equipo_b_actulizar_e;
    private prueba_diseño.PanelRound p_modificar_equipo_b_eliminar_e;
    private prueba_diseño.PanelRound p_modificar_equipo_nombre;
    private prueba_diseño.PanelRound p_modificar_equipo_sistema_operativo;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound10;
    private prueba_diseño.PanelRound panelRound2;
    private prueba_diseño.PanelRound panelRound8;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_so;
    // End of variables declaration//GEN-END:variables
}
