/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
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
 * @author HP
 */

public class SarkiSozleriDao extends DbConnection {

    
     //Listeleme Fonk.
    public List<SarkiSozleri> list(){
        List<SarkiSozleri> list = new ArrayList<>();        
        //Baglantı kontrol
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from SarkiSozleri order by sozid";
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
    public String delete(SarkiSozleri sarkisozleri){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from sarkiSozleri where sozid = "+sarkisozleri.getSozid();
            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Oluşturma Fonksiyonu 
    public String create(SarkiSozleri sarkisozleri){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into sarkiSozleri (SarkiSozleri) values ('"+sarkisozleri.getSarkisozleri()+"') ";
            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Güncelleme Fonksiyonu 
    public String update(SarkiSozleri sarkisozleri){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update sarkisozleri set Sarkisozleri = '"+sarkisozleri.getSarkisozleri()+"' where sozid = '"+sarkisozleri.getSozid()+ "'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
   
    
}
