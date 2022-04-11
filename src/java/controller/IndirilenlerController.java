/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.IndirilenlerDao;
import entity.Indirilenler;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author SENANUR PAKSOY
 */
@Named(value = "indirilenlerController")
@Dependent
public class IndirilenlerController implements Serializable{

    private List<Indirilenler> indirilenler;
    private IndirilenlerDao indirilenlerDao;
    private Indirilenler indirilen;
    
    public IndirilenlerController() {
    }

    public List<Indirilenler> getIndirilenler() {
        indirilenlerDao = new IndirilenlerDao();
        return indirilenlerDao.list();
    }


    public IndirilenlerDao getIndirilenlerDao() {
        return indirilenlerDao;
    }

    public void setIndirilenlerDao(IndirilenlerDao indirilenlerDao) {
        this.indirilenlerDao = indirilenlerDao;
    }

    public Indirilenler getIndirilen() {
        if(this.indirilen == null){
            indirilen = new Indirilenler();
        }
        return indirilen;
    }

    public void setIndirilen(Indirilenler indirilen) {
        this.indirilen = indirilen;
    }
    
     public void update(){
        indirilenlerDao.update(this.indirilen);
        indirilen = new Indirilenler();
    }
    public void delete(Indirilenler indirilen){
        indirilenlerDao.delete(indirilen);
    }
    public void create(){
        indirilenlerDao.create(this.indirilen);
        indirilen = new Indirilenler();
    }
    
    
    
}
