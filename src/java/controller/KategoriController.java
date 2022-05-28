/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KategoriDao;
import entity.Album;
import entity.Kategori;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author karao
 */
@Named(value = "KategoriController")
@SessionScoped
public class KategoriController implements Serializable {

    private List<Kategori> kategoriler;
    private KategoriDao kategoriDao;
    private Kategori kategori;
    
 
    public KategoriController() {
    }

    public List<Kategori> getKategoriler() {
        kategoriDao = new KategoriDao();
        return kategoriDao.list();
    }

    public void setKategoriler(List<Kategori> kategoriler) {
        this.kategoriler = kategoriler;
    }

    public KategoriDao getKategoriDao() {
        return kategoriDao;
    }

    public void setKategoriDao(KategoriDao kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

    public Kategori getKategori() {
        if(this.kategori == null){
            kategori = new Kategori();
        }
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
    public void update(){
        kategoriDao.update(this.kategori);
        kategori = new Kategori();
    }
    public void delete(Kategori kategori){
        kategoriDao.delete(kategori);
    }
    public void create(){
        kategoriDao.create(this.kategori);
        kategori = new Kategori();
    }
    
    public void updateForm(Kategori kategori){
        this.kategori=kategori;
    }
    
    public void clearForm(){
        this.kategori=new Kategori();
    }
    
}
    
    

