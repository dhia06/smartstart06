/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.Entities.Actualite;
import com.mycompany.myapp.MyApplication;
import com.mycompany.service.ServiceAjout;

/**
 *
 * @author ABIR HBECHA
 */
public class ConsulterActualite {
    
    
       Form f;
    Label titre;
  Label description;
    Label etat;
   // Button supprimer=new Button("supprimer");
   
    ImageViewer img;
    Button btsupprimer;

    //static Actualite art = new Actualite();

     public ConsulterActualite(Actualite actualite)  {
         
        f = new Form("NOTRE ACTUALITE");

        ServiceAjout serv =new ServiceAjout();
       // Container actualites = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
       
                    
    
       // for(Actualite a: serv.getList())
         {
       //  Container rechercher = new Container(new BoxLayout(BoxLayout.X_AXIS));   
        // Container imag = new Container(new BoxLayout(BoxLayout.X_AXIS));
        // Container detailsC = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       
           // img= new ImageViewer();
           // EncodedImage palceHolder = EncodedImage.createFromImage(Image.createImage(f.getWidth()/2, f.getWidth() / 2), true);
            //URLImage urlImage = URLImage.createToStorage(palceHolder, a.getImg(), "http://localhost/mobile/web/images/" + a.getImg());
           // img.setImage(urlImage);
           
           
           
          //    EncodedImage palceHolder = EncodedImage.createFromImage(Image.createImage(f.getWidth()/2, f.getWidth() / 2), true);
        // URLImage imgUrl = URLImage.createToStorage(palceHolder, "http://localhost/mobile/web/images" + a.getImg().substring(a.getImg().lastIndexOf("/") + 1),
           //        "http://localhost/mobile/web/images" + a.getImg().substring(a.getImg().lastIndexOf("/") + 1));
           // ScaleImageButton btn = new ScaleImageButton(imgUrl);
           // btn.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
          // f.add(img);
            
            titre =new Label("Titre :"+actualite.getTitre());
           // titre.getAllStyles().setFgColor(0x0D0F73);
            description= new Label("Description :"+actualite.getDescription());
          //  description.getAllStyles().setFgColor(0x0D0F73);
            etat =new Label("Etat :"+actualite.getEtat());
           // etat.getAllStyles().setFgColor(0x0D0F73);
            //prix = new Label("Prix :"+a.getPrix());
          //  prix.getAllStyles().setFgColor(0x0D0F73);
          //  nbplace = new Label("Nombre de place :"+a.getNbplace());
            //nbplace.getAllStyles().setFgColor(0x0D0F73);
           btsupprimer = new Button("Supprimer");
           // btsupprimer.getAllStyles().setFgColor(0x7F1C44);
            // nomSalle.setText(a.getNomSalle());
           // Etage.setText(a.getEtage()); 
           // typeSalle.setText(a.getTypeSalle());
           // prix.setText(a.getPrix());
           // nbplace.setText(a.getNbplace());

            f.add(titre);
             f.add(description);
            f.add(etat);
           f.add(btsupprimer);
             f.getToolbar().addCommandToRightBar("back", null, (ev)->{Affichage h=new Affichage();
          
          });
            // detailsC.add(prix);
            // detailsC.add(nbplace);
            // detailsC.add(btsupprimer); 
            // imag.add(detailsC);
          //  f.add(detailsC);
           //  actualites.add(imag);
              /*supprimer.addActionListener((e) -> {
                        ServiceAjout ser = new ServiceAjout();
                        ser.Supprimer(a.getId());
                       (new ConsulterActualite()).f.show();

                    });*/
   btsupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ServiceAjout serve = new ServiceAjout();
                serve.Supprimer(actualite.getId());
                Dialog.show("Alert", "actualite "+actualite.getTitre()+" supprimé", "ok", null);

            }
        });
             
         }
     //  f.add(actualites);
        f.show();
    
        
     
     }

  
  ////////////com

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Label getTitre() {
        return titre;
    }

    public void setTitre(Label titre) {
        this.titre = titre;
    }

    public Label getDescription() {
        return description;
    }

    public void setDescription(Label description) {
        this.description = description;
    }

    public Label getEtat() {
        return etat;
    }

    public void setEtat(Label etat) {
        this.etat = etat;
    }

    public ImageViewer getImg() {
        return img;
    }

    public void setImg(ImageViewer img) {
        this.img = img;
    }

  
  
    
    public void afficher() {
        this.f.show();
    }
    
    
   
}

    

