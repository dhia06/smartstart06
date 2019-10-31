/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entité.Actualite;
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
public class ActualiteService {
    
     private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public ActualiteService() {
        cnx = DataSource.getInstance().getConnexion();
    }

    
   
    public void insert(Actualite a) {
        String req = "insert into actualite (titre,date,description,img) values ('" + a.getTitre()+ "','" + a.getDate()+ "','"+a.getDescription()+"','"+a.getimg()+"')";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ActualiteService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   

    public void insertPst(Actualite a) {
        String req = "insert into actualite (titre,date,description,img) values (?,?,?,?)";

        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1, a.getTitre());
            pst.setDate(2, a.getDate());
            pst.setString(3, a.getDescription());
            pst.setString(4, a.getimg());
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(ActualiteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Actualite> readAll() {
        String req = "select * from actualite";
        List<Actualite> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Actualite(rs.getInt("id"), rs.getString("titre"), rs.getDate("date"),  rs.getString("description"), rs.getString("img")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActualiteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void readbyid(int id) {
        try {
            String sql = "SELECT * FROM actualite where id= ?";

            PreparedStatement r = cnx.prepareStatement(sql);
            r.setInt(1, id);
            ResultSet result = r.executeQuery();

            while (result.next()) {
                String titre = result.getString(2);
                Date date = result.getDate(3);
                
                String description=result.getString(4);
                String img =result.getString(5);

                String output = "Actualité : TITRE %s ** Date %s **  Description %s ** image %s ";
                System.out.println(String.format(output, titre, date,description,img));
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }

    public void delete( int id) {
        String req = "DELETE FROM actualite where id=?";
        try {
            PreparedStatement e = cnx.prepareStatement(req);
            e.setInt(1, id);
            e.executeUpdate();
            System.out.println("delete success");
        } catch (SQLException ex) {
            System.out.println("error of delete");
        }

    }

     
    public void update(Actualite a, int id) {
        try {
            String req = "UPDATE actualite SET titre=?,date=?,description=? ,img=? WHERE id=?";
            PreparedStatement u = cnx.prepareStatement(req);
           u.setString(1, a.getTitre());
            u.setDate(2, a.getDate());
          
            u.setString(3, a.getDescription());
            u.setString(4, a.getimg());
             u.setInt(5, id);
            u.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");
        }
     
    }
/*
    @Override
    public void insert(Actualite t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Actualite readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Actualite t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

   
  
    
}
