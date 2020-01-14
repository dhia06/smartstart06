/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entitie.Evenement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class ListeEvent extends Form{
     Form form;
     Button ajouter= new Button("ajout");
    public ListeEvent(ArrayList<Evenement> Events) {
        form = new Form("Liste des event", new BoxLayout(BoxLayout.Y_AXIS));
        for (Evenement evenement : Events) {
            // ajouter label
            Label eventLabel = new Label("Evenement: "+evenement.getTitre());
            eventLabel.addPointerPressedListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new AfficheEvent(evenement).afficher();
                }
            }
            );
            form.add(eventLabel);
             
         
        }
        form.add(ajouter);
        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
         new addEvent().AddEvent().show();
            }
        });
        
          
       
        
        
    }
    
    public void afficher() {
        this.form.show();
    }
    
        
    
}
