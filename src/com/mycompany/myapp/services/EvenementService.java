/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.utils.api;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author SRN
 */
public class EvenementService {
    public String rep;
    public JSONObject ByFilter;
    public EvenementService() {
    }
    
    public String afficher(){
        
    System.out.println(api.BASE_URL); 
                String url=api.BASE_URL+"/evenement/list/json/"+60;
         ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        con.addResponseListener((NetworkEvent evt) -> {
            rep=new String(con.getResponseData());
    });
       NetworkManager.getInstance().addToQueueAndWait(con);
       return rep; 
    }
    
    public void Ajouter(int nbr,String nom,String date,String Type,String Event,String Desc)
    {
        date="06/13/2022";
         String url=api.BASE_URL+"/evenement/new/json?nom="+nom+"&nbr="+nbr+"&date="+date+"&type="+Type+"&event="+Event+"&desc="+Desc;
         System.out.println(url);
         ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        con.addResponseListener((NetworkEvent evt) -> {
            rep=new String(con.getResponseData());
    });
       NetworkManager.getInstance().addToQueueAndWait(con);
    }
        public void Modifier(int nbr,String nom,String date,String Type,String Event,String Desc,int INDEX)
        {
             date="06/13/2022";
             String url=api.BASE_URL+"/evenement/edit/json/"+INDEX+"?nom="+nom+"&nbr="+nbr+"&date="+date+"&type="+Type+"&event="+Event+"&desc="+Desc;
             System.out.println("url");
             ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        con.addResponseListener((NetworkEvent evt) -> {
            rep=new String(con.getResponseData());
    });
       NetworkManager.getInstance().addToQueueAndWait(con);
        }
     public void Supprimer(int idEvent){
          String url=api.BASE_URL+"/evenement/delete/json/"+idEvent;
          ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        con.addResponseListener((NetworkEvent evt) -> {
            rep=new String(con.getResponseData());
    });
       NetworkManager.getInstance().addToQueueAndWait(con);
     }
         
                
 public JSONObject SearchById(int id)
 {
     
         String url=api.BASE_URL+"/evenement/listid/json/"+id;
         ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        con.addResponseListener((NetworkEvent evt) -> {
            rep=new String(con.getResponseData());
            JSONArray Ar=new JSONArray(rep);
            ByFilter=Ar.getJSONObject(0);
    });
       NetworkManager.getInstance().addToQueueAndWait(con);
       return ByFilter;
 }
}
