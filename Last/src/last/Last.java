/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package last;

import Entity.Evenement;
import Service.EvenementBD;
import java.sql.Date;

/**
 *
 * @author asus
 */
public class Last {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Evenement e=new Evenement(7, "ami", "balilove", "description", new Date(16, 03, 1996), 16, "nom_image", 16);
        EvenementBD es=new EvenementBD();
       // System.out.println(es.afficherEvent());
       // es.ajouterEvent(e);
      // es.delete_Event(e);
         
        // System.out.println("****************************");
       // es.Modifier_Event(e);
     //  es.searchEvent("khaoula");
      es.TrierTitre();
      es.TriernbPlace();
    
       
       //System.out.println(es.afficherEvent());
    }
    
}
