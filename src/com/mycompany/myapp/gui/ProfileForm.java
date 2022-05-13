/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.mycompany.myapp.services.CollabService;
import com.mycompany.myapp.services.CurrentUser;
import com.mycompany.myapp.services.UserService;

/**
 *
 * @author SBS
 */
public class ProfileForm extends BaseForm {
        CurrentUser CU = new CurrentUser();
    CollabService CS = new CollabService();
    public ProfileForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentProfile() {
        return true;
    }
    
    
    
    public ProfileForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Profile", "Title")
                )
        );
        
        installSidemenu(resourceObjectInstance);
        
        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("logo.png"), e -> {});
        
        
        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            fab.setUIID("FloatingActionButtonClose");
            Image oldImage = fab.getIcon();
            FontImage image = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "FloatingActionButton", 3.8f);
            fab.setIcon(image);
            Dialog popup = new Dialog();
            popup.setDialogUIID("Container");
            popup.setLayout(new LayeredLayout());
            
            Button c1 = new Button(resourceObjectInstance.getImage("contact-a.png"));
            Button c2 = new Button(resourceObjectInstance.getImage("contact-b.png"));
            Button c3 = new Button(resourceObjectInstance.getImage("contact-c.png"));
            Button trans = new Button(" ");
            trans.setUIID("Container");
            c1.setUIID("Container");
            c2.setUIID("Container");
            c3.setUIID("Container");
            Style c1s = c1.getAllStyles();
            Style c2s = c2.getAllStyles();
            Style c3s = c3.getAllStyles();
            
            c1s.setMarginUnit(Style.UNIT_TYPE_DIPS);
            c2s.setMarginUnit(Style.UNIT_TYPE_DIPS);
            c3s.setMarginUnit(Style.UNIT_TYPE_DIPS);

            c1s.setMarginBottom(16);
            c1s.setMarginLeft(12);
            c1s.setMarginRight(3);

            c2s.setMarginLeft(4);
            c2s.setMarginTop(5);
            c2s.setMarginBottom(10);
            c3s.setMarginRight(14);
            
            c3s.setMarginTop(12);
            c3s.setMarginRight(16);

            popup.add(trans).
                    add(FlowLayout.encloseIn(c1)).
                    add(FlowLayout.encloseIn(c2)).
                    add(FlowLayout.encloseIn(c3));
            
            ActionListener a = ee -> popup.dispose();
            
            trans.addActionListener(a);
            c1.addActionListener(a);
            c2.addActionListener(a);
            c3.addActionListener(a);
            
            popup.setTransitionInAnimator(CommonTransitions.createEmpty());
            popup.setTransitionOutAnimator(CommonTransitions.createEmpty());
            popup.setDisposeWhenPointerOutOfBounds(true);
            int t = ProfileForm.this.getTintColor();
            ProfileForm.this.setTintColor(0);
            popup.showPopupDialog(new Rectangle(ProfileForm.this.getWidth() - 10, ProfileForm.this.getHeight() - 10, 10, 10));
            ProfileForm.this.setTintColor(t);
            fab.setUIID("FloatingActionButton");
            fab.setIcon(oldImage);
        });
    }
    
    //-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField("","Nom", 20, TextArea.ANY);
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField("","Prenom", 20, TextArea.ANY);
    private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField("","Email", 20, TextArea.EMAILADDR);
    private com.codename1.ui.TextField gui_Text_Field_4 = new com.codename1.ui.TextField("","Numero Tel", 20, TextArea.ANY);
    private Picker datePicker = new Picker();  // DATE NAISSANCE
    private com.codename1.ui.ComboBox<String> gui_comboBox = new com.codename1.ui.ComboBox<>();
    private com.codename1.ui.TextField gui_Text_Field_5 = new com.codename1.ui.TextField("","Password", 20, TextArea.PASSWORD);

    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();



// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
        gui_Button_1.addActionListener(callback);

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
                new SignInForm().show();
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Sign Up");
        setName("SignUpForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        gui_Text_Field_1.setText(CU.getCurrentUser().getNom());
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Text_Field_2.setText(CU.getCurrentUser().getPrenom());
        gui_Component_Group_1.addComponent(gui_Text_Field_3);
        gui_Text_Field_3.setText(CU.getCurrentUser().getEmail());
        gui_Component_Group_1.addComponent(gui_Text_Field_4);
        gui_Text_Field_4.setText(CU.getCurrentUser().getNum_tel());
        gui_Component_Group_1.addComponent(gui_Text_Field_5);
        gui_Component_Group_1.addComponent(gui_comboBox);
        gui_comboBox.setSelectedItem(CU.getCurrentUser().getGenre());
         gui_Component_Group_1.addComponent(datePicker);

        gui_comboBox.addItem("Male");
        gui_comboBox.addItem("Female");

        gui_Container_1.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Button_3);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Valider");
        gui_Button_2.setName("Button_2");

        gui_Button_3.setUIID("CenterLabelSmall");

    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        boolean dbvalide=UserService.getInstance().CheckDateofbirthvalidity(datePicker.getText());
        if (gui_Text_Field_1.getText().length() == 0){
           Dialog.show("Alert", "Veuillez insérer un nom!", "Ok", null);
        } else if (gui_Text_Field_2.getText().length() == 0){
            Dialog.show("Alert", "Veuillez insérer un prenom!", "Ok", null);
        } else if (gui_Text_Field_3.getText().length() == 0){
            Dialog.show("Alert", "Veuillez insérer un email!", "Ok", null);
        } else if (gui_Text_Field_4.getText().length() == 0){
            Dialog.show("Alert", "Veuillez insérer un numero de telephone!", "Ok", null);
        } else if (dbvalide==false){
           Dialog.show("Alert", "Il faut que vous soyez plus que 18 ans !", "Ok", null);
        } else if (UserService.getInstance().CheckCurrentPassword(gui_Text_Field_3.getText(),gui_Text_Field_5.getText())==false){
           Dialog.show("Alert", "Veuillez vérifier votre mot de passe courrant !", "Ok", null);
        }
        else {
        UserService.getInstance().EditCompte(gui_Text_Field_1.getText(), gui_Text_Field_2.getText(), gui_Text_Field_3.getText(),gui_Text_Field_4.getText(),gui_comboBox.getSelectedItem(),datePicker.getText());
        Dialog.show("Success","Votre compte a été bien modifié",new Command("OK"));
        }
    }
}
