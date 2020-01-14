/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entities.Actualite;
import com.mycompany.service.ServiceAjout;
import java.util.Date;

/**
 *
 * @author ABIR HBECHA
 */ 
public class Ajout {
    
    Form f;
    TextField ttitre;
    TextField tdescription;
    TextField tetat;
  
    Picker Date = new Picker();
    Button btnajout, btnaff;
    
   
    public Ajout(){
        f = new Form("Ajouter une actualité");
        ttitre = new TextField("", "titre");
        tdescription = new TextField("", "description");
        tetat = new TextField("", "etat");
               Date.setType(Display.PICKER_TYPE_CALENDAR);
Date.setDate(new Date());
        btnajout=new Button("Ajouter");
        btnaff=new Button("Afficher");
        
        f.add(ttitre);
        f.add(tdescription);
         f.add(tetat);
         f.add(Date);
        f.add(btnajout);
        f.add(btnaff);
        
         btnajout.addActionListener((e) -> {
             ServiceAjout ser = new ServiceAjout();
             Actualite t = new Actualite(0,ttitre.getText(),tdescription.getText(),Integer.parseInt(tetat.getText()),Date.getDate());
            ser.ajouterTicket(t);
     
         });
         btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
        
        });
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTtitre() {
        return ttitre;
    }

    public void setTtitre(TextField ttitre) {
        this.ttitre = ttitre;
    }

    public TextField getTdescription() {
        return tdescription;
    }

    public void setTdescription(TextField tdescription) {
        this.tdescription = tdescription;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }

    public Button getBtnaff() {
        return btnaff;
    }

    public void setBtnaff(Button btnaff) {
        this.btnaff = btnaff;
    }
}
