/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class DataSourcee {
     private static String url="jdbc:mysql://127.0.0.1:3306/compte";
    private static String username="root";
        private static String password="";
        private static Connection connexion;
        private static DataSourcee instance;
        private DataSourcee(){
             try {
            // TODO code application logic here
            connexion=DriverManager.getConnection(url, username, password);
                 System.out.println("connection établi");
        } catch (SQLException ex) {
            Logger.getLogger(DataSourcee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        }
        
        public static DataSourcee getInstance(){
        if(instance==null)
            instance=new DataSourcee();
        return instance;
        }

    public static Connection getConnexion() {
        return connexion;
    }
        
}
