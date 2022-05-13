/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;
import com.codename1.components.ImageViewer;
import com.mycompany.myapp.gui.*;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.SwitchList;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.JSONParser;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.CurrentUser;
import com.mycompany.myapp.utils.api;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author SBS
 */
public class TrendingForm extends BaseForm {
CurrentUser CU = new CurrentUser();
    private Resources theme=com.codename1.ui.util.Resources.getGlobalResources();
    private  EncodedImage enc=EncodedImage.createFromImage(theme.getImage("profile_image.png"), false);
    
    public TrendingForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public TrendingForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
//        gui_separator1.setShowEvenIfBlank(true);
//        gui_Label_1_1_1.setShowEvenIfBlank(true);
//        
//        ScaleImageLabel sl = new ScaleImageLabel(resourceObjectInstance.getImage("skate-park.jpg"));
//        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
//        gui_imageContainer1.add(BorderLayout.CENTER, sl);
//        sl = new ScaleImageLabel(resourceObjectInstance.getImage("bridge.jpg"));
//        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
//        gui_imageContainer2.add(BorderLayout.CENTER, sl);
//        
//        installSidemenu(resourceObjectInstance);
//        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
//        
//        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
//        gui_LA.setIconPosition(BorderLayout.EAST);
//
//        FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_LOCATION_ON);
//        gui_newYork.setIconPosition(BorderLayout.EAST);
//        
//        gui_Text_Area_2.setRows(5);
//        gui_Text_Area_2.setColumns(100);
//        gui_Text_Area_2.setGrowByContent(false);
//        gui_Text_Area_2.setEditable(false);
//        gui_Text_Area_1.setRows(2);
//        gui_Text_Area_1.setColumns(100);
//        gui_Text_Area_1.setGrowByContent(false);
//        gui_Text_Area_1.setEditable(false);

    }

//-- DON'T EDIT BELOW THIS LINE!!!
//    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
//    private com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
//    private com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
//    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
//    private com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
//    private com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
//    private com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
//    private com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
//    private com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
//    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
//    private com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();
       Container gui_Containers;
       Container gui_Container;
       Button lbnom;
       ImageViewer imgpub;
       Button Confimer;
       Button Annuler;

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Trending");
        setName("TrendingForm");
                this.getToolbar().addCommandToRightBar("🌎", null, ev->{
        new MeteoForm(theme,this).show();
        });
       // for ()
      //  gui_Container.add(this);
        ///addComponent(gui_Containers);
        installSidemenu(resourceObjectInstance);
        System.out.println(api.BASE_URL); 
                String url=api.BASE_URL+"/publication/Mob";
         ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        
        con.addResponseListener(ee->{
        String reponse=new String(con.getResponseData());
          //  System.out.println(reponse);
            GenerateGUI(reponse);
         });
       NetworkManager.getInstance().addToQueueAndWait(con);


    }// </editor-fold>
                
    void GenerateGUI(String Src)
    {
        // JSONObject myResponse = new JSONObject(Src);
         JSONArray MYar=new JSONArray(Src);
          for (int i=0;i<MYar.length();i++)
          {
//              JSONObject JOI =;
//              System.out.println(JOI.get("fichier").toString());
//              System.out.println(JOI.get("datePublication").toString());
//              System.out.println(JOI.get("visibilite").toString());
//              System.out.println(JOI.get("description").toString());
//              System.out.println();
              add(addItem(MYar.getJSONObject(i),i));
         
              
          }
          
    }
     public Container addItem(JSONObject JOI,int index) {
         boolean FileAttach=false;
         JSONObject USEROBject =JOI.getJSONObject("idUtilisateur");
         //USER
              System.out.println(USEROBject.get("idUtilisateur"));
              System.out.println(USEROBject.get("avatar"));
        Container cnt0 =new Container(BoxLayout.x());
          String url=USEROBject.get("avatar").toString();
  URLImage urlimg=URLImage.createToStorage(enc, "avatar"+index, url);
        ImageViewer imgHand=new ImageViewer(urlimg);
        imgHand.setWidth(100);
        imgHand.setHeight(100);
        
        Container cnt1 = new Container(BoxLayout.y());
        lbnom = new Button(USEROBject.get("prenom") + " "+USEROBject.get("nom"));
        lbnom.getAllStyles().setBorder(Border.createEmpty());
        lbnom.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
        Label lbmail = new Label(JOI.get("datePublication").toString().substring(0,10));
        cnt1.add(lbnom);
        cnt1.add(lbmail);
        cnt0.addAll(imgHand,cnt1);
        TextArea Text_Area_1=new TextArea();
        Text_Area_1.setRows(2);
        Text_Area_1.setColumns(100);
        Text_Area_1.setGrowByContent(false);
        Text_Area_1.setEditable(false);
        Text_Area_1.setText(JOI.get("description").toString());
          String urlPub=api.BASE_URL+"/media/cache/ImgPublicLoad/images/posts/"+JOI.get("fichier").toString();
        if (urlPub.length()>4 && !(urlPub.contains(".gif")))
        {
            System.out.println("ENTERED FOR IMAGE");  
            URLImage urlpubL=URLImage.createToStorage(enc, "publication"+index,urlPub);
            imgpub=new ImageViewer(urlpubL);
            imgpub.setWidth(600);
            imgpub.setHeight(600);
            FileAttach=true;
        }
        
        Container cnt = new Container(BoxLayout.y());
        ComboBox<String> cb = new ComboBox<>();
        cb.setName(JOI.get("idPublication").toString());
        cb.addItem("");
        cb.addItem("Modifier cette publication");
        cb.addItem("Supprimer cette publication");
        cb.addItem("Sponsoriser cette publication");
      //  Label lbimg = new Label(theme.getImage(us.getNomimg()));
        cnt0.add(cb); //ADD FUNCTION BUTTON

  //      ImageViewer imgV=new ImageViewer(urlimg);
    //    cnt.addAll(imgV, cnt1);
    cnt.addAll(cnt0,Text_Area_1);
    if (FileAttach) cnt.add(imgpub);
//        Form f2 = new Form(BoxLayout.y());
//        Label lb1 = new Label();
//        Label lb2 = new Label();
//        f2.add(lb1);
//        f2.add(lb2);
        lbnom.addActionListener(e -> {
            System.out.println("PRINTED");
        });
//
//        f2.getToolbar().addCommandToLeftBar("back", null, ev -> {
//            hi.show();
//        });
        cb.addActionListener((e)->{
           // System.out.println(cb.getSelectedItem());
        int ID=Integer.parseInt(cb.getName());
        if (cb.getSelectedItem().toString()=="Supprimer cette publication")
                { 
//                if(Dialog.show("Confirmation", "Are you Sure you Want to Delete ", "Yes", "Cancel"))
//                {
//                     System.out.println("SUCCESS OMG");  
//                }
//                else
//                {
//                    System.out.println("okkk nope");
//                }
                Delete(ID);
                }
                else if (cb.getSelectedItem().toString()=="Modifier cette publication")
                {System.out.println("Modifier Pub "+ID);               
                 new EditPublicationForm(theme,ID,this).show();
                }
                else if  (cb.getSelectedItem().toString()=="Sponsoriser cette publication")
                {
                System.out.println("Sponsor Pub");
                Sponsor();
                }
        });
        return cnt;

    }

//-- DON'T EDIT ABOVE THIS LINE!!!

    @Override
    protected boolean isCurrentTrending() {
        return true;
    }
    
    void Delete(int indexPub)
    {
                        System.out.println(api.BASE_URL); 
         String url=api.BASE_URL+"/publication/deleteMob/"+indexPub;
         ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        


       NetworkManager.getInstance().addToQueueAndWait(con);
//                       ToastBar.Status status = ToastBar.getInstance().createStatus();
//                status.setMessage("Deleting ");
//                status.setShowProgressIndicator(true);
//                Display.getInstance().invokeAndBlock(()->{
//                Util.sleep(2000);});
                
                new TrendingForm(theme).show();
 
    }
    void Update(int indexPub)
    {
        
    }
    void Sponsor()
    {
        
    }
}
