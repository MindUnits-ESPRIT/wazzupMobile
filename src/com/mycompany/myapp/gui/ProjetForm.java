package com.mycompany.myapp.gui;
import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.mycompany.myapp.entities.Projet;
import com.mycompany.myapp.entities.Salle_Collaboration;
import com.mycompany.myapp.services.CollabService;
import com.mycompany.myapp.services.CurrentUser;

import java.util.ArrayList;

/**
 *
 * author Mouhib
 */
public class ProjetForm extends BaseForm {
       
CurrentUser CU = new CurrentUser();
    CollabService CS = new CollabService();
     ArrayList<Projet> projet = new ArrayList<>();
     
   
//int id = CU.getIdCurrentUser();
    public ProjetForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
    }

    
    @Override
    protected boolean isCurrentProject() {
        return true;
    }
    
    public ProjetForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        initGuiBuilderComponents(resourceObjectInstance);
        projet = CS.afficheProjet();
        System.out.println(projet);
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Projets", "Title")
                )
        );
        installSidemenu(resourceObjectInstance);
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logo.png"), e -> {
        });
        
    gui_Container2.setHeight(50);
        //table
        Object[][] rows = new Object[projet.size()][];
            for( int i = 0  ; i < rows.length ;i++){
                rows[i] = new Object[] {
                      projet.get(i).getNom_Projet(),projet.get(i).getURL_Trello()
                };
                  }
            TableModel model = new DefaultTableModel(new String[] {"NomP", "URL"},rows) {
                public boolean isCellEditable(int row, int col) {
                return col != 0;
        }
                    
              };
            
            Table table = new Table(model) {
               
   
      
    
                
                @Override
                protected TableLayout.Constraint createCellConstraint(Object value, int row, int column) { 
                    TableLayout.Constraint con =  super.createCellConstraint(value, row, column);
                          if( column == 1) {
                    con.setWidthPercentage(70);
                          }
                             if( column == 0) {
                    con.setWidthPercentage(20);}
                            
                    return con; 
                } 
                
            };  add(table);       
  }

    private com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
      private com.codename1.ui.Container gui_Container3 = new com.codename1.ui.Container(new BorderLayout());
      private com.codename1.ui.Container gui_Container4 = new com.codename1.ui.Container(new BorderLayout());
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
     private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.TextField txtfild  = new com.codename1.ui.TextField("", "Nom Projet", 20, TextArea.EMAILADDR);
    
  
    
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
private void guiBuilderBindComponentListeners() { 
        ProjetForm.EventCallbackClass callback = new ProjetForm.EventCallbackClass();
        gui_Button_2.addActionListener(callback); 
          gui_Button_3.addActionListener(callback); 
         gui_Button_3.getAllStyles().setMarginTop(0);
      
    } 
 
class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }
        public EventCallbackClass() {
        }
        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }
            if(sourceComponent == gui_Button_2) { 
                onButton_2ActionEvent(ev);
            }  
              if(sourceComponent == gui_Button_3) { 
                onButton_3ActionEvent(ev);
            }             
        }
        public void dataChanged(int type, int index) {
        }
    }
 public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        System.out.println(txtfild.getText()+" ....... ") ;
         if ((txtfild.getText().length() != 0)) { 
             CS.ajouterProjet(txtfild.getText(), 226);
             
            
               Dialog.show("Done ! ", "Projet "+txtfild.getText()+" cr??er" , "Entrer", null); 
                new ProjetForm().show();
   

               
                        }  else  {
                        Dialog.show("Alert", "must not be empty", "Ok", null);
                     }                  
    }
public void onButton_3ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        System.out.println(txtfild.getText()+" ....... ") ;
         if ((txtfild.getText().length() != 0)) { 
        
             
         CS.supprimerProjet(txtfild.getText());
               Dialog.show("Done ! ", "Projet "+txtfild.getText()+" supprimer" , "Entrer", null); 
                new ProjetForm().show();
   

               
                        }  else  {
                        Dialog.show("Alert", "must not be empty", "Ok", null);
                     }                  
    }



    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS)); 
        setTitle("Projets"); 
        setName("Projet"); 
        gui_Label_7.setText("C??er collaboration"); 
        addComponent(gui_Label_7); 
        addComponent(gui_Container_1_1); 
         addComponent(gui_Container2); 
         addComponent(gui_Container4); 
          addComponent(gui_Container3); 
        gui_Container_1_1.setName("Container_1_1"); 
        gui_Container_1_1.setName("Container2"); 
        gui_Container_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER,txtfild); 
        gui_Container2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER,gui_Button_2); 
        gui_Container4.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER,gui_Button_3); 
        gui_Button_2.setText("Cr??er"); 
        gui_Button_2.setName("Button_2"); 
        gui_Button_3.setText("Supprimer"); 
        gui_Button_3.setName("Button_3");
         gui_Container2.setHeight(50);
      
      

    
     
       

    }// </editor-fold> 

}
