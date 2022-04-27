/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Kagan
 */
public class SarkiSozleri {
    private int sozID;
    private int sanatciId;
    private int sarkiId;
    private int albumId;
    private String sozler;

    public SarkiSozleri() {
    }

    public SarkiSozleri(int sozID, int sanatciId, int sarkiId, int albumId, String sozler) {
        this.sozID = sozID;
        this.sanatciId = sanatciId;
        this.sarkiId = sarkiId;
        this.albumId = albumId;
        this.sozler = sozler;
    }

    public int getSozID() {
        return sozID;
    }

    public void setSozID(int sozID) {
        this.sozID = sozID;
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

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getSozler() {
        return sozler;
    }

    public void setSozler(String sozler) {
        this.sozler = sozler;
    }
    
    
    
    
}
