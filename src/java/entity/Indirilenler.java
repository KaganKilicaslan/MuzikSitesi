/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package entity;


/**
 *
 * @author HP
 */

public class Indirilenler {

    private int indirid;
    private int albumId;
    private int sanatciid;
    private int sarkiID;
  
    public Indirilenler() {
    }
    
    public Indirilenler(int indirid, int albumId,int sanatciid, int sarkiID ) {
        this.indirid = indirid;
        this.albumId = albumId;
        this.sanatciid = sanatciid;
        this.sarkiID = sarkiID;
    }
     public int getIndirid() {
        return indirid;
    }
     
     public void setIndirid(int indirid) {
        this.indirid = indirid;
    }
    
     
      
     public int getAlbumId() {
        return albumId;
    }
     public void setAlbumId(int albumId) {
        this.albumId = albumId;
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
     public void setsarkiID(int sarkiID) {
        this.sarkiID = sarkiID;
    }

    public String getindirId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
