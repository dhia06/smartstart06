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
    private String nom;
    private Date datedebut;
    private Date datefin;
   
    private String description ;
    private String img;
    private int nbjours;
    private int nbclick;
    private int idprop;
    private String site;

    public Publicite(int id, String nom, Date datedebut, Date datefin, String description, String img, int nbjours, int nbclick, int idprop, String site) {
        this.id = id;
        this.nom = nom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description = description;
        this.img = img;
        this.nbjours = nbjours;
        this.nbclick = nbclick;
        this.idprop = idprop;
        this.site = site;
    }

    public Publicite(String nom, Date datedebut, Date datefin, String description, String img, int nbjours, int nbclick, int idprop, String site) {
        this.nom = nom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description = description;
        this.img = img;
        this.nbjours = nbjours;
        this.nbclick = nbclick;
        this.idprop = idprop;
        this.site = site;
    }
 
   

    public Publicite() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNbjours() {
        return nbjours;
    }

    public void setNbjours(int nbjours) {
        this.nbjours = nbjours;
    }

    public int getNbclick() {
        return nbclick;
    }

    public void setNbclick(int nbclick) {
        this.nbclick = nbclick;
    }

    public int getIdprop() {
        return idprop;
    }

    public void setIdprop(int idprop) {
        this.idprop = idprop;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "Publicite{" + "id=" + id + ", nom=" + nom + ", datedebut=" + datedebut + ", datefin=" + datefin + ", description=" + description + ", img=" + img + ", nbjours=" + nbjours + ", nbclick=" + nbclick + ", idprop=" + idprop + ", site=" + site + '}';
    }
    
    
    
    
    
}
