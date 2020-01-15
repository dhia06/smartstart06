/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.CN;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.SOUTH;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Service.ServiceTask;
import com.mycompany.Entite.Task;
import javafx.scene.control.Alert;

/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField tusername;
    TextField temail;
    TextField tnom;
    TextField tprenom;
    TextField trole;
    TextField tpassword;
    Button btnajout, btnaff;

    public HomeForm() {
        f = new Form("Home",new FlowLayout(Component.CENTER, Component.CENTER));
        tusername = new TextField("", "username");
        temail = new TextField("", "email");
        tnom = new TextField("", "nom");
        tprenom = new TextField("", "prenom");
        trole = new TextField("", "role");
        tpassword = new TextField("", "password");
         tpassword.setConstraint(TextField.PASSWORD);

        btnajout = new Button("ajouter");
        btnaff = new Button("Affichage");
        f.add(tusername);
                f.add(temail);
        f.add(tnom);
        f.add(tprenom);
        f.add(trole);
        f.add(tpassword);

       
        f.add(btnajout);
        f.add(btnaff);
        btnajout.addActionListener((e) -> {
             if( tnom.getText().isEmpty() || tusername.getText().isEmpty()
                 || temail.getText().isEmpty() || tprenom.getText().isEmpty() || trole.getText().isEmpty() || tpassword.getText().isEmpty() )
         
          
                    Dialog.show("Attention", "Veuillez remplir les champs correctement!", "ok", null);

            else{
            ServiceTask ser = new ServiceTask();
            Task t = new Task(tusername.getText(), temail.getText(),tnom.getText(),tprenom.getText(),trole.getText(),tpassword.getText());
            ser.ajoutTask(t);
        }
        });
        btnaff.addActionListener((e) -> {
          //  Affichage a = new Affichage();
           // a.getF().show();
                       Task t = new Task(tusername.getText(), temail.getText(),tnom.getText(),tprenom.getText(),trole.getText(),tpassword.getText());

           Profile pro = new Profile();
            pro.prof(t);
           pro.getF1().show();
           
           
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

    public TextField getTusername() {
        return tusername;
    }

    public void setTusername(TextField tusername) {
        this.tusername = tusername;
    }

    public TextField getTemail() {
        return temail;
    }

    public void setTemail(TextField temail) {
        this.temail = temail;
    }

    public TextField getTprenom() {
        return tprenom;
    }

    public void setTprenom(TextField tprenom) {
        this.tprenom = tprenom;
    }

    public TextField getTrole() {
        return trole;
    }

    public void setTrole(TextField trole) {
        this.trole = trole;
    }

    public TextField getTpassword() {
        return tpassword;
    }

    public void setTpassword(TextField tpassword) {
        this.tpassword = tpassword;
    }

}
