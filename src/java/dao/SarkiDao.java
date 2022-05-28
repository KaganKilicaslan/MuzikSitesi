/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Album;
import entity.Sanatci;
import entity.Sarki;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;


public class SarkiDao extends DbConnection{
    
    private AlbumDao albumDAO;
    private SanatciDao sanatciDao;
    
    public Sarki findById(int id) {
       Sarki s = null;
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            String query = "SELECT * from sarki where sanatciid="+id;

            ResultSet rs = st.executeQuery(query);
             while(rs.next()){
               
             s = new Sarki(rs.getInt("sarkiID"),rs.getString("sarkiAdi"));
             }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return s;
    }
    
    //Listeleme Fonskiyonu
    public List<Sarki> list(){
        List<Sarki> list = new ArrayList<>();
       
        
        //Bağlantı kontrolu
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from sarki";
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
                Album a = (Album) this.getAlbumDAO().findById(result.getInt("albumid"));
                Sanatci s = (Sanatci) this.getSanatciDao().findById(result.getInt("sanatciid"));
            list.add(new Sarki(
                     result.getInt("sarkiID"),
                     result.getInt("sanatciid"),                   
                     result.getInt("albumId"),
                    result.getString("sarkiAdi")
            ));
         }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    //Silme Fonksiyonu
    public void delete(Sarki sarki){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from sarki where sarkiid = "+sarki.getSarkiID();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    
    }
    //..Oluşturma Fonksiyonu 
    public void create(Sarki sarki){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into sarki (sarkiid,sanatciid,albumid,sarkiadi) values ("+ sarki.getSarkiID()+ ",'" +
                    sarki.getSanatciid() + ",'" + sarki.getAlbumId() +
                    "','" + sarki.getSarkiAdi() + "')";
            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    //..Güncelleme Fonksiyonu 
    public void update(Sarki sarki){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update sarki set albumid = '"+sarki.getAlbumId()+" sarkiadi'" +sarki.getSarkiAdi()+"' where sarkiid = '"+sarki.getSarkiID()+"'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
       
    }

    public AlbumDao getAlbumDAO() {
       if (albumDAO == null) {
            this.albumDAO = new AlbumDao();
        }
        return albumDAO;
    }

    public void setAlbumDAO(AlbumDao albumDAO) {
        this.albumDAO = albumDAO;
    }

    public SanatciDao getSanatciDao() {
       if (sanatciDao == null) {
            this.sanatciDao = new SanatciDao();
        }
        return sanatciDao;
    }

    public void setSanatciDao(SanatciDao sanatciDao) {
        this.sanatciDao = sanatciDao;
    }
    
    
    
}
