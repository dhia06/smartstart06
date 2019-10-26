/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smart.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class MYBDConnection {

    private String url = "jdbc:mysql://127.0.0.1:3306/smartstart";
    private String username = "root";
    private String password = "";
    private Connection connexion;
    private static MYBDConnection instance;

    private MYBDConnection() {
        try {
            connexion = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion etablie");

        } catch (SQLException ex) {
            Logger.getLogger(MYBDConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public Connection getConnexion() {
        return connexion;
    }

      public static MYBDConnection getInstance(){
        if(instance==null)
            instance=new MYBDConnection();
        return instance;
    }

}
