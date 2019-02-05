package ClasesDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ClasesDAO.*;
import conexion.conex;
import java.awt.print.PrinterJob;
import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;
import java.util.HashMap;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
/**
 *
 * @author desarrollo8
 */
public class TicketVenta {
    
    
    public void imprimirticket(String folio){
        System.out.println("imprimiendo fofofo");
		java.sql.Connection conn = null;		
 		String bd = conex.bd;   
 		String login = conex.login;   
 		String password = conex.password;  
 		String ip=conex.ip;
 		
 		
 		String url = "jdbc:mysql://"+ip+"/" + bd; 

 		try 
         {
 			
    		 Class.forName("com.mysql.jdbc.Driver");
 			conn = DriverManager.getConnection(url, login, password);
 			
          
         } 
         catch (ClassNotFoundException ex) 
         {
             ex.printStackTrace();
         } 
         catch (SQLException ex) 
         {
             ex.printStackTrace();
         }
		
 		
 		
 		
 		
		try
        {       
            String master = "reportes//ticket.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
          //  System.out.println("master" + master);
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo de la etiqueta maestro.");
                JOptionPane.showMessageDialog(null,"No se pudo imprimir el ticket, no esta el archivo jasper.","Mensaje",JOptionPane.PLAIN_MESSAGE);  
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e1) 
            {
                System.out.println("Error cargando el reporte maestro: " + e1.getMessage());
                JOptionPane.showMessageDialog(null,"No se pudo imprimir el ticket."+e1.getMessage(),"Mensaje",JOptionPane.PLAIN_MESSAGE);  
                
            }              
            
            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
 
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";
            
            
        String encabezado="",footer="";
	conex cn = new conex();
	String sql="SELECT parametro from to_parametros where clave='ENCABEZADO'";
	System.out.println(sql);
	PreparedStatement pstm100;
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
	    	
	    	encabezado=rs100.getString("parametro");	    		    			   
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	sql="SELECT parametro from to_parametros where clave='FOOTER'";
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
	    	
	    	footer=rs100.getString("parametro");	    		    			   
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
        String user="",fecha="",monto="",cambio="",iva="",grantotal="",descuento="", mesa="", pagocon="";
        sql="SELECT usuario_registro,fecha_movimiento,monto_total, (efectivo+tarjeta+no_puntos) as pagocon, ((efectivo+tarjeta+no_puntos)-(monto_total+iva)) as cambio,iva,(monto_total+iva) as total, descuento,mesa from to_folios where no_folio='"+folio+"'";
        System.out.println(""+sql);
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	user=rs100.getString("usuario_registro");
                fecha=rs100.getString("fecha_movimiento");
                monto=rs100.getString("monto_total");
                cambio=rs100.getString("cambio");
                iva=rs100.getString("iva");
                grantotal=rs100.getString("total");
                descuento=rs100.getString("descuento");
                mesa=rs100.getString("mesa");
                pagocon=rs100.getString("pagocon");
            }
            if(mesa==null){
            mesa="";
            }
            sql="select * from rest_mesas where IdMesa='"+mesa+"'";
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	mesa=rs100.getString("Nombre");
            }            
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        try {
            cn.desconectar();
        } catch (SQLException ex) {

        }
            
            
            
    		
    		
    		 
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
            java.util.Date date = new java.util.Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");            
            
            parametro.put("folio",folio);               
            parametro.put("encabezado", encabezado);
            parametro.put("footer", footer);
            parametro.put("user", user);
            parametro.put("fecha", fecha);
            
            parametro.put("subtotal", monto);
            parametro.put("descuento", descuento);
            parametro.put("total", grantotal);
            parametro.put("cambio",cambio );
            parametro.put("pagocon",pagocon );
            
            
            if(mesa.equals("")){
            }else{
                mesa="Mesa: "+mesa;
            }
            parametro.put("mesa",mesa );
                     
            

            
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //Para mandar a imprimir
            JasperPrintManager.printReport(jasperPrint, false);
            //JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            //jviewer.setTitle("Ticket venta");
            //jviewer.setVisible(true);	
            
            
            
            
            
            //INICIA IMPRESION EN IMPRESORA SELECCIONADA
            PrinterJob job = PrinterJob.getPrinterJob();        
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for (int i = 0; i < services.length; i++) {
               String printerName = "PDFCreator";
               String servicesPrinterName =  services[i].getName().toUpperCase();
               if (servicesPrinterName.equals(printerName)) {
                        /*If the service is named as what we are querying we select it */
                        selectedService = i;
               }
            }            
            
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            printRequestAttributeSet.add(new Copies(1));                            
            
            JRPrintServiceExporter exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
            exporter.exportReport();    
            //FIN IMPRESION DE IMPRESORA SELECCIONADA
            
            
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
	}
	
    
    public String tipoimpresion(){
        String tipo="";
        conex cn = new conex();
	String sql="SELECT parametro from to_parametros where clave='TIPOIMPRESION'";
	System.out.println(sql);
	PreparedStatement pstm100;
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	tipo=rs100.getString("parametro");	    		    			   
            }
	    rs100.close();
            cn.desconectar();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}		        
        return tipo;
    }
    
}
