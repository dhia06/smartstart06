/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entities.Actualite;
import com.mycompany.service.ServiceAjout;
import java.util.ArrayList;

/**
 *
 * @author ABIR HBECHA
 */
public class ViewListe {

  
    
    Form f;
    public ViewListe(ArrayList<Actualite> actualites) {
        
         // f = new Form("Les actualité");
         f = new Form("Liste des actualités", new BoxLayout(BoxLayout.Y_AXIS));
    //    ServiceAjout serv =new ServiceAjout();
      //  Container actualites = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
       
                    
    
  //   for(Actualite a: serv.getList())
         //{
        
          //ArrayList<Actualite> actualites = new ArrayList<>();
      
      for (Actualite actualite : actualites) {
            // ajouter label
         Label Titre = new Label("Titre : "+actualite.getTitre());
            // Titre =new Label("Titre :"+a.getTitre());
            
            Titre.addPointerPressedListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new ConsulterActualite(actualite ).afficher();
                }
            }
            );
            f.add(Titre);
         
            
        }
    }

   
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    public void afficher() {
        this.f.show();
    }
    

  
    }

    
    
    
    
   

    

  

    
    
    
   
    

