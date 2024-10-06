/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author c.leal
 */
public class Crear_articulos extends javax.swing.JFrame {

    public static String usuarioS = Login.usuario_nombre;

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;

    //Fecha
    LocalDateTime fecha = LocalDateTime.now();
    int annio = fecha.getYear();
    int mes = fecha.getMonthValue();
    int dia = fecha.getDayOfMonth();
    int segundo = fecha.getSecond();

    public Crear_articulos() {
        initComponents();
        setTitle("Articulos");
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(700, 820);

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_equipo FROM `equipos`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_equipo.addItem(rs.getString("nombre_equipo"));

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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        p_invetario_registro_componentes = new prueba_diseño.PanelRound();
        p_registro_articulo = new prueba_diseño.PanelRound();
        b_registrar_registro_articulo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        cmb_equipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmb_estado = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cmb_departamento = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelRound1 = new prueba_diseño.PanelRound();
        txt_Nbien = new javax.swing.JTextField();
        panelRound2 = new prueba_diseño.PanelRound();
        txt_marca = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        panelRound6 = new prueba_diseño.PanelRound();
        txt_nombre = new javax.swing.JTextField();
        cabecera = new prueba_diseño.PanelRound();
        panelRound8 = new prueba_diseño.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmb_tipo = new javax.swing.JComboBox<>();
        barra_mover2 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellido");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_invetario_registro_componentes.setBackground(new java.awt.Color(0, 102, 102));
        p_invetario_registro_componentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_registro_articulo.setBackground(new java.awt.Color(36, 22, 74));
        p_registro_articulo.setRoundBottomLeft(50);
        p_registro_articulo.setRoundBottomRight(50);
        p_registro_articulo.setRoundTopLeft(50);
        p_registro_articulo.setRoundTopRight(50);
        p_registro_articulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_registrar_registro_articulo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        b_registrar_registro_articulo.setForeground(new java.awt.Color(255, 255, 255));
        b_registrar_registro_articulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_registrar_registro_articulo.setText("Registrar");
        b_registrar_registro_articulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_registrar_registro_articuloMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_registrar_registro_articuloMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_registrar_registro_articuloMouseExited(evt);
            }
        });
        p_registro_articulo.add(b_registrar_registro_articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        p_invetario_registro_componentes.add(p_registro_articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, 180, 50));

        jLabel13.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Descripción");
        p_invetario_registro_componentes.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 160, -1));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane2.setViewportView(txt_descripcion);

        p_invetario_registro_componentes.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 550, 90));

        jLabel18.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText(" Equipo");
        p_invetario_registro_componentes.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 200, 200, -1));

        cmb_equipo.setFont(new java.awt.Font("Serif", 0, 11)); // NOI18N
        cmb_equipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----" }));
        p_invetario_registro_componentes.add(cmb_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 245, 170, 40));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Estado");
        p_invetario_registro_componentes.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 200, 160, -1));

        cmb_estado.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Almacen", "Fuera de servicio", "En revision", "En uso" }));
        p_invetario_registro_componentes.add(cmb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 245, 170, 40));

        jLabel22.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Departamento");
        p_invetario_registro_componentes.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 200, 210, -1));

        cmb_departamento.setFont(new java.awt.Font("Serif", 0, 11)); // NOI18N
        cmb_departamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----" }));
        cmb_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departamentoActionPerformed(evt);
            }
        });
        p_invetario_registro_componentes.add(cmb_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 245, 170, 40));

        jLabel17.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nombre del Artículo");
        p_invetario_registro_componentes.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 160, -1));

        jLabel14.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Número de Bien");
        p_invetario_registro_componentes.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 160, -1));

        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Nbien.setBackground(new java.awt.Color(218, 215, 220));
        txt_Nbien.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txt_Nbien.setBorder(null);
        txt_Nbien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NbienActionPerformed(evt);
            }
        });
        panelRound1.add(txt_Nbien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        p_invetario_registro_componentes.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 180, 50));

        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_marca.setBackground(new java.awt.Color(218, 215, 220));
        txt_marca.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txt_marca.setBorder(null);
        txt_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_marcaActionPerformed(evt);
            }
        });
        panelRound2.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        p_invetario_registro_componentes.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 180, 50));

        jLabel21.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Marca");
        p_invetario_registro_componentes.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 160, -1));

        panelRound6.setRoundBottomLeft(50);
        panelRound6.setRoundBottomRight(50);
        panelRound6.setRoundTopLeft(50);
        panelRound6.setRoundTopRight(50);
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.setBackground(new java.awt.Color(218, 215, 220));
        txt_nombre.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txt_nombre.setBorder(null);
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        panelRound6.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        p_invetario_registro_componentes.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 180, 50));

        getContentPane().add(p_invetario_registro_componentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 700, 690));

        cabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound8.setBackground(new java.awt.Color(36, 22, 74));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);
        panelRound8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menuA/cerdo.png"))); // NOI18N
        panelRound8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 70));

        salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_login/tarjeta-de-direccion (1).png"))); // NOI18N
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        panelRound8.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 80, 60));

        jLabel2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registro de Artículo");
        panelRound8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 340, 40));

        cabecera.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 510, 80));

        jLabel20.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel20.setText("Tipo de Artículo");
        cabecera.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 130, -1));

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insumo", "Componente" }));
        cabecera.add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 120, 30));

        barra_mover2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barra_mover2MouseDragged(evt);
            }
        });
        barra_mover2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barra_mover2MousePressed(evt);
            }
        });
        cabecera.add(barra_mover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 30));

        getContentPane().add(cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
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
    }//GEN-LAST:event_salirMouseClicked

    private void cmb_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_departamentoActionPerformed

    private void txt_NbienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NbienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NbienActionPerformed

    private void txt_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_marcaActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void barra_mover2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barra_mover2MouseDragged
        //Obtener posicion x,y de la interfaz al arrastrar con el mouse
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        //Posicionar la ventana segun los valores obtenidos
        this.setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_barra_mover2MouseDragged

    private void barra_mover2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barra_mover2MousePressed
        //Obtener posiciones x,y del mouse cuando se mantiene presionado
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_barra_mover2MousePressed

    private void b_registrar_registro_articuloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrar_registro_articuloMouseEntered
        // Cambiar el color al hacer focus en el boton "Actualizar", del modulo
        //"Crear reporte"
        p_registro_articulo.setBackground(new Color(20, 22, 84));
    }//GEN-LAST:event_b_registrar_registro_articuloMouseEntered

    private void b_registrar_registro_articuloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrar_registro_articuloMouseExited
        // volver al color original, al no tener el focus en el boton "Actualizar", del modulo
        //"Crear reporte"
        p_registro_articulo.setBackground(new Color(36, 22, 74));
    }//GEN-LAST:event_b_registrar_registro_articuloMouseExited

    private void b_registrar_registro_articuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrar_registro_articuloMouseClicked
        //Registrar articulo y guardar en la base de datos

        //Generar codigo de articulo
        String a = String.valueOf(txt_nombre.getText().charAt(0));
        String b = String.valueOf(txt_nombre.getText().charAt(1));
        String c = String.valueOf(txt_nombre.getText().charAt(2));
        String d = String.valueOf(mes);
        String e = String.valueOf(dia);
        int numero = (int) (Math.random() * 100) + 1;

        String codigo = a + b + c + "-" + d + e + numero;

        //Llamado de clases
        ValidacionesGenerales vg = new ValidacionesGenerales();
        ValidacionesIndividual vi = new ValidacionesIndividual();

        //Obtener datos de los campos de textos
        String Nbien = txt_Nbien.getText().trim();
        String nombre = txt_nombre.getText().trim();
        String marca = txt_marca.getText().trim();
        String descripcion = txt_descripcion.getText().trim();
        String tipo_articulo = (String) cmb_tipo.getSelectedItem();
        String equipo = (String) cmb_equipo.getSelectedItem();
        String estado = (String) cmb_estado.getSelectedItem();
        String departamento = (String) cmb_departamento.getSelectedItem();

        //Arreglos para validar los datos
        String[] camposT = {nombre, marca, tipo_articulo, estado, descripcion};
        String[] camposL = {tipo_articulo, estado};
        String[] camposA = {Nbien, marca};

        //Consultas
        String comprobacion = "SELECT nombre_articulo FROM articulos "
                + "WHERE nombre_articulo ='" + nombre + "'"
                + " and codigo_articulo='" + codigo + "'";
        String comprobacion2 = "SELECT num_bien FROM existencias"
                + "WHERE num_bien ='" + Nbien + "'";
        String agregar = "INSERT INTO articulos values (?,?,?,?,?,?,?)";
        String agregar2 = "INSERT INTO existencias values (?,?,?,?,?,?,?,?,?,?)";

        //Verificar numero de bien
        if (Nbien.equals("")) {
            Nbien = null;
        } else {

        }

        //Validacion de campos vacios
        if (vg.camposVaciosArray(camposT)) {

            //Validacion de los diferentes caracteres de los campos
            if (!vg.validarLetras(camposL)) {
                JOptionPane.showMessageDialog(null, "Los campos (Campo no valido) solo deben contener letras...");
            } else if (!vg.validarTodos(camposA)) {
                JOptionPane.showMessageDialog(null, "Los campos (Caracteres no validos) no debe contener caracters especiales...");
            } else {

                //Verificaion de ecistencia de articulo
                try {
                    Connection cn = Conexion_sql.conectar();
                    PreparedStatement pst = cn.prepareStatement(comprobacion);
                    ResultSet rs = pst.executeQuery();

//                    Connection cn4 = Conexion_sql.conectar();
//                    PreparedStatement pst4 = cn4.prepareStatement(comprobacion2);
//                    ResultSet rs4 = pst4.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Codigo existente....");
                    } else if (!rs.next()) {

                        //Registrar usuario
                        try {
                            Connection cn2 = Conexion_sql.conectar();
                            PreparedStatement pst2 = cn2.prepareStatement(agregar);

                            pst2.setString(1, null);
                            pst2.setString(2, codigo);
                            pst2.setString(3, nombre);
                            pst2.setString(4, descripcion);
                            pst2.setString(5, dia + "/" + mes + "/" + annio);
                            pst2.setString(6, null);
                            pst2.setString(7, tipo_articulo);
                            pst2.executeUpdate();

                            try {
                                Connection cn3 = Conexion_sql.conectar();
                                PreparedStatement pst3 = cn3.prepareStatement(agregar2);

                                pst3.setString(1, null);
                                pst3.setString(2, marca);
                                pst3.setString(3, estado);
                                pst3.setString(4, Nbien);
                                pst3.setString(5, dia + "/" + mes + "/" + annio);
                                pst3.setString(6, null);
                                pst3.setString(7, equipo);
                                pst3.setString(8, Crear_articulos.usuarioS);
                                pst3.setString(9, codigo);
                                pst3.setString(10, departamento);

                                pst3.executeUpdate();

                                JOptionPane.showMessageDialog(null, "articulos Registrado con exito...");

                                if (tipo.equals("Administrador")) {
                                    dispose();
                                    Administrador menu = new Administrador();
                                    menu.setVisible(true);
                                    cn2.close();
                                    cn.close();

                                } else if (tipo.equals("Tecnico")) {
                                    dispose();
                                    Tecnico menu = new Tecnico();
                                    menu.setVisible(true);
                                    cn2.close();
                                    cn.close();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error del servidor");
                                }

                            } catch (Exception e3) {
                                System.err.println(e3);
                                JOptionPane.showMessageDialog(null, "verifica el numero de bien...");
                            }

                            cn2.close();
                            cn.close();

                        } catch (Exception e2) {
                            System.err.println(e2);
                            JOptionPane.showMessageDialog(null, "Error al Crear articulo...");
                        }

                    }
                } catch (Exception e1) {

                    System.err.println(e1);
                    JOptionPane.showMessageDialog(null, "Error al verificar articulo");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacios...");
        }
    }//GEN-LAST:event_b_registrar_registro_articuloMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Crear_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_articulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_registrar_registro_articulo;
    private javax.swing.JLabel barra_mover2;
    private prueba_diseño.PanelRound cabecera;
    private javax.swing.JComboBox<String> cmb_departamento;
    private javax.swing.JComboBox<String> cmb_equipo;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private prueba_diseño.PanelRound p_invetario_registro_componentes;
    private prueba_diseño.PanelRound p_registro_articulo;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound2;
    private prueba_diseño.PanelRound panelRound6;
    private prueba_diseño.PanelRound panelRound8;
    private javax.swing.JLabel salir;
    private javax.swing.JTextField txt_Nbien;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
