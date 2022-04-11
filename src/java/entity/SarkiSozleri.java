/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package entity;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;

/**
 *
 * @author HP
 */
@Named(value = "sarkiSozleri")
@Dependent
public class SarkiSozleri {

    private int sozid;
    private int sanatciid;
    private int sarkiID;
    private int albumID;
    private String sarkisozleri;
    
    public SarkiSozleri() {
    }
    
    
    public SarkiSozleri(int sozid, int sanatciid, int sarkiID, int albumID, String sarkisozleri ) {
        this.sozid = sozid;
        this.sanatciid = sanatciid;
        this.sanatciid = sanatciid;
        this.sarkiID = sarkiID;
        this.albumID = albumID;
        this.sarkisozleri = sarkisozleri;
    }
     public int getSozid() {
        return sozid;
    }
     
     public void setSozid(int sozid) {
        this.sozid = sozid;
    }
    
     
      
     public int getSanatciid() {
        return sanatciid;
    }
     public void setSanatciid(int sanatciid) {
        this.sanatciid = sanatciid;
    }
     
     
    
     public int getSarkiID() {
        return sarkiID;
    }
     public void setSarkiID(int sarkiID) {
        this.sarkiID = sarkiID;
    }
     
     
     
     public int getAlbumID() {
        return albumID;
    }
     public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }
    
     
     public String getSarkisozleri() {
        return sarkisozleri;
    }
     public void setSarkisozleri(String sarkisozleri) {
        this.sarkisozleri = sarkisozleri;
    }
    
}
