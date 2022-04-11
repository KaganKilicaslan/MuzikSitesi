/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SarkiSozleri;
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
public class SarkiSozleriDao extends DbConnection {
    
    //Listeleme Fonskiyonu
    public List<SarkiSozleri> list(){
        List<SarkiSozleri> list = new ArrayList<>();
       
        
        //Bağlantı kontrolu
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from sarkisozleri order by sozid";
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new SarkiSozleri(
                    result.getInt(1),
                    result.getInt(2),
                    result.getInt(3),
                    result.getInt(4),
                    result.getString(5)
            ));
         }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    //Silme Fonksiyonu
    public String delete(SarkiSozleri soz){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from sarkisozleri where sozid = "+soz.getSozid();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    //..Oluşturma Fonksiyonu 
    public String create(SarkiSozleri soz){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into sarkisozleri (sozler) values ('"+soz.getSozler()+"')";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Güncelleme Fonksiyonu 
    public String update(SarkiSozleri soz){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update sarkisozleri set sozler = '"+soz.getSozler()+"' where sozid = '"+soz.getSozid()+"'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }

    
}
