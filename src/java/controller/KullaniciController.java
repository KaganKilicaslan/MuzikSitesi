/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KullaniciDao;
import entity.Kullanici;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author karao
 */
@Named(value = "kullaniciController")
@SessionScoped
public class KullaniciController implements Serializable {

    private List<Kullanici> kullanicilar;
    private KullaniciDao kullaniciDao;
    private Kullanici kullanici;
    
    public KullaniciController() {
        
    }

    public List<Kullanici> getKullanicilar() {
        kullaniciDao = new KullaniciDao();
        return kullaniciDao.list();
    }

    public void setKullanicilar(List<Kullanici> kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    public KullaniciDao getKullaniciDao() {
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDao kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    public Kullanici getKullanici() {
        if(kullanici == null){
            kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
    
    
    public void update(){
        kullaniciDao.update(this.kullanici);
        kullanici = new Kullanici();
    }
    public void delete(Kullanici album){
        kullaniciDao.delete(album);
    }
    public void create(){
        kullaniciDao.create(this.kullanici);
        kullanici = new Kullanici();
    }
    
}
