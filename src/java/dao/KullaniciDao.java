/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanici;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author karao
 */
public class KullaniciDao extends DbConnection {

    //Listeleme Fonskiyonu
    public List<Kullanici> list() {
        List<Kullanici> list = new ArrayList<>();

        //Bağlantı kontrolu
        try {
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from kullanici order by kullaniciid";
            ResultSet result = state.executeQuery(sorgu);
            while (result.next()) {
                list.add(new Kullanici(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5)
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    //Silme Fonksiyonu
    public String delete(Kullanici kullanici) {

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from kullanici where kullaniciid = " + kullanici.getKullaniciID();

            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    //..Oluşturma Fonksiyonu 
    public String create(Kullanici kullanici) {

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into kullanici (ad,soyad,kullaniciadi,sifre) values ('"+ kullanici.getKullaniciAdi()+
                    "', '"+kullanici.getKullaniciSoyad()+ "', '" + kullanici.getNickName() + "','"+kullanici.getSifre()+"' )";
            st.executeUpdate(sorgu);
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    //..Güncelleme Fonksiyonu 
    public String update(Kullanici kullanici) {

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            /*String sorgu = "update kullanici set kullaniciadi = '" + kullanici.getNickName() + 
                    "' where kullaniciId = '" + kullanici.getKullaniciID() + "'";*/
            String sorgu = "update kullanici set ad='"+kullanici.getKullaniciAdi()+
                    "', soyad='"+kullanici.getKullaniciSoyad()+"', kullaniciadi='"+ kullanici.getNickName()+"',sifre='"+kullanici.getSifre()+
                    "' where kullaniciId = '" + kullanici.getKullaniciID()+ "'";
            st.executeUpdate(sorgu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }
}
