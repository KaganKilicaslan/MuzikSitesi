/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Sanatci;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author SENANUR PAKSOY
 */
public class SanatciDao extends DbConnection{
    
     public List<Sanatci> findById(int id) {
        List<Sanatci> list = new ArrayList<>();
        try {
            Connection c = this.connect();

            Statement st = c.createStatement();
            String query = "SELECT * from sanatci where sanatciid="+id;

            ResultSet rs = st.executeQuery(query);
             while(rs.next()){
             list.add(new Sanatci(
                     rs.getInt("sanatciid"),
                     rs.getString("ad"),
                     rs.getInt("albumId")
             ));
         }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    //Listeleme Fonskiyonu
    public List<Sanatci> list(){
        List<Sanatci> list = new ArrayList<>();        
        //Bağlantı kontrolu
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from sanatci order by sanatciid";
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Sanatci(
                    result.getInt(1),
                    result.getString(2),
                    result.getInt(3)
                    
                    
            ));
         }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    //Silme Fonksiyonu
    public String delete(Sanatci sanatci){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from sanatci where sanatciid = "+sanatci.getSanatciid();
            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    //..Oluşturma Fonksiyonu 
    public String create(Sanatci sanatci){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into sanatci (ad) values ('"+sanatci.getAd()+"') ";
            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Güncelleme Fonksiyonu 
    public String update(Sanatci sanatci){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update sanatci set ad = '"+sanatci.getAd()+"' where sanatciid = '"+sanatci.getSanatciid()+ "'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
}
