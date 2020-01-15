/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.Task;


/**
 *
 * @author Lenovo
 */
public class Profile {
    Form f1;
    SpanLabel lb;

  

    public Profile() {
       
    }
    
    
    
    
      public Form getF1() {
        return f1;
    }

    public void setF1(Form f1) {
        this.f1 = f1;
    }

    void prof(Task t) {
        f1=(Form)new Form("Profile", new BoxLayout(BoxLayout.Y_AXIS));
         lb = new SpanLabel("Username : "+t.getUsername());
        f1.add(lb);
        SpanLabel lb1 = new SpanLabel("Email : "+t.getEmail());
        f1.add(lb1);
        SpanLabel lb2 = new SpanLabel("Nom : "+t.getNom());
        f1.add(lb2);
         SpanLabel lb3 = new SpanLabel("Prenom : "+t.getPrenom());
        f1.add(lb3);
       SpanLabel  lb4 = new SpanLabel("Role : "+t.getRole());
        f1.add(lb4);
        SpanLabel lb5 = new SpanLabel("Password : "+t.getPassword());
        f1.add(lb5);
        
         f1.getToolbar().addCommandToLeftBar("Log out", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
          f1.getToolbar().addCommandToRightBar("Accueil", null, (ev)->{
          Accueil a = new Accueil();
          a.getF1().show();
          });
    }
    
}
