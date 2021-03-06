/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author karao
 */
public class AlbumDao extends DbConnection {

    public List<Album> findById(int id) {
        List<Album> list = new ArrayList<>();

        try {
            Connection c = this.connect();

            Statement st = c.createStatement();
            String query = "SELECT * from album order by albumid";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Album(
                        rs.getInt("albumID"),
                        rs.getString("albumAdi"),
                        rs.getDate("guncellemeTarihi")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public List<Album> findAll(int page, int pageSize) {
        List<Album> list = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            Connection c = this.connect();

            Statement st = c.createStatement();
            String query = "SELECT * from album order by albumid asc limit "+pageSize+" offset "+start;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Album(
                        rs.getInt("albumID"),
                        rs.getString("albumAdi"),
                        rs.getDate("guncellemeTarihi")
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

            String query = "SELECT count(album) as album_count from album";
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery(query);
            count = rs.getInt("album_count");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    //Listeleme Fonskiyonu
    public List<Album> list() {
        List<Album> list = new ArrayList<>();

        //Ba??lant?? kontrolu
        try {
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from album order by albumid";
            ResultSet result = state.executeQuery(sorgu);
            while (result.next()) {
                list.add(new Album(
                        result.getInt(1),
                        result.getString(2),
                        result.getDate(3)
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    //Silme Fonksiyonu
    public String delete(Album album) {

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from album where albumid = " + album.getAlbumID();

            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    //..Olu??turma Fonksiyonu 
    public String create(Album album) {

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into album (albumadi) values ('" + album.getAlbumAdi() + "')";

            st.executeUpdate(sorgu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

    //..G??ncelleme Fonksiyonu 
    public String update(Album album) {

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update album set albumAdi = '" + album.getAlbumAdi() + "' where albumid = '" + album.getAlbumID() + "'";

            st.executeUpdate(sorgu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }

}
