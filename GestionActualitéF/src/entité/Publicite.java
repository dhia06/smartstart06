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
public class Publicite {
    private int id;
    private String titre;
    private Date date;
   
   
    private String description ;
    private String affiche;
    
  
    
    private String proprietaire;
    private int likes;

    public Publicite(int id, String titre, Date date, String description, String affiche, String proprietaire) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.description = description;
        this.affiche = affiche;
        this.proprietaire = proprietaire;
    }

    public Publicite(String titre, Date date, String description, String affiche, String proprietaire) {
        this.titre = titre;
        this.date = date;
        this.description = description;
        this.affiche = affiche;
        this.proprietaire = proprietaire;
        
    }

    public Publicite(int id, String titre, Date date, String description, String affiche, String proprietaire, int likes) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.description = description;
        this.affiche = affiche;
        this.proprietaire = proprietaire;
        this.likes = likes;
    }

    public Publicite() {
    }

    public int getId() {
        return id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }
    
    

    @Override
    public String toString() {
        return "Publicite{" + "id=" + id + ", titre=" + titre + ", date=" + date + ", description=" + description + ", affiche=" + affiche + ", proprietaire=" + proprietaire + '}';
    }

   
    }
    
    
    
    

    
