/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author ikbal
 */
public class Sarki {
    private int sarkiID;
    private int sanatciID;
    private int albumID;
    private String sarkiAdi;
    
    public Sarki(){
        
    }
    
    public Sarki(int sarkiID, int sanatciID, int albumID, String sarkiAdi) {
        this.sarkiID = sarkiID;
        this.sanatciID = sanatciID;
        this.albumID = albumID;
        this.sarkiAdi = sarkiAdi;
    }

    public String getSarkiAdi() {
        return sarkiAdi;
    }

    public void setSarkiAdi(String sarkiAdi) {
        this.sarkiAdi = sarkiAdi;
    }
    

    public int getSarkiID() {
        return sarkiID;
    }

    public void setSarkiID(int sarkiID) {
        this.sarkiID = sarkiID;
    }

    public int getSanatciID() {
        return sanatciID;
    }

    public void setSanatciID(int sanatciID) {
        this.sanatciID = sanatciID;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }
    
    
}
