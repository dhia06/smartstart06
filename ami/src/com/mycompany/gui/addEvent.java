/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextComponent;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.ImageIO;
import com.mycompany.Entitie.Evenement;
import com.mycompany.service.ServiceTask;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 *
 * @author asus
 */
public class addEvent extends Form{
String imgname;


 
    public Form AddEvent() {
        TextModeLayout tl = new TextModeLayout(3, 2);
        Form c = new Form("Ajouter un evenement", tl);
        TextComponent titre = new TextComponent().label("titre").multiline(true);
        TextComponent lieu = new TextComponent().label("lieu");
         TextComponent nbplace = new TextComponent().label("nbplace");
        TextComponent description= new TextComponent().label("description").multiline(true);
       TextComponent categorie = new TextComponent().label("categorie").multiline(true);
        
       // TextComponent etage = new TextComponent().label("Etage de la salle");

        Button addimg = new Button("Ajouter une photo");

        Image defaultAvatar = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, "InputAvatarImage", 8);
        Image circleMaskImage = Image.createImage(250, 200);
        defaultAvatar = defaultAvatar.scaled(circleMaskImage.getWidth(), circleMaskImage.getHeight());
        defaultAvatar = ((FontImage) defaultAvatar).toEncodedImage();
        Object circleMask = circleMaskImage.createMask();
        defaultAvatar = defaultAvatar.applyMask(circleMask);
        addimg.setIcon(defaultAvatar);
        addimg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Dialog.show("Camera or Gallery", "Would you like to use the camera or the gallery for the picture?", "Camera", null)) {
                    String pic = Capture.capturePhoto();
                    if (pic != null) {
                        try {
                            Image img = Image.createImage(pic).fill(circleMaskImage.getWidth(), circleMaskImage.getHeight());
                            addimg.setIcon(img.applyMask(circleMask));
                            Random randomGenerator = new Random();

                            int randomInt = randomGenerator.nextInt(19999999);
                            String devisnamee = String.valueOf(randomInt) + ".jpg";
                            imgname = devisnamee;

                            System.out.println(FileSystemStorage.getInstance().getAppHomePath());
                            String imageFile = "file://C:\\wamp6\\www\\sprint" + devisnamee;
                            try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile);) {
                                ImageIO.getImageIO().save(img, os, ImageIO.FORMAT_PNG, 1);
                            } catch (IOException err) {
                                System.out.println(err.getMessage());
                            }
                        } catch (IOException err) {
                            ToastBar.showErrorMessage("An error occured while loading the image: " + err);
                            System.out.println(err.getMessage());
                        }
                    }
                }
            }
        });

        Picker date = new Picker();
        Button add = new Button("Ajouter");
        Button btnaff = new Button("afficher");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              ServiceTask sc = new ServiceTask();
               Evenement s = new Evenement();
                
                s.setTitre(titre.getText());
                s.setLieu(lieu.getText());
                  s.setNbplace(Integer.valueOf(nbplace.getText()));

                s.setDescription(description.getText());
                s.setNom_image(imgname);
                s.setId_categorie(Integer.valueOf(categorie.getText()));
                //s.setDate_Event(date.getDate());
             
                sc.AddEvent(s);
                ToastBar.showMessage(s.getTitre() + " est maintenant disponible", FontImage.MATERIAL_MESSAGE);
                new addEvent().AddEvent().show();
            }
        });
         btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
       
        
        });

        c.add(tl.createConstraint().horizontalSpan(2), titre);
        c.add(tl.createConstraint().horizontalSpan(2), lieu);
           c.add(tl.createConstraint().horizontalSpan(2), nbplace);
        c.add(tl.createConstraint().horizontalSpan(2), description);
       c.add(tl.createConstraint().horizontalSpan(2), categorie);

       

        c.add(addimg);
        c.add(date);
        c.add(add);
        c.add(btnaff);
        return c;
    }

  
}
