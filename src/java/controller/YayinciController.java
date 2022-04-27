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
    
    public YayinciController() {
    }

    public List<Yayinci> getYayincilar() {
       yayinciDao = new YayinciDao();
       return yayinciDao.list();
    }

    public void setYayincilar(List<Yayinci> yayincilar) {
        this.yayincilar = yayincilar;
    }

    public YayinciDao getYayinciDao() {
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
    
    
    
}
