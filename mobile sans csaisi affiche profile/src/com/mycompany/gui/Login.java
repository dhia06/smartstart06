/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.SOUTH;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.Task;
import com.mycompany.Service.ServiceTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.control.Alert;

/**
 *
 * @author Lenovo
 */
public class Login {
    Form f;
    TextField tusername;
    TextField tpassword;
    Button btnLogin,register;
       SpanLabel lb1 = new SpanLabel("");
    
    
    public Login(){
         f = new Form(new FlowLayout(CENTER, CENTER));
        f.setTitle("Smartstart");
       
        tusername = new TextField("", "username");
        tpassword = new TextField("", "password");
        tpassword.setConstraint(TextField.PASSWORD);
        
        btnLogin = new Button("Login");
       register = new Button("Register your account now");
        f.add(tusername);
        f.add(tpassword);
        f.add(btnLogin);
        f.add(register);
          f.add(lb1);
        btnLogin.addActionListener((e) -> {
             if( tusername.getText().isEmpty() || tpassword.getText().isEmpty())
                 
        Dialog.show("Attention", "Veuillez remplir les champs correctement!", "ok", null);

             else{
      
     ServiceTask sl = new ServiceTask();
            
            ArrayList<Task> list = sl.getList2();
            System.out.println(list);

          int x = 0;
            for (Iterator<Task> iterator = list.iterator(); iterator.hasNext();) {
                Task next = iterator.next();  
                System.out.println(next.getPassword());
                if ((next.getUsername().equals(tusername.getText())) && ((next.getPassword()).equals(tpassword.getText()))) {
                   
                       // membre = next;
                        x = 1;
                        System.out.println("username : " + next.getUsername());
                        Accueil f = new Accueil();
                        f.getF1().show();
                   
               }
            }
            if (x == 0) {
                Dialog.show("Attention", "Username or password Incorrect", "Ok", null);
            }
        }
        });
         register.addActionListener((e) -> {
             HomeForm h = new HomeForm();
             h.getF().show();
         });
       
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
}
