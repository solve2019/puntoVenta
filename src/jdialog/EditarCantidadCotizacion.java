/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdialog;

import conexion.conex;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jinternalPanel.Cotizacion;


/**
 *
 * @author desarrollo8
 */
public class EditarCantidadCotizacion extends javax.swing.JDialog {
int fila;
String precios,ids;
String existencias;
    /**
     * Creates new form EditarCantidad
     */
    public EditarCantidadCotizacion(java.awt.Frame parent, boolean modal,int filas, String producto, String cantidad, String precio, String existencia,String descuento,String id) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        jlproducto.setText(producto);
        txtcantidadactual.setText(cantidad);
        fila=filas;
        precios=precio;
        existencias=existencia;
        ids=id;
        txtdescuento.setText(descuento);
        txtcantidadnueva.requestFocus();
        
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
        jlproducto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcantidadactual = new javax.swing.JTextField();
        txtcantidadnueva = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar Cantidad");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(249, 247, 247));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setText("Producto:");

        jlproducto.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jlproducto.setText("-");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("Cantidad Actual:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel4.setText("Cantidad Nueva:");

        txtcantidadactual.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtcantidadactual.setEnabled(false);
        txtcantidadactual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadactualKeyTyped(evt);
            }
        });

        txtcantidadnueva.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtcantidadnueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadnuevaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadnuevaKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setText("Descuento:");

        txtdescuento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtdescuento.setText("0");
        txtdescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescuentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescuentoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel6.setText("%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcantidadactual, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcantidadnueva))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlproducto))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcantidadactual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcantidadnueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void txtcantidadactualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadactualKeyTyped
        // TODO add your handling code here:
        
        
        if(txtcantidadactual.getText().trim().length()>=4){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9'))){
               evt.consume(); // ignorar el evento de teclado
            }
        }
        
    }//GEN-LAST:event_txtcantidadactualKeyTyped

    private void txtcantidadnuevaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadnuevaKeyTyped
        // TODO add your handling code here:
        if(txtcantidadnueva.getText().trim().length()>=3){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9'))){
               evt.consume(); // ignorar el evento de teclado
            }
        }
    }//GEN-LAST:event_txtcantidadnuevaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       cargarcantidad();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
         Cotizacion.txtproductocoti.requestFocus();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         Cotizacion.txtproductocoti.requestFocus();
    }//GEN-LAST:event_formWindowClosing

    private void txtcantidadnuevaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadnuevaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            cargarcantidad();
         }            
    }//GEN-LAST:event_txtcantidadnuevaKeyPressed

    private void txtdescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescuentoKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            txtcantidadnueva.requestFocus();
         }   
    }//GEN-LAST:event_txtdescuentoKeyPressed

    private void txtdescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescuentoKeyTyped
        // TODO add your handling code here:
        
        if(txtdescuento.getText().trim().length()>=2){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9'))){
               evt.consume(); // ignorar el evento de teclado
            }
        }
        
    }//GEN-LAST:event_txtdescuentoKeyTyped

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
            java.util.logging.Logger.getLogger(EditarCantidadCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCantidadCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCantidadCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCantidadCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarCantidadCotizacion dialog = new EditarCantidadCotizacion(new javax.swing.JFrame(), true,1,"","","","","","");
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

    public void cargarcantidad(){
        String cantidadanterior=txtcantidadactual.getText().trim();
        String cantidadnueva=txtcantidadnueva.getText().trim();
        String descuento=txtdescuento.getText().trim();
        if(descuento.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de descuento no debe ir vacio.", "Alerta", JOptionPane.ERROR_MESSAGE);        
        }else if(cantidadnueva.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de cantidad no debe ir vacio.", "Alerta", JOptionPane.ERROR_MESSAGE);        
        }else{
            int cantinueva=Integer.parseInt(cantidadnueva);
            int cantiantes=Integer.parseInt(cantidadanterior);
            float preci=Float.parseFloat(precios);
            
            float descuen=Float.parseFloat(descuento);
            
            
        int cantidad_minimamayoreo=0;
        float preciomayoreo=0,precionormal=0;
        
        conex con=new conex();          
        ResultSet rs = null;       
        String myQuery = "SELECT * FROM tc_productos where idproducto='"+ids+"'";        
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);            
            while(rs.next()) {                     
                cantidad_minimamayoreo=rs.getInt("cantidad_mayoreo");
                preciomayoreo=rs.getFloat("precio_mayoreo");
                precionormal=rs.getFloat("precio_venta");
            }
            rs.close(); 
            st.close();
            con.desconectar();                
        } catch (SQLException ex) {
        }
            
            
            if(cantinueva>=cantidad_minimamayoreo){
                preci=preciomayoreo;
            }else{
                preci=precionormal;
            }
            
            
            float total=preci*(cantinueva);//nuevo precio de la venta     
            
            total=total-((total*descuen)/100);
            
            int existen=Integer.parseInt(existencias)-cantinueva; //se recalcula la existencia
            
            Cotizacion.jtproductoscoti.setValueAt(preci+"", fila, 2);
            Cotizacion.jtproductoscoti.setValueAt(cantidadnueva, fila, 3);
            Cotizacion.jtproductoscoti.setValueAt(total+"", fila, 4);
            Cotizacion.jtproductoscoti.setValueAt(existen+"", fila, 5);            
            Cotizacion.jtproductoscoti.setValueAt(descuento+"", fila, 7);            
            
            Cotizacion.cargar_informacion();            
            //JOptionPane.showMessageDialog(null, "Se modifico la cantidad correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);                   
            dispose();
            Cotizacion.txtproductocoti.requestFocus();
        }        
    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlproducto;
    private javax.swing.JTextField txtcantidadactual;
    private javax.swing.JTextField txtcantidadnueva;
    private javax.swing.JTextField txtdescuento;
    // End of variables declaration//GEN-END:variables


    
}
