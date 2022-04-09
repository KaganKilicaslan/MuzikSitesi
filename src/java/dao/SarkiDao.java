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

/**
 *
 * @author ikbal
 */
public class SarkiDao extends DbConnection{
    //Listeleme Fonskiyonu
    public List<Sarki> list(){
        List<Sarki> list = new ArrayList<>();
       
        
        //Bağlantı kontrolu
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from sarki order by sarkiid";
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Sarki(
                    result.getInt(1),
                    result.getInt(2),
                    result.getInt(3),
                    result.getString(4)
            ));
         }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    //Silme Fonksiyonu
    public String delete(Sarki sarki){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from sarki where sarkiid = "+sarki.getSarkiID();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    //..Oluşturma Fonksiyonu 
    public String create(Sarki sarki){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into sarki (sarkiadi) values ('"+sarki.getSarkiAdi()+"')";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Güncelleme Fonksiyonu 
    public String update(Sarki sarki){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update sarki set sarkiAdi = '"+sarki.getSarkiAdi()+"' where sarkiid = '"+sarki.getSarkiID()+"'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
}
