/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SarkiSozleriDao;
import entity.SarkiSozleri;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author SENANUR PAKSOY
 */
@Named(value = "sarkiSozleriController")
@SessionScoped
public class SarkiSozleriController implements Serializable {

    private List<SarkiSozleri> sozler;
    private SarkiSozleriDao sarkiSozleriDao;
    private SarkiSozleri soz;

    public SarkiSozleriController() {
    }

    public List<SarkiSozleri> getSozler() {
       sarkiSozleriDao = new SarkiSozleriDao();
        return sarkiSozleriDao.list();    }

   

    public SarkiSozleriDao getSarkiSozleriDao() {
        return sarkiSozleriDao;
    }

    public void setSarkiSozleriDao(SarkiSozleriDao sarkiSozleriDao) {
        this.sarkiSozleriDao = sarkiSozleriDao;
    }

    public SarkiSozleri getSoz() {
        if(this.soz == null){
            soz = new SarkiSozleri();
        }
        return soz;
    }

    public void setSoz(SarkiSozleri soz) {
        this.soz = soz;
    }
    
    public void update(){
        sarkiSozleriDao.update(this.soz);
        soz = new SarkiSozleri();
    }
    public void delete(SarkiSozleri soz){
        sarkiSozleriDao.delete(soz);
    }
    public void create(){
        sarkiSozleriDao.create(this.soz);
        soz = new SarkiSozleri();
    }

    
}
