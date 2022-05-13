/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author SRN
 */
public class Evenement {
     private int ID_Utilisateur;
    private String Date_P;        
    private int ID_Event ;
    private String Nom_Event;
    private int Nbr_participants;
    private String Date_Event;
    private String Type_Event;
    private String Event_Visibilite;
    private String Description;

    public Evenement() {
    }

    public Evenement(int ID_Utilisateur, int ID_Event, String Nom_Event, int Nbr_participants, String Date_Event, String Type_Event, String Event_Visibilite, String Description) {
        this.ID_Utilisateur = ID_Utilisateur;
        this.ID_Event = ID_Event;
        this.Nom_Event = Nom_Event;
        this.Nbr_participants = Nbr_participants;
        this.Date_Event = Date_Event;
        this.Type_Event = Type_Event;
        this.Event_Visibilite = Event_Visibilite;
        this.Description = Description;
    }

    public Evenement(int ID_Utilisateur, String Nom_Event, int Nbr_participants, String Date_Event, String Type_Event, String Event_Visibilite, String Description) {
        this.ID_Utilisateur = ID_Utilisateur;
        this.Nom_Event = Nom_Event;
        this.Nbr_participants = Nbr_participants;
        this.Date_Event = Date_Event;
        this.Type_Event = Type_Event;
        this.Event_Visibilite = Event_Visibilite;
        this.Description = Description;
    }

    public Evenement(String Date_P, int ID_Event, String Nom_Event, int Nbr_participants, String Date_Event, String Type_Event, String Event_Visibilite, String Description) {
        this.Date_P = Date_P;
        this.ID_Event = ID_Event;
        this.Nom_Event = Nom_Event;
        this.Nbr_participants = Nbr_participants;
        this.Date_Event = Date_Event;
        this.Type_Event = Type_Event;
        this.Event_Visibilite = Event_Visibilite;
        this.Description = Description;
    }

    public Evenement(int ID_Event) {
        this.ID_Event = ID_Event;
    }


    public int getID_Event() {
        return ID_Event;
    }

    public void setID_Event(int ID_Event) {
        this.ID_Event = ID_Event;
    }

    public String getNom_Event() {
        return Nom_Event;
    }

    public void setNom_Event(String Nom_Event) {
        this.Nom_Event = Nom_Event;
    }

    public int getNbr_participants() {
        return Nbr_participants;
    }

    public void setNbr_participants(int Nbr_participants) {
        this.Nbr_participants = Nbr_participants;
    }

    public String getDate_Event() {
        return Date_Event;
    }

    public void setDate_Event(String Date_Event) {
        this.Date_Event = Date_Event;
    }

    public String getType_Event() {
        return Type_Event;
    }

    public void setType_Event(String Type_Event) {
        this.Type_Event = Type_Event;
    }

    public String getEvent_Visibilite() {
        return Event_Visibilite;
    }

    public void setEvent_Visibilite(String Event_Visibilite) {
        this.Event_Visibilite = Event_Visibilite;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getID_Utilisateur() {
        return ID_Utilisateur;
    }

    public void setID_Utilisateur(int ID_Utilisateur) {
        this.ID_Utilisateur = ID_Utilisateur;
    }

    public String getDate_P() {
        return Date_P;
    }

    public void setDate_P(String Date_P) {
        this.Date_P = Date_P;
    }

    @Override
    public String toString() {
        return "evenements{" + ", ID_Utilisateur=" + ID_Utilisateur + ", Date_P=" + Date_P + ", ID_Event=" + ID_Event + ", Nom_Event=" + Nom_Event + ", Nbr_participants=" + Nbr_participants + ", Date_Event=" + Date_Event + ", Type_Event=" + Type_Event + ", Event_Visibilite=" + Event_Visibilite + ", Description=" + Description + '}';
    }
}
