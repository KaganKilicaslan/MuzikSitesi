/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.AlbumDao;
import entity.Album;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author karao
 */
@Named(value = "albumController")
@SessionScoped
public class AlbumController implements Serializable {

    private List<Album> albumler;
    private AlbumDao albumDao;
    private Album album;
    
    private int page=1;
    private int pageSize=3;
    private int pageCount;
    
    public void next(){
        this.page++;
    }
    public void previuos(){
        this.page--;
    }

    public AlbumDao getAlbumDao() {
        if(albumDao == null){
            albumDao = new AlbumDao();
        }
        return albumDao;
    }

    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
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
        this.pageCount= (int)Math.ceil(this.getAlbumDao().count()/pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) { 
        this.pageCount = pageCount;
    }
    
    
    
    public AlbumController() {
    }

   

    
   
    public void setAlbumDAO(AlbumDao albumDAO) {
        this.albumDao = albumDAO;
    }

    public Album getAlbum() {
        if(this.album == null){
            album = new Album();
        }
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    public List<Album> getAlbumler(){
        this.albumler= this.getAlbumDao().findAll(page, pageSize);
        return albumler;
    }
    
    public void update(){
        albumDao.update(this.album);
        album = new Album();
    }
    public void delete(Album album){
        albumDao.delete(album);
    }
    public void create(){
        albumDao.create(this.album);
        album = new Album();
    }
    
}
