/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Evenement {

    public int id;
    public String titre;
    public String lieu;
    public String description;
    public Date date_event;
    public int nbplace;
    public String nom_image;
    public int id_categorie;

    public Evenement(int id, String titre) {
        this.id = id;
        this.titre = titre;
    }
    

    public Evenement(int id, String titre, String lieu, String description, Date date_event, int nbplace, String nom_image, int id_categorie) {
        this.id = id;
        this.titre = titre;
        this.lieu = lieu;
        this.description = description;
        this.date_event = date_event;
        this.nbplace = nbplace;
        this.nom_image = nom_image;
        this.id_categorie = id_categorie;
    }

    public Evenement(String titre, String lieu, String description, Date date_event, int nbplace, String nom_image, int id_categorie) {
        this.titre = titre;
        this.lieu = lieu;
        this.description = description;
        this.date_event = date_event;
        this.nbplace = nbplace;
        this.nom_image = nom_image;
        this.id_categorie = id_categorie;
    }

    public Evenement() {
    }

    public int getId() {
        return id;
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

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_event() {
        return date_event;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }

    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", titre=" + titre + ", lieu=" + lieu + ", description=" + description + ", date_event=" + date_event + ", nbplace=" + nbplace + ", nom_image=" + nom_image + ", id_categorie=" + id_categorie + '}';
    }

}
