/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;
import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.gui.*;
import com.mycompany.myapp.services.CurrentUser;
import com.mycompany.myapp.services.UserService;
import com.mycompany.myapp.utils.api;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Misow3002
 */
public class AddPublicationForm  extends BaseForm{
    private int IndexP;
    Button lbnom;
    ImageViewer imgpub;
    CurrentUser CU = new CurrentUser();

     private Resources theme=com.codename1.ui.util.Resources.getGlobalResources();
    private  EncodedImage enc=EncodedImage.createFromImage(theme.getImage("No_image_available.png"), false);
           Container XCont =new Container(BoxLayout.x());
            Container YCont =new Container(BoxLayout.y());
            Container MCont =new Container(BoxLayout.y());

        public AddPublicationForm(com.codename1.ui.util.Resources resourceObjectInstance,Form previous)
        {
             initGuiBuilderComponents(resourceObjectInstance,previous);
        }
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance,Form previous) {
                   setTitle("Ajouter Publication");
        setName("FormAjouter");
                this.getToolbar().addCommandToLeftBar("<", null, ev->{
        previous.showBack();
        });
        GenerateGUI();
        }
    @Override
    protected boolean isCurrentInbox() {
        return true;
    }

    private void GenerateGUI() {
        Container cnt = new Container(BoxLayout.y());
       // JSONArray MYar=new JSONArray(reponse);
        //JSONObject JOI=MYar.getJSONObject(0);
        //JSONObject USEROBject =JOI.getJSONObject("idUtilisateur");
        Container cnt0 =new Container(BoxLayout.x());
         // String url=USEROBject.get("avatar").toString();
  //URLImage urlimg=URLImage.createToStorage(enc, "avatarEdited", url);
     //   ImageViewer imgHand=new ImageViewer(urlimg);
      //  imgHand.setWidth(100);
       // imgHand.setHeight(100);
        
        Container cnt1 = new Container(BoxLayout.y());
      //  lbnom = new Button(USEROBject.get("prenom") + " "+USEROBject.get("nom"));
//        lbnom.getAllStyles().setBorder(Border.createEmpty());
//        lbnom.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
//        cnt1.add(lbnom);
       // cnt0.addAll(imgHand,cnt1);
       cnt0.addAll(cnt1);
        TextArea Text_Area_1=new TextArea();
        Text_Area_1.setRows(2);
        Text_Area_1.setColumns(100);
        Text_Area_1.setGrowByContent(false);
        Text_Area_1.setEditable(true);
        Text_Area_1.setText("Ecrivez quelque chose");

//            URLImage urlpubL=URLImage.createToStorage(enc, "publicationEdited",urlPub);
//            imgpub=new ImageViewer(urlpubL);
//            imgpub.setWidth(600);
//            imgpub.setHeight(600);

  //      ImageViewer imgV=new ImageViewer(urlimg);
    //    cnt.addAll(imgV, cnt1);
      Button saveB=new Button("Publier");
      Button AddImg=new Button("Attachement");
    cnt.addAll(cnt0,Text_Area_1,AddImg,saveB);
    //cnt.add(imgpub);
    saveB.addActionListener(e -> {
        System.out.println("PublicationAjouté");
        String desc=Text_Area_1.getText();
        if (desc.length()==0)
        {   Dialog.show("Alert", "Veuillez Tapez quelque chose!", "Ok", null);
        
        }
        else{
        String img="NULL";
        UpdateData(desc,img);
        }
        });
    add(cnt);
    
    }

    private void UpdateData(String desc,String img) {
        if (img.length()==0 && img =="NULL" )img="NULL";
          int  id=CU.getIdCurrentUser();
       String url=api.BASE_URL+"/publication/AddMob/"+id+"?description="+desc+"&imageFile="+img;
         ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        
        con.addResponseListener(ee->{
        String reponse=new String(con.getResponseData());
           Dialog.show("Confirmation","Publication Publié avec succés" , "OK", null);
          new TrendingForm(theme).show();
          
         });
       NetworkManager.getInstance().addToQueueAndWait(con);
    }
        @Override
    protected boolean isCurrentCalendar() {
        return true;
    }
}
