/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.mycompany.service.ServiceTask;

/**
 *
 * @author asus
 */
public class Affichage extends Form{
     Form f;
    SpanLabel lb;
  
    public Affichage() {
                
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceTask service=new ServiceTask();
        ListeEvent viewListEvent = new ListeEvent (service.getList2());
        viewListEvent.afficher();
        //lb.setText(service.getList2().toString());
           f.getToolbar().addCommandToRightBar("back", null, (ev)->{addEvent h=new addEvent();
        h.show();
        });
         
          
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    
}
