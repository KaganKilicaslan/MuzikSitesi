/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.Album;
import entity.Kategory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author karao
 */
public class KategoryDao extends DbConnection {
    public List<Kategory> list(){
        List<Kategory> list = new ArrayList<>();

      try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from kategori order by kategoriid";
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Kategory(
                    result.getInt(1),
                    result.getString(2)
                    
            ));
         }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    
     //Silme Fonksiyonu
    public String delete(Kategory kategory){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from kategori where kategoriid = "+kategory.getKategoryID();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    //..Oluşturma Fonksiyonu 
    public String create(Kategory kategory){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into kategori (kategoriadi) values ('"+kategory.getKategoryAdi()+"')";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Güncelleme Fonksiyonu 
    public String update(Kategory kategory){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update kategori set kategoriadi = '"+kategory.getKategoryAdi()+"' where kategoriid = '"+kategory.getKategoryID()+"'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
}