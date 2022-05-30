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
         this.pageCount= (int)Math.ceil(this.getSanatciDao().count()/pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
   

    public SanatciController() {
    }
    
    
    public List<Sanatci> getSanatcilar() {
       this.sanatcilar =this.getSanatciDao().findAll(page,pageSize);
       return sanatcilar;
    }

    public SanatciDao getSanatciDao() {
         if(sanatciDao == null){
            sanatciDao = new SanatciDao();
        }
       
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
    public void updateForm(Sanatci sanatci){
        this.sanatci=sanatci;
    }
    public void clearForm(){
        this.sanatci=new Sanatci();
    }
}
