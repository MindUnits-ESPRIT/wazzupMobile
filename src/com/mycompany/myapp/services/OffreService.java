/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.utils.api;
import com.mycompany.myapp.gui.OffreForm;

/**
 *
 * @author Ahmed Guedri
 */
public class OffreService {
    public void deleteOffre(int id ) {
        String url = api.BASE_URL +"/Offre/"+id+"/delete/mobile";
        
         ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        
        con.addResponseListener(ee->{
        String reponse=new String(con.getResponseData());
          //  System.out.println(reponse);
            Dialog.show("Status","Paiement Annulé Avec Succés","ok",null);
            new OffreForm().show();
         });
       NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
