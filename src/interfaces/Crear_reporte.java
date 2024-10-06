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
public class Crear_reporte extends javax.swing.JFrame {

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;

    /*Fecha y Hora*/
    LocalDateTime fecha = LocalDateTime.now();

    int annio = fecha.getYear();
    int mes = fecha.getMonthValue();
    int dia = fecha.getDayOfMonth();
    int hora = fecha.getHour();
    int minutos = fecha.getMinute();
    int segundo = fecha.getSecond();

    public Crear_reporte() {
        initComponents();
        setTitle("Reportes");
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(1100, 930);

        //Inicio de panel de interface
        p_servicio.setVisible(true);
        p_toner.setVisible(false);

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

//        try {
//            Connection cn = Conexion_sql.conectar();
//            PreparedStatement pst = cn.prepareStatement(
//                    "SELECT nombre, apellido FROM `usuarios_equipos`");
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//
//                cmb_usuario.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
//
//            }
//            cn.close();
//
//        } catch (SQLException e) {
//            System.err.println(e);
//            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
//        }
//
//        try {
//            Connection cn = Conexion_sql.conectar();
//            PreparedStatement pst = cn.prepareStatement(
//                    "SELECT nombre_equipo FROM `equipos`");
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//
//                cmb_equipo.addItem(rs.getString("nombre_equipo"));
//
//            }
//            cn.close();
//
//        } catch (SQLException e) {
//            System.err.println(e);
//            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
//        }
        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_articulo FROM `articulos`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_articulos2.addItem(rs.getString("nombre_articulo"));

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

                cmb_tecnico2.addItem(rs.getString("nombre_usuario"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

//        try {
//            Connection cn = Conexion_sql.conectar();
//            PreparedStatement pst = cn.prepareStatement(
//                    "SELECT nombre_equipo FROM `equipos`");
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//
//                cmb_equipo2.addItem(rs.getString("nombre_equipo"));
//
//            }
//            cn.close();
//
//        } catch (SQLException e) {
//            System.err.println(e);
//            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
//        }
        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_departamento FROM `departamentos`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_departamento2.addItem(rs.getString("nombre_departamento"));

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

//        try {
//            Connection cn = Conexion_sql.conectar();
//            PreparedStatement pst = cn.prepareStatement(
//                    "SELECT nombre, apellido FROM `usuarios_equipos`");
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//
//                cmb_usuario2.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
//
//            }
//            cn.close();
//
//        } catch (SQLException e) {
//            System.err.println(e);
//            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
//        }
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
        panelRound5 = new prueba_diseño.PanelRound();
        panelRound8 = new prueba_diseño.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_tipo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        barra_mover4 = new javax.swing.JLabel();
        p_servicio = new prueba_diseño.PanelRound();
        p_registrar_reporte_crear_reporte = new prueba_diseño.PanelRound();
        b_registrar_reporte = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmb_equipo = new javax.swing.JComboBox<>();
        cmb_tecnico = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmb_articulo = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cmb_grado = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cmb_usuario = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cmb_departamento = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_req = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_obs = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_dia = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_sol = new javax.swing.JTextArea();
        t_anno = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        t_mes = new javax.swing.JComboBox<>();
        t_dia = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        p_toner = new prueba_diseño.PanelRound();
        jLabel26 = new javax.swing.JLabel();
        cmb_articulos2 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        cmb_usuario2 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cmb_equipo2 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        cmb_departamento2 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_dia2 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt_obs2 = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        p_registro_usurio_b_regitrar_u1 = new prueba_diseño.PanelRound();
        registrar2 = new javax.swing.JLabel();
        cmb_tecnico2 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        t_dia2 = new javax.swing.JComboBox<>();
        t_mes2 = new javax.swing.JComboBox<>();
        t_anno2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellido");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel2.setText("Registro de Reporte");
        panelRound8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 470, 100));

        panelRound5.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, 860, 100));

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Servicio Tecnico", "Cambio de Toner" }));
        cmb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipoActionPerformed(evt);
            }
        });
        panelRound5.add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 70, 110, 40));

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

        getContentPane().add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 130));

        p_servicio.setBackground(new java.awt.Color(0, 102, 102));
        p_servicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_registrar_reporte_crear_reporte.setBackground(new java.awt.Color(36, 22, 74));
        p_registrar_reporte_crear_reporte.setRoundBottomLeft(50);
        p_registrar_reporte_crear_reporte.setRoundBottomRight(50);
        p_registrar_reporte_crear_reporte.setRoundTopLeft(50);
        p_registrar_reporte_crear_reporte.setRoundTopRight(50);
        p_registrar_reporte_crear_reporte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_registrar_reporte.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        b_registrar_reporte.setForeground(new java.awt.Color(255, 255, 255));
        b_registrar_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_registrar_reporte.setText("Registrar");
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
        p_registrar_reporte_crear_reporte.add(b_registrar_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        p_servicio.add(p_registrar_reporte_crear_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 700, 180, 50));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Diagnóstico");
        p_servicio.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 250, 160, -1));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Equipo");
        p_servicio.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 160, -1));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Requerimientos");
        p_servicio.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 470, 160, -1));

        jLabel10.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Solución");
        p_servicio.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 80, -1));

        cmb_equipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------" }));
        p_servicio.add(cmb_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 110, 40));

        cmb_tecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        p_servicio.add(cmb_tecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 180, 110, 40));

        jLabel13.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Observaciones");
        p_servicio.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 160, -1));

        jLabel17.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tecnico");
        p_servicio.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 130, 160, -1));

        jLabel19.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Articulo");
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
        p_servicio.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 110, -1));

        cmb_usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------" }));
        p_servicio.add(cmb_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 110, 40));

        jLabel22.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Departamento");
        p_servicio.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 130, -1));

        cmb_departamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------" }));
        cmb_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departamentoActionPerformed(evt);
            }
        });
        p_servicio.add(cmb_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 200, 40));

        txt_req.setColumns(20);
        txt_req.setRows(5);
        jScrollPane1.setViewportView(txt_req);

        p_servicio.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 460, 150));

        txt_obs.setColumns(20);
        txt_obs.setRows(5);
        jScrollPane2.setViewportView(txt_obs);

        p_servicio.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 480, 160));

        txt_dia.setColumns(20);
        txt_dia.setRows(5);
        jScrollPane3.setViewportView(txt_dia);

        p_servicio.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 460, 150));

        txt_sol.setColumns(20);
        txt_sol.setRows(5);
        jScrollPane4.setViewportView(txt_sol);

        p_servicio.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 480, 150));

        t_anno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));
        p_servicio.add(t_anno, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 70, 30));

        jLabel11.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("año");
        p_servicio.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, -1, -1));

        jLabel23.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("mes");
        p_servicio.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        t_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        p_servicio.add(t_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 50, 30));

        t_dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        p_servicio.add(t_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 50, 30));

        jLabel24.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("dia");
        p_servicio.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, -1));

        getContentPane().add(p_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1100, 900));

        p_toner.setBackground(new java.awt.Color(0, 102, 102));
        p_toner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Articulo");
        p_toner.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 160, -1));

        cmb_articulos2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------" }));
        p_toner.add(cmb_articulos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 150, 40));

        jLabel27.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Usuario del Equipo");
        p_toner.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 160, -1));

        cmb_usuario2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------" }));
        p_toner.add(cmb_usuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 150, 40));

        jLabel28.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Nombre del Equipo");
        p_toner.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 160, 30));

        cmb_equipo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------" }));
        p_toner.add(cmb_equipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 150, 40));

        jLabel29.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Departamento");
        p_toner.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 210, -1));

        cmb_departamento2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------" }));
        cmb_departamento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departamento2ActionPerformed(evt);
            }
        });
        p_toner.add(cmb_departamento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 270, 40));

        jLabel30.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Diagnóstico");
        p_toner.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 160, -1));

        txt_dia2.setColumns(20);
        txt_dia2.setRows(5);
        jScrollPane5.setViewportView(txt_dia2);

        p_toner.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 920, 110));

        txt_obs2.setColumns(20);
        txt_obs2.setRows(5);
        jScrollPane8.setViewportView(txt_obs2);

        p_toner.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 920, 100));

        jLabel32.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Observaciones");
        p_toner.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 160, -1));

        p_registro_usurio_b_regitrar_u1.setBackground(new java.awt.Color(36, 22, 74));
        p_registro_usurio_b_regitrar_u1.setRoundBottomLeft(50);
        p_registro_usurio_b_regitrar_u1.setRoundBottomRight(50);
        p_registro_usurio_b_regitrar_u1.setRoundTopLeft(50);
        p_registro_usurio_b_regitrar_u1.setRoundTopRight(50);
        p_registro_usurio_b_regitrar_u1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrar2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        registrar2.setForeground(new java.awt.Color(255, 255, 255));
        registrar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrar2.setText("Registrar");
        registrar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrar2MouseClicked(evt);
            }
        });
        p_registro_usurio_b_regitrar_u1.add(registrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        p_toner.add(p_registro_usurio_b_regitrar_u1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 700, 180, 50));

        cmb_tecnico2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------" }));
        p_toner.add(cmb_tecnico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 150, 40));

        jLabel31.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Técnico");
        p_toner.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 210, -1));

        t_dia2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        p_toner.add(t_dia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 50, 30));

        t_mes2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        p_toner.add(t_mes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 50, 30));

        t_anno2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));
        p_toner.add(t_anno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 70, 30));

        jLabel4.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("dia");
        p_toner.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("mes");
        p_toner.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("año");
        p_toner.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, -1, -1));

        getContentPane().add(p_toner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1100, 800));

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

    private void b_registrar_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrar_reporteMouseEntered
        //Cambiar el color al pasar el mouse por encima del boton "Registrar", del modulo
        // "Registrar equipo", 
        p_registrar_reporte_crear_reporte.setBackground(new Color(20, 22, 84));

    }//GEN-LAST:event_b_registrar_reporteMouseEntered

    private void b_registrar_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrar_reporteMouseExited
        // Volver al color orginal , cuando el mouse no este sobre el boton "Registrar", de
        //Modulo "Registrar equipo"
        p_registrar_reporte_crear_reporte.setBackground(new Color(36, 22, 74));
    }//GEN-LAST:event_b_registrar_reporteMouseExited

    private void b_registrar_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_registrar_reporteMouseClicked
        //Registrar articulo y guardar en la base de datos

        //Generar codigo de articulo
        String m = String.valueOf(mes);
        String d = String.valueOf(dia);
        String a = String.valueOf(annio);
        int numero = (int) (Math.random() * 1000) + 1;

        //Llamado de clases
        ValidacionesGenerales vg = new ValidacionesGenerales();
        ValidacionesIndividual vi = new ValidacionesIndividual();

        //Obtener datos de los campos de textos
        String observacion = txt_obs.getText().trim();
        String diagnostico = txt_dia.getText().trim();
        String solucion = txt_sol.getText().trim();
        String requerimiento = txt_req.getText().trim();
        String fecha_creacion = annio + "-" + mes + "-" + dia;
        String fecha_ejecucion = t_anno.getSelectedItem() + "-" + t_mes.getSelectedItem() + "-" + t_dia.getSelectedItem();
        String tecnico = (String) cmb_tecnico.getSelectedItem();
        String articulo = (String) cmb_articulo.getSelectedItem();
        String grado = (String) cmb_grado.getSelectedItem();
        String usuario = (String) cmb_usuario.getSelectedItem();
        String equipo = (String) cmb_equipo.getSelectedItem();
        String departamento = (String) cmb_departamento.getSelectedItem();
        String tipo_reporte = (String) cmb_tipo.getSelectedItem();

        //generar codigo del reporte
        String codigo = "ST" + numero + "-" + tecnico + "-" + d + m + a;

        //Arreglos para validar los datos
        String[] camposT = {tecnico, grado, usuario, departamento};
        String[] camposL = {grado, usuario};
        String[] camposA = {observacion, diagnostico, solucion, requerimiento, tecnico, articulo, equipo, departamento};

        //Consultas
        String comprobacion = "SELECT codigo_reporte FROM reportes "
                + "WHERE codigo_reporte ='" + codigo + "'";
        String agregar = "INSERT INTO reportes values (?,?,?,?,?,?,?,?,?,?,?,?)";
        String agregar2 = "INSERT INTO reporte_detallado values (?,?,?,?,?,?,?)";

        //Validacion de campos vacios
        if (vg.camposVaciosArray(camposT)) {

            //Validacion de los diferentes caracteres de los campos
            if (!vg.validarLetras(camposL)) {
                JOptionPane.showMessageDialog(null, "Los campos (grado, usuario) solo deben contener letras...");
            } else if (!vg.validarTodos(camposA)) {
                JOptionPane.showMessageDialog(null, "Los campos (contraseña, contraseñaConfirmar) solo debe contener caracters (-./)...");
            } else {

                //Verificaion de ecistencia de articulo
                try {
                    Connection cn = Conexion_sql.conectar();
                    PreparedStatement pst = cn.prepareStatement(comprobacion);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Codigo existente....");
                    } else if (!rs.next()) {

                        //Registrar usuario
                        try {
                            Connection cn2 = Conexion_sql.conectar();
                            PreparedStatement pst2 = cn2.prepareStatement(agregar);

                            pst2.setString(1, null);
                            pst2.setString(2, codigo);
                            pst2.setString(3, fecha_creacion);
                            pst2.setString(4, fecha_ejecucion);
                            pst2.setString(5, observacion);
                            pst2.setString(6, diagnostico);
                            pst2.setString(7, solucion);
                            pst2.setString(8, requerimiento);
                            pst2.setString(9, tecnico);
                            pst2.setString(10, articulo);
                            pst2.setString(11, usuario);
                            pst2.setString(12, equipo);

                            pst2.executeUpdate();

                            try {
                                Connection cn3 = Conexion_sql.conectar();
                                PreparedStatement pst3 = cn3.prepareStatement(agregar2);

                                pst3.setString(1, null);
                                pst3.setString(2, grado);
                                pst3.setString(3, Administrador.usuario);
                                pst3.setString(4, departamento);
                                pst3.setString(5, codigo);
                                pst3.setString(6, tipo_reporte);
                                pst3.setString(7, fecha_ejecucion);

                                pst3.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Reporte Registrado con exito...");

                                if (tipo.equals("Administrador")) {
                                    dispose();
                                    Administrador menu = new Administrador();
                                    menu.setVisible(true);
                                    cn3.close();
                                    cn2.close();
                                    cn.close();

                                } else if (tipo.equals("Tecnico")) {
                                    dispose();
                                    Tecnico menu = new Tecnico();
                                    menu.setVisible(true);
                                    cn3.close();
                                    cn2.close();
                                    cn.close();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error del servidor");
                                }

                            } catch (Exception e3) {
                                System.err.println(e3);
                                JOptionPane.showMessageDialog(null, "verifica Reporte...");
                            }

                            cn2.close();
                            cn.close();

                        } catch (Exception e2) {
                            System.err.println(e2);
                            JOptionPane.showMessageDialog(null, "Error al Crear Reporte...");
                        }

                    }
                } catch (Exception e1) {

                    System.err.println(e1);
                    JOptionPane.showMessageDialog(null, "Error al verificar Reporte");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacios...");
        }
    }//GEN-LAST:event_b_registrar_reporteMouseClicked

    private void registrar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrar2MouseClicked
        //Registrar articulo y guardar en la base de datos

        //Generar codigo de articulo
        String m = String.valueOf(mes);
        String d = String.valueOf(dia);
        String a = String.valueOf(annio);
        int numero = (int) (Math.random() * 1000) + 1;

        //Llamado de clases
        ValidacionesGenerales vg = new ValidacionesGenerales();
        ValidacionesIndividual vi = new ValidacionesIndividual();

        //Obtener datos de los campos de textos
        String observacion = txt_obs2.getText().trim();
        String diagnostico = txt_dia2.getText().trim();
        String solucion = null;
        String requerimiento = null;
        String fecha_creacion = annio + "-" + mes + "-" + dia;
        String fecha_ejecucion = t_anno2.getSelectedItem() + "-" + t_mes2.getSelectedItem() + "-" + t_dia2.getSelectedItem();
        String tecnico = (String) cmb_tecnico2.getSelectedItem();
        String articulo = (String) cmb_articulos2.getSelectedItem();
        String usuario = (String) cmb_usuario2.getSelectedItem();
        String equipo = (String) cmb_equipo2.getSelectedItem();
        String departamento = (String) cmb_departamento2.getSelectedItem();
        String tipo_reporte = (String) cmb_tipo.getSelectedItem();

        //generar codigo del reporte
        String codigo = "AS" + numero + "-" + tecnico + "-" + d + m + a;

        //Arreglos para validar los datos
        String[] camposT = {tecnico, usuario, departamento};
        String[] camposL = {usuario};
        String[] camposA = {tecnico, articulo, equipo, departamento};

        //Consultas
        String comprobacion = "SELECT codigo_reporte FROM reportes "
                + "WHERE codigo_reporte ='" + codigo + "'";
        String agregar = "INSERT INTO reportes values (?,?,?,?,?,?,?,?,?,?,?,?)";
        String agregar2 = "INSERT INTO reporte_detallado values (?,?,?,?,?,?,?)";

        //Validacion de campos vacios
        if (vg.camposVaciosArray(camposT)) {

            //Validacion de los diferentes caracteres de los campos
            if (!vg.validarLetras(camposL)) {
                JOptionPane.showMessageDialog(null, "Los campos (usuario) solo deben contener letras...");
            } else if (!vg.validarTodos(camposA)) {
                JOptionPane.showMessageDialog(null, "Los campos (tecnico, articulo, equipo, departamento, observacion, diagnostico, solucion, requerimiento) solo debe contener caracters (-./)...");
            } else {

                //Verificaion de ecistencia de articulo
                try {
                    Connection cn = Conexion_sql.conectar();
                    PreparedStatement pst = cn.prepareStatement(comprobacion);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Codigo existente....");
                    } else if (!rs.next()) {

                        //Registrar usuario
                        try {
                            Connection cn2 = Conexion_sql.conectar();
                            PreparedStatement pst2 = cn2.prepareStatement(agregar);

                            pst2.setString(1, null);
                            pst2.setString(2, codigo);
                            pst2.setString(3, fecha_creacion);
                            pst2.setString(4, fecha_ejecucion);
                            pst2.setString(5, observacion);
                            pst2.setString(6, diagnostico);
                            pst2.setString(7, solucion);
                            pst2.setString(8, requerimiento);
                            pst2.setString(9, tecnico);
                            pst2.setString(10, articulo);
                            pst2.setString(11, usuario);
                            pst2.setString(12, equipo);

                            pst2.executeUpdate();

                            try {
                                Connection cn3 = Conexion_sql.conectar();
                                PreparedStatement pst3 = cn3.prepareStatement(agregar2);

                                pst3.setString(1, null);
                                pst3.setString(2, "Sustitucion");
                                pst3.setString(3, Administrador.usuario);
                                pst3.setString(4, departamento);
                                pst3.setString(5, codigo);
                                pst3.setString(6, tipo_reporte);
                                pst3.setString(7, fecha_ejecucion);

                                pst3.executeUpdate();

                                JOptionPane.showMessageDialog(null, "reporte Registrado con exito...");

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
                                JOptionPane.showMessageDialog(null, "Error al agregar el detalle del reporte...");
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
    }//GEN-LAST:event_registrar2MouseClicked

    private void cmb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipoActionPerformed
        if (cmb_tipo.getSelectedIndex() == 0) {

            p_servicio.setVisible(true);
            p_toner.setVisible(false);
            
            t_dia2.setSelectedIndex(0);
            t_mes2.setSelectedIndex(0);
            t_anno2.setSelectedIndex(0);
            txt_obs2.setText("");
            txt_dia2.setText("");
            cmb_articulos2.setSelectedIndex(0);
            cmb_departamento2.setSelectedIndex(0);
            cmb_tecnico2.setSelectedIndex(0);
            cmb_usuario2.setSelectedIndex(0);
            cmb_equipo2.setSelectedIndex(0);

        } else if (cmb_tipo.getSelectedIndex() == 1) {

            p_servicio.setVisible(false);
            p_toner.setVisible(true);
            
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

        }
    }//GEN-LAST:event_cmb_tipoActionPerformed

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

    private void cmb_departamento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departamento2ActionPerformed
        cmb_usuario2.removeAllItems();
        cmb_equipo2.removeAllItems();

        String dp = (String) cmb_departamento2.getSelectedItem();

        cmb_usuario2.addItem("--------");
        cmb_equipo2.addItem("--------");

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre, apellido FROM `usuarios_equipos` WHERE departamento= '" + dp + "'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_usuario2.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));

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

                cmb_equipo2.addItem(rs.getString("nombre_equipo"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }
    }//GEN-LAST:event_cmb_departamento2ActionPerformed

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
            java.util.logging.Logger.getLogger(Crear_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Crear_reporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_registrar_reporte;
    private javax.swing.JLabel barra_mover4;
    private javax.swing.JComboBox<String> cmb_articulo;
    private javax.swing.JComboBox<String> cmb_articulos2;
    private javax.swing.JComboBox<String> cmb_departamento;
    private javax.swing.JComboBox<String> cmb_departamento2;
    private javax.swing.JComboBox<String> cmb_equipo;
    private javax.swing.JComboBox<String> cmb_equipo2;
    private javax.swing.JComboBox<String> cmb_grado;
    private javax.swing.JComboBox<String> cmb_tecnico;
    private javax.swing.JComboBox<String> cmb_tecnico2;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JComboBox<String> cmb_usuario;
    private javax.swing.JComboBox<String> cmb_usuario2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private prueba_diseño.PanelRound p_registrar_reporte_crear_reporte;
    private prueba_diseño.PanelRound p_registro_usurio_b_regitrar_u1;
    private prueba_diseño.PanelRound p_servicio;
    private prueba_diseño.PanelRound p_toner;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panelRound8;
    private javax.swing.JLabel registrar2;
    private javax.swing.JComboBox<String> t_anno;
    private javax.swing.JComboBox<String> t_anno2;
    private javax.swing.JComboBox<String> t_dia;
    private javax.swing.JComboBox<String> t_dia2;
    private javax.swing.JComboBox<String> t_mes;
    private javax.swing.JComboBox<String> t_mes2;
    private javax.swing.JTextArea txt_dia;
    private javax.swing.JTextArea txt_dia2;
    private javax.swing.JTextArea txt_obs;
    private javax.swing.JTextArea txt_obs2;
    private javax.swing.JTextArea txt_req;
    private javax.swing.JTextArea txt_sol;
    // End of variables declaration//GEN-END:variables
}
