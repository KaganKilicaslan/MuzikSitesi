/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.YayinciDao;
import entity.Yayinci;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Kagan
 */
@Named(value = "YayinciController")
@SessionScoped
public class YayinciController implements Serializable {

    private List<Yayinci> yayincilar;
    private YayinciDao yayinciDao;
    private Yayinci yayinci;
    
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
        return pageCount;
    }

    public void setPageCount(int pageCount) {
         this.pageCount= (int)Math.ceil(this.getYayinciDao().count()/pageSize);
        this.pageCount = pageCount;
    }
   
    public YayinciController() {
    }

    public List<Yayinci> getYayincilar() {
        this.yayincilar= this.getYayinciDao().findAll(page, pageSize);
       return yayincilar;
    }

    public void setYayincilar(List<Yayinci> yayincilar) {
        this.yayincilar = yayincilar;
    }

   
    public YayinciDao getYayinciDao() {
        if(yayinciDao == null){
            yayinciDao = new YayinciDao();
        }
        return yayinciDao;
    }

    public void setYayinciDao(YayinciDao yayinciDao) {
        this.yayinciDao = yayinciDao;
    }

    public Yayinci getYayinci() {
        if(this.yayinci == null){
            yayinci = new Yayinci();
        }
        return yayinci;
    }

    public void setYayinci(Yayinci yayinci) {
        this.yayinci = yayinci;
    }
    
    public void update(){
        yayinciDao.update(this.yayinci);
        yayinci = new Yayinci();
    }
    public void delete(Yayinci yayinci){
        yayinciDao.delete(yayinci);
    }
    public void create(){
        yayinciDao.create(this.yayinci);
        yayinci = new Yayinci();
    }
    public void updateForm(Yayinci yayinci){
        this.yayinci=yayinci;
    }
    
    
}
