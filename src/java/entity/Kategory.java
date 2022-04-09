/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author karao
 */
public class Kategory {
    private int kategoryID;
    private String kategoryAdi;

    public Kategory() {
    }

    public Kategory(int kategoryID, String kategoryAdi) {
        this.kategoryID = kategoryID;
        this.kategoryAdi = kategoryAdi;
    }

    public Kategory(String kategoryAdi) {
        this.kategoryAdi = kategoryAdi;
    }

    public int getKategoryID() {
        return kategoryID;
    }

    public void setKategoryID(int kategoryID) {
        this.kategoryID = kategoryID;
    }

    public String getKategoryAdi() {
        return kategoryAdi;
    }

    public void setKategoryAdi(String kategoryAdi) {
        this.kategoryAdi = kategoryAdi;
    }

    
   
     
}
