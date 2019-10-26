/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartService;

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
import smart.Entity.Evenement;
import smart.Utils.MYBDConnection;

/**
 *
 * @author asus
 */
public class EvenementBD {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public EvenementBD() {
        cnx = MYBDConnection.getInstance().getConnexion();
    }

    public void insertPst(Evenement E) {
        String req = "insert into evenement  (id_categorie,titre,nom_image,lieu,description,date_event,nbplace) values (?,?,?,?,?,?,?)";

        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1, E.getId_categorie());
            pst.setString(2, E.getTitre());
            pst.setString(3, E.getNom_image());
            pst.setString(4, E.getLieu());
            pst.setString(5, E.getDescription());
            pst.setDate(6, E.getDate_event());
            pst.setInt(7, E.getNbplace());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Evenement> readAll() {
        String req = "select * from evenement";
        List<Evenement> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Evenement(rs.getInt("id"), rs.getInt("id_categorie"), rs.getString("titre"), rs.getString("nom_image"), rs.getString("lieu"), rs.getString("description"), rs.getDate("date_event"), rs.getInt("nbplace")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        String requette = "DELETE FROM evenement where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("delet success");
        } catch (SQLException ex) {
            System.out.println("error of delete");
        }
    }

    public void update(Evenement E, int id) {
        try {
            String requette = "UPDATE evenement SET id_categorie=?,titre=?,nom_image=?,lieu=?,description=?,date_event=?,nbplace=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setInt(1, E.getId_categorie());
            pst.setString(2, E.getTitre());
            pst.setString(3, E.getNom_image());
            pst.setString(4, E.getLieu());
            pst.setString(5, E.getDescription());
            pst.setDate(6, E.getDate_event());
            pst.setInt(7, E.getNbplace());
            pst.setInt(8, id);
            pst.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");

        }
    }
 public Evenement readById(int id) {
         try {
            String sql = "SELECT * FROM evenement where id= ?";
            
            PreparedStatement pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            
            while (result.next()){
                int id_categorie = result.getInt(2);
                String titre = result.getString(3);
                String nom_image = result.getString(4);
                String lieu = result.getString(5);
                String description = result.getString(6);
                Date date_event = result.getDate(7);
                int nbplace = result.getInt(8);
                
                
                String output = "User : %s - %s ";
                System.out.println(String.format(output, id_categorie, titre,nom_image,lieu,description,date_event,nbplace));
            }       } catch (SQLException ex) {
            System.out.println("error");
            
    }
         return null;
    }
}
