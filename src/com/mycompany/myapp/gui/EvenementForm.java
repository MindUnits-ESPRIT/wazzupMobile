 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.io.Log;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableModel;
import com.codename1.ui.util.Resources;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mycompany.myapp.services.EvenementService;
/**
 *
 * @author SRN
 */
public class EvenementForm extends BaseForm {
    Container cntM=new Container(BoxLayout.y());
    EvenementService se= new EvenementService();
    Button Add=new Button("Ajouter un événement");
    Resources theme = Resources.getGlobalResources();
    public EvenementForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
         getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Liste des evenements", "Title")
                )
        );
    Add.addActionListener(e->{
    //ahla ?
    new EvenementAddForm(resourceObjectInstance).show();
    });
}

    public EvenementForm() {
 
    }

    private void initGuiBuilderComponents(Resources resourceObjectInstance) {
setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Evenements");
        setName("EvenementForm");  
        installSidemenu(resourceObjectInstance);
       Afficher();
       
     //  Container c = new Container(BoxLayout. y () );
     // Button btnv=new Button("Valider");
     // c.add(btnv);

    }

    private void Afficher() {
        
        JSONArray MYar=new JSONArray(se.afficher());
        
          for (int i=0;i<MYar.length();i++)
          {
              JSONObject JOI =MYar.getJSONObject(i);
             // System.out.println(JOI);
           //System.out.println(JOI.get("nomEvent"));
//           TableModel model = new DefaultTableModel(new String[] {"Nom de l'evenement", "Nombre de participants", "Type d'evenement","Visibilite","Description"}, new Object[][] {
//    {JOI.get("nomEvent"), JOI.get("nbrParticipants"), JOI.get("typeEvent"),JOI.get("eventVisibilite"),JOI.get("description")},
//
//    }) {
//        public boolean isCellEditable(int row, int col) {
//            return col != 0;
//        }
//    };
//Table table = new Table(model);
//add(table);
          //    System.out.println(JOI.get("nbrParticipants").toString());
            // System.out.println(JOI.get("dateEvent").toString());
           // System.out.println(JOI.get("typeEvent").toString());
           // System.out.println(JOI.get("eventVisibilite").toString());
            // System.out.println(JOI.get("description").toString());
           //   add(addItem(),i));
         
              cntM.add(Generate(JOI));
          }
             //   Form hi = new Form("Table", new BorderLayout());


     cntM.setScrollableX(true);
     
    addAll(Add,cntM);
    }

    private Container Generate(JSONObject JOI) {
     Container cnt=new Container(BoxLayout.x());
//     
//      Form F2=new Form("Modifier",new FlowLayout(CENTER,CENTER));
//     Label lblogin=new Label("welcome : ");
//     F2.add(lblogin);

     Label lb1=new Label(JOI.get("nomEvent").toString());
     Label lb2=new Label(JOI.get("nbrParticipants").toString());
     Label lb3=new Label(JOI.get("typeEvent").toString());
     Label lb4=new Label(JOI.get("eventVisibilite").toString());
     Label lb5=new Label(JOI.get("description").toString());
     Button btnM=new Button("Modifier");
     btnM.setName(JOI.get("id").toString());
     Button btnR=new Button("Supprimer");
     btnR.setName(JOI.get("id").toString());
     cnt.addAll(lb1,lb2,lb3,lb4,lb5,btnM,btnR);
     btnM.addActionListener(e->{
     new EvenementModifyForm(theme, Integer.parseInt(btnM.getName())).show();
       
     });
     btnR.addActionListener(e->{
         if (Dialog.show("Confirmation", "étes vous sure ?!", "Oui", "Annuler"))
         {se.Supprimer(Integer.parseInt(btnM.getName()));
         new EvenementForm(theme).show();
         }
     });
    // cnt.setPreferredSize(new Dimension(330, 300));
     return cnt;
    }
    
    
   
}