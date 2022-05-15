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
public class ForgotpasswordForm extends com.codename1.ui.Form {
UserService US = new UserService();
CurrentUser CU = new CurrentUser();
    public ForgotpasswordForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public ForgotpasswordForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("ForgotpasswordForm");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getContentPane().setUIID("ForgotpasswordForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField("","Email", 20, TextArea.EMAILADDR);
        private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();

    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_1.addActionListener(callback);
        gui_Button_2.addActionListener(callback);


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

            if(sourceComponent == gui_Button_1) {
                new SignInForm().show();
            }
              if(sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
            }
            
  
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Mot de passe oublié");
        setName("ForgotpasswordForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Text_Field_2.setName("Text_Field_2");
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.setIcon(resourceObjectInstance.getImage("logo.png"));
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_2.setText("Récupérer mot de passe");
        gui_Button_2.setName("Button_2");
        gui_Container_1.addComponent(gui_Button_2);
        gui_Button_1.setText("Retour");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
         System.out.println(gui_Text_Field_2.getText());
         boolean exists=UserService.getInstance().CheckMailExistance(gui_Text_Field_2.getText());
   if (gui_Text_Field_2.getText().length() != 0) {
        if (exists){
            boolean forgotpassword=UserService.getInstance().RecupererPassword(gui_Text_Field_2.getText());
            if (forgotpassword){
                 Dialog.show("Succés", "Vous venez de recevoir un nouveau mot de passe sur votre email !", "Ok", null);
            }else {
             Dialog.show("Erreur", "Un erreur s'est survenue !", "Vérifier", null);
            }
        }
        else{
           Dialog.show("Erreur", "L'email saisie n'existe pas !", "Ok", null);
        }
    } else{
          Dialog.show("Erreur", "Veuillez saisir l'email associé a votre compte !", "Ok", null);
            }
    

    }
    }
  
    



