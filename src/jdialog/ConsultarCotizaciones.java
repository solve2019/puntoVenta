/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdialog;

import com.toedter.calendar.JDateChooser;
import conexion.conex;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import puntoventa.RemisionPDF;

/**
 *
 * @author JOSE
 */
public class ConsultarCotizaciones extends javax.swing.JDialog {

    private static TableRowSorter<TableModel> sorter;

    /**
     * Creates new form ConsultarCotizaciones
     */
    public ConsultarCotizaciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        cargartabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtcotizaciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Cotizaciones");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(250, 248, 248));

        jLabel1.setText("En este modulo puede buscar las cotizaciones generadas anteriormente.");

        jtcotizaciones.getTableHeader().setReorderingAllowed(false);
        jtcotizaciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtcotizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Fecha", "Monto", "Usuario Atendio", "Cliente", "Costo Envio", "Factura", "Fecha Pago", "Forma pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtcotizaciones.setRowHeight(22);
        jtcotizaciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtcotizaciones);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carrito.png"))); // NOI18N
        jButton1.setText("Abrir Cotización");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre del cliente:");

        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyReleased(evt);
            }
        });

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel4.setText("De:");

        jLabel5.setText("A:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("            Consulta por nombre                                                 o                                                Rango de fechas");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        jLabel3.setToolTipText("Actualiza la tabla");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inventario.png"))); // NOI18N
        jButton2.setText("Generar Factura");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConsultar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fechaInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6))
                    .addComponent(fechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int fila = -1;
        fila = jtcotizaciones.getSelectedRow();
        if (fila != -1) {
            String idcoti = jtcotizaciones.getValueAt(jtcotizaciones.getSelectedRow(), 0).toString();
            dispose();
            RemisionPDF pdfremi = new RemisionPDF();
            pdfremi.imprimircotizacion(idcoti);

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cotización de la Tabla", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombreClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteKeyReleased

    private void txtNombreClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyPressed
        filtar();
    }//GEN-LAST:event_txtNombreClienteKeyPressed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

        consultarFechas(fechaInicio, fechaFin);


    }//GEN-LAST:event_btnConsultarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        cargartabla();
        txtNombreCliente.setText("");
        fechaInicio.setDate(null);
        fechaFin.setDate(null);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int fila = -1;
        fila = jtcotizaciones.getSelectedRow();
        if (fila != -1) {
            String idcoti = jtcotizaciones.getValueAt(jtcotizaciones.getSelectedRow(), 0).toString();
            dispose();
            RemisionPDF pdfremi = new RemisionPDF();
            pdfremi.imprimirFactura(idcoti);

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cotización de la Tabla", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public static String obtenerFecha(JDateChooser fecha) {
        int dia = fecha.getCalendar().get(Calendar.DAY_OF_MONTH);
        int mes = fecha.getCalendar().get(Calendar.MONTH) + 1;
        int año = fecha.getCalendar().get(Calendar.YEAR);
        String mes1 = mes + "";
        String dia1 = dia + "";
        if (dia <= 9) {
            dia1 = "0" + dia;
        }
        if (mes <= 9) {
            mes1 = "0" + mes;
        }

        //prueba
        String diaMesSeleccionado = "";
        try {
            String formato = fecha.getDateFormatString();
            java.util.Date date = fecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            String fechaDelDia = String.valueOf(sdf.format(date));
            diaMesSeleccionado = fechaDelDia.substring(0, 2);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Al menos elija una FECHA DE NACIMIENTO VALIDA ", "Error..!!", JOptionPane.ERROR_MESSAGE);

        }

        //String fechaDia = diaMesSeleccionado + "-" + mes1 + "-" + año;
        String fechaDia = año + "-" + mes1 + "-" + diaMesSeleccionado;

        return fechaDia;
    }

    public void consultarFechas(JDateChooser fechaInicio, JDateChooser fechaFin) {

        if (fechaInicio.getDate() != null) {
            if (fechaFin.getDate() != null) {
                String fechaInicial = obtenerFecha(fechaInicio);
                String fechaFinal = obtenerFecha(fechaFin);
                String sql = "select * from to_cotizacion  where DATE(fecha)>=? and DATE(fecha)<=? and estatusFacturado='no'";
                conex con = new conex();
                try {
                    PreparedStatement ps = con.getConnection().prepareStatement(sql);
                    ps.setString(1, fechaInicial);
                    ps.setString(2, fechaFinal);
                    ResultSet rsR = ps.executeQuery();
                    vaciartabla();
                    DefaultTableModel modelo = (DefaultTableModel) jtcotizaciones.getModel();
                    while (rsR.next()) {
                        modelo.addRow(new Object[]{rsR.getString("id_cotizacion"), rsR.getString("fecha"),
                            rsR.getString("monto_total"), rsR.getString("usuario_registro"),
                            rsR.getString("cliente"), rsR.getString("costoEnvio"), rsR.getString("factura"),
                            rsR.getString("fechaPago"), rsR.getString("formaPago")});
                    }
                    sorter = new TableRowSorter<TableModel>(modelo);
                    jtcotizaciones.setRowSorter(sorter);
                } catch (Exception e) {
                    System.out.println("Error consultarFechas " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona una fecha final ");
                fechaFin.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha de inicio ");
            fechaInicio.requestFocus();
        }

    }

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
            java.util.logging.Logger.getLogger(ConsultarCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultarCotizaciones dialog = new ConsultarCotizaciones(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void filtar() {
        RowFilter<TableModel, Object> filtro = null;
        filtro = RowFilter.regexFilter(txtNombreCliente.getText().toString().toUpperCase(), 4);
        sorter.setRowFilter(filtro);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtcotizaciones;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables

    public void vaciartabla() {
        DefaultTableModel modelo = (DefaultTableModel) jtcotizaciones.getModel();
        for (int i = 0; i < jtcotizaciones.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void cargartabla() {
        vaciartabla();
        DefaultTableModel modelo = (DefaultTableModel) jtcotizaciones.getModel();
        conex con = new conex();
        ResultSet rsR = null;
        String myQuery = "select * from to_cotizacion where estatusFacturado='no' or estatusFacturado=''  order by id_cotizacion desc";
        //System.out.println(""+myQuery);
        try {
            Statement st = con.getConnection().createStatement();
            rsR = st.executeQuery(myQuery);
            while (rsR.next()) {

                modelo.addRow(new Object[]{rsR.getString("id_cotizacion"), rsR.getString("fecha"),
                    rsR.getString("monto_total"), rsR.getString("usuario_registro"),
                    rsR.getString("cliente"), rsR.getString("costoEnvio"), rsR.getString("factura"),
                    rsR.getString("fechaPago"), rsR.getString("formaPago")});
            }
            sorter = new TableRowSorter<TableModel>(modelo);
            jtcotizaciones.setRowSorter(sorter);
            rsR.close();
            st.close();
            con.desconectar();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
