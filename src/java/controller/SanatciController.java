/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SanatciDao;
import entity.Sanatci;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author SENANUR PAKSOY
 */
@Named(value = "sanatciController")
@SessionScoped
public class SanatciController implements Serializable {

    private List<Sanatci> sanatcilar;
    private SanatciDao sanatciDao;
    private Sanatci sanatci;

    public SanatciController() {
    }
    
    
    public List<Sanatci> getSanatcilar() {
        sanatciDao = new SanatciDao();
        return sanatciDao.list();
    }

    public SanatciDao getSanatciDao() {
        return sanatciDao;
    }

    public void setSanatciDao(SanatciDao sanatciDao) {
        this.sanatciDao = sanatciDao;
    }

    public Sanatci getSanatci() {
         if(this.sanatci == null){
            sanatci = new Sanatci();
        }
        return sanatci;
    }

    public void setSanatci(Sanatci sanatci) {
        this.sanatci = sanatci;
    }

    
    public void update(){
        sanatciDao.update(this.sanatci);
        sanatci = new Sanatci();
    }
    public void delete(Sanatci sanatci){
        sanatciDao.delete(sanatci);
    }
    public void create(){
        sanatciDao.create(this.sanatci);
        sanatci = new Sanatci();
    }
}
