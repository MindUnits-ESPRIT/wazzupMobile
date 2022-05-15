/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import java.util.ArrayList;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Projet;
import com.mycompany.myapp.entities.Salle_Collaboration;
import com.mycompany.myapp.utils.api;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mouhib
 */
public class CollabService {

    public static CollabService instance = null;
    private ConnectionRequest req;

    public static CollabService getInstance() {
        if (instance == null) {
            instance = new CollabService();
        }
        return instance;
    }

    public CollabService() {
        req = new ConnectionRequest();
    }

    /// AJOUT ///
    public void ajouterCollab(String nom , int idu) {
        String url = api.BASE_URL + "/CollabCreer?nom=" + nom + "&id=" + idu;
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
     /// Supprimer ///
    public void supprimerCollab(String nom ) {
        String url = api.BASE_URL + "/MobileD?nom=" + nom ;
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }

    /// Affichage ///
    public ArrayList<Salle_Collaboration> afficheCollab(int idu) {
        ArrayList<Salle_Collaboration> result = new ArrayList<>();
        String url = api.BASE_URL + "/listcollabMobile?id="+idu;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();
                try {
                    Map<String, Object> mapCollab = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapCollab.get("root");
                    for (Map<String, Object> obj : listOfMaps) {
                        Salle_Collaboration collab = new Salle_Collaboration();
                        float id = Float.parseFloat(obj.get("idCollab").toString());
                        String nomCollab = obj.get("nomCollab").toString();
                        String urlCollab = obj.get("urlCollab").toString();

                        collab.setID_Collab((int) id);
                        collab.setNom_Collab(nomCollab);
                        collab.setURL_Collab(urlCollab);
                        //insert data into arraylist result
                        result.add(collab);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    }
    /// Affichage Projet ///
    public ArrayList<Projet> afficheProjet() {
        ArrayList<Projet> result2 = new ArrayList<>();
        String url = api.BASE_URL + "/affiP";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();
              
                try {
                    Map<String, Object> mapProjet = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapProjet.get("root");
                    for (Map<String, Object> obj : listOfMaps) {
                        Projet projet = new Projet();
                       
                      
                        String nomProjet = obj.get("nomProjet").toString();
                        String urlT = obj.get("urlTrello").toString();
                        String desc = obj.get("descriptionProjet").toString();
                      
                    
                        projet.setDescription(desc);
                        projet.setURL_Trello(urlT);
                        projet.setNom_Projet(nomProjet);
                        //insert data into arraylist result
                        result2.add(projet);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result2;
    }
      /// AJOUT Projet ///
    public void ajouterProjet(String nom , int idc) {
        String url = api.BASE_URL + "/PrjtMob?nom=" + nom + "&idc=" + idc;
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
     /// Supprimer Projet ///
    public void supprimerProjet(String nom ) {
        String url = api.BASE_URL + "/PrD?nom=" + nom ;
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
}
