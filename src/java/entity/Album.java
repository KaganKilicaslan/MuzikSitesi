/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author karao
 */
public class Album {
    private int albumID;
    private String albumAdi;
    private Date guncellemeTarihi;
    
    
    public Album(){
        
    }
    
    public Album(String albumAdi){
        this.albumAdi = albumAdi;
    }
    public Album(int albumID, String albumAdi, Date guncellemeTarihi) {
        this.albumID = albumID;
        this.albumAdi = albumAdi;
        this.guncellemeTarihi = guncellemeTarihi;
    }
    
    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getAlbumAdi() {
        return albumAdi;
    }

    public void setAlbumAdi(String albumAdi) {
        this.albumAdi = albumAdi;
    }

    public Date getGuncellemeTarihi() {
        return guncellemeTarihi;
    }

    public void setGuncellemeTarihi(Date guncellemeTarihi) {
        this.guncellemeTarihi = guncellemeTarihi;
    }
    
    
    
    
}
