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
    
    public AlbumController() {
    }

   

    
    public AlbumDao getAlbumDAO() {
        return albumDao;
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
        albumDao = new AlbumDao();
        return albumDao.list();
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
