/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

import java.util.Date;






/**
 *
 * @author ABIR HBECHA
 */
public class Actualite {

    private int id;
    private String titre;
    private String description;
    private String img;
    private Integer nb_click;
    private Integer etat;
    private Date date;

    public Actualite(int id, String titre, String description, String img, Integer nb_click, Integer etat, Date date) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.img = img;
        this.nb_click = nb_click;
        this.etat = etat;
        this.date = date;
    }

    public Actualite(int id, String titre, String description, String img, Date date) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.img = img;
        this.date = date;
    }
    
   

    public Actualite(int id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    public Actualite(int id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public Actualite() {
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

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getNb_click() {
        return nb_click;
    }

    public void setNb_click(Integer nb_click) {
        this.nb_click = nb_click;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Actualite(int id, String titre, String description, Integer etat) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.etat = etat;
    }

    public Actualite(int id, String titre, String description, Integer etat, Date date) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.etat = etat;
        this.date = date;
    }
    
    
}
