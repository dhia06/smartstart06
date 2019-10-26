/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import smart.Entity.CategorieEvent;
import smart.Entity.Evenement;
import smart.Utils.MYBDConnection;

/**
 *
 * @author asus
 */
public class CategorieService {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public CategorieService() {
        cnx = MYBDConnection.getInstance().getConnexion();
    }

    public void insertPst(CategorieEvent C) {
        String req = "insert into categorieEvent (id,libelle,description) values (?,?,?)";

        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1, C.getId());
            pst.setString(2, C.getLibelle());
            pst.setString(5, C.getDescription());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<CategorieEvent> readAll() {
        String req = "select * from categorieEvent";
        List<CategorieEvent> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new CategorieEvent(rs.getInt("id"), rs.getString("libelle"), rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public void delete(CategorieEvent t, int id) {
        String requette = "DELETE FROM categorieEvent where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("delet success");
        } catch (SQLException ex) {
            System.out.println("error of delete");
        }
    }
     public void update(CategorieEvent C, int id) {
        try {
            String requette = "UPDATE categorieEvent SET id=?,libelle=?,description=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requette);
           
            pst.setString(2,C.getLibelle());
           
            pst.setString(5, C.getDescription());
            
            pst.setInt(8, id);
            pst.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");

        }
    }
}
