/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SarkiDao;
import entity.Sarki;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ikbal
 */
@Named(value = "sarkiController")
@SessionScoped
public class SarkiController implements Serializable {

    private List<Sarki> sarkilar;
    private SarkiDao sarkiDao;
    private Sarki sarki;
    
    
    
    public void update(){
        sarkiDao.update(this.sarki);
        sarki = new Sarki();
    }
    public void delete(Sarki sarki){
        sarkiDao.delete(sarki);
    }
    public void create(){
        sarkiDao.create(this.sarki);
        sarki = new Sarki();
    }
    
    public SarkiController() {
    }
    
    public List<Sarki> getSarkilar() {
        sarkiDao = new SarkiDao();
        return sarkiDao.list();
    }

    public void setSarkilar(List<Sarki> sarkilar) {
        this.sarkilar = sarkilar;
    }

    public SarkiDao getSarkiDao() {
        return sarkiDao;
    }

    public void setSarkiDao(SarkiDao sarkiDao) {
        this.sarkiDao = sarkiDao;
    }

    public Sarki getSarki() {
        if(this.sarki == null){
            sarki = new Sarki();
        }
        return sarki;
    }

    public void setSarki(Sarki sarki) {
        this.sarki = sarki;
    }
    
    
    
    
}
