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
 * @author Kagan
 */
@Named(value = "sarkiSozleriController")
@SessionScoped
public class SarkiSozleriController implements Serializable {

    private List<SarkiSozleri> sozler;
    private SarkiSozleriDao sarkiSozleriDao;
    private SarkiSozleri soz;
    
    
    private int page=1;
    private int pageSize=3;
    private int pageCount;
    
    
    public void next(){
        if(this.page == this.getPageCount())
            this.page=1;
        else
            this.page++;
    }
     public void previous(){
        if(this.page == this.getPageCount())
            this.page=1;
        else
            this.page--;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
         this.pageCount= (int)Math.ceil(this.getSarkiSozleriDao().count()/pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
    
    

    public SarkiSozleriController() {
    }

    public List<SarkiSozleri> getSozler() {
        this.sozler= this.getSarkiSozleriDao().findAll(page, pageSize);
        return sozler;
    }

    public void setSozler(List<SarkiSozleri> sozler) {
        this.sozler = sozler;
    }
// bu tamm
    public SarkiSozleriDao getSarkiSozleriDao() {
        
         if(sarkiSozleriDao == null){
            sarkiSozleriDao = new SarkiSozleriDao();
        }
       
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

    public void updateForm(SarkiSozleri soz){
        this.soz=soz;
    }
    public void clearForm(){
        
        this.soz= new SarkiSozleri();
    }
}
