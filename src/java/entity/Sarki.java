/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author ikbal
 */
public class Sarki {

    private int sarkiID;
    private int sanatciid;
    private int albumId;
    private String sarkiAdi;

    public Sarki() {

    }

    public Sarki(int sarkiID, String sarkiAdi) {
        this.sarkiID = sarkiID;
        this.sarkiAdi = sarkiAdi;
    }

    public int getSarkiID() {
        return sarkiID;
    }

    public void setSarkiID(int sarkiID) {
        this.sarkiID = sarkiID;
    }

    public Sarki(int sarkiID, int sanatciid, int albumId, String sarkiAdi) {
        this.sarkiID = sarkiID;
        this.sanatciid = sanatciid;
        this.albumId = albumId;
        this.sarkiAdi = sarkiAdi;
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

    public String getSarkiAdi() {
        return sarkiAdi;
    }

    public void setSarkiAdi(String sarkiAdi) {
        this.sarkiAdi = sarkiAdi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.sarkiID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sarki other = (Sarki) obj;
        return this.sarkiID == other.sarkiID;
    }

}
