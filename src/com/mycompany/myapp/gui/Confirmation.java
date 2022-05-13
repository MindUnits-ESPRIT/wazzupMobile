/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.PaiementService;
import com.mycompany.myapp.services.OffreService;

/**
 *
 * @author Ahmed Guedri
 */
public class Confirmation extends BaseForm{

    Resources theme=Resources.getGlobalResources();
Container MC=new Container(BoxLayout.yCenter());
     public Confirmation(com.codename1.ui.util.Resources resourceObjectInstance,int id) {
        initGuiBuilderComponents(resourceObjectInstance,id);
        
    }

    private void initGuiBuilderComponents(Resources resourceObjectInstance,int id) {
        Label lb1=new Label("Le Paiement a été effectué avec succés");

        //F2.setConstraint();
        Container cx=new Container (BoxLayout.xCenter());
        Button btnS=new Button("Annuler Offre");
        Button btnA=new Button("Acceuil");
        cx.addAll(btnS,btnA);
        MC.addAll(lb1,cx);
        add(MC);
        btnS.addActionListener(e->{
            OffreService OS=new OffreService();
            OS.deleteOffre(id);
            
        });
        btnA.addActionListener(ee->{
        new OffreForm(theme).show();
        });
    }
}
