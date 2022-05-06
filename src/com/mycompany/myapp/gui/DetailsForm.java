/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.mycompany.myapp.gui.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;

/**
 *
 * @author SBS
 */
public class DetailsForm extends com.codename1.ui.Form {

    public DetailsForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public DetailsForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        setToolbar(new Toolbar(true));
        initGuiBuilderComponents(resourceObjectInstance);
        Form last =  Display.getInstance().getCurrent();
        getToolbar().setBackCommand("", e -> last.show());
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setTitle("DetailsForm");
        setName("DetailsForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
