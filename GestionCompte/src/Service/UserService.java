/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utile.DataSourcee;

/**
 *
 * @author Lenovo
 */
public class UserService {
     private Connection cnx;
private Statement ste;
private ResultSet rs;
 private PreparedStatement pst;
    public UserService() {
        cnx=DataSourcee.getInstance().getConnexion();
    }
    
    public void insert(User p){
        try {
            String req="insert into User (login,password) values ('"+p.getLogin()+"','"+p.getPassword()+"')";
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
  // public void insertPst()autre methode
    public List<User> readAll(){
        String req="select * from User";
            List<User> list=new ArrayList<>();
        try {
            
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new User(rs.getInt("id"),rs.getString("login"),rs.getString("password")));
            }
                    } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
     public void update(User p,int id){
         try {
            String requette = "UPDATE User SET login=?,password=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setString(1, p.getLogin());
            pst.setString(2, p.getPassword());
            pst.setInt(3, id);
            pst.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");
        }

                
    }
     public void delete(User p,int id) {
           String requette = "DELETE FROM User where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("delet success");
        } catch (SQLException ex) {
            System.out.println("error of delete");
        }
     }
    
}
