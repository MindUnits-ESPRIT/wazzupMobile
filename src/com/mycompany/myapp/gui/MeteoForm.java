/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.utils.api;
import java.util.Map;
import org.json.JSONObject;


/**
 *
 * @author Misow3002
 */
public class MeteoForm extends BaseForm{
     private Resources theme=com.codename1.ui.util.Resources.getGlobalResources();
    private  EncodedImage enc=EncodedImage.createFromImage(theme.getImage("No_image_available.png"), false);
           Container XCont =new Container(BoxLayout.x());
            Container YCont =new Container(BoxLayout.y());
            Container MCont =new Container(BoxLayout.y());
        public MeteoForm(com.codename1.ui.util.Resources resourceObjectInstance,Form previous)
        {
             initGuiBuilderComponents(resourceObjectInstance,previous);
        }
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance,Form previous){
                   setTitle("Actualités Méteo");
        setName("FormMeteo");
                this.getToolbar().addCommandToLeftBar("<", null, ev->{
        previous.showBack();
        });
             GenerateGUI();
        }

    private void GenerateGUI() {
      
            //print in String
            // System.out.println(response.toString());
            //Read JSON response and print
                   String url="https://api.weatherapi.com/v1/current.json?key=4c76e85f65ba44d89a5100733220903&q=auto:ip";
      //   ConnectionRequest con=new ConnectionRequest();
       //  con.setRequestProperty();
      //  con.setUrl(url);
      Response<Map> jsonData =Rest.get(url).acceptJson().getAsJsonMap();
      
       // System.out.println(jsonData.getResponseData());

       // System.out.println(jsonData);
//        con.addResponseListener(ee->{
//        String reponse=new String(con.getResponseData());
//            System.out.println(reponse);
             JSONObject myResponse = new JSONObject(jsonData.getResponseData());
             System.out.println(myResponse);
            JSONObject ResultTXT=myResponse.getJSONObject("location");
            JSONObject ResultCurrent=myResponse.getJSONObject("current");
            JSONObject IMG_Content=ResultCurrent.getJSONObject("condition");
            System.out.println(ResultTXT);
          
//         });
//       NetworkManager.getInstance().addToQueueAndWait(con);
           
//            degre_txt.setText(String.valueOf(ResultCurrent.getFloat("temp_c")+"°"));
//            txt1.setText(IMG_Content.getString("text"));
//            txt2.setText(ResultTXT.getString("country")+","+ResultTXT.getString("name")+","+ResultTXT.getString("region"));
//            String Month=MMtoChar(Integer.parseInt(ResultCurrent.getString("last_updated").substring(5,7)));
//            txt3.setText(Month);
//            System.out.println("MMM : "+Month);
//            txt5.setText(ResultTXT.getString("localtime").substring(8,10));
//            Image imgg=new Image("https:"+IMG_Content.getString("icon"));
//            img_weath.setImage(imgg);
//            wave_txt.setText(ResultCurrent.getFloat("wind_mph")+" MPH");
//            water_txt.setText(ResultCurrent.getInt("humidity")+"%");
//            sun_txt.setText(ResultCurrent.getInt("cloud")+"%");
          String urlPic="https:"+IMG_Content.getString("icon");
  URLImage urlimg=URLImage.createToStorage(enc, "Meteo", urlPic);
        ImageViewer imgHand=new ImageViewer(urlimg);
        Container C1=new Container(BoxLayout.x());
        Label Txt=new Label(IMG_Content.getString("text"));
        C1.addAll(imgHand,Txt);
Label LbCountry=new Label("Country :"+ResultTXT.getString("country")+","+ResultTXT.getString("name")+","+ResultTXT.getString("region"));
Label LbDate=new Label("Date : "+ResultTXT.getString("localtime"));
Label LbMPH=new Label("MPH : "+ResultCurrent.getFloat("wind_mph"));
Label LbCloud=new Label("Cloud : "+ResultCurrent.getInt("cloud")+"%");
addAll(C1,LbCountry,LbDate,LbMPH,LbCloud);
    }
}
