/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smart.Entity;

/**
 *
 * @author asus
 */
public class CategorieEvent {

    private int id;
    private String libelle;
    private String description;

    public CategorieEvent(int id, String libelle, String description) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
    }

    public CategorieEvent(String libelle, String description) {
        this.libelle = libelle;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategorieEvent{" + "id=" + id + ", libelle=" + libelle + ", description=" + description + '}';
    }

}
