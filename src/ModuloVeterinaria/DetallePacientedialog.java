/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloVeterinaria;

import ClasesDAO.accesoSistema;
import Utilerias.funciones;
import conexion.conex;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author desarrollo8
 */
public class DetallePacientedialog extends javax.swing.JDialog {
static String idpaciente="";
    /**
     * Creates new form DetallePacientedialog
     */
    public DetallePacientedialog(java.awt.Frame parent, boolean modal,String id) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); 
        idpaciente=id;
        Calendar c2 = new GregorianCalendar();
        txtfechaini.setCalendar(c2);
        
        cargartablaCITAS();
        cargartablacontrolmedico();
        cargartablaparasito();
        cargartablavacunas();
        cargartabla();
        jtpacientes.getColumnModel().getColumn(0).setMaxWidth(0);
        jtpacientes.getColumnModel().getColumn(0).setMinWidth(0);
        jtpacientes.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtpacientes.getColumnModel().getColumn(0).setWidth(0);
         
        try {
            String consulta="SELECT nombrepaciente,sexo,observaciones,color,fecha_nacimiento, timestampdiff(month,fecha_nacimiento,curdate()) as edad,telefono,referencia FROM tc_mascotas where Idmascota="+idpaciente;
            conex con=new conex();
            Statement st = con.getConnection().createStatement();
            ResultSet rs=st.executeQuery(consulta);   
            while (rs.next())
            {                       
                 txtpaciente.setText(rs.getString("nombrepaciente"));
                 txtsexo.setText(rs.getString("sexo"));
                 String edad="";
                 int meses=rs.getInt("edad");
                 int anio=0;
                 int mesesdividido=0;
                 if(meses>=12){ //tiene mas de un año
                     anio=meses/12;
                     mesesdividido=meses-(anio*12);
                     edad=anio+" año(s) "+mesesdividido+" meses";
                 }else{//tiene menos de un año
                     edad=meses+" meses";
                 }
                 txtedad.setText(edad);
                 txtfechanacio.setText(rs.getString("fecha_nacimiento"));
                 txtobservaciones.setText(rs.getString("observaciones"));
                 txtcolor.setText(rs.getString("color"));
                 txttel.setText(rs.getString("telefono"));
                 txtreferencia.setText(rs.getString("referencia"));
                 
            }
            
            consulta="select * from to_estetica where idrpaciente='"+idpaciente+"'";
            rs=st.executeQuery(consulta);   
            while (rs.next())
            {                       
                 txtultimavacuna.setText(rs.getString("fecha"));
                 txtultimaconsulta.setText(rs.getString("proxima_cita"));                 
                 txtobservacionesconsulta.setText(rs.getString("comentario"));                 
            }
            
            rs.close();
            st.close();
            con.desconectar();    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener la informacion del paciente "+ex, "Error sql", JOptionPane.ERROR_MESSAGE);
        }
        
        
        funciones obtenimagen=new funciones();
        Image foto=obtenimagen.obtenImagenes("SELECT imagen FROM tc_mascotas where Idmascota="+idpaciente);
        if(foto==null){
            jlfoto.setText("");
            jlfoto.setIcon(null);
            jPanel2.updateUI();
        }else{        
            ImageIcon icon = new ImageIcon(foto.getScaledInstance(jlfoto.getWidth(), jlfoto.getHeight(), Image.SCALE_DEFAULT));
            jlfoto.setText("");
            jlfoto.setIcon(icon);
            jPanel2.updateUI();
        }
        
        
         //oculta el primer panel
        jTabbedPane1.remove(jPanel3);
        jPanel3.updateUI();
        jPanel3.repaint();
        
        jTabbedPane1.remove(jPanel4);
        jPanel4.updateUI();
        jPanel4.repaint();
        
        jTabbedPane1.remove(jPanel5);
        jPanel5.updateUI();
        jPanel5.repaint();
        
        jTabbedPane1.remove(jPanel6);
        jPanel6.updateUI();
        jPanel6.repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextArea2 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jlfoto = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtpaciente = new javax.swing.JTextField();
        txtfechanacio = new javax.swing.JTextField();
        txtsexo = new javax.swing.JTextField();
        txtcolor = new javax.swing.JTextField();
        txtultimavacuna = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtultimaconsulta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtobservaciones = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtobservacionesconsulta = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txttel = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtreferencia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtcitas = new javax.swing.JTable();
        txtfechaini = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtobservacion = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtvacunas = new javax.swing.JTable();
        txtfechavacunas = new com.toedter.calendar.JDateChooser();
        txtlote = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtvacunas = new javax.swing.JTextField();
        txtfecharevacunacion = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtparasitos = new javax.swing.JTable();
        txtfechaparacitos = new com.toedter.calendar.JDateChooser();
        txtproducto = new javax.swing.JTextField();
        txtlaboratorio = new javax.swing.JTextField();
        txtcita = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtcontrolmedico = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtcontrol = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtpacientes = new javax.swing.JTable();
        jcestatus = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txtop = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Expediente");

        jPanel2.setBackground(new java.awt.Color(249, 248, 248));

        jlfoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true));

        jTabbedPane1.setBackground(new java.awt.Color(252, 252, 252));

        jPanel1.setBackground(new java.awt.Color(249, 248, 248));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 19)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Sucursal:");

        jLabel2.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha Registro:");

        jLabel3.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Servicio:");

        jLabel4.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contacto:");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Observaciones:");

        jLabel6.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ultimo Servicio:");

        txtpaciente.setEditable(false);
        txtpaciente.setBackground(new java.awt.Color(255, 102, 0));
        txtpaciente.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtpaciente.setForeground(new java.awt.Color(255, 255, 255));

        txtfechanacio.setEditable(false);
        txtfechanacio.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        txtsexo.setEditable(false);
        txtsexo.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        txtcolor.setEditable(false);
        txtcolor.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        txtultimavacuna.setEditable(false);
        txtultimavacuna.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tiempo del negocio:");

        txtedad.setEditable(false);
        txtedad.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Proximo Servicio:");

        txtultimaconsulta.setEditable(false);
        txtultimaconsulta.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Observ. Servicio:");

        txtobservaciones.setEditable(false);
        txtobservaciones.setColumns(20);
        txtobservaciones.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtobservaciones.setRows(5);
        jScrollPane2.setViewportView(txtobservaciones);

        jScrollPane4.setViewportView(jScrollPane2);

        txtobservacionesconsulta.setEditable(false);
        txtobservacionesconsulta.setColumns(20);
        txtobservacionesconsulta.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtobservacionesconsulta.setRows(5);
        jScrollPane9.setViewportView(txtobservacionesconsulta);

        jLabel14.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Telefono:");

        txttel.setEditable(false);
        txttel.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Ref. Domicilio:");

        txtreferencia.setEditable(false);
        txtreferencia.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtfechanacio, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtultimavacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 98, Short.MAX_VALUE))
                                    .addComponent(jScrollPane4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtultimaconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtreferencia))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtpaciente)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfechanacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtultimavacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtultimaconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos Generales", jPanel1);

        jPanel3.setBackground(new java.awt.Color(252, 252, 252));

        jLabel11.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Fecha Sig. Visita:");

        jLabel12.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Observaciones:");

        jtcitas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtcitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha Registro", "Observación", "Usuario Registro", "Proxima Visita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtcitas.setRowHeight(24);
        jScrollPane1.setViewportView(jtcitas);

        txtobservacion.setColumns(20);
        txtobservacion.setRows(5);
        jScrollPane3.setViewportView(txtobservacion);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtfechaini, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfechaini, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Servicio 1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(252, 252, 252));

        jtvacunas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtvacunas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Observacion", "Proxima Visita", "Usuario Registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtvacunas.setRowHeight(22);
        jScrollPane8.setViewportView(jtvacunas);

        txtfechavacunas.setVisible(false);

        txtlote.setVisible(false);
        txtlote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Observacion:");

        jLabel21.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Fecha Sig. Visita:");

        txtvacunas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtfechavacunas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtvacunas))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfecharevacunacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 88, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfechavacunas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtvacunas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtfecharevacunacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Servicio 2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(252, 252, 252));

        jLabel16.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Observacion:");

        jLabel17.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Prox. Visita:");

        jtparasitos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtparasitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Observacion", "Proxima Visita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtparasitos.setRowHeight(22);
        jScrollPane5.setViewportView(jtparasitos);

        txtfechaparacitos.setVisible(false);

        txtproducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtproducto.setVisible(false);

        txtlaboratorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfechaparacitos, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtlaboratorio)
                            .addComponent(txtcita, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtlaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcita, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtfechaparacitos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Servicio 3", jPanel5);

        jPanel6.setBackground(new java.awt.Color(252, 252, 252));

        jtcontrolmedico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtcontrolmedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Registro", "Observaciones", "Usuario Registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtcontrolmedico.setRowHeight(22);
        jScrollPane6.setViewportView(jtcontrolmedico);

        txtcontrol.setColumns(20);
        txtcontrol.setRows(5);
        jScrollPane7.setViewportView(txtcontrol);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 2, 19)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Observaciones:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(123, 123, 123))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Observaciones", jPanel6);

        jPanel8.setBackground(new java.awt.Color(251, 248, 248));

        jtpacientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtpacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Fecha Servicio", "Sucursal", "Orden de Servicio", "Evidencia en Campo", "Tel sucursal", "Comentario", "Forma Pago", "Monto", "Cliente", "Teléfono Cliente", "Persona Atendio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtpacientes.setRowHeight(28);
        jScrollPane10.setViewportView(jtpacientes);

        jcestatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODAS" }));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Estatus:");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excel.png"))); // NOI18N
        jButton9.setText("Exportar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(txtop, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcestatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Historico de Servicios", jPanel7);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Foto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
        String observacion=txtobservacion.getText().trim();
        Date fecha=txtfechaini.getDate();        
        if(fecha==null){
            JOptionPane.showMessageDialog(null, "Falta ingresar la fecha.", "Validacion campos", JOptionPane.ERROR_MESSAGE);
        }else if(observacion.equals("")){
            JOptionPane.showMessageDialog(null, "falta ingresar la observacion.", "Validacion campos", JOptionPane.ERROR_MESSAGE);
        }else{
            SimpleDateFormat fechaformateada = new SimpleDateFormat("yyyy-MM-dd");  
            String fechaformateadas=fechaformateada.format(fecha);
            
            conex con=new conex();  
            try {
                Statement st = con.getConnection().createStatement();
                String myQuery = "insert into veterinaria_consultas (proxima_cita,fecha_consulta,observaciones,fecha_registro,usuario_registro,idrpaciente) values('"+fechaformateadas+"',now(),'"+observacion+"',now(),'"+accesoSistema.nombreuser+"','"+idpaciente+"')";
                st.executeUpdate(myQuery);                                
                st.close();
                con.desconectar();  
                txtobservacion.setText("");    
                cargartablaCITAS();
                JOptionPane.showMessageDialog(null, "La cita se registro correctamente.", "OK", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {       
                JOptionPane.showMessageDialog(null, "Error al registrar la cita: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String controlmedico=txtcontrol.getText().trim();
        if(controlmedico.equals("")){
                JOptionPane.showMessageDialog(null, "Falta ingresar la descripcion del control medico.", "Validacion campos", JOptionPane.ERROR_MESSAGE);
        }else{
            conex con=new conex();  
            try {
                Statement st = con.getConnection().createStatement();
                String myQuery = "insert into veterinaria_to_controlmedico (descripcion,fecharegistro,usuario_registro,idrpaciente) values('"+controlmedico+"',now(),'"+accesoSistema.nombreuser+"','"+idpaciente+"')";
                st.executeUpdate(myQuery);                                
                st.close();
                con.desconectar();  
                txtcontrol.setText("");       
                cargartablacontrolmedico();
                JOptionPane.showMessageDialog(null, "El control medico se registro correctamente.", "OK", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {       
                JOptionPane.showMessageDialog(null, "Error al registrar la control medico: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String producto=txtproducto.getText().trim();
        String laboratorio=txtlaboratorio.getText().trim();        
        Date cita=txtcita.getDate();
             
        
        if(laboratorio.equals("")){
            JOptionPane.showMessageDialog(null, "falta ingresar la observacion.", "Validacion campos", JOptionPane.ERROR_MESSAGE);
        }else if(cita==null){
            JOptionPane.showMessageDialog(null, "falta seleccionar la fecha de siguiente visita.", "Validacion campos", JOptionPane.ERROR_MESSAGE);
        }else{
            SimpleDateFormat fechaformateada = new SimpleDateFormat("yyyy-MM-dd");              
            String fechaformateadascita=fechaformateada.format(cita);
            
            conex con=new conex();  
            try {
                Statement st = con.getConnection().createStatement();
                String myQuery = "insert into veterinaria_parasitos (producto,laboratorio,cita,fecha_registro,usuario_registro,idrpaciente) values('"+producto+"','"+laboratorio+"','"+fechaformateadascita+"',now(),'"+accesoSistema.nombreuser+"','"+idpaciente+"')";
                st.executeUpdate(myQuery);                                
                st.close();
                con.desconectar();  
                txtproducto.setText("");                
                txtlaboratorio.setText(""); 
                cargartablaparasito();
                JOptionPane.showMessageDialog(null, "El control de parasito se registro correctamente.", "OK", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {       
                JOptionPane.showMessageDialog(null, "Error al registrar el control de paracitos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String lote=txtlote.getText().trim();
        String vacuna=txtvacunas.getText().trim();
        Date fecha=txtfechavacunas.getDate();        
        Date fecharevacunacion=txtfecharevacunacion.getDate();        
        if(vacuna.equals("")){
            JOptionPane.showMessageDialog(null, "falta ingresar la observacion.", "Validacion campos", JOptionPane.ERROR_MESSAGE);
        }else if(fecharevacunacion==null){
            JOptionPane.showMessageDialog(null, "falta seleccionar la fecha de sig servicio.", "Validacion campos", JOptionPane.ERROR_MESSAGE);
        }else{
            SimpleDateFormat fechaformateada = new SimpleDateFormat("yyyy-MM-dd");              
            String fechaformateadasrevacunacion=fechaformateada.format(fecharevacunacion);
            
            conex con=new conex();  
            try {
                Statement st = con.getConnection().createStatement();
                String myQuery = "insert into veterinaria_to_vacunas (idrpaciente,lote,vacuna,revacunacion,fecha_registro,usuario_registro) values('"+idpaciente+"','"+lote+"','"+vacuna+"','"+fechaformateadasrevacunacion+"',now(),'"+accesoSistema.nombreuser+"')";
                System.out.println(""+myQuery);
                st.executeUpdate(myQuery);                                
                st.close();
                con.desconectar();  
                txtvacunas.setText("");    
                txtlote.setText("");    
                cargartablavacunas();
                JOptionPane.showMessageDialog(null, "La vacuna se registro correctamente.", "OK", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {       
                JOptionPane.showMessageDialog(null, "Error al registrar la vacuna: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        cargartabla();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        Date fecha1=new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy hh-MM-ss");
        //formateador.format(fecha1);
        System.out.println(formateador.format(fecha1));
        System.out.println(fecha1.toLocaleString());
        File archivo;

        javax.swing.JFileChooser jF1= new javax.swing.JFileChooser();
        String ruta = "";
        try{
            if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION){
                ruta = jF1.getSelectedFile().getAbsolutePath();
                //archivo = new File(ruta+""+formateador.format(fecha1)+".xls");
                archivo = new File(ruta+".xls");
                System.out.println(archivo);
                //Aqui ya tiens la ruta,,,ahora puedes crear un fichero n esa ruta y escribir lo k kieras...
                exportarjTable(jtpacientes,archivo);
                JOptionPane.showMessageDialog(null, "El reporte se ha generado con exito", "Mensaje", JOptionPane.DEFAULT_OPTION);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "No se ha podido generar el archivo:"+ex, "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(DetallePacientedialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallePacientedialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallePacientedialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallePacientedialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetallePacientedialog dialog = new DetallePacientedialog(new javax.swing.JFrame(), true,"");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private static javax.swing.JComboBox<String> jcestatus;
    private javax.swing.JLabel jlfoto;
    private javax.swing.JTable jtcitas;
    private javax.swing.JTable jtcontrolmedico;
    private static javax.swing.JTable jtpacientes;
    private javax.swing.JTable jtparasitos;
    private javax.swing.JTable jtvacunas;
    private com.toedter.calendar.JDateChooser txtcita;
    private javax.swing.JTextField txtcolor;
    private javax.swing.JTextArea txtcontrol;
    private javax.swing.JTextField txtedad;
    private com.toedter.calendar.JDateChooser txtfechaini;
    private javax.swing.JTextField txtfechanacio;
    private com.toedter.calendar.JDateChooser txtfechaparacitos;
    private com.toedter.calendar.JDateChooser txtfecharevacunacion;
    private com.toedter.calendar.JDateChooser txtfechavacunas;
    private javax.swing.JTextField txtlaboratorio;
    private javax.swing.JTextField txtlote;
    private javax.swing.JTextArea txtobservacion;
    private javax.swing.JTextArea txtobservaciones;
    private javax.swing.JTextArea txtobservacionesconsulta;
    private static javax.swing.JTextField txtop;
    private javax.swing.JTextField txtpaciente;
    private javax.swing.JTextField txtproducto;
    private javax.swing.JTextField txtreferencia;
    private javax.swing.JTextField txtsexo;
    private javax.swing.JTextField txttel;
    private javax.swing.JTextField txtultimaconsulta;
    private javax.swing.JTextField txtultimavacuna;
    private javax.swing.JTextField txtvacunas;
    // End of variables declaration//GEN-END:variables


    public void vaciartablaCITAS(){
            DefaultTableModel modelo=(DefaultTableModel) jtcitas.getModel();         
            for (int i = 0; i < jtcitas.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
    
public void cargartablaCITAS(){    
        vaciartablaCITAS();
        DefaultTableModel modelo=(DefaultTableModel) jtcitas.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select * from veterinaria_consultas where idrpaciente='"+idpaciente+"' order by fecha_consulta desc";
               //System.out.println(""+myQuery);
               int i=0;
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            if(i==0){
                                txtultimaconsulta.setText(rsR.getString("fecha_consulta"));
                                txtobservacionesconsulta.setText(rsR.getString("observaciones"));
                            }
                            i++;
                            modelo.addRow(new Object[]{rsR.getString("Id"),rsR.getString("fecha_consulta"),rsR.getString("observaciones"),rsR.getString("usuario_registro"),rsR.getString("proxima_cita")});                        
                   }                                      
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              
    }


public void vaciartablacontrolmedico(){
            DefaultTableModel modelo=(DefaultTableModel) jtcontrolmedico.getModel();         
            for (int i = 0; i < jtcontrolmedico.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
    
public void cargartablacontrolmedico(){    
        vaciartablacontrolmedico();
        DefaultTableModel modelo=(DefaultTableModel) jtcontrolmedico.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select * from veterinaria_to_controlmedico where idrpaciente='"+idpaciente+"' order by Idcontrol desc";
               //System.out.println(""+myQuery);               
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                                            
                            modelo.addRow(new Object[]{rsR.getString("fecharegistro"),rsR.getString("descripcion"),rsR.getString("usuario_registro")});                        
                   }                                      
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              
    }



public void vaciartablaparasito(){
            DefaultTableModel modelo=(DefaultTableModel) jtparasitos.getModel();         
            for (int i = 0; i < jtparasitos.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
    
public void cargartablaparasito(){    
        vaciartablaparasito();
        DefaultTableModel modelo=(DefaultTableModel) jtparasitos.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select * from veterinaria_parasitos where idrpaciente='"+idpaciente+"' order by IdParasito desc";
               //System.out.println(""+myQuery);               
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                                            
                            modelo.addRow(new Object[]{rsR.getString("fechacontrolparacito"),rsR.getString("laboratorio"),rsR.getString("cita"),rsR.getString("usuario_registro")});                        
                   }                                      
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {                         
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              
    }



public void vaciartablavacunas(){
            DefaultTableModel modelo=(DefaultTableModel) jtvacunas.getModel();         
            for (int i = 0; i < jtvacunas.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
    
public void cargartablavacunas(){    
        vaciartablavacunas();
        DefaultTableModel modelo=(DefaultTableModel) jtvacunas.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select * from veterinaria_to_vacunas where idrpaciente='"+idpaciente+"' order by Idvacunas desc";
               //System.out.println(""+myQuery);               
               int i=0;
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                                            
                            if(i==0){
                                txtultimavacuna.setText(rsR.getString("fecha")+"  "+rsR.getString("vacuna"));                                
                            }
                            i++;
                            modelo.addRow(new Object[]{rsR.getString("fecha"),rsR.getString("vacuna"),rsR.getString("revacunacion"),rsR.getString("usuario_registro")});                        
                   }                                      
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {                         
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              
    }



public static void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtpacientes.getModel();         
            for (int i = 0; i < jtpacientes.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
public static void cargartabla(){    
        String estatus=jcestatus.getSelectedItem().toString();
        String oservicio=txtop.getText().trim();
        String sqlaux="";
        if(!estatus.equals("TODAS")){
            sqlaux=" and to_estetica.estatus='"+estatus+"'";
        }
        if(!oservicio.equals("")){
            sqlaux=" and to_estetica.tipocorte like '%"+oservicio+"%'";
        }
        
        vaciartabla();
        DefaultTableModel modelo=(DefaultTableModel) jtpacientes.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select id,fecha,nombrepaciente,tipocorte,evidenciacampo,tratamiento,comentario,acuenta,efectivo,nombre_completo,tc_mascotas.telefono,persona_atendio,proxima_cita from to_estetica,tc_mascotas,tc_clientes where to_estetica.idrpaciente='"+idpaciente+"' and tc_clientes.idcliente=tc_mascotas.idrcliente and to_estetica.idrpaciente=tc_mascotas.Idmascota"+sqlaux+" order by id desc";
               System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("id"),rsR.getString("proxima_cita"),rsR.getString("nombrepaciente"),rsR.getString("tipocorte"),rsR.getString("evidenciacampo"),rsR.getString("tratamiento"),rsR.getString("comentario"),rsR.getString("acuenta"),rsR.getString("efectivo"),rsR.getString("nombre_completo"),rsR.getString("telefono"),rsR.getString("persona_atendio")});                        
                   }                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              
    }        



public void exportarjTable(JTable tabla, File ficheroXLS) throws IOException {
        TableModel modelo = tabla.getModel();
        FileWriter fichero = new FileWriter(ficheroXLS);
        
        for(int i=0; i < modelo.getColumnCount(); i++) {
            fichero.write(modelo.getColumnName(i) + "\t");
        }
        fichero.write("\n");
        for(int i=0; i< modelo.getRowCount(); i++) {
            for(int j=0; j < modelo.getColumnCount(); j++) {
                String dato="";
                if(modelo.getValueAt(i,j)==null){
                }else{    
                dato=modelo.getValueAt(i,j).toString();
                }
                fichero.write(dato+"\t");
            }
            fichero.write("\n");
        }
        fichero.close();
    }
}
