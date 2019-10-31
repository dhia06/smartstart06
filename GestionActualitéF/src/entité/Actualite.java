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
public class Actualite {
    
    private int id;
    private String titre;
    private Date date;
   
    private String description ;
    private String img;

    public Actualite() {
    }

    public Actualite(int id, String titre, Date date, String description, String img) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        
        this.description = description;
        this.img = img;
    }

    public Actualite(String titre, Date date, String description, String img) {
        this.titre = titre;
        this.date = date;
       
        this.description = description;
        this.img = img;
    }

    public Actualite(String titre, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Actualite(String text, Actualite a, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDate() {
        return date;
    }

   

    public String getDescription() {
        return description;
    }

    public String getimg() {
        return img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   

    public void setDescription(String description) {
        this.description = description;
    }

    public void setimg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Actualite{" + "id=" + id + ", titre=" + titre + ", date=" + date +  ", description=" + description + ", img=" + img + '}';
    }
    
    
    
    
}


