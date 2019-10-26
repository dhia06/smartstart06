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
        String req = "insert into publicite(nom,datedebut,datefin,description,img,nbjours,nbclick,idprop,site) values (?,?,?,?,?,?,?,?,?)";

        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1, pub.getNom());
            pst.setDate(2, pub.getDatedebut());
            pst.setDate(3, pub.getDatefin());
            pst.setString(4, pub.getDescription());
            pst.setString(5, pub.getImg());
            pst.setInt(6, pub.getNbjours());
            pst.setInt(7, pub.getNbclick());
           
            pst.setInt(8, pub.getIdprop());
             pst.setString(9, pub.getSite());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ActualiteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Publicite> readAll() {
        String req = "select * from publicite";
        List<Publicite> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Publicite(rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDate("datedebut"),
                        rs.getDate("datefin"),
                        rs.getString("description"),
                        rs.getString("img"),
                        rs.getInt("nbjours"),
                        rs.getInt("nbclick"),
                        rs.getInt("idprop"),
                        rs.getString("site")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActualiteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public void delete(Publicite pub, int id) {
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
    
    
    
    

    public void update(Publicite pub,int id) {
        String sql = "UPDATE publicite SET  nom=?, description=?, datefin=?, img=?,nbclick=?, nbjours=?,site=? where id="+pub.getId(); 
        PreparedStatement ps;
        try {
            ps = cnx.prepareStatement(sql);
            ps.setString(1, pub.getNom());
            ps.setString(2, pub.getDescription());
            ps.setDate(3, pub.getDatefin());
            ps.setString(4, pub.getImg());
            ps.setString(5, pub.getSite());
            ps.setInt(6, pub.getNbclick());
            ps.setInt(7, pub.getNbjours());
            
           ps.executeUpdate();
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
                
             
                String nom = result.getString(2);
                 
               Date datedebut = result.getDate(3);
                Date datefin = result.getDate(4);
                String description=result.getString(5);
               
                String img =result.getString(6);
                int nbjours=result.getInt(7);
                int nbclick=result.getInt(8);
                int idprop=result.getInt(9);
                String site=result.getString(10);

                String output = "Publicité  : NOM %s  ** Date_fin %s**Date_fin %s **  Description %s ** img %s ** NBdejours %s ** nombredeclick %s ** leproprietaire %s ** site %s";
                System.out.println(String.format(output, nom, datedebut, datefin, description, img, nbjours, nbclick, idprop, site));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    


}
