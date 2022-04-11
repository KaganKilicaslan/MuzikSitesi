/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author SENANUR PAKSOY
 */
public class Indirilenler {
    private int indirid;
    private int sanatciid;
    private int sarkiid;
    private int albumid;

    public Indirilenler() {
    }

    public Indirilenler(int indirid, int sanatciid,int sarkiid, int albumid) {
        this.indirid = indirid;
        this.sanatciid = sanatciid;
        this.sarkiid = sarkiid;
        this.albumid = albumid;
    }

   
    public int getIndirid() {
        return indirid;
    }

    public void setIndirid(int indirid) {
        this.indirid = indirid;
    }

    public int getSanatciid() {
        return sanatciid;
    }

    public void setSanatciid(int sanatciid) {
        this.sanatciid = sanatciid;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public int getSarkiid() {
        return sarkiid;
    }

    public void setSarkiid(int sarkiid) {
        this.sarkiid = sarkiid;
    }
    
    

}
