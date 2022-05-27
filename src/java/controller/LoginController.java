/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entity.Kullanici;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import static javax.management.Query.value;

/**
 *
 * @author SENANUR PAKSOY
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private Kullanici user;

    public LoginController() {
    }

    public void login() {
        if (user.getNickName().equals("test") && user.getSifre().equals("12345678")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", user);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("KULLANICI ADI VEYA ŞİFRE YANLIŞ!!"));
        }
    }

    public boolean validatePassword(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {
        String v = (String) value;

        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Şifre alanı boş olamaz!"));
        } else if (v.length() < 7) {
            throw new ValidatorException(new FacesMessage("Şifre alanı 8 karakterden kısa olamaz!"));
        }

        return true;
    }

    public void register() {
        System.out.println("-------REGISTRED--------");
    }

    public Kullanici getUser() {
        if (user == null) {
            user = new Kullanici();
        }
        return user;
    }

    public void setUser(Kullanici user) {
        this.user = user;
    }

}
