/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author SENANUR PAKSOY
 */
public class IndirilenlerDao extends DbConnection{
    
    //Listeleme Fonskiyonu
        public List<Indirilenler> list(){
        List<Indirilenler> list = new ArrayList<>();        
        //Bağlantı kontrolu
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from indirilenler order by indirid";
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
    public String delete(Indirilenler indirilen){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from indirilenler where indirid = "+indirilen.getIndirid();
            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Oluşturma Fonksiyonu 
    public String create(Indirilenler indirilen){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into indirilenler (indirid) values ('"+indirilen.getIndirid()+"')";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Güncelleme Fonksiyonu 
    public String update(Indirilenler indirilen){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update indirilenler set indirid = '"+indirilen.getIndirid()+"' where albumid = '"+indirilen.getAlbumid()+"'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
}
