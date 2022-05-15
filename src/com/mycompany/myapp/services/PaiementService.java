/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.mycompany.myapp.utils.api;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Ahmed Guedri
 */
public class PaiementService {
     int resultid;
    public int  Ajouter(String contenu , int qte,String mtd,int prix)
    {
       CurrentUser CU = new CurrentUser();
        System.out.println(api.BASE_URL); 
        int id=CU.getIdCurrentUser();
                String url=api.BASE_URL+"/Offre/new/mobile/"+id+"?contenu="+contenu+"&qte="+qte+"&methodePaiement="+mtd+"&prix="+prix;
         ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        
        con.addResponseListener(ee->{
        String reponse=new String(con.getResponseData());
          //  System.out.println(reponse);
            JSONObject MYar=new JSONObject(reponse);
            resultid=Integer.parseInt(MYar.get("idOffre").toString());
            Dialog.show("Status","Paiement Effectué Avec Succés","Merci",null);
         });
       NetworkManager.getInstance().addToQueueAndWait(con);
       return resultid;
    }
}
