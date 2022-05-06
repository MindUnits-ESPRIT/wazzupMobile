/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;
import java.*;
/**
 *
 * @author MINDUNITS
 */
public class User{
    private int ID_Utilisateur;
    private String nom;
    private String prenom;
    private String datenaissance;
    private String num_tel;
    private String email;
    private String avatar;
    private String mdp;
    private String type_user;
    private int evaluation;
    private String genre;
    private String Token;
    private int nbsignal;
    private boolean activated;
    private boolean sponsor;
    private boolean desactivated;
    private String Liste_Collaborations ;

    public User(String nom, String prenom, String datenaissance, String num_tel, String email, String type_user, String genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.num_tel = num_tel;
        this.email = email;
        this.type_user = type_user;
        this.genre = genre;
    }

    public User() {
    }

    public User(int ID_Utilisateur, String email, String mdp, String type_user) {
        this.ID_Utilisateur = ID_Utilisateur;
        this.email = email;
        this.mdp = mdp;
        this.type_user = type_user;
    }

    public User(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public int getID_Utilisateur() {
        return ID_Utilisateur;
    }

    public void setID_Utilisateur(int ID_Utilisateur) {
        this.ID_Utilisateur = ID_Utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public int getNbsignal() {
        return nbsignal;
    }

    public void setNbsignal(int nbsignal) {
        this.nbsignal = nbsignal;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isSponsor() {
        return sponsor;
    }

    public void setSponsor(boolean sponsor) {
        this.sponsor = sponsor;
    }

    public boolean isDesactivated() {
        return desactivated;
    }

    public void setDesactivated(boolean desactivated) {
        this.desactivated = desactivated;
    }

    public String getListe_Collaborations() {
        return Liste_Collaborations;
    }

    public void setListe_Collaborations(String Liste_Collaborations) {
        this.Liste_Collaborations = Liste_Collaborations;
    }

    @Override
    public String toString() {
        return "User{" + "ID_Utilisateur=" + ID_Utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", datenaissance=" + datenaissance + ", num_tel=" + num_tel + ", email=" + email + ", avatar=" + avatar + ", mdp=" + mdp + ", type_user=" + type_user + ", evaluation=" + evaluation + ", genre=" + genre + ", Token=" + Token + ", nbsignal=" + nbsignal + ", activated=" + activated + ", sponsor=" + sponsor + ", desactivated=" + desactivated + ", Liste_Collaborations=" + Liste_Collaborations + '}';
    }

}