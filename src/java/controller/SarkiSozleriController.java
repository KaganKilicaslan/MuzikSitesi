/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import dao.SarkiSozleriDao;
import entity.SarkiSozleri;
import entity.Kategory;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author HP
 */
@Named(value = "sarkiSozleriController")
@Dependent
public class SarkiSozleriController implements Serializable {

    private List<SarkiSozleri> sarkisozleriler;
    private SarkiSozleriDao sarkisozleriDao;
    private SarkiSozleri sarkisozleri;
   
    public SarkiSozleriController() {
    }
    
    public List<SarkiSozleri> getSarkiSozleriler() {
        sarkisozleriDao = new SarkiSozleriDao();
        return sarkisozleriDao.list();
    }

    public SarkiSozleriDao getSarkiSozleriDao() {
        return sarkisozleriDao;
    }

    public void setIndirilenlerDao(SarkiSozleriDao sarkisozleriDao) {
        this.sarkisozleriDao = sarkisozleriDao;
    }

    public SarkiSozleri getsarkisozleri() {
         if(this.sarkisozleri == null){
            sarkisozleri = new SarkiSozleri();
        }
        return sarkisozleri;
    }

    public void setSarkiSozleri(SarkiSozleri sarkisozleri) {
        this.sarkisozleri = sarkisozleri;
    }

    
    public void update(){
        sarkisozleriDao.update(this.sarkisozleri);
        sarkisozleri = new SarkiSozleri();
    }
    public void delete(SarkiSozleri sarkisozleri){
        sarkisozleriDao.delete(sarkisozleri);
    }
    public void create(){
        sarkisozleriDao.create(this.sarkisozleri);
        sarkisozleri = new SarkiSozleri();
    }
    
}
