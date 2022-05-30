/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Liste;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author ikbal
 */

public class ListeDao extends DbConnection {
    //Listeleme Fonskiyonu
    public List<Liste> list(){
        List<Liste> list = new ArrayList<>();
       
        
        //Bağlantı kontrolu
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from sarkilistesi order by listeid";
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Liste(
                    result.getInt(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4),
                    result.getInt(5)
            ));
         }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    
     public List<Liste> findAll(int page,int pageSize){
        List<Liste> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        
        //Bağlantı kontrolu
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from kategori  order bylisteid asc limit "+pageSize+","+start;
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Liste(
                    result.getInt(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4),
                    result.getInt(5)
            ));
         }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
     
      public int count(){
        List<Liste> list = new ArrayList<>();
        int count =0;
        
        //Bağlantı kontrolu
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT count (sarkilistesi)as liste_count from sarkilistesi";
            ResultSet  result = state.executeQuery(sorgu);
            result.next();
            count = result.getInt("liste_count");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return count;
    }
    
    
    //Silme Fonksiyonu
    public String delete(Liste liste){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from sarkilistesi where listeid = "+liste.getListeID();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    //..Oluşturma Fonksiyonu 
    public String create(Liste liste){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into sarkilistesi (listeadi) values ('"+liste.getListeAdi()+"')";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Güncelleme Fonksiyonu 
    public String update(Liste liste){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update sarkilistesi set listeadi = '"+liste.getListeAdi()+"' where listeid = '"+liste.getListeID()+"'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
}
