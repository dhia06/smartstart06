/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart;

import entite.Projet;
import entite.Projet;
import service.ProjetService;
import service.ProjetService;
import utils.DataSource;

/**
 *
 * @author wiemhjiri
 */
public class SmartStart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // DataSource ds1=DataSource.getInstance();
        //System.out.println(ds1);
       //DataSource ds2=DataSource.getInstance();
        //System.out.println(ds2);
        //DataSource ds3=DataSource.getInstance();
        //System.out.println(ds3);

       Projet p = new Projet(1, "pidev", "4mille", "3mois", "des");
        ProjetService ps = new ProjetService();
        ps.insert(p);
        ps.insertPst(p);
       ps.readById(1);

        System.out.println(ps.readAll());
       ps.readAll().forEach(e -> System.out.println(e));
       
         
          System.out.println("************************");
         //  ps.delete(p, 1);
           //System.out.println("************************");
          // ps.update(p, 10);
           
    }

}
