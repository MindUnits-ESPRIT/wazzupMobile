/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.myapp.services.EvenementService;
import static java.lang.Integer.parseInt;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mycompany.myapp.services.EvenementService;

/**
 *
 * @author SRN
 */
public class EvenementAddForm extends BaseForm {
        Resources theme=Resources.getGlobalResources();
    Button Submit =new Button("Ajouter");
            Label L=new Label("Nom de l'événément : ");
         Label L2=new Label("Nombre de participants : ");
          Label L3=new Label("Date de l'événement : ");
           Label L4=new Label("Type de l'événement : ");
            Label L5=new Label("Visibilité : ");
             Label L6=new Label("Description : ");
             TextField TF=new TextField("", "Nom de l'événement", CENTER, CENTER);
             TextField TF2=new TextField("", "Nombre de participants", CENTER,  TextArea.NUMERIC);
             TextField TF3=new TextField("", "Date de l'événement", CENTER, CENTER);
             TextField TF4=new TextField("", "Type de l'événement", CENTER, CENTER);
             TextField TF5=new TextField("", "Visibilité", CENTER, CENTER);
             TextField TF6=new TextField("", "Description", CENTER, CENTER);
                               ComboBox<String> cb1 = new ComboBox<>();
                  ComboBox<String> cb2 = new ComboBox<>();

      public EvenementAddForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
         getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Ajouter un événement", "Title")
                )
        );

}
     private void initGuiBuilderComponents(Resources resourceObjectInstance) {
setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Ajouter Evenement");
        setName("EvenementForm");  
        installSidemenu(resourceObjectInstance);
        LoadForm();
       
     //  Container c = new Container(BoxLayout. y () );
     // Button btnv=new Button("Valider");
     // c.add(btnv);
     Submit.addActionListener(e->{
          
         EvenementService ES=new EvenementService();
     ES.Ajouter(parseInt(TF2.getText()),TF.getText(),TF3.getText(),cb1.getSelectedItem(),cb2.getSelectedItem(),TF6.getText());
        new EvenementForm(theme).show();
     });
    }

    private void LoadForm() {
        Container cntY=new Container(BoxLayout.yCenter());
        Container cntX=new Container(BoxLayout.xCenter());
        Container cntX2=new Container(BoxLayout.xCenter());
        Container cntX3=new Container(BoxLayout.xCenter());
        Container cntX4=new Container(BoxLayout.xCenter());
        Container cntX5=new Container(BoxLayout.xCenter());
        Container cntX6=new Container(BoxLayout.xCenter());
        cb1.setName("Type");
        cb2.setName("Visiblite");
        cb1.addItem("SalleCinema");
        cb1.addItem("Rencontre");
        cb2.addItem("Salle_publique");
        cb2.addItem("Salle_privee");
            cntX.addAll(L,TF);
            cntX2.addAll(L2,TF2);
            cntX3.addAll(L3,TF3);
            cntX4.addAll(L4,cb1);
            cntX5.addAll(L5,cb2);
            cntX6.addAll(L6,TF6);
            cntY.addAll(cntX,cntX2,cntX3,cntX4,cntX5,cntX6);
            add(cntY);
            add(Submit);
//           Validator val = new Validator();
//            val.addConstraint(TF, new LengthConstraint(2));
//            val.addConstraint(TF2, new NumericConstraint(true));
//                        val.addConstraint(TF4, new LengthConstraint(2));
//
//                                    val.addConstraint(TF5, new LengthConstraint(2));
//
//                                                val.addConstraint(TF6, new LengthConstraint(2));
//            
            //haw normalement chnowa ta3mel !
    }
    
    private void Ajouter(int nbr,String nom,String date,String Type,String Event,String Desc){
         EvenementService se= new EvenementService();
        JSONArray MYar=new JSONArray(se.afficher());
        
          for (int i=0;i<MYar.length();i++)
          {
              JSONObject JOI =MYar.getJSONObject(i);
              System.out.println(JOI);
              }

    }
}
