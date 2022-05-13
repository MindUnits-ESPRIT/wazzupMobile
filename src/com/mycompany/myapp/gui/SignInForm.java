/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextArea;
import com.mycompany.myapp.gui.*;
import com.mycompany.myapp.services.CurrentUser;
import com.mycompany.myapp.services.UserService;

/**
 *
 * @author SBS
 */
public class SignInForm extends com.codename1.ui.Form {
UserService US = new UserService();
CurrentUser CU = new CurrentUser();
    public SignInForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public SignInForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField("","Email", 20, TextArea.EMAILADDR);
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField("","Password", 20, TextArea.PASSWORD);
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
        gui_Button_1.addActionListener(callback);
        gui_Button_3.addActionListener(callback);

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
            
            if(sourceComponent == gui_Button_1) {
                new SignUpForm().show();
            }
            
            if(sourceComponent == gui_Button_3) {
                new ForgotpasswordForm().show();
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Sign In");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        gui_Text_Field_2.setName("Text_Field_2");
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Container_1.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Button_3);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.setIcon(resourceObjectInstance.getImage("logo.png"));
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Sign In");
        gui_Button_2.setName("Button_2");
        gui_Button_3.setText("Forgot Your Password");
        gui_Button_3.setUIID("CenterLabelSmall");
        gui_Button_3.setName("Button_3");
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("Create New Account");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        System.out.println(gui_Text_Field_2.getText()+" ....... " +gui_Text_Field_1.getText());
         
                if (gui_Text_Field_2.getText().length() == 0) {
                    if (gui_Text_Field_1.getText().length() != 0) {
                        
                        String check =  US.login(gui_Text_Field_2.getText(), gui_Text_Field_1.getText());
                           System.out.println("CHECK TESSTT"+US.login(gui_Text_Field_2.getText(), gui_Text_Field_1.getText()));

                        if (check.equals("1")) {
                            CU.setIdCurrentUser(US.getUser(gui_Text_Field_2.getText()).get(0).getID_Utilisateur());
                            CU.setCurrentUser(US.getUser(gui_Text_Field_2.getText()).get(0));
                            Dialog.show("Authentifié avec succés ! ", "Bienvenue " + CU.getCurrentUser().getPrenom()+ " "+CU.getCurrentUser().getNom() +"!", "Entrer", null);
                             new ProfileForm().show();
                        }
                        else if (check.equals("2")){
                            CU.setIdCurrentUser(US.getUser(gui_Text_Field_2.getText()).get(0).getID_Utilisateur());
                            CU.setCurrentUser(US.getUser(gui_Text_Field_2.getText()).get(0));
                            Dialog.show("Authentifié avec succés ! ", "Bienvenue Admin " + CU.getCurrentUser().getPrenom()+ " "+CU.getCurrentUser().getNom() +"!", "Accéder a votre panel", null);
                            new ProfileForm().show();
                        }
                        else{
                          Dialog.show("Alert", "Veuillez vérifier votre login !", "Vérifier", null);
                        }
                    } else {
                        Dialog.show("Alert", "Password is invalid!", "Ok", null);
                    }
                } else {
                    Dialog.show("Alert", "E-mail is invalid!", "Ok", null);
                }

    }
    }
  
    


