/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author karao
 */
public class Kategori {
    private int kategoriID;
    private String kategoriAdi;

    public Kategori() {
    }

    public Kategori(int kategoriID, String kategoriAdi) {
        this.kategoriID = kategoriID;
        this.kategoriAdi = kategoriAdi;
    }

    public int getKategoriID() {
        return kategoriID;
    }

    public void setKategoriID(int kategoriID) {
        this.kategoriID = kategoriID;
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }


  
    
   
     
}
