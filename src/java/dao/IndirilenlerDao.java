/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package dao;


import entity.Indirilenler;
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

public class IndirilenlerDao extends DbConnection {

    //Listeleme Fonk.
    public List<Indirilenler> list(){
        List<Indirilenler> list = new ArrayList<>();        
        //Baglantı kontrol
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from Indirilenler order by indirid";
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Indirilenler(
                    result.getInt(1),
                    result.getInt(2),
                    result.getInt(3),
                    result.getInt(4)
                    
            ));
         }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
   
      //Silme Fonksiyonu
    public String delete(Indirilenler indirilenler){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from sanatci where indirid = "+indirilenler.getIndirid();
            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Oluşturma Fonksiyonu 
    public String create(Indirilenler indirilenler){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into sanatci (ad) values ('"+indirilenler.getSanatciid()+"') ";
            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Güncelleme Fonksiyonu 
    /*public String update(Indirilenler indirilenler){
        
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
    */
}
