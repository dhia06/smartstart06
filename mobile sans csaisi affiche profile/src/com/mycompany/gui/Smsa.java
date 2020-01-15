/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.Task;
import com.mycompany.Service.ServiceTask;
import com.teknikindustries.bulksms.SMS;



/**
 *
 * @author Lenovo
 */
public class Smsa {

    Form f2;

    public Smsa() {
        f2 = new Form("Réclamation", new FlowLayout(Component.CENTER, Component.CENTER));
        TextField text = new TextField("", "text...");
        TextField numero = new TextField("", "numéro...");
        f2.add(text);
        f2.add(numero);
       Button  envoyer = new Button("Envoyer SMS");
               f2.add(envoyer);

          envoyer.addActionListener((e) -> {
        //  SMS smsTut = new SMS();
        //  smsTut.SendSMS("karrayy", "karray123A",text.getText(),numero.getText(), "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
                                         //  "+21652476914"                                  

        });
f2.getToolbar().addCommandToLeftBar("Back", null, (ev)->{Accueil h=new Accueil();
          h.getF1().show();
          });
    }

    public Form getF2() {
        return f2;
    }

    public void setF2(Form f2) {
        this.f2 = f2;
    }

}
