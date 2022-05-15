/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entity.Kullanici;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

/**
 *
 * @author SENANUR PAKSOY
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable{

    private Kullanici user;
    public LoginController() {
    }
    
    public void login(){
        if(user.getNickName().equals("test")&& user.getSifre().equals("123") ){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", user);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("KULLANICI ADI VEYA ŞİFRE YANLIŞ!!"));
        }
    }
    public Kullanici getUser() {
        if(user == null){
            user= new Kullanici();
        }
        return user;
    }

    public void setUser(Kullanici user) {
        this.user = user;
    }
    
}
