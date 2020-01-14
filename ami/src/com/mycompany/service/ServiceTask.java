/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.mycompany.Entitie.Evenement;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author asus
 */
public class ServiceTask {

    public void AddEvent(Evenement s) {
        ConnectionRequest con = new ConnectionRequest();

        System.out.println("hhhheloo:  " + s);

        String Url = "http://localhost/json/web/app_dev.php/api/new";
        //   +  s.getTitre() +"&description="+s.getDescription() +"&lieu="+s.getLieu()+"&nomImage="+s.getNom_image()+"&dateEvent="+s.getDate_event();

        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.setPost(true);
        con.addArgument("description", s.getDescription());
        con.addArgument("lieu", s.getLieu());
        con.addArgument("nom_image", s.getNom_image());
        con.addArgument("titre", s.getTitre());
        //con.addArgument("id_categorie", Integer.toString(s.getId_categorie()));
        con.addArgument("nbplace", Integer.toString(s.getNbplace()));

        con.addResponseListener((e) -> {

            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    public ArrayList<Evenement> parseListTaskJson(String json) {

        System.out.println("DEBUG, 48, parseListTaskJSON:" + json);
        ArrayList<Evenement> ListEvents = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            ListEvents.add(jsonToEvent(jsonArray.getJSONObject(i)));

        }
        System.out.println(ListEvents);
        return ListEvents;

    }

    ArrayList<Evenement> listTasks = new ArrayList<>();

    public ArrayList<Evenement> getList2() {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/json/web/app_dev.php/api/");
        con.setPost(false);
        con.addResponseListener((NetworkEvent evt) -> {
            System.out.println(con.getResponseData());
            listTasks = this.parseListTaskJson(new String(con.getResponseData()));
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

    public static void main(String[] args) {
        (new ServiceTask()).getList2();
    }

    private Evenement jsonToEvent(JSONObject jsonObject) {
        Integer id = jsonObject.getInt("id");
        String titre = jsonObject.getString("titre");
        String lieu = jsonObject.getString("lieu");

        String desc = jsonObject.getString("description");
        Integer nbp = jsonObject.getInt("nbplace");

        String img = jsonObject.getString("nomImage");

        return new Evenement(id, titre, lieu, desc, nbp, img);
    }

    public void Supprimer(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/json/web/app_dev.php/api/"+id+"/delete");
        con.setPost(false);
        con.addResponseListener((evt) -> {
            System.out.println(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
}
