/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

/**
 *
 * @author Lenovo
 */
public class Accueil {
    
    
     Form f1;
   

  

    public Accueil() {
         f1 = new Form("Accueil",new FlowLayout(Component.CENTER, Component.CENTER));
       
        Label n = new Label("Welcome in our application!");
        f1.add(n);
         f1.getToolbar().addMaterialCommandToRightSideMenu("Reclamation", FontImage.MATERIAL_WEB, (ev)->{
         Smsa s = new Smsa();
         s.getF2().show();
          });
         f1.getToolbar().addMaterialCommandToRightSideMenu("Feedback", FontImage.MATERIAL_WEB, (ev)->{
         
          });
    }

    public Form getF1() {
        return f1;
    }

    public void setF1(Form f1) {
        this.f1 = f1;
    }
    
}
