/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author karao
 */
public class Kullanici {

    private int kullaniciID;
    private String kullaniciAdi;
    private String kullaniciSoyad;
    private String nickName;
    private String sifre;

    public Kullanici() {
    }

    public Kullanici(int kullaniciID, String nickName, String sifre) {
        this.kullaniciID = kullaniciID;
        this.nickName = nickName;
        this.sifre = sifre;
    }

    public Kullanici(String nickName, String sifre) {
        this.nickName = nickName;
        this.sifre = sifre;
    }

    public Kullanici(String kullaniciAdi, String kullaniciSoyad, String nickName, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSoyad = kullaniciSoyad;
        this.nickName = nickName;
        this.sifre = sifre;
    }

    public Kullanici(int kullaniciID, String kullaniciAdi, String kullaniciSoyad, String nickName, String sifre) {
        this.kullaniciID = kullaniciID;
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSoyad = kullaniciSoyad;
        this.nickName = nickName;
        this.sifre = sifre;
    }

    public int getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(int kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciSoyad() {
        return kullaniciSoyad;
    }

    public void setKullaniciSoyad(String kullaniciSoyad) {
        this.kullaniciSoyad = kullaniciSoyad;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

   

}
