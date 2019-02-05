/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.*;
/**
 *
 * @author JOSE
 */
public class conexremoto { 
 /*
 public static String login = "solvemor_root";
 public static String password = "Lili2388";
 public static String ip = "www.solvemorelos.com.mx";
 public static String bd = "solvemor_fidelizaciones";  //teting 
 */
 
 /*
 public static String login = "posmexic_root";
 public static String password = "Abcd12345";
 public static String ip = "www.posmexico.com.mx";
 public static String bd = "posmexic_fidelizaciones";  
 */
    
 public static String login = "soluci72_root";
 public static String password = "Abcd1234_";
 public static String ip = "www.solucionesmedicasroda.com";
 public static String bd = "soluci72_fidelizaciones";  
    
 public static String url = "jdbc:mysql://"+ip+":3306/"+bd; 
   
   Connection conn = null;

   public conexremoto(){
       try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            //sSystem.out.println("Conexion a base de datos "+bd+" OK");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
    
   public Connection getConnection(){
      return conn;
   }

   public void desconectar() throws SQLException{
       if(conn!=null){
               conn.close();
        }      
   }

   public String user(){
   
   return password;
  }
   
    

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}


