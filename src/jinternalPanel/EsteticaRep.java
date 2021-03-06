/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinternalPanel;

import ClasesDAO.accesoSistema;
import ModuloVeterinaria.EditarServicio;
import ModuloVeterinaria.ImprimirHojaServicio;
import conexion.conex;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author desarrollo8
 */
public class EsteticaRep extends javax.swing.JInternalFrame {
public static TableRowSorter<TableModel> sorter;
    /**
     * Creates new form Estetica
     */
    public EsteticaRep() {
        initComponents();
        Calendar c2 = new GregorianCalendar();
        txtfechaini.setCalendar(c2);
        txtfechafin.setCalendar(c2);
        
        
        
        
        cargartabla();
        jtpacientes.getColumnModel().getColumn(0).setMaxWidth(0);
        jtpacientes.getColumnModel().getColumn(0).setMinWidth(0);
        jtpacientes.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtpacientes.getColumnModel().getColumn(0).setWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmenuimpresion = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpacientes = new javax.swing.JTable();
        jcestatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtop = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtfechaini = new com.toedter.calendar.JDateChooser();
        txtfechafin = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jccategoria = new javax.swing.JComboBox<>();
        lbltotal = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jmenuimpresion.setText("Imprimir Hoja de Servicio");
        jmenuimpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuimpresionActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmenuimpresion);

        setTitle("Servicios programados");

        jPanel1.setBackground(new java.awt.Color(251, 248, 248));

        jtpacientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtpacientes.getTableHeader().setReorderingAllowed(false) ;
        jtpacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Fecha Servicio", "Sucursal", "Orden de Servicio", "Evidencia en Campo", "Tel sucursal", "Comentario", "Forma Pago", "Monto", "Cliente", "Teléfono Cliente", "Persona Atendio", "Categoria", "Tecnico Asignado", "Oficina", "Frecuencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtpacientes.setComponentPopupMenu(jPopupMenu1);
        jtpacientes.setRowHeight(28);
        jScrollPane1.setViewportView(jtpacientes);

        jcestatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ABIERTA", "CERRADA", "CANCELADA", "TODAS" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Estatus:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seg.png"))); // NOI18N
        jButton2.setText("FINALIZAR SERVICIO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edit.png"))); // NOI18N
        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Al");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Del");

        jccategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona..", "Comerciales", "Industriales", "Residenciales", "Gobierno" }));

        lbltotal.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbltotal.setText("0");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        jButton4.setText("CANCELAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtop, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfechaini, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jccategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcestatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtfechaini, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtfechafin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jccategoria, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargartabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int fila=-1;
            fila=jtpacientes.getSelectedRow();
            if(fila!=-1){
                String id=jtpacientes.getValueAt(jtpacientes.getSelectedRow(),0).toString();                   
                int dialogButton = JOptionPane.YES_NO_OPTION;
                dialogButton=JOptionPane.showConfirmDialog (null, " Desea finalizar el servicio?","Finalizar",dialogButton);
                if(dialogButton == JOptionPane.YES_OPTION){ //The ISSUE is here
                    System.out.println("Se ha hecho doble click");
                    conex con=new conex();                      
                    String myQuery = "update to_estetica set fecha_entrega=now(),usuarioentrego='"+accesoSistema.nombreuser+"',estatus='CERRADA' where Id="+id;
                    System.out.println(""+myQuery);
                    try {
                       Statement st = con.getConnection().createStatement();
                       st.executeUpdate(myQuery);                   
                       st.close();
                       con.desconectar();
                       txtop.setText("");
                       cargartabla();
                       
                    } catch (SQLException ex) {       
                       JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }                  
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione un servicio de la Tabla","Alerta",JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         int fila=-1;
            fila=jtpacientes.getSelectedRow();
            if(fila!=-1){
                String id=jtpacientes.getValueAt(jtpacientes.getSelectedRow(),0).toString();                   
                 Frame f = JOptionPane.getFrameForComponent(this);
                EditarServicio consultaprecio=new EditarServicio(f,true,id);
                consultaprecio.show();                                  
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione un servicio de la Tabla","Alerta",JOptionPane.ERROR_MESSAGE);
            }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jmenuimpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuimpresionActionPerformed
        // TODO add your handling code here:
        
             int fila=-1;
            fila=jtpacientes.getSelectedRow();
            if(fila!=-1){
                String id=jtpacientes.getValueAt(jtpacientes.getSelectedRow(),0).toString();                   
                 Frame f = JOptionPane.getFrameForComponent(this);
                ImprimirHojaServicio impresion=new ImprimirHojaServicio(f,true,id);
                impresion.show();                                  
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione un servicio de la Tabla","Alerta",JOptionPane.ERROR_MESSAGE);
            } 
        
        
    }//GEN-LAST:event_jmenuimpresionActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
            int fila=-1;
            fila=jtpacientes.getSelectedRow();
            if(fila!=-1){
                String id=jtpacientes.getValueAt(jtpacientes.getSelectedRow(),0).toString();                   
                int dialogButton = JOptionPane.YES_NO_OPTION;
                dialogButton=JOptionPane.showConfirmDialog (null, " Desea Cancelar el servicio?","Cancelar",dialogButton);
                if(dialogButton == JOptionPane.YES_OPTION){ //The ISSUE is here
                    System.out.println("Se ha hecho doble click");
                    conex con=new conex();                      
                    String myQuery = "update to_estetica set fecha_cancelo=now(),usuario_cancelo='"+accesoSistema.nombreuser+"',estatus='CANCELADA' where Id="+id;
                    System.out.println(""+myQuery);
                    try {
                       Statement st = con.getConnection().createStatement();
                       st.executeUpdate(myQuery);                   
                       st.close();
                       con.desconectar();
                       txtop.setText("");
                       cargartabla();
                       
                    } catch (SQLException ex) {       
                       JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }                  
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione un servicio de la Tabla","Alerta",JOptionPane.ERROR_MESSAGE);
            }
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JComboBox<String> jccategoria;
    private static javax.swing.JComboBox<String> jcestatus;
    private javax.swing.JMenuItem jmenuimpresion;
    private static javax.swing.JTable jtpacientes;
    private static javax.swing.JLabel lbltotal;
    private static com.toedter.calendar.JDateChooser txtfechafin;
    private static com.toedter.calendar.JDateChooser txtfechaini;
    private static javax.swing.JTextField txtop;
    // End of variables declaration//GEN-END:variables



public static void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtpacientes.getModel();         
            for (int i = 0; i < jtpacientes.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
public static void cargartabla(){ 
    
        
        Date fecha=txtfechaini.getDate();
        Date fecha2=txtfechafin.getDate();
        SimpleDateFormat fechaformateada = new SimpleDateFormat("yyyy-MM-dd");  
        String fechaini=fechaformateada.format(fecha);
        String fechafin=fechaformateada.format(fecha2);
        
        String categoria=jccategoria.getSelectedItem().toString();
        String estatus=jcestatus.getSelectedItem().toString();
        String oservicio=txtop.getText().trim();
        String sqlaux="";
        if(!estatus.equals("TODAS")){
            sqlaux=" and to_estetica.estatus='"+estatus+"'";
        }
        if(!oservicio.equals("")){
            sqlaux=sqlaux+" and (to_estetica.tipocorte like '%"+oservicio+"%' or tc_clientes.nombre_completo like '%"+oservicio+"%' or tc_mascotas.nombrepaciente like '%"+oservicio+"%' or to_estetica.oficina like '%"+oservicio+"%')";
        }
        if(categoria.equals("Selecciona..")){
        }else{
            sqlaux=sqlaux+" and categoria_sucursal='"+categoria+"'";
        }
        sqlaux=sqlaux+" and date(proxima_cita)>='"+fechaini+"' and date(proxima_cita)<='"+fechafin+"'";
        vaciartabla();
        DefaultTableModel modelo=(DefaultTableModel) jtpacientes.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select id,fecha,nombrepaciente,evidenciacampo,tipocorte,tratamiento,comentario,acuenta,efectivo,nombre_completo,tc_mascotas.telefono,persona_atendio,proxima_cita,hora_servicio,categoria_sucursal as categoria,tecnico_asignado,oficina,sexo from to_estetica,tc_mascotas,tc_clientes where tc_clientes.idcliente=tc_mascotas.idrcliente and to_estetica.idrpaciente=tc_mascotas.Idmascota"+sqlaux+" order by proxima_cita asc";
               System.out.println(""+myQuery);
               int i=0;
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("id"),rsR.getString("proxima_cita")+" "+rsR.getString("hora_servicio"),rsR.getString("nombrepaciente"),rsR.getString("tipocorte"),rsR.getString("evidenciacampo"),rsR.getString("tratamiento"),rsR.getString("comentario"),rsR.getString("acuenta"),rsR.getString("efectivo"),rsR.getString("nombre_completo"),rsR.getString("telefono"),rsR.getString("persona_atendio"),rsR.getString("categoria"),rsR.getString("tecnico_asignado"),rsR.getString("oficina"),rsR.getString("sexo")});                        
                            i++;
                   } 
                   lbltotal.setText("Total: "+i);
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               sorter = new TableRowSorter<TableModel>(modelo);
               jtpacientes.setRowSorter(sorter);         
              
    }        

}
