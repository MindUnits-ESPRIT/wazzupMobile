package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.utils.api;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MINDUNITS
 */
public class UserService {
  public static UserService instance = null;
  public boolean resultOK;
  public String res;
  public boolean exists;
  public boolean validedb;
  public boolean recupere;
  public boolean edited;
  public boolean pwvalid;
  private ConnectionRequest req;
  private Hashtable requestResult;
  private ArrayList<User> user;

  public UserService() {
    req = new ConnectionRequest();
  }

  public static UserService getInstance() {
    if (instance == null) {
      instance = new UserService();
    }
    return instance;
  }

  //    public boolean addUser(User t) {
  //       // String url = Statics.BASE_URL + "/tasks/" + t.getName() + "/" + t.getStatus(); //création de l'URL
  //        req.setUrl("url");// Insertion de l'URL de notre demande de connexion
  //        req.addResponseListener(new ActionListener<NetworkEvent>() {
  //            @Override
  //            public void actionPerformed(NetworkEvent evt) {
  //                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
  //                req.removeResponseListener(this); //Supprimer cet actionListener
  //                /* une fois que nous avons terminé de l'utiliser.
  //                La ConnectionRequest req est unique pour tous les appels de
  //                n'importe quelle méthode du Service task, donc si on ne supprime
  //                pas l'ActionListener il sera enregistré et donc éxécuté même si
  //                la réponse reçue correspond à une autre URL(get par exemple)*/
  //
  //            }
  //        });
  //        NetworkManager.getInstance().addToQueueAndWait(req);
  //        return resultOK;
  //    }
  //
  public boolean addUser(
    String nom,
    String prenom,
    String email,
    String password,
    String genre,
    String numtel,
    String db
  ) {
    String url =
      api.BASE_URL +
      "/api/users/signup?nom=" +
      nom +
      "&prenom=" +
      prenom +
      "&email=" +
      email +
      "&mdp=" +
      password +
      "&genre=" +
      genre +
      "&full_number=" +
      numtel +
      "&datenaissance=" +
      db; //création de l'URL
    req.setUrl(url); // Insertion de l'URL de notre demande de connexion
    req.addResponseListener(
      new ActionListener<NetworkEvent>() {

        @Override
        public void actionPerformed(NetworkEvent evt) {
          resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
          req.removeResponseListener(this); //Supprimer cet actionListener
          /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
        }
      }
    );

    NetworkManager.getInstance().addToQueueAndWait(req);
    System.out.println(new String(req.getResponseData()));

    return resultOK;
  }

  public boolean CheckMailExistance(String email) {
    String url = api.BASE_URL + "/api/users/verifymail?email=" + email; //création de l'URL
    req.setUrl(url); // Insertion de l'URL de notre demande de connexion
    req.addResponseListener(
      new ActionListener<NetworkEvent>() {

        @Override
        public void actionPerformed(NetworkEvent evt) {
          resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
          exists = Boolean.parseBoolean(new String(req.getResponseData()));
        }
      }
    );
    NetworkManager.getInstance().addToQueueAndWait(req);
    System.out.println("MAIL EXISTANCE " + exists);

    return exists;
  }

  public boolean CheckDateofbirthvalidity(String db) {
    String url =
      api.BASE_URL + "/api/users/verifynaissance?datenaissance=" + db; //création de l'URL
    req.setUrl(url); // Insertion de l'URL de notre demande de connexion
    req.addResponseListener(
      new ActionListener<NetworkEvent>() {

        @Override
        public void actionPerformed(NetworkEvent evt) {
          resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
          validedb = Boolean.parseBoolean(new String(req.getResponseData()));
        }
      }
    );
    NetworkManager.getInstance().addToQueueAndWait(req);
    return validedb;
  }

  public boolean RecupererPassword(String email) {
    String url = api.BASE_URL + "/api/forgotpassword?email=" + email; //création de l'URL
    req.setUrl(url); // Insertion de l'URL de notre demande de connexion
    req.addResponseListener(
      new ActionListener<NetworkEvent>() {

        @Override
        public void actionPerformed(NetworkEvent evt) {
          resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
          recupere = Boolean.parseBoolean(new String(req.getResponseData()));
        }
      }
    );
    NetworkManager.getInstance().addToQueueAndWait(req);
    return recupere;
  }
  
  
  public boolean EditCompte(String nom,String prenom,String email,String full_number,String genre,String datenaissance) {
    String url = api.BASE_URL + "/api/users/edit?nom=" + nom + "&prenom=" + prenom+ "&email="+email+"&full_number="+full_number+"&genre="+genre+"&datenaissance="+datenaissance; ; //création de l'URL
    req.setUrl(url); // Insertion de l'URL de notre demande de connexion
    req.addResponseListener(
      new ActionListener<NetworkEvent>() {

        @Override
        public void actionPerformed(NetworkEvent evt) {
          resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
          edited = Boolean.parseBoolean(new String(req.getResponseData()));
        }
      }
    );
    NetworkManager.getInstance().addToQueueAndWait(req);
    return edited;
  }
  
  
    public boolean CheckCurrentPassword(String email,String mdp) {
    String url = api.BASE_URL + "/api/users/edit/passwordcheck?email=" + email + "&mdp=" + mdp ; //création de l'URL
    req.setUrl(url); // Insertion de l'URL de notre demande de connexion
    req.addResponseListener(
      new ActionListener<NetworkEvent>() {

        @Override
        public void actionPerformed(NetworkEvent evt) {
          resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
          pwvalid = Boolean.parseBoolean(new String(req.getResponseData()));
        }
      }
    );
    NetworkManager.getInstance().addToQueueAndWait(req);
    return pwvalid;
  }
  
  
  

  public String login(String email, String password) {
    String url =
      api.BASE_URL + "/api/mobile-auth?email=" + email + "&mdp=" + password; //création de l'URL
    req.setUrl(url); // Insertion de l'URL de notre demande de connexion
    req.addResponseListener(
      new ActionListener<NetworkEvent>() {

        @Override
        public void actionPerformed(NetworkEvent evt) {
          resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
          res = new String(req.getResponseData());
          System.out.println("THIS IS RESULTAT REALL" + res);
          req.removeResponseListener(this); //Supprimer cet actionListener
          /* une fois que nous avons terminé de l'utiliser.
                    La ConnectionRequest req est unique pour tous les appels de
                    n'importe quelle méthode du Service task, donc si on ne supprime
                    pas l'ActionListener il sera enregistré et donc éxécuté même si
                    la réponse reçue correspond à une autre URL(get par exemple)*/

        }
      }
    );

    NetworkManager.getInstance().addToQueueAndWait(req);
    System.out.println("USER IS");
    //        System.out.println(getUser(email,password));
    return res;
  }

  //retrieving connected user
  public ArrayList<User> getUser(String email) {
    System.out.println("THIS IS EMAIL " + email);
    String url = api.BASE_URL + "/api/getuser?email=" + email;
    req.setUrl(url);
    //req.setPost(false);
    req.addResponseListener(
      new ActionListener<NetworkEvent>() {

        @Override
        public void actionPerformed(NetworkEvent evt) {
          System.out.println("req.getResponseData()" + req.getResponseData());
          user = parseUsers(new String(req.getResponseData()));
          req.removeResponseListener(this);
        }
      }
    );
    NetworkManager.getInstance().addToQueueAndWait(req);
    System.out.println("user data" + user);
    return user;
  }

  public ArrayList<User> parseUsers(String jsonText) {
    try {
      System.out.println("usersList" + jsonText);
      user = new ArrayList<>();
      JSONParser j = new JSONParser();
      Map<String, Object> usersListJson = j.parseJSON(
        new CharArrayReader(jsonText.toCharArray())
      );
      System.out.println("users NOM" + usersListJson.get("nom").toString());
      System.out.println(
        "users PRENOM" + usersListJson.get("prenom").toString()
      );
      System.out.println(
        "users NUM" + usersListJson.get("full_number").toString()
      );

      int id = (int) Float.parseFloat(
        usersListJson.get("idUtilisateur").toString()
      );

      String nom = usersListJson.get("nom").toString();
      String prenom = usersListJson.get("prenom").toString();
      String db = usersListJson.get("datenaissance").toString();
      String tel = usersListJson.get("full_number").toString();
      String email = usersListJson.get("email").toString();
      String typeuser = usersListJson.get("typeUser").toString();
      String genre = usersListJson.get("genre").toString();
      user.add(new User(id, nom, prenom, db, tel, email, typeuser, genre));
    } catch (IOException ex) {}
    return user;
  }
  //
  //    public ArrayList<User> getAllUsers(){
  //        String url = api.BASE_URL+"/tasks/";
  //        req.setUrl(url);
  //        req.setPost(false);
  //        req.addResponseListener(new ActionListener<NetworkEvent>() {
  //            @Override
  //            public void actionPerformed(NetworkEvent evt) {
  //                tasks = parseUsers(new String(req.getResponseData()));
  //                req.removeResponseListener(this);
  //            }
  //        });
  //        NetworkManager.getInstance().addToQueueAndWait(req);
  //        return tasks;
  //    }
}
