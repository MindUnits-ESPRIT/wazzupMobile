/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Ahmed Guedri
 */
public class OffreForm extends BaseForm{
    Resources theme=Resources.getGlobalResources();
Container MC=new Container(BoxLayout.yCenter());
    public OffreForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
         installSidemenu(theme);
    }
     public OffreForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
         installSidemenu(resourceObjectInstance);
    }

    private void initGuiBuilderComponents(Resources resourceObjectInstance) {
        Label lb1=new Label("Nom Offre");
        TextField F1=new TextField("Offre Premium");
        Label lb2=new Label("Contenu Offre");
        TextField F2=new TextField();
          Label lb3=new Label("Duree offre");//qte
        TextField F3=new TextField();
        Button btnS=new Button("Suivant");
        MC.addAll(lb1,F1,lb2,F2,lb3,F3,btnS);
        add(MC);
        btnS.addActionListener(e->{
            String S1=F1.getText();
            String S2=F2.getText();
            int S3=Integer.parseInt(F3.getText());
         new PaiementForm(theme,this,S1,S2,S3).show();
        });
    }
}
