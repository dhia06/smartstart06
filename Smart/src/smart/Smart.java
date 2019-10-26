/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smart;

import java.sql.Date;
import smart.Entity.Evenement;
import smartService.EvenementBD;

/**
 *
 * @author asus
 */
public class Smart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Evenement e1 = new Evenement( 1, "abir", "image", "tunis", "nice", new Date(16,03, 1996), 2);
        EvenementBD es = new EvenementBD();
       //es.insert(e);
     es.insertPst(e1);
      // es.readById(1);

        System.out.println(es.readAll());
       es.readAll().forEach(e -> System.out.println(e));
        System.out.println("************************");
           //es.readById(1);
           System.out.println("************************");
           //es.delete(e1, 8);
           System.out.println("************************");
           //es.update(e1, 7);
         // es.readAll().forEach(e -> System.out.println(e));
           System.out.println("************************");
           es.readById(7);
    }
    
}
