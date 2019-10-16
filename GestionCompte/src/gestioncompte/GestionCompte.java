/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompte;

import Service.UserService;
import entite.User;
import utile.DataSourcee;

/**
 *
 * @author Lenovo
 */
public class GestionCompte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataSourcee ds1 = DataSourcee.getInstance();
        System.out.println(ds1);
        DataSourcee ds2 = DataSourcee.getInstance();
        System.out.println(ds2);
        DataSourcee ds3 = DataSourcee.getInstance();
        System.out.println(ds3);
        //singletenp bon pratique de dev permet d unifie  yejma3 les instance

        User p = new User("amine", "123");
        UserService ps = new UserService();
       // ps.insert(p);
        p.setLogin("aminee");
        p.setPassword("bhjbk");
     
        System.out.println(ps.readAll());
        //affichage java8
       // ps.update(p,2);
        ps.delete(p, 3);
    }
    
}
