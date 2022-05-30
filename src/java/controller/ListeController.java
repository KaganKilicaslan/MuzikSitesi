/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

package controller;

import dao.ListeDao;
import entity.Liste;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ikbal
 */
@Named(value = "listeController")
@SessionScoped
public class ListeController implements Serializable {
    
    private List<Liste> listeler;
    private ListeDao listeDao;
    private Liste liste;
    
    
     
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

    public ListeDao getListeDao() {
        return listeDao;
    }

    public void setListeDao(ListeDao listeDao) {
        this.listeDao = listeDao;
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
        this.pageCount= (int)Math.ceil(this.getListDao().count()/pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
    

    public ListeController() {
    }

    public List<Liste> getListeler() {
        this.listeler= this.getListeDao().findAll(page, pageSize);
        return listeDao.list();
    }

    public void setListeler(List<Liste> listeler) {
        this.listeler = listeler;
    }

    /*
      if(albumDao == null){
            albumDao = new AlbumDao();
        }
        return albumDao;
    */
    
    public ListeDao getListDao() {
        if(listeDao == null){
            listeDao = new ListeDao();
        }
        return listeDao;
    }

    public void setListDao(ListeDao listDao) {
        this.listeDao = listDao;
    }

    public Liste getListe() {
        if(this.liste==null){
            this.liste=new Liste();
        }
        return liste;
    }
    /* 
    sarki listesine sarki ekleyince veri eklemek 
    için düzenleye tıklayıp yapmak gerekiyordu bu kod onu ortadan kaldırdı
*/
    public void setListe(Liste liste) {
        this.liste = liste;
    }
    
    
    public void update(){
        listeDao.update(this.liste);
        liste = new Liste();
    }
    public void delete(Liste liste){
        listeDao.delete(liste);
    }
    public void create(){
        listeDao.create(this.liste);
        liste = new Liste();
    }
     public void updateForm(Liste liste){
        this.liste=liste;
    }
     
     
     
     public void clearForm(){
         this.liste=new Liste();
     }
}
