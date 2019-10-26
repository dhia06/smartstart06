/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import entite.Projet.java;
import java.util.Objects;

/**
 *
 * @author wiemhjiri
 */
public class Projet {

    private int id;
    private String titre;
    private String objectif;
    private String duree;
    private String description;

    public Projet(String titre, String objectif, String duree, String description) {
        this.titre = titre;
        this.objectif = objectif;
        this.duree = duree;
        this.description = description;
    }

   

    public Projet(int id, String titre, String objectif) {
        this.id = id;
        this.titre = titre;
        this.objectif = objectif;
    }

    public Projet(String titre, String objectif) {
        this.titre = titre;
        this.objectif = objectif;
    }

    public Projet(int id, String titre, String objectif, String duree, String description) {
        this.id = id;
        this.titre = titre;
        this.objectif = objectif;
        this.duree = duree;
        this.description = description;
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

    public void setTitre(String nom) {
        this.titre = titre;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String prenom) {
        this.objectif = objectif;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Projet{" + "id=" + id + ", titre=" + titre + ", objectif=" + objectif + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Projet other = (Projet) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return true;
    }

    static class java {

        public java() {
        }
    }

   

}
