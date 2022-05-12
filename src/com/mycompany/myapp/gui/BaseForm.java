/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.mycompany.myapp.gui.*;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.CurrentUser;
import com.mycompany.myapp.services.UserService;

/**
 *
 * @author MINDUNITS
 */
public class BaseForm extends Form {
UserService US = new UserService();
CurrentUser CU = new CurrentUser();
    public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
         Image ProjetImage = null;
        if(isCurrentProjet()) ProjetImage = selection;
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        Image profileImage = null;
        if(isCurrentProfile()) profileImage = selection;
        
        Image Userslist = null;
        if(isCurrentUserslist()) Userslist = selection;
        
        Image Collablist = null;
        if (isCurrentCollablist()) Collablist = selection;
        
        
        Button inboxButton = new Button("Inbox", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(inboxButton, 
                new Label("18", "SideCommandNumber"));
        inbox.setLeadComponent(inboxButton);
        inbox.setUIID("SideCommand");
        inboxButton.addActionListener(e -> new Userpanel().show());
        getToolbar().addComponentToSideMenu(inbox);
        
        //getToolbar().addCommandToSideMenu("Stats", statsImage, e -> new StatsForm(res).show());
        if (CU.getCurrentUser().getType_user().equals("User")){
        getToolbar().addCommandToSideMenu("Profile", profileImage, e -> new ProfileClientForm(res).show());
        
        getToolbar().addCommandToSideMenu("Collaboration", calendarImage, e -> new CollabForm(res).show());
        getToolbar().addCommandToSideMenu("Projet", ProjetImage, e -> new ProjetForm(res).show());
       
        
        getToolbar().addCommandToSideMenu("Settings", null, e -> {});
        } 
        else if (CU.getCurrentUser().getType_user().equals("Admin")){
        getToolbar().addCommandToSideMenu("Liste utilisateurs", Userslist, e -> new Userslist(res).show());
      
        getToolbar().addCommandToSideMenu("Settings", null, e -> {});
        }
        // spacer
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
        getToolbar().addComponentToSideMenu(new Label(res.getImage("logo.png"), "Container"));
        getToolbar().addComponentToSideMenu(new Label(CU.getCurrentUser().getPrenom()+" "+CU.getCurrentUser().getNom(), "SideCommandNoPad"));
        getToolbar().addComponentToSideMenu(new Label(CU.getCurrentUser().getType_user(), "SideCommandSmall"));
        Button btn = new Button("Deconnexion", "Deconnexionbtn");
        getToolbar().addComponentToSideMenu(btn);
        btn.addActionListener((e) -> new SignInForm().show());
        
    }

        
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }
     protected boolean isCurrentProjet() {
        return false;
    }
    protected boolean isCurrentProfile() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
      protected boolean isCurrentUserslist() {
        return false;
    }
      protected boolean isCurrentCollablist() {
        return false;
    }
      
    
}
