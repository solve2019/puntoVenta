/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package administracionFacturas;



import ClasesDAO.Ticket;
import Utilerias.funciones;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import conexion.conex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;




/**
 *
 * @author JOSE ANTUNEZ ROGEL
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class GenerarFactura {
    
    private static final long serialVersionUID = 1L;
 
    public GenerarFactura() {
        // TODO Auto-generated constructor stub
        
    }
    
   
    
            public String GenerarFacturaCliente(int numeroEmp,int numeroFac, int serieFac, int band,String patharchivos,String correo,String cliente,String tipopagocliente) throws IOException{
            String noEmpresa="", rfcEmisor_="", rfcReceptor_="", totalAmout="";
            String valorRetornado="";
            noEmpresa=""+numeroEmp;
            String cadena_lineal="", sello="", certificado="", noCertificado="", fechaGenera="", noFactura="", noCuenta="", metodoPago="", 
            formaPago="", folio="";
            String codigobarras="";
            String clave_privada="";
            float costotarjeta=0;
            // ### INICIA GENERACION DE CADENA LINEAL CON DATOS DE FACTURACION              GENERACION DE CADENA LINEAL 
            String desgloseServ="", fechaGeneracion="", rfcReceptor="", calle="", pais="", descEmpresa="";
            double montoTotal=0, SubTotal=0,descuento=0;
            DecimalFormat df = new DecimalFormat("0.00"); 
            cadena_lineal="||3.2|";
            

            //INICIA AQUI SE REALIZA DE REASIGNACION DE MONTO A LA NUEVA FACTURA QUE SERA GENERADA DESDE LA REMISION
            conex conn;
            conn = new conex();
            PreparedStatement pstm;
            PreparedStatement pstm1;

            //TERMINA AQUI SE REALIZA DE REASIGNACION DE MONTO A LA NUEVA FACTURA QUE SERA GENERADA DESDE LA REMISION

          // ### TERMINA GENERACIÓN DE CADENA LINEAL CON DATOS DE FACTURACION             GENERACION DE CADENA LINEAL
            try
              {
                  File archivo=new File(patharchivos+"cadenalineal.txt");
                  FileWriter escribir=new FileWriter(archivo,true);
                   
                   double subtotalwe=0,ivasss=0,descuentoss=0,desc=0;
                   double subtotalcondescuento=0;
                   String ieps="";
                  try {
                   double totaldesc=1.0;
                   funciones utileria=new funciones();
                   double paramiva=utileria.obteniva();
                   totaldesc=totaldesc+paramiva;
                           
                   pstm = (PreparedStatement) conn.getConnection().prepareStatement("select FechaGeneracion, Monto,factura,noCuenta,MetodoPago,FormaPagos,subtotal,iva, (descuento/"+totaldesc+") as descuento,ieps from to_facturas where factura="+numeroFac);
                   ResultSet rs = (ResultSet) pstm.executeQuery();
                      while (rs.next()) {
                          fechaGeneracion=rs.getString("FechaGeneracion");
                          montoTotal=rs.getFloat("Monto");
                          descuento=0;
                          folio=rs.getString("factura");
                          noCuenta=rs.getString("noCuenta");
                          metodoPago=rs.getString("MetodoPago");
                          formaPago=rs.getString("FormaPagos");
                          
                          descuentoss=rs.getDouble("descuento");                          
                          descuentoss=redondearDecimales(descuentoss, 2);
                          subtotalwe=rs.getDouble("subtotal")-descuentoss;
                          subtotalcondescuento=rs.getDouble("subtotal");
                          ieps=rs.getString("ieps");
                          SubTotal=subtotalwe;                          
                          }
                          rs.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  metodoPago=tipopagocliente;
                  noFactura=folio;
                  if(noCuenta.equals("")){
                      noCuenta="0000";
                  }

                  try {  
                        pstm = (PreparedStatement) conn.getConnection().prepareStatement("select * from tc_clientes where idcliente='"+noEmpresa+"'");
                        ResultSet rs = (ResultSet) pstm.executeQuery();
                        while (rs.next()) {
                            rfcReceptor=rs.getString("rfc");
                            calle=rs.getString("calle");
                            pais=rs.getString("pais");
                            descEmpresa=rs.getString("razon_social");
                        }
                        rs.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                  StringTokenizer tokens = new StringTokenizer(fechaGeneracion," ");
                  String ano="", mes="";
                  while(tokens.hasMoreTokens()){
                    ano=tokens.nextToken();
                    mes=tokens.nextToken();
                  }
                  
                  StringTokenizer tokens2 = new StringTokenizer(mes,".");
                  String hora="", basura="";
                  while(tokens2.hasMoreTokens()){
                    hora=tokens2.nextToken();
                    basura=tokens2.nextToken();
                  }
                  String id=null;   
                  funciones utileria=new funciones();
                  double paramiva=utileria.obteniva();
                  String subtotalparseado=df.format(subtotalcondescuento);
                  subtotalparseado = subtotalparseado.replace(",",".");
                  //String totalparseado=df.format((SubTotal+(SubTotal*.16)));
                  String totalparseado=df.format((SubTotal+(SubTotal*paramiva)+Float.parseFloat(ieps)));
                  totalparseado = totalparseado.replace(",",".");
                  //String ivaparseado=(df.format(SubTotal*.16));
                  String ivaparseado=(df.format(SubTotal*paramiva));
                  ivaparseado = ivaparseado.replace(",",".");
		  if ( band==2 ){
                    System.out.println("Consultar VENTA DE ARTICULOS");
                    System.out.println("select idproducto, to_ventas.cantidad, precio, to_ventas.cantidad*to_ventas.precio as total, no_folio, tarjeta from to_ventas,to_folios,to_facturas where to_folios.no_folio=to_ventas.folio and to_facturas.folio=to_folios.no_folio and factura='"+numeroFac+"'");
                    try {                     
                     pstm = (PreparedStatement) conn.getConnection().prepareStatement("select idproducto, to_ventas.cantidad, precio, to_ventas.cantidad*to_ventas.precio as total, no_folio, tarjeta from to_ventas,to_folios,to_facturas where to_folios.no_folio=to_ventas.folio and to_facturas.folio=to_folios.no_folio and factura='"+numeroFac+"'");
                     ResultSet rs = (ResultSet) pstm.executeQuery();
                        while (rs.next()) {                          
                          String costocliente=df.format(rs.getDouble("total"));
                          String preciounitario=df.format(rs.getDouble("precio"));
                          costocliente=costocliente.replace(",", ".");                          
                          preciounitario=preciounitario.replace(",", ".");                          
                          desgloseServ=desgloseServ+rs.getString("cantidad")+"|CANT|PZA|"+preciounitario+"|"+costocliente+"|";                          
                          codigobarras=rs.getString("no_folio");
                          costotarjeta=rs.getFloat("tarjeta");
                        }
                            rs.close();
                    } catch (SQLException ex) {                        
                        System.out.println(ex);
                    }
                    
                          //desgloseServ=desgloseServ+"1|CANT|PZA|"+subtotalparseado+"|"+subtotalparseado+"|";
                          //SubTotal=SubTotal; 
                       
                  }
                  SubTotal=SubTotal-descuento;
                  totalAmout=""+(SubTotal); //se agrego la resta del descuento para el calculo del iva
                  
                  
                  String razonsocialemisor="", paisemisor="",cpemisor="",lugarexpedicionemisor="",estadoemisor="",ciudademisor="",coloniaemisor="",calleemisor="";
                  String ivaemisor="";
                  try {                     
                     pstm = (PreparedStatement) conn.getConnection().prepareStatement("select * from to_datos_facturacion where id_datos=1");
                     ResultSet rs = (ResultSet) pstm.executeQuery();
                        while (rs.next()) {                                                    
                            clave_privada = rs.getString("clave_privada").trim();        
                            rfcEmisor_=rs.getString("rfc").trim();
                            noCertificado=rs.getString("nocertificado").trim();
                            razonsocialemisor=rs.getString("razonsocial").trim();
                            paisemisor=rs.getString("pais").trim();
                            cpemisor=rs.getString("cp").trim();
                            lugarexpedicionemisor=rs.getString("lugarexpedicion").trim();
                            estadoemisor=rs.getString("estado").trim();
                            ciudademisor=rs.getString("ciudad").trim();
                            coloniaemisor=rs.getString("colonia").trim();
                            calleemisor=rs.getString("calle").trim();                                                        
                            ivaemisor=rs.getString("iva").trim();                                                        
                        }
                        rs.close();
                    } catch (SQLException ex) {                        
                        System.out.println(ex);
                    }
                  
                  System.out.println("ciudademisor:   "+ciudademisor);
                  
                  //rfcEmisor_="KSL140218398";
                  //rfcEmisor_="SARJ740708R22";
                  rfcReceptor_=rfcReceptor;
                  String descu="";
                  descu=descuentoss+"";
                  System.out.println("DESCUENTOS: "+descu);
                  
                  descu=descuentoss+"";
                  descu = descu.replace(".",",");
                  String de[]=descu.split(",");
                  String unidad=de[0]+"";//obtengo las unidades
                  String decimales=de[1]+"";//obtengo decimales
                  System.out.println("DESCUN"+decimales);
                  if(decimales.length()==1){
                      decimales=decimales+"0";
                  }
                  descu=unidad+"."+decimales;
                  
                  
                  ieps=ieps;
                  System.out.println("ieps: "+ieps);
                  /*String decs[]=ieps.split(".");
                  String unidad2=decs[0]+"";//obtengo las unidades
                  String decimales2=decs[1]+"";//obtengo decimales
                  System.out.println("DESCUN"+decimales2);
                  if(decimales2.length()==1){
                      decimales2=decimales2+"0";
                  }
                  ieps=unidad2+"."+decimales2;*/
                   System.out.println("ieps: "+ieps);
                   
                   double tasaieps=subtotalcondescuento-Float.parseFloat(ieps);
                    double tas=tasaieps/subtotalcondescuento;
                    tas=redondearDecimales(tas,2);
                    tasaieps=1-tas;
                    tasaieps=redondearDecimales(tasaieps,2);
                    tasaieps=tasaieps*100;
                    String tasasaieps=tasaieps+"";
                    tasasaieps= tasasaieps.replace(".",",");
                    String ivass[]=tasasaieps.split(",");
                    String unidad3=ivass[0]+"";//obtengo las unidades
                    String decimales3=ivass[1]+"";//obtengo decimales
                    System.out.println("subtotal parseado a decimales"+decimales3);
                    if(decimales3.length()==1){
                        decimales3=decimales3+"0";
                    }
                     tasasaieps=unidad3+"."+decimales3; 
                   
                   
                  //desgloseServ=desgloseServ+"IVA|"+ivaemisor+"|"+ivaparseado+"||";
                  desgloseServ=desgloseServ+"IVA|"+ivaemisor+"|"+ivaparseado+"|IEPS|"+tasasaieps+"|"+ieps+"||";
                  System.out.println(desgloseServ);
                  cadena_lineal=cadena_lineal+ano+"T"+hora+"|ingreso|"+formaPago.trim()+"|"+(subtotalparseado)+"|"+descu+"|"+(totalparseado)
                          +"|"+metodoPago.trim()+"|"+lugarexpedicionemisor+"|"+noCuenta+"|"+rfcEmisor_+"|"+razonsocialemisor+"|"+calleemisor+"|"+coloniaemisor+"|"+ciudademisor+"|"+estadoemisor+""+
                          "|"+paisemisor+"|"+cpemisor+"|PERSONA MORAL|"+rfcReceptor.trim()+"|"+descEmpresa.trim()+"|"+calle.trim()+"|"+pais.trim()+"|";

                  cadena_lineal=cadena_lineal+desgloseServ;
                  fechaGenera=ano+"T"+hora;
                  //Escribimos en el archivo con el metodo write 
                  escribir.write(cadena_lineal);
                  //Cerramos la conexion
                  escribir.close();
                  System.out.println("cadena_lineales: "+cadena_lineal);
              }catch(Exception e)
              {
                  //Si existe un problema al escribir cae aqui
                  System.out.println("Exception: "+e);
              }
          // ### TERMINA GENERACIÓN DE CADENA LINEAL CON DATOS DE FACTURACION             GENERACION DE CADENA LINEAL

                System.out.println("inicia facturacion");
          // ### INICIA GENERACION DE SELLO DIGITAL Y CERTIFICADO APARTIR DE ARCHIVOS     SELLO DIGITAL Y CERTIFICADO
                  Facturacion obj = new Facturacion();
                  String cadena_original="", cert_publico="", origen_cer="";

                  //  cadena_original Cadena original.
                  //  clave_privada Clave privada.
                  //  cert_publico Ruta a la llave publica. (key file).
                  cadena_original = cadena_lineal;
                  //clave_privada = "Sell0k0Nn3n2014";                  
                  //clave_privada = "Mileni29";              //salazar7407    
                  //cert_publico = patharchivos+"CSD_Empresa\\CSD_SUCURSAL_KSL140218398_20140705_102913.key"; //ruta de archivos para desarrollo                  
                  cert_publico = patharchivos+"CSD_Empresa\\llave.key"; //ruta de archivos para desarrollo                  
                  //noCertificado = "00001000000304609708"; //CERTIFICADO DE KONNEN
                  //noCertificado = "00001000000202545310"; //CERTYIFICADO DE JOSE ANTUNEZ

                  sello = obj.getSelloDigital(cadena_original, clave_privada, cert_publico); 
                  //origen_cer = patharchivos+"CSD_Empresa\\00001000000304609708.cer"; //ruta para archivos de desarrollo                                    
                  origen_cer = patharchivos+"CSD_Empresa\\certificado.cer"; //ruta para archivos de desarrollo                                    
                  certificado = obj.getCertificado(origen_cer);
                  
                  System.out.println("Cadena original: "+cadena_original);
                  System.out.println("Sello: "+sello);
                  System.out.println("Certificado: "+certificado);
                  
          // ### TERMINA GENERACIÓN DE SELLO DIGITAL Y CERTIFICADO APARTIR DE ARCHIVOS    SELLO DIGITAL Y CERTIFICADO

          // ### INICIA GENERAR CFDI TIMBRADO                                             GENERAR CFDI TIMBRADO
                  GenerarCFDI obj_ = new GenerarCFDI();
                  System.out.println("Inicia generar CFDI Timbrado...");
                  
                  if ( band==1 ){
                      //valorRetornado = obj_.ConstruyeCFDI(sello, certificado, noCertificado, fechaGenera, noFactura, noEmpresa, noCuenta, metodoPago, formaPago, 1);
                  }else if ( band==2 ){
                      valorRetornado = obj_.ConstruyeCFDI(sello, certificado, noCertificado, fechaGenera, noFactura, noEmpresa, noCuenta, metodoPago, formaPago, 2,patharchivos,correo);
                  }
                  
                 
          // ### TERMINA GENERAR CFDI TIMBRADO                                            GENERAR CFDI TIMBRADO
                  
                
                  if(valorRetornado.equals("")){
                      valorRetornado = "Factura generada correctamente";
                      try {
                          Genera_CodigoQR(noFactura, rfcEmisor_, rfcReceptor_, totalAmout,patharchivos);
                      } catch (WriterException ex) {
                          //Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      String enviarcorreo="SI";
                      Ticket imprime=new Ticket();                        
                      imprime.ImprimirVentaFactura(codigobarras+"",formaPago,costotarjeta, noFactura,correo,cliente,numeroEmp+"",tipopagocliente,enviarcorreo);           
                      enviarcorreo="NO";
                      imprime.ImprimirVentaFactura(codigobarras+"",formaPago,costotarjeta, noFactura,correo,cliente,numeroEmp+"",tipopagocliente,enviarcorreo);           
                  }else{
                      System.out.println("Exception la factura no pudo ser generada");
                      try {                      
                      pstm = (PreparedStatement) conn.getConnection().prepareStatement("update to_facturas set estatus=2, factura=0 where factura='"+numeroFac+"';");
                      pstm.executeUpdate();     
                      pstm = (PreparedStatement) conn.getConnection().prepareStatement("update to_parametros set parametro=parametro-1 where clave='FACTURA';");
                      pstm.executeUpdate();     
                     } catch (SQLException ex) {
                         Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      JOptionPane.showMessageDialog(null, "La factura no se genero favor de revisar los datos del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                  }
                  
                  
              
                 return valorRetornado;    
        }
            
        private void Genera_CodigoQR(String noFactura, String rfcEmisor, String rfcRecetor, String totalAmout,String patharchivos) throws IOException, WriterException {
        
        //INICIA OBTENER DATOS DEL ARCHIVO XML GENERADO CON EL WEB SERVICE DE INVOICE ONE
        String total=totalAmout,  rfc_emosor=rfcEmisor, rfc_receptor=rfcRecetor;
        String FechaTimbrado="", UUID="", selloCFD="", noCertificadoSAT="", selloSAT="";
                String rutaimagen=patharchivos+"facturas_xml\\"+noFactura+".png";
                String sFichero = patharchivos+"facturas_xml\\"+noFactura+".xml"; //ruata de archivos para produccion
                System.out.println("ruta xml: "+sFichero);
                File fichero = new File(sFichero);
                if (fichero.exists()){
                                    // Creamos el parseador  
                                    DOMParser parser = new DOMParser();  
                                                 try {
                                                     // Procesamos el fichero XML                                                      
                                                     parser.parse(new InputSource(new FileInputStream(sFichero)));
                                                 } catch (SAXException ex) {
                                                     Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                    // Obtenemos el objeto Document  
                                    Document doc = parser.getDocument(); 
                                    // Obtenemos la etiqueta raiz  
                                 
                                        /*NodeList listaNodosNS = doc.getElementsByTagNameNS("http://www.sat.gob.mx/cfd/3","Comprobante");  
                                        for(int i=0;i<listaNodosNS.getLength();i++){  
                                           Node nodo = listaNodosNS.item(i); 
                                           //System.out.println(listaNodosNS.item(i));
                                           if (nodo instanceof Element){  
                                              //System.out.println(nodo.getAttributes().getNamedItem("descripcion").getTextContent());  

                                              total=nodo.getAttributes().getNamedItem("total").getTextContent()+"";
                                              System.out.println(nodo.getAttributes().getNamedItem("total").getTextContent());
                                                                                                      
                                           }                         
                                        }*/  


                                        NodeList listaNodosNS = doc.getElementsByTagNameNS("http://www.sat.gob.mx/TimbreFiscalDigital","TimbreFiscalDigital");  
                                        for(int i=0;i<listaNodosNS.getLength();i++){  
                                           Node nodo = listaNodosNS.item(i); 
                                           //System.out.println(listaNodosNS.item(i));
                                           if (nodo instanceof Element){  

                                              UUID= nodo.getAttributes().getNamedItem("UUID").getTextContent()+"";
                                              FechaTimbrado=nodo.getAttributes().getNamedItem("FechaTimbrado").getTextContent();                                              
                                              selloCFD=nodo.getAttributes().getNamedItem("selloCFD").getTextContent();
                                              noCertificadoSAT=nodo.getAttributes().getNamedItem("noCertificadoSAT").getTextContent();
                                              selloSAT=nodo.getAttributes().getNamedItem("selloSAT").getTextContent();
                                              
                                              
                                               try {
                                            	   conex conn;
                                                    conn = new conex();
                                                    PreparedStatement pstm;
                                                    pstm = (PreparedStatement) conn.getConnection().prepareStatement("update to_facturas set uuid='"+UUID+"', FechaTimbrado='"+FechaTimbrado+"', selloCFD='"+selloCFD+"', noCertificadoSAT='"+noCertificadoSAT+"', selloSAT='"+selloSAT+"' where factura="+noFactura);
                                                    pstm.executeUpdate();
                                                    pstm.close();
                                                    conn.desconectar();

                                                } catch (SQLException ex) {
                                                    Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                       
                                           }                         
                                        }                        
                                        
                                 }//FIN DE VALIDACION DE FICHERO
        //TERMINA OBTENR DATOS DEL ARCHIVO XML GENERADO CON EL WEB SERVICE DE INVOICE ONE
                
        
        //INICIA AGREAGAR ESTRUCTURA DE MONTO TOTAL PARA CFDI A MOSTRAR EN EL CODIGO QR
        int error=0;
        String montoTotal="", enteros="", decimal="", enterosAdd="", decimalAdd=""; 

        montoTotal=total;
        StringTokenizer tokens=new StringTokenizer(montoTotal,".");
        while(tokens.hasMoreTokens()){
                enteros=tokens.nextToken();
                decimal=tokens.nextToken();
        }

        if(enteros.length()<10){
                for(int i=enteros.length();i<10;i++){
                        enterosAdd=enterosAdd+"0";
                }
                enterosAdd = enterosAdd+enteros;
        }else if(enteros.length()>10){
                error=1;
        }

        if(decimal.length()<6){
                for(int i=decimal.length();i<6;i++){
                        decimalAdd=decimalAdd+"0";
                }
                decimalAdd=decimal+decimalAdd;
        }else if(decimal.length()>6){
                for (int i=0;i<decimal.length();i++){
                        if(i<6){
                                decimalAdd=decimalAdd+decimal.charAt(i);
                        }
                }	   
        }

        if(error==1){
                System.out.println("Error en la generación de QR Code");
        }else{
                System.out.println("Resul: "+enterosAdd+" . "+decimalAdd);
        }
        //TERMINA AGREGAR ESTRUCTURA DE MONTO TOTAL PARA CFDI A MOSTRAR EN EL CODIGO QR       
        
        String qrCodeData = "?re="+rfc_emosor+"&rr="+rfc_receptor+"&tt="+enterosAdd+"."+decimalAdd+"&id="+UUID;
       // String filePath = "C:/factura/CXCXML/"+noFactura+".png"; //ruta de archivos para produccion
        String filePath = rutaimagen; //"C:/factura_desarrollo/CXCXML/"+noFactura+".png"; //ruta de archivos desarrollo 
        String charset = "UTF-8"; // or "ISO-8859-1"
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        createQRCode(qrCodeData, filePath, charset, hintMap, 100, 100);
    }
    
    public static void createQRCode(String qrCodeData, String filePath, String charset, Map hintMap, int qrCodeheight, int qrCodewidth) throws IOException, WriterException{
        BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
        System.out.println("Si entro...");
    }

public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }

}


