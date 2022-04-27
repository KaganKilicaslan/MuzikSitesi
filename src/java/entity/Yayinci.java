/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Kagan
 */
public class Yayinci {
    private int yayinciID;
    private int albumID;
    private int sanatciId;
    private int sarkiId;
    private String yayinciAd;
    
    public Yayinci() {
    }
    
    public Yayinci(int yayinciID, int albumID, int sanatciId, int sarkiId, String yayinciAd) {
        this.yayinciID = yayinciID;
        this.albumID = albumID;
        this.sanatciId = sanatciId;
        this.sarkiId = sarkiId;
        this.yayinciAd = yayinciAd;
    }
    
    public int getYayinciID() {
        return yayinciID;
    }

    public void setYayinciID(int yayinciID) {
        this.yayinciID = yayinciID;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public int getSanatciId() {
        return sanatciId;
    }

    public void setSanatciId(int sanatciId) {
        this.sanatciId = sanatciId;
    }

    public int getSarkiId() {
        return sarkiId;
    }

    public void setSarkiId(int sarkiId) {
        this.sarkiId = sarkiId;
    }

    public String getYayinciAd() {
        return yayinciAd;
    }

    public void setYayinciAd(String yayinciAd) {
        this.yayinciAd = yayinciAd;
    }
    
    
    
}


