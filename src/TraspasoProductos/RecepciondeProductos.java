/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TraspasoProductos;

import ClasesDAO.accesoSistema;
import conexion.conex;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author desarrollo8
 */
public class RecepciondeProductos extends javax.swing.JInternalFrame {

    /**
     * Creates new form RecepciondeProductos
     */
    public RecepciondeProductos() {
        initComponents();
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
        txtqr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtcodigotraspaso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtobservacion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtproductos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtnoencontrados = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        txtqrguardar = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Recepción de Producto de Traspaso");

        jPanel1.setBackground(new java.awt.Color(248, 244, 244));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("CODIGO QR TRASPASO:");

        txtqr.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtqr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtqrKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono.png"))); // NOI18N
        jButton1.setText("Cargar QR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtcodigotraspaso.setEditable(false);
        txtcodigotraspaso.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        txtobservacion.setEditable(false);
        txtobservacion.setColumns(20);
        txtobservacion.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtobservacion.setRows(5);
        jScrollPane1.setViewportView(txtobservacion);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Código de traspaso:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Observación:");

        jtproductos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtproductos.getTableHeader().setReorderingAllowed(false) ;
        jtproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de Barras", "Producto", "Cantidad", "IdProd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtproductos.setRowHeight(25);
        jtproductos.getColumnModel().getColumn(3).setMaxWidth(0);
        jtproductos.getColumnModel().getColumn(3).setMinWidth(0);
        jtproductos.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        jtproductos.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        jScrollPane2.setViewportView(jtproductos);

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton2.setText("Aceptar Traspaso");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtnoencontrados.setColumns(20);
        txtnoencontrados.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtnoencontrados.setRows(5);
        jScrollPane3.setViewportView(txtnoencontrados);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Códigos de Barras no Encontrados:");

        txtusuario.setVisible(false);

        txtfecha.setVisible(false);

        txtqrguardar.setVisible(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(469, 469, 469)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcodigotraspaso, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(203, 203, 203)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtqr, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtqrguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtqr, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtqrguardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtcodigotraspaso, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:     
        //  T201702285114#ADMINISTRADOR DEL SISTEMA#2017-02-28 09:51:14.0#PRUEBAS DE TRASPASO#1-1!2-1!3-1!4-1!5-1!6-1!7-1!8-1!9-1!10-1!11-1!12-1!13-1!14-1!15-1!16-1!17-1!18-1!19-1!20-1!21-1!22-1!23-1!24-1!25-1!26-1!27-1!28-1!29-1!30-1!
        //  201702272131#ADMINISTRADOR DEL SISTEMA#2017-02-27 16:21:31.0#cva a cuautla#2-112!1-89!
        //  201702272131#ADMINISTRADOR DEL SISTEMA#2017-02-27 16:21:31.0#cva a cuautla#28562-112!1-89!
        
        if(!txtqr.getText().trim().equals("")){
                cargar_producto(txtqr.getText().trim());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtqrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqrKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!txtqr.getText().trim().equals("")){
                cargar_producto(txtqr.getText().trim());
            }
        }
    }//GEN-LAST:event_txtqrKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        boolean valida=existetraspaso(txtcodigotraspaso.getText().trim());
        if(valida==false){//no existe
            
            conex con=new conex();   
            ResultSet rsR = null;        
            String myQuery = "insert into to_traspasos_recepcion (codigovalidador,usuariotraspaso,observacion,fechagenerotraspaso,qr,fechacarga,usuariocargo) values('"+txtcodigotraspaso.getText().trim()+"','"+txtusuario.getText().trim()+"','"+txtobservacion.getText().trim()+"','"+txtfecha.getText().trim()+"','"+txtqrguardar.getText().trim()+"',now(),'"+accesoSistema.nombreuser+"')";
               //System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   int reg=st.executeUpdate(myQuery);   
                   if(reg==1){
                    for(int fila=0; fila<jtproductos.getRowCount(); fila++){   
                         String cant=jtproductos.getValueAt(fila, 2).toString().trim();
                         String idprod=jtproductos.getValueAt(fila, 3).toString().trim(); 
                         st.executeUpdate("insert into th_inventarios_registrados (id_producto,cantidad_agregada,fecha,usuario_ajusto,tipo_mov) values ('"+idprod+"','"+cant+"',now(),'"+accesoSistema.nombreuser+"','ENTRADA X TRASPASO')");   
                         st.executeUpdate("update tc_productos set existencia=existencia+"+cant+" where idproducto='"+idprod+"'");   
                    }
                   }
                   
                   
                   st.close();
                   con.desconectar();
                   txtcodigotraspaso.setText("");
                   txtusuario.setText("");
                   txtobservacion.setText("");
                   txtfecha.setText("");
                   txtqrguardar.setText("");
                   vaciartablaprod();
                   JOptionPane.showMessageDialog(null, "Se proceso correctamente los datos", "OK", JOptionPane.INFORMATION_MESSAGE);
               } catch (SQLException ex) {                         
                   JOptionPane.showMessageDialog(null, "Error al registrar los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               } 
            
        }else{ //ya existe
                   txtcodigotraspaso.setText("");
                   txtusuario.setText("");
                   txtobservacion.setText("");
                   txtfecha.setText("");
                   txtqrguardar.setText("");
                   vaciartablaprod();
            JOptionPane.showMessageDialog(null, "Este numero de traspaso ya fue procesado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtproductos;
    private javax.swing.JTextField txtcodigotraspaso;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextArea txtnoencontrados;
    private javax.swing.JTextArea txtobservacion;
    private javax.swing.JTextField txtqr;
    private javax.swing.JTextField txtqrguardar;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

public void cargar_producto(String datosqr){
        //obtenener datos partiendo de los delimitadores
        vaciartablaprod();
        txtnoencontrados.setText("");
        String delimiter = "#";
        String[] temp;
        temp = datosqr.split(delimiter);
        
        if(temp.length==5){  
            txtqrguardar.setText(datosqr);
            String nota=temp[0];
            System.out.println(nota);
            txtcodigotraspaso.setText(nota);
            String user=temp[1];
            txtusuario.setText(user);
            System.out.println(user);
            String fec=temp[2];
            txtfecha.setText(fec);
            System.out.println(fec);
            String obv=temp[3];
            System.out.println(obv);
            txtobservacion.setText(obv);
            String prodcanttotales=temp[4];
            System.out.println(prodcanttotales);

            String delimiter2 = "!";
            String[] temp2;
            temp2 = prodcanttotales.split(delimiter2);
            System.out.println("longitud: "+temp2.length);
            for(int i=0;i<temp2.length;i++){
                String prodcant=temp2[i];            
                //System.out.println(""+prodcant);

                //cortar cantidad y codigo de barras
                String delimiter3 = "-";
                String[] temp3;
                temp3 = prodcant.split(delimiter3);
                String codbar=temp3[0]; 
                String cantidad=temp3[1];
                
                String nombre=obtennomprod(codbar);
                String idprod=obtenidprod(codbar);
                if(!nombre.equals("")){
                    DefaultTableModel modelo=(DefaultTableModel) jtproductos.getModel();
                    modelo.addRow(new Object[]{codbar,nombre,cantidad,idprod});
                }else{//no existe el codigo de barras
                   txtnoencontrados.append(codbar+",");                
                }
                System.out.println("codbar: "+codbar);
                System.out.println("cantidad: "+cantidad);
                //fin cortar cadena de codigo de barras y cantidad            
            }  
            //fin de particionado
        }else{
            JOptionPane.showMessageDialog(null, "El codigo QR esta mal conformado favor de validarlo con el administrador.","Alerta",JOptionPane.ERROR_MESSAGE);
        }
        txtqr.setText("");
}



public String obtennomprod(String codbar){
String nombreprod="";
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select nombre_producto from tc_productos where estatus=1 and codigo_barras='"+codbar+"'";
               //System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {   
                       nombreprod=rsR.getString("nombre_producto");
                   }                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }    
return nombreprod;
}


public String obtenidprod(String codbar){
String nombreprod="";
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select idproducto from tc_productos where estatus=1 and codigo_barras='"+codbar+"'";
               //System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {   
                       nombreprod=rsR.getString("idproducto");
                   }                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }    
return nombreprod;
}

 public void vaciartablaprod(){
            DefaultTableModel modelo=(DefaultTableModel) jtproductos.getModel();         
            for (int i = 0; i < jtproductos.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    } 

 
 public boolean existetraspaso(String notatraspaso){
        boolean valida=false;
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select * from to_traspasos_recepcion where codigovalidador='"+notatraspaso+"'";
       //System.out.println(""+myQuery);
       try {
           Statement st = con.getConnection().createStatement();
           rsR = st.executeQuery(myQuery);
           while(rsR.next()) {   
               valida=true;
           }                   
           rsR.close(); 
           st.close();
           con.desconectar();
       } catch (SQLException ex) {                         
           JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
       }    
    return valida;
}
 
}