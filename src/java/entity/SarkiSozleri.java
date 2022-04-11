/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author SENANUR PAKSOY
 */
public class SarkiSozleri {
    private int sozid;
    private int sanatciid;
    private int sarkiid;
    private int albumid;
    private String sozler;

    public SarkiSozleri() {
    }

    public SarkiSozleri(int sozid, int sanatciid, int sarkiid, int albumid, String sozler) {
        this.sozid = sozid;
        this.sanatciid = sanatciid;
        this.sarkiid = sarkiid;
        this.albumid = albumid;
        this.sozler = sozler;
    }

    public SarkiSozleri(String sozler) {
        this.sozler = sozler;
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

    public int getSarkiid() {
        return sarkiid;
    }

    public void setSarkiid(int sarkiid) {
        this.sarkiid = sarkiid;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public String getSozler() {
        return sozler;
    }

    public void setSozler(String sozler) {
        this.sozler = sozler;
    }
    
    
    
}
