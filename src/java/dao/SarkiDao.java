/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Sarki;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class SarkiDao extends DbConnection {

    public List<Sarki> findById(int id) {
        List<Sarki> list = new ArrayList<>();
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String query = "SELECT * from sarki where sarkiid=" + id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                list.add(new Sarki(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4)
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public List<Sarki> findAll(int page, int pageSize) {
        List<Sarki> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String query = "SELECT * from sarki order by sarkiid asc limit " + pageSize + " offset " + start;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                list.add(new Sarki(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4)
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public int count() {

        int count = 0;
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String query = "SELECT count(sarki) as sarki_count from sarki";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("sarki_count");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return count;
    }

    //Listeleme Fonskiyonu
    public List<Sarki> list() {
        List<Sarki> list = new ArrayList<>();

        //Bağlantı kontrolu
        try {
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from sarki order by sarkiid";
            ResultSet result = state.executeQuery(sorgu);
            while (result.next()) {
                list.add(new Sarki(
                        result.getInt(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getString(4)
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    //Silme Fonksiyonu
    public String delete(Sarki sarki) {

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from sarki where sarkiid = " + sarki.getSarkiID();

            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    //..Oluşturma Fonksiyonu 
    public String create(Sarki sarki) {

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into sarki (sarkiadi) values ('" + sarki.getSarkiAdi() 
                    + "')";
            st.executeUpdate(sorgu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    //..Güncelleme Fonksiyonu 
    public String update(Sarki sarki) {

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update sarki set sarkiadi = '" + sarki.getSarkiAdi() + "' where sarkiid = '" + sarki.getSarkiID() + "'";

            st.executeUpdate(sorgu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

}
