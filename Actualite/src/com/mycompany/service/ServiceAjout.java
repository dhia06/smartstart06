/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entities.Actualite;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author ABIR HBECHA
 */
public class ServiceAjout {
    
 /*   public void ajoutactualite(Actualite a){
         ConnectionRequest con = new ConnectionRequest();
          String Url = "http://localhost/mobile/web/app_dev.php/actualite/new";
            con.setUrl(Url);
           
        
         con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }*/
    
       public void ajouterTicket(Actualite obj) {

        ConnectionRequest con = new ConnectionRequest();

       /*  String Url ="http://localhost/www/PIDEVWEBB/web/app_dev.php/new?nomSalle="
                +obj.getNomSalle()+"&nbplace=3"
                +"&prix="
                +obj.getPrix()+"&typeSalle=13"
              +"&etage"+obj.getEtage();*/
       
        String Url ="http://localhost/mobile/web/app_dev.php/new?titre="
                +obj.getTitre()
             
                +"&description="+obj.getDescription()
                +"&etat="+obj.getEtat()
                 +"&date="+obj.getDate();
              //  +"&image="+obj.getImage()
           //   +"&etage="+obj.getEtage();
        con.setUrl(Url);
      
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        con.setDisposeOnCompletion(dlg);
       NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
    
 public ArrayList<Actualite> parseListTaskJson(String json) {

        System.out.println("DEBUG, 48, parseListTaskJSON:" + json);
        ArrayList<Actualite> ListActualites = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
             ListActualites.add(jsonToActualite(jsonArray.getJSONObject(i)));
            
        }
          System.out.println(ListActualites);
        return ListActualites;

    }

    ArrayList<Actualite> listTasks = new ArrayList<>();

    
     public ArrayList<Actualite> getList() {
     
             ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/web/app_dev.php/all");
        con.setPost(false);
          con.addResponseListener((NetworkEvent evt) -> {
            System.out.println(con.getResponseData());
            listTasks = this.parseListTaskJson(new String(con.getResponseData()));
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
     public static void main(String[] args) {
        (new ServiceAjout()).getList();
    }
     

     private Actualite jsonToActualite(JSONObject jsonObject) {
      Integer id = jsonObject.getInt("id");
        String titre = jsonObject.getString("titre");
        String description = jsonObject.getString("description");
       
        
        
        return  new Actualite(id, titre, description);
    
    }
     
     
     public void Supprimer(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/web/app_dev.php/"+id+"/delete");
        con.setPost(false);
        con.addResponseListener((evt) -> {
            System.out.println(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
    
    
   

    }
      
 
    

