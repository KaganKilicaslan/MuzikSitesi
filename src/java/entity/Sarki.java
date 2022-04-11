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
    private Sanatci sanatci;
    private Album album;
    private String sarkiAdi;

    public Sarki() {

    }

    public Sarki(int sarkiID, String sarkiAdi) {
        this.sarkiID = sarkiID;
        this.sarkiAdi = sarkiAdi;
    }

    public Sarki(int sarkiID, Sanatci sanatci, Album album, String sarkiAdi) {
        this.sarkiID = sarkiID;
        this.sanatci = sanatci;
        this.album = album;
        this.sarkiAdi = sarkiAdi;
    }

    public int getSarkiID() {
        return sarkiID;
    }

    public void setSarkiID(int sarkiID) {
        this.sarkiID = sarkiID;
    }

    public Sanatci getSanatci() {
        return sanatci;
    }

    public void setSanatci(Sanatci sanatci) {
        this.sanatci = sanatci;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
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
