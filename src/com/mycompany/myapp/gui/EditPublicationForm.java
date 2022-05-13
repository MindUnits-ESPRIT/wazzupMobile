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
import com.mycompany.myapp.services.UserService;
import com.mycompany.myapp.utils.api;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author Misow3002
 */
public class EditPublicationForm  extends BaseForm{
    private int IndexP;
    Button lbnom;
    ImageViewer imgpub;
     private Resources theme=com.codename1.ui.util.Resources.getGlobalResources();
    private  EncodedImage enc=EncodedImage.createFromImage(theme.getImage("No_image_available.png"), false);
           Container XCont =new Container(BoxLayout.x());
            Container YCont =new Container(BoxLayout.y());
            Container MCont =new Container(BoxLayout.y());

        public EditPublicationForm(com.codename1.ui.util.Resources resourceObjectInstance,int indexP,Form previous)
        {
             initGuiBuilderComponents(resourceObjectInstance,indexP,previous);
        }
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance,int indexP,Form previous) {
            IndexP=indexP;
            System.out.println("you INDEX :"+IndexP);
                   setTitle("Modifier Publication");
        setName("FormModifier");
       // for ()
      //  gui_Container.add(this);
        ///addComponent(gui_Containers);
        this.getToolbar().addCommandToLeftBar("<", null, ev->{
        previous.showBack();
        });
        System.out.println(api.BASE_URL); 
                String url=api.BASE_URL+"/publication/LoadPub/"+IndexP;
         ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        
        con.addResponseListener(ee->{
        String reponse=new String(con.getResponseData());
          //  System.out.println(reponse);
            GenerateGUI(reponse,IndexP);
         });
       NetworkManager.getInstance().addToQueueAndWait(con);
        }
    @Override
    protected boolean isCurrentInbox() {
        return true;
    }

    private void GenerateGUI(String reponse,int index) {
        Container cnt = new Container(BoxLayout.y());
        boolean FileAttach=false;
        JSONArray MYar=new JSONArray(reponse);
        JSONObject JOI=MYar.getJSONObject(0);
        JSONObject USEROBject =JOI.getJSONObject("idUtilisateur");
        Container cnt0 =new Container(BoxLayout.x());
          String url=USEROBject.get("avatar").toString();
  URLImage urlimg=URLImage.createToStorage(enc, "avatarEdited", url);
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
        Text_Area_1.setEditable(true);
        Text_Area_1.setText(JOI.get("description").toString());
          String urlPub=api.BASE_URL+"/media/cache/ImgPublicLoad/images/posts/"+JOI.get("fichier").toString();
        if (urlPub.length()>4 && !(urlPub.contains(".gif")))
        {
            System.out.println("ENTERED FOR IMAGE");  
            URLImage urlpubL=URLImage.createToStorage(enc, "publicationEdited",urlPub);
            imgpub=new ImageViewer(urlpubL);
            imgpub.setWidth(600);
            imgpub.setHeight(600);
            FileAttach=true;
        }

  //      ImageViewer imgV=new ImageViewer(urlimg);
    //    cnt.addAll(imgV, cnt1);
      Button saveB=new Button("Appliquer les changements");
    cnt.addAll(cnt0,Text_Area_1,saveB);
    if (FileAttach) cnt.add(imgpub);
    saveB.addActionListener(e -> {
        System.out.println("Update DATA");
        String desc=Text_Area_1.getText();
        String img=JOI.get("fichier").toString();
        UpdateData(index,desc,img);
        });
    add(cnt);
    
    }

    private void UpdateData(int index,String desc,String img) {
        if (img.length()==0 && img =="NULL" )img="NULL";
           int id= CU.getIdCurrentUser();
       String url=api.BASE_URL+"/publication/"+index+"/editLEMob/"+id+"?description="+desc+"&imageFile="+img;
         ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        
        con.addResponseListener(ee->{
        String reponse=new String(con.getResponseData());
           Dialog.show("Confirmation","Publication Modifié avec succés" , "OK", null);
          new TrendingForm(theme).show();
          
         });
       NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
