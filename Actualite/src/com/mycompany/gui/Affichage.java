/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.mycompany.service.ServiceAjout;

/**
 *
 * @author ABIR HBECHA
 */
public class Affichage {
    
  Form f;
    SpanLabel lb;
  
    public Affichage() {
                
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceAjout service=new ServiceAjout();
        ViewListe viewListe = new ViewListe(service.getList());
        viewListe.afficher();
        //lb.setText(service.getList2().toString());
         //  f.getToolbar().addCommandToRightBar("back", null, (ev)->{AjoutForm h=new AjoutForm();
       // h.getF().show();
        };

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public SpanLabel getLb() {
        return lb;
    }

    public void setLb(SpanLabel lb) {
        this.lb = lb;
    }
         
          
    }

 


