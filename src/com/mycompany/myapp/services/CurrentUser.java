package com.mycompany.myapp.services;
import com.mycompany.myapp.entities.User;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Malek
 */
public class CurrentUser {

    /**
     *
     */
    public static CurrentUser instance;
    public static int idCurrentUser;
    public static User CurrentUser;

    public User getCurrentUser() {
        return CurrentUser;
    }

    public void setCurrentUser(User CurrentUser) {
        this.CurrentUser = CurrentUser;
    }

    public int getIdCurrentUser() {
        return idCurrentUser;
    }

    public void setIdCurrentUser(int idCurrentUser) {
        this.idCurrentUser = idCurrentUser;
    }

    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }

    public void disConnect() {
        this.setIdCurrentUser(-1);
        this.setCurrentUser(null);

    }

}
