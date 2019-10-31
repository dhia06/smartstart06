/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.AvisEvent;
import Utils.MyBDConnection;
import static com.oracle.nio.BufferSecrets.instance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public class AvisEventBD {
        private static AvisEventBD instanceBD;

        Connection mycon = MyBDConnection.getInstanceBD().getConnection(); 
           public static AvisEventBD getInstanceBD(){
        if(instanceBD==null) 
            instanceBD=new AvisEventBD();
        return instanceBD;
    }
         public void insert(AvisEvent o) {
        String req="insert into avis (etat,commentaire) values ('"    +o.getEtat()+"','"+o.getCommentaire()+"')";
        try {
             Statement st = mycon.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AvisEventBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
          public void delete(AvisEvent o) {
        String req="delete from avis where id="+o.getId();
        AvisEvent p;
        p = displayById(o.getId());
        
          if(p!=null)
              try {
           Statement st = mycon.createStatement();
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(AvisEventBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private AvisEvent displayById(int id) {
 String req="select * from avis where id ="+id;
           AvisEvent p=new AvisEvent();
        try {
            Statement st = mycon.createStatement();
            ResultSet rs = st.executeQuery(req);
          
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt("id"));
                p.setEtat(rs.getString("etat"));
                p.setCommentaire(rs.getString("commentaire"));

            //}  
        } catch (SQLException ex) {
            Logger.getLogger(AvisEventBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;    }
 public void supprimer(int id) throws SQLException {
            String req = "delete from avis where id=" + id;
            Statement st = mycon.createStatement();
            st.executeUpdate(req);
            System.out.println("suppression ok");
        

    }
   public ObservableList<AvisEvent> displayAll() {
        String req="select * from avis";
        ObservableList<AvisEvent> list=FXCollections.observableArrayList();       
        
        try {
           Statement st = mycon.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                AvisEvent p=new AvisEvent();
                p.setId(rs.getInt(1));
                p.setEtat(rs.getString("Etat"));
                p.setCommentaire(rs.getString("commentaire"));
                
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AvisEventBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<AvisEvent> displayAllList() {
        String req="select * from avis";
       List<AvisEvent> list=new ArrayList();
        
        try {
           Statement st = mycon.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                AvisEvent p=new AvisEvent();
                p.setId(rs.getInt(1));
                p.setEtat(rs.getString("etat"));
                p.setCommentaire(rs.getString("commentaire"));
               
                                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AvisEventBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<String> displayAllbyType(List<Integer> nbr) {
        String req="select etat , count(*) as count from avis group by etat ";
       List<String> list=new ArrayList();
        
        try {
            Statement st = mycon.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               list.add(rs.getString("etat"));
               nbr.add(rs.getInt("count"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AvisEventBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public boolean update(AvisEvent p) {
        String qry = "UPDATE avis SET Etat = '"+p.getEtat()+"', Comentaire = '"+p.getCommentaire()+"' WHERE id = "+p.getId();
        
        try {
            Statement st = mycon.createStatement();
            
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AvisEventBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
}
