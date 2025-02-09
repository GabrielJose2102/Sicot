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
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author c.leal
 */
public class Crear_memorandum extends javax.swing.JFrame {

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

    public Crear_memorandum() {
        initComponents();
        setTitle("Memorandom");
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(1010, 720);

        int numero_memo =0;

        try {
            Connection cn2 = Conexion_sql.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "SELECT COUNT(codigo_memorandum) as num_memo FROM `memorandum`");
            ResultSet rs2 = pst2.executeQuery();

            while (rs2.next()) {
                numero_memo = rs2.getInt("num_memo");

            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }
        
        int suma_memo = numero_memo + 1;
        n_memo.setEditable(false);
        n_memo.setText("00" + suma_memo);
        
        
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
        barra_mover4 = new javax.swing.JLabel();
        p_toner = new prueba_diseño.PanelRound();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        p_registro_usurio_b_regitrar_u1 = new prueba_diseño.PanelRound();
        registrar2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelRound2 = new prueba_diseño.PanelRound();
        txt_receptor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        panelRound3 = new prueba_diseño.PanelRound();
        txt_concepto = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        panelRound4 = new prueba_diseño.PanelRound();
        txt_factura = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txt_para = new javax.swing.JTextArea();
        panelRound6 = new prueba_diseño.PanelRound();
        txt_asunto = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txt_de = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        panelRound7 = new prueba_diseño.PanelRound();
        txt_responsable = new javax.swing.JTextField();
        panelRound9 = new prueba_diseño.PanelRound();
        n_memo = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();

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
        panelRound8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 80, 60));

        jLabel2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Memorandum");
        panelRound8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 470, 100));

        panelRound5.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 970, 100));

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

        p_toner.setBackground(new java.awt.Color(0, 102, 102));
        p_toner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Descripción de Asunto");
        p_toner.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 200, -1));

        txt_descripcion.setColumns(20);
        txt_descripcion.setLineWrap(true);
        txt_descripcion.setRows(5);
        txt_descripcion.setAutoscrolls(false);
        jScrollPane5.setViewportView(txt_descripcion);

        p_toner.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 660, 130));

        p_registro_usurio_b_regitrar_u1.setBackground(new java.awt.Color(36, 22, 74));
        p_registro_usurio_b_regitrar_u1.setRoundBottomLeft(50);
        p_registro_usurio_b_regitrar_u1.setRoundBottomRight(50);
        p_registro_usurio_b_regitrar_u1.setRoundTopLeft(50);
        p_registro_usurio_b_regitrar_u1.setRoundTopRight(50);
        p_registro_usurio_b_regitrar_u1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrar2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        registrar2.setForeground(new java.awt.Color(255, 255, 255));
        registrar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrar2.setText("Generar Memo");
        registrar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrar2MouseClicked(evt);
            }
        });
        p_registro_usurio_b_regitrar_u1.add(registrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        p_toner.add(p_registro_usurio_b_regitrar_u1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 460, 180, 50));

        jLabel17.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Autor");
        p_toner.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 50, -1));

        jLabel14.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Dirigido");
        p_toner.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 160, -1));

        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_receptor.setBackground(new java.awt.Color(218, 215, 220));
        txt_receptor.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txt_receptor.setBorder(null);
        txt_receptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receptorActionPerformed(evt);
            }
        });
        panelRound2.add(txt_receptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        p_toner.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 180, 50));

        jLabel21.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Recerptor");
        p_toner.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 160, -1));

        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_concepto.setBackground(new java.awt.Color(218, 215, 220));
        txt_concepto.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txt_concepto.setBorder(null);
        txt_concepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_conceptoActionPerformed(evt);
            }
        });
        panelRound3.add(txt_concepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        p_toner.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 180, 50));

        jLabel22.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Concepto");
        p_toner.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 160, -1));

        jLabel23.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Factura");
        p_toner.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 160, -1));

        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_factura.setBackground(new java.awt.Color(218, 215, 220));
        txt_factura.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txt_factura.setBorder(null);
        txt_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_facturaActionPerformed(evt);
            }
        });
        panelRound4.add(txt_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        p_toner.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 180, 50));

        txt_para.setColumns(20);
        txt_para.setLineWrap(true);
        txt_para.setRows(5);
        txt_para.setAutoscrolls(false);
        jScrollPane6.setViewportView(txt_para);

        p_toner.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 500, 50));

        panelRound6.setRoundBottomLeft(50);
        panelRound6.setRoundBottomRight(50);
        panelRound6.setRoundTopLeft(50);
        panelRound6.setRoundTopRight(50);
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_asunto.setBackground(new java.awt.Color(218, 215, 220));
        txt_asunto.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txt_asunto.setBorder(null);
        txt_asunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_asuntoActionPerformed(evt);
            }
        });
        panelRound6.add(txt_asunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        p_toner.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 180, 50));

        jLabel24.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Asunto");
        p_toner.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 160, -1));

        txt_de.setColumns(20);
        txt_de.setLineWrap(true);
        txt_de.setRows(5);
        txt_de.setAutoscrolls(false);
        jScrollPane7.setViewportView(txt_de);

        p_toner.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 500, 50));

        jLabel25.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Resposable");
        p_toner.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 160, -1));

        panelRound7.setRoundBottomLeft(50);
        panelRound7.setRoundBottomRight(50);
        panelRound7.setRoundTopLeft(50);
        panelRound7.setRoundTopRight(50);
        panelRound7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_responsable.setBackground(new java.awt.Color(218, 215, 220));
        txt_responsable.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txt_responsable.setBorder(null);
        txt_responsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_responsableActionPerformed(evt);
            }
        });
        panelRound7.add(txt_responsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        p_toner.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 180, 50));

        panelRound9.setRoundBottomLeft(50);
        panelRound9.setRoundBottomRight(50);
        panelRound9.setRoundTopLeft(50);
        panelRound9.setRoundTopRight(50);
        panelRound9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        n_memo.setBackground(new java.awt.Color(218, 215, 220));
        n_memo.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        n_memo.setForeground(new java.awt.Color(0, 0, 0));
        n_memo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        n_memo.setBorder(null);
        n_memo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_memoActionPerformed(evt);
            }
        });
        panelRound9.add(n_memo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 160, 40));

        p_toner.add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 180, 50));

        jLabel26.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("N-Memorandum");
        p_toner.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 160, -1));

        getContentPane().add(p_toner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1100, 590));

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

    private void registrar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrar2MouseClicked

        String Fecha_creacion = annio + "-" + mes + "-" + dia;

        String para = txt_para.getText().trim();
        String de = txt_de.getText().trim();
        String responsable = txt_responsable.getText().trim();
        String receptor = txt_receptor.getText().trim();
        String numero = n_memo.getText().trim();

        String asunto = txt_asunto.getText().trim();
        String concepto = txt_concepto.getText().trim();
        String factura = txt_factura.getText().trim();
        String descripcion = txt_descripcion.getText().trim();

        String codigo = "EMSPA-OT" + "-" + numero + annio + "-" + mes + "-" + dia;

        Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + codigo + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/cintillo encabezado 2022.jpg");
            header.scaleToFit(650, 1200);
            header.setAlignment(Chunk.ALIGN_CENTER);

            com.itextpdf.text.Image header2 = com.itextpdf.text.Image.getInstance("src/imagenes/oficina.jpg");
            header2.scaleToFit(200, 200);
            header2.setAlignment(Chunk.ALIGN_LEFT);

//Servicio Tecnico
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_RIGHT);
            parrafo.add(codigo + "\n");
            parrafo.add("Barquisimeto, " + Fecha_creacion + "\n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(header2);
            documento.add(parrafo);

//Area de Atendida
            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.add("\n \n Memoramdum");
            parrafo2.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));

            documento.add(parrafo2);

//Descripcion            
            Paragraph parrafo3 = new Paragraph();
            parrafo3.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo3.add("\n Para:" + para + "");
            parrafo3.add("\n De:" + de + "");
            parrafo3.add("\n Fecha:" + Fecha_creacion + "");
            parrafo3.add("\n Asunto:" + asunto + "\n\n");
            parrafo3.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.add(parrafo3);

            Paragraph parrafo5 = new Paragraph();
            parrafo5.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo5.add(descripcion + "\n\n");
            parrafo5.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
            documento.add(parrafo5);

            Paragraph parrafo6 = new Paragraph();
            parrafo6.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo6.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            PdfPTable tabla6 = new PdfPTable(3);
            tabla6.addCell("Concepto:  ");
            tabla6.addCell("Factura:  ");
            tabla6.addCell("Fecha Correspondiente:  ");

            tabla6.addCell(concepto);
            tabla6.addCell(factura);
            tabla6.addCell(Fecha_creacion);

            documento.add(tabla6);

//Descripcion            
            Paragraph parrafo4 = new Paragraph();
            parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo4.add("\n \n Firmas \n \n");
            parrafo4.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.add(parrafo4);

            PdfPTable tabla4 = new PdfPTable(2);
            tabla4.addCell("Autor:  " + responsable);
            tabla4.addCell("Receptor:  " + receptor);

            tabla4.addCell("   ");
            tabla4.addCell("   ");

            documento.add(tabla4);

            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");

        } catch (DocumentException | IOException e) {
            System.err.println("Error en PDF o ruta de imagen" + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al administrador");
        }

        try {
            String agregar = "INSERT INTO memorandum values (?,?)";

            Connection cn2 = Conexion_sql.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(agregar);

            pst2.setString(1, null);
            pst2.setString(2, codigo);
            pst2.executeUpdate();
            cn2.close();

        } catch (Exception e) {
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
    }//GEN-LAST:event_registrar2MouseClicked

    private void txt_receptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receptorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receptorActionPerformed

    private void txt_conceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_conceptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_conceptoActionPerformed

    private void txt_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_facturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_facturaActionPerformed

    private void txt_asuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_asuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_asuntoActionPerformed

    private void txt_responsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_responsableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_responsableActionPerformed

    private void n_memoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_memoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_memoActionPerformed

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
            java.util.logging.Logger.getLogger(Crear_memorandum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_memorandum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_memorandum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_memorandum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Crear_memorandum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barra_mover4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField n_memo;
    private prueba_diseño.PanelRound p_registro_usurio_b_regitrar_u1;
    private prueba_diseño.PanelRound p_toner;
    private prueba_diseño.PanelRound panelRound2;
    private prueba_diseño.PanelRound panelRound3;
    private prueba_diseño.PanelRound panelRound4;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panelRound6;
    private prueba_diseño.PanelRound panelRound7;
    private prueba_diseño.PanelRound panelRound8;
    private prueba_diseño.PanelRound panelRound9;
    private javax.swing.JLabel registrar2;
    private javax.swing.JTextField txt_asunto;
    private javax.swing.JTextField txt_concepto;
    private javax.swing.JTextArea txt_de;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_factura;
    private javax.swing.JTextArea txt_para;
    private javax.swing.JTextField txt_receptor;
    private javax.swing.JTextField txt_responsable;
    // End of variables declaration//GEN-END:variables
}
