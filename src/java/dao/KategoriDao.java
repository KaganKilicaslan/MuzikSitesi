/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;



import entity.Kategori;
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
public class KategoriDao extends DbConnection {
    public List<Kategori> list(){
        List<Kategori> list = new ArrayList<>();

      try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from kategori order by kategoriid";
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Kategori(
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
    public String delete(Kategori kategori){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from kategori where kategoriid = "+kategori.getKategoriID();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    //..Oluşturma Fonksiyonu 
    public String create(Kategori kategori){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into kategori (kategoriadi) values ('"+kategori.getKategoriAdi()+"')";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Güncelleme Fonksiyonu 
    public String update(Kategori kategori){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update kategori set kategoriadi = '"+kategori.getKategoriAdi()+"' where kategoriid = '"+kategori.getKategoriID()+"'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
}