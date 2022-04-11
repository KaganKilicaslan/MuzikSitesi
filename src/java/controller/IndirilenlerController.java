/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import dao.IndirilenlerDao;
import entity.Indirilenler;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author HP
 */
@Named(value = "indirilenlerController")
@Dependent
public class IndirilenlerController implements Serializable {

    private List<Indirilenler> indirilenlerler;
    private IndirilenlerDao indirilenlerDao;
    private Indirilenler indirilenler;
    
    public IndirilenlerController() {
    }
    
    public List<Indirilenler> getIndirilenlerler() {
        indirilenlerDao = new IndirilenlerDao();
        return indirilenlerDao.list();
    }

    public IndirilenlerDao getIndirilenlerDao() {
        return indirilenlerDao;
    }

    public void setIndirilenlerDao(IndirilenlerDao indirilenlerDao) {
        this.indirilenlerDao = indirilenlerDao;
    }

    public Indirilenler getindirilenler() {
         if(this.indirilenler == null){
            indirilenler = new Indirilenler();
        }
        return indirilenler;
    }

    public void setIndirilenler(Indirilenler indirilenler) {
        this.indirilenler = indirilenler;
    }

    
    /*public void update(){
        indirilenlerDao.update(this.indirilenler);
        indirilenler = new Indirilenler();
    }
    public void delete(Indirilenler indirilenler){
        indirilenlerDao.delete(indirilenler);
    }
    public void create(){
        indirilenlerDao.create(this.indirilenler);
        indirilenler = new Indirilenler();
    }
*/
    
    
}
