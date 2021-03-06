/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puntoventa;

import ClasesDAO.accesoSistema;
import Utilerias.funciones;
import conexion.conex;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import ModuloVeterinaria.NotificacionesDiarias;
/**
 *
 * @author desarrollo8
 */
public class Login extends JFrame implements KeyListener{

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        String rutaicon="/images/icono.png";        
        String ruta=rutaicon;      
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource(ruta));
        setIconImage(icon);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        txtcontra = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Punto de Venta Colostomic v1");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Comenzar nuevo turno");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 290, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 270, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Por favor ingresa tu usuario y contraseña para");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 290, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("continuar.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 270, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel5.setText("Usuario:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 270, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 170, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 110, 30));

        txtusuario.addKeyListener(this);
        txtusuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtusuario.setToolTipText("El usuario por defecto es: admin");
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 290, -1));

        txtcontra.addKeyListener(this);
        txtcontra.setToolTipText("La contraseña por defecto es: ad");
        txtcontra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcontraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcontraKeyReleased(evt);
            }
        });
        jPanel1.add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 180, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja.gif"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 140, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        validaUsuario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtcontraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             //System.out.println("enter");
             validaUsuario();
        }
    }//GEN-LAST:event_txtcontraKeyPressed

    private void txtcontraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtcontraKeyReleased

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    public void validaUsuario(){
         String user=txtusuario.getText().trim();
        String pass=txtcontra.getText().trim();
        
        Pattern pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");  
        Pattern pat2 = Pattern.compile("[a-zA-Z0-9.-]{1,20}");  
        Matcher matuser = pat.matcher(user);
        Matcher matpass = pat2.matcher(pass);
        if(user.equals("")){
            txtusuario.requestFocus();
            JOptionPane.showMessageDialog(null, "Falta ingresar el usuario.", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else if(pass.equals("")){
            txtcontra.requestFocus();
            JOptionPane.showMessageDialog(null, "Falta ingresar la contraseña.", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else if(!matpass.matches()){
            JOptionPane.showMessageDialog(null, "La contraseña contiene caracteres invalido favor de revisar.", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else{
        
            accesoSistema acceso=new accesoSistema();
            boolean ingresasistema=acceso.validaAcceso(user, pass);
            if(ingresasistema){
                //Respaldo de BD AUTOMATICO
                funciones resp=new funciones();
                String ruta=resp.obtenruta();
                if(ruta.equals("")){                    
                }else{
                    resp.GenerarBackupMySQLSilencioso();
                }//FIN RESPALDO BD
                
                String cajaabierta=acceso.caja_abierta();
                if(cajaabierta.equals("NO")){
                    DineroCaja dinero=new DineroCaja();
                    dinero.setVisible(true);
                }else{
                    PantallaPrincipal ventas=new PantallaPrincipal();
                    ventas.setVisible(true);
                }                
                dispose();
                obtennocitas();                
            }else{
                txtusuario.requestFocus();
                txtusuario.setText("");
                txtcontra.setText("");
                JOptionPane.showMessageDialog(null, "El usuario no existe en el sistema.", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.VK_F5==e.getKeyCode())
    {
        ConfigurarIp conf=new ConfigurarIp();
        conf.setVisible(true);
    }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

/*
public String obtenruta(){
    String ruta="";
        conex con=new conex();          
        ResultSet rs = null;       
        String myQuery = "SELECT * FROM to_parametros WHERE clave='RUTARESPALDOBD'";
        System.out.println(""+myQuery);
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            while(rs.next()) {                
                    ruta=rs.getString("parametro");                              
            }
            rs.close(); 
            st.close();
            con.desconectar(); 
        } catch (SQLException ex) {
        }
return ruta;
} 


public void GenerarBackupMySQL(){   
            java.util.Date today = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");     
            String fecha = formatter.format(today);
            String ruta=obtenruta();
            try{
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File("RESPALDOSBD/punto_venta_"+fecha+".sql");
                FileWriter fw = new FileWriter(backupFile);
                //Process child = runtime.exec("C:\\AppServ\\MySQL\\bin\\mysqldump --opt --password=root --user=root1 --databases punto_venta");
                //ruta=ruta+"\\mysqldump --opt --password=root --user=root1 --databases punto_venta";
                ruta=ruta+"\\mysqldump --opt --password=root --user=root1 --databases punto_venta";
                System.out.println(""+ruta);
                Process child = runtime.exec(ruta);
                InputStreamReader irs = new InputStreamReader(child.getInputStream());
                BufferedReader br = new BufferedReader(irs);
                String line;
                while( (line=br.readLine()) != null ) {
                    fw.write(line + "\n");
                }
                fw.close();
                irs.close();
                br.close();
                //JOptionPane.showMessageDialog(null, "El respaldo se genero con exito","OK",JOptionPane. INFORMATION_MESSAGE);
            }catch(Exception e){
                System.out.println("error: "+e);
                //JOptionPane.showMessageDialog(null, "Error no se genero el respaldo por el siguiente motivo: "+e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
            }            
        
 }*/

    
  public void obtennocitas(){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date fechahoy = new Date();
    String date1=sdf.format(fechahoy);
    
     Calendar calendar = Calendar.getInstance();
     calendar.setTime(fechahoy); // Configuramos la fecha que se recibe	
     Date fechasig=new Date();
     calendar.add(Calendar.DAY_OF_YEAR, 8);  // numero de días a añadir, o restar en caso de días<0
     fechasig=calendar.getTime();
     String date2=sdf.format(fechasig);
     
     Calendar calendar2 = Calendar.getInstance();
     calendar2.setTime(fechahoy); // Configuramos la fecha que se recibe	
     Date fechasig2=new Date();
     calendar2.add(Calendar.DAY_OF_YEAR, 1);  // numero de días a añadir, o restar en caso de días<0
     fechasig2=calendar2.getTime();
     String date3=sdf.format(fechasig2);
     
    String ruta="";
        conex con=new conex();          
        ResultSet rs = null;       
        int total=0;
        String myQuery = "SELECT count(Idvacunas) as total FROM veterinaria_to_vacunas WHERE revacunacion>='"+date1+"' and revacunacion<='"+date2+"'";
        //System.out.println(""+myQuery);
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            while(rs.next()) {                
                    total=rs.getInt("total");                              
            }
            /*myQuery = "SELECT count(Id) as total FROM veterinaria_consultas WHERE proxima_cita>='"+date1+"' and proxima_cita<='"+date2+"'";
            rs = st.executeQuery(myQuery);
            while(rs.next()) {                
                    total=total+rs.getInt("total");                              
            }
            myQuery = "SELECT count(IdParasito) as total FROM veterinaria_parasitos WHERE cita>='"+date1+"' and cita<='"+date2+"'";
            rs = st.executeQuery(myQuery);
            while(rs.next()) {                
                    total=total+rs.getInt("total");                              
            }*/
            myQuery = "SELECT count(Id) as total FROM to_estetica WHERE proxima_cita>='"+date1+"' and proxima_cita<='"+date1+"'";
            //System.out.println(""+myQuery);
            rs = st.executeQuery(myQuery);
            while(rs.next()) {                
                    total=total+rs.getInt("total");                              
            }
            myQuery = "SELECT count(Id) as total FROM to_estetica WHERE sigservicio>='"+date3+"' and sigservicio<='"+date2+"'";
            rs = st.executeQuery(myQuery);
            //System.out.println(""+myQuery);
            while(rs.next()) {                
                    total=total+rs.getInt("total");                              
            }
            rs.close(); 
            st.close();
            con.desconectar(); 
        } catch (SQLException ex) {
        }
        if(total>0){           
            Icon icono = new ImageIcon(getClass().getResource("/images/mail.png"));
            int resp=JOptionPane.showConfirmDialog(null, "Tienes "+total+" Notificaciones ¿Deseas verlas?.", "Notificaciones del sistema",1,JOptionPane.INFORMATION_MESSAGE,icono);
            if (JOptionPane.OK_OPTION == resp){
                
                Frame f = JOptionPane.getFrameForComponent(this);
                NotificacionesDiarias notificaciones=new NotificacionesDiarias(f,true);
                notificaciones.show();
                
            }
            else{
                System.out.println("No selecciona una opción afirmativa");
            }
        }
}   
    
}
