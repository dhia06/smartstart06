/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entity.Evenement;
import Utils.MyBDConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class EvenementBD {
    Connection mycon = MyBDConnection.getInstanceBD().getConnection(); 
    
    // Connection mycon = MyBDConnection.getInstanceBD().getConnection(); 
      public ObservableList<Evenement> afficherEvent(){
        ObservableList myList = FXCollections.observableArrayList();
        
        try {
            Statement st  = mycon.createStatement();
            String str = "SELECT * FROM evenement";
             ResultSet rs = st.executeQuery(str);
            while(rs.next()){
              // CategorieDB  ce=new CategorieDB();
            System.out.println("Evenement : "+rs.getInt(1)
                    +" | "+rs.getString(2)
                    +" | "+rs.getString(3)
                    +" | "+rs.getString(4)
                    +" | "+rs.getDate(5)
                    +" | "+rs.getInt(6)
                    +" | "+rs.getString(7)
                    +" | "+rs.getInt(8));
                    
              myList.add(new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),
                    rs.getInt(6),rs.getString(7),rs.getInt(8)));
               
            } 
            
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de l'affichage " + ex.getMessage());
        }      
        return myList;
    }
      public void ajouterEvent(Evenement E){
    
        
        try {
            Statement st = mycon.createStatement();
            String query = "insert into evenement values("+E.id+",'"+E.titre+"','"+E.lieu+"','"+E.description+"','"+E.date_event+"','"+E.nbplace+"','"+E.nom_image+"','"+E.id_categorie+"')";
            
           
            
        st.executeUpdate(query);
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void delete_Event(Evenement E) {

     
String requete = "delete from evenement where id = ?";
        try {
            PreparedStatement ps = mycon.prepareStatement(requete);
            ps.setInt(1, E.getId());
            ps.executeUpdate();
            System.out.println("Salles supprimé");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    
     
}  
       public void Modifier_Event(Evenement E) {
   

        
      PreparedStatement ps ;
            String req = "UPDATE evenement set    titre= ?,lieu= ?,description= ? ,date_event=?,nbplace= ?, nom_image= ?,id_categorie=?  where id=?";
            try {
                ps = mycon.prepareStatement(req);

                ps.setString(1, E.getTitre());
                ps.setString(2,E.getLieu());
                ps.setString(3, E.getDescription());
                ps.setDate(4, E.getDate_event());
               
                ps.setInt(5,E.getNbplace());
                ps.setString(6, E.getNom_image());
                ps.setInt(7, E.getId_categorie());
                 ps.setInt(8,E.getId());



                ps.executeUpdate();
                System.out.println("DONE UPDATE");
            } catch (SQLException ex) {
          //Logger.getLogger(BoutiqueDAO.class.getName()).log(Level.SEVERE, null, ex);

            }}
       public  ObservableList<Evenement> searchEvent(String tf){
        ObservableList myListBenef = FXCollections.observableArrayList();
        
        try {
            Statement st = mycon.createStatement();
            String str = "SELECT * FROM evenement WHERE id LIKE '%"+tf+"%'"
                        +"UNION SELECT * FROM evenement WHERE titre LIKE '%"+tf+"%'"
                        +"UNION SELECT * FROM evenement WHERE lieu LIKE '%"+tf+"%'"
                        +"UNION SELECT * FROM evenement WHERE description LIKE'%"+tf+"%'"
                        +"UNION SELECT * FROM evenement WHERE date_event LIKE '%"+tf+"%'"
                        +"UNION SELECT * FROM evenement WHERE nbplace LIKE '%"+tf+"%'"
                        +"UNION SELECT * FROM evenement WHERE nom_image LIKE '%"+tf+"%'"
                     +"UNION SELECT * FROM evenement WHERE id_categorie LIKE '%"+tf+"%'";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
            myListBenef.add(new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),
                    rs.getInt(6),rs.getString(7),rs.getInt(8)));
            }    
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de l'affichage " + ex.getMessage());
        }      
        return myListBenef;
    }
      /* public ObservableList<Evenement> searchEvent(String search) {
 String req="select * from evenement where (description like '%"+search+"%' or date_event  like '%"+search+"%' or titre  like '%"+search+"%') and date_event>=CURRENT_TIME order by date_event asc"; 
ObservableList<Evenement> list=FXCollections.observableArrayList();         
        try { Statement st = mycon.createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
               
                list.add(new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),
                    rs.getInt(6),rs.getString(7),rs.getInt(8)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }*/
 public List<Evenement> TrierTitre() {
        List<Evenement> list = new ArrayList<>();
        try {
            String sql2 = "SELECT * from evenement  order by titre ASC ";
            Statement st2 = mycon.createStatement();
            ResultSet rs = st2.executeQuery(sql2);
            while (rs.next()) {

                                Evenement e;
               e = new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),
                    rs.getInt(6),rs.getString(7),rs.getInt(8));
               list.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return list;
        
        
    }
 
    public List<Evenement> TrierDate() {
        List<Evenement> list = new ArrayList<>();
        try {
            String sql2 = "SELECT * from evenement  order by  date_event ASC ";
            Statement st2 = mycon.createStatement();
            ResultSet rs = st2.executeQuery(sql2);
            while (rs.next()) {

                                Evenement e;
               e = new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),
                    rs.getInt(6),rs.getString(7),rs.getInt(8));
               list.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return list;
        
        
    }
    public List<Evenement> TriernbPlace() {
        List<Evenement> list = new ArrayList<>();
        try {
            String sql2 = "SELECT * from evenement  order by nbplace ASC ";
            Statement st2 = mycon.createStatement();
            ResultSet rs = st2.executeQuery(sql2);
            while (rs.next()) {

                                Evenement e;
               e = new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),
                    rs.getInt(6),rs.getString(7),rs.getInt(8));
               list.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return list;
        
        
    }
    public void quantiteReduce(int idr) throws SQLException, IOException 
{
        
   
 String req1 =  "UPDATE `evenement` " + "SET `nbplace` = `nbplace`-1" + " WHERE `id`="+idr+ " and `nbplace`>"+ 0;
        try {
            PreparedStatement ste = mycon.prepareStatement(req1);
            int x = ste.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

} 
 


   
}     
