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

public class Modificar_articulos extends javax.swing.JFrame {

    //Variables para obtener posicion(x,y) de la ventana en la pantalla
    int mouseX, mouseY;

    String IDarticulo = "";

    public Modificar_articulos() {

        IDarticulo = Listar_articulos.IDarticulo_update;

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

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_articulo FROM `articulos`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_nombre.addItem(rs.getString("nombre_articulo"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        if (IDarticulo.equals("")) {

        } else {

            try {
                Connection cn2 = Conexion_sql.conectar();
                PreparedStatement pst2 = cn2.prepareStatement("SELECT `nombre_articulo`, "
                        + "`descripcion`, `finalizado`, `tipo_articulo`"
                        + "FROM `articulos` WHERE codigo_articulo='" + IDarticulo + "'");
                ResultSet rs2 = pst2.executeQuery();

                if (rs2.next()) {

                    String nombre = rs2.getString("nombre_articulo");
                    String descripcion = rs2.getString("descripcion");
                    String fecha = rs2.getString("finalizado");
                    String tipo = rs2.getString("tipo_articulo");

                    Connection cn3 = Conexion_sql.conectar();
                    PreparedStatement pst3 = cn3.prepareStatement("SELECT `marca`, "
                            + "`estado_articulo`, `num_bien`, `pertenece_equipo`, `departamento` "
                            + "FROM `existencias` WHERE articulo='" + IDarticulo + "'");
                    ResultSet rs3 = pst3.executeQuery();

                    if (rs3.next()) {

                        String marca = rs3.getString("marca");
                        String estado = rs3.getString("estado_articulo");
                        String num_bien = rs3.getString("num_bien");
                        String equipo = rs3.getString("pertenece_equipo");
                        String departamento = rs3.getString("departamento");

                        cmb_nombre.setSelectedItem(nombre);
                        txt_Nbien.setText(num_bien);
                        txt_nombre.setText(nombre);
                        txt_marca.setText(marca);
                        txt_fecha.setText(fecha);
                        txt_descripcion.setText(descripcion);
                        cmb_tipo.setSelectedItem(tipo);
                        cmb_equipo.setSelectedItem(equipo);
                        cmb_estado.setSelectedItem(estado);
                        cmb_departamento.setSelectedItem(departamento);

                    } else {
                        JOptionPane.showMessageDialog(null, "Error no se encontro en existencia");

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Error no se encontro en articulos");

                }

            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al buscar articulo");
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

        p_invetario_modificar_componentes = new prueba_diseño.PanelRound();
        p_b_registro_articulo = new prueba_diseño.PanelRound();
        b_articulo_modifcar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        p_eliminar_modificar_articulo = new prueba_diseño.PanelRound();
        b_articulo_eliminar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelRound2 = new prueba_diseño.PanelRound();
        txt_marca = new javax.swing.JTextField();
        panelRound1 = new prueba_diseño.PanelRound();
        txt_Nbien = new javax.swing.JTextField();
        panelRound6 = new prueba_diseño.PanelRound();
        txt_nombre = new javax.swing.JTextField();
        cmb_equipo = new javax.swing.JComboBox<>();
        cmb_estado = new javax.swing.JComboBox<>();
        cmb_departamento = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        cmb_nombre = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        panelRound3 = new prueba_diseño.PanelRound();
        txt_fecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t_dia = new javax.swing.JComboBox<>();
        t_mes = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        t_annio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cabecera = new prueba_diseño.PanelRound();
        panelRound8 = new prueba_diseño.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        barra_mover4 = new javax.swing.JLabel();
        cmb_tipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_invetario_modificar_componentes.setBackground(new java.awt.Color(0, 102, 102));
        p_invetario_modificar_componentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p_b_registro_articulo.setBackground(new java.awt.Color(36, 22, 74));
        p_b_registro_articulo.setRoundBottomLeft(50);
        p_b_registro_articulo.setRoundBottomRight(50);
        p_b_registro_articulo.setRoundTopLeft(50);
        p_b_registro_articulo.setRoundTopRight(50);
        p_b_registro_articulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_articulo_modifcar.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        b_articulo_modifcar.setForeground(new java.awt.Color(255, 255, 255));
        b_articulo_modifcar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_articulo_modifcar.setText("Modificar");
        b_articulo_modifcar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_articulo_modifcarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_articulo_modifcarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_articulo_modifcarMouseExited(evt);
            }
        });
        p_b_registro_articulo.add(b_articulo_modifcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar (2).png"))); // NOI18N
        p_b_registro_articulo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 12, 30, 30));

        p_invetario_modificar_componentes.add(p_b_registro_articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 580, 180, 50));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Estado");
        p_invetario_modificar_componentes.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 160, -1));

        jLabel14.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Número de Bien");
        p_invetario_modificar_componentes.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 160, -1));

        jLabel13.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Descripción");
        p_invetario_modificar_componentes.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 160, -1));

        jLabel17.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nombre del Artículo");
        p_invetario_modificar_componentes.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 160, -1));

        jLabel18.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Artículo");
        p_invetario_modificar_componentes.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 200, -1));

        jLabel21.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Marca");
        p_invetario_modificar_componentes.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 160, -1));

        jLabel22.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Departamento");
        p_invetario_modificar_componentes.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 210, -1));

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

        p_invetario_modificar_componentes.add(p_eliminar_modificar_articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 580, 180, 50));

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

        p_invetario_modificar_componentes.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 180, 50));

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

        p_invetario_modificar_componentes.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 180, 50));

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

        p_invetario_modificar_componentes.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 180, 50));

        cmb_equipo.setFont(new java.awt.Font("Serif", 0, 11)); // NOI18N
        cmb_equipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        p_invetario_modificar_componentes.add(cmb_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 170, 40));

        cmb_estado.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------", "Almacen", "Dañado", "En revision", "En uso" }));
        p_invetario_modificar_componentes.add(cmb_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 170, 40));

        cmb_departamento.setFont(new java.awt.Font("Serif", 0, 11)); // NOI18N
        cmb_departamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        cmb_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departamentoActionPerformed(evt);
            }
        });
        p_invetario_modificar_componentes.add(cmb_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 170, 40));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane2.setViewportView(txt_descripcion);

        p_invetario_modificar_componentes.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 550, 90));

        cmb_nombre.setFont(new java.awt.Font("Serif", 0, 11)); // NOI18N
        cmb_nombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        cmb_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_nombreActionPerformed(evt);
            }
        });
        p_invetario_modificar_componentes.add(cmb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 170, 40));

        jLabel19.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText(" Equipo");
        p_invetario_modificar_componentes.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 200, 200, -1));

        jLabel23.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText(" Equipo");
        p_invetario_modificar_componentes.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 200, -1));

        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_fecha.setEditable(false);
        txt_fecha.setBackground(new java.awt.Color(218, 215, 220));
        txt_fecha.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txt_fecha.setBorder(null);
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });
        panelRound3.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        p_invetario_modificar_componentes.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 180, 50));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("dia");
        p_invetario_modificar_componentes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 20, -1));

        t_dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        p_invetario_modificar_componentes.add(t_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 50, 30));

        t_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        p_invetario_modificar_componentes.add(t_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 50, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("mes");
        p_invetario_modificar_componentes.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 30, -1));

        t_annio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));
        p_invetario_modificar_componentes.add(t_annio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 70, 30));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("año");
        p_invetario_modificar_componentes.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 30, -1));

        jLabel16.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha Finalizado");
        p_invetario_modificar_componentes.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 160, -1));

        getContentPane().add(p_invetario_modificar_componentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 700, 690));

        cabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound8.setBackground(new java.awt.Color(36, 22, 74));
        panelRound8.setRoundBottomLeft(50);
        panelRound8.setRoundBottomRight(50);
        panelRound8.setRoundTopLeft(50);
        panelRound8.setRoundTopRight(50);
        panelRound8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerdo.png"))); // NOI18N
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
        jLabel2.setText("Modificar Artículo");
        panelRound8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 340, 40));

        cabecera.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 510, 80));

        jLabel20.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel20.setText("Tipo de Artículo");
        cabecera.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 130, -1));

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
        cabecera.add(barra_mover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 20));

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insumo", "Componente" }));
        cabecera.add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 120, 30));

        getContentPane().add(cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 130));

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

    private void b_articulo_modifcarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_articulo_modifcarMouseClicked
        //Modificacion Usuario y guardar en la base de datos

        //Llamado de clases
        ValidacionesGenerales vg = new ValidacionesGenerales();
        ValidacionesIndividual vi = new ValidacionesIndividual();

        //Obtener datos de los campos de textos
        String Nbien = txt_Nbien.getText().trim();
        String nombre = txt_nombre.getText().trim();
        String marca = txt_marca.getText().trim();
        String fecha = t_annio.getSelectedItem() + "-" + t_mes.getSelectedItem() + "-" + t_dia.getSelectedItem();
        String descripcion = txt_descripcion.getText().trim();
        String tipo_articulo = (String) cmb_tipo.getSelectedItem();
        String equipo = (String) cmb_equipo.getSelectedItem();
        String estado = (String) cmb_estado.getSelectedItem();
        String departamento = (String) cmb_departamento.getSelectedItem();
        String nombre_consulta = (String) cmb_nombre.getSelectedItem();

        String codigo = "";
        //Arreglos para validar los datos
        String[] camposT = {nombre, marca, tipo_articulo, estado, descripcion};
        String[] camposL = {};
        String[] camposA = {Nbien, marca, nombre, equipo, departamento, descripcion};

        //Consulta codigo
        String consulta_codigo = "SELECT `codigo_articulo` FROM `articulos`"
                + "WHERE nombre_articulo='" + nombre_consulta + "'";

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(consulta_codigo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                codigo = rs.getString("codigo_articulo");

                //Consultas de modificacion
                String modificar = "UPDATE articulos SET nombre_articulo=?, descripcion=?, finalizado"
                        + "=?, tipo_articulo=?"
                        + " WHERE codigo_articulo='" + codigo + "'";

                String modificar2 = "UPDATE existencias SET marca=?, estado_articulo=?, num_bien=?,"
                        + "fecha_salida=?, pertenece_equipo=?, departamento=?"
                        + " WHERE articulo='" + codigo + "'";

                //Validacion de campos vacios
                if (vg.camposVaciosArray(camposT)) {

                    //Confirmacion de contraseña
                    if (tipo_articulo.equals("------") && equipo.equals("------") && estado.equals("------") && departamento.equals("------")) {

                        estado = null;
                        equipo = null;
                        departamento = null;
                        tipo_articulo = null;

                    } else if (tipo_articulo.equals("------")) {
                        tipo_articulo = null;
                    } else if (equipo.equals("------")) {
                        equipo = null;
                    } else if (estado.equals("------")) {
                        estado = null;
                    } else if (departamento.equals("------")) {
                        departamento = null;
                    }

                    //Validacion de los diferentes caracteres de los campos
                    if (!vg.validarLetras(camposL)) {
                        JOptionPane.showMessageDialog(null, "Los campos (nombre, apellido, nombreUsuario) solo deben contener letras...");
                    } else if (!vg.validarTodos(camposA)) {
                        JOptionPane.showMessageDialog(null, "Los campos (contraseña, contraseñaConfirmar) no debe contener caracters especiales...");
                    } else {

                        //Modificar Articulo
                        try {
                            Connection cn2 = Conexion_sql.conectar();
                            PreparedStatement pst2 = cn2.prepareStatement(modificar);

                            pst2.setString(1, nombre);
                            pst2.setString(2, descripcion);
                            pst2.setString(3, fecha);
                            pst2.setString(4, tipo_articulo);

                            pst2.executeUpdate();

                            try {
                                Connection cn3 = Conexion_sql.conectar();
                                PreparedStatement pst3 = cn3.prepareStatement(modificar2);

                                pst3.setString(1, marca);
                                pst3.setString(2, estado);
                                pst3.setString(3, Nbien);
                                pst3.setString(4, fecha);
                                pst3.setString(5, equipo);
                                pst3.setString(6, departamento);

                                pst3.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Articulo Modificado");

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

//                        
                            } catch (Exception e) {
                                System.err.println(e);
                            }

                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Hay campos vacios...");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar codigo");
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }


    }//GEN-LAST:event_b_articulo_modifcarMouseClicked

    private void b_articulo_modifcarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_articulo_modifcarMouseEntered
        //Cambiar el color al pasar el mouse por encima del boton "ACTUALIZAR", del modulo
        // "MODIFICAR EQUIPO", 
        p_b_registro_articulo.setBackground(new Color(20, 22, 84));
    }//GEN-LAST:event_b_articulo_modifcarMouseEntered

    private void b_articulo_modifcarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_articulo_modifcarMouseExited
        // Volver al color orginal , cuando el mouse no este sobre el boton "REGISTRAR", de
        //Modulo ",MODIFICAR EQUIPO"
        p_b_registro_articulo.setBackground(new Color(36, 22, 74));
    }//GEN-LAST:event_b_articulo_modifcarMouseExited

    private void txt_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_marcaActionPerformed

    private void txt_NbienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NbienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NbienActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void cmb_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_departamentoActionPerformed

    private void cmb_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_nombreActionPerformed
        //
        String nombre_consulta = (String) cmb_nombre.getSelectedItem();
        String consulta_codigo = "SELECT `codigo_articulo` FROM `articulos`"
                + "WHERE nombre_articulo='" + nombre_consulta + "'";

        try {
            Connection cn = Conexion_sql.conectar();
            PreparedStatement pst = cn.prepareStatement(consulta_codigo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String codigo_articulo = rs.getString("codigo_articulo");

                try {
                    Connection cn2 = Conexion_sql.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("SELECT `nombre_articulo`, "
                            + "`descripcion`, `finalizado`, `tipo_articulo`"
                            + "FROM `articulos` WHERE codigo_articulo='" + codigo_articulo + "'");
                    ResultSet rs2 = pst2.executeQuery();

                    if (rs2.next()) {

                        String nombre = rs2.getString("nombre_articulo");
                        String descripcion = rs2.getString("descripcion");
                        String fecha = rs2.getString("finalizado");
                        String tipo = rs2.getString("tipo_articulo");

                        Connection cn3 = Conexion_sql.conectar();
                        PreparedStatement pst3 = cn3.prepareStatement("SELECT `marca`, "
                                + "`estado_articulo`, `num_bien`, `pertenece_equipo`, `departamento` "
                                + "FROM `existencias` WHERE articulo='" + codigo_articulo + "'");
                        ResultSet rs3 = pst3.executeQuery();

                        if (rs3.next()) {

                            String marca = rs3.getString("marca");
                            String estado = rs3.getString("estado_articulo");
                            String num_bien = rs3.getString("num_bien");
                            String equipo = rs3.getString("pertenece_equipo");
                            String departamento = rs3.getString("departamento");

                            txt_Nbien.setText(num_bien);
                            txt_nombre.setText(nombre);
                            txt_marca.setText(marca);
                            txt_fecha.setText(fecha);
                            txt_descripcion.setText(descripcion);
                            cmb_tipo.setSelectedItem(tipo);
                            cmb_equipo.setSelectedItem(equipo);
                            cmb_estado.setSelectedItem(estado);
                            cmb_departamento.setSelectedItem(departamento);

                        } else {
                            JOptionPane.showMessageDialog(null, "Error no se encontro en existencia");

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Error no se encontro en articulos");

                    }
                    cn.close();

                } catch (SQLException e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Error al buscar articulo");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar codigo");
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }


    }//GEN-LAST:event_cmb_nombreActionPerformed

    private void b_articulo_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_articulo_eliminarMouseClicked
        String busqueda = cmb_nombre.getSelectedItem().toString();

        //Consultas
        String consulta_codigo = "SELECT `codigo_articulo` FROM `articulos`"
                + "WHERE nombre_articulo='" + busqueda + "'";

        //Validacion de campos vacios
        if (!busqueda.equals("------")) {

            String clave = JOptionPane.showInputDialog("Introduce contraseña");

            if (clave.equals("EMSPA-01")) {

                int elimina = JOptionPane.showConfirmDialog(rootPane, "seguro que deeas eliminar el Articulo");

                if (elimina == 0) {

                    //Eliminar usuario
                    try {

                        //Codigo Pera buscar en la base de datos
                        Connection cn = Conexion_sql.conectar();
                        PreparedStatement pst = cn.prepareStatement(consulta_codigo);
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                            String codigo_articulo = rs.getString("codigo_articulo");

                            try {
                                //Codigo Para eliminar
                                String eliminar = "DELETE FROM `articulos` WHERE `codigo_articulo`='" + codigo_articulo + "'";
                                String eliminar2 = "DELETE FROM `existencias` WHERE `articulo`='" + codigo_articulo + "'";

                                Connection cn2 = Conexion_sql.conectar();
                                PreparedStatement pst2 = cn2.prepareStatement(eliminar);
                                pst2.executeUpdate();

                                Connection cn3 = Conexion_sql.conectar();
                                PreparedStatement pst3 = cn3.prepareStatement(eliminar2);
                                pst3.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Articulo Eliminado");

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
                        } else {
                        }

                    } catch (Exception e) {
                        System.err.println(e);
                        JOptionPane.showMessageDialog(null, "Articulo no encontrado...");
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

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_articulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_articulo_eliminar;
    private javax.swing.JLabel b_articulo_modifcar;
    private javax.swing.JLabel barra_mover4;
    private prueba_diseño.PanelRound cabecera;
    private javax.swing.JComboBox<String> cmb_departamento;
    private javax.swing.JComboBox<String> cmb_equipo;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JComboBox<String> cmb_nombre;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private prueba_diseño.PanelRound p_b_registro_articulo;
    private prueba_diseño.PanelRound p_eliminar_modificar_articulo;
    private prueba_diseño.PanelRound p_invetario_modificar_componentes;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound2;
    private prueba_diseño.PanelRound panelRound3;
    private prueba_diseño.PanelRound panelRound6;
    private prueba_diseño.PanelRound panelRound8;
    private javax.swing.JLabel salir;
    private javax.swing.JComboBox<String> t_annio;
    private javax.swing.JComboBox<String> t_dia;
    private javax.swing.JComboBox<String> t_mes;
    private javax.swing.JTextField txt_Nbien;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
