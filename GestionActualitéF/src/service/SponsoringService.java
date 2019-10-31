/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entité.Publicite;
import entité.Sponsoring;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utile.DataSource;

/**
 *
 * @author ASUS
 */
public class SponsoringService {
     private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public SponsoringService() {
        cnx = DataSource.getInstance().getConnexion();
    }

    public void insertPst(Sponsoring s) {
        String req = "insert into sponsoring (date_contrat,description) values (?,?)";

        try {
            pst = cnx.prepareStatement(req);
            
            pst.setDate(1, s.getDate_contrat());
            
         
            pst.setString(2,s.getDescription());
            
           
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }

      public List<Sponsoring> readAll() {
        String req = "select * from sponsoring";
        List<Sponsoring> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
        
               list.add(new Sponsoring(rs.getInt("ref"),  rs.getDate("date_contrat"),  rs.getString("description")));
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(ActualiteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
        
    }
    
    
    public void delete( int ref) {
        String req = "DELETE FROM sponsoring where ref=?";
        try {
            PreparedStatement e = cnx.prepareStatement(req);
            e.setInt(1, ref);
            e.executeUpdate();
            System.out.println("delete success");
        } catch (SQLException ex) {
            System.out.println("error of delete");
        }

    }
    
    
    
    

    public void update(Sponsoring s, int ref) {
        try {
            String req = "UPDATE sponsoring SET date_contrat=?,description=?  WHERE ref=?";
            PreparedStatement u = cnx.prepareStatement(req);
          
            u.setDate(1, s.getDate_contrat());
          
            u.setString(2, s.getDescription());
           
             u.setInt(3, ref);
            u.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");
        }
        
    }
    
    
     public void readbyid(int ref) {
        try {
            String sql = "SELECT * FROM sponsoring where ref= ?";

            PreparedStatement r = cnx.prepareStatement(sql);
            r.setInt(1, ref);
            ResultSet result = r.executeQuery();

            while (result.next()) {
                
             
                
                 
               Date date_contrat = result.getDate(2);
               
                String description=result.getString(3);
              

                String output = "sponsoring  :   ** Date %s**Description %s ** ";
                System.out.println(String.format(output,  date_contrat,  description));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
}
