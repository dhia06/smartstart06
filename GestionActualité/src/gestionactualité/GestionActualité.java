/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionactualité;

import entité.Actualite;
import entité.Publicite;
import java.sql.Date;
import service.ActualiteService;
import service.PubliciteService;

/**
 *
 * @author ASUS
 */
public class GestionActualité {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        Actualite a = new Actualite("amine", new Date(13, 10, 2019), "les jeunes",  "politique");
        // Actualite a2 = new Actualite("dance", new Date(13, 10, 2019), "les jeunes", "jour exceptionnel", "culture");
        //  Actualite a3 = new Actualite("musique", new Date(13, 10, 2019), "les jeunes", "jour exceptionnel", "comédie");
     //   Publicite pub=new Publicite("bb", new Date(12, 2, 2019), new Date(12, 3, 2019), "decrip", "rr", 2, 5, 4, "aal");
  
       
      //  PubliciteService ps =new PubliciteService();
       
        ActualiteService as = new ActualiteService();
        
       // as.insert(a);
     //  as.insertPst(a);
      // ps.insertPst(pub);
       // as.insertPst(a2);
        System.out.println(as.readAll());
        as.update(a,23 );
        as.readbyid(23);
       // as.readAll().forEach(e->System.out.println(e));
        // as.delete(a, 3);
        // System.out.println(ps.readAll());
       //  ps.delete(pub, 4);
        // System.out.println(ps.readAll());
        
        
         //ps.update(pub,22);
       // System.out.println(ps.readAll());
        System.out.println("********");
      // System.out.println(as.readAll());
     // ps.readbyid(2);
     //  System.out.println("********");
       // as.readbyid(29);
        
       
       
      
      
    }

}
