/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entité;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Sponsoring {
   private int ref;
   private Date date_contrat;
   private String description;

    public Sponsoring(int ref, Date date_contrat, String description) {
        this.ref = ref;
        this.date_contrat = date_contrat;
        this.description = description;
    }

    public Sponsoring(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public Date getDate_contrat() {
        return date_contrat;
    }

    public void setDate_contrat(Date date_contrat) {
        this.date_contrat = date_contrat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sponsoring(Date date_contrat, String description) {
        this.date_contrat = date_contrat;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Sponsoring{" + "ref=" + ref + ", date_contrat=" + date_contrat + ", description=" + description + '}';
    }
   
   
    
      
    
}
