/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entité.Actualite;
import entité.Publicite;
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
public class PubliciteService {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public PubliciteService() {
        cnx = DataSource.getInstance().getConnexion();
    }

    public void insertPst(Publicite pub) {
        String req = "insert into publicite(titre,date,description,affiche,proprietaire,likes) values (?,?,?,?,?,?)";

        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1, pub.getTitre());
            pst.setDate(2, pub.getDate());
            
            pst.setString(3, pub.getDescription());
            pst.setString(4, pub.getAffiche());
            pst.setString(5, pub.getProprietaire());
            pst.setInt(6, 0);
           
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

      public List<Publicite> readAll() {
        String req = "select * from publicite";
        List<Publicite> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Publicite(rs.getInt("id"), rs.getString("titre"), rs.getDate("date"),  rs.getString("description"), rs.getString("affiche"),rs.getString("proprietaire"),rs.getInt("likes")));
            }
        } catch (SQLException ex) {
            System.out.println( ex);
        }
        return list;
    
        
    }
    
    
    public void delete( int id) {
        String req = "DELETE FROM publicite where id=?";
        try {
            PreparedStatement e = cnx.prepareStatement(req);
            e.setInt(1, id);
            e.executeUpdate();
            System.out.println("delete success");
        } catch (SQLException ex) {
            System.out.println("error of delete");
        }

    }
    
    
    
    

    public void update(Publicite pub, int id) {
        try {
            String req = "UPDATE publicite SET titre=?,date=?,description=? ,affiche=? ,proprietaire=? WHERE id=?";
            PreparedStatement u = cnx.prepareStatement(req);
           u.setString(1, pub.getTitre());
            u.setDate(2, pub.getDate());
          
            u.setString(3, pub.getDescription());
            u.setString(4, pub.getAffiche());
             u.setString(5, pub.getProprietaire());
             u.setInt(6, id);
            u.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");
        }
        
    }
    
    
     public void readbyid(int id) {
        try {
            String sql = "SELECT * FROM publicite where id= ?";

            PreparedStatement r = cnx.prepareStatement(sql);
            r.setInt(1, id);
            ResultSet result = r.executeQuery();

            while (result.next()) {
                
             
                String titre = result.getString(2);
                 
               Date date = result.getDate(3);
               
                String description=result.getString(4);
               
                String affiche =result.getString(5);
             
                String proprietaire=result.getString(6);

                String output = "Publicité  : titre %s  ** Date %s**Description %s **  affiche %s ** proprietaire %s ";
                System.out.println(String.format(output, titre, date,  description, affiche,  proprietaire));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    


}
