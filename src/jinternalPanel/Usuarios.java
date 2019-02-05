/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinternalPanel;

import javax.swing.event.DocumentListener;
import ClasesDAO.accesoSistema;
import conexion.conex;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import jdialog.NuevoUsuario;
/**
 *
 * @author JOSE
 */
public class Usuarios extends javax.swing.JInternalFrame {
private static TableRowSorter<TableModel> sorter;
    /**
     * Creates new form Usuarios
     */
    public Usuarios() {
        initComponents();
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
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtusuarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setTitle("Catálogo de Usuarios");

        jPanel1.setBackground(new java.awt.Color(247, 246, 246));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Buscar en tabla:");

        txtBusqueda.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
        });

        jtusuarios.getTableHeader().setReorderingAllowed(false);
        jtusuarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtusuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Usuario", "Perfil", "Fecha Alta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtusuarios.setRowHeight(24);
        jtusuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtusuarios);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mas.png"))); // NOI18N
        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton3.setText("Resetear Contraseña");
        jButton3.setToolTipText("Resetea la contraseña y coloca \"solve\"");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
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

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed
        // TODO add your handling code here:
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrar();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrar();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrar();
            }
        });

    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int fila=-1;
            fila=jtusuarios.getSelectedRow();
            if(fila!=-1){
                int opc=JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?","Alerta",JOptionPane.INFORMATION_MESSAGE);
                if(opc==JOptionPane.OK_OPTION){
                    String id=jtusuarios.getValueAt(jtusuarios.getSelectedRow(),0).toString();
                    conex con=new conex();                                               
                    try {
                        String myQuery = "update tc_usuarios set estatus=0 where idusuario='"+id+"'";
                        Statement st = con.getConnection().createStatement();
                        st.executeUpdate(myQuery);
                        st.close();
                        con.desconectar();
                        cargartabla();
                        JOptionPane.showMessageDialog(null, "El usuarios se elimino correctamente. ", "Usuario eliminado", JOptionPane.PLAIN_MESSAGE);
                    } catch (SQLException ex) {       

                        JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }   
                    
                }
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione un usuario de la Tabla","Alerta",JOptionPane.ERROR_MESSAGE);
            }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Frame f = JOptionPane.getFrameForComponent(this);
        NuevoUsuario venta=new NuevoUsuario(f,true);
        venta.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int fila=-1;
            fila=jtusuarios.getSelectedRow();
            if(fila!=-1){
                int opc=JOptionPane.showConfirmDialog(null, "¿Estas seguro de resetear la contraseña?","Alerta",JOptionPane.INFORMATION_MESSAGE);
                if(opc==JOptionPane.OK_OPTION){
                    String id=jtusuarios.getValueAt(jtusuarios.getSelectedRow(),0).toString();
                    conex con=new conex();                                               
                    try {
                        String myQuery = "update tc_usuarios set password=MD5('solve') where idusuario='"+id+"'";
                        Statement st = con.getConnection().createStatement();
                        st.executeUpdate(myQuery);
                        st.close();
                        con.desconectar();                        
                        JOptionPane.showMessageDialog(null, "El usuarios se reseteo la contraseña por defecto 'solve'", "OK", JOptionPane.PLAIN_MESSAGE);
                    } catch (SQLException ex) {       

                        JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }   
                    
                }
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione un usuario de la Tabla","Alerta",JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public static void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtusuarios.getModel();         
            for (int i = 0; i < jtusuarios.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
    
public static void cargartabla(){    
        vaciartabla();
        DefaultTableModel modelo=(DefaultTableModel) jtusuarios.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select * from tc_usuarios where estatus=1";
               //System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("idusuario"),rsR.getString("nombre"),rsR.getString("usuario"),rsR.getString("perfil"),rsR.getString("fecha_alta")});                        
                   }
                   sorter = new TableRowSorter<TableModel>(modelo);
                   jtusuarios.setRowSorter(sorter);
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              
    }
    private void filtrar() {
        
         RowFilter<TableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter("(?i)"+txtBusqueda.getText(),1,2);
        }catch (java.util.regex.PatternSyntaxException e) {
        }
        sorter.setRowFilter(rf);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jtusuarios;
    private static javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
