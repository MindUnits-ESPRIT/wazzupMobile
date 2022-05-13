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

/**
 *
 * @author Ahmed Guedri
 */
public class PaiementForm extends BaseForm{

    Resources theme=Resources.getGlobalResources();
Container MC=new Container(BoxLayout.yCenter());
     public PaiementForm(com.codename1.ui.util.Resources resourceObjectInstance,Form previous,String s1,String s2,int qte) {
        initGuiBuilderComponents(resourceObjectInstance,previous,s1,s2,qte);
        
    }

    private void initGuiBuilderComponents(Resources resourceObjectInstance,Form previous,String s1,String s2,int qte) {
            this.getToolbar().addCommandToLeftBar("<", null, ev->{
        previous.showBack();
        });
        Label lb1=new Label("Choisir methode de Paiement");
        ComboBox<String> cb = new ComboBox<>();
        cb.addItem("Stripe");
        cb.addItem("Carte Credit");
        Label lb2=new Label("Prix");
        TextField F2=new TextField();
        //F2.setConstraint();

        Button btnS=new Button("Payer");
        MC.addAll(lb1,cb,lb2,F2,btnS);
        add(MC);
        btnS.addActionListener(e->{
         //CODE EL SERVICE
            System.out.println("GG ADDED");
            PaiementService AS=new PaiementService();
            int id=AS.Ajouter(s2, Integer.parseInt(F2.getText()), cb.getSelectedItem(), qte);
            new Confirmation(theme, id).show();
        });
    }
}
