/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import clase_base_datos.Conexion_sql;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import funcionabilidad.ValidacionesGenerales;
import funcionabilidad.ValidacionesIndividual;
import static interfaces.Crear_usuario.tipo;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;

/**
 *
 * @author c.leal
 */
public class Modificar_reporte extends javax.swing.JFrame {

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;

    String IDreporte = "";

    LocalDateTime fecha = LocalDateTime.now();

    int annio = fecha.getYear();
    int mes = fecha.getMonthValue();
    int dia = fecha.getDayOfMonth();
    int hora = fecha.getHour();
    int minutos = fecha.getMinute();
    int segundo = fecha.getSecond();

    public Modificar_reporte() {

        IDreporte = Listar_reportes.IDreporte_update;

        initComponents();
        setSize(1100, 930);
        setTitle("Modificar Reportes");
        setLocationRelativeTo(null);
        setResizable(false);

        //Inicio de panel de interface
        p_servicioT.setVisible(true);

        txt_sol.setEnabled(false);
        txt_sol.setEditable(false);
        txt_req.setEnabled(false);
        txt_req.setEditable(false);

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT codigo_reporte FROM `reportes`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_codigo.addItem(rs.getString("codigo_reporte"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_usuario FROM `usuarios_sistema`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_tecnico.addItem(rs.getString("nombre_usuario"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_articulo FROM `articulos`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_articulo.addItem(rs.getString("nombre_articulo"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre, apellido FROM `usuarios_equipos`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_usuario.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

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

        if (IDreporte.equals("")) {

        } else {

            if (IDreporte.equals("")) {
                cmb_codigo.setSelectedItem(IDreporte);
                t_dia.setSelectedIndex(0);
                t_mes.setSelectedIndex(0);
                t_anno.setSelectedIndex(0);
                txt_obs.setText("");
                txt_dia.setText("");
                txt_sol.setText("");
                txt_req.setText("");
                cmb_departamento.setSelectedIndex(0);
                cmb_articulo.setSelectedIndex(0);
                cmb_tecnico.setSelectedIndex(0);
                cmb_usuario.setSelectedIndex(0);
                cmb_equipo.setSelectedIndex(0);
            } else {

                try {
                    Connection cn2 = Conexion_sql.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("SELECT `grado_falla`, `id_departamento`, "
                            + "`tipo_reporte` FROM `reporte_detallado` "
                            + "WHERE codigo_reporte='" + IDreporte + "'");
                    ResultSet rs2 = pst2.executeQuery();

                    if (rs2.next()) {

                        String grado = rs2.getString("grado_falla");
                        String departamento = rs2.getString("id_departamento");
                        String tipo_reporte = rs2.getString("tipo_reporte");

                        Connection cn3 = Conexion_sql.conectar();
                        PreparedStatement pst3 = cn3.prepareStatement("SELECT `fecha_ejecucion`, "
                                + "`observacion`, `diagnostico`, `solucion`, `requerimientos`, "
                                + "`tecnico`, `articulo`, `usuario_equipo`, `equipo` "
                                + "FROM `bd_porcinos`.`reportes`WHERE codigo_reporte='" + IDreporte + "'");
                        ResultSet rs3 = pst3.executeQuery();

                        if (rs3.next()) {

                            String fecha = rs3.getString("fecha_ejecucion");
                            String obser = rs3.getString("observacion");
                            String diag = rs3.getString("diagnostico");
                            String solu = rs3.getString("solucion");
                            String req = rs3.getString("requerimientos");
                            String tecnico = rs3.getString("tecnico");
                            String articulo = rs3.getString("articulo");
                            String usuarioE = rs3.getString("usuario_equipo");
                            String equipo = rs3.getString("equipo");

                            if (tipo_reporte.equals("Cambio de Toner")) {
                                cmb_codigo.setSelectedItem(IDreporte);
                                txt_obs.setText(obser);
                                txt_dia.setText(diag);
                                txt_sol.setText("");
                                txt_sol.setEnabled(false);
                                txt_sol.setEditable(false);
                                txt_req.setText("");
                                txt_req.setEnabled(false);
                                txt_req.setEditable(false);
                                cmb_tipo.setSelectedItem(tipo_reporte);
                                cmb_departamento.setSelectedItem(departamento);
                                cmb_grado.setSelectedItem(grado);
                                cmb_articulo.setSelectedItem(articulo);
                                cmb_tecnico.setSelectedItem(tecnico);
                                cmb_usuario.setSelectedItem(usuarioE);
                                cmb_equipo.setSelectedItem(equipo);
                                t_dia.setSelectedIndex(0);
                                t_mes.setSelectedIndex(0);
                                t_anno.setSelectedIndex(0);

                            } else if (tipo_reporte.equals("Servicio Tecnico")) {
                                cmb_codigo.setSelectedItem(IDreporte);
                                txt_obs.setText(obser);
                                txt_dia.setText(diag);
                                txt_sol.setText(solu);
                                txt_sol.setEnabled(true);
                                txt_sol.setEditable(true);
                                txt_req.setText(req);
                                txt_req.setEnabled(true);
                                txt_req.setEditable(true);
                                cmb_tipo.setSelectedItem(tipo_reporte);
                                cmb_departamento.setSelectedItem(departamento);
                                cmb_grado.setSelectedItem(grado);
                                cmb_articulo.setSelectedItem(articulo);
                                cmb_tecnico.setSelectedItem(tecnico);
                                cmb_usuario.setSelectedItem(usuarioE);
                                cmb_equipo.setSelectedItem(equipo);
                                t_dia.setSelectedIndex(0);
                                t_mes.setSelectedIndex(0);
                                t_anno.setSelectedIndex(0);
                            }
                            cn3.close();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error no se encontro en reportes");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error no se encontro en reportes");
                    }
                    cn2.close();
                } catch (SQLException e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Error al buscar reporte");
                }
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
        p_servicio = new prueba_diseño.PanelRound();
        p_modificar_reporte_crear_reporte = new prueba_diseño.PanelRound();
        b_registrar_reporte = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmb_equipo = new javax.swing.JComboBox<>();
        cmb_tecnico = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmb_articulo = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cmb_grado = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cmb_usuario = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cmb_departamento = new javax.swing.JComboBox<>();
        cmb_codigo = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        p_servicioT = new prueba_diseño.PanelRound();
        etiqueta_d = new javax.swing.JLabel();
        etiqueta_r = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_req = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_obs = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_dia = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_sol = new javax.swing.JTextArea();
        etiqueta_s = new javax.swing.JLabel();
        etiqueta_o = new javax.swing.JLabel();
        p_eliminar_modificar_articulo = new prueba_diseño.PanelRound();
        b_articulo_eliminar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        t_dia = new javax.swing.JComboBox<>();
        t_mes = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        t_anno = new javax.swing.JComboBox<>();
        p_b_imprimir_listar_articulos = new prueba_diseño.PanelRound();
        b_imprimir_listar_articulos = new javax.swing.JLabel();
        btn_memorandum = new prueba_diseño.PanelRound();
        btn_memo = new javax.swing.JLabel();
        panelRound5 = new prueba_diseño.PanelRound();
        panelRound8 = new prueba_diseño.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        barra_mover4 = new javax.swing.JLabel();
        cmb_tipo = new javax.swing.JComboBox<>();

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellido");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_servicio.setBackground(new java.awt.Color(0, 102, 102));
        p_servicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_modificar_reporte_crear_reporte.setBackground(new java.awt.Color(36, 22, 74));
        p_modificar_reporte_crear_reporte.setRoundBottomLeft(50);
        p_modificar_reporte_crear_reporte.setRoundBottomRight(50);
        p_modificar_reporte_crear_reporte.setRoundTopLeft(50);
        p_modificar_reporte_crear_reporte.setRoundTopRight(50);
        p_modificar_reporte_crear_reporte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_registrar_reporte.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        b_registrar_reporte.setForeground(new java.awt.Color(255, 255, 255));
        b_registrar_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_registrar_reporte.setText("Modificar");
        b_registrar_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_registrar_reporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_registrar_reporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_registrar_reporteMouseExited(evt);
            }
        });
        p_modificar_reporte_crear_reporte.add(b_registrar_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        p_servicio.add(p_modificar_reporte_crear_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 700, 180, 50));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Equipo");
        p_servicio.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 160, -1));

        cmb_equipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------" }));
        p_servicio.add(cmb_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 110, 40));

        cmb_tecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        p_servicio.add(cmb_tecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 40));

        jLabel17.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Técnico");
        p_servicio.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 160, -1));

        jLabel19.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Artículo");
        p_servicio.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 130, 160, -1));

        cmb_articulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------" }));
        p_servicio.add(cmb_articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 180, 110, 40));

        jLabel20.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Grado");
        p_servicio.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 130, 160, -1));

        cmb_grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Leve", "Medio", "Grave" }));
        p_servicio.add(cmb_grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 180, 110, 40));

        jLabel21.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Usuario ");
        p_servicio.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 160, -1));

        cmb_usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------" }));
        p_servicio.add(cmb_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 110, 40));

        jLabel22.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Departamento");
        p_servicio.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 130, -1));

        cmb_departamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------" }));
        cmb_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departamentoActionPerformed(evt);
            }
        });
        p_servicio.add(cmb_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 210, 40));

        cmb_codigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        cmb_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_codigoActionPerformed(evt);
            }
        });
        p_servicio.add(cmb_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 110, 40));

        jLabel34.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Código");
        p_servicio.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, -1));

        p_servicioT.setBackground(new java.awt.Color(0, 102, 102));
        p_servicioT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiqueta_d.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        etiqueta_d.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_d.setText("Diagnóstico");
        p_servicioT.add(etiqueta_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 160, -1));

        etiqueta_r.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        etiqueta_r.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_r.setText("Requerimientos");
        p_servicioT.add(etiqueta_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 160, -1));

        txt_req.setColumns(20);
        txt_req.setRows(5);
        jScrollPane1.setViewportView(txt_req);

        p_servicioT.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 460, 150));

        txt_obs.setColumns(20);
        txt_obs.setRows(5);
        jScrollPane2.setViewportView(txt_obs);

        p_servicioT.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 480, 160));

        txt_dia.setColumns(20);
        txt_dia.setRows(5);
        jScrollPane3.setViewportView(txt_dia);

        p_servicioT.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 460, 150));

        txt_sol.setColumns(20);
        txt_sol.setRows(5);
        jScrollPane4.setViewportView(txt_sol);

        p_servicioT.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 480, 150));

        etiqueta_s.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        etiqueta_s.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_s.setText("Solución");
        p_servicioT.add(etiqueta_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 80, -1));

        etiqueta_o.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        etiqueta_o.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_o.setText("Observaciones");
        p_servicioT.add(etiqueta_o, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, -1));

        p_servicio.add(p_servicioT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1100, 450));

        p_eliminar_modificar_articulo.setBackground(new java.awt.Color(36, 22, 74));
        p_eliminar_modificar_articulo.setRoundBottomLeft(50);
        p_eliminar_modificar_articulo.setRoundBottomRight(50);
        p_eliminar_modificar_articulo.setRoundTopLeft(50);
        p_eliminar_modificar_articulo.setRoundTopRight(50);
        p_eliminar_modificar_articulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_articulo_eliminar.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        b_articulo_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        b_articulo_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_articulo_eliminar.setText("Eliminar");
        b_articulo_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_articulo_eliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_articulo_eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_articulo_eliminarMouseExited(evt);
            }
        });
        p_eliminar_modificar_articulo.add(b_articulo_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu_usuario/basura (1).png"))); // NOI18N
        p_eliminar_modificar_articulo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 12, 30, 30));

        p_servicio.add(p_eliminar_modificar_articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 700, 180, 50));

        jLabel24.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("dia");
        p_servicio.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, -1));

        t_dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        p_servicio.add(t_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 50, 30));

        t_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        p_servicio.add(t_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 50, 30));

        jLabel23.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("mes");
        p_servicio.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("año");
        p_servicio.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, -1, -1));

        t_anno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));
        p_servicio.add(t_anno, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 70, 30));

        p_b_imprimir_listar_articulos.setBackground(new java.awt.Color(36, 22, 74));
        p_b_imprimir_listar_articulos.setRoundBottomLeft(50);
        p_b_imprimir_listar_articulos.setRoundBottomRight(50);
        p_b_imprimir_listar_articulos.setRoundTopLeft(50);
        p_b_imprimir_listar_articulos.setRoundTopRight(50);
        p_b_imprimir_listar_articulos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_imprimir_listar_articulos.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        b_imprimir_listar_articulos.setForeground(new java.awt.Color(255, 255, 255));
        b_imprimir_listar_articulos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_imprimir_listar_articulos.setText("Imprimir Reporte");
        b_imprimir_listar_articulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_imprimir_listar_articulosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_imprimir_listar_articulosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_imprimir_listar_articulosMouseExited(evt);
            }
        });
        p_b_imprimir_listar_articulos.add(b_imprimir_listar_articulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        p_servicio.add(p_b_imprimir_listar_articulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 700, 200, 50));

        btn_memorandum.setBackground(new java.awt.Color(36, 22, 74));
        btn_memorandum.setRoundBottomLeft(50);
        btn_memorandum.setRoundBottomRight(50);
        btn_memorandum.setRoundTopLeft(50);
        btn_memorandum.setRoundTopRight(50);
        btn_memorandum.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_memo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btn_memo.setForeground(new java.awt.Color(255, 255, 255));
        btn_memo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_memo.setText("Memorandum");
        btn_memo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_memoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_memoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_memoMouseExited(evt);
            }
        });
        btn_memorandum.add(btn_memo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        p_servicio.add(btn_memorandum, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 700, 200, 50));

        getContentPane().add(p_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1100, 900));

        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound8.setBackground(new java.awt.Color(36, 22, 74));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);
        panelRound8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menuA/cerdo.png"))); // NOI18N
        panelRound8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 110, 100));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_login/tarjeta-de-direccion (1).png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        panelRound8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 80, 60));

        jLabel2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modificar Reporte");
        panelRound8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 470, 100));

        panelRound5.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, 860, 100));

        jLabel15.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Tipo");
        panelRound5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, 140, -1));

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
        panelRound5.add(barra_mover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 20));

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Servicio Tecnico", "Cambio de Toner" }));
        cmb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipoActionPerformed(evt);
            }
        });
        panelRound5.add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 70, 110, 40));

        getContentPane().add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void b_registrar_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrar_reporteMouseClicked
        //Registrar articulo y guardar en la base de datos

        //Llamado de clases
        ValidacionesGenerales vg = new ValidacionesGenerales();
        ValidacionesIndividual vi = new ValidacionesIndividual();

        //Obtener datos de los campos de textos
        String dia = (String) t_dia.getSelectedItem();
        String mes = (String) t_mes.getSelectedItem();
        String anno = (String) t_anno.getSelectedItem();
        String observacion = txt_obs.getText().trim();
        String diagnostico = txt_dia.getText().trim();
        String solucion = txt_sol.getText().trim();
        String requerimiento = txt_req.getText().trim();
        String fecha_ejecucion = t_anno.getSelectedItem() + "-" + t_mes.getSelectedItem() + "-" + t_dia.getSelectedItem();
        String tecnico = (String) cmb_tecnico.getSelectedItem();
        String articulo = (String) cmb_articulo.getSelectedItem();
        String grado = (String) cmb_grado.getSelectedItem();
        String usuario = (String) cmb_usuario.getSelectedItem();
        String equipo = (String) cmb_equipo.getSelectedItem();
        String departamento = (String) cmb_departamento.getSelectedItem();
        String tipo_reporte = (String) cmb_tipo.getSelectedItem();
        String codigo = (String) cmb_codigo.getSelectedItem();

        //Arreglos para validar los datos
        String[] camposT = {tecnico, grado, usuario, departamento};
        String[] camposN = {dia, mes, anno};
        String[] camposA = {};

        //Consultas de modificacion
        String modificar = "UPDATE `reportes` SET fecha_ejecucion=?, observacion=?,"
                + " diagnostico=?, solucion=?, requerimientos=?, tecnico=?,"
                + " articulo=?, usuario_equipo=?, equipo=? "
                + " WHERE codigo_reporte ='" + codigo + "'";
        String modificar2 = "UPDATE `reporte_detallado` SET grado_falla=?, id_departamento=?"
                + " WHERE codigo_reporte='" + codigo + "'";

        //Validacion de campos vacios
        if (vg.camposVaciosArray(camposT)) {

            //Confirmacion de contraseña
            if (tecnico.equals("------") && articulo.equals("------") && grado.equals("------")
                    && usuario.equals("------") && equipo.equals("------") && departamento.equals("------")
                    && tipo_reporte.equals("------")) {

                tecnico = null;
                articulo = null;
                grado = null;
                usuario = null;
                equipo = null;
                departamento = null;
                tipo_reporte = null;

            } else if (tecnico.equals("------")) {
                tecnico = null;
            } else if (articulo.equals("------")) {
                articulo = null;
            } else if (grado.equals("------")) {
                grado = null;
            } else if (usuario.equals("------")) {
                usuario = null;
            } else if (equipo.equals("------")) {
                equipo = null;
            } else if (departamento.equals("------")) {
                departamento = null;
            } else if (tipo_reporte.equals("------")) {
                tipo_reporte = null;
            }

            //Validacion de los diferentes caracteres de los campos
            if (!vg.validarNumerosC(camposN)) {
                JOptionPane.showMessageDialog(null, "Los campos (dia, mes, año) solo debe de contener numeros...");
            } else if (!vg.validarTodos(camposA)) {
                JOptionPane.showMessageDialog(null, "Los campos (contraseña, contraseñaConfirmar) no debe contener caracters especiales...");
            } else {

                //Modificar Reporte
                try {
                    Connection cn3 = Conexion_sql.conectar();
                    PreparedStatement pst3 = cn3.prepareStatement(modificar2);

                    pst3.setString(1, grado);
                    pst3.setString(2, departamento);

                    pst3.executeUpdate();

                    try {
                        Connection cn2 = Conexion_sql.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(modificar);

                        if (tipo_reporte.equals("Servicio Tecnico")) {
                            pst2.setString(1, fecha_ejecucion);
                            pst2.setString(2, observacion);
                            pst2.setString(3, diagnostico);
                            pst2.setString(4, solucion);
                            pst2.setString(5, requerimiento);
                            pst2.setString(6, tecnico);
                            pst2.setString(7, articulo);
                            pst2.setString(8, usuario);
                            pst2.setString(9, equipo);

                            pst2.executeUpdate();

                            cn2.close();

                            System.out.println("ReporteModificado servicio tecnico");

                        } else if (tipo_reporte.equals("Cambio de Toner")) {

                            pst2.setString(1, fecha_ejecucion);
                            pst2.setString(2, observacion);
                            pst2.setString(3, diagnostico);
                            pst2.setString(4, null);
                            pst2.setString(5, null);
                            pst2.setString(6, tecnico);
                            pst2.setString(7, articulo);
                            pst2.setString(8, usuario);
                            pst2.setString(9, equipo);

                            pst2.executeUpdate();

                            cn2.close();

                            System.out.println("ReporteModificado Cambio de toner");

                        } else {
                            JOptionPane.showMessageDialog(null, "Error de reporte");
                        }

                    } catch (Exception e) {
                        System.err.println(e);
                        JOptionPane.showMessageDialog(null, "Error al modificar datos de la tabla reportes...");
                    }

                    JOptionPane.showMessageDialog(null, "Reporte Modificado");

                    cn3.close();

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

            }

        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacios...");
        }
    }//GEN-LAST:event_b_registrar_reporteMouseClicked

    private void b_registrar_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrar_reporteMouseEntered
        //Cambiar el color al pasar el mouse por encima del boton "Registrar", del modulo
        // "Registrar equipo",
        p_modificar_reporte_crear_reporte.setBackground(new Color(20, 22, 84));
    }//GEN-LAST:event_b_registrar_reporteMouseEntered

    private void b_registrar_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrar_reporteMouseExited
        // Volver al color orginal , cuando el mouse no este sobre el boton "Registrar", de
        //Modulo "Registrar equipo"
        p_modificar_reporte_crear_reporte.setBackground(new Color(36, 22, 74));
    }//GEN-LAST:event_b_registrar_reporteMouseExited

    private void cmb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipoActionPerformed
//        String tipo_r = (String) cmb_tipo.getSelectedItem();
//
//        if (tipo_r.equals("Servicio Tecnico")) {
//            p_servicioT.setVisible(true);
//            p_asistencia.setVisible(false);
//        } else {
//            p_servicioT.setVisible(false);
//            p_asistencia.setVisible(true);
//        }
    }//GEN-LAST:event_cmb_tipoActionPerformed

    private void cmb_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_codigoActionPerformed
        //
        String codigo = (String) cmb_codigo.getSelectedItem();
        String tipo_r = (String) cmb_tipo.getSelectedItem();

        if (codigo.equals("------")) {
            t_dia.setSelectedIndex(0);
            t_mes.setSelectedIndex(0);
            t_anno.setSelectedIndex(0);
            txt_obs.setText("");
            txt_dia.setText("");
            txt_sol.setText("");
            txt_req.setText("");
            cmb_departamento.setSelectedIndex(0);
            cmb_articulo.setSelectedIndex(0);
            cmb_tecnico.setSelectedIndex(0);
            cmb_usuario.setSelectedIndex(0);
            cmb_equipo.setSelectedIndex(0);
        } else {

            try {
                Connection cn2 = Conexion_sql.conectar();
                PreparedStatement pst2 = cn2.prepareStatement("SELECT `grado_falla`, `id_departamento`, "
                        + "`tipo_reporte` FROM `reporte_detallado` "
                        + "WHERE codigo_reporte='" + codigo + "'");
                ResultSet rs2 = pst2.executeQuery();

                if (rs2.next()) {

                    String grado = rs2.getString("grado_falla");
                    String departamento = rs2.getString("id_departamento");
                    String tipo_reporte = rs2.getString("tipo_reporte");

                    Connection cn3 = Conexion_sql.conectar();
                    PreparedStatement pst3 = cn3.prepareStatement("SELECT `fecha_ejecucion`, "
                            + "`observacion`, `diagnostico`, `solucion`, `requerimientos`, "
                            + "`tecnico`, `articulo`, `usuario_equipo`, `equipo` "
                            + "FROM `bd_porcinos`.`reportes`WHERE codigo_reporte='" + codigo + "'");
                    ResultSet rs3 = pst3.executeQuery();

                    if (rs3.next()) {

                        String fecha = rs3.getString("fecha_ejecucion");
                        String obser = rs3.getString("observacion");
                        String diag = rs3.getString("diagnostico");
                        String solu = rs3.getString("solucion");
                        String req = rs3.getString("requerimientos");
                        String tecnico = rs3.getString("tecnico");
                        String articulo = rs3.getString("articulo");
                        String usuarioE = rs3.getString("usuario_equipo");
                        String equipo = rs3.getString("equipo");

                        if (tipo_reporte.equals("Cambio de Toner")) {
                            txt_obs.setText(obser);
                            txt_dia.setText(diag);
                            txt_sol.setText("");
                            txt_sol.setEnabled(false);
                            txt_sol.setEditable(false);
                            txt_req.setText("");
                            txt_req.setEnabled(false);
                            txt_req.setEditable(false);
                            cmb_tipo.setSelectedItem(tipo_reporte);
                            cmb_departamento.setSelectedItem(departamento);
                            cmb_grado.setSelectedItem(grado);
                            cmb_articulo.setSelectedItem(articulo);
                            cmb_tecnico.setSelectedItem(tecnico);
                            cmb_usuario.setSelectedItem(usuarioE);
                            cmb_equipo.setSelectedItem(equipo);
                            t_dia.setSelectedIndex(0);
                            t_mes.setSelectedIndex(0);
                            t_anno.setSelectedIndex(0);

                        } else if (tipo_reporte.equals("Servicio Tecnico")) {
                            txt_obs.setText(obser);
                            txt_dia.setText(diag);
                            txt_sol.setText(solu);
                            txt_sol.setEnabled(true);
                            txt_sol.setEditable(true);
                            txt_req.setText(req);
                            txt_req.setEnabled(true);
                            txt_req.setEditable(true);
                            cmb_tipo.setSelectedItem(tipo_reporte);
                            cmb_departamento.setSelectedItem(departamento);
                            cmb_grado.setSelectedItem(grado);
                            cmb_articulo.setSelectedItem(articulo);
                            cmb_tecnico.setSelectedItem(tecnico);
                            cmb_usuario.setSelectedItem(usuarioE);
                            cmb_equipo.setSelectedItem(equipo);
                            t_dia.setSelectedIndex(0);
                            t_mes.setSelectedIndex(0);
                            t_anno.setSelectedIndex(0);
                        }
                        cn3.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error no se encontro en reportes");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error no se encontro en reportes");
                }
                cn2.close();
            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al buscar reporte");
            }
        }
    }//GEN-LAST:event_cmb_codigoActionPerformed

    private void b_articulo_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_articulo_eliminarMouseClicked
        String busqueda = cmb_codigo.getSelectedItem().toString();

        //Codigo Para eliminar
        String eliminar = "DELETE FROM `reportes` WHERE `codigo_reporte`='" + busqueda + "'";
        String eliminar2 = "DELETE FROM `reporte_detallado` WHERE `codigo_reporte`='" + busqueda + "'";

        //Validacion de campos vacios
        if (!busqueda.equals("------")) {

            String clave = JOptionPane.showInputDialog("Introduce contraseña");

            if (clave.equals("EMSPA-01")) {

                int elimina = JOptionPane.showConfirmDialog(rootPane, "seguro que deeas eliminar el Reporte");

                if (elimina == 0) {

                    //Eliminar usuario
                    try {

                        Connection cn2 = Conexion_sql.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(eliminar);
                        pst2.executeUpdate();

                        Connection cn3 = Conexion_sql.conectar();
                        PreparedStatement pst3 = cn3.prepareStatement(eliminar2);
                        pst3.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Reporte Eliminado");

                        cn2.close();
                        cn3.close();

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
                        JOptionPane.showMessageDialog(null, "Error al eliminar...");
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
    }//GEN-LAST:event_b_articulo_eliminarMouseClicked

    private void b_articulo_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_articulo_eliminarMouseEntered
        // TODO add your handling code here:
        // Cambiar el color al hacer focus en el boton "ELIMINAR", del modulo
        //"MODIFICAR EQUIPO"
        p_eliminar_modificar_articulo.setBackground(new Color(164, 48, 48));
    }//GEN-LAST:event_b_articulo_eliminarMouseEntered

    private void b_articulo_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_articulo_eliminarMouseExited
        // Volver al color orginal , cuando el mouse no este sobre el boton "ELIMINAR", de
        //Modulo ",MODIFICAR ARTICULO"
        p_eliminar_modificar_articulo.setBackground(new Color(36, 22, 74));
    }//GEN-LAST:event_b_articulo_eliminarMouseExited

    private void b_imprimir_listar_articulosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_imprimir_listar_articulosMouseEntered
        /// Cambiar el color al pasar el mouse por encima del boton "IMPRIMIR LISTADO", del modulo
        //"LISTAR REPORTE"
        p_b_imprimir_listar_articulos.setBackground(new Color(20, 22, 84));
    }//GEN-LAST:event_b_imprimir_listar_articulosMouseEntered

    private void b_imprimir_listar_articulosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_imprimir_listar_articulosMouseExited
        /// volver al color original, al no tener el focus en el boton "IMPRIMIR LISTADO", del modulo
        //"LISTAR REPORTE"
        p_b_imprimir_listar_articulos.setBackground(new Color(36, 22, 74));
    }//GEN-LAST:event_b_imprimir_listar_articulosMouseExited

    private void b_imprimir_listar_articulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_imprimir_listar_articulosMouseClicked

        int tipo_reporte = cmb_tipo.getSelectedIndex();

        String Fecha_creacion = annio + "-" + mes + "-" + dia;
        String hora_creacion = hora + ":" + minutos + ":" + segundo;

        String codigo = (String) cmb_codigo.getSelectedItem();
        String fecha_ejecucion = t_anno.getSelectedItem() + "-" + t_mes.getSelectedItem() + "-" + t_dia.getSelectedItem();
        String tecnico = (String) cmb_tecnico.getSelectedItem();

        String grado = (String) cmb_grado.getSelectedItem();
        String departamento = (String) cmb_departamento.getSelectedItem();
        String usuario = (String) cmb_usuario.getSelectedItem();
        String equipo = (String) cmb_equipo.getSelectedItem();

        String observacion = txt_obs.getText().trim();
        String diagnostico = txt_dia.getText().trim();
        String solucion = txt_sol.getText().trim();
        String requerimiento = txt_req.getText().trim();

        if (!codigo.equals("------")) {

            if (tipo_reporte == 0) {

                Document documento = new Document();

                try {

                    String ruta = System.getProperty("user.home");
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + codigo + ".pdf"));

                    com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/Banner.png");
                    header.scaleToFit(650, 1000);
                    header.setAlignment(Chunk.ALIGN_CENTER);

//Servicio Tecnico
                    Paragraph parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add("Servicio Tecnico. \n \n");
                    parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.open();
                    documento.add(header);
                    documento.add(parrafo);

                    PdfPTable tabla1 = new PdfPTable(1);
                    tabla1.addCell("Creacion de reporte:  " + Fecha_creacion);
                    tabla1.addCell("Cofigo:  " + codigo + "");
                    tabla1.addCell("Fecha de Ejecucion:  " + fecha_ejecucion + "                  Hora: " + hora_creacion);
                    tabla1.addCell("Tecnico:  " + tecnico + "");

                    documento.add(tabla1);

//Area de Atendida
                    Paragraph parrafo2 = new Paragraph();
                    parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo2.add("\n \n Area de Atencion. \n \n");
                    parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.add(parrafo2);

                    PdfPTable tabla2 = new PdfPTable(1);
                    tabla2.addCell("Departamento:  " + departamento);
                    tabla2.addCell("Equipo:  " + equipo);
                    tabla2.addCell("Usuario:  " + usuario);
                    tabla2.addCell("Grado de Falla:  " + grado);

                    documento.add(tabla2);

//Descripcion            
                    Paragraph parrafo3 = new Paragraph();
                    parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo3.add("\n \n Descripcion. \n \n");
                    parrafo3.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.add(parrafo3);

                    PdfPTable tabla3 = new PdfPTable(2);
                    tabla3.addCell("Observaciones:  ");
                    tabla3.addCell("Diagnostico:  ");

                    tabla3.addCell(observacion);
                    tabla3.addCell(diagnostico);

                    documento.add(tabla3);

//Descripcion            
                    Paragraph parrafo4 = new Paragraph();
                    parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo4.add("\n \n  \n \n");
                    parrafo4.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.add(parrafo4);

                    PdfPTable tabla4 = new PdfPTable(2);
                    tabla4.addCell("Solucion:  ");
                    tabla4.addCell("Requerimientos:  ");

                    tabla4.addCell(solucion);
                    tabla4.addCell(requerimiento);

                    documento.add(tabla4);

                    Paragraph parrafo5 = new Paragraph();
                    parrafo5.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo5.add("\n \n  \n \n");
                    parrafo5.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.add(parrafo5);

                    PdfPTable tabla5 = new PdfPTable(2);
                    tabla5.addCell("    Firma del Tecnico  ");
                    tabla5.addCell("    Firma del Usuario  ");

                    tabla5.addCell(" ");
                    tabla5.addCell(" ");

                    documento.add(tabla5);

                    documento.close();
                    JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");

                } catch (DocumentException | IOException e) {
                    System.err.println("Error en PDF o ruta de imagen" + e);
                    JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al administrador");
                }

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

            } else if (tipo_reporte == 1) {

                Document documento = new Document();

                try {

                    String ruta = System.getProperty("user.home");
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + codigo + ".pdf"));

                    com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/Banner.png");
                    header.scaleToFit(650, 1000);
                    header.setAlignment(Chunk.ALIGN_CENTER);

//Servicio Tecnico
                    Paragraph parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add("Cambio de Toner. \n \n");
                    parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.open();
                    documento.add(header);
                    documento.add(parrafo);

                    PdfPTable tabla1 = new PdfPTable(1);
                    tabla1.addCell("Creacion de reporte:  " + Fecha_creacion);
                    tabla1.addCell("Cofigo:  " + codigo);
                    tabla1.addCell("Fecha de Ejecucion:  " + fecha_ejecucion + "                  Hora: " + hora_creacion);
                    tabla1.addCell("Tecnico:  " + tecnico);

                    documento.add(tabla1);

//Area de Atendida
                    Paragraph parrafo2 = new Paragraph();
                    parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo2.add("\n \n Area de Atencion. \n \n");
                    parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.add(parrafo2);

                    PdfPTable tabla2 = new PdfPTable(1);
                    tabla2.addCell("Departamento:  " + departamento);
                    tabla2.addCell("Equipo:  " + equipo);
                    tabla2.addCell("Usuario:  " + usuario);
                    tabla2.addCell("Grado de Falla:  " + grado);

                    documento.add(tabla2);

//Descripcion            
                    Paragraph parrafo3 = new Paragraph();
                    parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo3.add("\n \n Descripcion. \n \n");
                    parrafo3.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.add(parrafo3);

                    PdfPTable tabla3 = new PdfPTable(2);
                    tabla3.addCell("Observaciones:  ");
                    tabla3.addCell("Diagnostico:  ");

                    tabla3.addCell(observacion);
                    tabla3.addCell(diagnostico);

                    documento.add(tabla3);

                    Paragraph parrafo5 = new Paragraph();
                    parrafo5.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo5.add("\n \n  \n \n");
                    parrafo5.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.add(parrafo5);

                    PdfPTable tabla5 = new PdfPTable(2);
                    tabla5.addCell("    Firma del Tecnico  ");
                    tabla5.addCell("    Firma del Usuario  ");

                    tabla5.addCell(" ");
                    tabla5.addCell(" ");

                    documento.add(tabla5);

                    documento.close();
                    JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");

                } catch (DocumentException | IOException e) {
                    System.err.println("Error en PDF o ruta de imagen" + e);
                    JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al administrador");
                }

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

            } else {
                JOptionPane.showMessageDialog(null, "Error Consultar al administrador del sistema");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error al crear reporte verifica el codigo del reporte");
        }


    }//GEN-LAST:event_b_imprimir_listar_articulosMouseClicked

    private void btn_memoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_memoMouseClicked
        // redirigir a la interfaz de generar memorandum
        dispose();
        Crear_memorandum memo = new Crear_memorandum();
        memo.setVisible(true);
    }//GEN-LAST:event_btn_memoMouseClicked

    private void btn_memoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_memoMouseEntered
        btn_memorandum.setBackground(new Color(20, 22, 84));
    }//GEN-LAST:event_btn_memoMouseEntered

    private void btn_memoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_memoMouseExited
        btn_memorandum.setBackground(new Color(36, 22, 74));
    }//GEN-LAST:event_btn_memoMouseExited

    private void cmb_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departamentoActionPerformed
        
        cmb_usuario.removeAllItems();
        cmb_equipo.removeAllItems();

        String dp = (String) cmb_departamento.getSelectedItem();

        cmb_usuario.addItem("--------");
        cmb_equipo.addItem("--------");

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre, apellido FROM `usuarios_equipos` WHERE departamento= '" + dp + "'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_usuario.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_equipo FROM `equipos` WHERE departamento= '" + dp + "'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_equipo.addItem(rs.getString("nombre_equipo"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }
        
    }//GEN-LAST:event_cmb_departamentoActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Modificar_reporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_articulo_eliminar;
    private javax.swing.JLabel b_imprimir_listar_articulos;
    private javax.swing.JLabel b_registrar_reporte;
    private javax.swing.JLabel barra_mover4;
    private javax.swing.JLabel btn_memo;
    private prueba_diseño.PanelRound btn_memorandum;
    private javax.swing.JComboBox<String> cmb_articulo;
    private javax.swing.JComboBox<String> cmb_codigo;
    private javax.swing.JComboBox<String> cmb_departamento;
    private javax.swing.JComboBox<String> cmb_equipo;
    private javax.swing.JComboBox<String> cmb_grado;
    private javax.swing.JComboBox<String> cmb_tecnico;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JComboBox<String> cmb_usuario;
    private javax.swing.JLabel etiqueta_d;
    private javax.swing.JLabel etiqueta_o;
    private javax.swing.JLabel etiqueta_r;
    private javax.swing.JLabel etiqueta_s;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private prueba_diseño.PanelRound p_b_imprimir_listar_articulos;
    private prueba_diseño.PanelRound p_eliminar_modificar_articulo;
    private prueba_diseño.PanelRound p_modificar_reporte_crear_reporte;
    private prueba_diseño.PanelRound p_servicio;
    private prueba_diseño.PanelRound p_servicioT;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panelRound8;
    private javax.swing.JComboBox<String> t_anno;
    private javax.swing.JComboBox<String> t_dia;
    private javax.swing.JComboBox<String> t_mes;
    private javax.swing.JTextArea txt_dia;
    private javax.swing.JTextArea txt_obs;
    private javax.swing.JTextArea txt_req;
    private javax.swing.JTextArea txt_sol;
    // End of variables declaration//GEN-END:variables
}
