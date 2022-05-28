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

    public ListeController() {
    }

    public List<Liste> getListeler() {
        listeDao = new ListeDao();
        return listeDao.list();
    }

    public void setListeler(List<Liste> listeler) {
        this.listeler = listeler;
    }

    public ListeDao getListDao() {
        if(liste == null){
            liste = new Liste();
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
