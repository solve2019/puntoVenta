package puntoventa;

import ClasesDAO.accesoSistema;
import conexion.conex;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import static jinternalPanel.Cotizacion.comboCliente;

public class RemisionPDF {

    public void imprimirpdf(String barcodes) {
        java.sql.Connection conn = null;
        String bd = conex.bd;
        String login = conex.login;
        String password = conex.password;
        String ip = conex.ip;

        String url = "jdbc:mysql://" + ip + "/" + bd;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String master = "reportes//remision.jasper";  //poner la direccion donde se encuentra el archivo .jasper

            //  System.out.println("master" + master);
            if (master == null) {
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el ticket, no esta el archivo jasper.", "Mensaje", JOptionPane.PLAIN_MESSAGE);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e1) {
                System.out.println("Error cargando el reporte maestro: " + e1.getMessage());
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el ticket." + e1.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

            }

            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";

            String folio = "", subtotal = "", total = "", iva = "";
            conex con = new conex();
            try {
                String myQuery = "select no_folio, monto_total, (monto_total*.16) as iva, monto_total+(monto_total*.16) as total from to_folios where codigo_venta='" + barcodes + "'";
                System.out.println("" + myQuery);
                ResultSet rsR = null;
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while (rsR.next()) {
                    folio = rsR.getString("no_folio");
                    subtotal = rsR.getString("monto_total");
                    total = rsR.getString("total");
                    iva = rsR.getString("iva");
                }
                rsR.close();
                st.close();
                con.desconectar();
            } catch (SQLException ex) {
            }

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");
            parametro.put("folio", folio);
            parametro.put("subtotal", subtotal);
            parametro.put("iva", iva);
            parametro.put("total", total);
            //parametro.put("folio",folio);            
            System.out.println(folio + " " + subtotal + " " + iva + " " + total);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);

            //JasperPrintManager.printReport(jasperPrint, false);
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Remision");
            jviewer.setVisible(true);

        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());
        }

    }

    public void imprimirservicio(String idservicio, String fechaservicio, String horaservicio, String monto, String costo, String iva, String estatus, String tipocliente, String medio, String pago) {
        java.sql.Connection conn = null;
        String bd = conex.bd;
        String login = conex.login;
        String password = conex.password;
        String ip = conex.ip;

        String url = "jdbc:mysql://" + ip + "/" + bd;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String master = "reportes//fumivac_formato.jasper";  //poner la direccion donde se encuentra el archivo .jasper

            //  System.out.println("master" + master);
            if (master == null) {
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el ticket, no esta el archivo fumivac_formato.jasper.", "Mensaje", JOptionPane.PLAIN_MESSAGE);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e1) {
                System.out.println("Error cargando el reporte de cotizacion: " + e1.getMessage());
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el formato del servicio." + e1.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

            }

            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";

            String imagen = new File(".").getAbsolutePath() + "\\imagenes_configurables\\logo_sistema.jpg";
            parametro.put("logo", imagen);
            System.out.println("impresion PDF");
            parametro.put("folio", idservicio);
            parametro.put("fecha", fechaservicio);
            parametro.put("hora", horaservicio);
            parametro.put("costo", costo);
            parametro.put("iva", iva);
            parametro.put("total", monto);
            parametro.put("formapago", pago);

            parametro.put("estatus", estatus);
            parametro.put("tipocliente", tipocliente);
            parametro.put("medioseentero", medio);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);

            //JasperPrintManager.printReport(jasperPrint, false);
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Formato de Servicio");
            jviewer.setVisible(true);

        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());
        }
    }

    public void imprimircotizacion(String idcoti) {
        java.sql.Connection conn = null;
        String bd = conex.bd;
        String login = conex.login;
        String password = conex.password;
        String ip = conex.ip;

        String url = "jdbc:mysql://" + ip + "/" + bd;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String master = "reportes//cotizacion - copia.jasper";   //poner la direccion donde se encuentra el archivo .jasper

            //  System.out.println("master" + master);
            if (master == null) {
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el ticket, no esta el archivo jasper.", "Mensaje", JOptionPane.PLAIN_MESSAGE);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e1) {
                System.out.println("Error cargando el reporte de cotizacion: " + e1.getMessage());
                JOptionPane.showMessageDialog(null, "No se pudo imprimir la cotizacion." + e1.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

            }

            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";

            double ivas = obteniva();

            String folio = "", subtotal = "", cliente = "", costoEnvio = "", factura = "", fechaPago = "";
            conex con = new conex();
            double iva = 0.0, total = 0.0;
            String datosDeposito = "BANCO BANAMEX\n"
                    + "A NOMOBRE: COLOSTOMIC SA DE CV\n"
                    + "NUMERO CUENTA: 8175007 SUCURSAL 7003\n"
                    + "CUENTA CLABE: 002540700381750073";
            String direccion = "", telefono = "", rfc = "", estado = "", formaPago = "", fechaRegistro = "", formaPago1 = "";
            try {

                /* String myQuery = "select DATE(fecha) as fecha, monto_total, (monto_total*" + ivas + ") as iva, "
                 + "monto_total+(monto_total+costoEnvio)*" + ivas + ") as total,cliente,costoEnvio,factura,fechaPago,formaPago "
                 + "from to_cotizacion where id_cotizacion='" + idcoti + "'";*/
                String myQuery = "select DATE(fecha) as fecha, monto_total,"
                        + "cliente,costoEnvio,factura,fechaPago,formaPago "
                        + "from to_cotizacion where  id_cotizacion='" + idcoti + "'";
                System.out.println("consulta homi" + myQuery);
                ResultSet rsR = null;
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while (rsR.next()) {

                    subtotal = rsR.getString("monto_total");
                    total = Double.parseDouble(rsR.getString("monto_total"));
                    factura = rsR.getString("factura");
                    iva = total * ivas;
                    total += iva;
                    System.out.println("factura " + factura);
                    if (factura.equalsIgnoreCase("si")) {

                    } else {
                        datosDeposito = "BANCO BANAMEX\n"
                                + "A NOMOBRE: VICTOR MANUEL BARRANCO JOYNER\n"
                                + "NUMERO DE CUENTA: 801 5718\n"
                                + "SUCURSAL: 500\n"
                                + "PAGO DESDE CUALQUIER OXXO\n"
                                + "CUENTA CLABE: 002 540 050 080 157 180\n"
                                + "BANCO BANAMEX \n"
                                + "5204 1671 3241 0697";
                    }

                    cliente = rsR.getString("cliente");
                    costoEnvio = rsR.getString("costoEnvio");
                    factura = rsR.getString("factura");
                    fechaPago = rsR.getString("fechaPago");
                    fechaRegistro = rsR.getString("fecha");
                    formaPago1 = rsR.getString("formaPago");
                }
                //**consultar clientes

                ResultSet rs = null;
                String myQueryCliente = "select concat(calle,' ',colonia,' ',noext,' ',municipio) as direccion,estado,rfc,FormaPago,telefono from tc_clientes where nombre_completo='" + cliente + "'\n"
                        + ";";
                System.out.println("mysq " + myQueryCliente);
                try {
                    Statement stCliente = con.getConnection().createStatement();
                    rs = stCliente.executeQuery(myQueryCliente);
                    while (rs.next()) {
                        System.out.println("paso por cliente");
                        direccion = rs.getString("direccion");
                        telefono = rs.getString("telefono");
                        rfc = rs.getString("rfc");
                        estado = rs.getString("estado");
                        formaPago = rs.getString("FormaPago");

                    }

                    rs.close();
                    stCliente.close();

                } catch (SQLException ex) {
                    System.out.println("algo mal en traer cliente " + ex.getMessage());
                }
                //termina consultar clientes

                rsR.close();
                st.close();
                con.desconectar();
            } catch (SQLException ex) {
            }

            String datosempresa = datosdeempresa();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String imagen = new File(".").getAbsolutePath() + "\\imagenes_configurables\\logo_reporte.jpg";
            // System.out.println("imagen " +imagen);
            parametro.put("logo", imagen);
            System.out.println("impresion PDF");
            parametro.put("folio", idcoti);

            parametro.put("datosempresa", datosempresa);
            parametro.put("subtotal", subtotal);
            parametro.put("iva", iva + "");
            parametro.put("total", total + "");
            parametro.put("cliente", cliente);
            parametro.put("fechaPago", fechaPago);
            parametro.put("factura", factura);
            parametro.put("rfc", rfc);
            parametro.put("direccion", direccion);
            parametro.put("ciudad", estado);
            parametro.put("telefono", telefono);
            String arreFecha[] = fechaRegistro.split("-");
            parametro.put("dia", arreFecha[2]);
            parametro.put("mes", arreFecha[1]);
            parametro.put("año", arreFecha[0]);
            parametro.put("formaPago", formaPago1);
            parametro.put("costoenvio", costoEnvio);
            parametro.put("datos_deposito", datosDeposito);
            //parametro.put("presentacion", folio)

            //parametro.put("folio",folio);            
            System.out.println(folio + " " + subtotal + " " + iva + " " + total + " " + fechaPago + " " + factura);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);

            //JasperPrintManager.printReport(jasperPrint, false);
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Cotizacion");
            jviewer.setVisible(true);

        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());
        }

    }

    public void verFacturas(String idcoti) {
        java.sql.Connection conn = null;
        String bd = conex.bd;
        String login = conex.login;
        String password = conex.password;
        String ip = conex.ip;

        String url = "jdbc:mysql://" + ip + "/" + bd;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String master = "reportes//factura.jasper";   //poner la direccion donde se encuentra el archivo .jasper

            //  System.out.println("master" + master);
            if (master == null) {
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el ticket, no esta el archivo jasper.", "Mensaje", JOptionPane.PLAIN_MESSAGE);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e1) {
                System.out.println("Error cargando el reporte de cotizacion: " + e1.getMessage());
                JOptionPane.showMessageDialog(null, "No se pudo imprimir la cotizacion." + e1.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

            }

            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";

            double ivas = obteniva();

            String folio = "", subtotal = "", cliente = "", costoEnvio = "", factura = "", fechaPago = "";
            conex con = new conex();
            double iva = 0.0, total = 0.0;
            String datosDeposito = "BANCO BANAMEX\n"
                    + "A NOMOBRE: COLOSTOMIC SA DE CV\n"
                    + "NUMERO CUENTA: 8175007 SUCURSAL 7003\n"
                    + "CUENTA CLABE: 002540700381750073";
            String direccion = "", telefono = "", rfc = "", estado = "", formaPago = "", fechaRegistro = "", formaPago1 = "";
            try {

                /* String myQuery = "select DATE(fecha) as fecha, monto_total, (monto_total*" + ivas + ") as iva, "
                 + "monto_total+(monto_total+costoEnvio)*" + ivas + ") as total,cliente,costoEnvio,factura,fechaPago,formaPago "
                 + "from to_cotizacion where id_cotizacion='" + idcoti + "'";*/
                String myQuery = "select DATE(fecha) as fecha, monto_total,"
                        + "cliente,costoEnvio,factura,fechaPago,formaPago "
                        + "from to_cotizacion where  id_cotizacion='" + idcoti + "'";
                System.out.println("consulta homi" + myQuery);
                ResultSet rsR = null;
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while (rsR.next()) {

                    subtotal = rsR.getString("monto_total");
                    total = Double.parseDouble(rsR.getString("monto_total"));
                    factura = rsR.getString("factura");
                    iva = total * ivas;
                    total += iva;
                    System.out.println("factura " + factura);
                    if (factura.equalsIgnoreCase("si")) {

                    } else {
                        datosDeposito = "BANCO BANAMEX\n"
                                + "A NOMOBRE: VICTOR MANUEL BARRANCO JOYNER\n"
                                + "NUMERO DE CUENTA: 801 5718\n"
                                + "SUCURSAL: 500\n"
                                + "PAGO DESDE CUALQUIER OXXO\n"
                                + "CUENTA CLABE: 002 540 050 080 157 180\n"
                                + "BANCO BANAMEX \n"
                                + "5204 1671 3241 0697";
                    }

                    cliente = rsR.getString("cliente");
                    costoEnvio = rsR.getString("costoEnvio");
                    factura = rsR.getString("factura");
                    fechaPago = rsR.getString("fechaPago");
                    fechaRegistro = rsR.getString("fecha");
                    formaPago1 = rsR.getString("formaPago");
                }
                //**consultar clientes

                ResultSet rs = null;
                String myQueryCliente = "select concat(calle,' ',colonia,' ',noext,' ',municipio) as direccion,estado,rfc,FormaPago,telefono from tc_clientes where nombre_completo='" + cliente + "'\n"
                        + ";";
                System.out.println("mysq " + myQueryCliente);
                try {
                    Statement stCliente = con.getConnection().createStatement();
                    rs = stCliente.executeQuery(myQueryCliente);
                    while (rs.next()) {
                        System.out.println("paso por cliente");
                        direccion = rs.getString("direccion");
                        telefono = rs.getString("telefono");
                        rfc = rs.getString("rfc");
                        estado = rs.getString("estado");
                        formaPago = rs.getString("FormaPago");

                    }

                    rs.close();
                    stCliente.close();

                } catch (SQLException ex) {
                    System.out.println("algo mal en traer cliente " + ex.getMessage());
                }
                //termina consultar clientes

                rsR.close();
                st.close();
                con.desconectar();
            } catch (SQLException ex) {
            }

            String datosempresa = datosdeempresa();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String imagen = new File(".").getAbsolutePath() + "\\imagenes_configurables\\logo_reporte.jpg";
            // System.out.println("imagen " +imagen);
            parametro.put("logo", imagen);
            System.out.println("impresion PDF");
            parametro.put("folio", idcoti);

            parametro.put("datosempresa", datosempresa);
            parametro.put("subtotal", subtotal);
            parametro.put("iva", iva + "");
            parametro.put("total", total + "");
            parametro.put("cliente", cliente);
            parametro.put("fechaPago", fechaPago);
            parametro.put("factura", factura);
            parametro.put("rfc", rfc);
            parametro.put("direccion", direccion);
            parametro.put("ciudad", estado);
            parametro.put("telefono", telefono);
            String arreFecha[] = fechaRegistro.split("-");
            parametro.put("dia", arreFecha[2]);
            parametro.put("mes", arreFecha[1]);
            parametro.put("año", arreFecha[0]);
            parametro.put("formaPago", formaPago1);
            parametro.put("costoenvio", costoEnvio);
            parametro.put("datos_deposito", datosDeposito);
            //parametro.put("presentacion", folio)

            //parametro.put("folio",folio);            
            System.out.println(folio + " " + subtotal + " " + iva + " " + total + " " + fechaPago + " " + factura);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);

            //JasperPrintManager.printReport(jasperPrint, false);
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("FACTURA");
            jviewer.setVisible(true);

        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());
        }

    }

    public void verEmbarques(String idcoti) {

        System.out.println("coti " + idcoti);
        java.sql.Connection conn = null;
        String bd = conex.bd;
        String login = conex.login;
        String password = conex.password;
        String ip = conex.ip;

        String url = "jdbc:mysql://" + ip + "/" + bd;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String master = "reportes//embarques.jasper";   //poner la direccion donde se encuentra el archivo .jasper

            //  System.out.println("master" + master);
            if (master == null) {
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el ticket, no esta el archivo jasper.", "Mensaje", JOptionPane.PLAIN_MESSAGE);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e1) {
                System.out.println("Error cargando el reporte de cotizacion: " + e1.getMessage());
                JOptionPane.showMessageDialog(null, "No se pudo imprimir la cotizacion." + e1.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

            }

            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";

            double ivas = obteniva();

            String folio = "", subtotal = "", cliente = "", costoEnvio = "", factura = "", fechaPago = "";
            conex con = new conex();
            double iva = 0.0, total = 0.0;
            String datosDeposito = "BANCO BANAMEX\n"
                    + "A NOMOBRE: COLOSTOMIC SA DE CV\n"
                    + "NUMERO CUENTA: 8175007 SUCURSAL 7003\n"
                    + "CUENTA CLABE: 002540700381750073";
            String direccion = "", correo = "", telefono = "", rfc = "", estado = "", formaPago = "", fechaRegistro = "", formaPago1 = "";
            try {

                /* String myQuery = "select DATE(fecha) as fecha, monto_total, (monto_total*" + ivas + ") as iva, "
                 + "monto_total+(monto_total+costoEnvio)*" + ivas + ") as total,cliente,costoEnvio,factura,fechaPago,formaPago "
                 + "from to_cotizacion where id_cotizacion='" + idcoti + "'";*/
                String myQuery = "select DATE(fecha) as fecha, monto_total,"
                        + "cliente,costoEnvio,factura,fechaPago,formaPago "
                        + "from to_cotizacion where  id_cotizacion='" + idcoti + "'";
                System.out.println("consulta homi" + myQuery);
                ResultSet rsR = null;
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while (rsR.next()) {

                    subtotal = rsR.getString("monto_total");
                    total = Double.parseDouble(rsR.getString("monto_total"));
                    factura = rsR.getString("factura");
                    iva = total * ivas;
                    total += iva;
                    System.out.println("factura " + factura);
                    if (factura.equalsIgnoreCase("si")) {

                    } else {
                        datosDeposito = "BANCO BANAMEX\n"
                                + "A NOMOBRE: VICTOR MANUEL BARRANCO JOYNER\n"
                                + "NUMERO DE CUENTA: 801 5718\n"
                                + "SUCURSAL: 500\n"
                                + "PAGO DESDE CUALQUIER OXXO\n"
                                + "CUENTA CLABE: 002 540 050 080 157 180\n"
                                + "BANCO BANAMEX \n"
                                + "5204 1671 3241 0697";
                    }

                    cliente = rsR.getString("cliente");
                    costoEnvio = rsR.getString("costoEnvio");
                    factura = rsR.getString("factura");
                    fechaPago = rsR.getString("fechaPago");
                    fechaRegistro = rsR.getString("fecha");
                    formaPago1 = rsR.getString("formaPago");
                }
                //**consultar clientes

                ResultSet rs = null;
                String myQueryCliente = "select concat(calle,' ',colonia,' ',noext,' ',municipio) as direccion,estado,rfc,FormaPago,telefono,email from tc_clientes where nombre_completo='" + cliente + "'\n"
                        + ";";
                System.out.println("mysq " + myQueryCliente);
                try {
                    Statement stCliente = con.getConnection().createStatement();
                    rs = stCliente.executeQuery(myQueryCliente);
                    while (rs.next()) {

                        direccion = rs.getString("direccion");
                        telefono = rs.getString("telefono");
                        rfc = rs.getString("rfc");
                        estado = rs.getString("estado");
                        formaPago = rs.getString("FormaPago");
                        correo = rs.getString("email");

                    }

                    rs.close();
                    stCliente.close();

                } catch (SQLException ex) {
                    System.out.println("algo mal en traer cliente " + ex.getMessage());
                }
                //termina consultar clientes

                rsR.close();
                st.close();
                con.desconectar();
            } catch (SQLException ex) {
            }

            String datosempresa = datosdeempresa();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
               String imagen = new File(".").getAbsolutePath() + "\\imagenes_configurables\\logo_reporte.jpg";
            // System.out.println("imagen " +imagen);
            parametro.put("logo", imagen);
            parametro.put("idCoti", idcoti);
            parametro.put("cliente", cliente);
            parametro.put("direccion", direccion);
            parametro.put("telefono", telefono);
            parametro.put("correo", correo);
            parametro.put("datos_deposito", datosDeposito);

            System.out.println("impresion PDF");
            /* parametro.put("folio", idcoti);

             parametro.put("datosempresa", datosempresa);
             parametro.put("subtotal", subtotal);
             parametro.put("iva", iva + "");
             parametro.put("total", total + "");
            
             parametro.put("fechaPago", fechaPago);
             parametro.put("factura", factura);
             parametro.put("rfc", rfc);
           
             parametro.put("ciudad", estado);
       
             String arreFecha[] = fechaRegistro.split("-");
             parametro.put("dia", arreFecha[2]);
             parametro.put("mes", arreFecha[1]);
             parametro.put("año", arreFecha[0]);
             parametro.put("formaPago", formaPago1);
             parametro.put("costoenvio", costoEnvio);*/

            //parametro.put("presentacion", folio)
            //parametro.put("folio",folio);            
            System.out.println(folio + " " + subtotal + " " + iva + " " + total + " " + fechaPago + " " + factura);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);

            //JasperPrintManager.printReport(jasperPrint, false);
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Guia embarque");
            jviewer.setVisible(true);

        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());
        }

    }

    public boolean imprimirFactura(String idcoti, Frame f) {
        boolean ban = false;
        java.sql.Connection conn = null;
        String bd = conex.bd;
        String login = conex.login;
        String password = conex.password;
        String ip = conex.ip;

        String url = "jdbc:mysql://" + ip + "/" + bd;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String master = "reportes//factura.jasper";   //poner la direccion donde se encuentra el archivo .jasper

            //  System.out.println("master" + master);
            if (master == null) {
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el ticket, no esta el archivo jasper.", "Mensaje", JOptionPane.PLAIN_MESSAGE);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e1) {
                System.out.println("Error cargando el reporte de cotizacion: " + e1.getMessage());
                JOptionPane.showMessageDialog(null, "No se pudo imprimir la cotizacion." + e1.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

            }

            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";

            double ivas = obteniva();
            System.out.println("modificamos estatus coti");

            String folio = "", subtotal = "", cliente = "", costoEnvio = "", factura = "", fechaPago = "";
            conex con = new conex();
            modificarEstatusCotizacion(con.getConnection(), idcoti);
            double iva = 0.0, total = 0.0;
            String datosDeposito = "BANCO BANAMEX\n"
                    + "A NOMOBRE: COLOSTOMIC SA DE CV\n"
                    + "NUMERO CUENTA: 8175007 SUCURSAL 7003\n"
                    + "CUENTA CLABE: 002540700381750073";
            String direccion = "", numFactura = "", telefono = "", rfc = "", estado = "", formaPago = "", fechaRegistro = "", formaPago1 = "";
            try {

                /* String myQuery = "select DATE(fecha) as fecha, monto_total, (monto_total*" + ivas + ") as iva, "
                 + "monto_total+(monto_total+costoEnvio)*" + ivas + ") as total,cliente,costoEnvio,factura,fechaPago,formaPago "
                 + "from to_cotizacion where id_cotizacion='" + idcoti + "'";*/
                String myQuery = "select DATE(fecha) as fecha, monto_total,"
                        + "cliente,costoEnvio,factura,fechaPago,formaPago,numFactura "
                        + "from to_cotizacion where id_cotizacion='" + idcoti + "'";

                ResultSet rsR = null;
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while (rsR.next()) {
                    numFactura = rsR.getString("numFactura");
                    subtotal = rsR.getString("monto_total");
                    total = Double.parseDouble(rsR.getString("monto_total"));
                    factura = rsR.getString("factura");
                    iva = total * ivas;
                    total += iva;
                    System.out.println("factura " + factura);
                    if (factura.equalsIgnoreCase("si")) {

                    } else {
                        datosDeposito = "BANCO BANAMEX\n"
                                + "A NOMOBRE: VICTOR MANUEL BARRANCO JOYNER\n"
                                + "NUMERO DE CUENTA: 801 5718\n"
                                + "SUCURSAL: 500\n"
                                + "PAGO DESDE CUALQUIER OXXO\n"
                                + "CUENTA CLABE: 002 540 050 080 157 180\n"
                                + "BANCO BANAMEX \n"
                                + "5204 1671 3241 0697";
                    }

                    cliente = rsR.getString("cliente");
                    costoEnvio = rsR.getString("costoEnvio");
                    factura = rsR.getString("factura");
                    fechaPago = rsR.getString("fechaPago");
                    fechaRegistro = rsR.getString("fecha");
                    formaPago1 = rsR.getString("formaPago");
                }
                //**consultar clientes

                ResultSet rs = null;
                String myQueryCliente = "select concat(calle,' ',colonia,' ',noext,' ',municipio) as direccion,estado,rfc,FormaPago,telefono from tc_clientes where nombre_completo='" + cliente + "'\n"
                        + ";";
                System.out.println("mysq " + myQueryCliente);
                try {
                    Statement stCliente = con.getConnection().createStatement();
                    rs = stCliente.executeQuery(myQueryCliente);
                    while (rs.next()) {
                        System.out.println("paso por cliente");
                        direccion = rs.getString("direccion");
                        telefono = rs.getString("telefono");
                        rfc = rs.getString("rfc");
                        estado = rs.getString("estado");
                        formaPago = rs.getString("FormaPago");

                    }

                    rs.close();
                    stCliente.close();

                } catch (SQLException ex) {
                    System.out.println("algo mal en traer cliente " + ex.getMessage());
                }
                //termina consultar clientes

                rsR.close();
                st.close();

            } catch (SQLException ex) {
            }

            String datosempresa = datosdeempresa();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String imagen = new File(".").getAbsolutePath() + "\\imagenes_configurables\\logo_reporte.jpg";
            // System.out.println("imagen " +imagen);
            parametro.put("logo", imagen);
            System.out.println("impresion PDF");
            parametro.put("folio", idcoti);
            parametro.put("numFactura", numFactura);

            parametro.put("datosempresa", datosempresa);
            parametro.put("subtotal", subtotal);
            parametro.put("iva", iva + "");
            parametro.put("total", total + "");
            parametro.put("cliente", cliente);
            parametro.put("fechaPago", fechaPago);
            parametro.put("factura", factura);
            parametro.put("rfc", rfc);
            parametro.put("direccion", direccion);
            parametro.put("ciudad", estado);
            parametro.put("telefono", telefono);
            String arreFecha[] = fechaRegistro.split("-");
            parametro.put("dia", arreFecha[2]);
            parametro.put("mes", arreFecha[1]);
            parametro.put("año", arreFecha[0]);
            parametro.put("formaPago", formaPago1);
            parametro.put("costoenvio", costoEnvio);
            parametro.put("datos_deposito", datosDeposito);
            //parametro.put("presentacion", folio)

            //parametro.put("folio",folio);            
            System.out.println(folio + " " + subtotal + " " + iva + " " + total + " " + fechaPago + " " + factura);
//registramos el folio
            if (registrarFolio(con.getConn(), total + "", "0.00", "0.00", "", accesoSistema.nombreuser, formaPago1, accesoSistema.iduser,
                    "0.00", iva + "", "0.00", cliente)) {

                obtenerProductos(con.getConnection(), idcoti);
                //abrimos la pantalla embarque
                pantallaEmbarque.idCoti = idcoti;

                pantallaEmbarque em = new pantallaEmbarque();
                em.setVisible(true);
            } else {

            }

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);

            //JasperPrintManager.printReport(jasperPrint, false);
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Factura");
            jviewer.setVisible(true);

            ban = true;
            con.desconectar();
        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());
        }
        return ban;
    }
//cesar

    public void modificarEstatusCotizacion(Connection con, String idCoti) {

        String sql1 = "select max(numFactura) as contador from to_cotizacion";

        try {

            PreparedStatement ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int conta = 0;
                if (rs.getObject("contador") == null) {
                    conta = 1;
                } else {
                    conta = rs.getInt("contador") + 1;
                }

                System.out.println("con " + con);
                String sql2 = "update to_cotizacion set estatusFacturado='si',numFactura='" + conta + "' where id_cotizacion='" + idCoti + "'";
                ps = con.prepareStatement(sql2);
                ps.executeUpdate();
            }

            System.out.println("se  modifico el estatus " + idCoti);
        } catch (Exception e) {
            System.out.println("Error  en  modificarEstatusCotizacion " + e.getMessage());
        }
    }

    public boolean registrarFolio(Connection con, String monto, String pagoefectivo, String referenciabanco,
            String referenciamixto, String nombreuser, String formaPago, String iduser,
            String resultdescuento, String iva, String ieps, String nombrecliente) {
        int folio = ultimoFolio(con) + 1;
        String idclientefac = obtenerIdCliente(con, nombrecliente) + "";
        boolean ban = false;

        String sql = "INSERT INTO to_folios (no_folio, monto_total, efectivo, tarjeta,referencia_tarjeta, "
                + "monto_puntos, no_puntos, fecha_movimiento,usuario_registro,tipo_movimiento,forma_pago,id_usuario,"
                + "descuento,iva,cliente,ieps) "
                + "VALUES ('" + folio + "', " + monto + ", " + pagoefectivo + ", " + referenciabanco + ", '" + referenciamixto
                + "', 0, 0, now(),'" + nombreuser + "','FACTURA','" + formaPago + "','" + iduser + "','"
                + resultdescuento + "','" + iva + "','" + idclientefac + "'," + ieps + ")";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ban = true;
        } catch (Exception e) {
        }

        return ban;

    }

    public void obtenerProductos(Connection con, String idCoti) {
        int ultimoFol = ultimoFolio(con);
        System.out.println("obtenemos ultimo folio " + ultimoFol);
        String sql = "select monto_total+(monto_total  *.16)as total,idproducto,cantidad,precio  from to_cotizacion as c  inner join   to_cotizacion_prod as  cp on c.id_cotizacion=cp.id_coti where id_coti='" + idCoti + "'";
        try {
            System.out.println("obtner prod " + sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //obtnemos la cantidad 
                String total = rs.getString("total");
                String idPro = rs.getString("idproducto");
                int can = rs.getInt("cantidad");
                String precio = rs.getString("precio");
                System.out.println("registramos la venta");
                registrarVenta(con, idPro, can + "", precio, total, ultimoFol + "", "0.00");
                System.out.println("vamos a editar la cantidad producto ");

                int nuevaCantidad = obtenerCantidadProductos(con, idPro) - rs.getInt("cantidad");
                editarCantidaPro(con, nuevaCantidad + "", idPro);

            }
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public void editarCantidaPro(Connection con, String nuevaCantidad, String idPro) {
        String sql = "update tc_productos set existencia='" + nuevaCantidad + "' where idproducto='" + idPro + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("editado cantidad " + idPro);
        } catch (Exception e) {
            System.out.println("Error en editarCantidadPro  " + e.getMessage());
        }
    }

    public int obtenerCantidadProductos(Connection con, String idPro) {
        int can = 0;
        String sql = "select existencia from   tc_productos where idproducto='" + idPro + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                can = rs.getInt("existencia");
            }
            System.out.println("cantidad " + can);

            System.out.println("tenemos cantidad");
        } catch (Exception e) {
            System.out.println("Error  al obtenerCantidadProductos " + e.getMessage());
        }
        return can;
    }

    public boolean registrarVenta(Connection con, String idproducto, String cantidad, String precio, String total, String folio, String ieps) {
        String sql = "insert into to_ventas(idproducto,cantidad,precio,total,folio,fecha_mov,ieps)"
                + "values('" + idproducto + "','" + cantidad + "','" + precio + "','" + total + "','" + folio + "',now(),'" + ieps + "')";

        boolean ban = false;
        System.out.println("registro  la venta " + sql);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ban = true;
            ps.close();
            System.out.println("registro  la venta");
        } catch (Exception e) {
            System.out.println("Error registrar venta " + e.getMessage());
        }

        return ban;
    }

    public void cargar_clientes() {

        conex con = new conex();

    }

    public int obtenerIdCliente(Connection con, String nombre) {
        int idCliente = 0;
        String sql = "select  idcliente from tc_clientes where nombre_completo=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idCliente = rs.getInt("idcliente");
            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("error  al  obtenerIdCliente");
        }

        return idCliente;
    }

    public int ultimoFolio(Connection con) {
        int ultimoFolio = 0;
        String sql = "select no_folio from to_folios order by no_folio desc limit 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ultimoFolio = rs.getInt("no_folio");
            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("error  al  obtner el ultimo folio");
        }

        return ultimoFolio;
    }

    public void imprimirPDFCompra(String idcoti) {
        java.sql.Connection conn = null;
        String bd = conex.bd;
        String login = conex.login;
        String password = conex.password;
        String ip = conex.ip;

        String url = "jdbc:mysql://" + ip + "/" + bd;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String master = "reportes//compras.jasper";  //poner la direccion donde se encuentra el archivo .jasper

            //  System.out.println("master" + master);
            if (master == null) {
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el ticket, no esta el archivo jasper.", "Mensaje", JOptionPane.PLAIN_MESSAGE);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e1) {
                System.out.println("Error cargando el reporte de cotizacion: " + e1.getMessage());
                JOptionPane.showMessageDialog(null, "No se pudo imprimir la cotizacion." + e1.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

            }

            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";

            double ivas = obteniva();

            String folio = "", subtotal = "", total = "", iva = "", fecha = "", proveedor = "", domicilio = "", idprov = "";
            conex con = new conex();
            try {

                String myQuery = "select monto_compra, (monto_compra*" + ivas + ") as iva, monto_compra+(monto_compra*" + ivas + ") as total, fecha_registro, IdProveedor from proveedor_to_compra where FolioCompra='" + idcoti + "'";
                System.out.println("" + myQuery);
                ResultSet rsR = null;
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while (rsR.next()) {
                    subtotal = rsR.getString("monto_compra");
                    total = rsR.getString("total");
                    iva = rsR.getString("iva");
                    fecha = rsR.getString("fecha_registro");
                    idprov = rsR.getString("IdProveedor");
                }

                myQuery = "SELECT * from proveedor_tc where IdProveedor='" + idprov + "'";
                System.out.println("" + myQuery);
                rsR = st.executeQuery(myQuery);
                while (rsR.next()) {
                    proveedor = rsR.getString("nombreProveedor");
                    domicilio = rsR.getString("direccion") + " " + rsR.getString("colonia") + " C.P. " + rsR.getString("cp") + " " + rsR.getString("estado");
                }

                rsR.close();
                st.close();
                con.desconectar();
            } catch (SQLException ex) {
            }
            String imagen = new File(".").getAbsolutePath() + "\\imagenes_configurables\\logo_sistema.jpg";
            String datosempresa = datosdeempresa();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");
            parametro.put("folio", idcoti);

            parametro.put("datosempresa", datosempresa);
            parametro.put("subtotal", subtotal);
            parametro.put("iva", iva);
            parametro.put("total", total);
            parametro.put("fecha", fecha);
            parametro.put("fecha", fecha);
            parametro.put("proveedor", proveedor);
            parametro.put("domicilio", domicilio);
            parametro.put("imagen", imagen);
            System.out.println(folio + " " + subtotal + " " + iva + " " + total);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);

            //JasperPrintManager.printReport(jasperPrint, false);
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Compras");
            jviewer.setVisible(true);

        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());
        }

    }

    public void imprimirpdfpension(String barcodes, String pension) {

        java.sql.Connection conn = null;

        String bd = conex.bd;
        String login = conex.login;
        String password = conex.password;
        String ip = conex.ip;

        String url = "jdbc:mysql://" + ip + "/" + bd;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String master = "reportes//ticket.jasper";  //poner la direccion donde se encuentra el archivo .jasper

            //  System.out.println("master" + master);
            if (master == null) {
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el ticket, no esta el archivo jasper.", "Mensaje", JOptionPane.PLAIN_MESSAGE);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e1) {
                System.out.println("Error cargando el reporte maestro: " + e1.getMessage());
                JOptionPane.showMessageDialog(null, "No se pudo imprimir el ticket." + e1.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

            }

            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";

            String footer = "", encabezado = "";

            String tiempo_mu = "0", hora_fin = null, diahoramin = "";
            String tipo_auto = "";
            float lavado = 0;
            int tiempo = 0;

            conex cn = new conex();
            String sql = "SELECT sum(TIMESTAMPDIFF(second,fecha_entrada,fecha_salida)) as tiempo, codigo_barras,folio,fecha_entrada,placas,marca,modelo,id_usuario,fecha_salida,monto,costo_lavado from entradas where codigo_barras='" + barcodes + "' GROUP BY fecha_entrada";
            ResultSet rs100 = null;
            PreparedStatement pstm100;
            String codigobar = "", ficha = "", hora_entrada = "", conductor = "", placa_tracto = "", noeconomico = "", placa_remolque = "";
            String empresa = "", tipo = "", categoria = "", usuario = "", hora_salida = "", monto = "", dias = "", costo_lavado = "";
            try {
                pstm100 = cn.getConnection().prepareStatement(sql);
                rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {
                    tiempo_mu = rs100.getString(1);
                    codigobar = rs100.getString("codigo_barras");
                    ficha = rs100.getString("folio");
                    hora_entrada = rs100.getString("fecha_entrada");
                    placa_tracto = rs100.getString("placas");
                    noeconomico = rs100.getString("marca");
                    placa_remolque = rs100.getString("modelo");
                    costo_lavado = rs100.getString("costo_lavado");
                    usuario = rs100.getString("id_usuario");
                    hora_salida = rs100.getString("fecha_salida");
                    monto = rs100.getString("monto");
                }
                sql = "SELECT parametro from parametros where clave='FOOTER'";
                pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
                rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {

                    footer = rs100.getString("parametro");
                }
                sql = "SELECT parametro from parametros where clave='ENCABEZADO'";
                pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
                rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {

                    encabezado = rs100.getString("parametro");
                }

            } catch (SQLException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            rs100.close();
            cn.desconectar();

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String imagen = new File(".").getAbsolutePath() + "\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            

            parametro.put("codigo_barra", codigobar);
            parametro.put("footer", footer);
            parametro.put("encabezado", encabezado);
            parametro.put("costolavado", costo_lavado);

            parametro.put("ficha", ficha);
            parametro.put("hora_entrada", hora_entrada);
            parametro.put("conductor", conductor);
            parametro.put("placa_tracto", placa_tracto);
            parametro.put("noeconomico", noeconomico);
            parametro.put("placa_remolque", placa_remolque);
            parametro.put("empresa", empresa);
            parametro.put("tipo", tipo);
            parametro.put("categoria", categoria);
            parametro.put("usuario", usuario);
            parametro.put("hora_salida", hora_salida);
            parametro.put("monto", monto);
            parametro.put("dias", diahoramin);
            parametro.put("pension", pension);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);
            JasperPrintManager.printReport(jasperPrint, false);

            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            //JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            //jviewer.setTitle("Ticket");
            //jviewer.setVisible(true);
        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());
        }

    }

    public double obteniva() {
        double iva = 0.0;
        conex cn = new conex();
        String sql = "SELECT parametro from to_parametros where clave='IVA'";
        System.out.println(sql);
        PreparedStatement pstm100;
        try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
            while (rs100.next()) {

                iva = rs100.getDouble("parametro");
            }
            rs100.close();
            pstm100.close();
            cn.desconectar();
        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        iva = iva / 100;
        return iva;
    }

    public String datosdeempresa() {
        String encabezado = "";
        conex cn = new conex();
        String sql = "SELECT parametro from to_parametros where clave='ENCABEZADO'";
        System.out.println(sql);
        PreparedStatement pstm100;
        try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
            while (rs100.next()) {
                encabezado = rs100.getString("parametro");
            }
            rs100.close();
            pstm100.close();
            cn.desconectar();
        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        return encabezado;
    }

    public void imprimirnota(String idcoti) {
        java.sql.Connection conn = null;
        String bd = conex.bd;
        String login = conex.login;
        String password = conex.password;
        String ip = conex.ip;

        String url = "jdbc:mysql://" + ip + "/" + bd;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String master = "reportes//notacredito.jasper";  //poner la direccion donde se encuentra el archivo .jasper

            //  System.out.println("master" + master);
            if (master == null) {
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null, "No se pudo generar la nota, no esta el archivo jasper.", "Mensaje", JOptionPane.PLAIN_MESSAGE);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch (JRException e1) {
                System.out.println("Error cargando el reporte de cotizacion: " + e1.getMessage());
                JOptionPane.showMessageDialog(null, "No se pudo imprimir la nota." + e1.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

            }

            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";

            double ivas = obteniva();

            String folio = "", subtotal = "", total = "", iva = "", ieps = "";
            conex con = new conex();
            try {

                String myQuery = "select monto_total_nota, (monto_total_nota*" + ivas + ") as iva, monto_total_nota+ieps+(monto_total_nota*" + ivas + ") as total,ieps from to_nota_credito where id_nota='" + idcoti + "'";
                System.out.println("" + myQuery);
                ResultSet rsR = null;
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while (rsR.next()) {
                    subtotal = rsR.getString("monto_total_nota");
                    total = rsR.getString("total");
                    iva = rsR.getString("iva");
                    ieps = rsR.getString("ieps");

                }
                rsR.close();
                st.close();
                con.desconectar();
            } catch (SQLException ex) {
            }

            String datosempresa = datosdeempresa();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");
            parametro.put("folio", idcoti);

            parametro.put("datosempresa", datosempresa);
            parametro.put("subtotal", subtotal);
            parametro.put("iva", iva);
            parametro.put("ieps", ieps);
            parametro.put("total", total);
            //parametro.put("folio",folio);            
            System.out.println(folio + " " + subtotal + " " + iva + " " + total);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);

            //JasperPrintManager.printReport(jasperPrint, false);
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Nota de credito");
            jviewer.setVisible(true);

        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());
        }

    }

}
