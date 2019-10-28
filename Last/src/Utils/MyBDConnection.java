/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.DriverManager;
import java.sql.Connection;

import java.sql.SQLException;

/**
 *
 * @author LINA
 */
public class MyBDConnection {
       public static Connection cnx;
   String url = "jdbc:mysql://127.0.0.1:3306/smartstart";
   String login ="root";
   String pwd ="";
   Connection mycon;
   static MyBDConnection instanceBD;
  
    public MyBDConnection() {
      try {
          //get a connection to database
           mycon = DriverManager.getConnection(url, login, pwd);
           System.out.println("connexion etablie !!");
      } catch (SQLException ex) {
           System.out.println(ex.getMessage());
           System.out.println("connexion  non etablie !!");
      }
        
    }
    
    public static MyBDConnection  getInstanceBD(){
        if(instanceBD == null)
            instanceBD = new MyBDConnection();
        return instanceBD;
        
    }
    
    public Connection getConnection(){
        return mycon;
    }
    
    
    
    
}
