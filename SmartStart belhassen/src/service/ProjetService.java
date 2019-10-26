/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Projet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author wiemhjiri
 */
public class ProjetService{

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProjetService() {
        cnx = DataSource.getInstance().getConnexion();
    }

    public void insert(Projet p) {
        String req = "insert into projet (titre,objectif,duree,description) values ('" + p.getTitre() + "','" + p.getObjectif() + "','" + p.getDuree() + "','" + p.getDescription() + "')";
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertPst(Projet p) {
        String req = "insert into projet (titre,objectif,duree,description) values (?,?,?,?)";

        try {
            pst = cnx.prepareStatement(req);
            pst.setString(1, p.getTitre());
            pst.setString(2, p.getObjectif());
            pst.setString(3, p.getDuree());
            pst.setString(4, p.getDescription());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Projet> readAll() {
        String req = "select * from projet";
        List<Projet> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Projet(rs.getInt("id"), rs.getString("titre"), rs.getString("objectif"), rs.getString("duree"), rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Projet readById(int id) {
        try {
            String sql = "SELECT * FROM projet where id= ?";

            PreparedStatement pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                String nom = result.getString(2);
                String prenom = result.getString(3);

                String output = "User : %s - %s ";
                System.out.println(String.format(output, nom, prenom));
            }
        } catch (SQLException ex) {
            System.out.println("error");

        }
        return null;
    }

    public void delete( int id) {
        String requette = "DELETE FROM projet where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("delet success");
        } catch (SQLException ex) {
            System.out.println("error of delete");
        }
    }

    public void update(Projet t, int id) {
        try {
            String requette = "UPDATE projet SET titre=?,objectif=?,duree=?,description=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setString(1, t.getTitre());
            pst.setString(2, t.getObjectif());
              pst.setString(3, t.getDuree());
            pst.setString(4, t.getDescription());
            pst.setInt(5, id);
            pst.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");
        }

    }

   
}
