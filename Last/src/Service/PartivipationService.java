/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Participation;
import Utils.MyBDConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class PartivipationService {
     Connection mycon = MyBDConnection.getInstanceBD().getConnection(); 
    public void ajouterParticipation(Participation e) {
        String requete = "insert into participation (paticipant_id,event_id ,id) VALUES(?,?,?)";
        try {
            
            
             PreparedStatement pst = mycon.prepareStatement(requete);
            
            pst.setInt(1, e.getPaticipant_id());
            pst.setInt(3, e.getId());
            pst.setInt(2, e.getEvent_id());
           
            pst.executeUpdate();
            System.out.println("participaton");
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
        }
    }
    public List<Participation> displayparticipant() {
        List<Participation> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM participation";
            
            Statement st = mycon.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
               Participation p =new Participation();
                p.setPaticipant_id(rs.getInt("paticipant_id"));
                p.setEvent_id(rs.getInt("event_id"));
                p.setId(rs.getInt("id"));
                
                
                myList.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur d'affichage");
        }
        return myList;
    }
     
      public boolean suprrimerParticipation(Participation p, int paticipant_id) {
        boolean b = false;

        try {
            String requete = "delete from participation where paticipant_id=?";
            PreparedStatement std = mycon.prepareStatement(requete);
            std.setInt(1, paticipant_id);
            std.executeUpdate();

            System.out.println("emprunt supprimer ...");
            b = true;
            

        } catch (Exception e) {
            System.out.println("probleme  ...");
        }
        return b;
    }

    
}
