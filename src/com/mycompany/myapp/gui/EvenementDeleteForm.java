/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.EvenementService;
import static java.lang.Integer.parseInt;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author SRN
 */
public class EvenementDeleteForm extends BaseForm {
    Button Submit =new Button("Supprimer");
    
      public EvenementDeleteForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
         getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Supprimer un événement", "Title")
                )
        );

}
     private void initGuiBuilderComponents(Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Ajouter Evenement");
        setName("EvenementForm");  
        installSidemenu(resourceObjectInstance);
        LoadForm();
      Submit.addActionListener(e->{
     
     });
    }

    private void LoadForm() {
        
            
    }
    
    private void Supprimer(int idEvent){
         EvenementService se= new EvenementService();
        JSONArray MYar=new JSONArray(se.afficher());
        
          for (int i=0;i<MYar.length();i++)
          {
              JSONObject JOI =MYar.getJSONObject(i);
              System.out.println(JOI);
              }
    } 
}
