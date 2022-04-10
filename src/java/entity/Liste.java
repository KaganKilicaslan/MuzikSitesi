/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ikbal
 */
public class Liste {

    private int listeID;
    private String listeAdi;
    private int sarkiID;
    private int sanatciID;
    private int albumID;

    public Liste() {
    }

    
    public Liste( int listeID, String listeAdi, int sarkiID, int sanatciID, int albumID) {
        this.listeID = listeID;
        this.listeAdi = listeAdi;
        this.sarkiID = sarkiID;
        this.sanatciID = sanatciID;
        this.albumID = albumID;
    }

    public String getListeAdi() {
        return listeAdi;
    }

    public void setListeAdi(String listeAdi) {
        this.listeAdi = listeAdi;
    }

    public int getListeID() {
        return listeID;
    }

    public void setListeID(int listeID) {
        this.listeID = listeID;
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
