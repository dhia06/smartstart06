/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author asus
 */
public class AvisEvent {
     private int  id;
      private String etat;
    private String commentaire;

    public AvisEvent(int id, String etat, String commentaire) {
        this.id = id;
        this.etat = etat;
        this.commentaire = commentaire;
    }

    public AvisEvent(String etat, String commentaire) {
        this.etat = etat;
        this.commentaire = commentaire;
    }

    public AvisEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "AvisEvent{" + "id=" + id + ", etat=" + etat + ", commentaire=" + commentaire + '}';
    }
    
}
