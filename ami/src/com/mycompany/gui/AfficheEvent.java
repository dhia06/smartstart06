/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entitie.Evenement;
import com.mycompany.service.ServiceTask;

/**
 *
 * @author asus
 */
public class AfficheEvent extends Form{
     Form form;
    Label nom;
    Label lieu;
    Label description ;
    Label image;
    Label nbplace;
    Button suprimer = new Button("supprimer");
     public  AfficheEvent(Evenement evenement) {
        form = new Form("Mon evenements:", new BoxLayout(BoxLayout.Y_AXIS));
        nom = new Label("Titre: "+evenement.getTitre());
        lieu = new Label("lieu: "+evenement.getLieu());
       description = new Label("Description :"+evenement.getDescription());
        image = new Label("image : "+evenement.getNom_image());
        nbplace = new Label("nombre de place : "+Integer.toString(evenement.getNbplace()));
        form.add(nom);
        form.add(lieu);
        form.add(image);
        form.add(description);
        form.add(nbplace);
     form.getToolbar().addCommandToRightBar("back", null, (ev)->{Affichage h=new Affichage();
          
          });
     form.add(suprimer);
              suprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 ServiceTask ser = new ServiceTask();
                ser.Supprimer(evenement.getId());
                Dialog.show("Alert", "evenement "+evenement.getTitre()+" supprimé", "ok", null);
            }
            
        });
    }

  

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
    
    public void afficher() {
            this.form.show();
    }

   
    
}
