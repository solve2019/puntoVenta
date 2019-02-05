/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdialog;

import conexion.conex;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jinternalPanel.Cotizacion;

/**
 *
 * @author desarrollo8
 */
public class catalogo_productosCoti extends javax.swing.JDialog {

    /**
     * Creates new form catalogo_productos
     */
    public catalogo_productosCoti(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
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
        txtproducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtprod = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(251, 251, 251));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Teclee las primeras letras del producto, o una coincidencia del mismo.");

        txtproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtproductoKeyTyped(evt);
            }
        });

        jtprod.getTableHeader().setReorderingAllowed(false) ;
        jtprod.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtprod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Barras", "Descripción", "Precio", "Existencia", "Id"
            }
        ));
        jtprod.setRowHeight(18);
        jtprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtprodMouseClicked(evt);
            }
        });
        jtprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtprodKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtprod);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mas.png"))); // NOI18N
        jButton1.setText("Agregar Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addComponent(txtproducto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
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
        DefaultTableModel modelo=(DefaultTableModel) jtprod.getModel();  
          int fila=-1;
          fila=jtprod.getSelectedRow();
          if(fila!=-1){
            String codigobarras=jtprod.getValueAt(fila, 4).toString();            
            Cotizacion.cargar_productobusqueda(codigobarras);            
            dispose();
            
          }else{
            JOptionPane.showMessageDialog(null, "Seleccionar un producto de la tabla.","Alerta",JOptionPane.ERROR_MESSAGE);
          }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtprodMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {        
          DefaultTableModel modelo=(DefaultTableModel) jtprod.getModel();  
          int fila=-1;
          fila=jtprod.getSelectedRow();
          if(fila!=-1){
            String codigobarras=jtprod.getValueAt(fila, 4).toString();            
            Cotizacion.cargar_productobusqueda(codigobarras);            
            dispose();
            
          }else{
            JOptionPane.showMessageDialog(null, "Seleccionar un producto de la tabla.","Alerta",JOptionPane.ERROR_MESSAGE);
          }
        }
        
    }//GEN-LAST:event_jtprodMouseClicked

    private void txtproductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproductoKeyTyped
        // TODO add your handling code here:System.out.println("hola");
        
        cargatabla(txtproducto.getText().trim());
    }//GEN-LAST:event_txtproductoKeyTyped

    private void jtprodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtprodKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
          DefaultTableModel modelo=(DefaultTableModel) jtprod.getModel();  
          int fila=-1;
          fila=jtprod.getSelectedRow();
          if(fila!=-1){
            String codigobarras=jtprod.getValueAt(fila, 4).toString();            
            Cotizacion.cargar_productobusqueda(codigobarras);            
            dispose();
            
          }else{
            JOptionPane.showMessageDialog(null, "Seleccionar un producto de la tabla.","Alerta",JOptionPane.ERROR_MESSAGE);
          }
        }else{
        
        }
    }//GEN-LAST:event_jtprodKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
        Cotizacion.txtproductocoti.requestFocus();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Cotizacion.txtproductocoti.requestFocus();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(catalogo_productosCoti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(catalogo_productosCoti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(catalogo_productosCoti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(catalogo_productosCoti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                catalogo_productosCoti dialog = new catalogo_productosCoti(new javax.swing.JFrame(), true);
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

    public void cargatabla(String producto){
        vaciartabla();
        conex conlocal=new conex();                   
        ResultSet rs = null;
        DefaultTableModel modelo=(DefaultTableModel) jtprod.getModel();  
     
        try {
            Statement st = conlocal.getConnection().createStatement();
            String consul="select * from tc_productos where estatus=1 and nombre_producto like '%"+producto+"%'";
            System.out.println(""+consul);
            rs = st.executeQuery(consul);
            while(rs.next()) {                     
                modelo.addRow(new Object[]{""+rs.getString("codigo_barras"),""+rs.getString("nombre_producto"),""+rs.getString("precio_venta"),""+rs.getString("existencia"),""+rs.getString("idproducto")});
            }
            rs.close();
            conlocal.desconectar();
        } catch (SQLException ex) {
            
        }
        jtprod.getColumnModel().getColumn(4).setMaxWidth(0);
        jtprod.getColumnModel().getColumn(4).setMinWidth(0);
        jtprod.getColumnModel().getColumn(4).setPreferredWidth(0);
        jtprod.getColumnModel().getColumn(4).setWidth(0);
    }
    
    
    public void vaciartabla(){
        DefaultTableModel modelo=(DefaultTableModel) jtprod.getModel();         
        for (int i = 0; i < jtprod.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
        }    
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtprod;
    private javax.swing.JTextField txtproducto;
    // End of variables declaration//GEN-END:variables
}
