/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KategoryDao;
import entity.Album;
import entity.Kategory;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author karao
 */
@Named(value = "kategoryController")
@SessionScoped
public class KategoryController implements Serializable {

    private List<Kategory> kategoryler;
    private KategoryDao kategoryDao;
    private Kategory kategory;
    
 
    public KategoryController() {
    }

    public List<Kategory> getKategoryler() {
        kategoryDao = new KategoryDao();
        return kategoryDao.list();
    }

    public void setKategoryler(List<Kategory> kategoryler) {
        this.kategoryler = kategoryler;
    }

    public KategoryDao getKategoryDao() {
        return kategoryDao;
    }

    public void setKategoryDao(KategoryDao kategoryDao) {
        this.kategoryDao = kategoryDao;
    }

    public Kategory getKategory() {
        if(this.kategory == null){
            kategory = new Kategory();
        }
        return kategory;
    }

    public void setKategory(Kategory kategory) {
        this.kategory = kategory;
    }
    public void update(){
        kategoryDao.update(this.kategory);
        kategory = new Kategory();
    }
    public void delete(Kategory kategory){
        kategoryDao.delete(kategory);
    }
    public void create(){
        kategoryDao.create(this.kategory);
        kategory = new Kategory();
    }
    
    
    
}
    
    

