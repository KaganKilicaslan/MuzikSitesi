/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author SENANUR PAKSOY
 */
public class Sanatci {
    private int sanatciid;
    private int albumId;
    private String ad;

    public Sanatci() {
    }

    public Sanatci(String ad) {
        this.ad = ad;
    }

    public Sanatci(int sanatciid, String ad, int albumId ) {
        this.sanatciid = sanatciid;
        this.ad = ad;
        this.albumId = albumId;
    }

    public int getSanatciid() {
        return sanatciid;
    }

    public void setSanatciid(int sanatciid) {
        this.sanatciid = sanatciid;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

   
}
