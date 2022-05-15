/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;


import java.util.ArrayList;


/**
 *
 * @author mouhi
 */
public class Salle_Collaboration {
    private int ID_Collab;
    private Object chat;
    ArrayList<User> Liste_Utilisateur = new ArrayList<User>();
    private String URL_Collab;
    private String Nom_Collab;
    private int ID_Utilisateur;

    public int getID_Collab() {
        return ID_Collab;
    }

    public Object getChat() {
        return chat;
    }

    public String getURL_Collab() {
        return URL_Collab;
    }

    public String getNom_Collab() {
        return Nom_Collab;
    }

    public void setID_Collab(int ID_Collab) {
        this.ID_Collab = ID_Collab;
    }

    public void setChat(Object chat) {
        this.chat = chat;
    }

    public void setURL_Collab(String URL_Collab) {
        this.URL_Collab = URL_Collab;
    }

    public void setNom_Collab(String Nom_Collab) {
        this.Nom_Collab = Nom_Collab;
    }

    public ArrayList<User> getListe_Utilisateur() {
        return Liste_Utilisateur;
    }

    public void setListe_Utilisateur(ArrayList<User> Liste_Utilisateur) {
        this.Liste_Utilisateur = Liste_Utilisateur;
    }

    public int getID_Utilisateur() {
        return ID_Utilisateur;
    }

    public void setID_Utilisateur(int ID_Utilisateur) {
        this.ID_Utilisateur = ID_Utilisateur;
    }

    @Override
    public String toString() {
        return "Salle_Collaboration{" + "ID_Collab=" + ID_Collab + ", chat=" + chat + ", Liste_Utilisateur="
                + Liste_Utilisateur + ", URL_Collab=" + URL_Collab + ", Nom_Collab=" + Nom_Collab + '}';
    }

    public Salle_Collaboration() {
    }

    public Salle_Collaboration(ArrayList<User> Liste_Utilisateur, String URL_Collab, String Nom_Collab,
            int ID_Utilisatuer) {

        this.Liste_Utilisateur = Liste_Utilisateur;
        this.URL_Collab = URL_Collab;
        this.Nom_Collab = Nom_Collab;
        this.ID_Utilisateur = ID_Utilisatuer;
    }

}
